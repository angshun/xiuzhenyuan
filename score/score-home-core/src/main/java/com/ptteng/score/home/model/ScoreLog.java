package com.ptteng.score.home.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "score_log")
public class ScoreLog implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 8823103704205630464L;


    private Long id;


    private Long staffId;


    private String scoreReason;


    private String scoreChange;


    private Integer scoreType;


    private Long createAt;


    private Long updateAt;


    private Long createBy;


    private Long updateBy;

    private Long specialId;

    @Column(name = "special_id")
    public Long getSpecialId() {
        return specialId;
    }

    public void setSpecialId(Long specialId) {
        this.specialId = specialId;
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

    @Column(name = "score_reason")
    public String getScoreReason() {
        return scoreReason;
    }


    public void setScoreReason(String scoreReason) {
        this.scoreReason = scoreReason;
    }

    @Column(name = "score_change")
    public String getScoreChange() {
        return scoreChange;
    }


    public void setScoreChange(String scoreChange) {
        this.scoreChange = scoreChange;
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

