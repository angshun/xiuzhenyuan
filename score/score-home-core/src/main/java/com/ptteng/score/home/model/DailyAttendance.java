package com.ptteng.score.home.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "daily_attendance")
public class DailyAttendance implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5435736509595384832L;



	private Long id;


	private Integer attendanceType;


	private Integer normalScore;


	private Integer morningScore;


	private Integer lateScore;


	private Integer overtimeScore;


	private Integer leftEarlyScore;


	private Integer absenceScore;


	private Long workTime;


	private Long closingTime;


	private String companyCoordinate;


	private Long attendanceInstance;


	private Integer outsideWorkTimeScore;


	private Integer outsideClosingTimeScore;


	private Integer logReleaseTime;


	private Integer approveScore;


	private Integer beApproveScore;


	private Integer loveScore;


	private Integer sunScore;


	private Long createAt;


	private Long updateAt;


	private Long createBy;


	private Long updateBy;

	private Long outsideWorkTime;

	private Long outsideClosingTime;

//	private Integer logNormalScore;
//
//
//	@Column(name = "log_normal_score")
//	public Integer getLogNormalScore() {
//		return logNormalScore;
//	}
//
//	public void setLogNormalScore(Integer logNormalScore) {
//		this.logNormalScore = logNormalScore;
//	}
//

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "attendance_type")
	public Integer getAttendanceType() {
		return attendanceType;
	}


	public void setAttendanceType(Integer attendanceType) {
		this.attendanceType = attendanceType;
	}

	@Column(name = "normal_score")
	public Integer getNormalScore() {
		return normalScore;
	}


	public void setNormalScore(Integer normalScore) {
		this.normalScore = normalScore;
	}

	@Column(name = "morning_score")
	public Integer getMorningScore() {
		return morningScore;
	}


	public void setMorningScore(Integer morningScore) {
		this.morningScore = morningScore;
	}

	@Column(name = "late_score")
	public Integer getLateScore() {
		return lateScore;
	}


	public void setLateScore(Integer lateScore) {
		this.lateScore = lateScore;
	}

	@Column(name = "overtime_score")
	public Integer getOvertimeScore() {
		return overtimeScore;
	}


	public void setOvertimeScore(Integer overtimeScore) {
		this.overtimeScore = overtimeScore;
	}

	@Column(name = "left_early_score")
	public Integer getLeftEarlyScore() {
		return leftEarlyScore;
	}


	public void setLeftEarlyScore(Integer leftEarlyScore) {
		this.leftEarlyScore = leftEarlyScore;
	}

	@Column(name = "absence_score")
	public Integer getAbsenceScore() {
		return absenceScore;
	}


	public void setAbsenceScore(Integer absenceScore) {
		this.absenceScore = absenceScore;
	}

	@Column(name = "work_time")
	public Long getWorkTime() {
		return workTime;
	}


	public void setWorkTime(Long workTime) {
		this.workTime = workTime;
	}

	@Column(name = "closing_time")
	public Long getClosingTime() {
		return closingTime;
	}

	@Column(name = "outside_work_time")
	public Long getOutsideWorkTime() {
		return outsideWorkTime;
	}

	public void setOutsideWorkTime(Long outsideWorkTime) {
		this.outsideWorkTime = outsideWorkTime;
	}

	@Column(name = "outside_closing_time")
	public Long getOutsideClosingTime() {
		return outsideClosingTime;
	}

	public void setOutsideClosingTime(Long outsideClosingTime) {
		this.outsideClosingTime = outsideClosingTime;
	}

	public void setClosingTime(Long closingTime) {
		this.closingTime = closingTime;
	}

	@Column(name = "company_coordinate")
	public String getCompanyCoordinate() {
		return companyCoordinate;
	}


	public void setCompanyCoordinate(String companyCoordinate) {
		this.companyCoordinate = companyCoordinate;
	}

	@Column(name = "attendance_instance")
	public Long getAttendanceInstance() {
		return attendanceInstance;
	}


	public void setAttendanceInstance(Long attendanceInstance) {
		this.attendanceInstance = attendanceInstance;
	}

	@Column(name = "outside_work_time_score")
	public Integer getOutsideWorkTimeScore() {
		return outsideWorkTimeScore;
	}


	public void setOutsideWorkTimeScore(Integer outsideWorkTimeScore) {
		this.outsideWorkTimeScore = outsideWorkTimeScore;
	}

	@Column(name = "outside_closing_time_score")
	public Integer getOutsideClosingTimeScore() {
		return outsideClosingTimeScore;
	}


	public void setOutsideClosingTimeScore(Integer outsideClosingTimeScore) {
		this.outsideClosingTimeScore = outsideClosingTimeScore;
	}

	@Column(name = "log_release_time")
	public Integer getLogReleaseTime() {
		return logReleaseTime;
	}


	public void setLogReleaseTime(Integer logReleaseTime) {
		this.logReleaseTime = logReleaseTime;
	}

	@Column(name = "approve_score")
	public Integer getApproveScore() {
		return approveScore;
	}


	public void setApproveScore(Integer approveScore) {
		this.approveScore = approveScore;
	}

	@Column(name = "be_approve_score")
	public Integer getBeApproveScore() {
		return beApproveScore;
	}


	public void setBeApproveScore(Integer beApproveScore) {
		this.beApproveScore = beApproveScore;
	}

	@Column(name = "love_score")
	public Integer getLoveScore() {
		return loveScore;
	}


	public void setLoveScore(Integer loveScore) {
		this.loveScore = loveScore;
	}

	@Column(name = "sun_score")
	public Integer getSunScore() {
		return sunScore;
	}


	public void setSunScore(Integer sunScore) {
		this.sunScore = sunScore;
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

