package com.ptteng.dao;

import com.ptteng.model.Student;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by yangshun on 2017/5/31.
 */
@Component//是Spring给中立类的注解
public interface StudentMapper {
    public List<Student>getAllStudent();

    public int deleteStudentById(int id);

    public int addStudent(Student stu);

    public int updateStudent(Student stu);

    public Student findStudentById(int id);



}
