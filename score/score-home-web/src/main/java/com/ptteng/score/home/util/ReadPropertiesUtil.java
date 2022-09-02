package com.ptteng.score.home.util;


import com.ptteng.score.home.responseStructure.ResponseInfo;

import java.io.*;
import java.net.URL;
import java.util.Properties;

/**
 * Title:    score
 * Description:
 * Company:  www.jnshu.com
 *
 * @author hfismyangel@163.com
 * @version 1.0
 * @Ddate 2017/9/27
 */
public class ReadPropertiesUtil {
    private static Properties p;

    private ReadPropertiesUtil() {
    }


    public static Properties getErrorCodeProperties() throws IOException {
        /**
         *@Author hfismyangel@163.com
         *@Description:属性文件读取工具
         *@Date: 20:00 2017/10/13
         * @param
         */
        //properties继承hashtable，自带线程安全
        if (p == null) {
            URL url = ResponseInfo.class.getClassLoader().getResource("exception_zh.properties");
            InputStream in = new BufferedInputStream(new FileInputStream(url.getPath()));
            p = new Properties();
            p.load(new InputStreamReader(in, "utf-8"));

        }
        return p;
    }

}
