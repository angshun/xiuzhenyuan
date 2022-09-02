package com.ptteng.score.admin.responseStructure;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ptteng.score.admin.util.ReadPropertiesUtil;

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
   /**
   *@Author hfismyangel@163.com
   *@Description:部分特殊数据采用的出参结构体
   *@Date: 21:40 2017/10/21
      * @param null
   */

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
        } catch (Exception e) {
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


}
