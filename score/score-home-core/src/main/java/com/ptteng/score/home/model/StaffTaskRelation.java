package com.ptteng.score.home.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "staff_task_relation")
public class StaffTaskRelation implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 6004101918858311680L;


    private Long id;


    private Long staffId;


    private Long taskId;


    private Integer attendanceType;


    private Integer taskType;


    private Long createAt;


    private Long updateAt;


    private Long createBy;


    private Long updateBy;

    private Integer approveStatus;

    @Column(name = "approve_status")
    public Integer getApproveStatus() {
        return approveStatus;
    }

    public void setApproveStatus(Integer approveStatus) {
        this.approveStatus = approveStatus;
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

    @Column(name = "task_id")
    public Long getTaskId() {
        return taskId;
    }


    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    @Column(name = "attendance_type")
    public Integer getAttendanceType() {
        return attendanceType;
    }


    public void setAttendanceType(Integer attendanceType) {
        this.attendanceType = attendanceType;
    }

    @Column(name = "task_type")
    public Integer getTaskType() {
        return taskType;
    }


    public void setTaskType(Integer taskType) {
        this.taskType = taskType;
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

