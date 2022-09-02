package com.ptteng.dao;

import com.ptteng.model.occupation;

import java.util.List;

/**
 * Created by shun on 2017/6/23.
 */
public interface occupationDao {
    public List<occupation>getList();

    public occupation getName(String v_name);

}
