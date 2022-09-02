package com.ptteng.controller;

import com.ptteng.model.Student;
import com.ptteng.service.StudentService;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class StudentController {
    int i = 0;
    int j = 0;
    int k = 0;
    int l = 0;

    private ApplicationContext ac = null;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String getAll(HttpServletRequest request, HttpServletResponse response) {

        ac = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
        int flag = Math.random() > 0.5 ? 1 : 0;//使用random产生随机数0或1，如果是0则访问service1，如果是1则访问service2
        System.out.println("产生的随机数是：" + flag);
        List<Student> list = null;
        try {
            switch (flag) {
                case 1:
                    StudentService studentService1 = (StudentService) ac.getBean("studentService");
                    i++;
                    System.out.println("第"+i+"次访问第一层service1");
                    list = studentService1.getAll();
                    break;
                default:
                    j++;
                    StudentService studentService2 = (StudentService) ac.getBean("studentService2");
                    System.out.println("第"+j+"次访问第一层访问service2");
                    list = studentService2.getAll();
                    break;
            }

        } catch (Exception e) {
            switch (flag) {
                case 1:
                    k++;
                    StudentService studentService2 = (StudentService) ac.getBean("studentService2");
                    System.out.println("第"+k+"次访问第一层访问失败，转为第二层访问service2");
                    list = studentService2.getAll();

                    break;
                default:
                    l++;
                    StudentService studentService1 = (StudentService) ac.getBean("studentService");
                    System.out.println("第"+l+"次访问第一层失败，转为第二层访问service1");
                    list = studentService1.getAll();
                    break;
            }
        }

        request.setAttribute("list", list);
        return "list";
    }
}
