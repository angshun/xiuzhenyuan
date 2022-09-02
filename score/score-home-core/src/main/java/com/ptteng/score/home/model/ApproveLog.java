package com.ptteng.score.home.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "approve_log")
public class ApproveLog implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 654438195186514944L;	
	

   	 
    private  Long id;
	
  	 
    private  Integer type;
	
  	 
    private  Long logId;
	
  	 
    private  Long staffId;
	
  	 
    private  Long createAt;
	
  	 
    private  Long updateAt;
	
  	 
    private  Long createBy;
	
  	 
    private  Long updateBy;

	private Long praiseId;

	private Integer scoreType;

	private Integer score;

	@Column(name = "score")
	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	@Column(name = "score_type")
	public Integer getScoreType() {
		return scoreType;
	}

	public void setScoreType(Integer scoreType) {
		this.scoreType = scoreType;
	}

	@Column(name = "praise_id")
	public Long getPraiseId() {
		return praiseId;
	}

	public void setPraiseId(Long praiseId) {
		this.praiseId = praiseId;
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
		 	@Column(name = "type")
	public Integer getType() {
		return type;
	}
	
	
	public void setType(Integer type) {
		this.type = type;
	}
		 	@Column(name = "log_id")
	public Long getLogId() {
		return logId;
	}
	
	
	public void setLogId(Long logId) {
		this.logId = logId;
	}
		 	@Column(name = "staff_id")
	public Long getStaffId() {
		return staffId;
	}
	
	
	public void setStaffId(Long staffId) {
		this.staffId = staffId;
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

