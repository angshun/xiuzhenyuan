package com.ptteng.carrots.bangbang.controller;

import com.ptteng.carrots.bangbang.model.*;
import com.ptteng.carrots.bangbang.service.CompanyService;
import com.ptteng.carrots.bangbang.service.CompanyTagService;
import com.ptteng.carrots.bangbang.service.ProfessionService;
import com.ptteng.carrots.bangbang.service.ProfessionTagService;
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
import javax.swing.*;
import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.*;

/**
 * 后台：
 * 1.新增职位
 * 2.删除职位
 * 3.修改职位
 * 4.修改职位上架状态
 * 5.搜索职位
 * 6.获取职位详情
 * 7.公司在招职位
 * // * <p>
 * // * 前台：
 * // * 8.最新职位
 * // * 9.最新职位搜索
 * // * 10.推荐职位
 * // * 11.推荐职位搜索
 *
 * @author magenm
 * @Date 2014-4-16 13:43
 */
@Controller
public class ProfessionController {
    private static final Log log = LogFactory.getLog(ProfessionController.class);

    @Autowired
    private ProfessionService professionService;

    @Autowired
    private ProfessionTagService professionTagService;

    @Autowired
    private CompanyService companyService;

    @Autowired
    private CompanyTagService companyTagService;


    /**
     * 1.新增职位
     *
     * @param request
     * @param response
     * @param model
     * @param professionData
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/a/u/profession", method = RequestMethod.POST)
    public String addProfessionJson(HttpServletRequest request,
                                    HttpServletResponse response, ModelMap model,
                                    @RequestBody ProfessionData professionData) throws Exception {

        log.info("前端传入的对象：professionData：");
        Profession profession = professionData.getProfession();
        log.info("获得职位对象 profession : profession= ");
        if (profession.getName() == null || profession.getName() == "") {
            log.info("必填参数:职位名称 有误或为空！");
            model.addAttribute("code", -9002);
            return "common/fail";
        }
        if (profession.getResponsibility() == null || profession.getResponsibility() == "") {
            log.info("必填参数:岗位职责 有误或为空！");
            model.addAttribute("code", -9009);
            return "common/fail";
        }
        if (profession.getRequirement() == null || profession.getRequirement() == "") {
            log.info("必填参数: 必备条件 有误或为空！");
            model.addAttribute("code", -9010);
            return "common/fail";
        }
        if (profession.getWelfare() == null || profession.getWelfare() == "") {
            log.info("必填参数：公司福利 有误或为空！");
            model.addAttribute("code", -9011);
            return "common/fail";
        }

        Long adminId = null;
        try {
            adminId = CookieUtil.getAdminId(request);
            log.info("获取管理员身份成功！ adminId：" + adminId);
        } catch (Throwable t) {
            log.error("获取管理员身份失败！");
            t.printStackTrace();
            log.error(t.getMessage());


            model.addAttribute("code", -5001);
            return "common/fail";
        }
//       新增职位获取自增主键id
        Long id = null;
        try {
            profession.setCreateAt(System.currentTimeMillis());
            profession.setStatus(1);//默认上架状态
            profession.setReleaseAt(System.currentTimeMillis());
            profession.setCreateBy(adminId);
            id = professionService.insert(profession);
            log.info("新增 ID为：" + " " + id + " profession: ");

            List<ProfessionTag> professionTagList = new ArrayList<>();
            if (DataUtils.isNotNullOrEmpty(professionData.getProfessionTag())) {
                for (String p : professionData.getProfessionTag()) {
                    ProfessionTag professionTag = new ProfessionTag();
                    //标签表关联职位id
                    professionTag.setPId(id);
                    professionTag.setTag(p.toString());
                    professionTag.setCreateAt(profession.getCreateAt());
                    professionTag.setCreateBy(profession.getCreateBy());
                    professionTagList.add(professionTag);
                }
                try {
                    //插入职位标签list
                    professionTagService.insertList(professionTagList);
                    log.info("职位标签插入成功！ professionTagList：" + professionTagList.size());
                } catch (Throwable t) {
                    t.printStackTrace();
                    log.error(t.getMessage());
                    log.error("职位标签插入失败 professionTagList :" + professionTagList);
                    model.addAttribute("code", -9012);
                }
            }
            model.addAttribute("code", 0);

        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("add profession error ");
            model.addAttribute("code", -100000);
        }
        return "common/insert";
    }

    /**
     * 2.删除职位
     *
     * @param request
     * @param response
     * @param model
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/a/u/profession/{id}", method = RequestMethod.DELETE)
    public String deleteProfessionJson(HttpServletRequest request,
                                       HttpServletResponse response, ModelMap model, @PathVariable Long id)
            throws Exception {

        log.info("delete profession : id= " + id);

        Map<String, Object> sql = DynamicUtil.getProfessionTagIds(id, false);
        List<Long> professionTagIds = null;
        try {
            professionTagIds = professionTagService.getIdsByDynamicCondition(ProfessionTag.class, sql, 0, Integer.MAX_VALUE);
            log.info("通过职位ID查询职位标签，得到职位标签Ids：" + professionTagIds);
            professionTagService.deleteList(ProfessionTag.class, professionTagIds);
            log.info("通过职位标签Ids删除职位标签成功！");
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("系统异常！删除职位标签失败！职位ID为：" + id);
            model.addAttribute("code", -9012);
            return "common/fail";
        }
        try {
            professionService.delete(id);
            log.info("delete profession 成功！职位ID：" + id);
            model.addAttribute("code", "0");
            model.addAttribute("id", id);

        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("delete profession error,id is  " + id);
            model.addAttribute("code", -9021);
            return "common/fail";
        }
        return "common/success";
    }


    /**
     * 3.修改职位
     *
     * @param request
     * @param response
     * @param model
     * @param professionData
     * @return
     * @throws Exception
     */

