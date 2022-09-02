package com.ptteng.carrots.bangbang.controller;

import com.ptteng.carrots.bangbang.model.Company;
import com.ptteng.carrots.bangbang.model.CompanyTag;
import com.ptteng.carrots.bangbang.model.Profession;
import com.ptteng.carrots.bangbang.model.ProfessionTag;
import com.ptteng.carrots.bangbang.service.CompanyService;
import com.ptteng.carrots.bangbang.service.CompanyTagService;
import com.ptteng.carrots.bangbang.service.ProfessionService;
import com.ptteng.carrots.bangbang.service.ProfessionTagService;
import com.ptteng.common.dao.util.SQLUtil;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.vendor.OpenJpaDialect;
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
public class ProfessionController {
    private static final Log log = LogFactory.getLog(ProfessionController.class);

    @Autowired
    private ProfessionService professionService;
    @Autowired
    private CompanyService companyService;
    @Autowired
    private CompanyTagService companyTagService;
    @Autowired
    private ProfessionTagService professionTagService;

    /**
     * 推荐职位/最新职位/职位搜索页
     *
     * @param request
     * @param response
     * @param model
     * @param name           职位名称
     * @param province       省
     * @param city           市
     * @param county         县区
     * @param industry       所属行业
     * @param education 工作经验
     * @param welfare        薪资水平
     * @param releaseAt      发布时间
     * @param recommend      推荐类型
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/a/profession/search", method = RequestMethod.GET)
    public String getProfessionList(HttpServletRequest request,
                                    HttpServletResponse response, ModelMap model, String name, Integer province,
                                    Integer city, Integer county, Integer industry, Integer education, Integer experience,
                                    Integer welfare, Integer releaseAt,Integer type,Integer subType, Integer grade, Integer salary, Integer recommend,
                                    Integer page, Integer size) throws Exception {

        log.info("get name data is " + name);
        log.info("get workExperience data is " + experience);
        log.info("get welfare data is " + welfare);
        log.info("get recommend data is " + recommend);
        log.info("get type data is " + subType);

        if (page == null || page < 1) {
            page = 1;
        }
        if (size == null || size < 1) {
            size = 8;
        }
        int start = (page - 1) * size;

        List<Long> professionIdsList = null;

        List<Profession> professionList = null;

        List<Long> count = null;

        HashSet<Long> companyIdSetList = new HashSet<>();

        List<Long> companyIdList = new ArrayList<>();

        List<Company> companyList = null;

        List<Long> cTagIdsList = null;

        List<CompanyTag> cTagList = null;

//        Map<String, Object> professionDataMap = new HashMap<>();

        Map<String, Object> professionParams = null;
        try {
            //组装动态SQL
            professionParams = DynamicUtil.getProfessionList(name, province, city, county, industry, education, experience, welfare, releaseAt, type,subType, grade, recommend, salary);
            log.info("get professionParams data is " + SQLUtil.convert2Sql(professionParams, 0, Integer.MAX_VALUE));

            professionIdsList = professionService.getIdsByDynamicCondition(Profession.class, professionParams, start, size);
            log.info("get professionIdsList data is " + professionIdsList.size());

            //获取count
            count = professionService.getIdsByDynamicCondition(Profession.class, professionParams, 0, Integer.MAX_VALUE);
            Long total = (long) count.size();
            log.info("get count data is " + count + "count size is " + total);

            //获取professionList
            professionList = professionService.getObjectsByIds(professionIdsList);
            log.info("get professionList data is " + professionList.size());

            List<Map<String, Object>> professionDataList = new ArrayList<>();
            //获取公司标签全部列表
            Map<String, Object> cTagParam = DynamicUtil.getCompanyTag();
            log.info("get cTagParam data is " + SQLUtil.convert2Sql(cTagParam, 0, Integer.MAX_VALUE));

            cTagIdsList = companyTagService.getIdsByDynamicCondition(CompanyTag.class, cTagParam, 0, Integer.MAX_VALUE);
            log.info("get cTagIdList data is " + cTagIdsList);

            cTagList = companyTagService.getObjectsByIds(cTagIdsList);
            log.info("get cTagList data is " + cTagList.size());

            for (Profession p : professionList) {
                companyIdSetList.add(p.getcId());
//                companyIdList.add(p.getcId());
            }
            companyIdList.addAll(companyIdSetList);

            companyList = companyService.getObjectsByIds(companyIdList);
            for (Profession p : professionList) {
                for (Company c : companyList) {
                    if (p.getcId().equals(c.getId())) {
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
                        professionDataMap.put("cId", c.getId());
                        professionDataMap.put("province", c.getProvince());
                        professionDataMap.put("city", c.getCity());
                        professionDataMap.put("county", c.getCounty());
                        professionDataMap.put("cName", c.getName());
                        professionDataMap.put("industry", c.getIndustry());
                        professionDataMap.put("logo", c.getLogo());
                        professionDataList.add(professionDataMap);
                        //注意：可能会不是每个公司id都有对应的公司标签，报错：String out of index:-1
                        String temp = " ";
                        for (int i = 0; i < cTagList.size(); i++) {
                            if (c.getId().equals(cTagList.get(i).getCId())) {
                                temp += cTagList.get(i).getTag() + ",";
                            }
                        }
                        temp = temp.substring(0, temp.length() - 1);
                        log.info("遍历后的companyTagList：" + temp);
                        professionDataMap.put("companyTagList", temp);
                        //将全部键值对加入到List中


                    }



                }
            }

            model.addAttribute("code", 0);
            model.addAttribute("page", page);
            model.addAttribute("size", size);
            model.addAttribute("total", total);
            model.addAttribute("professionDataList", professionDataList);
        } catch (Throwable t) {
            log.error(t.getMessage());
            model.addAttribute("code", -10000);
        }

        return "/carrots-bangbang-home-service/profession/json/professionDataListJson";
    }


    /**
     * 职位介绍页
     *
     * @param request
     * @param response
     * @param model
     * @param id       职位id
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/a/profession/{id}", method = RequestMethod.GET)
    public String getProfessionJson(HttpServletRequest request,
                                    HttpServletResponse response, ModelMap model, @PathVariable Long id) throws Exception {

        Map<String, Object> professionTagParams = null;

        List<Long> professionTagIdsList = null;

        List<ProfessionTag> professionTagList = null;

        List<String> tagLis = new ArrayList<>();

        Map<String, Object> professionData = new HashedMap();

        log.info("get data : id= " + id);
        if (id == null) {
            log.info("get profession id is null");
            return "/common/fail";
        }
        try {
            Profession profession = professionService.getObjectById(id);
            log.info("get profession data is " + profession.getId());
            Company company = companyService.getObjectById(profession.getcId());
            log.info("get company data is " + company.getId());
            //组装sql
            professionTagParams = DynamicUtil.getProfessionTagById(id);
            //获取professionTagList
            professionTagIdsList = professionTagService.getIdsByDynamicCondition(ProfessionTag.class, professionTagParams, 0, Integer.MAX_VALUE);
            //获取professionTagList
            professionTagList = professionTagService.getObjectsByIds(professionTagIdsList);

//            /遍历职位标签添加到字符串数组里
            for (ProfessionTag ta : professionTagList) {
                tagLis.add(ta.getTag());
            }

            professionData.put("id", profession.getId());
            professionData.put("name", profession.getName());
            professionData.put("companyName", company.getName());
            professionData.put("logo", company.getLogo());
            professionData.put("totalNum", company.getTotalNum());
            professionData.put("province", company.getProvince());
            professionData.put("city", company.getCity());
            professionData.put("salary", profession.getSalary());
            professionData.put("education", profession.getEducation());
            professionData.put("experience", profession.getWorkExperience());
            professionData.put("releaseAt", profession.getReleaseAt());
            professionData.put("responsibility", profession.getResponsibility());
            professionData.put("requisite", profession.getRequirement());
            professionData.put("welfare", profession.getWelfare());
            professionData.put("industry", company.getIndustry());
            professionData.put("professionTag", tagLis);

            model.addAttribute("code", 0);
            model.addAttribute("professionData", professionData);
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("get profession error,id is  " + id);
            model.addAttribute("code", -100000);
        }

        return "/carrots-bangbang-home-service/profession/json/professionDetailJson";
    }

    /**
     * 成功案例
     *
     * @param request
     * @param response
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/a/company/success", method = RequestMethod.GET)
    public String getSuccess(HttpServletRequest request, HttpServletResponse response, ModelMap model) throws Exception {
        Map<String, Object> params1 = null;
        Map<String, Object> params2 = null;
        List<Long> professionIdsList1 = null;
        List<Long> professionIdsList2 = null;
        List<Profession> professionList1 = null;
        List<Profession> professionList2 = null;
        List<Long> companyIdsList1 = null;
        List<Long> companyIdsList2 = null;
        List<Company> companyList1 = null;
        List<Company> companyList2 = null;
        //认证公司

        try {
            params1 = DynamicUtil.getNewProfession(false);
            log.info("params1========" + params1);
            companyIdsList1 = companyService.getIdsByDynamicCondition(Company.class, params1, 0, Integer.MAX_VALUE);
            log.info("认证公司id去重前list: " + companyIdsList1);
            LinkedHashSet<Long> companySet1 = new LinkedHashSet<Long>(companyIdsList1);
            ArrayList<Long> newCompanyIdsList1 = new ArrayList<Long>(companySet1);
            log.info("认证公司id去重后list: " + newCompanyIdsList1);
            //拿到公司对象List
            companyList1 = companyService.getObjectsByIds(newCompanyIdsList1);
            log.info("get companyList1 data is " + companyList1);
            model.addAttribute("code", 0);
            model.addAttribute("companyList1", companyList1);
        } catch (Throwable t) {
            log.error(t.getMessage());
            model.addAttribute("code", -10000);
        }
        try {
            params2 = DynamicUtil.getNewProfession(true);
            log.info("params2========" + params2);
            companyIdsList2 = companyService.getIdsByDynamicCondition(Company.class, params2, 0, Integer.MAX_VALUE);
            log.info("认证公司id去重前list: " + companyIdsList2);
            LinkedHashSet<Long> companySet2 = new LinkedHashSet<Long>(companyIdsList2);
            ArrayList<Long> newCompanyIdsList2 = new ArrayList<Long>(companySet2);
            log.info("认证公司id去重后list: " + newCompanyIdsList2);
            //拿到公司对象List
            companyList2 = companyService.getObjectsByIds(newCompanyIdsList2);
            log.info("get companyList2 data is " + companyList2);
            model.addAttribute("code", 0);
            model.addAttribute("companyList2", companyList2);
        } catch (Throwable t) {
            log.error(t.getMessage());
            model.addAttribute("code", -10000);
        }

        return "/carrots-bangbang-home-service/company/json/companySuccess";
    }
}

