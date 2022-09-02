package com.ptteng.login.service.impl;

import com.ptteng.login.dao.StudentDao;
import com.ptteng.login.model.Student;
import com.ptteng.login.service.StudentService;
import com.ptteng.login.util.MemcachedUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by shun on 2017/7/1.
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao stuDao;


    public int add(Student stu) {
//        Integer i = stuDao.add(stu);
//        System.out.println("insert通过selectByUsername向缓存中添加key为:" + stu + "的数据");
//        Student student = findStuByName(stu);


        return stuDao.add(stu);

    }

    public int delete(int id) {
        return stuDao.delete(id);
    }

    public int update(Student stu) {

        return stuDao.update(stu);
    }

    public Student findStuById(int id) {
        Student stu = (Student) MemcachedUtils.get("id" + id);
        if (stu != null) {
            System.out.println("本次操作是从缓存中查询数据！");

            return stu;
        }
        stu = stuDao.findStuById(id);
        boolean flag = MemcachedUtils.add("id" + id, stu);
        System.out.println("本次操作是从数据库中查询数据！,并向缓存中添加数据，添加结果为：" + flag);
        return stu;
    }

    public List<Student> getAll() {
        List<Student> list;
        if (MemcachedUtils.get("list") != null) {
            list = (List<Student>) MemcachedUtils.get("list");
            System.out.println("本次操作是从缓存中查询数据！");
            return list;
        }

        list = stuDao.getAll();
        boolean flag = MemcachedUtils.add("list", list);
        System.out.println("本次操作是从数据库中查询数据！,并向缓存中添加数据，添加结果为：" + flag);
        return list;
    }

    public Student findStuByName(String stu_name) {

        Student student1 = (Student) MemcachedUtils.get(stu_name);
        if (student1 != null) {
            System.out.println("selectByUsername从缓存中查询key为：" + stu_name + "的数据！");
            return student1;
        }
        student1 = stuDao.findStuByName(stu_name);
        boolean flog = MemcachedUtils.add(stu_name, student1);
        System.out.println("selectByUsername从数据库中查询数据！并向缓存中添加key为:" + stu_name + "的数据，添加结果：" + flog);
        return student1;
    }
}
