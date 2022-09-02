package com.ptteng.score.home.responseStructure;

import com.ptteng.score.home.model.ScoreLog;

import java.util.List;

/**
 * Title:    score
 * Description:
 * Company:  www.jnshu.com
 *
 * @author hfismyangel@163.com
 * @version 1.0
 * @Ddate 2017/10/13
 */
public class TimeScoreLogCatagory {

    private String formatTime;
    private List<ScoreLog> scoreLogList;


    public String getFormatTime() {
        return formatTime;
    }

    public void setFormatTime(String formatTime) {
        this.formatTime = formatTime;
    }

    public List<ScoreLog> getScoreLogList() {
        return scoreLogList;
    }

    public void setScoreLogList(List<ScoreLog> scoreLogList) {
        this.scoreLogList = scoreLogList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TimeScoreLogCatagory that = (TimeScoreLogCatagory) o;

        return formatTime != null ? formatTime.equals(that.formatTime) : that.formatTime == null;
    }

    @Override
    public int hashCode() {
        return formatTime != null ? formatTime.hashCode() : 0;
    }
}
