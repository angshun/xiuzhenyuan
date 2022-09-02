package com.ptteng.controller;


import com.ptteng.mapper.StudentMapper;
import com.ptteng.mapper.VocationMapper;
import com.ptteng.model.Student;
import com.ptteng.model.Vocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;



/**
 * Created by litao on 2017/2/28.
 */

@Controller
public class HomeController {
    @Autowired
    private VocationMapper vocationMapper;
    @Autowired
    private StudentMapper studentMapper;

//    @RequestMapping(value = "/home", method = RequestMethod.GET)
//    public ModelAndView getHomeInfo(ModelMap modelMap){
//        List<Student> list = studentMapper.getAllStudent();
//        ModelAndView mav = new ModelAndView("home");
//        mav.addObject("list", list);
//        return mav;
//    }
@RequestMapping(value = "/home", method = RequestMethod.GET)
public String getHomeInfo(ModelMap modelMap){
    List<Student> list = studentMapper.getAllStudent();
    modelMap.put("list",list);
    return "home";
}


    @RequestMapping(value = "/courseList", method = RequestMethod.GET)
    public String getTextInfo(ModelMap modelMap) {
        List<Vocation> list1 = vocationMapper.getVocationsWithDirection(1);
        List<Vocation> list2 = vocationMapper.getVocationsWithDirection(2);
        List<Vocation> list3 = vocationMapper.getVocationsWithDirection(3);
        List<Vocation> list4 = vocationMapper.getVocationsWithDirection(4);
        List<Vocation> list5 = vocationMapper.getVocationsWithDirection(5);
        List list = new ArrayList();
        list.add(list1);
        list.add(list2);
        list.add(list3);
        list.add(list4);
        list.add(list5);
        modelMap.put("list", list);
        return "courseList";
    }
}
