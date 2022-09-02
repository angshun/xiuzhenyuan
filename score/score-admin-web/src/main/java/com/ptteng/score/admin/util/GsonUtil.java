package com.ptteng.score.admin.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Title:    score
 * Description:
 * Company:  www.jnshu.com
 *
 * @author hfismyangel@163.com
 * @version 1.0
 * @Ddate 2017/10/21
 */
public class GsonUtil {
    private static Gson serializeGson;
    private static Gson gson;

    public static Gson getUnerializeNullsGson() {
        //不序列化null的gson，线程安全
        if (gson == null) {
            gson = new Gson();
        }
        return gson;
    }

    public static Gson getGson() {
        //序列化空值的gson,Gson是线程安全的，无需加锁
        if (serializeGson == null) {
            serializeGson = new GsonBuilder().serializeNulls().create();
        }
        return serializeGson;
    }
}
