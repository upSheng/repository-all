package com.chs.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.codec.digest.DigestUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @author : HongSheng.Chen
 * @date : 2020/4/12 14:45
 */
public class SignUtil {


    public static String createSign(Map params, Boolean hasSecret, String appSecret) {
        SortedMap<String, Object> sortedMap = new TreeMap<>(params);
        StringBuilder sb = new StringBuilder();
        for (String k : sortedMap.keySet()) {
            String v = String.valueOf(params.get(k));
            if ("sign".equals(k) || v == null || v.trim().length() == 0 || "null".equals(v)) {
                continue;
            }
            sb.append(k).append("=").append(v.trim()).append("&");
        }
        if (hasSecret) {
            String paramData = sb.append("secret=").append(appSecret).toString();
            System.out.println(paramData);
            return DigestUtils.sha1Hex(paramData).substring(8).toUpperCase();
        }
        return DigestUtils.sha1Hex(sb.substring(0, sb.length() - 1)).substring(8).toUpperCase();
    }



    public static void main(String[] args) {



        Map<String, String> params = new HashMap<>();
        params.put("cpUid", "14584341ebb34959b512c9b95c70650d");
        params.put("cpSid", "89814aabd98841c9ad2acd7bed8e2ae8");
        params.put("payAmount", "600");
        params.put("payType", "2");
        params.put("productCode", "iap0001");
        params.put("productName", "少量的砖石");
        params.put("productCount", "1");
        params.put("appKey", "1127439642");
        params.put("cpOrderId", "cZgGRDPo2020082811182147");
        params.put("timestamp", "1598584708217");
        params.put("sign", "BC2C61D98E876213180F04A076BA770D");
//        params.put("voucherId", v);
        params.put("cpExtra", "viewkingdom");




        String sign = createSign(params,true,"99aecd5d36c254eb006d4c499c9e4280");
        System.out.println(sign);

//        String str = "orderAmount=1&orderId=64498-20200629195416-7321&orderProductCode=1&resultCode=SUCCESS&resultDesc=支付成功&voucherAmount=0&voucherType=0";
//        String s = DigestUtils.sha1Hex(str).substring(8).toUpperCase();
//        System.out.println(s);

    }


}
