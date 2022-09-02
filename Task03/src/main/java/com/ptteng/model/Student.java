package com.ptteng.model;


import org.springframework.stereotype.Component;

/**
 * Created by yangshun on 2017/5/31.
 */
@Component//是Spring给中立类注解，
public class Student {
    private int id;
    private String stu_name;
    private String sign;
    private String stu_introducer;
    private Long create_at;
    private Long update_at;
    private String stu_school;

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

    public Long getCreate_at() {
        return create_at;
    }

    public void setCreate_at(Long create_at) {
        this.create_at = create_at;
    }

    public Long getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(Long update_at) {
        this.update_at = update_at;
    }

    public String getStu_school() {
        return stu_school;
    }

    public void setStu_school(String stu_school) {
        this.stu_school = stu_school;
    }

    @Override//👇方法从父类/接口继承过来的，需要重写
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", stu_name='" + stu_name + '\'' +
                ", sign='" + sign + '\'' +
                ", stu_introducer='" + stu_introducer + '\'' +
                ", create_at=" + create_at +
                ", update_at=" + update_at +
                ", stu_school='" + stu_school + '\'' +
                '}';
    }

    public Student(int id, String stu_name, String sign, String stu_introducer, Long create_at, Long update_at, String stu_school) {
        this.id = id;
        this.stu_name = stu_name;
        this.sign = sign;
        this.stu_introducer = stu_introducer;
        this.create_at = create_at;
        this.update_at = update_at;

        this.stu_school = stu_school;
    }

    public Student() {
    }
}
