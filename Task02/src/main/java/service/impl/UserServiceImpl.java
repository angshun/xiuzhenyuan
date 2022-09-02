package service.impl;

import mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.User;
import service.UserService;

import java.util.List;

/**
 * Created by yangshun on 2017/5/30.
 */
@Service//标示为一个Service并且装配了userMapper
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    public List<User> selectUser() {

        return userMapper.selectUser();
    }

}
