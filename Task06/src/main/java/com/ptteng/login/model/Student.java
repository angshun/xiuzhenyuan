package com.ptteng.login.model;

import java.io.Serializable;

/**
 * Created by shun on 2017/7/1.
 */
public class Student implements Serializable {
    private int id;
    private String stu_name;
    private String stu_school;
    private String sign;
    private String stu_introducer;

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", stu_name='" + stu_name + '\'' +
                ", stu_school='" + stu_school + '\'' +
                ", sign='" + sign + '\'' +
                ", stu_introducer='" + stu_introducer + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStu_name() {
        return stu_name;
    }

    public void setStu_name(String stu_name) {
        this.stu_name = stu_name;
    }

    public String getStu_school() {
        return stu_school;
    }

    public void setStu_school(String stu_school) {
        this.stu_school = stu_school;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getStu_introducer() {
        return stu_introducer;
    }

    public void setStu_introducer(String stu_introducer) {
        this.stu_introducer = stu_introducer;
    }

    public Student(int id, String stu_name, String stu_school, String sign, String stu_introducer) {

        this.id = id;
        this.stu_name = stu_name;
        this.stu_school = stu_school;
        this.sign = sign;
        this.stu_introducer = stu_introducer;
    }
}
