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
public class ExcelScoreLog {

    private String id;
    private String name;
    private String department;
    private String position;
    private String scoreReason;
    private String scoreChange;
    private String scoreType;
    private String createAt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getScoreReason() {
        return scoreReason;
    }

    public void setScoreReason(String scoreReason) {
        this.scoreReason = scoreReason;
    }

    public String getScoreChange() {
        return scoreChange;
    }

    public void setScoreChange(String scoreChange) {
        this.scoreChange = scoreChange;
    }

    public String getScoreType() {
        return scoreType;
    }

    public void setScoreType(String scoreType) {
        this.scoreType = scoreType;
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }
}
