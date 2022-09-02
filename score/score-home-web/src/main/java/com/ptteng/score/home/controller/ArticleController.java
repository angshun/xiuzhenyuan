package com.ptteng.score.home.controller;

import com.ptteng.common.storage.util.ImgStorageUtil;
import com.ptteng.score.home.constant.ConstantItem;
import com.ptteng.score.home.model.Article;
import com.ptteng.score.home.service.ArticleService;
import com.ptteng.score.home.util.DynamicSQLUtil;
import com.qding.common.util.DataUtils;
import com.qding.common.util.FileUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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
     * 1.详情
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
            log.info("get article data is " + article);

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
     * 2.列表
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
            log.info("get articleIdList is: " + articleIdList.size());

            articleList = articleService.getObjectsByIds(articleIdList);
            log.info("get articleList is: " + articleList.size());

            count = articleService.getIdsByDynamicCondition(Article.class, param, ConstantItem.ZERO, Integer.MAX_VALUE);
            log.info("get count.size is： " + count.size());

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
     * 3.上传图片
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
            model.addAttribute("code", -1000);
            return "/common/fail";
        }
        if (null == file) {
            log.info("type is null");
            model.addAttribute("code", -1000);
            return "/common/fail";
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

            return "/common/img";

        } catch (Throwable t) {

            t.printStackTrace();
            log.error(t.getMessage());
            model.addAttribute("code", -100000);
        }

        return "/common/img";
    }


}

