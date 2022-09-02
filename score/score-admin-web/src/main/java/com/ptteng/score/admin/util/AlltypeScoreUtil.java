//package com.ptteng.score.admin.util;
//
//import com.ptteng.score.admin.constant.ConstantItem;
//import com.ptteng.score.admin.controller.AllTypeScoreController;
//import com.ptteng.score.admin.model.AllTypeScore;
//import com.ptteng.score.admin.model.Staff;
//import com.ptteng.score.admin.service.AllTypeScoreService;
//import com.ptteng.score.admin.service.StaffService;
//import com.qding.common.util.http.cookie.CookieUtil;
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//
///**
// * Created by shun 2017.10.22.15 15:03
// */
//public class AlltypeScoreUtil {
//
//    private static final Log log = LogFactory.getLog(AllTypeScoreController.class);
//
//    @Autowired
//    private StaffService staffService;
//
//    @Autowired
//    private AllTypeScoreService allTypeScoreService;
//
//    @Autowired
//    private CookieUtil cookieUtil;
//
//
//
//
//    	switch (type) {
//        case 0:
//            for (Staff s : staffList) {
//                for (Long l : list) {
//                    if (l.longValue() == s.getPositionId()) {
//                        s.setPositionId(ConstantItem.ZERO_ID);
//                        s.setPositionName(null);
//                        s.setPositionScore(ConstantItem.ZERO);
//                        staffList1.add(s);
//                    }
//                }
//            }
//            log.info("get type is: " + allTypeScore.getType());
//            break;
//        case 1:
//            for (Staff s : staffList) {
//                for (Long l : list) {
//                    log.info("get l is: "+l);
//                    if (l.longValue() == s.getDegreeId()) {
//                        log.info("get l is: "+l.longValue()+" degreeId is: "+s.getDegreeId());
//                        s.setDegreeId(ConstantItem.ZERO_ID);
//                        s.setDegreeScore(ConstantItem.ZERO);
//                        staffList1.add(s);
//                    }
//                }
//            }
//            log.info("get type is: " + allTypeScore.getType());
//            break;
//        case 2:
//            for (Staff s : staffList) {
//                for (Long l : list) {
//                    if ( s.getHonorId()==l.longValue()) {
//                        log.info("get l is: "+l.longValue());
//                        s.setHonorId(ConstantItem.ZERO_ID);
//                        s.setHonorScore(ConstantItem.ZERO);
//                        staffList1.add(s);
//                    }
//                }
//            }
//            log.info("get type is: " + allTypeScore.getType());
//            break;
//        case 3:
//            for (Staff s : staffList) {
//                for (Long l : list) {
//                    if (l.longValue() == s.getJopId()) {
//                        s.setJopId(ConstantItem.ZERO_ID);
//                        s.setJopScore(ConstantItem.ZERO);
//                        staffList1.add(s);
//                    }
//                }
//            }
//            log.info("get type is: " + allTypeScore.getType());
//            break;
//        case 4:
//            for (Staff s : staffList) {
//                for (Long l : list) {
//                    if (l.longValue() == s.getSpecialityId()) {
//                        s.setSpecialityId(ConstantItem.ZERO_ID);
//                        s.setSpecialityScore(ConstantItem.ZERO);
//                        staffList1.add(s);
//                    }
//                }
//            }
//            log.info("get type is: " + allTypeScore.getType());
//            break;
//    }
//
//}
