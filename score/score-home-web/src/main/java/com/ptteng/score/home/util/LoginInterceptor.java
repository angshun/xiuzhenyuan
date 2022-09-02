package com.ptteng.score.home.util;


import com.qding.common.util.DataUtils;
import com.qding.common.util.http.cookie.CookieUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;
import java.util.Enumeration;

/**
 * @author shun
 * @date 2017/6/28
 */


public class LoginInterceptor implements HandlerInterceptor {
    private static final Log log = LogFactory.getLog(LoginInterceptor.class);

    @Autowired
    private CookieUtil cookieUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
//        //把所有的请求参数打出来
//        log.info(" request uri: " + request.getRequestURI());
//        log.info("request token" + request.getHeader("token"));
//        Enumeration<String> names = request.getParameterNames();
//        log.info("=========================================" + request.getParameter("token"));
//        while (names.hasMoreElements()) {
//            String name = names.nextElement();
//            String value = request.getParameter(name);
//            log.info(" Parameter  name : " + name + " value : " + value);
//        }
//
//        String token = request.getParameter("token");
//        if (null == token) {
//            token = request.getHeader("token");
//        }
//        log.info("token : " + token);
//
//
//        Cookie[] cookies = request.getCookies();
//        for (Cookie c : cookies) {
//            System.out.println("拦截器获取cookies和其MaxAge：" + c.getName() + "-->" + c.getMaxAge());
//        }
//
//        CookieUtil cookieUtil = new CookieUtil();
//        String keyIdentity = cookieUtil.getKeyIdentity(request, CookieUtil.USER_ID);
//
//        if (DataUtils.isNullOrEmpty(keyIdentity)) {
//            String contextPath = request.getContextPath();
//            String uri = contextPath + "/login";
//            System.out.println("重定向路径：" + uri);
//            response.sendRedirect(uri);
//        }
//
//
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}