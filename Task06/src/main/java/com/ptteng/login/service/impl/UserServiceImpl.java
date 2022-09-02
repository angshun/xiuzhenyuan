package com.ptteng.login.service.impl;

import com.ptteng.login.dao.UserDao;
import com.ptteng.login.model.User;
import com.ptteng.login.service.UserService;
import com.ptteng.login.util.MemcachedUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by shun on 2017/6/24.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public User select(Long id) {
        User user = (User) MemcachedUtils.get("id" +id);
        if (user != null) {
            System.out.println("select从缓存中查询key为：id" + id + "的数据！");
            return user;
        }
        user = userDao.select(id);
        boolean flog = MemcachedUtils.add("id" + id, user);
        System.out.println("select从数据库中查询数据！并向缓存中添加key为:id" + id + "的数据，添加结果：" + flog);
        return user;
    }

    public User selectByUserName(String username) {
        User user = (User) MemcachedUtils.get(username);
        if (user != null) {
            System.out.println("selectByUsername从缓存中查询key为：" + username + "的数据！");
            return user;
        }
        user = userDao.selectByUserNmae(username);
        boolean flog = MemcachedUtils.add(username, user);
        System.out.println("selectByUsername从数据库中查询数据！并向缓存中添加key为:" + username + "的数据，添加结果：" + flog);
        return user;
    }

    public int insert(String username, String password) {
        Integer i = userDao.insert(username, password);
        System.out.println("insert通过selectByUsername向缓存中添加key为:" + username + "的数据");
        User user = selectByUserName(username);

        return i;
    }


    public boolean verification(String username, String password) {

        User user = (User) MemcachedUtils.get(username + password);
        if (user != null) {
            System.out.println("verification从缓存中查询key为：" + username + password + "的数据！");
            return true;
        }
        user = userDao.verification(username, password);
        if (user != null) {
            boolean flag = MemcachedUtils.add(username + password, user);
            System.out.println("verification从数据库中查询数据！并向缓存中添加key为：" + username + password +"的数据，添加结果：" + flag);
            return true;
        }
        System.out.println("verification从数据库中没有查到数据！");
        return false;
    }
}
