package com.ptteng.carrots.bangbang.controller;

import com.ptteng.carrots.bangbang.model.Company;
import com.ptteng.carrots.bangbang.model.CompanyTag;
import com.ptteng.carrots.bangbang.model.Product;
import com.ptteng.carrots.bangbang.model.Profession;
import com.ptteng.carrots.bangbang.service.CompanyService;
import com.ptteng.carrots.bangbang.service.CompanyTagService;
import com.ptteng.carrots.bangbang.service.ProductService;
import com.ptteng.carrots.bangbang.service.ProfessionService;
import com.ptteng.common.dao.util.SQLUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import util.DynamicUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;


@Controller
public class CompanyController {
    private static final Log log = LogFactory.getLog(CompanyController.class);

    @Autowired
    private CompanyService companyService;
    @Autowired
    private CompanyTagService companyTagService;
    @Autowired
    private ProductService productService;
    @Autowired
    private ProfessionService professionService;


    /**
     * 公司列表页 搜索公司页
     *
     * @param request
     * @param response
     * @param model
     * @param name      公司名字
     * @param province  省份代码
     * @param city      市代码
     * @param county    县区代码
     * @param industry  所属行业
     * @param financing 融资规模
     * @param approved  认证状态
     * @param page      第几页
     * @param size      每页数量
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/a/company/search", method = RequestMethod.GET)
    public String getCompanyList(HttpServletRequest request, HttpServletResponse response, ModelMap model,
                                 String name, Integer province, Integer city, Integer county, Integer industry,
                                 Integer financing, Integer approved, Integer page, Integer size) throws Exception {

        if (page == null) {
            page = 1;
        }
        if (size == null) {
            size = 10;
        }
        int start = (page - 1) * size;

        List<Long> companyIdsList = null;

        List<Long> count = null;

        List<Company> companyList = null;

        //组装动态SQL
        Map<String, Object> params = null;


        try {
            params = DynamicUtil.getCompanyList(name, province, city, county, industry, financing, approved);
            log.info("============> get params is " + SQLUtil.convert2Sql(params,0,Integer.MAX_VALUE));
        } catch (Throwable t) {
            log.error(t.getMessage());
            log.error("==============> New params is " + params);
        }
        //获取公司idsList
        try {
            companyIdsList = companyService.getIdsByDynamicCondition(Company.class, params, start, size);
            log.info("===============> ids" + companyIdsList);
            count = companyService.getIdsByDynamicCondition(Company.class, params, 0, Integer.MAX_VALUE);
            log.info("===============> count" + count);

        } catch (Throwable t) {
            log.error(t.getMessage());
            log.error("================> error" + companyIdsList);
            log.error("================> error" + count);
        }

        //获取companyList
        try {
            companyList = companyService.getObjectsByIds(companyIdsList);
            log.info("=============> companyList" +companyIdsList);
        } catch (Throwable t) {
            log.error(t.getMessage());
            log.error("==========> error " + t);
        }
        //公司在招职位数量
        List<Integer> professionNum = new ArrayList<Integer>();
        try {
            if (companyIdsList != null) {
                for (Long cid : companyIdsList) {
                    Map<String, Object> proParam = DynamicUtil.getProfessionOnlyByCid(cid);
                    List<Long> proCount = professionService.getIdsByDynamicCondition(Profession.class, proParam, 0, Integer.MAX_VALUE);
                    professionNum.add(proCount.size());
                }
            }

        } catch (Throwable t) {
            log.error(t);
            log.error(t.getMessage());
        }

        int total = count.size();
        model.addAttribute("code", 0);
        model.addAttribute("page", page);
        model.addAttribute("size", size);
        model.addAttribute("total", total);
        model.addAttribute("companyList", companyList);
        model.addAttribute("professionNum", professionNum);

        return "/carrots-bangbang-home-service/company/json/companyListJson";
    }

    /**
     * 公司详情页
     *
     * @param request
     * @param response
     * @param model
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/a/company/{id}", method = RequestMethod.GET)
    public String getCompanyJson(HttpServletRequest request,
                                 HttpServletResponse response, ModelMap model, @PathVariable Long id)
            throws Exception {

        log.info("get data : id= " + id);

        List<Long> tagIdsList = null;
        List<Long> productIdsList = null;

        try {
            //通过id拿到公司信息
            Company company = companyService.getObjectById(id);
            log.info("get company data is " + company.getId());

            //通过公司id去标签表中拿到标签列表
            Map<String, Object> cTagParams = DynamicUtil.getCompanyTagListByCid(id);
            log.info("get cTagParams data is " + SQLUtil.convert2Sql(cTagParams,0,Integer.MAX_VALUE));
            tagIdsList = companyTagService.getIdsByDynamicCondition(CompanyTag.class, cTagParams, 0, Integer.MAX_VALUE);
            List<CompanyTag> companyTagList = companyTagService.getObjectsByIds(tagIdsList);
            log.info("get tagList data is " + companyTagList.size());

            //通过公司id去产品表中拿到产品信息
            Map<String, Object> productParams = DynamicUtil.getProductList(id);
            log.info("get productParams data is " + SQLUtil.convert2Sql(productParams,0,Integer.MAX_VALUE));
            productIdsList = productService.getIdsByDynamicCondition(Product.class, productParams, 0, Integer.MAX_VALUE);
            Product product = productService.getObjectById(productIdsList.get(0));
            log.info("get productList data is " + product.getId());

            model.addAttribute("code", 0);
            model.addAttribute("company", company);
            model.addAttribute("companyTagList", companyTagList);
            model.addAttribute("product", product);

        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("get company error,id is  " + id);
            model.addAttribute("code", -100000);
        }

        return "/carrots-bangbang-home-service/company/json/companyDetailJson";
    }

    /**
     * 公司在招职位页
     *
     * @param request
     * @param response
     * @param model
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/a/company/profession/{id}", method = RequestMethod.GET)
    public String updateCompanyJson(HttpServletRequest request, HttpServletResponse response, ModelMap model,
                                    @PathVariable Long id, Integer type, Integer page, Integer size) throws Exception {

        log.info("id ========= " + id);
        Map<String, Object> professionParams = null;
        Map<String, Object> countParams = null;
        Map<String, Object> cTagParams = null;
        List<Long> professionIdsList = null;
        List<Long> tagIdsList = null;
        List<Long> count = null;
        List<Profession> professionList = null;
        List<CompanyTag> companyTagList = null;

        if (page == null) {
            page = 1;
        }

        if (size == null) {
            size = 10;
        }

        int start = (page - 1) * size;

        //首先根据id拿到公司对象
        Company company = companyService.getObjectById(id);
        log.info("get company data is " + company.getId());

        try {
            //其次根据公司id拿到职位ids
            professionParams = DynamicUtil.getProfessionByCid(id, type, false);
            professionIdsList = professionService.getIdsByDynamicCondition(Profession.class, professionParams, start, size);
            log.info("get professionIdsList data is " + professionIdsList);
            countParams = DynamicUtil.getProfessionByCid(id, null, true);
            count = professionService.getIdsByDynamicCondition(Profession.class, countParams, 0, Integer.MAX_VALUE);
            log.info("get count data is " + count);
            //根据职位ids拿到职位对象List
            professionList = professionService.getObjectsByIds(professionIdsList);
            log.info("get professionList data is " + professionList.size());
            Long total = count.get(0);
            log.info("get total data is:" + total);
            //再次根据公司id拿到公司标签ids
            cTagParams = DynamicUtil.getCompanyTagListByCid(id);
            tagIdsList = companyTagService.getIdsByDynamicCondition(CompanyTag.class, cTagParams, 0, Integer.MAX_VALUE);
            log.info("get companyTagIdsList data is " + tagIdsList.size());
            //根据公司标签ids拿到公司标签对象List
            companyTagList = companyTagService.getObjectsByIds(tagIdsList);
            log.info("get companyTagList data is " + companyTagList.size());

            List<Map<String, Object>> professionDataList = new ArrayList<>();
            for (Profession p : professionList) {
                Map<String, Object> professionDataMap = new HashMap<>();
                //添加职位信息到professionDataMap中
                professionDataMap.put("pId", p.getId());
                professionDataMap.put("pName", p.getName());
                professionDataMap.put("salary", p.getSalary());
                professionDataMap.put("education", p.getEducation());
                professionDataMap.put("experience", p.getWorkExperience());
                professionDataMap.put("releaseAt", p.getReleaseAt());
                professionDataMap.put("type", p.getType());
                professionDataMap.put("subType", p.getSubType());
                professionDataMap.put("grade", p.getGrade());
                //添加公司信息到professionDataMap中
                professionDataMap.put("cId", company.getId());
                professionDataMap.put("province", company.getProvince());
                professionDataMap.put("city", company.getCity());
                professionDataMap.put("county", company.getCounty());
                professionDataMap.put("cName", company.getName());
                professionDataMap.put("industry", company.getIndustry());
                professionDataMap.put("logo", company.getLogo());
                professionDataMap.put("totalNum", company.getTotalNum());

                //注意：可能会不是每个公司id都有对应的公司标签，报错：String out of index:-1
                String temp = " ";
                for (int i = 0; i < companyTagList.size(); i++) {
                    if (company.getId().equals(companyTagList.get(i).getCId())) {
                        temp += companyTagList.get(i).getTag() + ",";
                    }
                }
                temp = temp.substring(0, temp.length() - 1);
                log.info("遍历后的companyTagList：" + temp);
                professionDataMap.put("companyTagList", temp);
                //将全部键值对加入到List中
                professionDataList.add(professionDataMap);
            }

            model.addAttribute("code", 0);
            model.addAttribute("page", page);
            model.addAttribute("size", size);
            model.addAttribute("total", total);
            model.addAttribute("professionDataList", professionDataList);
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            model.addAttribute("code", -6003);

        }

        return "/carrots-bangbang-home-service/company/json/companyProfessionJson";
    }

//    @RequestMapping(value = "/a/company/recommend/search", method = RequestMethod.GET)
//    public String getRecommendCompany(HttpServletRequest request, HttpServletResponse response, ModelMap model,
//                                      Integer page, Integer size) throws Exception {
//        if (page == null) {
//            page = 1;
//        }
//        if (size == null) {
//            size = 4;
//        }
//        int start = (page - 1) * size;
//
//        List<Long> comIdsList = null;
//        List<Long> count = null;
//
//        List<Company> recoCompanyList = null;
//
//        //组装动态SQL
//        Map<String, Object> param = null;
//        try {
//            param = DynamicUtil.getRecommendCompany();
//            log.info("============> get params is " + param);
//        } catch (Throwable t) {
//            log.error(t.getMessage());
//            log.error("==============> New params is " + param);
//        }
//
//        //获取公司idsList
//        try {
//            comIdsList = companyService.getIdsByDynamicCondition(Company.class, param, start, size);
//            log.info("===============>recommend company ids" + comIdsList.size());
//            count = companyService.getIdsByDynamicCondition(Company.class, param, 0, Integer.MAX_VALUE);
//            log.info("===============> count" + count);
//
//        } catch (Throwable t) {
//            log.error(t.getMessage());
//            log.error("================> error" + comIdsList);
//            log.error("================> error" + count);
//        }
//
//        //获取companyList
//        try {
//            recoCompanyList = companyService.getObjectsByIds(comIdsList);
//            log.info("=============> recoCompanyList" + recoCompanyList.size());
//        } catch (Throwable t) {
//            log.error(t.getMessage());
//            log.error("==========> error " + t);
//        }
//
//        //获取职位idsList
//        List<Integer> professionNum = new ArrayList<Integer>();
//        try {
//            if (comIdsList != null) {
//                for (Long id : comIdsList) {
//                    Map<String, Object> profParam = DynamicUtil.getProfessionOnlyByCid(id);
//                    List<Long> profCount = professionService.getIdsByDynamicCondition(Profession.class, profParam, 0, Integer.MAX_VALUE);
//                    professionNum.add(profCount.size());
//                }
//            }
//
//        } catch (Throwable t) {
//            log.error(t);
//            log.error(t.getMessage());
//        }
//
//        int total = count.size();
//        model.addAttribute("code", 0);
//        model.addAttribute("page", page);
//        model.addAttribute("size", size);
//        model.addAttribute("total", total);
//        model.addAttribute("recoCompanyList", recoCompanyList);
//        model.addAttribute("professionNum", professionNum);
//
//        return "/carrots-bangbang-home-service/company/json/recoCompanyListJson";
//    }


}

