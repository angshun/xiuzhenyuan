package com.ptteng.login.controller;

import com.ptteng.login.model.User;
import com.ptteng.login.model.excellence_stu;
import com.ptteng.login.service.UserService;
import com.ptteng.login.service.excellence_stuService;
import com.ptteng.login.util.DESUtil;
import com.ptteng.login.util.MD5Util;
import org.apache.commons.net.util.Base64;
import org.apache.log4j.Logger;
import org.apache.velocity.tools.view.CookieTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import sun.rmi.runtime.Log;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

/**
 * Created by shun on 2017/6/26.
 */
@Controller
@RequestMapping
public class HomeController {

    Logger log = Logger.getLogger(HomeController.class);
    @Autowired
    private excellence_stuService service;
    @Autowired
    private UserService userService;
//    主
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String getAll(Model model, HttpServletRequest request) {
        List<excellence_stu> list = service.getAll();
//        String contextPath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
//        log.error(contextPath);
//        model.addAttribute("contextPath", contextPath);
        model.addAttribute("list", list);
        return "home";
    }
    //职业
    @RequestMapping(value = "/u/occupation", method = RequestMethod.GET)
    public String getAll(HttpServletRequest request, Model model) {
//        String contextPath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getServletPath();
//        System.out.println("路径：" + contextPath);
//        model.addAttribute("contextPath", contextPath);
        return "occupation";
    }
    //注册
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@RequestParam("user") String user, @RequestParam("passwd") String password) {
        String md5 = MD5Util.stringToMD5(password);
        userService.insert(user, md5);
        return "views/ok";
    }
    //登录
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "views/login";
    }
    //登录失败
    @RequestMapping(value = "/no", method = RequestMethod.GET)
    public String no() {
        return "views/no";
    }

    //登录处理
    @RequestMapping(value = "/login/validate", method = RequestMethod.POST)
    public void validate(@RequestParam("username") String username, @RequestParam("password") String password, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        String md5 = MD5Util.stringToMD5(password);
        if (userService.verification(username, md5)) {
            User user = userService.selectByUserName(username);
            Long id = user.getId();
            Long loginTime = System.currentTimeMillis();
            String token = id + "=" + loginTime;
            byte[] bytes = DESUtil.desCrypto(token, "99999999");
            String src = Base64.encodeBase64String(bytes);
            Cookie cookie = new Cookie("token", URLEncoder.encode(src, "UTF-8"));
            cookie.setMaxAge(60 * 60 * 24 * 7);
            cookie.setPath("/");
            response.addCookie(cookie);
            HttpSession session = request.getSession();
            session.setAttribute("user", user);

            try {
                response.sendRedirect("/Task06/home");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            try {
                response.sendRedirect("/Task06/no");
            } catch (IOException e) {

                e.printStackTrace();
            }
        }
    }

    //退出
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Cookie[] cookies = request.getCookies();
        for (Cookie c : cookies) {
            if (c.getName().equals("token")) {
                Cookie cookieKiller = new Cookie(c.getName(), "");
                cookieKiller.setMaxAge(0);
                response.addCookie(cookieKiller);
                break;
            }
        }
        HttpSession session = request.getSession();
        session.setAttribute("user", null);
        response.sendRedirect("/Task06/home");
    }
}

