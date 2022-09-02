package com.ptteng.carrots.bangbang.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "module")
public class Module implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 494035488288451584L;	
	
		
   	 
    private  Long id;
	
  	 
    private  String name;
	
  	 
    private  Long pid;
	
  	 
    private  String type;
	
  	 
    private  Long menuId;
	
  	 
    private  String icon;
	
  	 
    private  int level;
	
  	 
    private  String url;
	
  	 
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
		 	@Column(name = "name")
	public String getName() {
		return name;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
		 	@Column(name = "p_id")
	public Long getPid() {
		return pid;
	}
	
	
	public void setPid(Long pid) {
		this.pid = pid;
	}
		 	@Column(name = "type")
	public String getType() {
		return type;
	}
	
	
	public void setType(String type) {
		this.type = type;
	}
		 	@Column(name = "menu_id")
	public Long getMenuId() {
		return menuId;
	}
	
	
	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}
		 	@Column(name = "icon")
	public String getIcon() {
		return icon;
	}
	
	
	public void setIcon(String icon) {
		this.icon = icon;
	}
		 	@Column(name = "level")
	public int getLevel() {
		return level;
	}
	
	
	public void setLevel(int level) {
		this.level = level;
	}
		 	@Column(name = "url")
	public String getUrl() {
		return url;
	}
	
	
	public void setUrl(String url) {
		this.url = url;
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

