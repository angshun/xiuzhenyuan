package com.ptteng.service.impl;

import com.ptteng.dao.excellence_stuDao;
import com.ptteng.model.excellence_stu;
import com.ptteng.service.excellence_stuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by shun on 2017/6/22.
 */
@Service
public class excellence_stuServiceImpl implements excellence_stuService {
    @Autowired
    private excellence_stuDao dao;

    public List<excellence_stu> getAll() {

        return dao.getAll();
    }

    public excellence_stu getTime(int id) {
        return dao.getTime(id);
    }




}
