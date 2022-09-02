package com.ptteng.login.dao;

import com.ptteng.login.model.excellence_stu;

import java.util.List;

/**
 * Created by shun on 2017/6/24.
 */
public interface excellence_stuDao {

    public List<excellence_stu> getAll();

    public excellence_stu getTime(int id);

}
