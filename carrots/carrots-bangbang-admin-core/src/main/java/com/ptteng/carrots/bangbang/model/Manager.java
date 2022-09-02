package com.ptteng.carrots.bangbang.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "manager")
public class Manager implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5069026844457485312L;	
	
		
   	 
    private  Long id;
	
  	 
    private  String mobile;
	
  	 
    private  Long rid;
	
  	 
    private  String pwd;
	
  	 
    private  String name;
	
  	 
    private  String status;
	
  	 
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
		 	@Column(name = "mobile")
	public String getMobile() {
		return mobile;
	}
	
	
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
		 	@Column(name = "r_id")
	public Long getRid() {
		return rid;
	}
	
	
	public void setRid(Long rid) {
		this.rid = rid;
	}
		 	@Column(name = "pwd")
	public String getPwd() {
		return pwd;
	}
	
	
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
		 	@Column(name = "name")
	public String getName() {
		return name;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
		 	@Column(name = "status")
	public String getStatus() {
		return status;
	}
	
	
	public void setStatus(String status) {
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

