package com.ptteng.dao;

import com.ptteng.model.Student;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StudentDao {


    public List<Student> getAll();




}
