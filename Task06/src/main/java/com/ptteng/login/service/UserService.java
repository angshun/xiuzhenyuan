package com.ptteng.login.service;

import com.ptteng.login.model.User;
import com.ptteng.login.model.excellence_stu;

import java.util.List;

/**
 * Created by shun on 2017/6/24.
 */
public interface UserService {

    public User select(Long id);

    public User selectByUserName(String username);

    public int insert(String username, String password);

    public boolean verification(String username, String password);


}
