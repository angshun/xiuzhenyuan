package com.ptteng.score.home.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "staff")
public class Staff implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 2883882348033995776L;


    private Long id;


    private String name;


    private String img;


    private String phone;


    private String pwd;


    private Long departmentId;


    private String departmentName;


    private Long positionId;


    private Integer iniScore;


    private Integer degreeScore;


    private Integer honorScore;


    private Integer jopScore;


    private Integer specialityScore;


    private Integer commendScore;


    private Integer baseScore;


    private Integer addScore;


    private Integer subScore;


    private Integer scoreSituation;


    private Integer totalScore;


    private Integer seniority;


    private Integer star;


    private Integer incumbency;


    private Integer sunScore;


    private Integer loveScore;


    private Integer approvalLogNum;


    private Integer waitApprovalNum;


    private Integer myApprovalNum;


    private Integer myCopyNum;


    private Integer ranking;


    private Integer joinRank;


    private Long entryAt;


    private Integer role;


    private Long createAt;


    private Long updateAt;


    private Long createBy;


    private Long updateBy;

    private String positionName;
    private Integer iniCommendScore;
    private Integer iniApproveScore;
    private String scoreTypeRelation;

    @Column(name = "score_type_relation")
    public String getScoreTypeRelation() {
        return scoreTypeRelation;
    }

    public void setScoreTypeRelation(String scoreTypeRelation) {
        this.scoreTypeRelation = scoreTypeRelation;
    }

    @Column(name = "ini_commend_score")
    public Integer getIniCommendScore() {
        return iniCommendScore;
    }

    public void setIniCommendScore(Integer iniCommendScore) {
        this.iniCommendScore = iniCommendScore;
    }

    @Column(name = "ini_approve_score")
    public Integer getIniApproveScore() {
        return iniApproveScore;
    }

    public void setIniApproveScore(Integer iniApproveScore) {
        this.iniApproveScore = iniApproveScore;
    }

    @Column(name = "position_name")
    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
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

    @Column(name = "img")
    public String getImg() {
        return img;
    }


    public void setImg(String img) {
        this.img = img;
    }

    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }


    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Column(name = "pwd")
    public String getPwd() {
        return pwd;
    }


    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Column(name = "department_id")
    public Long getDepartmentId() {
        return departmentId;
    }


    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    @Column(name = "department_name")
    public String getDepartmentName() {
        return departmentName;
    }


    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Column(name = "position_id")
    public Long getPositionId() {
        return positionId;
    }


    public void setPositionId(Long positionId) {
        this.positionId = positionId;
    }

    @Column(name = "ini_score")
    public Integer getIniScore() {
        return iniScore;
    }


    public void setIniScore(Integer iniScore) {
        this.iniScore = iniScore;
    }

    @Column(name = "degree_score")
    public Integer getDegreeScore() {
        return degreeScore;
    }


    public void setDegreeScore(Integer degreeScore) {
        this.degreeScore = degreeScore;
    }

    @Column(name = "honor_score")
    public Integer getHonorScore() {
        return honorScore;
    }


    public void setHonorScore(Integer honorScore) {
        this.honorScore = honorScore;
    }

    @Column(name = "jop_score")
    public Integer getJopScore() {
        return jopScore;
    }


    public void setJopScore(Integer jopScore) {
        this.jopScore = jopScore;
    }

    @Column(name = "speciality_score")
    public Integer getSpecialityScore() {
        return specialityScore;
    }


    public void setSpecialityScore(Integer specialityScore) {
        this.specialityScore = specialityScore;
    }

    @Column(name = "commend_score")
    public Integer getCommendScore() {
        return commendScore;
    }


    public void setCommendScore(Integer commendScore) {
        this.commendScore = commendScore;
    }

    @Column(name = "base_score")
    public Integer getBaseScore() {
        return baseScore;
    }


    public void setBaseScore(Integer baseScore) {
        this.baseScore = baseScore;
    }

    @Column(name = "add_score")
    public Integer getAddScore() {
        return addScore;
    }


    public void setAddScore(Integer addScore) {
        this.addScore = addScore;
    }

    @Column(name = "sub_score")
    public Integer getSubScore() {
        return subScore;
    }


    public void setSubScore(Integer subScore) {
        this.subScore = subScore;
    }

    @Column(name = "score_situation")
    public Integer getScoreSituation() {
        return scoreSituation;
    }


    public void setScoreSituation(Integer scoreSituation) {
        this.scoreSituation = scoreSituation;
    }

    @Column(name = "total_score")
    public Integer getTotalScore() {
        return totalScore;
    }


    public void setTotalScore(Integer totalScore) {
        this.totalScore = totalScore;
    }

    @Column(name = "seniority")
    public Integer getSeniority() {
        return seniority;
    }


    public void setSeniority(Integer seniority) {
        this.seniority = seniority;
    }

    @Column(name = "star")
    public Integer getStar() {
        return star;
    }


    public void setStar(Integer star) {
        this.star = star;
    }

    @Column(name = "incumbency")
    public Integer getIncumbency() {
        return incumbency;
    }


    public void setIncumbency(Integer incumbency) {
        this.incumbency = incumbency;
    }

    @Column(name = "sun_score")
    public Integer getSunScore() {
        return sunScore;
    }


    public void setSunScore(Integer sunScore) {
        this.sunScore = sunScore;
    }

    @Column(name = "love_score")
    public Integer getLoveScore() {
        return loveScore;
    }


    public void setLoveScore(Integer loveScore) {
        this.loveScore = loveScore;
    }

    @Column(name = "approval_log_num")
    public Integer getApprovalLogNum() {
        return approvalLogNum;
    }


    public void setApprovalLogNum(Integer approvalLogNum) {
        this.approvalLogNum = approvalLogNum;
    }

    @Column(name = "wait_approval_num")
    public Integer getWaitApprovalNum() {
        return waitApprovalNum;
    }


    public void setWaitApprovalNum(Integer waitApprovalNum) {
        this.waitApprovalNum = waitApprovalNum;
    }

    @Column(name = "my_approval_num")
    public Integer getMyApprovalNum() {
        return myApprovalNum;
    }


    public void setMyApprovalNum(Integer myApprovalNum) {
        this.myApprovalNum = myApprovalNum;
    }

    @Column(name = "my_copy_num")
    public Integer getMyCopyNum() {
        return myCopyNum;
    }


    public void setMyCopyNum(Integer myCopyNum) {
        this.myCopyNum = myCopyNum;
    }

    @Column(name = "ranking")
    public Integer getRanking() {
        return ranking;
    }


    public void setRanking(Integer ranking) {
        this.ranking = ranking;
    }

    @Column(name = "join_rank")
    public Integer getJoinRank() {
        return joinRank;
    }


    public void setJoinRank(Integer joinRank) {
        this.joinRank = joinRank;
    }

    @Column(name = "entry_at")
    public Long getEntryAt() {
        return entryAt;
    }


    public void setEntryAt(Long entryAt) {
        this.entryAt = entryAt;
    }

    @Column(name = "role")
    public Integer getRole() {
        return role;
    }


    public void setRole(Integer role) {
        this.role = role;
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

