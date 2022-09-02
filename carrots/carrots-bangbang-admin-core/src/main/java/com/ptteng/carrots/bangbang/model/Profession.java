package com.ptteng.carrots.bangbang.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "profession")
public class Profession implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 683684912528086016L;


    private Long id;


    private String name;


    private Long cId;


    private Long releaseAt;


    private Integer salary;


    private Integer education;


    private Integer workExperience;


    private Integer status;


    private String responsibility;


    private String requirement;


    private String welfare;


    private Long createAt;


    private Long updateAt;


    private Long createBy;


    private Long updateBy;


    private Integer province;


    private Integer city;


    private Integer county;


    private Integer type;

    private Integer subType;

    private Integer grade;

    private Integer recommend;

    public Integer getGrade() {
        return grade;
    }

    @Column(name = "grade")
    public void setGrade(Integer grade) {

        this.grade = grade;
    }

    public Integer getSubType() {
        return subType;
    }

    @Column(name = "subType")
    public void setSubType(Integer subType) {

        this.subType = subType;
    }

    public Integer getType() {
        return type;
    }

    @Column(name = "type")

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getProvince() {
        return province;
    }

    @Column(name = "province")

    public void setProvince(Integer province) {
        this.province = province;
    }

    public Integer getCity() {
        return city;
    }

    @Column(name = "city")

    public void setCity(Integer city) {
        this.city = city;
    }

    public Integer getCounty() {
        return county;
    }

    @Column(name = "county")

    public void setCounty(Integer county) {
        this.county = county;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "c_id")
    public Long getcId() {
        return cId;
    }


    public void setcId(Long cId) {
        this.cId = cId;
    }

    @Column(name = "release_at")
    public Long getReleaseAt() {
        return releaseAt;
    }


    public void setReleaseAt(Long releaseAt) {
        this.releaseAt = releaseAt;
    }

    @Column(name = "salary")
    public Integer getSalary() {
        return salary;
    }


    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    @Column(name = "education")
    public Integer getEducation() {
        return education;
    }


    public void setEducation(Integer education) {
        this.education = education;
    }

    @Column(name = "work_experience")
    public Integer getWorkExperience() {
        return workExperience;
    }


    public void setWorkExperience(Integer workExperience) {
        this.workExperience = workExperience;
    }

    @Column(name = "status")
    public Integer getStatus() {
        return status;
    }


    public void setStatus(Integer status) {
        this.status = status;
    }

    @Column(name = "responsibility")
    public String getResponsibility() {
        return responsibility;
    }


    public void setResponsibility(String responsibility) {
        this.responsibility = responsibility;
    }

    @Column(name = "requirement")
    public String getRequirement() {
        return requirement;
    }


    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    @Column(name = "welfare")
    public String getWelfare() {
        return welfare;
    }


    public void setWelfare(String welfare) {
        this.welfare = welfare;
    }

    @Column(name = "create_at")
    public Long getCreateAt() {
        return createAt;
    }


    public void setCreateAt(Long createAt) {
        this.createAt = createAt;
    }

    @Column(name = "update_at")
    public Long getUpdateAt() {
        return updateAt;
    }


    public void setUpdateAt(Long updateAt) {
        this.updateAt = updateAt;
    }

    @Column(name = "create_by")
    public Long getCreateBy() {
        return createBy;
    }


    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    @Column(name = "update_by")
    public Long getUpdateBy() {
        return updateBy;
    }


    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
    }


    @Column(name = "recommend")
    public Integer getRecommend() {
        return recommend;
    }

    public void setRecommend(Integer recommend) {
        this.recommend = recommend;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this,
                ToStringStyle.MULTI_LINE_STYLE);
    }


}

