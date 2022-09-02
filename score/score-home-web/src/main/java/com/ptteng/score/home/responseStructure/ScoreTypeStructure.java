package com.ptteng.score.home.responseStructure;

import com.ptteng.score.home.model.ScoreType;

import java.util.List;

/**
 * Title:    score
 * Description:
 * Company:  www.jnshu.com
 *
 * @author hfismyangel@163.com
 * @version 1.0
 * @Ddate 2017/10/26
 */
public class ScoreTypeStructure {
    private Long applyId;
    private List<ScoreType> scoreTypeList;

    public Long getApplyId() {
        return applyId;
    }

    public void setApplyId(Long applyId) {
        this.applyId = applyId;
    }

    public List<ScoreType> getScoreTypeList() {
        return scoreTypeList;
    }

    public void setScoreTypeList(List<ScoreType> scoreTypeList) {
        this.scoreTypeList = scoreTypeList;
    }
}
