package com.ptteng.score.home.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "task")
public class Task implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1675488720233667584L;


    private Long id;


    private String name;


    private String title;


    private String content;


    private Integer scoreType;


    private Integer taskType;


    private Integer project;


    private Long startAt;


    private Long endAt;


    private Integer joinNum;


    private Integer number;


    private Integer times;


    private Integer taskScore;


    private String visualDepartment;


    private Integer taskStatus;


    private Long createAt;


    private Long updateAt;


    private Long createBy;


    private Long updateBy;


    private Integer status;

    private Integer approveStatus;

    @Column(name = "approve_status")
    public Integer getApproveStatus() {
        return approveStatus;
    }

    public void setApproveStatus(Integer approveStatus) {
        this.approveStatus = approveStatus;
    }

    @Column(name = "status")
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    @Column(name = "title")
    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "content")
    public String getContent() {
        return content;
    }


    public void setContent(String content) {
        this.content = content;
    }

    @Column(name = "score_type")
    public Integer getScoreType() {
        return scoreType;
    }


    public void setScoreType(Integer scoreType) {
        this.scoreType = scoreType;
    }

    @Column(name = "task_type")
    public Integer getTaskType() {
        return taskType;
    }


    public void setTaskType(Integer taskType) {
        this.taskType = taskType;
    }

    @Column(name = "project")
    public Integer getProject() {
        return project;
    }


    public void setProject(Integer project) {
        this.project = project;
    }

    @Column(name = "start_at")
    public Long getStartAt() {
        return startAt;
    }


    public void setStartAt(Long startAt) {
        this.startAt = startAt;
    }

    @Column(name = "end_at")
    public Long getEndAt() {
        return endAt;
    }


    public void setEndAt(Long endAt) {
        this.endAt = endAt;
    }

    @Column(name = "join_num")
    public Integer getJoinNum() {
        return joinNum;
    }


    public void setJoinNum(Integer joinNum) {
        this.joinNum = joinNum;
    }

    @Column(name = "number")
    public Integer getNumber() {
        return number;
    }


    public void setNumber(Integer number) {
        this.number = number;
    }

    @Column(name = "times")
    public Integer getTimes() {
        return times;
    }


    public void setTimes(Integer times) {
        this.times = times;
    }

    @Column(name = "task_score")
    public Integer getTaskScore() {
        return taskScore;
    }


    public void setTaskScore(Integer taskScore) {
        this.taskScore = taskScore;
    }

    @Column(name = "visual_department")
    public String getVisualDepartment() {
        return visualDepartment;
    }


    public void setVisualDepartment(String visualDepartment) {
        this.visualDepartment = visualDepartment;
    }

    @Column(name = "task_status")
    public Integer getTaskStatus() {
        return taskStatus;
    }


    public void setTaskStatus(Integer taskStatus) {
        this.taskStatus = taskStatus;
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

    public String toString() {
        return ToStringBuilder.reflectionToString(this,
                ToStringStyle.MULTI_LINE_STYLE);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Task task = (Task) o;

        return id.equals(task.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}

