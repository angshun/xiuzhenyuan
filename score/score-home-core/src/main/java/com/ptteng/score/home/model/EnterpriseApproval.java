package com.ptteng.score.home.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "enterprise_approval")
public class EnterpriseApproval implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 4376220539599310848L;


    private Long id;


    private String title;


    private Long applyId;


    private Integer scoreType;


    private Integer score;


    private Integer status;


    private String content;


    private String picture;


    private Long approvalId;


    private Long createAt;


    private Long updateAt;


    private Long createBy;


    private Long updateBy;

    private Long taskId;

    private Long scoreId;

    @Column(name = "score_id")
    public Long getScoreId() {
        return scoreId;
    }

    public void setScoreId(Long scoreId) {
        this.scoreId = scoreId;
    }

    @Column(name = "task_id")
    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
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

    @Column(name = "title")
    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "apply_id")
    public Long getApplyId() {
        return applyId;
    }


    public void setApplyId(Long applyId) {
        this.applyId = applyId;
    }

    @Column(name = "score_type")
    public Integer getScoreType() {
        return scoreType;
    }


    public void setScoreType(Integer scoreType) {
        this.scoreType = scoreType;
    }

    @Column(name = "score")
    public Integer getScore() {
        return score;
    }


    public void setScore(Integer score) {
        this.score = score;
    }

    @Column(name = "status")
    public Integer getStatus() {
        return status;
    }


    public void setStatus(Integer status) {
        this.status = status;
    }

    @Column(name = "content")
    public String getContent() {
        return content;
    }


    public void setContent(String content) {
        this.content = content;
    }

    @Column(name = "picture")
    public String getPicture() {
        return picture;
    }


    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Column(name = "approval_id")
    public Long getApprovalId() {
        return approvalId;
    }


    public void setApprovalId(Long approvalId) {
        this.approvalId = approvalId;
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

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this,
                ToStringStyle.MULTI_LINE_STYLE);
    }

}

