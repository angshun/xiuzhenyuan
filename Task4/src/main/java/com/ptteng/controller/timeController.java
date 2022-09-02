package com.ptteng.controller;

import com.ptteng.model.excellence_stu;
import com.ptteng.service.excellence_stuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by shun on 2017/6/24.
 */
@Controller
@RequestMapping
public class timeController {
    @Autowired
    private excellence_stuService service;
    @RequestMapping(value = "/time/{id}",method = RequestMethod.GET)
    public ModelAndView getTime(@PathVariable("id")int id) {
        Long l = System.currentTimeMillis();
        System.out.println(l);
        excellence_stu stu = service.getTime(id);
        ModelAndView mav = new ModelAndView("time");
        mav.addObject("show", stu);
        return mav;


    }




}
