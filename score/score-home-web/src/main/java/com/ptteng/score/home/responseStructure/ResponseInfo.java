package com.ptteng.score.home.responseStructure;

import com.ptteng.score.home.util.ReadPropertiesUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.Properties;

/**
 * Title:    score
 * Description:
 * Company:  www.jnshu.com
 *
 * @author hfismyangel@163.com
 * @version 1.0
 * @Ddate 2017/9/27
 */

public class ResponseInfo {
    private static Gson gson;

    public static Gson getGson() {
        //序列化空值的gson,Gson是线程安全的
        if (gson == null) {
            gson = new GsonBuilder().serializeNulls().create();
        }
        return gson;
    }

    private Integer code;
    private String message;
    private Integer page;
    private Integer size;
    private Integer total;
    private Object data;


    public ResponseInfo() {
        //成功状态
        this.code = 0;
        message = "success";
    }

    public ResponseInfo(Object data) {
        //返回非列表数据（单条数据）
        this.code = 0;
        message = "success";
        this.data = data;
    }

    public ResponseInfo(Integer code) {
        //错误信息
        this.code = code;
        try {
            Properties properties = ReadPropertiesUtil.getErrorCodeProperties();
            this.message = properties.getProperty(code.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ResponseInfo(Integer page, Integer size, Integer total, Object data) {
        //返回列表数据
        code = 0;
        message = "success";
        this.page = page;
        this.size = size;
        this.total = total;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
