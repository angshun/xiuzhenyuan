package com.ptteng.score.admin.controller;

import com.ptteng.score.admin.constant.ConstantItem;
import com.ptteng.score.admin.model.Task;
import com.ptteng.score.admin.service.DepartmentService;
import com.ptteng.score.admin.service.TaskService;
import com.ptteng.score.admin.util.ControllerAnnotation;
import com.ptteng.score.admin.util.DynamicSQLUtil;
import com.ptteng.score.admin.util.GsonUtil;
import com.ptteng.score.admin.util.PageUtil;
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
import java.util.stream.Collectors;

/**
 * Task  crud
 *
 * @author magenm
 * @Date 2014-4-16 13:43
 */
@Controller
public class TaskController {
    private static final Log log = LogFactory.getLog(TaskController.class);


    @Autowired
    private TaskService taskService;
    @Autowired
    private CookieUtil cookieUtil;
    @Autowired
    private DepartmentService departmentService;
    /**
     * @param
     * @return
     */
    @ControllerAnnotation("001")
    @RequestMapping(value = "/a/u/task", method = RequestMethod.GET)
    public String getTaskList(HttpServletRequest request,
                              HttpServletResponse response, ModelMap model, Integer page, Integer size, Integer orderBy, Long taskType, Long scoreType, Long project, Long startAt, Long endAt) throws Exception {
        /**
         *@Description:动态查询任务列表
         *
         */

        log.info("=========get task list =========");

        if (page == null) {
            page = ConstantItem.ONE;
        }
        if (size == null) {
            size = ConstantItem.FIFTY;
        }
        int start = (page - ConstantItem.ONE) * size;
        if (start < ConstantItem.ZERO) {
            start = ConstantItem.ZERO;
        }

        log.info("pageList : page= " + start + " , size=" + size);

        try {
            Long adminId = Long.valueOf(cookieUtil.getKeyIdentity(request, CookieUtil.USER_ID));
            log.info("user id" + adminId);
            log.info("参数：" + "page" + page + "size" + size + "taskType" + taskType + "scoreType" + scoreType + "project" + project + "startAt" + startAt + "endAt" + endAt);
            if (null == orderBy) {
                orderBy = ConstantItem.ZERO;
            }
            //拼接动态条件
            Map<String, Object> map = DynamicSQLUtil.searchTask(taskType, scoreType, project, startAt, endAt, orderBy);
            List<Long> count = taskService.getIdsByDynamicCondition(Task.class, map, ConstantItem.ZERO, Integer.MAX_VALUE);
            log.info("get total list size:" + count.size());
            //分页
            PageUtil pageUtil = new PageUtil(page, size);
            List<Long> pageList = count.stream().skip(pageUtil.getStart()).limit(pageUtil.getSize()).collect(Collectors.toList());
            log.info("get pageList size:" + pageList.size());
            //查询任务实体
            List<Task> taskList = taskService.getObjectsByIds(pageList);
            log.info("get taskList.size is: " + taskList.size());
            //出参返回
            model.addAttribute("code", 0);
            model.addAttribute("page", pageUtil.getPage());
            model.addAttribute("size", pageUtil.getSize());
            model.addAttribute("total", count.size());
            model.addAttribute("taskList", taskList);
            return "json/task/json/taskListJson";
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            model.addAttribute("code", -100000);
            return "common/fail";
        }
    }

