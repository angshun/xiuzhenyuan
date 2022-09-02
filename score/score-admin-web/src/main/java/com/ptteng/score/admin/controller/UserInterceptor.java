//
//import com.gemantic.common.util.StringUtil;
//import com.qding.common.util.http.cookie.CookieUtil;
//import com.qding.common.util.http.cookie.UserCryptUtil;
//import org.apache.commons.collections.CollectionUtils;
//import org.apache.commons.lang.StringUtils;
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.io.UnsupportedEncodingException;
//import java.text.SimpleDateFormat;
//import java.util.*;
//
//public class UserInterceptor extends HandlerInterceptorAdapter {
//
//    private static final Log log = LogFactory.getLog("interceptor");
//
//    @Autowired
//    private UserService userService;
//    @Autowired
//    private UserMemberRelationService userMemberRelationService;
//
//    public static String SPLITTER_REGEX = "\\|";
//    public static final String USER_ID = "userId";
//
//    @Autowired
//    private CookieUtil cookieUtil;
//
//    private static final String PARAM_OS = "os";
//
//    @Override
//    public boolean preHandle(HttpServletRequest request,
//                             HttpServletResponse response, Object handler) throws Exception {
//
//        //把所有的请求参数打出来
//        log.info(" request uri: " + request.getRequestURI());
//        log.info("request token" + request.getHeader("token"));
//        Enumeration<String> names = request.getParameterNames();
//        log.info("=========================================" + request.getParameter("token"));
//        while (names.hasMoreElements()) {
//            String name = names.nextElement();
//            String value = request.getParameter(name);
//            log.info(" Parameter  name : " + name + " value : " + value);
//        }
//        //
//
//        String token = request.getParameter("token");
//        if (null == token) {
//            token = request.getHeader("token");
//        }
//        log.info("token : " + token);
//        if (StringUtil.isNotEmpty(token)) {
//            Map map = decodeCookie(token);
//            log.info("map is : " + map);
//            Long uid = null;
//            User user = null;
//            if (null != map) {
//                uid = (Long) map.get(USER_ID);
//                log.info("uid is : " + uid);
//            } else {
//                log.info("maps is null");
////                return noLogin(response,request);
//                return wrongUser(response, token);
//            }
//            if (null != uid) {
//                user = this.userService.getObjectById(uid);
//                log.info("user is : " + user);
//                if (null != user) {
//                    if (User.STATUS_OFF.equals(user.getStatus())) {
//                        return userOff(response, request);
//                    }
//
//                    //更新用户会员状态
//                    Long now = System.currentTimeMillis();
//                    List<Long> userMemberRelationIds = userMemberRelationService.getUserMemberRelationIdsByUidAndStatus(uid, User.IS_MEMBER, 0, Integer.MAX_VALUE);
//                    if (CollectionUtils.isEmpty(userMemberRelationIds)) {
//                        log.info(" user " + uid + " is not a member ");
//                        user.setIsMember(User.IS_NOT_MEMBER);
//                    } else {
//                        List<UserMemberRelation> userMemberRelations = userMemberRelationService.getObjectsByIds(userMemberRelationIds);
//                        for (UserMemberRelation userMemberRelation : userMemberRelations) {
//                            log.info(" user member endAt is " + getDate(userMemberRelation.getEndAt()) + " now is " + getDate(now));
//                            if (now.longValue() >= userMemberRelation.getEndAt().longValue()) {
//                                log.info(" user member " + userMemberRelation.getId() + " is out of date ");
//                                userMemberRelation.setStatus(User.IS_NOT_MEMBER);
//                            } else {
//                                log.info(" user member " + userMemberRelation.getId() + " is in date ");
//                            }
//                        }
//                        userMemberRelationService.updateList(userMemberRelations);
//                    }
//
//
//                    //判断用户是否是会员
//                    List<Long> userMemberRelationId = userMemberRelationService.getUserMemberRelationIdsByUidAndStatus(uid, User.IS_MEMBER, 0, 1);
//                    if (CollectionUtils.isEmpty(userMemberRelationId)) {
//                        log.info(" user " + uid + " is not a member ");
//                        user.setIsMember(User.IS_NOT_MEMBER);
//                    } else {
//                        log.info(" user is member ");
//                        user.setIsMember(User.IS_MEMBER);
//                    }
//
//
//
////                    //获取用户登录系统
////                    String os = request.getParameter(PARAM_OS);
////                    if (StringUtil.isEmpty(os)) {
////                        os = request.getHeader(PARAM_OS);
////                    }
////                    log.info("version interceptor os is: " + os);
////                    if (StringUtil.isEmpty(os) || !("android".equals(os) || "ios".equals(os) || "web".equals(os))) {
////                        log.info("arg os is empty and need force updating");
////                        response.sendRedirect("/a/force/update/version");
////                        return false;
////                    } else {
////                        log.info("user os is " + os);
////                        user.setOs(os);
////                    }
//
//                    request.setAttribute("user", user);
//                } else {
//                    log.info("user is null");
////                    return noLogin(response,request);
//                    return wrongUser(response, token);
//                }
//
//            } else {
//                log.info("uid is null");
////                return noLogin(response,request);
//                return wrongUser(response, token);
//            }
//        } else {
//            Long uid = cookieUtil.getID(request);
//            log.info("uid is " + uid);
//            if (uid == null) {
//                return wrongUser(response, token);
//            }
//            log.info("get uid  from cookie is " + uid);
//            User user = this.userService.getObjectById(uid);
//            if (user == null) {
//                return wrongUser(response, token);
//            } else {
//                log.info("get usr " + user);
//
//                if (User.STATUS_OFF.equals(user.getStatus())) {
//                    return userOff(response, request);
//                }
//                if (null != uid) {
//                    user = this.userService.getObjectById(uid);
//                    log.info("user is : " + user);
//                    if (null != user) {
//                        if (User.STATUS_OFF.equals(user.getStatus())) {
//                            return userOff(response, request);
//                        }
//
//                        //更新用户会员状态
//                        Long now = System.currentTimeMillis();
//                        List<Long> userMemberRelationIds = userMemberRelationService.getUserMemberRelationIdsByUidAndStatus(uid, User.IS_MEMBER, 0, Integer.MAX_VALUE);
//                        if (CollectionUtils.isEmpty(userMemberRelationIds)) {
//                            log.info(" user " + uid + " is not a member ");
//                            user.setIsMember(User.IS_NOT_MEMBER);
//                        } else {
//                            List<UserMemberRelation> userMemberRelations = userMemberRelationService.getObjectsByIds(userMemberRelationIds);
//                            for (UserMemberRelation userMemberRelation : userMemberRelations) {
//                                log.info(" user member endAt is " + getDate(userMemberRelation.getEndAt()) + " now is " + getDate(now));
//                                if (now.longValue() >= userMemberRelation.getEndAt().longValue()) {
//                                    log.info(" user member " + userMemberRelation.getId() + " is out of date ");
//                                    userMemberRelation.setStatus(User.IS_NOT_MEMBER);
//                                } else {
//                                    log.info(" user member " + userMemberRelation.getId() + " is in date ");
//                                }
//                            }
//                            userMemberRelationService.updateList(userMemberRelations);
//                        }
//
//
//                        //判断用户是否是会员
//                        List<Long> userMemberRelationId = userMemberRelationService.getUserMemberRelationIdsByUidAndStatus(uid, User.IS_MEMBER, 0, 1);
//                        if (CollectionUtils.isEmpty(userMemberRelationId)) {
//                            log.info(" user " + uid + " is not a member ");
//                            user.setIsMember(User.IS_NOT_MEMBER);
//                        } else {
//                            log.info(" user is member ");
//                            user.setIsMember(User.IS_MEMBER);
//                        }
//
//
////                    //获取用户登录系统
////                    String os = request.getParameter(PARAM_OS);
////                    if (StringUtil.isEmpty(os)) {
////                        os = request.getHeader(PARAM_OS);
////                    }
////                    log.info("version interceptor os is: " + os);
////                    if (StringUtil.isEmpty(os) || !("android".equals(os) || "ios".equals(os) || "web".equals(os))) {
////                        log.info("arg os is empty and need force updating");
////                        response.sendRedirect("/a/force/update/version");
////                        return false;
////                    } else {
////                        log.info("user os is " + os);
////                        user.setOs(os);
////                    }
//
//                        request.setAttribute("user", user);
//                    } else {
//                        log.info("user is null");
////                    return noLogin(response,request);
//                        return wrongUser(response, token);
//                    }
//
//                } else {
//                    log.info("uid is null");
////                return noLogin(response,request);
//                    return wrongUser(response, token);
//                }
////                //获取用户登录系统
////                String os = request.getParameter(PARAM_OS);
////                if (StringUtil.isEmpty(os)) {
////                    os = request.getHeader(PARAM_OS);
////                }
////                log.info("version interceptor os is: " + os);
////                if (StringUtil.isEmpty(os) || !("andriod".equals(os) || "ios".equals(os) || "web".equals(os))) {
////                    log.info("arg os is empty and need force updating");
////                    response.sendRedirect("/a/force/update/version");
////                    return false;
////                } else {
////                    log.info("user os is " + os);
////                    user.setOs(os);
////                }
//
//                request.setAttribute("user", user);
//            }
//            log.info("get uid is " + uid);
//            return true;
//        }
//        return true;
//    }
//
//    public static String getDate(Long time) {
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String date = "";
//
//        if (null != time) {
//            date = dateFormat.format(new Date(time));
//        }
//        return date;
//    }
//
//    public static Map getUserIdentity(String userName, Long userId) {
//        Map map = new HashMap();
//        map.put(CookieUtil.USER_NAME, userName);
//        map.put(CookieUtil.USER_ID, userId);
//        return map;
//    }
//
//    private boolean failureToken(HttpServletResponse response, Long uid) throws IOException {
//
//        log.info(" user failureToken ");
//        response.sendRedirect("/a/failure/" + uid);
//        return false;
//
//    }
//
//    private Map decodeCookie(String value) {
//        if (StringUtils.isBlank(value))
//            return null;
//        try {
//            String[] p = value.split(SPLITTER_REGEX);
//            Long userId = new Long(p[0]);
//            String crypt = p[1];
//            String plainUserInfo = UserCryptUtil.userDecrypt(crypt);
//            String userName = UserCryptUtil.getUserNameFromPlain(plainUserInfo);
//            Long uid = UserCryptUtil.getUserIdFromPlain(plainUserInfo);
//            if (userId.equals(uid)) {
//                return getUserIdentity(userName, userId);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            log.error("Wrong cookie format: [" + value + "] message is:" + e.getMessage());
//            return null;
//        }
//
//        return null;
//    }
//
//    private boolean userOff(HttpServletResponse response, HttpServletRequest request) throws IOException {
//
//        log.info(" user is  freeze");
//
//        RequestDispatcher rd = request.getRequestDispatcher("/r/json/statusOff.json");
//        try {
//            rd.forward(request, response);
//        } catch (ServletException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        return false;
//
//    }
//
//    //用户未登录
//    private boolean noLogin(HttpServletResponse response, HttpServletRequest request) throws IOException {
//
//        log.info(" manager don't login");
//
//        RequestDispatcher rd = request.getRequestDispatcher("/r/json/noLogin.json");
//        try {
//            rd.forward(request, response);
//        } catch (ServletException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        return false;
//
//    }
//
//    private boolean wrongUser(HttpServletResponse response, String token) throws IOException {
//
//        response.sendRedirect("/a/wrong/" + token);
//        return false;
//
//    }
//
//    @Override
//    public void postHandle(HttpServletRequest request,
//                           HttpServletResponse response, Object handler,
//                           ModelAndView modelAndView) throws Exception {
//
//        log.info("p =========================================== ");
//    }
//
//    /**
//     * 获取跳转链接的地址
//     *
//     * @param request
//     * @return
//     */
//    public String getInterceptorUrl(HttpServletRequest request) {
//
//        String interceptorUrl = request.getRequestURI()
//                + (null == request.getQueryString() ? "" : "?"
//                + request.getQueryString()).toString();
//        interceptorUrl = interceptorUrl.replace("/app/", "/");
//
//        log.info("get getInterceptorUrl is " + interceptorUrl);
//
//        return interceptorUrl;
//    }
//
//    public static void main(String[] args) throws UnsupportedEncodingException {
//        String value = "158|b312db2d21e59d36fefa868d6f0facd4*AGDt8TIx56z8-JG-30bQ_ZWXZmcIBq4biS2y4KMyloc";
//        String[] p = value.split(SPLITTER_REGEX);
//        Long userId = new Long(p[0]);
//        String crypt = p[1];
//        String plainUserInfo = UserCryptUtil.userDecrypt(crypt);
//        String userName = UserCryptUtil.getUserNameFromPlain(plainUserInfo);
//        Long uid = UserCryptUtil.getUserIdFromPlain(plainUserInfo);
//        log.info(uid);
//        log.info(userId);
//        if (userId.equals(uid)) {
//            log.info("token wrong");
//            System.out.print(getUserIdentity(userName, userId));
//        }
//
////		String x = URLEncoder.encode("p/hello", "utf-8");
////		log.info(x);
//
//    }
//}
