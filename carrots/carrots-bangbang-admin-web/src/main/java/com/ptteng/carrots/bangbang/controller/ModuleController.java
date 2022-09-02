package com.ptteng.carrots.bangbang.controller;

import com.ptteng.carrots.bangbang.model.Module;
import com.ptteng.carrots.bangbang.service.ModuleService;
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

import javax.naming.Name;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Module  crud
 * 
 * @author magenm
 * @Date 2014-4-16 13:43
 * 
 */
@Controller
public class ModuleController {
	private static final Log log = LogFactory.getLog(ModuleController.class);

	@Autowired
	private ModuleService moduleService;


	/**
	 * 1.新增模块
	 * @param request
	 * @param response
	 * @param model
	 * @param module
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/a/u/module", method = RequestMethod.POST)
	public String addModuleJson(HttpServletRequest request,
								HttpServletResponse response, ModelMap model,
								Module module) throws Exception {

		if (DataUtils.isNullOrEmpty(module.getName())){
//			log.info(module.getName());
			log.error("必填信息为空或有误！");
			model.addAttribute("code", -8000);
			return "common/fail";
		}
//		if (DataUtils.isNullOrEmpty(module.getMenuId())) {
//			log.error("必填信息为空或有误！");
//			model.addAttribute("code", -6002);
//			return "common/fail";
//		}
//		if (	DataUtils.isNullOrEmpty(module.getUrl())) {
//			log.error("必填信息为空或有误！");
//			model.addAttribute("code", -6003);
//			return "common/fail";
//		}
//		if (DataUtils.isNullOrEmpty(module.getPid())) {
//			log.error("必填信息为空或有误！");
//			model.addAttribute("code", -6004);
//			return "common/fail";
//		}
//		if (DataUtils.isNullOrEmpty(module.getType())) {
//
//			log.error("必填信息为空或有误！");
//			model.addAttribute("code", -6005);
//			return "common/fail";
//		}

		log.info("新增模块 : module= " + module);

		Long adminId = null;
		try {
			adminId = util.CookieUtil.getAdminId(request);
			log.info("获取管理员ID成功！");
		} catch (Throwable t) {
			t.printStackTrace();
			log.error(t.getMessage());
			log.error("系统异常获取管理员ID失败");
			model.addAttribute("code", -5001);
			return "common/fail";
		}

		try {

			module.setCreateBy(adminId);
			module.setCreateAt(System.currentTimeMillis());
			moduleService.insert(module);
			model.addAttribute("code", "0");

		} catch (Throwable t) {
			t.printStackTrace();
			log.error(t.getMessage());
			log.error("add module error ");
			model.addAttribute("code", -6007);
		}

		return "common/insert";
	}

	/**
	 * 2.删除模块
	 * @param request
	 * @param response
	 * @param model
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/a/u/module/{id}", method = RequestMethod.DELETE)
	public String deleteModuleJson(HttpServletRequest request,
								   HttpServletResponse response, ModelMap model, @PathVariable Long id)
			throws Exception {

		log.info("delete module : id= " + id);
		try {
			moduleService.delete(id);

			log.info("add module success");
			model.addAttribute("code", "0");
			model.addAttribute("id", id);
			log.info("删除成功! ID为：" + id);

		} catch (Throwable t) {
			t.printStackTrace();
			log.error(t.getMessage());
			log.error("delete module error,id is  " + id);
			model.addAttribute("code", -6008);

		}

		return "/data/json";
	}


	/**
	 * 3.修改模块
	 *
	 * @param request
	 * @param response
	 * @param model
	 * @param module
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/a/u/module/{id}", method = RequestMethod.PUT)
	public String updateModuleJson(HttpServletRequest request, HttpServletResponse response,
								   ModelMap model, Module module, @PathVariable Long id) throws Exception {


		Long adminId = null;

		Module module1 = moduleService.getObjectById(id);

		module1.setName(module.getName());
		module1.setUrl(module.getUrl());
		module1.setType(module.getType());
		module1.setUpdateAt(System.currentTimeMillis());
		module1.setMenuId(module.getMenuId());
		module1.setPid(module.getPid());
		log.info("update module : module=:" + module);
		adminId = util.CookieUtil.getAdminId(request);
		log.info("获得管理员ID成功：" + adminId);
		module1.setUpdateBy(adminId);



//		if (DataUtils.isNullOrEmpty(module.getName()))
////				DataUtils.isNullOrEmpty(module.getType()) ||
////				DataUtils.isNullOrEmpty(module.getMenuId()) ||
////				DataUtils.isNullOrEmpty(module.getPid()) ||
////				DataUtils.isNullOrEmpty(module.getUrl()))
//{
//			log.error("必填内容为空！！！");
//			model.addAttribute("code", -6009);
//			return "common/fail";
//		}
//
//		log.info("update module : module= " + module);
//		Long adminID = null;
//		try {
//			adminID = util.CookieUtil.getAdminId(request);
//			log.info("获得管理员ID成功！：" + adminID);
//		} catch (Throwable t) {
//			t.printStackTrace();
//			log.error(t.getMessage());
//			log.error("系统异常，获得管理员ID失败");
//			model.addAttribute("code", -6010);
//			return "common/fail";
//		}
//
//		try {
//
//			Module module1 = moduleService.getObjectById(id);
//			module.setUpdateBy(adminID);
//			module.setUpdateAt(System.currentTimeMillis());
//			module.setCreateAt(module1.getCreateAt());
//			module.setCreateBy(module1.getCreateBy());
//
//			moduleService.update(module);
//			log.info("ID为：" + id + "module更新成功：" + module);
//
//			model.addAttribute("code", "0");
//
//
//			model.addAttribute("id", id);
//
//		} catch (Throwable t) {
//			t.printStackTrace();
//			log.error(t.getMessage());
//			log.error("update module error,id is  " + module.getId());
//			model.addAttribute("code", -6011);
//			return "common/fail";
//
//		}

		return "data/json";
	}


	/**
	 * 4.模块列表
	 *
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/a/u/module/search", method = RequestMethod.GET)
	public String getmoduleList(HttpServletRequest request,
								HttpServletResponse response, ModelMap model, Integer page,
								Integer size) throws Exception {
		if (page == null || page <= 0) {
			page = 1;
		}
		if (size == null || size <= 0) {
			size = 10;
		}
		int start = (page - 1) * size;


		log.info("");

		List<Long> ids = null;
		List<Module> moduleList = null;
		try {
			ids = moduleService.getModuleIds(start, 0);
			log.info("获得模块ids：" + ids);
		} catch (Throwable t) {
			t.printStackTrace();
			t.getMessage();
			log.error("系统错误，获得模块列表ids失败！");
			model.addAttribute("code", -6012);
			return "common/fail";
		}
		try {
			moduleList = moduleService.getObjectsByIds(ids);
			log.info("获得模块列表成：" + moduleList);
			model.addAttribute("code", "0");
			model.addAttribute("moduleList", moduleList);
		} catch (Throwable t) {
			t.getMessage();
			t.printStackTrace();
			log.error("系统错误，获得模块列表失败");
			model.addAttribute("code", -6013);
			return "common/fail";
		}


		return "carrots-bangbang-admin-service/module/json/moduleListJson";
	}

	/**
	 * 5.获得模块详情
	 * @param request
	 * @param response
	 * @param model
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/a/u/module/{id}", method = RequestMethod.GET)
	public String getModule(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, @PathVariable Long id)
			throws Exception {


		if(null != id){
			try {
				Module module = moduleService.getObjectById(id);
				model.addAttribute("code", "0");
				model.addAttribute("module", module);
			} catch (Throwable t) {
				t.printStackTrace();
				t.getMessage();
				log.error("获得ID为：" + id + "详情失败！");
				model.addAttribute("code", -6014);
				return "common/fail";
			}
		}else{
			model.addAttribute("id", 0);
		}

		return "/carrots-bangbang-admin-service/module/json/moduleDetailJson";
	}


	
	    
	

	
	
	
}

