package com.ptteng.score.admin.controller;

import com.google.gson.Gson;
import com.ptteng.score.admin.constant.ConstantItem;
import com.ptteng.score.admin.model.Department;
import com.ptteng.score.admin.model.Staff;
import com.ptteng.score.admin.responseStructure.Node;
import com.ptteng.score.admin.responseStructure.ResponseInfo;
import com.ptteng.score.admin.service.DepartmentService;
import com.ptteng.score.admin.service.StaffService;
import com.ptteng.score.admin.util.ControllerAnnotation;
import com.ptteng.score.admin.util.DepartmentTreeUtil;
import com.ptteng.score.admin.util.DynamicSQLUtil;
import com.ptteng.score.admin.util.GsonUtil;
import com.qding.common.util.DataUtils;
import com.qding.common.util.http.cookie.CookieUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * Department  crud
 *
 * @author magenm
 * @Date 2014-4-16 13:43
 */
@Controller
public class DepartmentController {
    private static final Log log = LogFactory.getLog(DepartmentController.class);

    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private CookieUtil cookieUtil;

    @Autowired
    private StaffService staffService;

    /**
     * 1.新增
     *
     * @param request
     * @param response
     * @param model
     * @return
     * @throws Exception
     */
    @ControllerAnnotation("050")
    @RequestMapping(value = "/a/u/department", method = RequestMethod.POST)
    public String addDepartmentJson(HttpServletRequest request,
                                    HttpServletResponse response, ModelMap model, @RequestBody Department department) throws Exception {

        if (DataUtils.isNullOrEmpty(department)) {
            log.info("get department is null！");
            model.addAttribute("code", -1000);
            return "common/fail";
        }
        log.info("add  department= " + department);
        Long adminId = Long.valueOf(cookieUtil.getKeyIdentity(request, CookieUtil.USER_ID));
        log.info("get adminId is : " + adminId);

        Long id = null;

        if (DataUtils.isNullOrEmpty(department.getParentId())) {
            log.info("get parentId is null！");
            model.addAttribute("code", -1000);
            return "common/fail";
        }
        log.info("get parentId is: " + department.getParentId());

        try {
            if (!department.getParentId().equals(ConstantItem.ZERO_ID)) {
                Department department1 = departmentService.getObjectById(department.getParentId());
                department1.setIsParent(ConstantItem.ONE);
                boolean result = departmentService.update(department1);
                log.info("update id: " + department1 + " result is: " + result);

            }
            department.setIsParent(ConstantItem.ZERO);

            department.setCreateBy(adminId);
            department.setUpdateBy(adminId);
            id = departmentService.insert(department);
            log.info("add department id is: " + id);
            model.addAttribute("code", 0);
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("add department error ");
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
    @RequestMapping(value = "/a/u/department", method = RequestMethod.DELETE)
    public String deleteDepartmentJson(HttpServletRequest request,
                                       HttpServletResponse response, ModelMap model, Long[] id)
            throws Exception {
        if (id != null && id.length == ConstantItem.ZERO) {
            log.info("get id is null！");
            model.addAttribute("code", -1000);
            return "common/fail";
        }

        log.info("delete department :id= " + id.length);
        List<Long> departmentIds = null;
        List<Department> departmentList = null;
        Set<Long> allTrueId = null;
        List<Long> allTrueIdList = new ArrayList<>();
        List<Long> idList = null;
        idList = Arrays.asList(id);
        List<Staff> staffList1 = new ArrayList<>();
        try {

            departmentIds = departmentService.getDepartmentIds(0, Integer.MAX_VALUE);
            log.info("get departmentIds is: " + departmentIds);

            departmentList = departmentService.getObjectsByIds(departmentIds);
            log.info("get departmentIds.size is: " + departmentList);

            for (Long longId : idList) {
                allTrueId = DepartmentTreeUtil.getAllTrueId(longId, departmentList);
                allTrueIdList.addAll(allTrueId);
            }
            //更新删除职位的员工的职位信息
            List<Long> staffIds = staffService.getStaffIds(ConstantItem.ZERO, Integer.MAX_VALUE);
            log.info("get staffIds is: " + staffIds);

            List<Staff> staffList = staffService.getObjectsByIds(staffIds);
            log.info("get staffList.size is: " + staffList.size());


            for (Staff s : staffList) {
                for (Long l : allTrueIdList) {
                    if (s.getDepartmentId() == l.longValue()) {
                        s.setDepartmentId(ConstantItem.MINUS_ID);
                        s.setDepartmentName(null);
                        staffList1.add(s);
                    }
                }
            }
            log.info("update staffList departmentName : " + staffList.size());
            boolean result = staffService.updateList(staffList1);
            log.info("update staffList1 result is: " + result);


            departmentService.deleteList(Department.class, allTrueIdList);
            log.info("delete department id is: " + allTrueIdList);
            model.addAttribute("code", 0);
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("delete department error,id is  " + id);
            model.addAttribute("code", -100000);

        }

        return "/data/json";
    }

    /**
     * 3.修改
     *
     * @param request
     * @param response
     * @param model
     * @param department
     * @return
     * @throws Exception
     */
    @ControllerAnnotation("051")
    @RequestMapping(value = "/a/u/department", method = RequestMethod.PUT)
    public String updateDepartmentJson(HttpServletRequest request,
                                       HttpServletResponse response, ModelMap model, @RequestBody Department department) throws Exception {

        if (DataUtils.isNullOrEmpty(department)) {
            log.info("get department is null！");
            model.addAttribute("code", -1000);
            return "common/fail";
        }
        log.info("update department : department= " + department);
        Long adminId = Long.valueOf(cookieUtil.getKeyIdentity(request, CookieUtil.USER_ID));
        log.info("get adminId is : " + adminId);
        List<Long> staffIds = null;
        List<Staff> staffList = null;
        Map<String, Object> param = null;
        try {
            //更新员工列表的部门名称
            Department department1 = departmentService.getObjectById(department.getId());
            param = DynamicSQLUtil.getDepartmentStaffList(department1.getName());
            log.info("get name is: " + department1.getName());

            staffIds = staffService.getIdsByDynamicCondition(Staff.class, param, ConstantItem.ZERO, Integer.MAX_VALUE);
            log.info("get staffIds is: " + staffIds);
            staffList = staffService.getObjectsByIds(staffIds);
            log.info("get staffList.size is: " + staffList.size());
            for (Staff s : staffList) {
                s.setDepartmentName(department.getName());
                s.setUpdateBy(adminId);
            }


            boolean resultt = staffService.updateList(staffList);
            log.info("update staffList result is: " + resultt);


            department.setUpdateBy(adminId);


            boolean result = departmentService.update(department);
            log.info("update  departmentName id: " + department.getId() + " result is: " + result);

            model.addAttribute("code", 0);


        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("update department error,id is  " + department.getId());
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
    @RequestMapping(value = "/a/u/department/{id}", method = RequestMethod.GET)
    public String getDepartmentJson(HttpServletRequest request,
                                    HttpServletResponse response, ModelMap model, @PathVariable Long id)
            throws Exception {

        if (DataUtils.isNullOrEmpty(id)) {
            log.info("get id is null！");
            model.addAttribute("code", -1000);
            return "common/fail";
        }
        log.info("get data : id= " + id);

        try {
            Department department = departmentService.getObjectById(id);
            log.info("get department data is " + department);
            if (DataUtils.isNullOrEmpty(department)) {
                log.info("get department is null！");
                model.addAttribute("code", -1000);
                return "common/fail";
            }

            model.addAttribute("code", 0);

            model.addAttribute("department", department);

        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("get department error,id is  " + id);
            model.addAttribute("code", -100000);
        }

        return "/json/department/json/departmentDetailJson";
    }

    /**
     * 5.列表
     *
     * @param request
     * @param response
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/a/u/department", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    public String getDepartmentListJson(HttpServletRequest request,
                                        HttpServletResponse response, ModelMap model)
            throws Exception {
        /**
         *@Description:查询部门列表
         */

        try {
            List<Long> departmentIds = departmentService.getDepartmentIds(0, Integer.MAX_VALUE);
            log.info("get departmentIds is: " + departmentIds);

            List<Department> departmentList = departmentService.getObjectsByIds(departmentIds);
            log.info("get departmentList.size is: " + departmentList.size());

            List<Department> departmentList1 = new ArrayList<>();
            for (Department department : departmentList) {
                if (department.getParentId() == ConstantItem.ZERO_ID.longValue()) {
                    departmentList1.add(department);
                }
            }
            List<Node> nodes = DepartmentTreeUtil.recursionQuery(departmentList1, departmentList);
            return GsonUtil.getUnerializeNullsGson().toJson(new ResponseInfo(nodes));
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            model.addAttribute("code", -100000);
            return "common/fail";
        }
    }

    public static List<Node> recursionQuery(List<Department> parentlist, List<Department> allList) {
        /**
         *@Author hfismyangel@163.com
         *@Description:递归生成树形结构部门分级
         *@Date: 20:19 2017/9/28
         * @param parentlist
         * @param allList
         */
        List resultList = new ArrayList<>();
        for (Department department : parentlist) {
            //如果是父节点。DB中由isParent字段，从pojo中获取参数判断是否父节点
            if (department.getIsParent() == ConstantItem.ONE) {
                Node node = new Node();
                //详见json结构体，
                node.setId(department.getId());
                node.setName(department.getName());
                List<Department> list1 = new ArrayList<>();
                for (Department department1 : allList) {
                    if (department.getId() == department1.getParentId().longValue()) {
                        list1.add(department1);
                    }
                }
                node.setNode(recursionQuery(list1, allList));
                //把node添加到列表
                resultList.add(node);
            } else {
                //如果是叶子节点
                Node node = new Node();
                node.setId(department.getId());
                node.setName(department.getName());
                resultList.add(node);
            }
        }
        return resultList;
    }

}

