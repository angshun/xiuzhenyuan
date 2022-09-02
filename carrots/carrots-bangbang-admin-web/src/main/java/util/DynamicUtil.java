package util;


import com.ptteng.carrots.bangbang.model.Profession;
import com.ptteng.common.dao.util.SQLUtil;
import com.qding.common.util.DataUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.ss.formula.functions.Count;
import org.apache.xmlbeans.impl.regex.REUtil;

import javax.persistence.Id;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;


public class DynamicUtil {

    private static final Log log = LogFactory.getLog(DynamicUtil.class);

    /**
     * 后台按条件搜索Article列表
     *
     * @param title
     * @param createBy
     * @param startAt
     * @param endAt
     * @param status
     * @param type
     * @return
     */
    public static Map<String, Object> getArticleList(String title, Long createBy, Long startAt, Long endAt, Integer status, Integer type
    ) {
        Map<String, Object> params = new HashMap<String, Object>();
        if (DataUtils.isNotNullOrEmpty(title)) {
            params.put("title & like", "'%" + title + "%'");
        }
        if (DataUtils.isNotNullOrEmpty(createBy)) {
            params.put("create_by", createBy);
        }
        if (DataUtils.isNotNullOrEmpty(startAt)) {

            params.put("create_at & >=", startAt);
        }
        if (DataUtils.isNotNullOrEmpty(endAt)) {
            params.put("create_at & <=", endAt);
        }
        if (DataUtils.isNotNullOrEmpty(status)) {
            params.put("status",status);
        }
        if (DataUtils.isNotNullOrEmpty(type)) {
            params.put("type",type );
        }

        params.put("@order", " rank asc ");
        params.put("@query", " id ");
        params.put("@table", " article ");
        log.info("getArticleList sql is " + SQLUtil.convert2Sql(params, 0, 0));
        return params;
    }

    /**
     * 通过cid得到产品
     *
     * @param
     * @param pName
     * @param cName
     * @param education
     * @param salary
     * @param type
     * @param status
     * @param recommend
     * @param startAt
     * @param endAt     @return
     * @param subType
     * @return 后台职位列表查询
     */
    public static Map<String, Object> getProfessionList(String pName, String cName, Integer workExperience,
                                                        Integer education, Integer salary, Integer type,
                                                        Integer status, Integer recommend, Long startAt, Long endAt,
                                                        Integer subType, Integer grade, Long cid, Integer city,
                                                        Integer county, Integer province) {

        Map<String, Object> param = new HashMap<>();
        if (DataUtils.isNotNullOrEmpty(pName)) {
            param.put("p.name & like ", "'%" + pName + "%'");
        }
        if (DataUtils.isNotNullOrEmpty(cName)) {
            param.put("c.name & like ", "'%" + cName + "%'");
        }
        if (DataUtils.isNotNullOrEmpty(type)) {
            param.put("p.type", type);
        }
        if (DataUtils.isNotNullOrEmpty(subType)) {
            param.put("p.subType", subType);
        }
        if (DataUtils.isNotNullOrEmpty(grade)) {
            param.put("p.grade", grade);
        }
        if (DataUtils.isNotNullOrEmpty(city)) {
            param.put("p.city", city);
        }
        if (DataUtils.isNotNullOrEmpty(county)) {
            param.put("p.county", county);
        }
        if (DataUtils.isNotNullOrEmpty(province)) {
            param.put("p.province", province);
        }

        if (DataUtils.isNotNullOrEmpty(recommend)) {
            param.put("p.recommend", recommend);
        }
        if (DataUtils.isNotNullOrEmpty(cid)) {
            param.put("p.c_id", cid);
        }

        if (DataUtils.isNotNullOrEmpty(education)) {
            param.put("p.education", education);
        }
        if (DataUtils.isNotNullOrEmpty(workExperience)) {
            param.put("p.work_experience", workExperience);
        }
        if (DataUtils.isNotNullOrEmpty(salary)) {
            param.put("p.salary", salary);
        }
        if (DataUtils.isNotNullOrEmpty(status)) {
            param.put("p.status", status);
        }
        if (DataUtils.isNotNullOrEmpty(startAt)) {
            param.put("p.release_at & >= ", startAt);
        }
        if (DataUtils.isNotNullOrEmpty(endAt)) {
            param.put("p.release_at & <= ", endAt);
        }
        param.put("@order", "p.release_at desc");
        param.put("@query", "p.id");
        param.put("@table", "profession p,company c");
        param.put("p.c_id", "c.id ");
        log.info("getProfessionList sql :" + SQLUtil.convert2Sql(param, 0, Integer.MAX_VALUE));
        return param;
    }

