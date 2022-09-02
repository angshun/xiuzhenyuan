package com.ptteng.carrots.bangbang.controller;

import com.ptteng.carrots.bangbang.model.Role;
import com.ptteng.carrots.bangbang.service.RoleService;
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
 * Role  crud
 * 
 * @author magenm
 * @Date 2014-4-16 13:43
 * 
 */
@Controller
public class RoleController {
	private static final Log log = LogFactory.getLog(RoleController.class);

	@Autowired
	private RoleService roleService;


	@RequestMapping(value = "/a/u/jia", method = RequestMethod.GET)
	public String jia(ModelMap model) {
		model.addAttribute("code", 0);
		return "common/jia";
	}


	@RequestMapping(value = "/c/role", method = RequestMethod.GET)
	public String getroleList(HttpServletRequest request,
							  HttpServletResponse response, ModelMap model) throws Exception {


		log.info("/role  to /role/view/roleList");

		return "/carrots-bangbang-admin-service/role/view/roleList";
	}


	@RequestMapping(value = "/c/role/{id}", method = RequestMethod.GET)
	public String getRole(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, @PathVariable Long id)
			throws Exception {

		log.info("/role/" + id + "  to /role/view/roleDeail");
		if(null != id){
			model.addAttribute("id", id);
		}else{
			model.addAttribute("id", 0);
		}

		return "/carrots-bangbang-admin-service/role/view/roleDetail";
	}
	
	
	
	    
	

	@RequestMapping(value = "/a/role/{id}", method = RequestMethod.GET)
	public String getRoleJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, @PathVariable Long id)
			throws Exception {

		log.info("get data : id= " + id);
		try {
			Role role = roleService.getObjectById(id);
			log.info("get role data is " + role);

			model.addAttribute("code", 0);

			model.addAttribute("role", role);

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("get role error,id is  " + id);
			model.addAttribute("code", -100000);
		}

		return "/carrots-bangbang-admin-service/role/json/roleDetailJson";
	}

	@RequestMapping(value = "/a/role/{id}", method = RequestMethod.PUT)
	public String updateRoleJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, Role role) throws Exception {
		
		log.info("update role : role= " + role);
		
		try {
			
			roleService.update(role);

			model.addAttribute("code", 0);

			model.addAttribute("role", role);

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("update role error,id is  " + role.getId());
			model.addAttribute("code", -6003);

		}

		return "/data/json";
	}

	@RequestMapping(value = "/a/role", method = RequestMethod.POST)
	public String addRoleJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, Role role) throws Exception {
		
		log.info("update role : role= " + role);
		
		try { 
			role.setId(null);

			roleService.insert(role);

			model.addAttribute("code", 0);
		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("add role error ");
			model.addAttribute("code", -6002);
		}

		return "/data/json";
	}

	@RequestMapping(value = "/a/role/{id}", method = RequestMethod.DELETE)
	public String deleteRoleJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, @PathVariable Long id)
			throws Exception {

		log.info("delete role : id= " + id);
		try {
			roleService.delete(id);

			log.info("add role success");
			model.addAttribute("code", 0);

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("delete role error,id is  " + id);
			model.addAttribute("code", -6004);

		}

		return "/data/json";
	}
	
	
	@RequestMapping(value = "/a/multi/role", method = RequestMethod.GET)
	public String getMultiRoleJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, Long[] ids)
			throws Exception {
			
		List<Long> idList = new ArrayList();	
	   if (ids == null) {

		} else {
			idList = Arrays.asList(ids);
		}
		try {

			

			List<Role> roleList = roleService.getObjectsByIds(idList);
			log.info("get  role data is " + roleList);

			model.addAttribute("code", 0);			
			model.addAttribute("total",roleList.size());

			model.addAttribute("roleList", roleList);

		} catch (Throwable t) {
			log.error(t.getMessage());
			log.error("get role error,id is  " + idList);
			model.addAttribute("code", -100000);
		}

		return "/carrots-bangbang-admin-service/role/json/roleListJson";
	}
	
	
	
	
	
}

