package com.ptteng.login.util;

import com.whalin.MemCached.MemCachedClient;

import java.util.Date;

/**
 * Created by shun on 2017/6/30.
 */
public class MemcachedUtils {
    private static MemCachedClient cachedClient;

    static {
        if (cachedClient == null) {
            cachedClient = new MemCachedClient("memCachedPool");
        }
    }

    private MemcachedUtils() {
    }

    public static boolean set(String key, Object value) {
        return setExp(key, value, null);
    }

    public static boolean set(String key, Object value, Date expire) {
        return setExp(key, value, expire);
    }

    public static boolean setExp(String key, Object value, Date expire) {
        boolean flag = false;
        try {
            flag = cachedClient.set(key, value, expire);
        } catch (Exception e) {

        }
        return flag;
    }

    public static boolean add(String key, Object value) {
        return addExp(key, value, null);
    }

    public static boolean add(String key, Object value, Date expire) {

        return addExp(key, value, expire);
    }

    public static boolean addExp(String key, Object value, Date expire) {
        boolean flag = false;
        try {
            flag = cachedClient.add(key, value, expire);
        } catch (Exception e) {

        }
        return flag;
    }

    public static boolean replace(String key, Object value) {
        return replaceExp(key, value, null);
    }

    /**
     * 仅当键已经存在时，replace命令才会替换缓存中的键
     *
     * @param key
     * @param value
     * @param expire 过期时间 New Date（1000*10）：十秒过期
     * @return
     */
    public static boolean replace(String key, Object value, Date expire) {
        return replaceExp(key, value, expire);
    }

    /**
     * 仅当键已经存在时，replace命令才会替换缓存中的键
     *
     * @param key
     * @param value
     * @param expire 过期时间 New Date（1000*10）：十秒过期
     * @return
     */
    public static boolean replaceExp(String key, Object value, Date expire) {
        boolean flag = false;
        try {
            flag = cachedClient.replace(key, value, expire);
        } catch (Exception e) {

        }
        return flag;
    }

    /**
     * get 命令用于检索与之前添加的键值对相关的值
     *
     * @param key
     * @return
     */
    public static Object get(String key) {
        Object obj = null;
        try {
            obj = cachedClient.get(key);
        } catch (Exception e) {

        }
        return obj;
    }

    /**
     * 删除 memcached中的任何现有值。
     *
     * @param key
     * @param expire
     * @return
     */
    public static boolean delete(String key, Date expire) {
        return deleteExp(key, expire);
    }

    /**
     * 删除memcached中的任何现有值
     *
     * @param key
     * @param expire
     * @return
     */
    private static boolean deleteExp(String key, Date expire) {
        boolean flag = false;
        try {
            flag = cachedClient.delete(key, expire);
        } catch (Exception e) {

        }
        return flag;
    }

    /**
     * 清理缓存中的所有键-值对
     *
     * @return
     */
    public static boolean flushAll() {
        boolean flag = false;
        try {
            flag = cachedClient.flushAll();
        } catch (Exception e) {

        }
        return flag;
    }
}