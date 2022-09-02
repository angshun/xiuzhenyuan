package com.ptteng.score.home.controller;


import com.ptteng.score.home.constant.ConstantItem;
import com.ptteng.score.home.model.ApplyManage;
import com.ptteng.score.home.service.ApplyManageService;
import com.ptteng.score.home.util.DynamicSQLUtil;
import com.qding.common.util.DataUtils;
import com.qding.common.util.http.cookie.CookieUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * ApplyManage  crud
 * 
 * @author magenm
 * @Date 2014-4-16 13:43
 * 
 */
@Controller
public class ApplyManageController {
	private static final Log log = LogFactory.getLog(ApplyManageController.class);

	@Autowired
	private ApplyManageService applyManageService;


	/**
	 * 工作台模块展示
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/a/u/applyManage", method = RequestMethod.GET)
	public String getMultiApplyManageJson(HttpServletRequest request,
										  HttpServletResponse response, ModelMap model)
			throws Exception {

		log.info("get /a/u/applyManage ");

		List<Long> applyManageIdList = null;

		List<ApplyManage> applyManageList = null;

		Map<String, Object> param = null;

		param = DynamicSQLUtil.getApplyManageList();

		try {


			applyManageIdList = applyManageService.getIdsByDynamicCondition(ApplyManage.class, param,  ConstantItem.ZERO, Integer.MAX_VALUE);
			log.info("get applyManagerIdList is: " + applyManageIdList);
			applyManageList = applyManageService.getObjectsByIds(applyManageIdList);
			log.info("get  applyManage data is " + applyManageList.size());

			if (applyManageList.size() == 0) {
				log.error("get applyManageList is null！");
				model.addAttribute("code", -1000);
				return "common/fail";
			}
			log.info("get applyManageList.size is: " + applyManageList.size());


			model.addAttribute("code", 0);
			model.addAttribute("applyManageList", applyManageList);

		} catch (Throwable t) {
			log.error(t.getMessage());
			log.error("get applyManage error,id is  ");
			model.addAttribute("code", -100000);
		}

		return "/json/applyManage/json/applyManageListJson";
	}


	
	
	
	
	
}

