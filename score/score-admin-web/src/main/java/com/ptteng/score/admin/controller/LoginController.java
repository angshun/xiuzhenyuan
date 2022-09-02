package com.ptteng.score.admin.controller;

import com.ptteng.score.admin.constant.ConstantItem;
import com.ptteng.score.admin.model.Manager;
import com.ptteng.score.admin.model.Role;
import com.ptteng.score.admin.service.ManagerService;
import com.ptteng.score.admin.service.RoleService;
import com.ptteng.score.admin.util.*;
import com.qding.common.util.DataUtils;
import com.qding.common.util.http.cookie.CookieUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class LoginController {

    private static final Log log = LogFactory.getLog(LoginController.class);

    @Autowired
    private ManagerService managerService;


    @Autowired
    private CookieUtil cookieUtil;

    @Autowired
    private RoleService roleService;


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
//    @ControllerAnnotation("071")
    @RequestMapping(value = "/a/login", method = RequestMethod.POST)
    public String login(HttpServletRequest request, HttpServletResponse response, ModelMap model,
                        String name, String pwd) throws Exception {

        log.info("get name is : " + name + " pwd is " + pwd);

        if (DataUtils.isNullOrEmpty(name)) {

            model.addAttribute("code", -5007);
            return "common/fail";
        }
        if (DataUtils.isNullOrEmpty(pwd)) {

            model.addAttribute("code", -5008);
            return "common/fail";
        }

        //通过用户名去数据库查用户id
        Map<String, Object> param = DynamicSQLUtil.getLogin(name);
        List<Long> nameIdList = null;
        Manager manager = null;
        Long id = null;
        Long time = null;
        Role role = null;
        String results = null;
        try {
            nameIdList = managerService.getIdsByDynamicCondition(Manager.class, param, 0, Integer.MAX_VALUE);
            log.info("get nameIdList is :" + nameIdList);

            if (nameIdList.size() == ConstantItem.ZERO) {
                log.error("账号输入错误！");
                model.addAttribute("code", -5003);
                return "common/fail";
            }

            //因为用户名是唯一的，所以实际上ids里面只有一个值
            manager = managerService.getObjectById(nameIdList.get(ConstantItem.ZERO));
            log.info("get manager is :" + manager);
            Map<String, String> maps = new HashMap();
            maps.put(CookieConstant.Cookie_WEB_ManagerName, manager.getName());


            maps.put(CookieUtil.USER_ID, manager.getId() + "");//map用来存储键和值
            cookieUtil.setIdentity(request, response, maps, manager.getId());

            role = roleService.getObjectById(manager.getRoleId());
            log.info("get role is: " + role);


            String encodePass = com.gemantic.common.util.PasswordUtils.encode(pwd);
            log.info("用户输入登录密码：" + encodePass);
            log.info("数据库密码：" + manager.getPwd());

            //判断密码是否正确
            if (encodePass.equals(manager.getPwd())) {
                //获取manager的id,进行加密
                id = manager.getId();
                time = System.currentTimeMillis();
                String str = id + "=" + time;
                log.info("===============>str:" + str);

                //加密操作
                byte[] result = DESUtil.desCrypto(str, "12345678");
                //把加密的字节转换为16进制
                log.info("bytes==========>>" + result);
                results = TypeUtil.bytesToHexString(result);
                Cookie cookie = new Cookie("token", results);
                cookie.setMaxAge(ConstantItem.COKIE_MAX);
                response.addCookie(cookie);
//                response.addHeader("token", results);
//                response.addHeader("userId", String.valueOf(id));
//                HttpSession session = request.getSession();
//                session.setAttribute("userId", id);
//                session.setMaxInactiveInterval();
            } else {
                model.addAttribute("code", "-2004");
                return "common/fail";
            }

        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("系统错误！");
            model.addAttribute("code", -100000);
        }

        model.addAttribute("manager", manager);
        model.addAttribute("role", role);
        model.addAttribute("token", results);
        model.addAttribute("code", 0);
        return "common/login";
    }


    /**
     * 退出系统(ed)
     *
     * @param request
     * @param response
     * @param model
     * @return
     */
//    @ControllerAnnotation("072")
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
        log.info("退出成功！");
        return "/data/json";
    }


}


