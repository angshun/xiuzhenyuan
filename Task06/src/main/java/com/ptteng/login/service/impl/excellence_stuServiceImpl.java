package com.ptteng.login.service.impl;

import com.ptteng.login.dao.excellence_stuDao;
import com.ptteng.login.model.excellence_stu;
import com.ptteng.login.service.excellence_stuService;
import com.ptteng.login.util.MemcachedUtils;
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
        List<excellence_stu>list;
        if (MemcachedUtils.get("list") != null) {
            list = (List<excellence_stu>) MemcachedUtils.get("list");
            System.out.println("本次操作是从缓存中查询数据！");
            return list;
        }
        list = excellence_stuDao.getAll();
        boolean flag = MemcachedUtils.add("list", list);
        System.out.println("本次操作是从数据库中查询数据,并向缓存中添加数据，添加结果为："+flag);
        return list;
    }
}
