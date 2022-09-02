package com.ptteng.carrots.bangbang.controller;

import com.ptteng.carrots.bangbang.model.ProfessionTag;
import com.ptteng.carrots.bangbang.service.ProfessionTagService;
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
 * ProfessionTag  crud
 * 
 * @author magenm
 * @Date 2014-4-16 13:43
 * 
 */
@Controller
public class ProfessionTagController {
	private static final Log log = LogFactory.getLog(ProfessionTagController.class);

	@Autowired
	private ProfessionTagService professionTagService;



	@RequestMapping(value = "/c/professionTag", method = RequestMethod.GET)
	public String getprofessionTagList(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {

		
		
		log.info("/professionTag  to /professionTag/view/professionTagList");

		return "/carrots-bangbang-admin-service/professionTag/view/professionTagList";
	}
    
    

    
	
	@RequestMapping(value = "/c/professionTag/{id}", method = RequestMethod.GET)
	public String getProfessionTag(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, @PathVariable Long id)
			throws Exception {

		log.info("/professionTag/" + id + "  to /professionTag/view/professionTagDeail");
		if(null != id){
			model.addAttribute("id", id);
		}else{
			model.addAttribute("id", 0);
		}

		return "/carrots-bangbang-admin-service/professionTag/view/professionTagDetail";
	}
	
	
	
	    
	

	@RequestMapping(value = "/a/u/professionTag/{id}", method = RequestMethod.GET)
	public String getProfessionTagJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, @PathVariable Long id)
			throws Exception {

		log.info("get data : id= " + id);
		try {
			ProfessionTag professionTag = professionTagService.getObjectById(id);
			log.info("get professionTag data is " + professionTag);

			model.addAttribute("code", 0);

			model.addAttribute("professionTag", professionTag);

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("get professionTag error,id is  " + id);
			model.addAttribute("code", -100000);
		}

		return "/carrots-bangbang-admin-service/professionTag/json/professionTagDetailJson";
	}

	@RequestMapping(value = "/a/professionTag/{id}", method = RequestMethod.PUT)
	public String updateProfessionTagJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, ProfessionTag professionTag) throws Exception {
		
		log.info("update professionTag : professionTag= " + professionTag);
		
		try {
			
			professionTagService.update(professionTag);

			model.addAttribute("code", 0);

			model.addAttribute("professionTag", professionTag);

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("update professionTag error,id is  " + professionTag.getId());
			model.addAttribute("code", -6003);

		}

		return "/data/json";
	}

	@RequestMapping(value = "/a/professionTag", method = RequestMethod.POST)
	public String addProfessionTagJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, ProfessionTag professionTag) throws Exception {
		
		log.info("update professionTag : professionTag= " + professionTag);
		
		try { 
			professionTag.setId(null);

			professionTagService.insert(professionTag);

			model.addAttribute("code", 0);
		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("add professionTag error ");
			model.addAttribute("code", -6002);
		}

		return "/data/json";
	}

	@RequestMapping(value = "/a/professionTag/{id}", method = RequestMethod.DELETE)
	public String deleteProfessionTagJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, @PathVariable Long id)
			throws Exception {

		log.info("delete professionTag : id= " + id);
		try {
			professionTagService.delete(id);

			log.info("add professionTag success");
			model.addAttribute("code", 0);

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("delete professionTag error,id is  " + id);
			model.addAttribute("code", -6004);

		}

		return "/data/json";
	}
	
	
	@RequestMapping(value = "/a/multi/professionTag", method = RequestMethod.GET)
	public String getMultiProfessionTagJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, Long[] ids)
			throws Exception {
			
		List<Long> idList = new ArrayList();	
	   if (ids == null) {

		} else {
			idList = Arrays.asList(ids);
		}
		try {

			

			List<ProfessionTag> professionTagList = professionTagService.getObjectsByIds(idList);
			log.info("get  professionTag data is " + professionTagList);

			model.addAttribute("code", 0);			
			model.addAttribute("total",professionTagList.size());

			model.addAttribute("professionTagList", professionTagList);

		} catch (Throwable t) {
			log.error(t.getMessage());
			log.error("get professionTag error,id is  " + idList);
			model.addAttribute("code", -100000);
		}

		return "/carrots-bangbang-admin-service/professionTag/json/professionTagListJson";
	}
	
	
	
	
	
}

