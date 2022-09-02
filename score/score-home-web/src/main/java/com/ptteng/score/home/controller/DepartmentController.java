package com.ptteng.score.home.controller;

import com.ptteng.score.home.constant.ConstantItem;
import com.ptteng.score.home.model.Department;
import com.ptteng.score.home.responseStructure.Node;
import com.ptteng.score.home.responseStructure.ResponseInfo;
import com.ptteng.score.home.service.DepartmentService;
import com.ptteng.score.home.util.DepartmentTreeUtil;
import com.ptteng.score.home.util.GsonUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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


    @RequestMapping(value = "/a/u/organize", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    public String getDepartmentListJson(HttpServletRequest request,
                                        HttpServletResponse response, ModelMap model)
            throws Exception {
        /***
         * @Description:查询部门
         */
        log.info("get /a/u/organize ");
        try {
            List<Long> departmentIds = departmentService.getDepartmentIds(ConstantItem.ZERO, Integer.MAX_VALUE);
            List<Department> list = departmentService.getObjectsByIds(departmentIds);

            log.info("get departmentIds list size:" + list.size());
            List<Department> list1 = new ArrayList<>();
            for (Department department : list) {
                if (Objects.equals(department.getParentId(), ConstantItem.ZEROL)) {
                    list1.add(department);
                }
            }
            List<Node> nodes = DepartmentTreeUtil.recursionQuery(list1, list);

            log.info("get nodes size:" + nodes.size());

            return GsonUtil.getUnerializeNullsGson().toJson(new ResponseInfo(nodes));
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            model.addAttribute("code", -10000);
            return "common/fail";
        }

    }

}

