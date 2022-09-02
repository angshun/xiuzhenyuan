package com.ptteng.score.home.responseStructure;

/**
 * Title:    score
 * Description:
 * Company:  www.jnshu.com
 *
 * @author hfismyangel@163.com
 * @version 1.0
 * @Ddate 2017/10/25
 */
public class RewardStructure {
    private Long id;
    private String title;
    private String content;
    private Integer scoreType;
    private String img;
    private Long[] rewardId;
    private Integer[] score;
    private Integer type;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getScoreType() {
        return scoreType;
    }

    public void setScoreType(Integer scoreType) {
        this.scoreType = scoreType;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Long[] getRewardId() {
        return rewardId;
    }

    public void setRewardId(Long[] rewardId) {
        this.rewardId = rewardId;
    }

    public Integer[] getScore() {
        return score;
    }

    public void setScore(Integer[] score) {
        this.score = score;
    }
}
