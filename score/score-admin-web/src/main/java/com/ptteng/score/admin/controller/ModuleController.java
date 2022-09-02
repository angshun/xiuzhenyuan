package com.ptteng.score.admin.controller;

import com.ptteng.score.admin.constant.ConstantItem;
import com.ptteng.score.admin.model.Module;
import com.ptteng.score.admin.service.ModuleService;
import com.ptteng.score.admin.util.ControllerAnnotation;
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

	@Autowired
	private com.qding.common.util.http.cookie.CookieUtil cookieUtil;


	/**
	 * 1.新增
	 * @param request
	 * @param response
	 * @param model
	 * @param module
	 * @return
	 * @throws Exception
	 */
	@ControllerAnnotation("092")
	@RequestMapping(value = "/a/u/module", method = RequestMethod.POST)
	public String addModuleJson(HttpServletRequest request,
								HttpServletResponse response, ModelMap model, @RequestBody Module module) throws Exception {

		log.info("insert module is " + module);

		if (DataUtils.isNullOrEmpty(module.getName())) {
			log.error("必填参数有误或为空！");
			model.addAttribute("code", -1000);
			return "common/fail";
		}
		Long adminId = Long.valueOf(cookieUtil.getKeyIdentity(request, com.qding.common.util.http.cookie.CookieUtil.USER_ID));

		try {

			module.setCreateBy(adminId);
			module.setUpdateBy(adminId);
			Long id = moduleService.insert(module);
			log.info("insert module is : " + id);
			model.addAttribute("code", 0);
		} catch (Throwable t) {
			t.printStackTrace();
			log.error(t.getMessage());
			log.error("add module error ");
			model.addAttribute("code", -100000);
		}

		return "/data/json";
	}

	/**
	 * 2.删除
	 * @param request
	 * @param response
	 * @param model
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@ControllerAnnotation("093")
	@RequestMapping(value = "/a/u/module/{id}", method = RequestMethod.DELETE)
	public String deleteModuleJson(HttpServletRequest request,
								   HttpServletResponse response, ModelMap model, @PathVariable Long id)
			throws Exception {

		log.info("delete module  id : " + id);
		try {
			boolean result = moduleService.delete(id);

			log.info("delete module id result is :"  + result);
			model.addAttribute("code", 0);

		} catch (Throwable t) {
			t.printStackTrace();
			log.error(t.getMessage());
			log.error("delete module error,id is  " + id);
			model.addAttribute("code", -6004);

		}

		return "/data/json";
	}

	/**
	 * 3.修改
	 * @param request
	 * @param response
	 * @param model
	 * @param module
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@ControllerAnnotation("091")
	@RequestMapping(value = "/a/u/module/{id}", method = RequestMethod.PUT)
	public String updateModuleJson(HttpServletRequest request,
								   HttpServletResponse response, ModelMap model,
								   @RequestBody Module module,
								   @PathVariable Long id) throws Exception {

		log.info("update module is : " + module);

		if (DataUtils.isNullOrEmpty(module.getName())) {
			log.error("必填参数有误或为空！");
			model.addAttribute("code", -1000);
			return "common/fail";
		}
		Long adminId = Long.valueOf(cookieUtil.getKeyIdentity(request, com.qding.common.util.http.cookie.CookieUtil.USER_ID));

		try {
			Module module1 = moduleService.getObjectById(id);
			log.info("get module1 is :" + module1);
			module.setCreateAt(module1.getCreateAt());
			module.setCreateBy(module1.getCreateBy());
			module.setUpdateBy(adminId);
			module.setId(module1.getId());

			boolean result = moduleService.update(module);
			log.info("update module result is : " + result);

			model.addAttribute("code", 0);


		} catch (Throwable t) {
			t.printStackTrace();
			log.error(t.getMessage());
			log.error("update module error,id is  " + module.getId());
			model.addAttribute("code", -100000);

		}

		return "/data/json";
	}


	/**
	 * 4.列表
	 * @param request
	 * @param response
	 * @param model
	 * @param page
	 * @param size
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/a/u/module/list", method = RequestMethod.GET)
	public String getModuleList(HttpServletRequest request,
								HttpServletResponse response, ModelMap model, Integer page,
								Integer size)
			throws Exception {

		log.info("get param = page is : " + page + " size is : " + size);

		if (page == null || page <= ConstantItem.ZERO) {
			page = ConstantItem.ONE;
		}
		if (size == null || size <= ConstantItem.ZERO) {
			size = ConstantItem.FIFTY;
		}
		int start = (page - ConstantItem.ONE) * size;
		if (start < ConstantItem.ZERO) {
			start = ConstantItem.ZERO;
		}

		List<Long> moduleIdList = null;

		List<Long> count = null;

		List<Module> moduleList = null;

		try {
			moduleIdList = moduleService.getModuleIds(start, size);
			log.info("get moduleIdList is : " + moduleIdList);

			count = moduleService.getModuleIds(ConstantItem.ZERO, Integer.MAX_VALUE);
			log.info("get count is : " + count);

			moduleList = moduleService.getObjectsByIds(moduleIdList);
			log.info("get  moduleList.size is : " + moduleList.size());

			model.addAttribute("code", 0);
			model.addAttribute("total", count.size());
			model.addAttribute("page", page);
			model.addAttribute("size", size);
			model.addAttribute("moduleList", moduleList);

		} catch (Throwable t) {
			log.error(t.getMessage());
			log.error("get module error,id is  " + moduleIdList);
			model.addAttribute("code", -100000);
		}


		return "/json/module/json/moduleListJson";
	}

	/**
	 * 5.详情
	 * @param request
	 * @param response
	 * @param model
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/a/u/module/{id}", method = RequestMethod.GET)
	public String getModuleJson(HttpServletRequest request,
								HttpServletResponse response, ModelMap model, @PathVariable Long id)
			throws Exception {

		log.info("get module id is : " + id);
		try {
			Module module = moduleService.getObjectById(id);
			log.info("get module is : " + module);

			model.addAttribute("code", 0);

			model.addAttribute("module", module);

		} catch (Throwable t) {
			t.printStackTrace();
			log.error(t.getMessage());
			log.error("get module error,id is  " + id);
			model.addAttribute("code", -100000);
		}

		return "/json/module/json/moduleDetailJson";
	}



	/**
	 * 批量获取模块详细信息
	 * @param request
	 * @param response
	 * @param model
	 * @param ids
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/a/u/multi/module", method = RequestMethod.GET)
	public String getMultiModuleJson(HttpServletRequest request,
									 HttpServletResponse response, ModelMap model, Long[] ids)
			throws Exception {
		log.info("get module mid " + ids);
		List<Long> idList = new ArrayList();
		if (ids == null|| ids.length<=ConstantItem.ZERO) {
			model.addAttribute("code", 0);
			model.addAttribute("total", 0);
			model.addAttribute("size", 10);

		} else {
			idList = Arrays.asList(ids);
		}
		try {

			if (idList.size() == 0 || idList.size() <= ConstantItem.ZERO) {

				model.addAttribute("code", 0);
				model.addAttribute("total", 0);
				model.addAttribute("size", 10);
			} else {
				List<Module> moduleList = moduleService.getObjectsByIds(idList);
				log.info("get moduleList data is " + moduleList.size());

				if (moduleList.size() != 0 && moduleList.size() > ConstantItem.ZERO) {
					int totalPage = 0;
					int totalCnt = moduleList.size();
					if (totalCnt > 0) {
						totalPage = totalCnt / ConstantItem.TEN + ConstantItem.ONE;
					}

					model.addAttribute("code", 0);

//					model.addAttribute("size", 10);
					model.addAttribute("total", moduleList.size());
					model.addAttribute("moduleList", moduleList);

				} else {
					model.addAttribute("code", 0);
					model.addAttribute("total", 0);
					model.addAttribute("moduleList", moduleList);
				}
			}
		} catch (Throwable t) {
			log.error(t.getMessage());
			log.error("get module error,id is  " + Arrays.toString(ids));
			model.addAttribute("code", -100000);
		}

		return "/json/module/json/moduleListJson";
	}


	/**
	 * 查询模块列表
	 */

	@RequestMapping(value = "/a/u/module/", method = RequestMethod.GET)
	public String getModuleIdsByTypeJsonList(HttpServletRequest request,
											 HttpServletResponse response, ModelMap model, Integer page,
											 Integer size, String type) throws Exception {
		if (page==null) {
			page = ConstantItem.ONE;
		}
		if (size==null) {
			size = ConstantItem.FIFTY;
		}

		int start = (page - ConstantItem.ONE) * size;
		if (start < ConstantItem.ZERO) {
			start = ConstantItem.ZERO;
		}

		log.info("pageList : page= " + start + " , size=" + size);

		try {

			List<Long> ids=null;
			List<Long> totalids = new ArrayList<Long>();
			Boolean next = false;
			size+=1;

			if ((type!=null)&&(!"".equals(type))) {
				ids= moduleService.getModuleIdsByType(type, start,size);
				totalids= moduleService.getModuleIdsByType(type, ConstantItem.ZERO, Integer.MAX_VALUE);
			}else {
				ids=moduleService.getModuleIds(start,size);
				totalids=moduleService.getModuleIds(ConstantItem.ZERO, Integer.MAX_VALUE);

			}


			log.info("get countModuleIdsByType size is " + ids.size());

			if(ids.size()!=0 && ids.size()>0){

				if (size.equals(ids.size())) {
					next = true;
					log.info("ss  "+ids.subList(ConstantItem.ZERO,size-ConstantItem.ONE));
					model.addAttribute("ids", ids.subList(ConstantItem.ZERO,size-ConstantItem.ONE));
				}else{
					log.info("ss  "+ids.subList(ConstantItem.ZERO,ids.size()));
					model.addAttribute("ids", ids.subList(ConstantItem.ZERO, ids.size()));
				}
				int totalCnt = totalids.size();

				//model.addAttribute("page",page);
				model.addAttribute("total",totalCnt);
			}else{
				model.addAttribute("ids", ids);
			}

			model.addAttribute("code", 0);
			model.addAttribute("size", size-1);

			model.addAttribute("page",page);

			model.addAttribute("next", next);
		} catch (Throwable t) {
			t.printStackTrace();
			log.error(t.getMessage());
			log.error("get module list error,page is  " + start + " , size "
					+ size);
			// for test
			model.addAttribute("code", -100000);
		}

		return "/json/module/json/moduleIdListJson";
	}

	
}

