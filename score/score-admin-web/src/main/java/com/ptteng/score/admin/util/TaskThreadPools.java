package com.ptteng.score.admin.util;

import com.ptteng.score.admin.model.Manager;
import com.ptteng.score.admin.model.OperationLog;
import com.ptteng.score.admin.responseStructure.QueueDealStructure;
import com.ptteng.score.admin.service.ManagerService;
import com.ptteng.score.admin.service.OperationLogService;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;

/**
 * Title:    score
 * Description:
 * Company:  www.jnshu.com
 *
 * @author hfismyangel@163.com
 * @version 1.0
 * @Ddate 2017/10/11
 */
//@Component
public class TaskThreadPools {
    @Autowired
    private ManagerService managerService;
    @Autowired
    private OperationLogService operationLogService;

    private static final org.apache.commons.logging.Log log = LogFactory.getLog(TaskThreadPools.class);
    //线程池对队列的操作可能并发，需要volatile保证队列内存可见性
    private static volatile Queue<QueueDealStructure> dataQueue;
    private volatile List<OperationLog> logs = Collections.synchronizedList(new ArrayList<>());

    public static Queue<QueueDealStructure> getQueueInstance() {
        if (dataQueue == null) {
            //LinkedList实现了Queue接口，可以用LinkedList做一个队列,这里使用阻塞队列BlockingQueue
            dataQueue = new LinkedBlockingQueue<>();
        }
        return dataQueue;
    }

    public void commitLogPool() {
        /**
        *@Author hfismyangel@163.com
        *@Description:定时任务线程池自动提交日志
        *@Date: 20:01 2017/10/13
           * @param
        */
        if (getQueueInstance().peek() != null) {
            log.info("===================poll is not null，make Executor>>");
            int size;
            //初始化固定容量为队列长度的Executor
            ExecutorService threadPoolExecutor = Executors.newFixedThreadPool((size = getQueueInstance().size()));

            for (int i = 0; i < size; i++) {
                threadPoolExecutor.submit(new Runnable() {
                    @Override
                    public void run() {
                        QueueDealStructure poll;
                        if ((poll = getQueueInstance().poll()) != null) {
                            try {
                                String keyIdentity = poll.getKeyIdentity();
                                String property = poll.getProperty();
                                log.info("===================thread start and Thread id>>" + Thread.currentThread().getId());
                                Long adminId = Long.valueOf(keyIdentity);
                                Manager admin = managerService.getObjectById(adminId);
                                //创建日志对象
                                OperationLog operationLog = new OperationLog();
                                operationLog.setAdmin(admin.getName());
                                operationLog.setOperation(property);
                                operationLog.setCreateBy(adminId);
                                operationLog.setUpdateBy(adminId);
                                logs.add(operationLog);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });
            }
            //及时关闭，否则可能引起内存泄露
            threadPoolExecutor.shutdown();
            if (logs.size() != 0) {
                try {
                    //批量插入
                    operationLogService.insertList(logs);
                    log.info("==================insert database finish>>");
                    logs.clear();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Scheduled(cron = "0 0 0/1 * * ?")
    public void timer() {
        //spring timer定时提交任务
        commitLogPool();
    }
}
