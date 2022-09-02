package com.ptteng.score.home.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "philosophy")
public class Philosophy implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4268067214537263104L;	
	
		
   	 
    private  Long id;
	
  	 
    private  String title;
	
  	 
    private  Integer reward;
	
  	 
    private  String content;
	
  	 
    private  Integer project;
	
  	 
    private  Integer readNum;
	
  	 
    private  Integer status;
	
  	 
    private  Integer articleStatus;
	
  	 
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
		 	@Column(name = "title")
	public String getTitle() {
		return title;
	}
	
	
	public void setTitle(String title) {
		this.title = title;
	}
		 	@Column(name = "reward")
	public Integer getReward() {
		return reward;
	}
	
	
	public void setReward(Integer reward) {
		this.reward = reward;
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
		 	@Column(name = "read_num")
	public Integer getReadNum() {
		return readNum;
	}
	
	
	public void setReadNum(Integer readNum) {
		this.readNum = readNum;
	}
		 	@Column(name = "status")
	public Integer getStatus() {
		return status;
	}
	
	
	public void setStatus(Integer status) {
		this.status = status;
	}
		 	@Column(name = "article_status")
	public Integer getArticleStatus() {
		return articleStatus;
	}
	
	
	public void setArticleStatus(Integer articleStatus) {
		this.articleStatus = articleStatus;
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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Philosophy that = (Philosophy) o;

		return id.equals(that.id);
	}

	@Override
	public int hashCode() {
		return id.hashCode();
	}
}

