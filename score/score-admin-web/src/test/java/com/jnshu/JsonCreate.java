package com.jnshu;


import com.google.gson.Gson;
import com.ptteng.score.admin.model.*;
import org.junit.Test;

/**
 * Title:    score
 * Description:
 * Company:  www.jnshu.com
 *
 * @author hfismyangel@163.com
 * @version 1.0
 * @Ddate 2017/9/27
 */
public class JsonCreate {
    Gson gson= new Gson();
    @Test
    public void TaskJson(){
        Task task = new Task();
        task.setId(3L);
        task.setTitle("打扫卫生");
        task.setContent("打扫整栋公司大厦280层的卫生间");
        task.setTaskType(0);
        task.setTaskScore(100);
        task.setProject(1);
        task.setNumber(3);
        task.setStartAt(1506487250021L);
        task.setEndAt(1606487291477L);
//        System.out.println(gson.toJson(task));

        ScoreType scoreType=new ScoreType();
        scoreType.setMoral("好人卡");
        scoreType.setContent("你是个好人呦~");
        System.out.println(gson.toJson(scoreType));

        Philosophy philosophy = new Philosophy();
        philosophy.setTitle("哲♂学");
        philosophy.setContent("至高哲学");
        System.out.println(gson.toJson(philosophy));

        Notice notice=new Notice();
        notice.setContent("前方有敌人！");
        notice.setId(2L);
        System.out.println(gson.toJson(notice));

        EnterpriseLog enterpriseLog= new EnterpriseLog();
        enterpriseLog.setId(2L);
        enterpriseLog.setLogContent("hahahahha");
        System.out.println(gson.toJson(enterpriseLog));

        EnterpriseApproval enterpriseApproval=new EnterpriseApproval();
        enterpriseApproval.setId(3L);
        enterpriseApproval.setContent("我就想加分，不行吗？");
        enterpriseApproval.setTitle("老子想加多少加多少");
        enterpriseApproval.setApplyId(2L);
        enterpriseApproval.setApprovalId(3L);
        System.out.println(gson.toJson(enterpriseApproval));

    }

    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
    }
}
