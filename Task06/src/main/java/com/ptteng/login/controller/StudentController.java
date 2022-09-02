package com.ptteng.login.controller;

import com.ptteng.login.model.Student;
import com.ptteng.login.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by shun on 2017/7/1.
 */
@Controller
@RequestMapping
public class StudentController {
    @Autowired
    private StudentService stuService;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add() {
        return "Student/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@ModelAttribute("stu") Student stu) {

        stuService.add(stu);

        return "redirect:/list";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") int id) {
        int i = stuService.delete(id);
        return "redirect:/list";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String update(@PathVariable("id") int id, Model model) {
        Student stu = stuService.findStuById(id);
        model.addAttribute("update", stu);
        return "Student/update";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public String update(@PathVariable("id") int id, Student stu) {
        Student stu1 = stuService.findStuById(id);
        stu1.setStu_name(stu.getStu_name());
        stu1.setStu_introducer(stu.getStu_introducer());
        stu1.setStu_school(stu.getStu_school());
        stu1.setSign(stu.getSign());
        stuService.update(stu1);
        return "redirect:/list";
    }

    @RequestMapping(value = "/list/{id}", method = RequestMethod.GET)
    public String findStuById(@PathVariable("id") int id, Model model) {
        Student stu = stuService.findStuById(id);
        model.addAttribute("show", stu);
        return "Student/show";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String getAll(Model model) {
        List<Student> list = stuService.getAll();
        model.addAttribute("list", list);
        return "Student/list";
    }
}
