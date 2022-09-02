package com.ptteng.login.service.impl;

import com.ptteng.login.dao.excellence_stuDao;
import com.ptteng.login.model.excellence_stu;
import com.ptteng.login.service.excellence_stuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by shun on 2017/6/24.
 */
@Service
public class excellence_stuServiceImpl implements excellence_stuService {
    @Autowired
    private excellence_stuDao excellence_stuDao;


    public List<excellence_stu> getAll() {
        return excellence_stuDao.getAll();
    }

    public excellence_stu getTime(int id) {
        return excellence_stuDao.getTime(id);
    }
}
