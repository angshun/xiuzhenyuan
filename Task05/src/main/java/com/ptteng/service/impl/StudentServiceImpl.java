package com.ptteng.service.impl;

import com.ptteng.dao.StudentDao;
import com.ptteng.model.Student;
import com.ptteng.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by shun on 2017/6/13.
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Resource
    private StudentDao studentDao;

    public List<Student> select() {
        return studentDao.select();
    }


}
