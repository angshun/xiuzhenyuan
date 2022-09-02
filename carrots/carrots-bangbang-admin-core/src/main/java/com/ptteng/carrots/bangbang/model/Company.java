package com.ptteng.carrots.bangbang.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "company")
public class Company implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1749718496306633728L;


    private Long id;


    private String name;


    private Long totalNum;


    private Integer industry;


    private Integer province;


    private Integer city;


    private Integer county;


    private Integer financing;


    private Integer approved;


    private Long approvedAt;


    private Integer freezed;


    private Integer recommend;


    private String slogan;


    private String introduction;


    private String product;


    private String moblile;


    private String address;


    private String logo;


    private String mail;


    private String map;


    private Long createAt;


    private Long updateAt;


    private Long createBy;


    private Long releaseAt;


    private Long updateBy;


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

    @Column(name = "total_num")
    public Long getTotalNum() {
        return totalNum;
    }


    public void setTotalNum(Long totalNum) {
        this.totalNum = totalNum;
    }

    @Column(name = "industry")
    public Integer getIndustry() {
        return industry;
    }


    public void setIndustry(Integer industry) {
        this.industry = industry;
    }

    @Column(name = "province")
    public Integer getProvince() {
        return province;
    }


    public void setProvince(Integer province) {
        this.province = province;
    }

    @Column(name = "city")
    public Integer getCity() {
        return city;
    }


    public void setCity(Integer city) {
        this.city = city;
    }

    @Column(name = "county")
    public Integer getCounty() {
        return county;
    }


    public void setCounty(Integer county) {
        this.county = county;
    }

    @Column(name = "financing")
    public Integer getFinancing() {
        return financing;
    }


    public void setFinancing(Integer financing) {
        this.financing = financing;
    }

    @Column(name = "approved")
    public Integer getApproved() {
        return approved;
    }


    public void setApproved(Integer approved) {
        this.approved = approved;
    }

    @Column(name = "approved_at")
    public Long getApprovedAt() {
        return approvedAt;
    }


    public void setApprovedAt(Long approvedAt) {
        this.approvedAt = approvedAt;
    }

    @Column(name = "freezed")
    public Integer getFreezed() {
        return freezed;
    }


    public void setFreezed(Integer freezed) {
        this.freezed = freezed;
    }

    @Column(name = "recommend")
    public Integer getRecommend() {
        return recommend;
    }

    public void setRecommend(Integer recommend) {
        this.recommend = recommend;
    }

    @Column(name = "slogan")
    public String getSlogan() {
        return slogan;
    }


    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    @Column(name = "introduction")
    public String getIntroduction() {
        return introduction;
    }


    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    @Column(name = "product")
    public String getProduct() {
        return product;
    }


    public void setProduct(String product) {
        this.product = product;
    }

    @Column(name = "moblile")
    public String getMoblile() {
        return moblile;
    }


    public void setMoblile(String moblile) {
        this.moblile = moblile;
    }

    @Column(name = "address")
    public String getAddress() {
        return address;
    }


    public void setAddress(String address) {
        this.address = address;
    }

    @Column(name = "logo")
    public String getLogo() {
        return logo;
    }


    public void setLogo(String logo) {
        this.logo = logo;
    }

    @Column(name = "mail")
    public String getMail() {
        return mail;
    }


    public void setMail(String mail) {
        this.mail = mail;
    }

    @Column(name = "map")
    public String getMap() {
        return map;
    }


    public void setMap(String map) {
        this.map = map;
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

    @Column(name = "release_at")
    public Long getReleaseAt() {
        return releaseAt;
    }


    public void setReleaseAt(Long releaseAt) {
        this.releaseAt = releaseAt;
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

