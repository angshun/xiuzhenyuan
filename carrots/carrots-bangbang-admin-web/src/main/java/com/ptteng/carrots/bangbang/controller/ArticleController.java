package com.ptteng.carrots.bangbang.controller;

import com.ptteng.carrots.bangbang.model.Article;
import com.ptteng.carrots.bangbang.service.ArticleService;
import com.ptteng.common.storage.util.ImgStorageUtil;
import com.qding.common.util.FileUtil;
import javafx.print.PageLayout;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import util.CookieUtil;
import util.DynamicUtil;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    private ImgStorageUtil imgStorageUtil;

    /**
     * 1.Article新增接口
     *
     * @param response
     * @param request
     * @param model
     * @param article
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/a/u/article", method = RequestMethod.POST)
    public String addArticle(HttpServletResponse response, HttpServletRequest request,
                             ModelMap model, @RequestBody Article article) throws Exception {

        if (article.getImg() == null || article.getImg() == "") {
            log.error("必填参数有误或为空！");
            model.addAttribute("code", -1000);
            return "common/fail";
        }

        Long adminId = null;
        try {
            adminId = CookieUtil.getAdminId(request);
            log.info("获取管理员身份成功！adminId：" + adminId);
        } catch (Throwable t) {
            log.error("系统异常，获取管理员ID失败！");
            t.printStackTrace();
            log.error(t.getMessage());
        }
        //设置创建人和更新人为管理员
        article.setCreateBy(adminId);
        //向数据库中插入Article

        try {
            article.setCreateAt(System.currentTimeMillis());
            Long aId = articleService.insert(article);
            Integer articleId = new Long(aId).intValue();
            article.setId(aId);
            article.setRank((articleId));
            boolean update = articleService.update(article);


            model.addAttribute("code", 0);
        } catch (Throwable t) {
            log.error("add article error ：" + article);
            t.printStackTrace();
            log.error(t.getMessage());
            model.addAttribute("code", -100000);
            return "common/fail";

        }

        return "common/insert";
    }


    /**
     * 2.删除Article
     *
     * @param request
     * @param response
     * @param model
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/a/u/article/{id}", method = RequestMethod.DELETE)
    public String deleteArticleJson(HttpServletRequest request,
                                    HttpServletResponse response, ModelMap model,
                                    @PathVariable Long id)
            throws Exception {

        log.info("delete article : id= " + id);
        try {

            articleService.delete(id);
            log.info("删除 article 成功 id：" + id);
            model.addAttribute("code", "0");
            model.addAttribute("id", id);

        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("delete article error,id is  " + id);
            model.addAttribute("code", -100000);
            return "common/fail";

        }

        return "common/success";
    }

    /**
     * 3.更新Article
     *
     * @param request
     * @param response
     * @param model
     * @param article
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/a/u/article/{id}", method = RequestMethod.PUT)
    public String updateArticleJson(HttpServletRequest request,
                                    HttpServletResponse response, ModelMap model,
                                    @RequestBody Article article,
                                    @PathVariable Long id) throws Exception {

        if (article.getImg() == null || article.getImg() == "") {
            log.error("传入的参数有误！，必填参数为空！");
            model.addAttribute("code", -1004);
            return "common/fail";
        }
        //获取管理员id
        Long adminId = null;
        try {
            adminId = CookieUtil.getAdminId(request);
            log.info("获取管理员身份成功！adminId：" + adminId);
            article.setUpdateBy(adminId);
        } catch (Throwable t) {
            log.error("获取管理员身份失败！");
            log.error(t.getMessage());
        }

        //更新Article
        try {
            Article article1 = articleService.getObjectById(id);
            log.info("获取旧数据！article1:" + article);
            article.setUpdateBy(adminId);
            article.setUpdateAt(System.currentTimeMillis());
            article1.setTitle(article.getTitle());
            article1.setImg(article.getImg());
            article1.setIndustry(article.getIndustry());
            article1.setStatus(article.getStatus());
            article1.setType(article.getType());
            article1.setUrl(article.getUrl());
            articleService.update(article1);
            model.addAttribute("code", 0);
            log.info("article更新成功！Article ID：" + article.getId());

        } catch (Throwable t) {
            log.error("update article error,id is  " + article.getId());
            t.printStackTrace();
            log.error(t.getMessage());
            model.addAttribute("code", -100000);
            return "common/fail";
        }
        return "common/success";
    }

    /**
     * 4.修改上下线状态
     *
     * @param request
     * @param response
     * @param id
     * @param status
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/a/u/article/status/{id}", method = RequestMethod.PUT)
    public String updateStatus(HttpServletRequest request, HttpServletResponse response,
                               @PathVariable Long id,
                               Integer status, ModelMap model) throws Exception {

        if (id == null) {
            model.addAttribute("code", -1005);
            log.error("put article status error and id is null");
            return "common/fail";
        }
        Article article = articleService.getObjectById(id);
        log.info("update article id :" + id + "status : " + status);
        Long adminId = null;
        try {
            adminId = CookieUtil.getAdminId(request);
            log.info("获取管理员身份成功！ adminId：" + adminId);
        } catch (Throwable t) {
            log.error("获取管理员身份失败！");
            t.printStackTrace();
            log.error(t.getMessage());
            model.addAttribute("code", -1000);
            return "common/fail";
        }
        article.setUpdateBy(adminId);
        article.setStatus(status/* == 0 ? 1 : 0*/);
        article.setUpdateAt(System.currentTimeMillis());

        try {
            articleService.update(article);
            log.info("article状态更新成功！article" + id);
            model.addAttribute("code", "0");
            model.addAttribute("id", id);
        } catch (Throwable t) {
            log.error("更新Article状态失败！ article ：" + id);
            t.printStackTrace();
            log.error(t.getMessage());
            model.addAttribute("code", -100000);
            return "common/fail";
        }
        return "common/success";
    }

    /**
     * 5.按条件搜索Article列表
     * 请求参数：
     *
     * @param title
     * @param type
     * @param createBy
     * @param startAt
     * @param endAt
     * @param status
     * @param page
     * @param size
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/a/u/article/search", method = RequestMethod.GET)
    public String getArticleList(HttpServletRequest request,
                                 HttpServletResponse response, ModelMap model, String title, Integer type, Long createBy,
                                 Long startAt, Long endAt, Integer status, Integer page, Integer size) throws Exception {
        if (page == null || page <= 0) {
            page = 1;
        }
        //后台做拖动排序，返回所有数据
        if (size == null || size <= 0) {
            size = Integer.MAX_VALUE;
        }
        int start = (page - 1) * size;
        if (start < 0) {
            start = 0;
        }
        List<Article> articleList = null;
        try {

            Map<String, Object> param = DynamicUtil.getArticleList(title, createBy, startAt, endAt, status, type);
            List<Long> ids = articleService.getIdsByDynamicCondition(Article.class, param, start, size);
            log.info("get ids is " + ids);
            List<Long> count = articleService.getIdsByDynamicCondition(Article.class, param, 0, Integer.MAX_VALUE);
            log.info("get count is " + count);
            articleList = articleService.getObjectsByIds(ids);
            log.info("get articleList is " + ids);
            model.addAttribute("code", "0");
            model.addAttribute("page", page);

            model.addAttribute("size", size);
            model.addAttribute("total", count.size());
            model.addAttribute("articleList", articleList);

        } catch (Exception t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("get article error");
            model.addAttribute("code", -100000);
        }
        return "/carrots-bangbang-admin-service/article/json/articleListJson";
    }


    /**
     * 6.获取单个Article详情
     *
     * @param model
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/a/u/article/{id}", method = RequestMethod.GET)
    public String getArticleJson(HttpServletRequest request,
                                 HttpServletResponse response, ModelMap model, @PathVariable Long id)
            throws Exception {

        log.info("get data : id= " + id);
        try {
            if (id == null) {
                model.addAttribute("code", -1006);
                return "common/fail";
            } else {
                Article article = articleService.getObjectById(id);
                if (article == null) {
                    model.addAttribute("code", -1007);
                    return "common/fail";
                } else {
                    log.info("get article data is " + article.getId());

                    model.addAttribute("code", "0");

                    model.addAttribute("article", article);
                }
            }
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("get article error,id is  " + id);
            model.addAttribute("code", -100000);
        }

        return "carrots-bangbang-admin-service/article/json/articleDetailJson";

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

        int code = 0;
        log.info(file.getOriginalFilename());

        try {

            String ext = FileUtil.getFileExtension(file.getOriginalFilename());

            String fileName = UUID.randomUUID().toString() + "." + ext;


            String filePath = "/data/img/graship/" + module + "/" + fileName;

//            String filePath = "/Users/shun/Desktop/img/" + module + "/" + fileName;

            String dirPath = "/data/img/graship/" + module;
//            String dirPath = "/Users/shun/Desktop/img/" + module;


            File dir = new File("/data/img/graship/" + module);
//            File dir = new File("/Users/shun/Desktop/img/" + module);

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
//            String url = this.imgStorageUtil.imgStorage(null, "img/" + module + "/"
            String url = this.imgStorageUtil.imgStorage(null, "graship/" + module + "/"
                    + fileName, filePath);
            log.info(module + " upload success ,and file name is " + fileName
                    + "temp path is " + filePath + " access url is " + url);
            tempFile.delete();
//			log.info(file.getOriginalFilename() + " delete success ");
            model.addAttribute("url", url);
            model.addAttribute("code", "0");

            return "/common/img";

        } catch (Throwable t) {

            t.printStackTrace();
            log.error(t.getMessage());
            model.addAttribute("code", -100000);
        }

        return "/common/success";
    }

    /**
     * Article拖动排序
     * @param request
     * @param response
     * @param model
     * @param ranks
     * @return
     * @throws Exception
     */
    //保存排序,前端传一数组过来,里面包含的是各id的排序,比如传[3.7.8.1.9]即表示排第一的是id为3的记录,第二的是id为7的,类推
    @RequestMapping(value = "/a/u/article/rank", method = RequestMethod.PUT)
    public String sort(HttpServletRequest request, HttpServletResponse response, ModelMap model,
                       Long[] ranks) throws Exception {

        List<Long> list = Arrays.asList(ranks);
        log.info("拖动后的rank排序：" + list);
        try {
            List<Article> articleList = articleService.getObjectsByIds(list);
            //循环后自增
            int index = 1;
            for (Article article : articleList) {
                article.setRank(index);
                index += 1;
            }
            articleService.updateList(articleList);
            model.addAttribute("code", 0);
        } catch (Throwable t) {
            t.printStackTrace();
            log.error("update rank error:");
            log.error(t.getMessage());
            model.addAttribute("code", -100000);
            return "common/fail";
        }
        return "common/success";
    }

}

