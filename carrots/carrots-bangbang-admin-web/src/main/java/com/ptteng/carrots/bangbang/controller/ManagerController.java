package com.ptteng.carrots.bangbang.controller;

import com.ptteng.carrots.bangbang.model.Manager;
import com.ptteng.carrots.bangbang.service.ManagerService;
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






    /**
	 * 
	 * @param
	 * @return

	 */

	@RequestMapping(value = "/c/manager", method = RequestMethod.GET)
	public String getmanagerList(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {

		
		
		log.info("/manager  to /manager/view/managerList");

		return "/carrots-bangbang-admin-service/manager/view/managerList";
	}
    
    

    
	
	@RequestMapping(value = "/c/manager/{id}", method = RequestMethod.GET)
	public String getManager(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, @PathVariable Long id)
			throws Exception {

		log.info("/manager/" + id + "  to /manager/view/managerDeail");
		if(null != id){
			model.addAttribute("id", id);
		}else{
			model.addAttribute("id", 0);
		}

		return "/carrots-bangbang-admin-service/manager/view/managerDetail";
	}
	
	
	
	    
	

	@RequestMapping(value = "/a/manager/{id}", method = RequestMethod.GET)
	public String getManagerJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, @PathVariable Long id)
			throws Exception {

		log.info("get data : id= " + id);
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

		return "/carrots-bangbang-admin-service/manager/json/managerDetailJson";
	}

	@RequestMapping(value = "/a/manager/{id}", method = RequestMethod.PUT)
	public String updateManagerJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, Manager manager) throws Exception {
		
		log.info("update manager : manager= " + manager);
		
		try {
			
			managerService.update(manager);

			model.addAttribute("code", 0);

			model.addAttribute("manager", manager);

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("update manager error,id is  " + manager.getId());
			model.addAttribute("code", -6003);

		}

		return "/data/json";
	}

	@RequestMapping(value = "/a/manager", method = RequestMethod.POST)
	public String addManagerJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, Manager manager) throws Exception {
		
		log.info("update manager : manager= " + manager);
		
		try { 
			manager.setId(null);

			managerService.insert(manager);

			model.addAttribute("code", 0);
		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("add manager error ");
			model.addAttribute("code", -6002);
		}

		return "/data/json";
	}

	@RequestMapping(value = "/a/manager/{id}", method = RequestMethod.DELETE)
	public String deleteManagerJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, @PathVariable Long id)
			throws Exception {

		log.info("delete manager : id= " + id);
		try {
			managerService.delete(id);

			log.info("add manager success");
			model.addAttribute("code", 0);

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("delete manager error,id is  " + id);
			model.addAttribute("code", -6004);

		}

		return "/data/json";
	}
	
	
	@RequestMapping(value = "/a/multi/manager", method = RequestMethod.GET)
	public String getMultiManagerJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, Long[] ids)
			throws Exception {
			
		List<Long> idList = new ArrayList();	
	   if (ids == null) {

		} else {
			idList = Arrays.asList(ids);
		}
		try {

			

			List<Manager> managerList = managerService.getObjectsByIds(idList);
			log.info("get  manager data is " + managerList);

			model.addAttribute("code", 0);			
			model.addAttribute("total",managerList.size());

			model.addAttribute("managerList", managerList);

		} catch (Throwable t) {
			log.error(t.getMessage());
			log.error("get manager error,id is  " + idList);
			model.addAttribute("code", -100000);
		}

		return "/carrots-bangbang-admin-service/manager/json/managerListJson";
	}
	
	
	
	
	
}

