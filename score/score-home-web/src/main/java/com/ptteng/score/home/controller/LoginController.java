package com.ptteng.score.home.controller;


import com.ptteng.score.home.constant.ConstantItem;
import com.ptteng.score.home.model.Staff;
import com.ptteng.score.home.service.StaffService;
import com.ptteng.score.home.util.CookieConstant;
import com.ptteng.score.home.util.DESUtil;
import com.ptteng.score.home.util.DynamicSQLUtil;
import com.ptteng.score.home.util.TypeUtil;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class LoginController {

    private static final Log log = LogFactory.getLog(LoginController.class);

    @Autowired
    private StaffService staffService;


    @Autowired
    private CookieUtil cookieUtil;


    /**
     * 登录接口
     *
     * @param request
     * @param response
     * @param model
     * @param phone
     * @param pwd
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/a/login", method = RequestMethod.POST)
    public String login(HttpServletRequest request, HttpServletResponse response, ModelMap model,
                        String phone, String pwd) throws Exception {

        log.info("get phone is : " + phone + " pwd is " + pwd);

        if (DataUtils.isNullOrEmpty(phone)) {

            model.addAttribute("code", -5007);
            return "common/fail";
        }
        if (DataUtils.isNullOrEmpty(pwd)) {

            model.addAttribute("code", -5008);
            return "common/fail";
        }

        //通过用户名去数据库查用户id
        Map<String, Object> param = DynamicSQLUtil.getLogin(phone);
        List<Long> phoneIdList = null;
        Staff staff = null;
        Long id = null;
        Long time = null;

        try {
            phoneIdList = staffService.getIdsByDynamicCondition(Staff.class, param, ConstantItem.ZERO, Integer.MAX_VALUE);
            log.info("get nameIdList is :" + phoneIdList);

            if (phoneIdList.size() == ConstantItem.ZERO) {
                log.error("手机号输入错误！");
                model.addAttribute("code", -5024);
                return "common/fail";
            }
//

            //因为手机号是唯一的，所以实际上ids里面只有一个值
            staff = staffService.getObjectById(phoneIdList.get(ConstantItem.ZERO));


            if (ConstantItem.ONE != staff.getIncumbency()) {
                log.error("您已离职！");
                model.addAttribute("code", -5025);
                return "common/fail";
            }
            log.info("get staffPhone is :" + staff.getPhone());
            log.info("get staffName is :" + staff.getPhone());
            Map<String, String> maps = new HashMap();
            maps.put(CookieConstant.Cookie_WEB_StaffPhone, staff.getPhone());
            maps.put(CookieConstant.Cookie_WEB_StaffName, staff.getName());
            maps.put(CookieUtil.USER_ID, staff.getId() + "");//map用来存储键和值
            cookieUtil.setIdentity(request, response, maps, staff.getId());

            //判断密码是否正确
            if (pwd.equals(staff.getPwd())) {
                //获取员工的id,进行加密
                id = staff.getId();
                time = System.currentTimeMillis();
                String str = id + "=" + time;
                log.info("================>str:" + str);

                //加密操作
                byte[] result = DESUtil.desCrypto(str, "12345678");
                //把加密的字节转换为16进制
                String results = TypeUtil.bytesToHexString(result);
                Cookie cookie = new Cookie("token", results);
                cookie.setMaxAge(60 * 60 * 24 * 7 * 30);
                response.addCookie(cookie);
            } else {
                model.addAttribute("code", -2004);
                return "common/fail";
            }

        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("系统错误！");
            model.addAttribute("code", -100000);
        }

        model.addAttribute("staff", staff);
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
    @RequestMapping(value = "/a/logout", method = RequestMethod.POST)
    public String logout(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
        log.info(" welcome to staff logout ");



        try {
            cookieUtil.clearCookie(response);

            model.addAttribute("code", 0);
            model.addAttribute("result", "/login/index");

        } catch (Throwable t) {
            log.error(t.getMessage());
            log.error("staff logout error  ");
            model.addAttribute("code", -5005);
            model.addAttribute("result", null);
        }
        log.info("退出成功！");
        return "/data/json";
    }


}


