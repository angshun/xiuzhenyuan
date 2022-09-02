package com.ptteng;

import com.ptteng.service.StudentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StartServer {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("Spring-mvc.xml");
        StudentService service = (StudentService) ac.getBean("studentService");
        System.out.println("server发布成功！");





    }
}
