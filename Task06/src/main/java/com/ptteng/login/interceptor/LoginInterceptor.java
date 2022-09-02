package com.ptteng.login.interceptor;


import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by shun on 2017/6/28.
 */

public class LoginInterceptor implements HandlerInterceptor {


    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        Cookie[] cookies = request.getCookies();
        for (Cookie c : cookies) {
            System.out.println("拦截器获取cookies和其MaxAge：" + c.getName() + "-->" + c.getMaxAge());}
        HttpSession session = request.getSession();
        if (session.getAttribute("user") != null) {
            return true;
        }

        String contextPath = request.getContextPath();
        String uri = contextPath + "/login";
        System.out.println("重定向路径：" + uri);
        response.sendRedirect(uri);

        return false;
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
