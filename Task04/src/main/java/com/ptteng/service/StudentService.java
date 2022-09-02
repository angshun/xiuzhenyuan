package com.ptteng.service;

import com.ptteng.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yangshun on 2017/5/31.
 */
/*
* @Service  @Controller @Repository @Component ，
* 这四个其实是一样的功能，没有区别，只是在MVC模式上表示的层不一样，
* service一般标注在service层的bean上，
* controller标注在控制层，
* @Repository标注在view层，
* component通用
* 使用注解需要在spring配置文件里加上下面这句
* <context:component-scan base-package=""/>
*在xml配置了这个标签后，spring可以自动去扫描base-pack下面或者子包下面的java文件，
*如果扫描到有@Component @Controller@Service等这些注解的类，则把这些类注册为bean
* 如果配置了<context:component-scan>那么<context:annotation-config/>标签
* 就可以不用再xml中配置了，因为前者包含了后者。
* <context:anntotation-config>只能用于激活那些已经在spring容器里注册过的bean
*
* */
@Service
public interface StudentService {
    public int addStudent(Student stu);

    public int deleteStudent(int id);

    public int updateStudent(Student stu);

    public Student findStudentById(int id);

    public List<Student> getAllStudent();

}
