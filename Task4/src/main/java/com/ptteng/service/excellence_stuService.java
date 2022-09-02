package com.ptteng.service;

import com.ptteng.model.excellence_stu;

import java.util.List;

/**
 * Created by shun on 2017/6/22.
 */
public interface excellence_stuService {
    public List<excellence_stu> getAll();

    public excellence_stu getTime(int id);


}
