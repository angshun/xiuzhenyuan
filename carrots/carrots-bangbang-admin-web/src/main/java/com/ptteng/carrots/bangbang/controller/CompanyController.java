package com.ptteng.carrots.bangbang.controller;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.carrots.bangbang.model.Company;
import com.ptteng.carrots.bangbang.model.CompanyTag;
import com.ptteng.carrots.bangbang.model.Product;
import com.ptteng.carrots.bangbang.service.CompanyService;
import com.ptteng.carrots.bangbang.service.CompanyTagService;
import com.ptteng.carrots.bangbang.service.ProductService;
import com.ptteng.carrots.bangbang.vo.CompanyData;
import com.ptteng.common.dao.util.SQLUtil;
import com.qding.common.util.DataUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import util.CookieUtil;
import util.DynamicUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

import static com.ptteng.carrots.bangbang.constant.Constant.*;


@Controller
public class CompanyController {
    private static final Log log = LogFactory.getLog(CompanyController.class);

    @Autowired
    private CompanyService companyService;
    @Autowired
    private ProductService productService;
    @Autowired
    private CompanyTagService companyTagService;



    /**
     * 公司列表
     *
     * @param request
     * @param response
     * @param model
     * @param name        公司名称
     * @param province    省代码
     * @param city        市代码
     * @param county      区县代码
     * @param productName 产品名称
     * @param industry    行业
     * @param financing   融资规模
     * @param approved    认证状态
     * @param freezed     冻结状态
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/a/u/company/search", method = RequestMethod.GET)
    public String getCompanyList(HttpServletRequest request, HttpServletResponse response, ModelMap model, String name,
                                 Integer province, Integer city, Integer county, String productName, Integer industry,
                                 Integer financing, Integer approved, Integer freezed, Integer page, Integer size) throws Exception {

        log.info("get name data is " + name);
        log.info("get productName data is " + productName);
        log.info("get approved data is " + approved);
        log.info("get freezed data is " + freezed);

        List<Long> companyIdsList = null;
        List<Long> count = null;
        if (page == null || page < 1) {
            page = 1;
        }
        if (size == null || size < 1) {
            size = 10;
        }

        Integer start = (page - 1) * size;
        Map<String, Object> companyParam = null;

        try {
            //组装动态SQL
            companyParam = DynamicUtil.getCompanyList(name, province, city, county, productName, industry, financing, approved, freezed);
            log.info("get companyParam data is " + SQLUtil.convert2Sql(companyParam,0,Integer.MAX_VALUE));
            //获取公司id
            companyIdsList = companyService.getIdsByDynamicCondition(Company.class, companyParam, start, size);
            log.info("get companyIdsList.size data is " + companyIdsList.size());
            count = companyService.getIdsByDynamicCondition(Company.class, companyParam, 0, Integer.MAX_VALUE);
            log.info("get count data is " + count);
        } catch (Throwable t) {
            log.error(t.getMessage());
            log.error("companyIdsList error is " + companyIdsList);
            log.error("count error is " + count);
        }

        //获取公司列表
        List<Company> companyList = companyService.getObjectsByIds(companyIdsList);
        int total = count.size();
        log.info("get companyList data is " + companyList.size());
        model.addAttribute("code", 0);
        model.addAttribute("page", page);
        model.addAttribute("size", size);
        model.addAttribute("total", total);
        model.addAttribute("companyList", companyList);

        return "/carrots-bangbang-admin-service/company/json/companyListJson";
    }

    /**
     * 公司详情
     *
     * @param request
     * @param response
     * @param model
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/a/u/company/{id}", method = RequestMethod.GET)
    public String getCompanyJson(HttpServletRequest request,
                                 HttpServletResponse response, ModelMap model, @PathVariable Long id)
            throws Exception {

        List<Long> productIdsList = null;
        List<Long> cTagIdsList = null;
        List<Product> productList = null;
        List<CompanyTag> companyTagList = null;

        List<String> tagList = new ArrayList<String>();

        log.info("company id is : " + id);

        try {
            Company company = companyService.getObjectById(id);
            log.info("get company data is " + company);
            //首先通过公司id拿到Param
            Map<String, Object> productParam = DynamicUtil.getProductList(id);
            Map<String, Object> cTagParam = DynamicUtil.getTagList(id);
            //通过Param拿到IdsList
            productIdsList = productService.getIdsByDynamicCondition(Product.class, productParam, 0, Integer.MAX_VALUE);
            cTagIdsList = companyTagService.getIdsByDynamicCondition(CompanyTag.class, cTagParam, 0, Integer.MAX_VALUE);
            //通过IdsList拿到List
            productList = productService.getObjectsByIds(productIdsList);
            Product product = productList.get(0);

            companyTagList = companyTagService.getObjectsByIds(cTagIdsList);

            for (CompanyTag tag : companyTagList) {
                tagList.add(tag.getTag());
            }
            log.info("tagList.size is " + tagList.size());

            model.addAttribute("code", 0);

            model.addAttribute("company", company);

            model.addAttribute("product", product);

            model.addAttribute("companyTag", tagList);

        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("get company error,id is  " + id);
            model.addAttribute("code", -100000);
        }

        return "/carrots-bangbang-admin-service/company/json/companyDetailJson";
    }

    /**
     * 编辑公司
     *
     * @param request
     * @param response
     * @param model
     * @param companyData
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/a/u/company/{id}", method = RequestMethod.PUT)
    public String updateCompanyJson(HttpServletRequest request, HttpServletResponse response, ModelMap model,
                                    @PathVariable Long id, @RequestBody CompanyData companyData) throws Exception {

        log.info("get company id is " + id);
        if (id == null) {
            log.info("company id is null");
            model.addAttribute("code", -10000);
            return "/common/fail";
        }
        Company company = companyData.getCompany();
        Product product = companyData.getProduct();
        String[] companyTag = companyData.getCompanyTag();

        List<Long> cTagIdsList = null;
        List<Long> productIdsList = null;
        Long uid = null;

        Company companySource = new Company();
        Product productSource = new Product();

        log.info("update company = " + company);

        if (company.getName() == null) {
            model.addAttribute("code", -10000);
        }
        if (company.getSlogan() == null) {
            model.addAttribute("code", -10000);
        }
        if (company.getTotalNum() == null) {
            model.addAttribute("code", -10000);
        }
        if (company.getLogo() == null) {
            model.addAttribute("code", -10000);
        }
        if (company.getIntroduction() == null) {
            model.addAttribute("code", -10000);
        }

        try {
            //获取原有公司创建人创建时间
            companySource = companyService.getObjectById(id);
            company.setCreateAt(companySource.getCreateAt());
            company.setCreateBy(companySource.getCreateBy());
            company.setFreezed(companySource.getFreezed());
            company.setId(id);
            log.info("get uid = " + uid);
            company.setUpdateAt(System.currentTimeMillis());
            log.info("update company = " + company.getId());
            companyService.update(company);
            log.info("update companyId=" + id);

            //先删除所有id等于cid的产品
            Map<String, Object> productParam = DynamicUtil.getProductList(id);
            productIdsList = productService.getIdsByDynamicCondition(Product.class, productParam, 0, Integer.MAX_VALUE);
            try {
                productService.deleteList(Product.class, productIdsList);
                log.info("delete product success");
                model.addAttribute("code", 0);
            } catch (Throwable t) {
                t.printStackTrace();
                log.info(t.getMessage());
                log.error(productIdsList, t);
                model.addAttribute("code", -6004);
                return "common/fail";
            }

            if (product != null) {
                productSource.setCId(id);
                productSource.setName(product.getName());
                productSource.setSlogan(product.getSlogan());
                productSource.setLogo(product.getLogo());
                productSource.setSummary(product.getSummary());
                productSource.setUpdateAt(System.currentTimeMillis());
                productService.insert(productSource);
            }

            //先删除所有id等于cid的标签
            Map<String, Object> cTagIdsParam = DynamicUtil.getTagList(id);
            cTagIdsList = companyTagService.getIdsByDynamicCondition(CompanyTag.class, cTagIdsParam, 0, Integer.MAX_VALUE);
            try {
                companyTagService.deleteList(CompanyTag.class, cTagIdsList);
                log.info("delete cTagsList success");
                model.addAttribute("code", 0);
            } catch (Throwable t) {
                t.printStackTrace();
                log.error(t.getMessage());
                log.error("delete t companyTagsList error,companyTagIds is  " + cTagIdsList, t);
                model.addAttribute("code", -6004);
                return "/common/fail";
            }

            List<CompanyTag> companyTagList = new ArrayList<CompanyTag>();
            //如果请求参数不为空，则添加进去
            if (DataUtils.isNotNullOrEmpty(companyTag)) {
                for (String str : companyTag) {
                    CompanyTag comTag = new CompanyTag();
                    comTag.setCId(id);
                    comTag.setCreateAt(company.getCreateAt());
                    comTag.setUpdateAt(comTag.getUpdateAt());
                    comTag.setTag(str.toString());
                    companyTagList.add(comTag);
                }

                try {
                    companyTagService.insertList(companyTagList);
                    log.info("companyTagList is " + companyTagList.size());
                } catch (Throwable t) {
                    t.printStackTrace();
                    log.error(t.getMessage());
                    log.error("系统异常，向公司标签表中插入数据失败");
                    model.addAttribute("code", -10000);
                    return "common/fail";
                }
            }
            return "/common/success";


        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return "/common/success";
    }
    /**
     * 更新认证状态
     *
     * @param request
     * @param response
     * @param model
     * @param id
     * @param approved 认证状态
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/a/u/company/approved/{id}", method = RequestMethod.PUT)
    public String updateCompanyApproved(HttpServletRequest request, HttpServletResponse response, ModelMap model,
                                        @PathVariable Long id, Integer approved) throws Exception {

        log.info("update company (id = " + id + ")" + " approved status: " + approved);
        if (id == null) {
            log.info("company id is null");
            model.addAttribute("code", -10000);
            return "/common/fail";
        }

        try {
            Company company = companyService.getObjectById(id);
            if (approved.equals(APPROVED)) {
                company.setRecommend(RECOMMEND);
            } else if (approved.equals(UN_APPROVED)) {
                company.setRecommend(UN_RECOMMEND);
            }
            company.setApproved(approved);
            company.setApprovedAt(System.currentTimeMillis());
            company.setUpdateAt(System.currentTimeMillis());
            companyService.update(company);
            model.addAttribute("code", 0);

        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("update company approved error, approved is  " + approved);
            model.addAttribute("code", -10000);
        }

        return "/data/json";
    }

    /**
     * 更新冻结状态
     *
     * @param request
     * @param response
     * @param model
     * @param id       公司id
     * @param freezed  冻结状态
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/a/u/company/freezed/{id}", method = RequestMethod.PUT)
    public String updateCompanyFreezed(HttpServletRequest request, HttpServletResponse response, ModelMap model,
                                       @PathVariable Long id, Integer freezed) throws Exception {
        log.info("get company (id :" + id + ")" + "and freezed status is " + freezed);
        if (id == null) {
            log.info("company id is null");
            model.addAttribute("code", -10000);
            return "/common/fail";
        }

        try {
            Company company = companyService.getObjectById(id);
            company.setFreezed(freezed);
            company.setUpdateAt(System.currentTimeMillis());
            companyService.update(company);
            model.addAttribute("code", 0);
            model.addAttribute("company", company);
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("");
            model.addAttribute("code", -10000);
        }

        return "/data/json";

    }


    /**
     * 新增公司
     *
     * @param request
     * @param response
     * @param model
     * @param companyData
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/a/u/company", method = RequestMethod.POST)
    public String addCompanyJson(HttpServletRequest request, HttpServletResponse response, ModelMap model,
                                 @RequestBody CompanyData companyData) throws Exception {

        Long uId = null;
        Long cId = null;
        log.info("companyData " + companyData);
        Company company = companyData.getCompany();
        Product product = companyData.getProduct();
        String[] companyTag = companyData.getCompanyTag();

        log.info("insert company : company = " + company);
        log.info("insert companyTag : companyTag = " + companyTag);
        //入参校验：打*的不能为空
        //公司名字不能为空
        if (company.getName() == null) {
            model.addAttribute("code", -10000);
            return "/common/fail";
        }
        //公司slogan不能为空
        if (company.getSlogan() == null) {
            model.addAttribute("code", -10000);
            return "/common/fail";
        }
        //公司人数不能为空
        if (company.getTotalNum() == null) {
            model.addAttribute("code", -10000);
            return "/common/fail";
        }
        //公司logo不能为空
        if (company.getLogo() == null) {
            model.addAttribute("code", -10000);
            return "/common/fail";
        }
        //公司介绍不能为空
        if (company.getIntroduction() == null) {
            model.addAttribute("code", -10000);
            return "/common/fail";
        }
        Long adminId = null;
        try {
            adminId = CookieUtil.getAdminId(request);
            log.info("获取管理员身份成功！ adminId：" + adminId);
        } catch (Throwable t) {
            log.error("获取管理员身份失败！");
            t.printStackTrace();
            log.error(t.getMessage());

        }
        company.setCreateBy(adminId);

        try {
            //获取创建、修改时间
            company.setCreateAt(System.currentTimeMillis());
            company.setUpdateAt(company.getCreateAt());
            //默认新公司冻结状态为解冻
            company.setFreezed(UN_FREEZED);
            //插入公司数据
            cId = companyService.insert(company);
            //插入产品数据
            if (product != null) {
                product.setCId(cId);
                product.setCreateAt(company.getCreateAt());
                product.setUpdateAt(product.getCreateAt());

                productService.insert(product);
                log.info("get product1 data is " + product);
            }

            List<CompanyTag> companyTagList = new ArrayList<CompanyTag>();
            if (DataUtils.isNotNullOrEmpty(companyTag)) {
                for (String str : companyTag) {
                    CompanyTag comTag = new CompanyTag();
                    comTag.setCId(cId);
                    comTag.setTag(str.toString());
                    comTag.setCreateAt(company.getCreateAt());
                    comTag.setUpdateAt(comTag.getCreateAt());
                    companyTagList.add(comTag);
                }
                try {
                    companyTagService.insertList(companyTagList);
                    log.info("公司标签插入成功！ companyTagList：" + companyTagList);
                } catch (Throwable t) {
                    t.printStackTrace();
                    log.error(t.getMessage());
                    log.error("公司标签插入失败 companyTagList :" + companyTagList);
                    model.addAttribute("code", -9012);
                }
            }

            model.addAttribute("code", 0);
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("add company error " + t);
            log.error(companyData,t);
            log.error(company.getApproved(), t);
            model.addAttribute("code", -10000);
        }

        return "/common/addsuccess";
    }
    /**
     * 删除公司信息
     *
     * @param request
     * @param response
     * @param model
     * @param id       公司id
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/a/u/company/{id}", method = RequestMethod.DELETE)
    public String deleteCompanyJson(HttpServletRequest request,
                                    HttpServletResponse response, ModelMap model, @PathVariable Long id)
            throws Exception {

        log.info("delete company : id= " + id);
        List<Long> productIdsList = null;
        List<Long> tagIdsList = null;
        if (id == null) {
            log.info("company id is null");
            model.addAttribute("code", -10000);
            return "/common/fail";
        }
        try {
            companyService.delete(id);
            log.info("delete company success");
            model.addAttribute("code", 0);

        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("delete company error,id is  " + id);
            model.addAttribute("code", -10000);

        }
        Map<String, Object> productParams = DynamicUtil.getProductList(id);
        log.info("get productParams data is " + productParams);

        try {
            productIdsList = productService.getIdsByDynamicCondition(Product.class, productParams, 0, Integer.MAX_VALUE);
            log.info("get productIdsList data is " + productIdsList);
            productService.deleteList(Product.class, productIdsList);
            model.addAttribute("code", 0);
        } catch (Throwable t) {
            t.printStackTrace();
            log.error("delete productIdsList error, ids is " + productIdsList, t);
            model.addAttribute("code", -10000);
        }

        Map<String, Object> tagParams = DynamicUtil.getTagList(id);
        log.info("get tagParams data is " + tagParams);
        try {
            tagIdsList = companyTagService.getIdsByDynamicCondition(CompanyTag.class, tagParams, 0, Integer.MAX_VALUE);
            log.info("get tagIdsList data is " + tagIdsList);
            companyTagService.deleteList(CompanyTag.class, tagIdsList);
            model.addAttribute("code", 0);
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("delete tagIdsList errpr, ids is" + tagIdsList, t);
            model.addAttribute("code", -10000);
        }

        return "/data/json";
    }

}

