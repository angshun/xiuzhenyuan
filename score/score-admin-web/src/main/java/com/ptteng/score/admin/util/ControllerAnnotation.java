package com.ptteng.score.admin.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Title:    MapCacheTest
 * Description:
 * Company:  www.jnshu.com
 *
 * @author hfismyangel@163.com
 * @version 1.0
 * @Ddate 2017/8/8
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ControllerAnnotation {
   /**
   *@Author hfismyangel@163.com
   *@Description:操作日志映射注解，用于记录操作日志
   *@Date: 19:53 2017/10/13
      * @param
   */
   String value();
}
