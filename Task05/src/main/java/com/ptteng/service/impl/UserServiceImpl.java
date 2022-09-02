package com.ptteng.service.impl;

import com.ptteng.dao.UserDao;
import com.ptteng.model.User;
import com.ptteng.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by shun on 2017/6/13.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    public User select(Long id) {
        return userDao.select(id);
    }

    public User selectByUsername(String username) {
        return userDao.selectByUsername(username);
    }

    public int insert(String username, String password) {
        return userDao.insert(username, password);
    }

    public boolean verification(String username, String password) {
        if (userDao.verification(username, password) == null) {
            return false;
        }
        return true;
    }
}
