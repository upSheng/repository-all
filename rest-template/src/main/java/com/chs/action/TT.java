package com.chs.action;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 陈洪生<br>
 * <b>mail</b> chenhongsheng@tansun.com.cn<br>
 * <b>date</b> 2019/7/27<br>
 * @version 1.0.1
 * <pre>
 * 版本            修改人            修改日期            修改内容描述
 * --------------------------------------------------------------------
 * 1.0.1 	       陈洪生	        2019/7/27            创建
 * --------------------------------------------------------------------
 * </pre>
 */
public class TT {

    public static void main(String[] args) {

            MultiValueMap<String, Object> paramMap = new LinkedMultiValueMap<String, Object>();
            paramMap.add("mchid", "1547187151");

            System.out.println(paramMap.getFirst("mchid"));
            System.out.println(paramMap.get("mchid").toString());

    }
}