    /**
     * 通过公司id查询在招职位
     *
     * @param cid
     * @return
     */
    public static Map<String, Object> getProfessionIds(Long cid, Boolean count) {

        Map<String, Object> param = new HashMap<>();
        param.put("c_id", cid);
        if (count) {
            param.put("@query", "count(id)");
        } else

            param.put("@query", "id");
        param.put("@table", "profession");
        param.put("@order", "release_at desc");
        log.info("sql:" + SQLUtil.convert2Sql(param, 0, Integer.MAX_VALUE));
        return param;

    }

    /**
     * 根据职位id查询职位标签ids
     *
     * @param id
     * @param count
     * @return
     */
    public static Map<String, Object> getProfessionTagIds(Long id, boolean count) {
        Map<String, Object> param = new HashMap<>();
        if (DataUtils.isNotNullOrEmpty(id)) {
            param.put("pid", id);
        }
        if (count) {
            param.put("@query", "count(id)");
        } else {
            param.put("@query", "id");
        }
        param.put("@table", "profession_tag");
        return param;
    }

    public static Map<String, Object> getpTagIdsByPId(Long pId) {
        Map<String, Object> param = new HashMap<>();
        param.put("pid", pId);
        param.put("@query", "id");
        param.put("@table", "profession_tag");
        return param;
    }


