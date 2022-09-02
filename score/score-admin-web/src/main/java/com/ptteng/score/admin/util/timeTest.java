package com.ptteng.score.admin.util;

import org.junit.Test;

import java.util.Calendar;

/**
 * Created by shun 2017.10.09.22 22:52
 */
public class timeTest {




    private long timeUtil1(int hour,int minutes) {
        /*
        时间处理方法
         */
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR, hour-12);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, minutes);
        cal.set(Calendar.MILLISECOND, 0);
        long time = cal.toInstant().toEpochMilli();
        return time;
    }



    public void testTimee() {
        int hour = 10;
        int minutes = 10;
        System.out.println(timeUtil1(hour, minutes));
    }

}
