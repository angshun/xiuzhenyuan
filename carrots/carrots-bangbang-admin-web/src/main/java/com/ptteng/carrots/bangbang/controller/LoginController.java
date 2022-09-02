package com.ptteng.carrots.bangbang.controller;

import com.ptteng.carrots.bangbang.model.Manager;
import com.ptteng.carrots.bangbang.service.ManagerService;
import com.qding.common.util.DataUtils;
import com.qding.common.util.http.cookie.CookieUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.lf5.LogLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import util.DESUtil;
import util.DynamicUtil;
import util.MD5Util;
import util.TypeUtil;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class LoginController {

    private static final Log log = LogFactory.getLog(LoginController.class);

    @Autowired
    private ManagerService managerService;


    @Autowired
    private CookieUtil cookieUtil;

    /**
     * 登录接口
     *
     * @param request
     * @param response
     * @param model
     * @param name
     * @param pwd
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/a/login", method = RequestMethod.POST)
    public String login(HttpServletRequest request, HttpServletResponse response, ModelMap model,
                        String name, String pwd) throws Exception {

        if (DataUtils.isNullOrEmpty(name)) {

            model.addAttribute("code", -5007);
            return "common/fail";
        }
        if (DataUtils.isNullOrEmpty(pwd)) {

            model.addAttribute("code", -5008);
            return "common/fail";
        }
        log.info("================>name:" + name + "pwd:" + pwd);

        //通过用户名去数据库查用户id
        Map<String, Object> param = DynamicUtil.getManagerList(name);
        List<Long> ids = null;
        Manager manager = null;
        Long id = null;
        Long time = null;

        try {
            ids = managerService.getIdsByDynamicCondition(Manager.class, param, 0, Integer.MAX_VALUE);
            log.info("=============>ids:" + ids);

            if (ids.size() == 0) {

                log.error("账号输入错误！");
                model.addAttribute("code", -5003);
                return "common/fail";
            }
            //因为用户名是唯一的，所以实际上ids里面只有一个值
            manager = managerService.getObjectById(ids.get(0));
            log.info("=============>manager:" + manager);


            String md5 = MD5Util.stringToMD5(name + pwd);
            log.info("===============>md5:" + md5);
            //判断密码是否正确
            if (name.equals(manager.getName()) && md5.equals(manager.getPwd())) {
                //获取manager的id,进行加密
                id = manager.getId();
                time = System.currentTimeMillis();
//            long createDate = new Date().getTime();
                String str = id + "=" + time;
                log.info("===============>str:" + str);

                //加密操作
                byte[] result = DESUtil.desCrypto(str, "12345678");
                //把加密的字节转换为16进制
                String results = TypeUtil.bytesToHexString(result);
                Cookie cookie = new Cookie("token", results);
                cookie.setMaxAge(60 * 60 * 24 * 7);
                response.addCookie(cookie);
            } else {
//                response.sendRedirect("/a/login");
                model.addAttribute("code", "-2004");
                return "common/fail";
            }

        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("系统错误！");
            model.addAttribute("code", -100000);
        }

        model.addAttribute("code", "0");
        return "common/success";
    }


    /**
     * 退出系统(ed)
     *
     * @param request
     * @param response
     * @param model
     * @return
     */
    @RequestMapping(value = "/a/logout", method = RequestMethod.POST)
    public String logout(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
        log.info(" welcome to manager logout ");

        try {
            cookieUtil.clearCookie(response);

            model.addAttribute("code", 0);
            model.addAttribute("result", "/login/index");

        } catch (Throwable t) {
            log.error(t.getMessage());
            log.error("manager logout error  ");
            model.addAttribute("code", -5005);
            model.addAttribute("result", null);
        }

        return "/data/json";
    }

}


