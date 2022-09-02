package util;


import org.apache.log4j.Logger;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by shun 2017.08.03.18 18:58
 */
public class CookieUtil {

    static Logger log = Logger.getLogger(CookieUtil.class);

    /**
     * 从cookie中取得当前登录的admin的ID
     *
     * @param request
     * @return
     * @throws Exception
     */
    public static Long getAdminId(HttpServletRequest request) throws Exception {
        // 引号表示一个字符串为空的对象
        String id = "";
        //获取当前路径以及父路径的cookie值
        Cookie[] cookies = request.getCookies();
        log.info("获取当前请求的cookie值：" + cookies);
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("token")) {
                    String token = cookie.getValue();
                    log.info("将cookie中的token进行解密：");
                    byte[] tk = TypeUtil.hexStringToByte(token);
                    byte[] tk1 = DESUtil.decrypt(tk, "12345678");
                    String tk2 = new String(tk1);
                    String time = "";
                    log.info("遍历解密后的字符串，得到ID");
                    for (int i = 0; i < tk2.length(); i++) {
                        char c = tk2.charAt(i);
                        if (c == '=') {
                            for (int j = i + 1; j < tk2.length(); j++) {
                                time = time + tk2.charAt(j);
                            }
                            break;
                        }
                        id = id + c;
                    }
                    return Long.parseLong(id);
                }
            }
        }
        return Long.parseLong(id);
    }

    /**
     * 将传入的ID和系统当前时间进行加密存入COOKIE中
     *
     * @param request
     * @param response
     * @param id
     */
    public static void addcookie(HttpServletRequest request, HttpServletResponse response,
                                 Long id) {
        //将id和当前时间进行加密，生成token
        String source = id + "=" + System.currentTimeMillis();
        String token = TypeUtil.bytesToHexString(DESUtil.desCrypto(source, "12345678"));
        //将token放入cookie中
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("carrots-bangbang-admin")) {
                    cookie.setValue(token);
                    cookie.setMaxAge(60 * 60 * 24);
                    response.addCookie(cookie);
                } else {
                    Cookie adminId = new Cookie("carrots-bangbang-admin", token);
                    adminId.setMaxAge(60 * 60 * 24);
                    response.addCookie(adminId);
                }
            }
        } else {
            Cookie adminId = new Cookie("carrots-bangbang-admin", token);
            adminId.setMaxAge(60 * 60 * 24);
            response.addCookie(adminId);
        }
    }


}
