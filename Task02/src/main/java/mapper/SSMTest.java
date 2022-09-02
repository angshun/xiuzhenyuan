package mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pojo.User;

import java.util.List;


/**
 * Created by yangshun on 2017/5/30.
 */
//指定使用的单元测试执行类
    @RunWith(SpringJUnit4ClassRunner.class)
//指定spring配置文件所在的路径
    @ContextConfiguration("classpath:applicationContext.xml")
public class SSMTest {
@Autowired
private UserMapper userMapper;

@Test
public void insertUser() throws Exception {
        User user = new User();
        user.setName("半夜了");
        userMapper.insertUser(user);
        System.out.println(user);
        }

@Test
public void updateUser() throws Exception {
        User user = new User();
        user.setName("更新个");
        userMapper.updateUser(user);
        System.out.println(user);
        }

@Test
public void selectUserById() throws Exception {
        User user = userMapper.selectUserById(4);
        System.out.println(user);
        }

@Test
public void deleteUser() throws Exception {
        userMapper.deleteUser(50);

        }


@Test
public void selectUser() throws Exception {
        List<User> list = userMapper.selectUser();
        for (User u : list) {

        System.out.println(u.toString());
        }

        }


}