    @RequestMapping(value = "/a/u/profession/{id}", method = RequestMethod.PUT)
    public String updateProfessionJson(HttpServletRequest request,
                                       HttpServletResponse response, ModelMap model,
                                       @RequestBody ProfessionData professionData,
                                       @PathVariable Long id
    ) throws Exception {

        log.info("从ProfessionData中获得profession对象：");
        Profession profession = professionData.getProfession();

        Profession profession1 = professionService.getObjectById(id);
        log.info("获得修改前的对象：");


        Long adminId = null;
        try {
            adminId = CookieUtil.getAdminId(request);
            log.info("获取管理员身份成功！ adminId：" + adminId);
        } catch (Throwable t) {
            log.error("获取管理员身份失败！");
            t.printStackTrace();
            log.error(t.getMessage());
            model.addAttribute("code", -5001);
            return "common/fail";
        }
        if (DataUtils.isNullOrEmpty(profession.getName()) ||
                DataUtils.isNullOrEmpty(profession.getWelfare()) ||
                DataUtils.isNullOrEmpty(profession.getRequirement()) ||
                DataUtils.isNullOrEmpty(profession.getResponsibility())) {
            log.error("必填信息有误或为空！");
            model.addAttribute("code", -1000);
            return "common/fail";
        }
        try {
            profession.setCreateBy(profession1.getCreateBy());
            profession.setCreateAt(profession1.getCreateAt());
            profession.setReleaseAt(profession1.getReleaseAt());
            profession.setStatus(profession1.getStatus());
            profession.setUpdateBy(adminId);
            profession.setUpdateAt(System.currentTimeMillis());
            profession.setId(profession1.getId());
            professionService.update(profession);
            log.info("提交修改后ID为：" + id + " 的数据：");
            model.addAttribute("code", 0);

        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("修改职位错误");
            model.addAttribute("code", -9022);
            return "common/fail";
        }
        //以上是职位修改，下面是职位标签

        //首先根据pid在数据中删除对应的标签
        log.info("根据职位ID删除职位标签，ID为：" + id);
        Map<String, Object> sql = DynamicUtil.getProfessionTagIds(id, false);
        log.info("删除职位标签的SQL：" + sql);
        List<Long> tags = null;
        try {
            tags = professionTagService.getIdsByDynamicCondition(ProfessionTag.class, sql, 0, Integer.MAX_VALUE);
            log.info("通过职位ID，在职位标签表中查询到对应标签 tags：" + tags.size());
            professionTagService.deleteList(ProfessionTag.class, tags);
            log.info("通过职位ID，删除对应职位标签成功！");
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("系统异常，删除职位标签错误");
            model.addAttribute("code", -9023);
            return "common/fail";
        }
        //下面跟新标签
        List<ProfessionTag> professionTags = new ArrayList<>();
        if (DataUtils.isNotNullOrEmpty(professionData.getProfessionTag())) {
            for (String p : professionData.getProfessionTag()) {
                ProfessionTag professionTag = new ProfessionTag();
                professionTag.setPId(profession1.getId());
                professionTag.setUpdateAt(System.currentTimeMillis());
                professionTag.setUpdateBy(adminId);
                professionTag.setCreateBy(adminId);
                professionTag.setTag(p.toString());
                professionTags.add(professionTag);
            }
            try {
                professionTagService.insertList(professionTags);
                log.info("向数据库中插入职位标签：professionTags：" + professionTags.size());
            } catch (Throwable t) {
                t.printStackTrace();
                log.error(t.getMessage());
                log.error("系统异常，向职位标签表中插入数据失败");
                model.addAttribute("code", -9024);
                return "common/fail";
            }
        }
        return "common/success";
    }

