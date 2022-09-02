package com.ptteng.carrots.bangbang.controller;

import com.ptteng.carrots.bangbang.model.Article;
import com.ptteng.carrots.bangbang.service.ArticleService;
import com.ptteng.common.dao.util.SQLUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import util.DynamicUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

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




    /**
     * 按类型查询Article
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/a/article/search", method = RequestMethod.GET)
    public String getArticleJson(HttpServletRequest request,
                                 HttpServletResponse response, ModelMap model,
                                 Integer type, Integer page, Integer size)
            throws Exception {

        if (page == null || page <= 0) {
            page = 1;
        }
        if (size == null || size <= 0) {
            size = 10;
        }
        int start = (page - 1) * size;


        Map<String, Object> articleSql = null;

        List<Article> articleList = null;

        List<Long> articlIdList = null;

        List<Long> count = null;


        try {
            articleSql = DynamicUtil.getArticel(type);
            log.info("get articleSql is :"+ SQLUtil.convert2Sql(articleSql,0,Integer.MAX_VALUE));
            articlIdList = articleService.getIdsByDynamicCondition(Article.class, articleSql, start,size);
            log.info("get articleIdList is :" + articlIdList);
            count = articleService.getIdsByDynamicCondition(Article.class, articleSql, 0, Integer.MAX_VALUE);
            log.info("get count is :" + count);
            articleList = articleService.getObjectsByIds(articlIdList);
            log.info("get articleList is :" + articleList);

            model.addAttribute("code", "0");
            model.addAttribute("size", size);
            model.addAttribute("page", page);
            model.addAttribute("total", count.size());
            model.addAttribute("articleList", articleList);

        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("系统异常");
            model.addAttribute("code", "-1001");
        }


        return "/carrots-bangbang-home-service/article/json/articleListJson";
    }

}

