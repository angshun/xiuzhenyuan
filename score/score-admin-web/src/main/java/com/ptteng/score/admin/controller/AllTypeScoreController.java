package com.ptteng.score.admin.controller;

import com.ptteng.score.admin.constant.ConstantItem;
import com.ptteng.score.admin.model.AllTypeScore;
import com.ptteng.score.admin.model.Staff;
import com.ptteng.score.admin.service.AllTypeScoreService;
import com.ptteng.score.admin.service.StaffService;
import com.ptteng.score.admin.util.ControllerAnnotation;
import com.ptteng.score.admin.util.DynamicSQLUtil;
import com.qding.common.util.DataUtils;
import com.qding.common.util.http.cookie.CookieUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * AllTypeScore  crud
 *
 * @author magenm
 * @Date 2014-4-16 13:43
 */
@Controller
public class AllTypeScoreController {
    private static final Log log = LogFactory.getLog(AllTypeScoreController.class);

    @Autowired
    private AllTypeScoreService allTypeScoreService;

    @Autowired
    private StaffService staffService;


    @Autowired
    private CookieUtil cookieUtil;


    /**
     * 1.新增
     *
     * @param request
     * @param response
     * @param model
     * @param allTypeScore
     * @return
     * @throws Exception
     */
    @ControllerAnnotation("030")
    @RequestMapping(value = "/a/u/allTypeScore", method = RequestMethod.POST)
    public String addAllTypeScoreJson(HttpServletRequest request,
                                      HttpServletResponse response, ModelMap model, @RequestBody AllTypeScore allTypeScore) throws Exception {

        log.info("add allTypeScore= " + allTypeScore);
        if (DataUtils.isNullOrEmpty(allTypeScore)) {
            log.info("get allTypeScore is null！");
            model.addAttribute("code", -1000);
            return "common/fail";
        }


        Long adminId = Long.valueOf(cookieUtil.getKeyIdentity(request, CookieUtil.USER_ID));

        log.info("get adminId is : " + adminId);

        Long id = null;

        try {

            allTypeScore.setCreateBy(adminId);
            allTypeScore.setUpdateBy(adminId);
            id = allTypeScoreService.insert(allTypeScore);
            log.info("add allTypeScore id is: " + id);

            model.addAttribute("code", 0);
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("add allTypeScore error ");
            model.addAttribute("code", -100000);
        }

        return "/data/json";
    }

