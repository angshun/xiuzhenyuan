package com.ptteng.service.impl;

import com.ptteng.dao.StudentDAO;
import com.ptteng.pojo.Student;
import com.ptteng.service.ServiceStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by shun on 2017/6/19.
 */
@Service("studentService")
public class ServiceStudentImpl implements ServiceStudent {

    @Autowired
    private StudentDAO dao;
    public int addStudent(Student stu) {
        return dao.addStudent(stu);
    }

    public int deleteStudent(int id) {
        return dao.deleteStudent(id);
    }

    public int updateStudent(Student stu) {
        return dao.updateStudent(stu);
    }

    public List<Student> getAllStudent() {
        return dao.getAllStudent();
    }

    public Student findStudentById(int id) {
        return dao.findStudentById(id);
    }

    public Student findStudentByName(String stu_name) {
        return dao.findStudentByName(stu_name);
    }
}
