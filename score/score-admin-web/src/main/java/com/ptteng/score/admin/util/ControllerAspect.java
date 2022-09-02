package com.ptteng.score.admin.util;

import com.ptteng.score.admin.model.Manager;
import com.ptteng.score.admin.model.OperationLog;
import com.ptteng.score.admin.service.ManagerService;
import com.ptteng.score.admin.service.OperationLogService;
import com.qding.common.util.http.cookie.CookieUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Properties;

/**
 * Title:    score
 * Description:
 * Company:  www.jnshu.com
 *
 * @author hfismyangel@163.com
 * @version 1.0
 * @Ddate 2017/9/29
 */
@Aspect
@Component
public class ControllerAspect {
    /**
    *@Author hfismyangel@163.com
    *@Description:aop拦截器，用于拦截增删改的请求，记录操作日志，可以打开定时批量提交模式
    *@Date: 21:41 2017/10/21
       * @param null
    */

    private static final Log log = LogFactory.getLog(ControllerAspect.class);
    @Autowired
    private CookieUtil cookieUtil;
    @Autowired
    private OperationLogService operationLogService;
    @Autowired
    private ManagerService managerService;
    private Properties properties = ReadPropertiesUtil.getErrorCodeProperties();

    @After(value = "execution(* com.ptteng.score.admin.controller.*.*(..)) && @annotation(annotation)")
    public void operationRecord(JoinPoint point, ControllerAnnotation annotation) throws Throwable {
        /**
         *@Author hfismyangel@163.com
         *@Description:AOP通过属性文件记录操作日志
         * 自定义注解，注解参数为业务码，建立业务码和操作的映射，将操作放入队列，后台线程处理，aop拦截此注解
         * 日志放入队列中，日志这个是不影响业务的操作，用队列记录然后线程定时去处理，不占用处理业务的时间
         *如果是并发不高的系统，日志记录可以同步,非业务流程或者不影响返回的流程，一般都使用线程池进行优化
         *@Date: 21:30 2017/9/29
         * @param point
         * @param annotation
         */
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        log.debug("=================>aop add log>" + annotation.value());
        //获取操作人
        String keyIdentity = cookieUtil.getKeyIdentity(request, CookieUtil.USER_ID);
        Long adminId = Long.valueOf(keyIdentity);
        //通过注解获取具体操作记录
        String property = properties.getProperty(annotation.value());
        Manager admin = managerService.getObjectById(adminId);
        //插入操作记录
        OperationLog operationLog = new OperationLog();
        operationLog.setAdmin(admin.getName());
        operationLog.setOperation(property);
        operationLog.setCreateBy(adminId);
        operationLog.setUpdateBy(adminId);
        Long insert = operationLogService.insert(operationLog);
        log.debug("=================>insert operation log id>>" + insert);

        //开启线程池定时提交日志模式
        /*Queue<QueueDealStructure> queueInstance = TaskThreadPools.getQueueInstance();
        QueueDealStructure queueDealStructure = new QueueDealStructure();
        queueDealStructure.setProperty(property);
        queueDealStructure.setKeyIdentity(keyIdentity);
        queueInstance.offer(queueDealStructure);*/
    }
}

