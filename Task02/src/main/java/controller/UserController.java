package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pojo.User;
import service.UserService;

import java.util.List;

/**
 * Created by yangshun on 2017/5/30.
 */
@Controller//标示为了控制器自动装配了UserService
@RequestMapping("")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("list")
    public ModelAndView list(){
        ModelAndView mav = new ModelAndView();
        List<User> us = userService.selectUser();
        // 放入转发参数
        mav.addObject("us", us);
        // 放入jsp路径
        mav.setViewName("list");
        return mav;

    }





}
