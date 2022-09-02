package com.ptteng.util;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by shun on 2017/6/24.
 */
public class DataTag extends TagSupport {
    public int doStartTag() throws JspException {
        String vv = "" + value;
        long time = Long.valueOf((vv.trim()));
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(time);
        //转换为datePattern时间类型
        SimpleDateFormat dateFormat = new SimpleDateFormat(datePattern);
        String s = dateFormat.format(c.getTime());
        try {
            pageContext.getOut().write(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return super.doStartTag();
    }
    private String value;
    public String datePattern;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDatePattern() {
        return datePattern;
    }

    public void setDatePattern(String datePattern) {
        this.datePattern = datePattern;
    }



}
