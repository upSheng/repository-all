package com.chs.activity.utils;

import com.chs.activity.config.Constans;
import org.springframework.util.DigestUtils;

import java.util.Map;

/**
 * @author : HongSheng.Chen
 * @date : 2021/3/10 9:55
 */
public class SignUtils {

    public static String sign(Map<String, String> map, String key) {


        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            sb.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
        }
        sb.append("key=").append(key);
        return DigestUtils.md5DigestAsHex(sb.toString().getBytes()).toUpperCase();
    }
}
