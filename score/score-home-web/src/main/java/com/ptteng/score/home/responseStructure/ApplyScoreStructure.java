package com.ptteng.score.home.responseStructure;

/**
 * Title:    score
 * Description:
 * Company:  www.jnshu.com
 *
 * @author hfismyangel@163.com
 * @version 1.0
 * @Ddate 2017/10/25
 */
public class ApplyScoreStructure {
    private Long scoreId;
    private Long taskId;

    private String title;
    private Integer scoreType;
    private Long[] staffId;
    private Long applyId;
    private Long approvalId;
    private String content;
    private String picture;
    private Integer score;
    private Long[] copyId;
    private Integer project;
    public Long getScoreId() {
        return scoreId;
    }

    public void setScoreId(Long scoreId) {
        this.scoreId = scoreId;
    }

    public Integer getProject() {
        return project;
    }

    public void setProject(Integer project) {
        this.project = project;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public Integer getScoreType() {
        return scoreType;
    }

    public void setScoreType(Integer scoreType) {
        this.scoreType = scoreType;
    }

    public Long[] getStaffId() {
        return staffId;
    }

    public void setStaffId(Long[] staffId) {
        this.staffId = staffId;
    }

    public Long getApplyId() {
        return applyId;
    }

    public void setApplyId(Long applyId) {
        this.applyId = applyId;
    }

    public Long getApprovalId() {
        return approvalId;
    }

    public void setApprovalId(Long approvalId) {
        this.approvalId = approvalId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Long[] getCopyId() {
        return copyId;
    }

    public void setCopyId(Long[] copyId) {
        this.copyId = copyId;
    }
}
