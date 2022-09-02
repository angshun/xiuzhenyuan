package mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import pojo.User;

import java.util.List;

/**
 * Created by yangshun on 2017/5/30.
 */
public interface UserMapper {
    public void insertUser(User user);

    public void updateUser(User user);

    public User selectUserById(int id);

    public void deleteUser(int id);



    public List<User> selectUser();
}
