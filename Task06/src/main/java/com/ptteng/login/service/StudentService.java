package com.ptteng.login.service;

import com.ptteng.login.model.Student;

import java.util.List;

/**
 * Created by shun on 2017/7/1.
 */
public interface StudentService {
    public int add(Student stu);

    public int delete(int id);

    public int update(Student stu);

    public Student findStuById(int id);

    public List<Student> getAll();

    public Student findStuByName(String stu_name);
}
