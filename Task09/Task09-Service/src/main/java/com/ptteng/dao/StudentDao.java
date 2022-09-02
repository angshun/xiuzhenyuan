package com.ptteng.dao;

import com.ptteng.model.Student;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StudentDao {

    @Select("SELECT * FROM stu")
    public List<Student> getAll();
}
