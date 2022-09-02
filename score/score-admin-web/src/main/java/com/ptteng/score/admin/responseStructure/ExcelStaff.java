package com.ptteng.score.admin.responseStructure;

import java.io.Serializable;

/**
 * Title:    score
 * Description:
 * Company:  www.jnshu.com
 *
 * @author hfismyangel@163.com
 * @version 1.0
 * @Ddate 2017/9/28
 */
public class ExcelStaff implements Serializable{


    private static final long serialVersionUID = -7053848438693877146L;
    private Long id;


    private String name;


    private String img;


    private String phone;


    private String pwd;


    private Long departmentId;


    private String departmentName;


    private Long positionId;

    private String positionName;
    private Integer iniScore;


    private Integer degreeScore;


    private Integer honorScore;


    private Integer jopScore;


    private Integer specialityScore;

    private Integer positionScore;

    private Integer commendScore;


    private Integer baseScore;


    private Integer addScore;


    private Integer subScore;


    private Integer scoreSituation;


    private Integer totalScore;


    private Integer seniority;


    private Integer seniorityScore;
    private Integer star;


    private Integer starScore;
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


    private Long starId;
    private Long degreeId;
    private Long honorId;
    private Long specialityId;
    private Long jopId;



    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Long getPositionId() {
        return positionId;
    }

    public void setPositionId(Long positionId) {
        this.positionId = positionId;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public Integer getIniScore() {
        return iniScore;
    }

    public void setIniScore(Integer iniScore) {
        this.iniScore = iniScore;
    }

    public Integer getDegreeScore() {
        return degreeScore;
    }

    public void setDegreeScore(Integer degreeScore) {
        this.degreeScore = degreeScore;
    }

    public Integer getHonorScore() {
        return honorScore;
    }

    public void setHonorScore(Integer honorScore) {
        this.honorScore = honorScore;
    }

    public Integer getJopScore() {
        return jopScore;
    }

    public void setJopScore(Integer jopScore) {
        this.jopScore = jopScore;
    }

    public Integer getSpecialityScore() {
        return specialityScore;
    }

    public void setSpecialityScore(Integer specialityScore) {
        this.specialityScore = specialityScore;
    }

    public Integer getPositionScore() {
        return positionScore;
    }

    public void setPositionScore(Integer positionScore) {
        this.positionScore = positionScore;
    }

    public Integer getCommendScore() {
        return commendScore;
    }

    public void setCommendScore(Integer commendScore) {
        this.commendScore = commendScore;
    }

    public Integer getBaseScore() {
        return baseScore;
    }

    public void setBaseScore(Integer baseScore) {
        this.baseScore = baseScore;
    }

    public Integer getAddScore() {
        return addScore;
    }

    public void setAddScore(Integer addScore) {
        this.addScore = addScore;
    }

    public Integer getSubScore() {
        return subScore;
    }

    public void setSubScore(Integer subScore) {
        this.subScore = subScore;
    }

    public Integer getScoreSituation() {
        return scoreSituation;
    }

    public void setScoreSituation(Integer scoreSituation) {
        this.scoreSituation = scoreSituation;
    }

    public Integer getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Integer totalScore) {
        this.totalScore = totalScore;
    }

    public Integer getSeniority() {
        return seniority;
    }

    public void setSeniority(Integer seniority) {
        this.seniority = seniority;
    }

    public Integer getSeniorityScore() {
        return seniorityScore;
    }

    public void setSeniorityScore(Integer seniorityScore) {
        this.seniorityScore = seniorityScore;
    }

    public Integer getStar() {
        return star;
    }

    public void setStar(Integer star) {
        this.star = star;
    }

    public Integer getStarScore() {
        return starScore;
    }

    public void setStarScore(Integer starScore) {
        this.starScore = starScore;
    }

    public Integer getIncumbency() {
        return incumbency;
    }

    public void setIncumbency(Integer incumbency) {
        this.incumbency = incumbency;
    }

    public Integer getSunScore() {
        return sunScore;
    }

    public void setSunScore(Integer sunScore) {
        this.sunScore = sunScore;
    }

    public Integer getLoveScore() {
        return loveScore;
    }

    public void setLoveScore(Integer loveScore) {
        this.loveScore = loveScore;
    }

    public Integer getApprovalLogNum() {
        return approvalLogNum;
    }

