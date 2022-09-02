package com.ptteng.service;

import com.ptteng.model.User;

/**
 * Created by shun on 2017/6/13.
 */
public interface UserService {
    public User select(Long id);

    public User selectByUsername(String username);

    public int insert(String username, String password);

    public boolean verification(String username, String password);

}
