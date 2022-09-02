package com.ptteng.score.home.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Entity
@Table(name = "role")
public class Role implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5975517449135460352L;
	public static final String STATUS_USING = "using";
	public static final String STATUS_STOPPED = "stopped";
		
   	 
    private  Long id;
	
  	 
    private  String name;
	
  	 
    private  String status;
	
  	 
    private  String permissions;
	
  	 
    private  Long createAt;
	
  	 
    private  Long updateAt;
	
  	 
    private  Long createBy;
	
  	 
    private  Long updateBy;

	private Map<Long, List<String>> permissionsSet = new HashMap();

	@Transient
	public Map<Long, List<String>> getPermissionsSet() {
		return this.permissionsSet;
	}

	public void setPermissionsSet(Map<Long, List<String>> permissionsSet) {
		this.permissionsSet = permissionsSet;
		Gson gson = (new GsonBuilder()).create();
		this.permissions = gson.toJson(permissionsSet);
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
		 	@Column(name = "permissions")
	public String getPermissions() {
		return permissions;
	}
	
	
	public void setPermissions(String permissions) {
		this.permissions = permissions;
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

