package com.ptteng.dao;

import com.ptteng.model.User;
import com.sun.org.glassfish.gmbal.ParameterNames;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

/**
 * Created by shun on 2017/6/13.
 */
public interface UserDao {
    public User select(Long id);

    public User selectByUsername(String username);

    public int insert(@Param("username") String username, @Param("password") String password);


    public User verification(@Param("username") String username, @Param("password") String password);

}