    /**
     * 2.删除
     *
     * @param request
     * @param response
     * @param model
     * @param id
     * @return
     * @throws Exception
     */
    @ControllerAnnotation("032")
    @RequestMapping(value = "/a/u/allTypeScore", method = RequestMethod.DELETE)
    public String deleteAllTypeScoreJson(HttpServletRequest request,
                                         HttpServletResponse response, ModelMap model, Long[] id)
            throws Exception {

        log.info("get id.length is: " + id.length);
        if (id != null && id.length == ConstantItem.ZERO) {
            log.info("get id is null！");
            model.addAttribute("code", -1000);
            return "common/fail";
        }
        List<Long> list = Arrays.asList(id);
        log.info("delete allTypeScore : id= " + list);

        List<Staff> staffList1 = new ArrayList<>();
        AllTypeScore allTypeScore = null;
        List<Staff> staffList = null;
        List<Long> staffIds = null;


        try {

            staffIds = staffService.getStaffIds(ConstantItem.ZERO, Integer.MAX_VALUE);
            log.info("get staffIds.size is: " + staffIds);

            staffList = staffService.getObjectsByIds(staffIds);
            if (DataUtils.isNullOrEmpty(staffList)) {
                log.info("get staffList) is null！");
                model.addAttribute("code", -1000);
                return "common/fail";
            }
            log.info("get staffList.size id is: " + staffList.size());


            if (list.get(ConstantItem.ZERO) == null) {
                log.info("get list.get(0) is null！");
                model.addAttribute("code", -1000);
                return "common/fail";
            }


            allTypeScore = allTypeScoreService.getObjectById(list.get(ConstantItem.ZERO));
            log.info("get allTypeScore id is: " + allTypeScore.getId());

            if (DataUtils.isNullOrEmpty(allTypeScore.getType())) {
                model.addAttribute("code", -1000);
                return "common/fail";
            }
            log.info("get allTypeScore is: " + allTypeScore);
            log.info("get allTypeScoreType is: " + allTypeScore.getType());

        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("get  staffList error,id is  " + staffIds);
            model.addAttribute("code", -100000);
        }


        switch (allTypeScore.getType()) {
            case 0:
                for (Staff s : staffList) {
                    for (Long l : list) {
                        if (l.longValue() == s.getPositionId()) {
                            s.setPositionId(ConstantItem.ZERO_ID);
                            s.setPositionName(null);
                            s.setPositionScore(ConstantItem.ZERO);
                            staffList1.add(s);
                        }
                    }
                }
                log.info("get type is: " + allTypeScore.getType());
                break;
            case 1:
                for (Staff s : staffList) {
                    for (Long l : list) {
                        log.info("get l is: " + l);
                        if (l.longValue() == s.getDegreeId()) {
                            log.info("get l is: " + l.longValue() + " degreeId is: " + s.getDegreeId());
                            s.setDegreeId(ConstantItem.ZERO_ID);
                            s.setDegreeScore(ConstantItem.ZERO);
                            staffList1.add(s);
                        }
                    }
                }
                log.info("get type is: " + allTypeScore.getType());
                break;
            case 2:
                for (Staff s : staffList) {
                    for (Long l : list) {
                        if (s.getHonorId() == l.longValue()) {
                            log.info("get l is: " + l.longValue());
                            s.setHonorId(ConstantItem.ZERO_ID);
                            s.setHonorScore(ConstantItem.ZERO);
                            staffList1.add(s);
                        }
                    }
                }
                log.info("get type is: " + allTypeScore.getType());
                break;
            case 3:
                for (Staff s : staffList) {
                    for (Long l : list) {
                        if (l.longValue() == s.getJopId()) {
                            s.setJopId(ConstantItem.ZERO_ID);
                            s.setJopScore(ConstantItem.ZERO);
                            staffList1.add(s);
                        }
                    }
                }
                log.info("get type is: " + allTypeScore.getType());
                break;
            case 4:
                for (Staff s : staffList) {
                    for (Long l : list) {
                        if (l.longValue() == s.getSpecialityId()) {
                            s.setSpecialityId(ConstantItem.ZERO_ID);
                            s.setSpecialityScore(ConstantItem.ZERO);
                            staffList1.add(s);
                        }
                    }
                }
                break;
            default:
        }

        try {
            log.info("update staffIdList.size is: " + staffList1.size());

            boolean result = staffService.updateList(staffList1);
            log.info("update staffList1 result is: " + result);
            allTypeScoreService.deleteList(AllTypeScore.class, list);

            log.info("delete allTypeScore.size is: " + list.size());
            model.addAttribute("code", 0);

        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("delete allTypeScore error,id is  " + id);
            model.addAttribute("code", -6004);

        }

        return "/data/json";
    }


    /**
     * 3.修改
     *
     * @param request
     * @param response
     * @param model
     * @param allTypeScore
     * @return
     * @throws Exception
     */
    @ControllerAnnotation("031")
    @RequestMapping(value = "/a/u/allTypeScore", method = RequestMethod.PUT)
    public String updateAllTypeScoreJson(HttpServletRequest request,
                                         HttpServletResponse response, ModelMap model, @RequestBody AllTypeScore allTypeScore) throws Exception {

        log.info("update  allTypeScore= " + allTypeScore);
        if (DataUtils.isNullOrEmpty(allTypeScore)) {
            log.info("get allTypeScore is null！");
            model.addAttribute("code", -1000);
            return "common/fail";
        }
        Long adminId = Long.valueOf(cookieUtil.getKeyIdentity(request, CookieUtil.USER_ID));
        log.info("get adminId is : " + adminId);

        try {

            //只有职位需要改名称，其他四中存的id
            if (allTypeScore.getType() == ConstantItem.ZERO) {
                List<Staff> staffList = null;
                List<Long> staffIdList = null;
                Map<String, Object> param = null;
                AllTypeScore allTypeScore1 = null;

                if (DataUtils.isNullOrEmpty(allTypeScore.getId())) {
                    log.info("get allTypeScoreId is null！");
                    model.addAttribute("code", -1000);
                    return "common/fail";
                }


                allTypeScore1 = allTypeScoreService.getObjectById(allTypeScore.getId());
                log.info("get allTypeScore1Id is: " + allTypeScore1.getId());
                param = DynamicSQLUtil.getPositionNameList(allTypeScore1.getName());

                staffIdList = staffService.getIdsByDynamicCondition(Staff.class, param, ConstantItem.ZERO, Integer.MAX_VALUE);
                log.info("get staffIdList is: " + staffIdList);
                staffList = staffService.getObjectsByIds(staffIdList);
                log.info("get staffList.size is: " + staffList.size());

                for (Staff s : staffList) {
                    s.setPositionName(allTypeScore.getName());
                }
                boolean result = staffService.updateList(staffList);
                log.info("update staffList result is: " + result);
            }

            allTypeScore.setUpdateBy(adminId);


            boolean result = allTypeScoreService.update(allTypeScore);
            log.info("update allTypeScore id: " + allTypeScore.getId() + " result is: " + result);

            model.addAttribute("code", 0);


        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("update allTypeScore error,id is  " + allTypeScore.getId());
            model.addAttribute("code", -100000);

        }

        return "/data/json";
    }


