package com.ptteng.service;

import com.ptteng.model.occupation;

import java.util.List;

/**
 * Created by shun on 2017/6/23.
 */
public interface occupationService {

    public List<occupation> getList();

    public occupation getName(String v_name);

}
