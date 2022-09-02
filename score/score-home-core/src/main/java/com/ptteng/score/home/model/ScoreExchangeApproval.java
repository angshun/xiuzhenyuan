package com.ptteng.score.home.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "score_exchange_approval")
public class ScoreExchangeApproval implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3288876052692112384L;	
	
		
   	 
    private  Long id;
	
  	 
    private  Long staffId;
	
  	 
    private  Long goodsId;
	
  	 
    private  Integer exchangeStatus;
	
  	 
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
		 	@Column(name = "staff_id")
	public Long getStaffId() {
		return staffId;
	}
	
	
	public void setStaffId(Long staffId) {
		this.staffId = staffId;
	}
		 	@Column(name = "goods_id")
	public Long getGoodsId() {
		return goodsId;
	}
	
	
	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}
		 	@Column(name = "exchange_status")
	public Integer getExchangeStatus() {
		return exchangeStatus;
	}
	
	
	public void setExchangeStatus(Integer exchangeStatus) {
		this.exchangeStatus = exchangeStatus;
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

