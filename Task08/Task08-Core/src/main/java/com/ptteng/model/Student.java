package com.ptteng.model;

import java.io.Serializable;

public class Student implements Serializable {
    private int id;
    private String name;
    private String avatar;
    private String type;
    private String introduction;

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

    public Student() {

    }

    public Student(int id, String name, String avatar, String type, String introduction) {

        this.id = id;
        this.name = name;
        this.avatar = avatar;
        this.type = type;
        this.introduction = introduction;
    }
}
