package com.ptteng.score.admin.responseStructure;

/**
 * Title:    score
 * Description:
 * Company:  www.jnshu.com
 *
 * @author hfismyangel@163.com
 * @version 1.0
 * @Ddate 2017/9/28
 */
public class ExcelRewareLog {
    private String id;
    private String staffName;
    private String adminName;
    private String department;
    private String position;
    private String title;
    private String content;
    private String score;
    private String scoreType;
    private String rewardTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getScoreType() {
        return scoreType;
    }

    public void setScoreType(String scoreType) {
        this.scoreType = scoreType;
    }

    public String getRewardTime() {
        return rewardTime;
    }

    public void setRewardTime(String rewardTime) {
        this.rewardTime = rewardTime;
    }

    @Override
    public String toString() {
        return "ExcelRewareLog{" +
                "id='" + id + '\'' +
                ", staffName='" + staffName + '\'' +
                ", adminName='" + adminName + '\'' +
                ", department='" + department + '\'' +
                ", position='" + position + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", score='" + score + '\'' +
                ", scoreType='" + scoreType + '\'' +
                ", rewardTime='" + rewardTime + '\'' +
                '}';
    }
}