    /**
     * 4.修改上下架状态
     *
     * @param request
     * @param response
     * @param model
     * @param id
     * @param status
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/a/u/profession/status/{id}", method = RequestMethod.PUT)
    public String getprofessionList(HttpServletRequest request,
                                    HttpServletResponse response, ModelMap model,
                                    @PathVariable Long id, Integer status) throws Exception {

        Long adminId = null;
        try {
            adminId = CookieUtil.getAdminId(request);
            log.info("获取管理员身份成功！ adminId：" + adminId);
        } catch (Throwable t) {
            log.error("获取管理员身份失败！");
            t.printStackTrace();
            log.error(t.getMessage());
            model.addAttribute("code", -5001);
            return "common/fail";
        }

        try {
            Profession profession = professionService.getObjectById(id);
            log.info("网页传递状态值为 status：" + status);
            profession.setStatus(status);
            profession.setUpdateAt(System.currentTimeMillis());
            profession.setUpdateBy(adminId);
            professionService.update(profession);
            model.addAttribute("code", "0");
            model.addAttribute("id", id);
            return "common/success";
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("系统异常，修改上下架错误");
            model.addAttribute("code", -9013);
            return "common/fail";
        }

    }

    /**
     * 5.职位列表
     *
     * @param request
     * @param response
     * @param model
     * @param cName
     * @param pName
     * @param type
     * @param education
     * @param workExperience
     * @param salary
     * @param status
     * @param startAt
     * @param endAt
     * @param page
     * @param size
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/a/u/profession/search", method = RequestMethod.GET)
    public String getProfessionList(HttpServletRequest request, HttpServletResponse response,
                                    ModelMap model, String cName, String pName, Integer type,
                                    Integer education, Integer workExperience, Integer salary,
                                    Integer status, Long startAt, Long endAt, Integer page,
                                    Integer size, Integer recommend, Integer subType, Integer grade,
                                    Long cid, Integer city, Integer county, Integer province)
            throws Exception {

        if (page == null || page <= 0) {
            page = 1;
        }
        if (size == null || size <= 0) {
            size = 10;
        }
        int start = (page - 1) * size;


        Map<String, Object> professionSql = null;

        List<Long> professionIdList = null;

        List<Long> professionCountList = null;

        List<Profession> professionList = null;

        HashSet<Long> companyIdSetList = new HashSet<>();

        List<Long> companyIdList = new ArrayList<>();

        List<Company> companyList = null;

        List<Map<String, Object>> professionDataList = new ArrayList<>();

        boolean data = false;

        try {
//查职位sql
            professionSql = DynamicUtil.getProfessionList(pName, cName, workExperience, education, salary, type, status, recommend, startAt, endAt, subType, grade, cid, city, county, province);
            log.info("get professionSql is:" + SQLUtil.convert2Sql(professionSql, 0, Integer.MAX_VALUE));
//职位ids
            professionIdList = professionService.getIdsByDynamicCondition(Profession.class, professionSql, start, size);
            log.info("get professionIdList is:" + professionIdList);
//职位list
            professionList = professionService.getObjectsByIds(professionIdList);
            log.info("get professionList is: " + professionIdList);

            professionCountList = professionService.getIdsByDynamicCondition(Profession.class, professionSql, 0, Integer.MAX_VALUE);
            log.info("get professionCountList is:" + professionCountList.size());
//遍历职位list得到公司ids
            for (Profession p : professionList) {
//                companyIdList.add(p.getcId());
                companyIdSetList.add(p.getcId());
            }
            companyIdList.addAll(companyIdSetList);
            log.info("get companyIdList is:" + companyIdList);

//公司list

            companyList = companyService.getObjectsByIds(companyIdList);
            log.info("get companyList is:" + companyIdList);
            for (Profession p : professionList) {
                for (Company c : companyList) {
                    if (p.getcId().equals(c.getId())) {
                        Map<String, Object> professionData = new HashMap<>();
                        professionData.put("companyName", c.getName());
                        professionData.put("professionName", p.getName());
                        professionData.put("pId", p.getId());
                        professionData.put("welfare", p.getWelfare());
                        professionData.put("responsibility", p.getResponsibility());
                        professionData.put("requirement", p.getRequirement());
                        professionData.put("cId", c.getId());
                        professionData.put("workExperience", p.getWorkExperience());
                        professionData.put("education", p.getEducation());
                        professionData.put("salary", p.getSalary());
                        professionData.put("type", p.getType());
                        professionData.put("subType", p.getSubType());
                        professionData.put("grade", p.getGrade());
                        professionData.put("recommend", p.getRecommend());
                        professionData.put("status", p.getStatus());
                        professionData.put("releaseAt", p.getCreateAt());
                        data = professionDataList.add(professionData);
                    }
                }
                model.addAttribute("code", "0");
            }
            log.info("professionDataList add professionData:" + data);
            model.addAttribute("size", size);
            model.addAttribute("page", page);
            model.addAttribute("total", professionCountList.size());
            model.addAttribute("professionDataList", professionDataList);
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("get professionList error ");
            model.addAttribute("code", -9026);
            return "common/fail";
        }


        return "/carrots-bangbang-admin-service/profession/json/professionListJson";
    }

    /**
     * 6.职位详情信息
     *
     * @param request
     * @param response
     * @param model
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/a/u/profession/{id}", method = RequestMethod.GET)
    public String getProfessionJson(HttpServletRequest request,
                                    HttpServletResponse response, ModelMap model, @PathVariable Long id)
            throws Exception {

        log.info("get data : id= " + id);

        Profession profession = null;

        Long cid = null;

        Company company = null;

        List<Long> professionTagIdList = null;

        List<ProfessionTag> professionTagList = null;
        List<String> tagList = new ArrayList<String>();

        try {
            profession = professionService.getObjectById(id);
            log.info("get profession is " + profession.getId());

            cid = profession.getcId();
            company = companyService.getObjectById(cid);
//            log.info("get company is " + company.getId());

            Map<String, Object> pTagParam = DynamicUtil.getpTagIdsByPId(id);
            professionTagIdList = professionTagService.getIdsByDynamicCondition(ProfessionTag.class, pTagParam, 0, Integer.MAX_VALUE);
            professionTagList = professionTagService.getObjectsByIds(professionTagIdList);
            for (ProfessionTag tg : professionTagList) {
                tagList.add(tg.getTag());
            }

            Map<String, Object> professionData = new HashMap<>();
            professionData.put("companyName", company.getName());
            professionData.put("professionName", profession.getName());
            professionData.put("pId", profession.getId());
            professionData.put("welfare", profession.getWelfare());
            professionData.put("responsibility", profession.getResponsibility());
            professionData.put("requirement", profession.getRequirement());
            professionData.put("workExperience", profession.getWorkExperience());
            professionData.put("education", profession.getEducation());
            professionData.put("salary", profession.getSalary());
            professionData.put("type", profession.getType());
            professionData.put("subType", profession.getSubType());
            professionData.put("grade", profession.getGrade());
            professionData.put("recommend", profession.getRecommend());
            professionData.put("city", profession.getCity());
            professionData.put("county", profession.getCounty());
            professionData.put("province", profession.getProvince());

            professionData.put("professionTag", tagList);

            model.addAttribute("code", 0);

            model.addAttribute("professionData", professionData);


        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("get profession error,id is  " + id);
            model.addAttribute("code", -100000);
        }

        return "/carrots-bangbang-admin-service/profession/json/professionDetailJson";
    }

    /**
     * 7.公司在招职位
     *
     * @param request
     * @param response
     * @param id
     * @param model
     * @param page
     * @param size
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/a/u/company/profession/{id}", method = RequestMethod.GET)
    public String jopTitle(HttpServletRequest request, HttpServletResponse response,
                           @PathVariable Long id, ModelMap model, Integer page, Integer size) throws Exception {

        if (page == null || page <= 0) {
            page = 1;
        }
        if (size == null || size <= 10) {
            size = 10;
        }
        int start = (page - 1) * size;
        if (start < 0) {
            start = 0;
        }
        Map<String, Object> sql = DynamicUtil.getProfessionIds(id, false);
        log.info("查询SQL语句为：" + sql);
        List<Long> ids = null;

        try {
            ids = professionService.getIdsByDynamicCondition(Profession.class, sql, start, size);
            log.info("取得公司的职位ids成功！ids：" + ids);
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("系统异常，获取职位ids异常");
            model.addAttribute("code", -6607);
            return "common/fail";
        }
        Map<String, Object> countSql = DynamicUtil.getProfessionIds(id, true);
        List<Long> count = null;
        boolean list = false;
        try {
            count = professionService.getIdsByDynamicCondition(Profession.class, countSql, 0, Integer.MAX_VALUE);
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("系统异常，获取公司在招职位总数异常");
            model.addAttribute("code", -6606);
            return "common/fail";
        }

        List<Profession> professions = new ArrayList<>();
        try {
            professions = professionService.getObjectsByIds(ids);
            log.info("通过职位ids获取对象列表成功！professions:" + ids);
        } catch (Throwable t) {
            t.printStackTrace();
            log.error("系统异常！通过职位ids获取职位对象列表失败！ids：" + ids);
            model.addAttribute("code", -6605);
            return "common/fail";
        }
        Company company = null;
        try {
            company = companyService.getObjectById(id);
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("系统异常！获得公司对象失败。ID为：" + id);
            model.addAttribute("code", -6606);
            return "common/fail";
        }

        //把公司名称和职位信息组装在一个list里
        List<Map<Object, Object>> professionList = new ArrayList<>();
        for (Profession p : professions) {
            Map<Object, Object> profession = new HashMap<>();
            profession.put("id", p.getId());
            profession.put("cid", p.getcId());
            profession.put("professionName", p.getName());
            profession.put("workExperience", p.getWorkExperience());
            profession.put("type", p.getType());
            profession.put("salary", p.getSalary());
            profession.put("education", p.getEducation());
            profession.put("releasedAt", p.getReleaseAt());
            profession.put("status", p.getStatus());
            profession.put("companyName", company.getName());
            list = professionList.add(profession);

        }
        log.info("professionList add profession:" + list);
        model.addAttribute("code", "0");
        model.addAttribute("total", count.get(0));
        model.addAttribute("size", size);
        model.addAttribute("page", page);
        model.addAttribute("professionList", professionList);
        return "/carrots-bangbang-admin-service/profession/json/jopTitle";
    }


}

