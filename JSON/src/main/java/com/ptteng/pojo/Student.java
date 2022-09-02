package com.ptteng.pojo;

/**
 * Created by shun on 2017/6/19.
 */
public class Student {
    private int id;
    private String stu_name;
    private String sign;
    private String stu_school;
    private String stu_introducer;
    private Long create_at;
    private Long update_at;

    public Student() {
    }

    public Student(int id, String stu_name, String sign, String stu_school, String stu_introducer, Long create_at, Long update_at) {

        this.id = id;
        this.stu_name = stu_name;
        this.sign = sign;
        this.stu_school = stu_school;
        this.stu_introducer = stu_introducer;
        this.create_at = create_at;
        this.update_at = update_at;
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

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getStu_school() {
        return stu_school;
    }

    public void setStu_school(String stu_school) {
        this.stu_school = stu_school;
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

    @Override
    public String toString() {
        return "Student{}";
    }
}
