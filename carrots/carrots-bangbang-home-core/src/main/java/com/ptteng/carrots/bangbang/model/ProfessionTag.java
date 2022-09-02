package com.ptteng.carrots.bangbang.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "profession_tag")
public class ProfessionTag implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5437614730941810688L;	
	
		
   	 
    private  Long id;
	
  	 
    private  Long cId;
	
  	 
    private  Long pId;
	
  	 
    private  String tag;
	
  	 
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
		 	@Column(name = "cid")
	public Long getCId() {
		return cId;
	}
	
	
	public void setCId(Long cId) {
		this.cId = cId;
	}
		 	@Column(name = "pid")
	public Long getPId() {
		return pId;
	}
	
	
	public void setPId(Long pId) {
		this.pId = pId;
	}
		 	@Column(name = "tag")
	public String getTag() {
		return tag;
	}
	
	
	public void setTag(String tag) {
		this.tag = tag;
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

