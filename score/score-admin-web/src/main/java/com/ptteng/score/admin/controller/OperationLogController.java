package com.ptteng.score.admin.controller;

import com.ptteng.score.admin.constant.ConstantItem;
import com.ptteng.score.admin.model.OperationLog;
import com.ptteng.score.admin.service.OperationLogService;
import com.ptteng.score.admin.util.PageUtil;
import com.qding.common.util.DataUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.stream.Collectors;

/**
 * OperationLog  crud
 *
 * @author magenm
 * @Date 2014-4-16 13:43
 */
@Controller
public class OperationLogController {
    private static final Log log = LogFactory.getLog(OperationLogController.class);

    @Autowired
    private OperationLogService operationLogService;


    /**
     * @param
     * @return
     */

    @RequestMapping(value = "/a/u/operationLog", method = RequestMethod.GET)
    public String getoperationLogList(HttpServletRequest request,
                                      HttpServletResponse response, ModelMap model, Integer page, Integer size) throws Exception {
        /**
         *@Description:操作日志
         */
        log.info("入参: " + "page" + page + "size" + size);
        try {
            List<Long> operationLogIds = operationLogService.getOperationLogIds(ConstantItem.ZERO, Integer.MAX_VALUE);
            log.info("get operationLogIds is: "+operationLogIds);
            //分页，page，size判空处理
            PageUtil pageUtil = new PageUtil(page, size);
            List<Long> pageList = operationLogIds.stream().skip(pageUtil.getStart()).limit(pageUtil.getSize()).collect(Collectors.toList());
            log.info("分页后长度: " + pageList.size());
            //查询
            List<OperationLog> operationLogList = operationLogService.getObjectsByIds(pageList);
            if (DataUtils.isNullOrEmpty(operationLogList)) {
                log.error("get opreationLogList is null！");
                model.addAttribute("code", -1000);
                return "common/fail";
            }
            log.info("get operationLogList.size is: " + operationLogList.size());
            model.addAttribute("code", 0);
            model.addAttribute("page", pageUtil.getPage());
            model.addAttribute("size", pageUtil.getSize());
            model.addAttribute("total", operationLogIds.size());
            model.addAttribute("operationLogList", operationLogList);
            return "json/operationLog/json/operationLogListJson";
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("get operationLog error ");
            model.addAttribute("code", -100000);
            return "common/fail";        }
    }
}

