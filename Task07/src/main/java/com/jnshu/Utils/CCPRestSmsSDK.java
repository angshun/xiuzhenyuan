/*
 *  Copyright (c) 2014 The CCP project authors. All Rights Reserved.
 *
 *  Use of this source code is governed by a Beijing Speedtong Information Technology Co.,Ltd license
 *  that can be found in the LICENSE file in the root of the web site.
 *
 *   http://www.yuntongxun.com
 *
 *  An additional intellectual property rights grant can be found
 *  in the file PATENTS.  All contributing project authors may
 *  be found in the AUTHORS file in the root of the source tree.
 */
package com.jnshu.Utils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import ytx.org.apache.http.HttpEntity;
import ytx.org.apache.http.HttpResponse;
import ytx.org.apache.http.client.methods.HttpGet;
import ytx.org.apache.http.client.methods.HttpPost;
import ytx.org.apache.http.client.methods.HttpRequestBase;
import ytx.org.apache.http.entity.BasicHttpEntity;
import ytx.org.apache.http.impl.client.DefaultHttpClient;
import ytx.org.apache.http.message.AbstractHttpMessage;
import ytx.org.apache.http.util.EntityUtils;

import com.cloopen.rest.sdk.utils.CcopHttpClient;
import com.cloopen.rest.sdk.utils.DateUtil;
import com.cloopen.rest.sdk.utils.EncryptUtil;
import com.cloopen.rest.sdk.utils.LoggerUtil;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class CCPRestSmsSDK {

	 

	private static final int Request_Get = 0;


	private static final int Request_Post = 1;
	private static final String TemplateSMS = "SMS/TemplateSMS";
	private String SERVER_IP;
	private String SERVER_PORT;
	private String ACCOUNT_SID;
	private String ACCOUNT_TOKEN;
	public String App_ID;
	private BodyType BODY_TYPE = BodyType.Type_JSON;

	public enum BodyType {
		Type_XML, Type_JSON;
	}


	/**
	 * ??????????????????????????????
	 * 
	 * @param serverIP
	 *            ???????????? ???????????????
	 * @param serverPort
	 *            ???????????? ???????????????
	 */
	public void init(String serverIP, String serverPort) {
		if (isEmpty(serverIP) || isEmpty(serverPort)) {
			LoggerUtil.fatal("???????????????:serverIP???serverPort??????");
			throw new IllegalArgumentException("????????????:" + (isEmpty(serverIP) ? " ??????????????? " : "") + (isEmpty(serverPort) ? " ??????????????? " : "") + "??????");
		}
		SERVER_IP = serverIP;
		SERVER_PORT = serverPort;
	}

	/**
	 * ????????????????????????
	 * 
	 * @param accountSid
	 *            ???????????? ???????????????
	 * @param accountToken
	 *            ???????????? ???????????????
	 */
	public void setAccount(String accountSid, String accountToken) {
		if (isEmpty(accountSid) || isEmpty(accountToken)) {
			LoggerUtil.fatal("???????????????:accountSid???accountToken??????");
			throw new IllegalArgumentException("????????????:" + (isEmpty(accountSid) ? " ???????????????" : "") + (isEmpty(accountToken) ? " ??????????????? " : "") + "??????");
		}
		ACCOUNT_SID = accountSid;
		ACCOUNT_TOKEN = accountToken;
	}


	/**
	 * ???????????????Id
	 * 
	 * @param appId
	 *            ???????????? ??????Id
	 */
	public void setAppId(String appId) {
		if (isEmpty(appId)) {
			LoggerUtil.fatal("???????????????:appId??????");
			throw new IllegalArgumentException("????????????: ??????Id ??????");
		}
		App_ID = appId;
	}

	/**
	 * ????????????????????????
	 * 
	 * @param to
	 *            ???????????? ??????????????????????????????????????????????????????????????????????????????????????????????????????100???
	 * @param templateId
	 *            ???????????? ??????Id
	 * @param datas
	 *            ???????????? ????????????????????????????????????{??????}
	 * @return
	 */
	public HashMap<String, Object> sendTemplateSMS(String to, String templateId, String[] datas) {
		HashMap<String, Object> validate = accountValidate();
		if(validate!=null) 
			return validate;
		if ((isEmpty(to)) || (isEmpty(App_ID)) || (isEmpty(templateId)))
			throw new IllegalArgumentException("????????????:" + (isEmpty(to) ? " ???????????? " : "") + (isEmpty(templateId) ? " ??????Id " : "") + "??????");
		CcopHttpClient chc = new CcopHttpClient();
		DefaultHttpClient httpclient = null;
		try {
			httpclient = chc.registerSSL(SERVER_IP, "TLS", Integer.parseInt(SERVER_PORT), "https");
		} catch (Exception e1) {
			e1.printStackTrace();
			throw new RuntimeException("?????????httpclient??????" + e1.getMessage());
		}
		String result = "";
		try {
			HttpPost httppost = (HttpPost) getHttpRequestBase(1, TemplateSMS);
			String requsetbody = "";
			if (BODY_TYPE == BodyType.Type_JSON) {
				JsonObject json = new JsonObject();
				json.addProperty("appId", App_ID);
				json.addProperty("to", to);
				json.addProperty("templateId", templateId);
				if (datas != null) {
					StringBuilder sb = new StringBuilder("[");
					for (String s : datas) {
						sb.append("\"" + s + "\"" + ",");
					}
					sb.replace(sb.length() - 1, sb.length(), "]");
					JsonParser parser = new JsonParser();
					JsonArray Jarray = parser.parse(sb.toString()).getAsJsonArray();
					json.add("datas", Jarray);
				}
				requsetbody = json.toString();
			} else {
				StringBuilder sb = new StringBuilder("<?xml version='1.0' encoding='utf-8'?><TemplateSMS>");
				sb.append("<appId>").append(App_ID).append("</appId>").append("<to>").append(to).append("</to>").append("<templateId>").append(templateId)
						.append("</templateId>");
				if (datas != null) {
					sb.append("<datas>");
					for (String s : datas) {
						sb.append("<data>").append(s).append("</data>");
					}
					sb.append("</datas>");
				}
				sb.append("</TemplateSMS>").toString();
				requsetbody = sb.toString();
			}

			LoggerUtil.info("sendTemplateSMS Request body =  " + requsetbody);
			BasicHttpEntity requestBody = new BasicHttpEntity();
			requestBody.setContent(new ByteArrayInputStream(requsetbody.getBytes("UTF-8")));
			requestBody.setContentLength(requsetbody.getBytes("UTF-8").length);
			httppost.setEntity(requestBody);
			HttpResponse response = httpclient.execute(httppost);

			HttpEntity entity = response.getEntity();
			if (entity != null)
				result = EntityUtils.toString(entity, "UTF-8");

			EntityUtils.consume(entity);
		} catch (IOException e) {
			e.printStackTrace();
			LoggerUtil.error(e.getMessage());
			return getMyError("172001", "????????????");
		} catch (Exception e) {
			e.printStackTrace();
			LoggerUtil.error(e.getMessage());
			return getMyError("172002", "?????????");
		}  finally {
			if (httpclient != null)
				httpclient.getConnectionManager().shutdown();
		}

		LoggerUtil.info("sendTemplateSMS response body = " + result);
		
		try {
			if (BODY_TYPE == BodyType.Type_JSON) {
				return jsonToMap(result);
			} else {
				return xmlToMap(result);
			}
		} catch (Exception e) {
			   
			return getMyError("172003", "??????????????????");
		}
	}

	private HashMap<String, Object> jsonToMap(String result) {
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		JsonParser parser = new JsonParser();
		JsonObject asJsonObject = parser.parse(result).getAsJsonObject();
		Set<Entry<String, JsonElement>> entrySet = asJsonObject.entrySet();
		HashMap<String, Object> hashMap2 = new HashMap<String, Object>();

		for (Entry<String, JsonElement> m : entrySet) {
			if ("statusCode".equals(m.getKey()) || "statusMsg".equals(m.getKey()))
				hashMap.put(m.getKey(), m.getValue().getAsString());
			else {
				if ("SubAccount".equals(m.getKey()) || "totalCount".equals(m.getKey())
						||"token".equals(m.getKey())||"downUrl".equals(m.getKey())) {
					if (!"SubAccount".equals(m.getKey()))
						hashMap2.put(m.getKey(), m.getValue().getAsString());
					else {
						try {
							if((m.getValue().toString().trim().length()<=2)&&!m.getValue().toString().contains("[")){
								hashMap2.put(m.getKey(), m.getValue().getAsString());
								hashMap.put("data", hashMap2);
								break;
							}
							if(m.getValue().toString().contains("[]")){
								hashMap2.put(m.getKey(), new JsonArray());
								hashMap.put("data", hashMap2);
								continue;
							}
							JsonArray asJsonArray = parser.parse(m.getValue().toString()).getAsJsonArray();
							ArrayList<HashMap<String, Object>> arrayList = new ArrayList<HashMap<String, Object>>();
							for (JsonElement j : asJsonArray) {
								Set<Entry<String, JsonElement>> entrySet2 = j.getAsJsonObject().entrySet();
								HashMap<String, Object> hashMap3 = new HashMap<String, Object>();
								for (Entry<String, JsonElement> m2 : entrySet2) {
									hashMap3.put(m2.getKey(), m2.getValue().getAsString());
								}
								arrayList.add(hashMap3);
							}
							hashMap2.put("SubAccount", arrayList);
						} catch (Exception e) {
							JsonObject asJsonObject2 = parser.parse(m.getValue().toString()).getAsJsonObject();
							Set<Entry<String, JsonElement>> entrySet2 = asJsonObject2.entrySet();
							HashMap<String, Object> hashMap3 = new HashMap<String, Object>();
							for (Entry<String, JsonElement> m2 : entrySet2) {
								hashMap3.put(m2.getKey(), m2.getValue().getAsString());
							}
							hashMap2.put(m.getKey(), hashMap3);
							hashMap.put("data", hashMap2);
						}
						
					}
					hashMap.put("data", hashMap2);
				} else {

					JsonObject asJsonObject2 = parser.parse(m.getValue().toString()).getAsJsonObject();
					Set<Entry<String, JsonElement>> entrySet2 = asJsonObject2.entrySet();
					HashMap<String, Object> hashMap3 = new HashMap<String, Object>();
					for (Entry<String, JsonElement> m2 : entrySet2) {
						hashMap3.put(m2.getKey(), m2.getValue().getAsString());
					}
					if (hashMap3.size() != 0) {
						hashMap2.put(m.getKey(), hashMap3);
					} else {
						hashMap2.put(m.getKey(), m.getValue().getAsString());
					}
					hashMap.put("data", hashMap2);
				}
			}
		}
		return hashMap;
	}

	/**
	 * @description ???xml??????????????????map
	 * @param xml
	 * @return Map
	 */
	private HashMap<String, Object> xmlToMap(String xml) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		Document doc = null;
		try {
			doc = DocumentHelper.parseText(xml); // ??????????????????XML
			Element rootElt = doc.getRootElement(); // ???????????????
			HashMap<String, Object> hashMap2 = new HashMap<String, Object>();
			for (Iterator i = rootElt.elementIterator(); i.hasNext();) {
				Element e = (Element) i.next();
				if ("statusCode".equals(e.getName()) || "statusMsg".equals(e.getName()))
					map.put(e.getName(), e.getText());
				else {
					if ("SubAccount".equals(e.getName()) || "totalCount".equals(e.getName())
							||"token".equals(e.getName())||"downUrl".equals(e.getName())) {
						if (!"SubAccount".equals(e.getName())) {
							hashMap2.put(e.getName(), e.getText());
						} else {
							ArrayList<HashMap<String, Object>> arrayList = new ArrayList<HashMap<String, Object>>();
							HashMap<String, Object> hashMap3 = new HashMap<String, Object>();
							for (Iterator i2 = e.elementIterator(); i2.hasNext();) {
								Element e2 = (Element) i2.next();
								hashMap3.put(e2.getName(), e2.getText());
								arrayList.add(hashMap3);
							}
							hashMap2.put("SubAccount", arrayList);
						}
						map.put("data", hashMap2);
					} else {

						HashMap<String, Object> hashMap3 = new HashMap<String, Object>();
						for (Iterator i2 = e.elementIterator(); i2.hasNext();) {
							Element e2 = (Element) i2.next();
							// hashMap2.put(e2.getName(),e2.getText());
							hashMap3.put(e2.getName(), e2.getText());
						}
						if (hashMap3.size() != 0) {
							hashMap2.put(e.getName(), hashMap3);
						} else {
							hashMap2.put(e.getName(), e.getText());
						}
						map.put("data", hashMap2);
					}
				}
			}
		} catch (DocumentException e) {
			e.printStackTrace();
			LoggerUtil.error(e.getMessage());
		} catch (Exception e) {
			LoggerUtil.error(e.getMessage());
			e.printStackTrace();
		}
		return map;
	}


	private HttpRequestBase getHttpRequestBase(int get, String action) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		String timestamp = DateUtil.dateToStr(new Date(), DateUtil.DATE_TIME_NO_SLASH);
		EncryptUtil eu = new EncryptUtil();
		String sig = "";
		String acountName = "";
		String acountType = "Accounts";
		
		acountName = ACCOUNT_SID;
		sig = ACCOUNT_SID + ACCOUNT_TOKEN + timestamp;
		String signature = eu.md5Digest(sig);

		String url = getBaseUrl().append("/" + acountType + "/").append(acountName).append("/" + action + "?sig=").append(signature).toString();
		LoggerUtil.info(getmethodName(action)+" url = " + url);
		HttpRequestBase mHttpRequestBase = null;
		if (get == Request_Get)
			mHttpRequestBase = new HttpGet(url);
		else if (get == Request_Post)
			mHttpRequestBase = new HttpPost(url);

		setHttpHeader(mHttpRequestBase);
		String src = acountName + ":" + timestamp;
		String auth = eu.base64Encoder(src);
		mHttpRequestBase.setHeader("Authorization", auth);
		return mHttpRequestBase;
	}

	

	private String getmethodName(String action) {
		 if(action.equals(TemplateSMS)){
			 return "sendTemplateSMS";
		 } else {
			 return ""; 
		 }
	}

	private void setHttpHeader(AbstractHttpMessage httpMessage) {
		if (BODY_TYPE == BodyType.Type_JSON) {
			httpMessage.setHeader("Accept", "application/json");
			httpMessage.setHeader("Content-Type", "application/json;charset=utf-8");
		} else {
			httpMessage.setHeader("Accept", "application/xml");
			httpMessage.setHeader("Content-Type", "application/xml;charset=utf-8");
		}
	}

	private StringBuffer getBaseUrl() {
		StringBuffer sb = new StringBuffer("https://");
		sb.append(SERVER_IP).append(":").append(SERVER_PORT);
		sb.append("/2013-12-26");
		return sb;
	}

	private boolean isEmpty(String str) {
		return (("".equals(str)) || (str == null));
	}

	private HashMap<String, Object> getMyError(String code, String msg) {
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("statusCode", code);
		hashMap.put("statusMsg", msg);
		return hashMap;
	}

	private HashMap<String,Object> accountValidate() {
		if ((isEmpty(SERVER_IP))) {
			return getMyError("172004", "IP??????");
		}
		if ((isEmpty(SERVER_PORT))) {
			return getMyError("172005", "????????????");
		}
		if ((isEmpty(ACCOUNT_SID))) {
			return getMyError("172006", "???????????????");
		}
		if ((isEmpty(ACCOUNT_TOKEN))) {
			return getMyError("172007", "?????????????????????");
		}
		if ((isEmpty(App_ID))) {
			return getMyError("172012", "??????ID??????");
		}
		return null;
	}
}