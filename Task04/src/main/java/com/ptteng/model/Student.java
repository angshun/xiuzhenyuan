package com.ptteng.model;


import org.springframework.stereotype.Component;

/**
 * Created by yangshun on 2017/5/31.
 */
@Component//是Spring给中立类注解，
public class Student {
    private String sign;//宣言
    private String stu_introducer;//学生介绍
    private Long create_at;//创建时间
    private Long update_at;//更新时间
    private String stu_school;//毕业学校


    private int id;
    private String stu_name;//姓名
    private String position;//职位
    private String work_Experience;//工作经历
    private String imges;//头像


    private String url_head;//t头像
    private int	 course_type;//修真类型
    private String company;//公司
    private String person_introduce;//任务介绍
    private int good_status;//判断是否是优秀学员


    public String getImges() {
        return imges;
    }

    public void setImges(String imges) {
        this.imges = imges;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getWork_Experience() {
        return work_Experience;
    }

    public void setWork_Experience(String work_Experience) {
        this.work_Experience = work_Experience;
    }

    public String getUrl_head() {
        return url_head;
    }

    public void setUrl_head(String url_head) {
        this.url_head = url_head;
    }

    public int getCourse_type() {
        return course_type;
    }

    public void setCourse_type(int course_type) {
        this.course_type = course_type;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPerson_introduce() {
        return person_introduce;
    }

    public void setPerson_introduce(String person_introduce) {
        this.person_introduce = person_introduce;
    }

    public int getGood_status() {
        return good_status;
    }

    public void setGood_status(int good_status) {
        this.good_status = good_status;
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
