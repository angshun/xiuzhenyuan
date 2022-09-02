package com.ptteng.score.admin.util;


import com.ptteng.score.admin.model.Manager;
import com.ptteng.score.admin.service.ManagerService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;

/**
 * Created by shun on 2017/6/28.
 */

public class LoginInterceptor implements HandlerInterceptor {

    private static final Log log = LogFactory.getLog(LoginInterceptor.class);

    public static final String USER_ID = "userId";


    @Autowired
    private ManagerService managerService;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        long start = System.currentTimeMillis();
        String token = request.getParameter("token");
        if (null == token) {
            token = request.getHeader("token");
        }
        log.info("token : " + token);
        if (null == token) {
            return false;
        }
        byte[] bytes = TypeUtil.hexStringToByte(token);
        log.info("bytes==========>>" + bytes);
        byte[] decrypt = DESUtil.decrypt(bytes, "12345678");

        log.info("解密后token：" + decrypt);
        String[] split = new String(decrypt).split("=");

        String managerId = split[0];
        log.info("获取managerId：" + managerId);
        Manager manager = managerService.getObjectById(Long.parseLong(managerId));
        log.info("spend time:" + (System.currentTimeMillis() - start));
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}

