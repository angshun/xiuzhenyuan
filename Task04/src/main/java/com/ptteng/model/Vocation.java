package com.ptteng.model;

import org.springframework.stereotype.Component;

/**
 * Created by shun on 2017/6/8.
 */
    @Component
    public class Vocation {

        private long id;
        private String v_name;//职业名字
        private String v_direction;//职业方向
        private String introduce;//职业介绍
        private int step_diff;//入门难度
        private int stu_diff;//学习难度
        private String stu_cycle;//学习周期
        private int com_count;//公司数量
        private String detail_introduce;//详细介绍
        private String tip;//提示
        private String salary_low;//初级工程师薪水
        private String salary_mid;//中级工程师薪水
        private String salary_high;//高级工程师薪水

        public String getV_direction() {
            return v_direction;
        }

        public void setV_direction(String v_direction) {
            this.v_direction = v_direction;
        }

        public String getIntroduce() {
            return introduce;
        }

        public void setIntroduce(String introduce) {
            this.introduce = introduce;
        }

        public int getStep_diff() {
            return step_diff;
        }

        public void setStep_diff(int step_diff) {
            this.step_diff = step_diff;
        }

        public int getStu_diff() {
            return stu_diff;
        }

        public void setStu_diff(int stu_diff) {
            this.stu_diff = stu_diff;
        }

        public String getStu_cycle() {
            return stu_cycle;
        }

        public void setStu_cycle(String stu_cycle) {
            this.stu_cycle = stu_cycle;
        }

        public int getCom_count() {
            return com_count;
        }

        public void setCom_count(int com_count) {
            this.com_count = com_count;
        }

        public String getDetail_introduce() {
            return detail_introduce;
        }

        public void setDetail_introduce(String detail_introduce) {
            this.detail_introduce = detail_introduce;
        }

        public String getTip() {
            return tip;
        }

        public void setTip(String tip) {
            this.tip = tip;
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

        public String getV_name() {
            return v_name;
        }

        public void setV_name(String v_name) {
            this.v_name = v_name;
        }

        public void setId(long id) {
            this.id = id;
        }
        public long getId() {
            return id;
        }
    }


