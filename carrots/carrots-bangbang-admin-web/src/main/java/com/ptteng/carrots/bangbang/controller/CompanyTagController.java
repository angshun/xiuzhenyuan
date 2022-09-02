package com.ptteng.carrots.bangbang.controller;

import com.ptteng.carrots.bangbang.model.CompanyTag;
import com.ptteng.carrots.bangbang.service.CompanyTagService;
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
 * CompanyTag  crud
 * 
 * @author magenm
 * @Date 2014-4-16 13:43
 * 
 */
@Controller
public class CompanyTagController {
	private static final Log log = LogFactory.getLog(CompanyTagController.class);

	@Autowired
	private CompanyTagService companyTagService;






    /**
	 * 
	 * @param
	 * @return

	 */

	@RequestMapping(value = "/c/companyTag", method = RequestMethod.GET)
	public String getcompanyTagList(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {

		
		
		log.info("/companyTag  to /companyTag/view/companyTagList");

		return "/carrots-bangbang-admin-service/companyTag/view/companyTagList";
	}
    
    

    
	
	@RequestMapping(value = "/c/companyTag/{id}", method = RequestMethod.GET)
	public String getCompanyTag(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, @PathVariable Long id)
			throws Exception {

		log.info("/companyTag/" + id + "  to /companyTag/view/companyTagDeail");
		if(null != id){
			model.addAttribute("id", id);
		}else{
			model.addAttribute("id", 0);
		}

		return "/carrots-bangbang-admin-service/companyTag/view/companyTagDetail";
	}
	
	
	
	    
	

	@RequestMapping(value = "/a/companyTag/{id}", method = RequestMethod.GET)
	public String getCompanyTagJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, @PathVariable Long id)
			throws Exception {

		log.info("get data : id= " + id);
		try {
			CompanyTag companyTag = companyTagService.getObjectById(id);
			log.info("get companyTag data is " + companyTag);

			model.addAttribute("code", 0);

			model.addAttribute("companyTag", companyTag);

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("get companyTag error,id is  " + id);
			model.addAttribute("code", -100000);
		}

		return "/carrots-bangbang-admin-service/companyTag/json/companyTagDetailJson";
	}

	@RequestMapping(value = "/a/companyTag/{id}", method = RequestMethod.PUT)
	public String updateCompanyTagJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, CompanyTag companyTag) throws Exception {
		
		log.info("update companyTag : companyTag= " + companyTag);
		
		try {
			
			companyTagService.update(companyTag);

			model.addAttribute("code", 0);

			model.addAttribute("companyTag", companyTag);

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("update companyTag error,id is  " + companyTag.getId());
			model.addAttribute("code", -6003);

		}

		return "/data/json";
	}

	@RequestMapping(value = "/a/companyTag", method = RequestMethod.POST)
	public String addCompanyTagJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, CompanyTag companyTag) throws Exception {
		
		log.info("update companyTag : companyTag= " + companyTag);
		
		try { 
			companyTag.setId(null);

			companyTagService.insert(companyTag);

			model.addAttribute("code", 0);
		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("add companyTag error ");
			model.addAttribute("code", -6002);
		}

		return "/data/json";
	}

	@RequestMapping(value = "/a/companyTag/{id}", method = RequestMethod.DELETE)
	public String deleteCompanyTagJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, @PathVariable Long id)
			throws Exception {

		log.info("delete companyTag : id= " + id);
		try {
			companyTagService.delete(id);

			log.info("add companyTag success");
			model.addAttribute("code", 0);

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("delete companyTag error,id is  " + id);
			model.addAttribute("code", -6004);

		}

		return "/data/json";
	}
	
	
	@RequestMapping(value = "/a/multi/companyTag", method = RequestMethod.GET)
	public String getMultiCompanyTagJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, Long[] ids)
			throws Exception {
			
		List<Long> idList = new ArrayList();	
	   if (ids == null) {

		} else {
			idList = Arrays.asList(ids);
		}
		try {

			

			List<CompanyTag> companyTagList = companyTagService.getObjectsByIds(idList);
			log.info("get  companyTag data is " + companyTagList);

			model.addAttribute("code", 0);			
			model.addAttribute("total",companyTagList.size());

			model.addAttribute("companyTagList", companyTagList);

		} catch (Throwable t) {
			log.error(t.getMessage());
			log.error("get companyTag error,id is  " + idList);
			model.addAttribute("code", -100000);
		}

		return "/carrots-bangbang-admin-service/companyTag/json/companyTagListJson";
	}
	
	
	
	
	
}