    /**
     * 4.详情
     *
     * @param request
     * @param response
     * @param model
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/a/u/allTypeScore/{id}", method = RequestMethod.GET)
    public String getAllTypeScoreJson(HttpServletRequest request,
                                      HttpServletResponse response, ModelMap model, @PathVariable Long id)
            throws Exception {

        log.info("get data : id= " + id);
        if (DataUtils.isNullOrEmpty(id)) {
            log.info("get id is null！");
            model.addAttribute("code", -1000);
            return "common/fail";
        }
        try {

            AllTypeScore allTypeScore = allTypeScoreService.getObjectById(id);
            log.info("get allTypeScore data is " + allTypeScore);

            if (DataUtils.isNullOrEmpty(allTypeScore)) {
                log.info("get allTypeScore is null！");
                model.addAttribute("code", -1000);
                return "common/fail";
            }

            model.addAttribute("code", 0);
            model.addAttribute("allTypeScore", allTypeScore);

        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("get allTypeScore error,id is  " + id);
            model.addAttribute("code", -100000);
        }

        return "/json/allTypeScore/json/allTypeScoreDetailJson";
    }

    /**
     * 5.列表
     *
     * @param request
     * @param response
     * @param model
     * @param size
     * @param page
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/a/u/allTypeScore", method = RequestMethod.GET)
    public String getMultiAllTypeScoreJson(HttpServletRequest request,
                                           HttpServletResponse response, ModelMap model, Integer size, Integer page, Integer type)
            throws Exception {

        log.info("param= size is: " + size + " page is: " + page);
        if (page == null || page <= ConstantItem.ZERO) {
            page = ConstantItem.ONE;
        }
        if (size == null || size <= ConstantItem.ZERO) {
            size = ConstantItem.FIFTY;
        }
        int start = (page - ConstantItem.ONE) * size;
        if (start < ConstantItem.ZERO) {
            start = ConstantItem.ZERO;
        }

        List<Long> allTypeScoreIdList = null;

        List<Long> count = null;

        List<AllTypeScore> allTypeScoreList = null;

        Map<String, Object> param = null;

        param = DynamicSQLUtil.getAllTypeScore(type);

        try {

            allTypeScoreIdList = allTypeScoreService.getIdsByDynamicCondition(AllTypeScore.class, param, start, size);
            log.info("get allTypeScoreIdList is: " + allTypeScoreIdList);

            count = allTypeScoreService.getIdsByDynamicCondition(AllTypeScore.class, param, ConstantItem.ZERO, Integer.MAX_VALUE);
            log.info("get count is: " + count.size());


            allTypeScoreList = allTypeScoreService.getObjectsByIds(allTypeScoreIdList);
            log.info("get  allTypeScoreList.size  is " + allTypeScoreList.size());


            if (allTypeScoreList.size() == 0) {
                log.info("get allTypeScoreList is null！");
                model.addAttribute("code", -1000);
                return "common/fail";

            }
            model.addAttribute("code", 0);
            model.addAttribute("page", page);
            model.addAttribute("size", size);
            model.addAttribute("total", count.size());
            model.addAttribute("allTypeScoreList", allTypeScoreList);

        } catch (Throwable t) {
            log.error(t.getMessage());
            log.error("get allTypeScore error,id is  ");
            model.addAttribute("code", -100000);
        }

        return "/json/allTypeScore/json/allTypeScoreListJson";
    }


}

