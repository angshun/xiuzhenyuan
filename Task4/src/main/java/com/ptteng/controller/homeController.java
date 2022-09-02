package com.ptteng.controller;

import com.ptteng.model.excellence_stu;
import com.ptteng.service.excellence_stuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * Created by shun on 2017/6/22.
 */
@Controller
@RequestMapping
public class homeController {
    @Autowired
    private excellence_stuService excellence_stuService;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView getAll(Map map) {
        List<excellence_stu> list = excellence_stuService.getAll();
        ModelAndView mav = new ModelAndView("home");
        mav.addObject("list", list);
        return mav;
    }
    @RequestMapping(value = "/occupation", method = RequestMethod.GET)
    public String getAll() {
        return "occupation";
    }








}
