package com.ptteng.score.admin.util;

import java.util.Calendar;

/**
 * Title:    score
 * Description:
 * Company:  www.jnshu.com
 *
 * @author hfismyangel@163.com
 * @version 1.0
 * @Ddate 2017/9/30
 */
public class DateUtil {

    //当天小时时间戳
    public static long timeUtill(int num) {
        /*
        时间处理方法
         */
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR, num);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
//        long zero = cal.toInstant().toEpochMilli()/* - (long) 1000 * 60 * 60 * 24 * 1*/;
        long time = cal.toInstant().toEpochMilli()/* - (long) 1000 * 60 * 60 * 24 * 1*/;
        return time;
    }


    //当天零点时间戳
    public static long timeUtil(long num) {
        /*
        时间处理方法
         */
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
        long time = cal.toInstant().toEpochMilli() - (long) 1000 * 60 * 60 * 24 * num;
        return time;
    }


    public static void main(String[] args) {
        Long time = 0L;
        time = timeUtill(12);
        System.out.println(time);

    }


    //当月第一天零点时间戳
    public static long getCurrentMonthLastDay() {
        Calendar a = Calendar.getInstance();
        a.set(Calendar.DATE, 1);//把日期设置为当月第一天
        // a.roll(Calendar.DATE, -1);//日期回滚一天，也就是最后一天
        a.set(Calendar.HOUR, 0);
        a.set(Calendar.SECOND, 0);
        a.set(Calendar.MINUTE, 0);
        a.set(Calendar.MILLISECOND, 0);
        long time = a.toInstant().toEpochMilli();
        return time;
    }


    //传ture是当年第一天零点 传fasle是当前季度第一天零点
    public static long getQuarterByMonth(boolean iniYear) {
        Calendar cale = Calendar.getInstance();
        int month = cale.get(Calendar.MONTH) + 1;
        int months[] = {0, 3, 6, 9};
        int season;
        if (month >= 0 && month <= 2) // 1-3月;0,1,2
        {
            season = months[0];
        } else if (month >= 3 && month <= 5) // 4-6月;3,4,5
        {
            season = months[1];
        } else if (month >= 6 && month <= 8) // 7-9月;6,7,8
        {
            season = months[2];
        } else {  // 10-12月;10,11,12
            season = months[3];
        }
        if (iniYear) {
            season = 1;
        }
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.MONTH, season - 1);
        cal.set(Calendar.DATE, 1);
        cal.set(Calendar.HOUR, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.toInstant().toEpochMilli();
    }


}
