package com.ptteng.score.admin.controller;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.common.storage.util.ImgStorageUtil;
import com.ptteng.score.admin.constant.ConstantItem;
import com.ptteng.score.admin.model.Article;
import com.ptteng.score.admin.model.Staff;
import com.ptteng.score.admin.service.ArticleService;
import com.ptteng.score.admin.service.StaffService;
import com.ptteng.score.admin.util.ControllerAnnotation;
import com.ptteng.score.admin.util.DynamicSQLUtil;
import com.qding.common.util.DataUtils;
import com.qding.common.util.FileUtil;
import com.qding.common.util.http.cookie.CookieUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;
import java.io.File;
import java.util.*;

/**
 * Article  crud
 *
 * @author magenm
 * @Date 2014-4-16 13:43
 */
@Controller
public class ArticleController {
    private static final Log log = LogFactory.getLog(ArticleController.class);

    @Autowired
    private ArticleService articleService;

    @Autowired
    private CookieUtil cookieUtil;

    @Autowired
    private ImgStorageUtil imgStorageUtil;
    @Autowired
    private StaffService staffService;

    /**
     * 1.新增
     *
     * @param request
     * @param response
     * @param model
     * @param article
     * @return
     * @throws Exception
     */
    @ControllerAnnotation("131")
    @RequestMapping(value = "/a/u/article", method = RequestMethod.POST)
    public String addArticleJson(HttpServletRequest request,
                                 HttpServletResponse response, ModelMap model, @RequestBody Article article) throws Exception {

        if (DataUtils.isNullOrEmpty(article)) {
            log.info("get article is null！");
            model.addAttribute("code", -1000);
            return "common/fail";
        }
        log.info("add article: " + article);
        Long adminId = Long.valueOf(cookieUtil.getKeyIdentity(request, CookieUtil.USER_ID));
        log.info("get adminId is : " + adminId);

        Long id = null;

        try {

            article.setCreateBy(adminId);
            article.setUpdateBy(adminId);

            id = articleService.insert(article);

            log.info("add article id is: " + id);
            model.addAttribute("code", 0);
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("add article error ");
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
    @ControllerAnnotation("133")
    @RequestMapping(value = "/a/u/article", method = RequestMethod.DELETE)
    public String deleteArticleJson(HttpServletRequest request,
                                    HttpServletResponse response, ModelMap model, Long[] id)
            throws Exception {


        if (null != id && id.length == ConstantItem.ZERO) {
            log.info("get id is null！");
            model.addAttribute("code", -1000);
            return "common/fail";
        }
        log.info("delete article id: " + id);
        List<Long> list = Arrays.asList(id);

        try {
            articleService.deleteList(Article.class, list);

            log.info("delete articleList id: " + list);
            model.addAttribute("code", 0);

        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("delete article error,id is  " + id);
            model.addAttribute("code", -100000);

        }

        return "/data/json";
    }

    /**
     * 3.修改
     *
     * @param request
     * @param response
     * @param model
     * @param article
     * @return
     * @throws Exception
     */
    @ControllerAnnotation("132")
    @RequestMapping(value = "/a/u/article", method = RequestMethod.PUT)
    public String updateArticleJson(HttpServletRequest request,
                                    HttpServletResponse response, ModelMap model, @RequestBody Article article) throws Exception {

        if (DataUtils.isNullOrEmpty(article)) {
            log.info("get article is null！");
            model.addAttribute("code", -1000);
            return "common/fail";
        }
        log.info("update article: " + article);

        Long adminId = Long.valueOf(cookieUtil.getKeyIdentity(request, CookieUtil.USER_ID));
        log.info("get adminId is: " + adminId);
        try {

            article.setUpdateBy(adminId);
            boolean result = articleService.update(article);
            log.info("update id: " + article.getId() + " result is: " + result);

            model.addAttribute("code", 0);


        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("update article error,id is  " + article.getId());
            model.addAttribute("code", -100000);

        }

        return "/data/json";
    }


    /**
     * 4.详情
     *
     * @param request
     * @param response
     * @param model
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/a/u/article/{id}", method = RequestMethod.GET)
    public String getArticleJson(HttpServletRequest request,
                                 HttpServletResponse response, ModelMap model, @PathVariable Long id)
            throws Exception {

        if (DataUtils.isNullOrEmpty(id)) {
            log.info("get id is null！");
            model.addAttribute("code", -1000);
            return "common/fail";
        }
        log.info("get data : id= " + id);

        try {
            Article article = articleService.getObjectById(id);
            if (DataUtils.isNullOrEmpty(article)) {
                log.info("get article is null！");
                model.addAttribute("code", -1000);
                return "common/fail";
            }
            log.info("get articleId  is " + article.getId());

            model.addAttribute("code", 0);

            model.addAttribute("article", article);

        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("get article error,id is  " + id);
            model.addAttribute("code", -100000);
        }

        return "/json/article/json/articleDetailJson";
    }

    /**
     * 5.列表
     *
     * @param request
     * @param response
     * @param model
     * @param type
     * @param page
     * @param size
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/a/u/article", method = RequestMethod.GET)
    public String getArticleListJson(HttpServletRequest request,
                                     HttpServletResponse response, ModelMap model, Integer type,
                                     Integer page, Integer size)
            throws Exception {
        log.info("param= type is: " + type + " page is: " + page + " size is: " + size);

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

        Map<String, Object> param = null;

        List<Long> articleIdList = null;

        List<Article> articleList = null;

        List<Long> count = null;

        param = DynamicSQLUtil.getArticleList(type);

        try {


            articleIdList = articleService.getIdsByDynamicCondition(Article.class, param, start, size);
            log.info("get articleIdList is: " + articleIdList);

            articleList = articleService.getObjectsByIds(articleIdList);
            log.info("get articleList.size is: " + articleList.size());

            count = articleService.getIdsByDynamicCondition(Article.class, param, ConstantItem.ZERO, Integer.MAX_VALUE);
            log.info("get count.size is： " + count.size());

            if (DataUtils.isNullOrEmpty(articleList)) {
                log.info("get articleList is null！");
                model.addAttribute("code", -1000);
                return "common/fail";
            }

            model.addAttribute("code", 0);
            model.addAttribute("total", count.size());
            model.addAttribute("page", page);
            model.addAttribute("size", size);
            model.addAttribute("articleList", articleList);

        } catch (Throwable t) {
            log.error(t.getMessage());
            log.error("get article error,id is  ");
            model.addAttribute("code", -100000);
        }


        return "/json/article/json/articleListJson";
    }


    /**
     * 7.上传图片
     *
     * @param request
     * @param response
     * @param model
     * @param file
     * @param module
     * @return
     * @throws Exception
     */

    @RequestMapping(value = "/a/u/img/{module}", method = RequestMethod.POST)
    public String uploadFile(HttpServletRequest request, HttpServletResponse response, ModelMap model,
                             @RequestParam MultipartFile file, @PathVariable String module) {

        log.info("upload module is " + module);

        if (org.apache.commons.lang.StringUtils.isBlank(module)) {
            log.info("type is null");
        }

        log.info(file.getOriginalFilename());

        try {

            String ext = FileUtil.getFileExtension(file.getOriginalFilename());

            String fileName = UUID.randomUUID().toString() + "." + ext;


            String filePath = "/data/img/score/" + module + "/" + fileName;

//			String filePath = "/Users/shun/Desktop/img/" + module + "/" + fileName;

            String dirPath = "/data/img/score/" + module;
//			String dirPath = "/Users/shun/Desktop/img/" + module;


            File dir = new File("/data/img/score/" + module);
//			File dir = new File("/Users/shun/Desktop/img/" + module);

            if (dir.exists()) {
                log.info("创建目录" + dirPath + "失败，目标目录已经存在");
            } else {
                //创建目录
                if (dir.mkdirs()) {
                    log.info("创建目录" + dirPath + "成功！");
                } else {
                    log.info("创建目录" + dirPath + "失败！");
                }
            }

            File tempFile = new File(filePath);
            file.transferTo(tempFile);
//			String url = this.imgStorageUtil.imgStorage(null, "img/" + module + "/"
            String url = this.imgStorageUtil.imgStorage(null, "score/" + module + "/"
                    + fileName, filePath);
            log.info(module + " upload success ,and file name is " + fileName
                    + "temp path is " + filePath + " access url is " + url);
            tempFile.delete();
//			log.info(file.getOriginalFilename() + " delete success ");
            model.addAttribute("url", url);
            model.addAttribute("code", "0");

            return "/common/url";

        } catch (Throwable t) {

            t.printStackTrace();
            log.error(t.getMessage());
            model.addAttribute("code", -100000);
        }

        return "common/url";
    }


}

