package util;

import com.ptteng.common.dao.util.SQLUtil;
import com.qding.common.util.DataUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.*;

public class DynamicUtil {

    private static final Log log = LogFactory.getLog(DynamicUtil.class);

    /**
     * 搜索公司页 & 公司列表
     */
    public static Map<String, Object> getCompanyList(String name, Integer province, Integer city, Integer county,
                                                     Integer industry, Integer financing, Integer approved) {
        //创建map集合
        Map<String, Object> params = new HashMap<String, Object>();
        //动态SQL组装判断
        if (DataUtils.isNotNullOrEmpty(name)) {
            params.put("name & like ", "'%" + name + "%'");
        }
        if (DataUtils.isNotNullOrEmpty(province)) {
            params.put("province ", province);
        }
        if (DataUtils.isNotNullOrEmpty(city)) {
            params.put("city ", city);
        }
        if (DataUtils.isNotNullOrEmpty(county)) {
            params.put("county ", county);
        }
        if (DataUtils.isNotNullOrEmpty(industry)) {
            params.put("industry ", industry);
        }
        if (DataUtils.isNotNullOrEmpty(financing)) {
            params.put("financing ", financing);
        }
        if (DataUtils.isNotNullOrEmpty(approved)) {
            params.put("approved", approved);
        }
        params.put("freezed", 0);
        params.put("@query", "id");
        //先按照认证排序，再按照新建时间排序
        params.put("@order", " approved desc, create_at desc");
        params.put("@table", "company");
        log.info("getCompanyList sql is " + SQLUtil.convert2Sql(params, 0, 0));

        return params;
    }

    /**
     * 获取推荐公司
     * @return
     */
    public static Map<String, Object> getRecommendCompany() {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("freezed", 0);
        param.put("approved", 1);
        param.put("@query", "id");
        param.put("@table", "company");
        log.info("getRecommendCompany sql is " + SQLUtil.convert2Sql(param, 0, Integer.MAX_VALUE));
        return param;
    }

    /**
     * 通过公司id拿到标签列表
     */
    public static Map<String, Object> getCompanyTagListByCid(Long cId) {

        //创建map集合
        Map<String, Object> params = new HashMap<String, Object>();
        // select id from company_tag where cid = ? order by create_at desc
        if (DataUtils.isNotNullOrEmpty(cId)) {
            params.put(" cid ", cId);
        }
        params.put("@query", " id ");
        params.put("@order", " create_at desc");
        params.put("@table", " company_tag ");
        log.info("getCompanyTagListByCid sql is " + SQLUtil.convert2Sql(params, 0, 0));

        return params;
    }

    /**
     * 获取全部companyTag
     *
     * @return
     */
    public static Map<String, Object>getCompanyTag() {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("@query", " id ");
        params.put("@order", " create_at desc");
        params.put("@table", " company_tag ");
        log.info("getCompanyTagListByCid sql is " + SQLUtil.convert2Sql(params, 0, 0));
        return params;
    }

    /**
     * 通过公司id拿到产品列表
     */
    public static Map<String, Object> getProductList(Long cId) {

        //创建map集合
        Map<String, Object> params = new HashMap<String, Object>();
        // select id from product where cid = ? order by create_at desc
        if (DataUtils.isNotNullOrEmpty(cId)) {
            params.put(" cid ",cId);
        }
        params.put("@query", " id ");
        params.put("@table", " product ");
        params.put("@order", " create_at DESC");
        log.info("getProductList sql is " + SQLUtil.convert2Sql(params, 0, 0));

        return params;
    }

    /**
     * 通过公司id拿到职位
     *
     * @param cid
     * @param type
     * @return
     */
    public static Map<String, Object> getProfessionByCid(Long cid, Integer type, boolean bl) {
        Map<String, Object> params = new HashMap<String, Object>();
        if (DataUtils.isNotNullOrEmpty(cid)) {
            params.put("c_id", cid);
        }
        if (DataUtils.isNotNullOrEmpty(type)) {
            params.put("type ", type);
        }
        if (bl) {
            params.put("@query", "count(id)");
        } else {
            params.put("@query", "id");

        }
        params.put("@table", "profession");
        params.put("@order", "update_at desc ");

        log.info("getProfessionByCid sql is " + SQLUtil.convert2Sql(params, 0, Integer.MAX_VALUE));
        return params;
    }

    /**
     * 仅根据公司id获得职位id
     *
     * @param id
     * @return
     */
    public static Map<String, Object> getProfessionOnlyByCid(Long id) {
        Map<String, Object> params = new HashMap<String, Object>();
        if (DataUtils.isNotNullOrEmpty(id)) {
            params.put("c_id", id);
        }
        params.put("@query", "id");
        params.put("@table", "profession");

        log.info("getProfessionOnlyByCid sql is " + SQLUtil.convert2Sql(params, 0, Integer.MAX_VALUE));
        return params;
    }