    @ControllerAnnotation("001")
    @RequestMapping(value = "/a/u/task", method = RequestMethod.POST)
    public String addTask(HttpServletRequest request,
                          HttpServletResponse response, ModelMap model,
                          @RequestBody String task)
            throws Exception {
        /**
         *@Description:新增任务
         */
        try {
            //参数判空
            if (null == task) {
                model.addAttribute("code", -1000);
                return "common/fail";
            }
            //拼装任务实体
            Task taskJson = GsonUtil.getUnerializeNullsGson().fromJson(task, Task.class);
            //判断任务类型
            if (taskJson.getTaskType() == ConstantItem.ZERO) {
                taskJson.setNumber(null);
                taskJson.setStartAt(null);
                taskJson.setEndAt(null);
            }
            if (taskJson.getTaskType() == ConstantItem.ONE) {
                taskJson.setStartAt(null);
                taskJson.setEndAt(null);
            }
            log.info("参数：task=" + taskJson.getId() + taskJson.getTitle());
            //插入数据库
            Long adminId = Long.valueOf(cookieUtil.getKeyIdentity(request, CookieUtil.USER_ID));
            log.info("get user id :" + adminId);
            taskJson.setCreateBy(adminId);
            taskJson.setUpdateBy(adminId);
            taskJson.setTaskStatus(ConstantItem.ZERO);
            taskJson.setJoinNum(ConstantItem.ZERO);
            taskJson.setApproveStatus(ConstantItem.ZERO);
            taskJson.setStatus(ConstantItem.ONE);
            taskJson.setTimes(ConstantItem.ZERO);


            //默认选择所有部门
            List<Long> idList = departmentService.getDepartmentIds(0, Integer.MAX_VALUE);
            //拼装可见部门id字符串
            StringBuilder stringBuilder = new StringBuilder();
            for (Long ids : idList) {
                stringBuilder.append(ids + ",");
            }
            stringBuilder.delete(stringBuilder.length() - ConstantItem.ONE, stringBuilder.length());
            log.info("department Visual  : id= " + stringBuilder.toString());
            //插入可见部门
            taskJson.setVisualDepartment(stringBuilder.toString());
            //执行修改



            Long insert = taskService.insert(taskJson);
            log.info("add taskId: " + insert);
            model.addAttribute("code", 0);
            return "/data/json";
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            model.addAttribute("code", -100000);
            return "common/fail";
        }
    }

    @ControllerAnnotation("002")
    @RequestMapping(value = "/a/u/task", method = RequestMethod.PUT)
    public String updateTask(HttpServletRequest request,
                             HttpServletResponse response, ModelMap model, @RequestBody Task taskJson)
            throws Exception {
        /**
         *@Description:修改任务
         */
        if (DataUtils.isNullOrEmpty(taskJson)) {
            log.error("get task is null");
            model.addAttribute("code", -1000);
            return "common/fail";
        }
        try {
            //拼装任务实体
//            Task taskJson = GsonUtil.getUnerializeNullsGson().fromJson(task, Task.class);
            //判断任务类型
            if (taskJson.getTaskType() == ConstantItem.ZERO) {
                taskJson.setNumber(null);
                taskJson.setStartAt(null);
                taskJson.setEndAt(null);
            }
            if (taskJson.getTaskType() == ConstantItem.ONE) {
                taskJson.setStartAt(null);
                taskJson.setEndAt(null);
            }
            //获取身份信息
            Long adminId = Long.valueOf(cookieUtil.getKeyIdentity(request, CookieUtil.USER_ID));
            taskJson.setUpdateBy(adminId);
            boolean update = taskService.update(taskJson);
            //更新失败
            if (!update) {
                model.addAttribute("code", -100000);
                return "common/fail";
            }
            model.addAttribute("code", 0);
            return "/data/json";
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            model.addAttribute("code", -100000);
            return "common/fail";
        }
    }

    @ControllerAnnotation("003")
    @RequestMapping(value = "/a/u/task", method = RequestMethod.DELETE)
    public String deleteTask(HttpServletRequest request,
                             HttpServletResponse response, ModelMap model, Long[] id) throws Exception {
        /**
         *@Description:删除任务
         */
        try {
            log.info("============id size>>" + id.length);//参数判空
            if (id != null && id.length == ConstantItem.ZERO) {
                log.info("get id is null！");
                model.addAttribute("code", -1000);
                return "common/fail";
            }
            //数组转为list
            List<Long> list = Arrays.asList(id);
            log.info("delete task : task size： " + list.size());
            taskService.deleteList(Task.class, list);

            model.addAttribute("code", 0);
            return "/data/json";
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            model.addAttribute("code", -100000);
            return "common/fail";
        }
    }

