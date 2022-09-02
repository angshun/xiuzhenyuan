package com.ptteng.score.admin.controller;

import com.ptteng.score.admin.model.RoleModule;
import com.ptteng.score.admin.service.RoleModuleService;
import com.qding.common.util.DataUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * RoleModule  crud
 * 
 * @author magenm
 * @Date 2014-4-16 13:43
 * 
 */
@Controller
public class RoleModuleController {
	private static final Log log = LogFactory.getLog(RoleModuleController.class);

	@Autowired
	private RoleModuleService roleModuleService;






    /**
	 * 
	 * @param
	 * @return
	 *
	 *
	 */

	@RequestMapping(value = "/c/roleModule", method = RequestMethod.GET)
	public String getroleModuleList(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {

		
		
		log.info("/roleModule  to /roleModule/view/roleModuleList");

		return "/score-home-service/roleModule/view/roleModuleList";
	}
    
    

    
	
	@RequestMapping(value = "/c/roleModule/{id}", method = RequestMethod.GET)
	public String getRoleModule(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, @PathVariable Long id)
			throws Exception {

		log.info("/roleModule/" + id + "  to /roleModule/view/roleModuleDeail");
		if(null != id){
			model.addAttribute("id", id);
		}else{
			model.addAttribute("id", 0);
		}

		return "/score-home-service/roleModule/view/roleModuleDetail";
	}
	
	
	
	    
	

	@RequestMapping(value = "/a/roleModule/{id}", method = RequestMethod.GET)
	public String getRoleModuleJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, @PathVariable Long id)
			throws Exception {

		if (DataUtils.isNullOrEmpty(id)) {
			log.info("get id is null！");
			model.addAttribute("code", -1000);
			return "common/fail";
		}
		log.info("get data : id= " + id);

		try {
			RoleModule roleModule = roleModuleService.getObjectById(id);
			log.info("get roleModule data is " + roleModule);

			model.addAttribute("code", 0);

			model.addAttribute("roleModule", roleModule);

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("get roleModule error,id is  " + id);
			model.addAttribute("code", -100000);
		}

		return "/score-home-service/roleModule/json/roleModuleDetailJson";
	}

//	@RequestMapping(value = "/a/roleModule/{id}", method = RequestMethod.PUT)
//	public String updateRoleModuleJson(HttpServletRequest request,
//			HttpServletResponse response, ModelMap model, RoleModule roleModule) throws Exception {
//
//		if (DataUtils.isNullOrEmpty(roleModule)) {
//			log.info("get id is null！");
//			model.addAttribute("code", -1000);
//			return "common/fail";
//		}
//		log.info("update roleModule : roleModule= " + roleModule);
//
//		try {
//
//			roleModuleService.update(roleModule);
//
//			model.addAttribute("code", 0);
//
//			model.addAttribute("roleModule", roleModule);
//
//		} catch (Throwable t) {
//		    t.printStackTrace();
//			log.error(t.getMessage());
//			log.error("update roleModule error,id is  " + roleModule.getId());
//			model.addAttribute("code", -6003);
//
//		}
//
//		return "/data/json";
//	}

	@RequestMapping(value = "/a/roleModule", method = RequestMethod.POST)
	public String addRoleModuleJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, RoleModule roleModule) throws Exception {

		if (DataUtils.isNullOrEmpty(roleModule)) {
			log.info("get roleModule is null！");
			model.addAttribute("code", -1000);
			return "common/fail";
		}
		
		log.info("update roleModule : roleModule= " + roleModule);
		
		try { 
			roleModule.setId(null);

			roleModuleService.insert(roleModule);

			model.addAttribute("code", 0);
		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("add roleModule error ");
			model.addAttribute("code", -6002);
		}

		return "/data/json";
	}

	@RequestMapping(value = "/a/roleModule/{id}", method = RequestMethod.DELETE)
	public String deleteRoleModuleJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, @PathVariable Long id)
			throws Exception {

		if (DataUtils.isNullOrEmpty(id)) {
			log.info("get id is null！");
			model.addAttribute("code", -1000);
			return "common/fail";
		}
		log.info("delete roleModule : id= " + id);
		try {
			roleModuleService.delete(id);

			log.info("add roleModule success");
			model.addAttribute("code", 0);

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("delete roleModule error,id is  " + id);
			model.addAttribute("code", -6004);

		}

		return "/data/json";
	}
	
	
	@RequestMapping(value = "/a/multi/roleModule", method = RequestMethod.GET)
	public String getMultiRoleModuleJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, Long[] ids)
			throws Exception {
			
		List<Long> idList = new ArrayList();	
	   if (ids == null) {

		} else {
			idList = Arrays.asList(ids);
		}
		try {

			

			List<RoleModule> roleModuleList = roleModuleService.getObjectsByIds(idList);
			log.info("get  roleModule data is " + roleModuleList);

			model.addAttribute("code", 0);			
			model.addAttribute("total",roleModuleList.size());

			model.addAttribute("roleModuleList", roleModuleList);

		} catch (Throwable t) {
			log.error(t.getMessage());
			log.error("get roleModule error,id is  " + idList);
			model.addAttribute("code", -100000);
		}

		return "/score-home-service/roleModule/json/roleModuleListJson";
	}
	
	
	
	
	
}

