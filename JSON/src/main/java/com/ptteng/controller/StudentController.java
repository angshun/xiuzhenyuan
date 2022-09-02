package com.ptteng.controller;
import com.ptteng.pojo.Student;
import com.ptteng.service.ServiceStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.sql.Struct;
import java.util.List;

/**
 * Created by shun on 2017/6/19.
 */
@Controller
public class StudentController {
    @Autowired
    ServiceStudent service;
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add() {
        return "Student/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@ModelAttribute("stu") Student student) {
        service.addStudent(student);
        return "redirect:/list";
    }
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") int id) {
        int i = service.deleteStudent(id);
        return "redirect:/list";
    }
    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String update(@PathVariable("id") int id, Model model) {
        Student student = service.findStudentById(id);
        model.addAttribute("update",student);
        return "Student/update";
    }
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public String update(@PathVariable("id") int id,Student stu) {
        Student student = service.findStudentById(id);
        student.setStu_name(stu.getStu_name());
        student.setSign(stu.getSign());
        student.setStu_school(stu.getStu_school());
        student.setStu_introducer(stu.getStu_introducer());
        service.updateStudent(student);
        return "redirect:/list";
    }
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String getAll(Model model) {
        List<Student> list = service.getAllStudent();
        model.addAttribute("list",list);
        return "Student/list";
    }
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String getAll(HttpServletRequest request) {
        List<Student> list = service.getAllStudent();
        request.setAttribute("list", list);
        return "Student/list";
    }
    @RequestMapping(value = "/list/{id}", method = RequestMethod.GET)
    public String findStudentById(@PathVariable("id") int id, Model model) {
        Student student = service.findStudentById(id);
        model.addAttribute("show", student);
        return "Student/show";
    }
    @RequestMapping(value = "/list/stu/{stu_name}", method = RequestMethod.GET)
    public String findStudentByName(@PathVariable("stu_name") String stu_name, Model model) {
        Student student = service.findStudentByName(stu_name);
        model.addAttribute("show1", student);
        return "Student/show1";
    }


















}
