package com.ptteng.model;

/**
 * Created by shun on 2017/6/13.
 */
public class Student {
    private long id;
    private String name;
    private String avatar;
    private String type;
    private String introduction;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", avatar='" + avatar + '\'' +
                ", type='" + type + '\'' +
                ", introduction='" + introduction + '\'' +
                '}';
    }

    public Student() {
    }

    public Student(long id, String name, String avatar, String type, String introduction) {

        this.id = id;
        this.name = name;
        this.avatar = avatar;
        this.type = type;
        this.introduction = introduction;
    }
}
