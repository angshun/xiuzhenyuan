package com.ptteng.carrots.bangbang.vo;

import com.ptteng.carrots.bangbang.model.Company;
import com.ptteng.carrots.bangbang.model.CompanyTag;
import com.ptteng.carrots.bangbang.model.Product;

public class CompanyData {

    private Company company;

    private String[] companyTag;

    private Product product;

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String[] getCompanyTag() {
        return companyTag;
    }

    public void setCompanyTag(String[] companyTag) {
        this.companyTag = companyTag;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
