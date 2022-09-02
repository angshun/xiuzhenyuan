package com.ptteng.carrots.bangbang.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "article")
public class Article implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4303575984341874688L;	
	
		
   	 
    private  Long id;
	
  	 
    private  Integer type;
	
  	 
    private  String title;
	
  	 
    private  String img;
	
  	 
    private  String url;
	
  	 
    private  Integer status;
	
  	 
    private  Integer industry;
	
  	 
    private  Long createAt;
	
  	 
    private  Long updateAt;
	
  	 
    private  Long createBy;
	
  	 
    private  Long updateBy;
	
  	 
    private  Integer rank;
	
  
	
		 	
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
		 	@Column(name = "title")
	public String getTitle() {
		return title;
	}
	
	
	public void setTitle(String title) {
		this.title = title;
	}
		 	@Column(name = "img")
	public String getImg() {
		return img;
	}
	
	
	public void setImg(String img) {
		this.img = img;
	}
		 	@Column(name = "url")
	public String getUrl() {
		return url;
	}
	
	
	public void setUrl(String url) {
		this.url = url;
	}
		 	@Column(name = "status")
	public Integer getStatus() {
		return status;
	}
	
	
	public void setStatus(Integer status) {
		this.status = status;
	}
		 	@Column(name = "industry")
	public Integer getIndustry() {
		return industry;
	}
	
	
	public void setIndustry(Integer industry) {
		this.industry = industry;
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
		 	@Column(name = "rank")
	public Integer getRank() {
		return rank;
	}
	
	
	public void setRank(Integer rank) {
		this.rank = rank;
	}
		
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}

}

