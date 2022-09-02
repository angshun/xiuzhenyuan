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
@Table(name = "manager")
public class Manager implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5048867869019550720L;

	public static final String STATUS_USING = "using";
	public static final String STATUS_STOPPED = "stopped";
	public static final String RESET = "reset";
	
		
   	 
    private  Long id;
	
  	 
    private  String phone;
	
  	 
    private  Long roleId;
	
  	 
    private  String nick;
	
  	 
    private  String pwd;
	
  	 
    private  String region;
	
  	 
    private  String company;
	
  	 
    private  String type;
	
  	 
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
		 	@Column(name = "phone")
	public String getPhone() {
		return phone;
	}
	
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
		 	@Column(name = "role_id")
	public Long getRoleId() {
		return roleId;
	}
	
	
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
		 	@Column(name = "nick")
	public String getNick() {
		return nick;
	}
	
	
	public void setNick(String nick) {
		this.nick = nick;
	}
		 	@Column(name = "pwd")
	public String getPwd() {
		return pwd;
	}
	
	
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
		 	@Column(name = "region")
	public String getRegion() {
		return region;
	}
	
	
	public void setRegion(String region) {
		this.region = region;
	}
		 	@Column(name = "company")
	public String getCompany() {
		return company;
	}
	
	
	public void setCompany(String company) {
		this.company = company;
	}
		 	@Column(name = "type")
	public String getType() {
		return type;
	}
	
	
	public void setType(String type) {
		this.type = type;
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

