package com.ptteng.login.dao;

import com.ptteng.login.model.User;
import org.apache.ibatis.annotations.Param;

/**
 * Created by shun on 2017/6/24.
 */
public interface UserDao {

    public User select(Long id);

    public User selectByUserNmae(String username);

    public int insert(@Param("username") String username, @Param("password") String password);

    public User verification(@Param("username") String username, @Param("password") String password);






}
