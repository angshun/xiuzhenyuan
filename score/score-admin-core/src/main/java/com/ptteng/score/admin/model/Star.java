package com.ptteng.score.admin.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


@Entity
@Table(name = "star")
public class Star implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7557588834502808576L;	
	
		
   	 
    private  Long id;
	
  	 
    private  Integer gradeType;
	
  	 
    private  String name;
	
  	 
    private  Integer score;
	
  	 
    private  Integer level;
	
  	 
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
		 	@Column(name = "grade_type")
	public Integer getGradeType() {
		return gradeType;
	}
	
	
	public void setGradeType(Integer gradeType) {
		this.gradeType = gradeType;
	}
		 	@Column(name = "name")
	public String getName() {
		return name;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
		 	@Column(name = "score")
	public Integer getScore() {
		return score;
	}
	
	
	public void setScore(Integer score) {
		this.score = score;
	}
		 	@Column(name = "level")
	public Integer getLevel() {
		return level;
	}
	
	
	public void setLevel(Integer level) {
		this.level = level;
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

