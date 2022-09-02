package com.ptteng.service;

import com.ptteng.pojo.Student;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by shun on 2017/6/19.
 */


public interface ServiceStudent {

    public int addStudent(Student stu);

    public int deleteStudent(int id);

    public int updateStudent(Student stu);

    public List<Student> getAllStudent();

    public Student findStudentById(int id);

    public Student findStudentByName(String stu_name);






}
