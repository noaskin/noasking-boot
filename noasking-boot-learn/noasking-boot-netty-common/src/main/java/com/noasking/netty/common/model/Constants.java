package com.noasking.netty.common.model;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;

/**
 * 常量
 */
public class Constants {

    private static MessageDigest md5 = null;

    static {
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * 获取token信息
     *
     * @param userid
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String getToken(String userid) throws UnsupportedEncodingException {
        byte[] bs = md5.digest(userid.getBytes("utf-8"));
        StringBuilder sb = new StringBuilder(40);
        for (byte x : bs) {
            if ((x & 0xff) >> 4 == 0) {
                sb.append("0").append(Integer.toHexString(x & 0xff));
            } else {
                sb.append(Integer.toHexString(x & 0xff));
            }
        }
        return sb.toString();
    }

    /**
     * 获取ID
     *
     * @return
     */
    public static long getID() {
        return System.currentTimeMillis();
    }
}
