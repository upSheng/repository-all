package com.chs.util;

import org.apache.commons.codec.digest.DigestUtils;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @author : HongSheng.Chen
 * @date : 2020/4/12 14:45
 */
public class SignUtil {

    public static String createSign(Map params, String appSecret) {
        SortedMap<String, Object> sortedMap = new TreeMap<>(params);
        StringBuilder sb = new StringBuilder();
        for (String k : sortedMap.keySet()) {
            String v = String.valueOf(params.get(k));
            if ("sign".equals(k) || v == null || v.trim().length() == 0 || "null".equals(v)) {
                continue;
            }
            sb.append(k).append("=").append(v.trim()).append("&");
        }

        String paramData = sb.append("secret=").append(appSecret).toString();
        return DigestUtils.sha1Hex(paramData).substring(8).toUpperCase();


    }
}
