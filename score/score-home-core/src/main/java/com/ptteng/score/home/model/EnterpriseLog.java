package com.ptteng.score.home.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Table(name = "enterprise_log")
public class EnterpriseLog implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 808179429194230784L;


    private Long id;


    private Long staffId;


    private String logContent;


    private Integer approveNum;


    private Integer commentNum;


    private String picture;


    private Long createAt;


    private Long updateAt;


    private Long createBy;


    private Long updateBy;

    private String comment;

    private String praise;

    @Column(name = "praise")
    public String getPraise() {
        return praise;
    }

    public void setPraise(String praise) {
        this.praise = praise;
    }

    @Column(name = "comment")
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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

    @Column(name = "staff_id")
    public Long getStaffId() {
        return staffId;
    }


    public void setStaffId(Long staffId) {
        this.staffId = staffId;
    }

    @Column(name = "log_content")
    public String getLogContent() {
        return logContent;
    }


    public void setLogContent(String logContent) {
        this.logContent = logContent;
    }

    @Column(name = "approve_num")
    public Integer getApproveNum() {
        return approveNum;
    }


    public void setApproveNum(Integer approveNum) {
        this.approveNum = approveNum;
    }

    @Column(name = "comment_num")
    public Integer getCommentNum() {
        return commentNum;
    }


    public void setCommentNum(Integer commentNum) {
        this.commentNum = commentNum;
    }

    @Column(name = "picture")
    public String getPicture() {
        return picture;
    }


    public void setPicture(String picture) {
        this.picture = picture;
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

}

