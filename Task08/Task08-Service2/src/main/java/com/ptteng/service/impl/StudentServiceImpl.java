package com.ptteng.service.impl;

import com.ptteng.dao.StudentDao;
import com.ptteng.model.Student;
import com.ptteng.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;
    @Override
    public List<Student> getAll() {
        return studentDao.getAll();
    }
}
