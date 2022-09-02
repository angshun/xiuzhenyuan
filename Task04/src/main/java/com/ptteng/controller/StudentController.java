package com.ptteng.controller;

import com.ptteng.model.Student;
import com.ptteng.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by yangshun on 2017/5/31.
 */
@Controller//注释为Controller层
@RequestMapping("info")//用来处理请求地址映射的注解，用于类上表示类中所有响应请求的方法都是以该类地址作为父路径。
public class StudentController {
    @Resource//注入，使用@Resource而不用@Autowired是为了降低耦合，默认按名称装配
    private StudentService studentService;


    //获取用户列表，访问方法：http://localhost:8080/info/list       //method：指定请求类型，GET、POST、DELETE等
    @RequestMapping(value = "/list", method = RequestMethod.GET)//value：指定请求地址，可以是URI Template模式
    public String getStudent(ModelMap modelMap) {
        List<Student> list = studentService.getAllStudent();

        modelMap.addAttribute("list", list);//传递数据到前端
        return "user/list";//返回对应视图
    }

    //get请求,访问添加用户页面，访问方法http://localhost:8080/info/list/add
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addStudent() {

        return "user/insert";
    }

    //post请求，处理添加用户请求，并重定向到用户管理页面
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addStudentPost(@ModelAttribute("student") Student student) {/*
    注意此处，post请求传递过来的是一个Student对象，里面包含了该用户的信息
    通过@ModelAttribute()注解可以获取传递过来的'student'，并创建这个对象
    数据库中添加一个用户，该步暂时不会刷新缓存*/
        if (student.getStu_name().length() == 0) {
            return "redirect:/info/list";
        }
        try {
            studentService.addStudent(student);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "redirect:/info/list";
    }

    @RequestMapping(value = "/list/{id}", method = RequestMethod.GET)
    public String showById(@PathVariable("id") int id, Model model) {
        Student student = studentService.findStudentById(id);
        model.addAttribute("update", student);
        System.out.println();
        return "user/update";

    }
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public String updateStudent(@PathVariable("id")int id, Student student) {
        Student oldStudent = studentService.findStudentById(id);
        oldStudent.setStu_name(student.getStu_name());
        oldStudent.setSign(student.getSign());
        oldStudent.setStu_school(student.getStu_school());
        oldStudent.setStu_introducer(student.getStu_introducer());
        studentService.updateStudent(oldStudent);
        return "redirect:/info/list";
    }




    @RequestMapping(value = "/delete/{id}",method = RequestMethod.GET)
        public String deleteStudent(@PathVariable("id") int id){

            try {
                int rs = studentService.deleteStudent(id);
            }catch (Exception e){
                e.printStackTrace();
            }

            return "redirect:/info/list";
        }





    /*  @Responsebody与@RequestBody
    @Responsebody表示该方法的返回结果直接写入HTTP response body中
    一般在异步获取数据时使用，在使用@RequestMapping后，返回值通常解析为跳转路径，
    加上@Responsebody后返回结果不会被解析为跳转路径，而是直接写入HTTP response body中。
    比如异步获取json数据，加上@Responsebody后，会直接返回json数据。*//*

    @ResponseBody
    //下面String是它的键，存储类型为String，object是它的值，object为所有数据类型的父类，
    // 就是说可以存储任何类型的数据，调用时，可以进行转型
    public Map<String, Object> getDate(HttpServletResponse response) {
        SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd");
        String datetime = tempDate.format(new java.util.Date());
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("data", datetime);
        return map;
 */


}





