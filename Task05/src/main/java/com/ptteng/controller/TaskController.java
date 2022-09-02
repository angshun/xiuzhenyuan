package com.ptteng.controller;

import com.ptteng.model.Student;
import com.ptteng.model.User;
import com.ptteng.service.StudentService;
import com.ptteng.service.UserService;
import com.ptteng.utils.DESUtil;
import com.ptteng.utils.MD5Util;
import com.ptteng.utils.TypeUtil;
import com.sun.tools.corba.se.idl.StringGen;
import org.apache.commons.net.util.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Created by shun on 2017/6/13.
 */
@Controller
@RequestMapping
public class TaskController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private UserService userService;


    //主页界面
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(Model model,HttpServletRequest request) {
        List<Student>studentList = studentService.select();
        String contextPath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getServletPath();
        model.addAttribute("contextPath", contextPath);
        model.addAttribute("studentList", studentList);
        return "index";
    }


    //职业界面
    @RequestMapping(value = "/u/occupation", method = RequestMethod.GET)
    public String occuption(Model model, HttpServletRequest request) {

        String contextPath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
        System.out.println("路径:" + contextPath);
        model.addAttribute("contextPath", contextPath);
        return "occupation";
    }

    //登录页面
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {

        return "login";
    }

    //登录失败页面
    @RequestMapping(value = "/login/no", method = RequestMethod.GET)
    public String error() {
        return "no";
    }

    //登录处理
    @RequestMapping(value = "/login/validate", method = RequestMethod.POST)
    //@RequestParam("username")声明接收的参数是登录操作传过来的username和password,这样下面方法所引用的username和password都是指用户登录输入的username和password
    public void Validate(@RequestParam("username") String username, @RequestParam("password") String password,
                         HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        String md5 = MD5Util.stringToMD5(password);
        if (userService.verification(username, md5)) {
            User user = userService.selectByUsername(username);
            Long id = user.getId();
            Long createDate = new Date().getTime();
            String str = id + "=" + createDate;
            //加密
            byte[] result = DESUtil.desCrypto(str, "12345678");

            //把加密的字节数组转换成16进制
            String results = TypeUtil.bytesToHexString(result);
//            String results = Base64.encodeBase64String(result);
//
            Cookie cookie = new Cookie("token", results);
            cookie.setMaxAge(60 * 60 * 24 * 7);//7天
            cookie.setPath("/");
            System.out.println("新生成cookie和其MaxAge：" + cookie.getName() + "-->" + cookie.getMaxAge());
            httpServletResponse.addCookie(cookie);
            HttpSession session = httpServletRequest.getSession();
            session.setAttribute("user", user);
            for (Cookie c : httpServletRequest.getCookies()) {
                System.out.println("cookes添加到response后重新获取cookies和其MaxAge：" + c.getName() + "-->" + c.getMaxAge());
            }
            try {
                httpServletResponse.sendRedirect("/index");
//                httpServletRequest.getRequestDispatcher("/index.html").forward(httpServletRequest, httpServletResponse);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                httpServletResponse.sendRedirect("no");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    //退出
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public void logout(HttpServletRequest request, HttpServletResponse response) {
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
        try {
            response.sendRedirect("/index");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //注册页面
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@RequestParam("user") String user, @RequestParam("passwd") String password) {
        String md5 = MD5Util.stringToMD5(password);
        userService.insert(user, md5);
        return "ok";
    }

    }
