package com.ptteng.model;


/**
 * Created by shun on 2017/6/23.
 */
public class occupation {
    private int id;
    private String avatar;//头像
    private String v_name;//职业名字
    private String v_introduce;//职业介绍
    private String doorsill;//门槛
    private String difficulty_level;//难易级别
    private String growth_cycle;//成长周期
    private int com_count;//公司需求数
    private String salary_low;//初级工程师
    private String salary_mid;//中级工程师
    private String salary_high;//高级工程师
    private int number;//学习人数
    private String condition;//入门条件

    @Override
    public String toString() {
        return "occupation{" +
                "id=" + id +
                ", avatar='" + avatar + '\'' +
                ", v_name='" + v_name + '\'' +
                ", v_introduce='" + v_introduce + '\'' +
                ", doorsill='" + doorsill + '\'' +
                ", difficulty_level='" + difficulty_level + '\'' +
                ", growth_cycle='" + growth_cycle + '\'' +
                ", com_count=" + com_count +
                ", salary_low='" + salary_low + '\'' +
                ", salary_mid='" + salary_mid + '\'' +
                ", salary_high='" + salary_high + '\'' +
                ", number=" + number +
                ", condition='" + condition + '\'' +
                '}';
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getV_name() {
        return v_name;
    }

    public void setV_name(String v_name) {
        this.v_name = v_name;
    }

    public String getV_introduce() {
        return v_introduce;
    }

    public void setV_introduce(String v_introduce) {
        this.v_introduce = v_introduce;
    }

    public String getDoorsill() {
        return doorsill;
    }

    public void setDoorsill(String doorsill) {
        this.doorsill = doorsill;
    }

    public String getDifficulty_level() {
        return difficulty_level;
    }

    public void setDifficulty_level(String difficulty_level) {
        this.difficulty_level = difficulty_level;
    }

    public String getGrowth_cycle() {
        return growth_cycle;
    }

    public void setGrowth_cycle(String growth_cycle) {
        this.growth_cycle = growth_cycle;
    }

    public int getCom_count() {
        return com_count;
    }

    public void setCom_count(int com_count) {
        this.com_count = com_count;
    }

    public String getSalary_low() {
        return salary_low;
    }

    public void setSalary_low(String salary_low) {
        this.salary_low = salary_low;
    }

    public String getSalary_mid() {
        return salary_mid;
    }

    public void setSalary_mid(String salary_mid) {
        this.salary_mid = salary_mid;
    }

    public String getSalary_high() {
        return salary_high;
    }

    public void setSalary_high(String salary_high) {
        this.salary_high = salary_high;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public occupation() {

    }

    public occupation(int id, String avatar, String v_name, String v_introduce, String doorsill, String difficulty_level, String growth_cycle, int com_count, String salary_low, String salary_mid, String salary_high, int number, String condition) {

        this.id = id;
        this.avatar = avatar;
        this.v_name = v_name;
        this.v_introduce = v_introduce;
        this.doorsill = doorsill;
        this.difficulty_level = difficulty_level;
        this.growth_cycle = growth_cycle;
        this.com_count = com_count;
        this.salary_low = salary_low;
        this.salary_mid = salary_mid;
        this.salary_high = salary_high;
        this.number = number;
        this.condition = condition;
    }
}

