package com.ptteng.score.admin.controller;

import com.ptteng.score.admin.constant.ConstantItem;
import com.ptteng.score.admin.model.Manager;
import com.ptteng.score.admin.model.Role;
import com.ptteng.score.admin.service.ManagerService;
import com.ptteng.score.admin.service.RoleService;
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
import java.util.*;

/**
 * Manager  crud
 *
 * @author magenm
 * @Date 2014-4-16 13:43
 *
 */
@Controller
public class ManagerController {
	private static final Log log = LogFactory.getLog(ManagerController.class);

	@Autowired
	private ManagerService managerService;

	@Autowired
	private CookieUtil cookieUtil;

	@Autowired
	private RoleService roleService;


	/**
	 * 1.新增
	 *
	 * @param request
	 * @param response
	 * @param model
	 * @param manager
	 * @return
	 * @throws Exception
	 */
	@ControllerAnnotation("081")
	@RequestMapping(value = "/a/u/manager", method = RequestMethod.POST)
	public String addManagerJson(HttpServletRequest request,
								 HttpServletResponse response, ModelMap model, @RequestBody Manager manager) throws Exception {

		log.info("get manager is : " + manager);

		if (DataUtils.isNullOrEmpty(manager.getName())) {

			model.addAttribute("code", -5007);
			return "common/fail";
		}
		if (DataUtils.isNullOrEmpty(manager.getPwd())) {

			model.addAttribute("code", -5008);
			return "common/fail";
		}

		Long adminId = Long.valueOf(cookieUtil.getKeyIdentity(request, com.qding.common.util.http.cookie.CookieUtil.USER_ID));

		String encodePass = com.gemantic.common.util.PasswordUtils.encode(manager.getPwd());

		log.info("pwd encrypt is: " + encodePass);

		try {
			manager.setId(null);
			manager.setUpdateBy(adminId);
			manager.setCreateBy(adminId);
			manager.setPwd(encodePass);

			Long id = managerService.insert(manager);
			log.info("insert manager id is: " + id);

			model.addAttribute("code", 0);
		} catch (Throwable t) {
			t.printStackTrace();
			log.error(t.getMessage());
			log.error("add manager error ");
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
	@ControllerAnnotation("082")
	@RequestMapping(value = "/a/u/manager/{id}", method = RequestMethod.DELETE)
	public String deleteManagerJson(HttpServletRequest request,
									HttpServletResponse response, ModelMap model, @PathVariable Long id)
			throws Exception {

		if (DataUtils.isNullOrEmpty(id)) {
			log.info("get id is null！");
			model.addAttribute("code", -1000);
			return "common/fail";
		}
		log.info("delete manager id is " + id);
		try {
			boolean result = managerService.delete(id);

			log.info("delete manager result: " + result);
			model.addAttribute("code", 0);

		} catch (Throwable t) {
			t.printStackTrace();
			log.error(t.getMessage());
			log.error("delete manager error,id is  " + id);
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
	 * @param manager
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@ControllerAnnotation("083")
	@RequestMapping(value = "/a/u/manager/{id}", method = RequestMethod.PUT)
	public String updateManagerJson(HttpServletRequest request,
									HttpServletResponse response, ModelMap model,
									@RequestBody Manager manager,
									@PathVariable Long id) throws Exception {


		if (DataUtils.isNullOrEmpty(manager)) {
			model.addAttribute("code", -1000);
			return "common/fail";
		}
		if (DataUtils.isNullOrEmpty(manager.getName())) {

			model.addAttribute("code", -5007);
			return "common/fail";
		}
		if (DataUtils.isNullOrEmpty(manager.getPwd())) {

			model.addAttribute("code", -5008);
			return "common/fail";
		}
		log.info("update manager is : " + manager);

		Long adminId = Long.valueOf(cookieUtil.getKeyIdentity(request, com.qding.common.util.http.cookie.CookieUtil.USER_ID));

		try {

			Manager manager1 = managerService.getObjectById(id);
			log.info("get manager1 is : " + manager1);

			String oldPwd = com.gemantic.common.util.PasswordUtils.encode(manager1.getPwd());
			log.info("get old pwdd is : " + oldPwd);
			manager.setCreateAt(manager1.getCreateAt());
			manager.setCreateBy(manager1.getCreateBy());
			manager.setUpdateBy(adminId);
			manager.setId(manager1.getId());

			String encodePass = com.gemantic.common.util.PasswordUtils.encode(manager.getPwd());
			manager.setPwd(encodePass);
			log.info("get newPwd is : " + encodePass);

			boolean result =  managerService.update(manager);
			log.info("update manager result is : " + result);

			model.addAttribute("code", 0);


		} catch (Throwable t) {
			t.printStackTrace();
			log.error(t.getMessage());
			log.error("update manager error,id is  " + manager.getId());
			model.addAttribute("code", -100000);

		}

		return "/data/json";
	}


	/**
	 * 4.列表搜索
	 *
	 * @param request
	 * @param response
	 * @param model
	 * @param
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/a/u/manager/search", method = RequestMethod.GET)
	public String getMultiManagerJson(HttpServletRequest request,
									  HttpServletResponse response, ModelMap model, Integer roleId, String name, Integer page, Integer size)
			throws Exception {

		log.info("param is =rid is: " + roleId + " name is: " + name + " page is: " + page + " size is:" + size);
		if (page == null || page <= ConstantItem.ZERO) {
			page = 1;
		}
		if (size == null || size <= ConstantItem.ZERO) {
			size = ConstantItem.FIFTY;
		}
		int start = (page - ConstantItem.ONE) * size;
		if (start < ConstantItem.ZERO) {
			start = ConstantItem.ZERO;
		}
		log.info("page is:" + page + " size is :" + size + " start is :" + start);

		List<Long> managerIdList = null;

		List<Long> count = null;

		List<Manager> managerList = null;

		Map<String, Object> param = null;

		List<Role> roleList = null;

		HashSet<Long> roleListSet = new HashSet<>();


		List<Map<String, Object>> managerDataList = new ArrayList<>();


		List<Long> ridList = new ArrayList<>();



		param = DynamicSQLUtil.getManagerList(roleId, name);

		try {

			managerIdList = managerService.getIdsByDynamicCondition(Manager.class, param, start, size);
			log.info("get  managerIdList.size  is: " + managerIdList.size());

			count = managerService.getIdsByDynamicCondition(Manager.class, param, ConstantItem.ZERO, Integer.MAX_VALUE);
			log.info("get count is :" + count);

			managerList = managerService.getObjectsByIds(managerIdList);
			log.info("get managerList.size is:" + managerIdList.size());


			for (Manager m : managerList) {
				Long id = m.getRoleId();
				roleListSet.add(id);
			}
			ridList.addAll(roleListSet);
			log.info("get ridList is : " + ridList);
			roleList = roleService.getObjectsByIds(ridList);
			log.info("get roleList.size is : " + roleList.size());


			for (Manager m : managerList) {
				for (Role r : roleList) {
					if (m.getRoleId().equals(r.getId())) {

						Map<String, Object> managerData = new HashMap<>();
						managerData.put("roleName", r.getName());
						managerData.put("roleId", r.getId());
						managerData.put("name", m.getName());
						managerData.put("id", m.getId());
						managerData.put("createAt", m.getCreateAt());
						for (Manager manager : managerList) {

							if (m.getCreateBy().equals(manager.getId())) {
								managerData.put("createBy", manager.getName());
							}

							if (m.getUpdateBy().equals(manager.getId())) {
								managerData.put("updateBy", manager.getName());
							}
						}

						managerData.put("updateAt", m.getUpdateAt());

						managerDataList.add(managerData);
					}
				}
			}


			model.addAttribute("code", 0);
			model.addAttribute("page", page);
			model.addAttribute("size", size);
			model.addAttribute("total", count.size());
			model.addAttribute("managerList", managerDataList);

		} catch (Throwable t) {
			log.error(t.getMessage());
			log.error("get manager error,id is  " + managerList.size());
			model.addAttribute("code", -100000);
		}

		return "json/manager/json/managerListJson";
	}

	/**
	 * 5.详情
	 *
	 * @param request
	 * @param response
	 * @param model
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/a/u/manager/{id}", method = RequestMethod.GET)
	public String getManagerJson(HttpServletRequest request,
								 HttpServletResponse response, ModelMap model, @PathVariable Long id)
			throws Exception {

		log.info("get manager  id= " + id);
		try {
			Manager manager = managerService.getObjectById(id);
			log.info("get manager data is " + manager);

			model.addAttribute("code", 0);

			model.addAttribute("manager", manager);

		} catch (Throwable t) {
			t.printStackTrace();
			log.error(t.getMessage());
			log.error("get manager error,id is  " + id);
			model.addAttribute("code", -100000);
		}

		return "json/manager/json/managerDetailJson";
	}

	/**
	 * 6.密码修改
	 *
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/a/u/pwd", method = RequestMethod.PUT)
	public String updateManagerPassword(HttpServletRequest request,
										HttpServletResponse response, ModelMap model, String oldPwd, String newPwd) throws Exception {
		log.info("get oldPwd is : " + oldPwd + " newPwd is : " + newPwd);

		Long uid = Long.valueOf(cookieUtil.getKeyIdentity(request,
				com.qding.common.util.http.cookie.CookieUtil.USER_ID));

		if (oldPwd == null || newPwd == null || oldPwd.trim().equals("") || newPwd.trim().equals("")) {
			log.info(" pwd  is null");
			model.addAttribute("code", -1004);
			return "/data/json";
		}

		if (oldPwd.length() > ConstantItem.TWO_HUNDRED || oldPwd.length() < 0 || newPwd.length() > ConstantItem.TWO_HUNDRED || newPwd.length() < ConstantItem.ZERO) {
			log.info(" pwd  is null");
			model.addAttribute("code", -5012);
			return "/data/json";
		}

		String oldPwdEncode = com.gemantic.common.util.PasswordUtils.encode(oldPwd);

		Manager u = managerService.getObjectById(uid);
		log.info("get manager is : " + u);

		log.info("输入的旧密码：" + oldPwdEncode);
		log.info("数据库的旧密码：" + u.getPwd());

		if (u.getPwd().equals(oldPwdEncode)) {
			String newPwd1 = com.gemantic.common.util.PasswordUtils.encode(newPwd);
			log.info("新密码：" + newPwd1);
			u.setPwd(newPwd1);
			u.setUpdateBy(uid);
			boolean result = managerService.update(u);
			log.info("update pwd result is : " + result);

			model.addAttribute("code", 0);
		} else {

			model.addAttribute("code", -5006);
			model.addAttribute("result", "你输入的旧密码有误！");
		}

		return "/data/json";
	}


	/**
	 * 6.批量获取用户详细信息
	 *
	 * @param request
	 * @param response
	 * @param model
	 * @param ids
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/a/u/multi/manager", method = RequestMethod.GET)
	public String getAllManagerJson(HttpServletRequest request,
									HttpServletResponse response, ModelMap model, Long[] ids)
			throws Exception {

		log.info("get data : ids= " + ids);
		List<Long> idList = new ArrayList();
		if (ids == null || ids.length <= 0) {
			model.addAttribute("code", 0);
			model.addAttribute("size", 0);
			model.addAttribute("total", 0);

		} else {
			idList = Arrays.asList(ids);
		}
		try {

			if (idList == null || idList.size() <= ConstantItem.ZERO) {
				model.addAttribute("code", 0);
				model.addAttribute("size", 0);
				model.addAttribute("total", 0);
			} else {
				List<Manager> managerList = managerService.getObjectsByIds(idList);
				log.info("get manager data is " + managerList);


				model.addAttribute("code", 0);
				model.addAttribute("size", 0);
				model.addAttribute("total", managerList.size());
				model.addAttribute("ManagerList", managerList);


			}
		} catch (Throwable t) {
			log.error(t.getMessage());
			log.error("get manager error,ids is  " + idList);
			model.addAttribute("code", -100000);
		}

		return "/json/Manager/json/ManagerListJson";
	}





}

