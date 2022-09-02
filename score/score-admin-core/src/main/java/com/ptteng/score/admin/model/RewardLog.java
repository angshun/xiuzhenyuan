package com.ptteng.score.admin.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


@Entity
@Table(name = "reward_log")
public class RewardLog implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 3493286013613694976L;


    private Long id;


    private Long staffId;


    private String adminName;


    private String adminPhoto;


    private String rewardContent;


    private String rewardScore;


    private String rewardRemark;


    private String rewardTitle;


    private Integer scoreType;


    private Long createAt;


    private Long updateAt;


    private Long createBy;


    private Long updateBy;


    private String img;

    private Integer type;


    @Column(name = "type")
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Column(name = "img")
    public String getImg() {
        return img;
    }
    public void setImg(String img) {
        this.img = img;
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

    @Column(name = "admin_Name")
    public String getAdminName() {
        return adminName;
    }


    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    @Column(name = "admin_photo")
    public String getAdminPhoto() {
        return adminPhoto;
    }


    public void setAdminPhoto(String adminPhoto) {
        this.adminPhoto = adminPhoto;
    }

    @Column(name = "reward_content")
    public String getRewardContent() {
        return rewardContent;
    }


    public void setRewardContent(String rewardContent) {
        this.rewardContent = rewardContent;
    }

    @Column(name = "reward_score")
    public String getRewardScore() {
        return rewardScore;
    }


    public void setRewardScore(String rewardScore) {
        this.rewardScore = rewardScore;
    }

    @Column(name = "reward_remark")
    public String getRewardRemark() {
        return rewardRemark;
    }


    public void setRewardRemark(String rewardRemark) {
        this.rewardRemark = rewardRemark;
    }

    @Column(name = "reward_title")
    public String getRewardTitle() {
        return rewardTitle;
    }


    public void setRewardTitle(String rewardTitle) {
        this.rewardTitle = rewardTitle;
    }

    @Column(name = "score_type")
    public Integer getScoreType() {
        return scoreType;
    }


    public void setScoreType(Integer scoreType) {
        this.scoreType = scoreType;
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

