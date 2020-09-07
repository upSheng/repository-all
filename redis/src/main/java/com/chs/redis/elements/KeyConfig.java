package com.chs.redis.elements;

/**
 * @author : HongSheng.Chen
 * @date : 2020/8/16 11:03
 */
public class KeyConfig {

    public static String splitWithColon(String... keys) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < keys.length; i++) {

            sb.append(keys[i]);
            if (i != keys.length - 1) {
                sb.append(":");
            }
        }
        return sb.toString();
    }
}
