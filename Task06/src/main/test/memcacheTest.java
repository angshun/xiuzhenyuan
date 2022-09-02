import com.ptteng.login.dao.excellence_stuDao;
import com.ptteng.login.model.excellence_stu;
import com.ptteng.login.util.MemcachedUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by shun on 2017/6/30.
 */
@RunWith(SpringJUnit4ClassRunner.class)  //使用junit4进行测试
@ContextConfiguration({"classpath:spring/spring-mvc.xml"}) //加载配置文件
public class memcacheTest {

    @Autowired
    private excellence_stuDao dao;

    @Test
    public void  getAll() {
        List<excellence_stu> list;
//        if (MemcachedUtils.get("list") != null) {
//            list = (List<excellence_stu>) MemcachedUtils.get("list");
//            System.out.println("本次操作是从缓存中查询数据！"+list);
//        }

        list = dao.getAll();

        System.out.println(list);

        boolean flag = MemcachedUtils.add("list42", list);


        System.out.print(flag);


        //System.out.println("本次操作是从数据库中查询数据！,并向缓存中添加数据，添加结果为："+flag+list);
    }





}