    public void setApprovalLogNum(Integer approvalLogNum) {
        this.approvalLogNum = approvalLogNum;
    }

    public Integer getWaitApprovalNum() {
        return waitApprovalNum;
    }

    public void setWaitApprovalNum(Integer waitApprovalNum) {
        this.waitApprovalNum = waitApprovalNum;
    }

    public Integer getMyApprovalNum() {
        return myApprovalNum;
    }

    public void setMyApprovalNum(Integer myApprovalNum) {
        this.myApprovalNum = myApprovalNum;
    }

    public Integer getMyCopyNum() {
        return myCopyNum;
    }

    public void setMyCopyNum(Integer myCopyNum) {
        this.myCopyNum = myCopyNum;
    }

    public Integer getRanking() {
        return ranking;
    }

    public void setRanking(Integer ranking) {
        this.ranking = ranking;
    }

    public Integer getJoinRank() {
        return joinRank;
    }

    public void setJoinRank(Integer joinRank) {
        this.joinRank = joinRank;
    }

    public Long getEntryAt() {
        return entryAt;
    }

    public void setEntryAt(Long entryAt) {
        this.entryAt = entryAt;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public Long getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Long createAt) {
        this.createAt = createAt;
    }

    public Long getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Long updateAt) {
        this.updateAt = updateAt;
    }

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public Long getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
    }

    public Long getStarId() {
        return starId;
    }

    public void setStarId(Long starId) {
        this.starId = starId;
    }

    public Long getDegreeId() {
        return degreeId;
    }

    public void setDegreeId(Long degreeId) {
        this.degreeId = degreeId;
    }

    public Long getHonorId() {
        return honorId;
    }

    public void setHonorId(Long honorId) {
        this.honorId = honorId;
    }

    public Long getSpecialityId() {
        return specialityId;
    }

    public void setSpecialityId(Long specialityId) {
        this.specialityId = specialityId;
    }

    public Long getJopId() {
        return jopId;
    }

    public void setJopId(Long jopId) {
        this.jopId = jopId;
    }

    public ExcelStaff(Long id, String name, String img, String phone, String pwd, Long departmentId, String departmentName, Long positionId, String positionName, Integer iniScore, Integer degreeScore, Integer honorScore, Integer jopScore, Integer specialityScore, Integer positionScore, Integer commendScore, Integer baseScore, Integer addScore, Integer subScore, Integer scoreSituation, Integer totalScore, Integer seniority, Integer seniorityScore, Integer star, Integer starScore, Integer incumbency, Integer sunScore, Integer loveScore, Integer approvalLogNum, Integer waitApprovalNum, Integer myApprovalNum, Integer myCopyNum, Integer ranking, Integer joinRank, Long entryAt, Integer role, Long createAt, Long updateAt, Long createBy, Long updateBy, Long starId, Long degreeId, Long honorId, Long specialityId, Long jopId) {
        this.id = id;
        this.name = name;
        this.img = img;
        this.phone = phone;
        this.pwd = pwd;
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.positionId = positionId;
        this.positionName = positionName;
        this.iniScore = iniScore;
        this.degreeScore = degreeScore;
        this.honorScore = honorScore;
        this.jopScore = jopScore;
        this.specialityScore = specialityScore;
        this.positionScore = positionScore;
        this.commendScore = commendScore;
        this.baseScore = baseScore;
        this.addScore = addScore;
        this.subScore = subScore;
        this.scoreSituation = scoreSituation;
        this.totalScore = totalScore;
        this.seniority = seniority;
        this.seniorityScore = seniorityScore;
        this.star = star;
        this.starScore = starScore;
        this.incumbency = incumbency;
        this.sunScore = sunScore;
        this.loveScore = loveScore;
        this.approvalLogNum = approvalLogNum;
        this.waitApprovalNum = waitApprovalNum;
        this.myApprovalNum = myApprovalNum;
        this.myCopyNum = myCopyNum;
        this.ranking = ranking;
        this.joinRank = joinRank;
        this.entryAt = entryAt;
        this.role = role;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.createBy = createBy;
        this.updateBy = updateBy;
        this.starId = starId;
        this.degreeId = degreeId;
        this.honorId = honorId;
        this.specialityId = specialityId;
        this.jopId = jopId;
    }
}
