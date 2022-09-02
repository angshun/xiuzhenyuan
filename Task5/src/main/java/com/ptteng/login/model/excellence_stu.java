package com.ptteng.login.model;

/**
 * Created by shun on 2017/6/24.
 */
public class excellence_stu {

    private int id;
    private String name;//姓名
    private String vocation;//职业
    private String avatar;//头像
    private String experience;//工作经历
    private Long create_at;//创建时间

    @Override
    public String toString() {
        return "excellence_stu{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", vocation='" + vocation + '\'' +
                ", avatar='" + avatar + '\'' +
                ", experience='" + experience + '\'' +
                ", create_at=" + create_at +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVocation() {
        return vocation;
    }

    public void setVocation(String vocation) {
        this.vocation = vocation;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public Long getCreate_at() {
        return create_at;
    }

    public void setCreate_at(Long create_at) {
        this.create_at = create_at;
    }

    public excellence_stu() {

    }

    public excellence_stu(int id, String name, String vocation, String avatar, String experience, Long create_at) {

        this.id = id;
        this.name = name;
        this.vocation = vocation;
        this.avatar = avatar;
        this.experience = experience;
        this.create_at = create_at;
    }
}