    @RequestMapping(value = "/a/u/task/{id}", method = RequestMethod.GET)
    public String getTask(HttpServletRequest request,
                          HttpServletResponse response, ModelMap model, @PathVariable Long id) throws Exception {
        /**
         *@Description:查询单条任务信息
         */
        try {
            log.info("get task : taskId= " + id);
            //参数判空
            if (null == id) {
                model.addAttribute("code", -1000);
                return "common/fail";
            }
            //执行查询
            Task task = taskService.getObjectById(id);
            if (task == null) {
                model.addAttribute("code", -100000);
                return "common/fail";
            }
            log.info("get task:" + task);
            model.addAttribute("code", 0);
            model.addAttribute("task", task);
            return "json/task/json/taskDetailJson";
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            model.addAttribute("code", -100000);
            return "common/fail";
        }
    }

    @RequestMapping(value = "/a/u/taskVisual", method = RequestMethod.PUT)
    public String editDepartmentVisual(HttpServletRequest request,
                                       HttpServletResponse response, ModelMap model, Long[] visualDepartment, Long id)
            throws Exception {
        /**
         *@Description:设置部门可见性
         */
        try {
            //参数判空
            log.info("get id :" + id);
            if (null == id) {
                model.addAttribute("code", -1000);
                return "common/fail";
            }
            List<Long> idList = Arrays.asList(visualDepartment);
            //拼装可见部门id字符串
            StringBuilder stringBuilder = new StringBuilder();
            for (Long ids : idList) {
                stringBuilder.append(ids + ",");
            }
            stringBuilder.delete(stringBuilder.length() - ConstantItem.ONE, stringBuilder.length());
            log.info("department Visual  : id= " + stringBuilder.toString());
            //修改相应字段
            Task task = taskService.getObjectById(id);
            task.setVisualDepartment(stringBuilder.toString());
            //执行修改
            boolean update = taskService.update(task);
            if (!update) {
                model.addAttribute("code", -100000);
                return "common/fail";
            }
            model.addAttribute("code", 0);
            return "/data/json";
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            model.addAttribute("code", -100000);
            return "common/fail";
        }
    }

    @ControllerAnnotation("000")
    @RequestMapping(value = "/a/u/task/status/{id}", method = RequestMethod.PUT)
    public String updateTaskStatus(HttpServletRequest request,
                                   HttpServletResponse response, ModelMap model, @PathVariable Long id) throws Exception {
        /**
         @Description:修改任务状态
         */
        try {
            //数组转为list
            log.info("put task status : task= " + id);
            //参数判空
            if (null == id) {
                model.addAttribute("code", -1000);
                return "common/fail";
            }
            Task task = taskService.getObjectById(id);
            //更改状态
            if (task.getStatus() == ConstantItem.ONE) {
                task.setStatus(ConstantItem.ZERO);
            } else {
                task.setStatus(ConstantItem.ONE);
            }
            //获取操作人身份并设置
            Long adminId = Long.valueOf(cookieUtil.getKeyIdentity(request, CookieUtil.USER_ID));
            task.setUpdateBy(adminId);

            //更新操作
            boolean result = taskService.update(task);
            log.info("update taskId is: " + task.getId() + " result is: " + result);
            model.addAttribute("code", 0);
            return "/data/json";
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            model.addAttribute("code", -100000);
            return "common/fail";
        }
    }


    @RequestMapping(value = "/a/u/taskVisual/{id}", method = RequestMethod.GET)
    public String editDepartmentVisual(HttpServletRequest request,
                                       HttpServletResponse response, ModelMap model, @PathVariable Long id)
            throws Exception {
        /**
         *@Description:获取单独的任务可见性
         */
        try {
            log.info("=========task id>>" + id);
            //参数判空
            if (null == id) {
                model.addAttribute("code", -1000);
                return "common/fail";
            }
            Task task = taskService.getObjectById(id);
            if (null == task) {
                model.addAttribute("code", -100000);
                return "common/fail";
            }
            String visualDepartment = task.getVisualDepartment() == null ? "0" : task.getVisualDepartment();
            //字符串处理

            String[] split = visualDepartment.split(",");
            List<Integer> list = new ArrayList<>();
            //切割为整型加入list
            for (String s : split) {
                list.add(Integer.valueOf(s));
            }
            log.info("=========get list size>>" + list.size());
            model.addAttribute("code", 0);
            model.addAttribute("taskVisual", list);
            return "json/othersJsp/json/taskDetailJson";
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            model.addAttribute("code", -100000);
            return "common/fail";
        }
    }
}

