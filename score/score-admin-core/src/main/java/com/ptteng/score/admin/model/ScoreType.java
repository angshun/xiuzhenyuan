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
@Table(name = "score_type")
public class ScoreType implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1811702490312042496L;	
	
		
   	 
    private  Long id;
	
  	 
    private  String moral;
	
  	 
    private  String content;
	
  	 
    private  Integer project;
	
  	 
    private  Integer scoreType;
	
  	 
    private  Integer times;
	
  	 
    private  Integer status;
	
  	 
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
		 	@Column(name = "moral")
	public String getMoral() {
		return moral;
	}
	
	
	public void setMoral(String moral) {
		this.moral = moral;
	}
		 	@Column(name = "content")
	public String getContent() {
		return content;
	}
	
	
	public void setContent(String content) {
		this.content = content;
	}
		 	@Column(name = "project")
	public Integer getProject() {
		return project;
	}
	
	
	public void setProject(Integer project) {
		this.project = project;
	}
		 	@Column(name = "score_type")
	public Integer getScoreType() {
		return scoreType;
	}
	
	
	public void setScoreType(Integer scoreType) {
		this.scoreType = scoreType;
	}
		 	@Column(name = "times")
	public Integer getTimes() {
		return times;
	}
	
	
	public void setTimes(Integer times) {
		this.times = times;
	}
		 	@Column(name = "status")
	public Integer getStatus() {
		return status;
	}
	
	
	public void setStatus(Integer status) {
		this.status = status;
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