    /**
     * 获取职业列表
     *
     * @param name       职业名称
     * @param province   省
     * @param city       市
     * @param county     区
     * @param industry   所属行业
     * @param
     * @param welfare    薪资
     * @param releaseAt  发布时间
     * @param recommend  推荐状态
     * @return
     */
    public static Map<String, Object> getProfessionList(String name, Integer province, Integer city, Integer county,
                                                        Integer industry, Integer education, Integer experience, Integer welfare,
                                                        Integer releaseAt,Integer type, Integer subType, Integer grade, Integer recommend, Integer salary) {

        Map<String, Object> params = new HashMap<String, Object>();

        if (DataUtils.isNotNullOrEmpty(name)) {
            params.put("p.name & like ", "'%" + name + "%'");
        }
        if (DataUtils.isNotNullOrEmpty(province)) {
            params.put("c.province", province);
        }
        if (DataUtils.isNotNullOrEmpty(city)) {
            params.put("c.city", city);
        }
        if (DataUtils.isNotNullOrEmpty(county)) {
            params.put("c.county", county);
        }
        if (DataUtils.isNotNullOrEmpty(industry)) {
            params.put("c.industry", industry);
        }
        if (DataUtils.isNotNullOrEmpty(education)) {
            params.put("p.education", education);
        }
        if (DataUtils.isNotNullOrEmpty(salary)) {
            params.put("p.salary", salary);
        }
        if (DataUtils.isNotNullOrEmpty(experience)) {
            params.put("p.work_experience", experience);
        }
        if (DataUtils.isNotNullOrEmpty(welfare)) {
            params.put("p.welfare", welfare);
        }
        if (DataUtils.isNotNullOrEmpty(type)) {
            params.put("p.type", type);
        }
        if (DataUtils.isNotNullOrEmpty(subType)) {
            params.put("p.subType", subType);
        }
        if (DataUtils.isNotNullOrEmpty(grade)) {
            params.put("p.grade", grade);
        }
        if (DataUtils.isNotNullOrEmpty(recommend)) {
            if (recommend != 0 && recommend != 1) {
                params.put("@order", "p.release_at desc");
            } else {
                params.put("p.recommend", recommend);

            }
        }
        if (DataUtils.isNotNullOrEmpty(releaseAt)) {
            //获取当前零时的时间戳

            Long current = System.currentTimeMillis(); //当前时间戳

            Long time = current/(1000*3600*24)*(1000*3600*24) - TimeZone.getDefault().getRawOffset();

            log.info("零时时间戳：" + time);
            switch (releaseAt) {
                //当天发布，创建时间要大于time
                case 0:
                    params.put("p.release_at & >= ", time);
                    break;
                //三天内创建，创建时间要大于2天前零时的时间戳
                case 1:
                    params.put("p.release_at & >= ", time - 86400000 * 2);
                    break;
                //七天内创建，创建时间要大于6天前零时的时间戳
                case 2:
                    params.put("p.release_at & >= ", time - 86400000 * 6);
                    break;
            }
        }
        params.put("@query", "p.id");
        params.put("@order", "p.release_at desc");
        params.put("@table", "profession p, company c");
        params.put("p.c_id", "c.id");
        log.info("getProfessionList sql is " + SQLUtil.convert2Sql(params, 0, Integer.MAX_VALUE));
        return params;
    }


    /**
     * 根据职位id拿到职位标签
     *
     * @param pid
     * @return
     */
    public static Map<String, Object> getProfessionTagById(Long pid) {
        Map<String, Object> params = new HashMap<String, Object>();
        if (DataUtils.isNotNullOrEmpty(pid)) {
            params.put("pid", pid);
        }
        params.put("@query", "id");
        params.put("@table", "profession_tag");
        params.put("@order", "create_At desc");

        log.info("get professionTag sql is " + SQLUtil.convert2Sql(params, 0, 0));

        return params;
    }



    public static Map<String, Object> getNewProfession(boolean bl) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("@query", "c.id");
        params.put("@order", "p.release_at desc");

        if (bl) {
            params.put("@table", "profession p JOIN company c ON c.id = p.c_id and c.approved = 0");
//            params.put("@table", "profession where c_id in (select id from company where approved = 0)");
        } else {
            params.put("@table", "profession p JOIN company c ON c.id = p.c_id and c.approved = 1");
        }

        return params;
    }


    public static Map<String, Object> getArticel(Integer type) {
        Map<String, Object> param = new HashMap<>();
        param.put("@query", "id");
        param.put("@table", "article");
        param.put("@order", "create_at desc");
        if (DataUtils.isNotNullOrEmpty(type)) {
            param.put("type", type);

        }
        return param;


    }

   /* public static List<Company> getSuccessCompany(boolean bl) throws Exception {
        Map<String, Object> params = null;
        List<Long> professionIdsList = null;
        List<Profession> professionList = null;
        List<Long> companyIdsList = null;
        List<Company> companyList = null;

        //拿到职位idslist
        params = DynamicUtil.getNewProfession(bl);
        professionIdsList = professionService.getIdsByDynamicCondition(Profession.class, params, 0, Integer.MAX_VALUE);
        //拿到职位对象
        professionList = professionService.getObjectsByIds(professionIdsList);
        //遍历拿到公司ids
        for (Profession p : professionList) {
            companyIdsList.add(p.getcId());
        }
        log.info("公司id去重前list: " + companyIdsList);
        LinkedHashSet<Long> companySet = new LinkedHashSet<Long>(companyIdsList);
        ArrayList<Long> newCompanyIdsList = new ArrayList<Long>(companySet);
        log.info("公司id去重后list: " + newCompanyIdsList);
        //拿到公司对象List
        companyList = companyService.getObjectsByIds(newCompanyIdsList);
        log.info("get companyList data is " + companyList);

        return companyList;
    }*/
}
