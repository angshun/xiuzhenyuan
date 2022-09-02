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
@Table(name = "attendance_log")
public class AttendanceLog implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3195250895744812032L;	
	
		
   	 
    private  Long id;
	
  	 
    private  Long staffId;
	
  	 
    private  Integer attendanceType;
	
  	 
    private  String attendanceAddress;
	
  	 
    private  Integer attendanceStatus;
	
  	 
    private  Long createAt;
	
  	 
    private  Long updateAt;
	
  	 
    private  Long createBy;
	
  	 
    private  Long updateBy;
	
  
	
		 	
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
		 	@Column(name = "attendance_type")
	public Integer getAttendanceType() {
		return attendanceType;
	}
	
	
	public void setAttendanceType(Integer attendanceType) {
		this.attendanceType = attendanceType;
	}
		 	@Column(name = "attendance_address")
	public String getAttendanceAddress() {
		return attendanceAddress;
	}
	
	
	public void setAttendanceAddress(String attendanceAddress) {
		this.attendanceAddress = attendanceAddress;
	}
		 	@Column(name = "attendance_status")
	public Integer getAttendanceStatus() {
		return attendanceStatus;
	}
	
	
	public void setAttendanceStatus(Integer attendanceStatus) {
		this.attendanceStatus = attendanceStatus;
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

