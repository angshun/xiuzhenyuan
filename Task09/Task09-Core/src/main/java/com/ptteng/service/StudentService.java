package com.ptteng.service;

import com.ptteng.model.Student;
import org.oasisopen.sca.annotation.Remotable;

import java.util.List;

@Remotable
public interface StudentService {

    public List<Student> getAll();



}
