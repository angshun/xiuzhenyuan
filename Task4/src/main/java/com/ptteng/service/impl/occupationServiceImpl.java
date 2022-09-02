package com.ptteng.service.impl;

import com.ptteng.dao.occupationDao;
import com.ptteng.model.occupation;
import com.ptteng.service.occupationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by shun on 2017/6/23.
 */
@Service
public class occupationServiceImpl implements occupationService {
    @Autowired
    private occupationDao dao;
    public List<occupation> getList() {

        return dao.getList();
    }

    public occupation getName(String v_name) {
        return dao.getName(v_name);
    }
}