    public static Map<String, Object> getProductList(Long cId) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("cid", cId);
        params.put("@query", " id ");
        params.put("@table", " product ");
        params.put("@order", "create_at desc");
        log.info("get productList sql is " + SQLUtil.convert2Sql(params, 0, Integer.MAX_VALUE));
        return params;
    }

    /**
     * 根据cid得到标签
     *
     * @param CId
     * @return
     */
    public static Map<String, Object> getTagList(Long CId) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("cid", CId);
        params.put("@query", " id ");
        params.put("@table", " company_tag ");
        params.put("@order", " create_at desc ");
        log.info("get tagList sql is " + SQLUtil.convert2Sql(params, 0, Integer.MAX_VALUE));
        return params;
    }

    /**
     * 公司列表
     *
     * @param name
     * @param province
     * @param city
     * @param county
     * @param productName
     * @param industry
     * @param financing
     * @param approved
     * @param freezed
     * @return
     */
    public static Map<String, Object> getCompanyList(String name, Integer province, Integer city, Integer county, String productName,
                                                     Integer industry, Integer financing, Integer approved, Integer freezed) {

//        select c.id from company c JOIN product p ON c.id = p.cid and cName like ? and pName like ? and province in ? and ...
        Map<String, Object> params = new HashMap<String, Object>();
        if (DataUtils.isNotNullOrEmpty(name)) {
            params.put("c.Name & like ", "'%" + name + "%'");
        }
        if (DataUtils.isNotNullOrEmpty(productName)) {
            params.put("p.name & like ", "'%" + productName + "%'");
        }
        if (DataUtils.isNotNullOrEmpty(province)) {
            params.put("c.province ", "'" + province + "'");
        }
        if (DataUtils.isNotNullOrEmpty(city)) {
            params.put("c.city ", "'" + city + "'");
        }
        if (DataUtils.isNotNullOrEmpty(county)) {
            params.put("c.county ", "'" + county + "'");
        }
        if (DataUtils.isNotNullOrEmpty(industry)) {
            params.put("c.industry", +industry);
        }

//        if (industry.length != 0) {
//            StringBuffer sb = new StringBuffer();
//            for (Integer num : industry) {
//                sb.append(num);
//                sb.append(",");
//            }
//            sb.delete(sb.length() - 1, sb.length());
//            log.debug(sb.toString());
//            params.put("c.industry & in", "(" + sb.toString() + ")");
//        }



        if (DataUtils.isNotNullOrEmpty(financing)) {
            params.put("c.financing", financing);
        }
        if (DataUtils.isNotNullOrEmpty(approved)) {
            params.put("c.approved", approved);
        }
        if (DataUtils.isNotNullOrEmpty(freezed)) {
            params.put("c.freezed", freezed);
        }
        params.put("@query", "c.id");
        params.put("@table", " company c " + "JOIN " + "product p " + "ON " + " c.id = p.cid");
        params.put("@order", " c.create_at desc");

        log.info("getCompanyList sql is " + SQLUtil.convert2Sql(params, 0, 0));
        return params;
    }

    public static Map<String, Object> getManagerList(String name) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("@query", "id");
        params.put("@table", "manager");
        params.put("name", "'" + name + "'");

        log.info("get manager sql is " + SQLUtil.convert2Sql(params, 0, 0));
        return params;
    }

    /**
     * 前台最新职位
     *
     * @return
     */
    public static Map<String, Object> getPosition() {
        Map<String, Object> param = new HashMap<>();
        param.put("@query", "c.id");
        param.put("@table", "profession p,company c");
        param.put("@order", "p.release_at desc");
        param.put("c.id", "p.c_id");
        log.info("get Position sql is :");
        return param;
    }

    public static Map<String, Object> getPositionSearch(String name, Integer city, Integer industry, Integer county,
                                                        Integer workExperience, Integer salary, Integer province,
                                                        Integer recommend, Integer releaseAt, Integer education) {

        Map<String, Object> param = new HashMap<>();
        if (DataUtils.isNotNullOrEmpty(name)) {
            param.put("p.name & like", "'%" + name + "%'");
        }
        if (DataUtils.isNotNullOrEmpty(city)) {
            param.put("p.city", city);
        }
        if (DataUtils.isNotNullOrEmpty(province)) {
            param.put("p.province", province);
        }
        if (DataUtils.isNotNullOrEmpty(county)) {
            param.put("p.county", county);
        }
        if (DataUtils.isNotNullOrEmpty(workExperience)) {
            param.put("p.work_experience", workExperience);
        }
        if (DataUtils.isNotNullOrEmpty(industry)) {
            param.put("p.industry", industry);
        }
        if (DataUtils.isNotNullOrEmpty(salary)) {
            param.put("p.salary", salary);
        }
        if (DataUtils.isNotNullOrEmpty(education)) {
            param.put("p.education", education);
        }
        if (DataUtils.isNotNullOrEmpty(recommend)) {
            if (recommend != 0) {
                param.put("@order", "p.recommend desc,p.release_at desc");
            } else {
                param.put("@order", "p.release_at desc");
            }
        }
        if (DataUtils.isNotNullOrEmpty(releaseAt)) {
            Long current = System.currentTimeMillis(); //当前时间戳
            //今天0点时间戳
            Long time = current - (24 * 3600 * 1000) * (24 * 3600 * 1000) - TimeZone.getDefault().getRawOffset();

            switch (releaseAt) {
                case 0://当天发布
                    param.put("p.release_at & >=", time);
                    break;
                case 1://三天内发布
                    param.put("p.release_at & >=", time - (24 * 3600 * 1000) * 2);
                    break;
                case (2)://七天内发布
                    param.put("p.release_at & >=", time - (24 * 3600 * 1000) * 6);
                    break;
            }
        }
        param.put("@query", "p.id");
        param.put("@table", "profession p,company c");
        param.put("c.id", "p.c_id");
        log.info("get Position sql is " + SQLUtil.convert2Sql(param, 0, 0));
        return param;
    }

    public static Map<String, Object> getCompanyTagList() {
        Map<String, Object> param = new HashMap<>();
        param.put("@query", "id");
        param.put("@table", "company_tag");
        param.put("@order", "create_at desc");
        log.info("get sql is :" + SQLUtil.convert2Sql(param, 0, 0));
        return param;
    }


}
