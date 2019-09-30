package com.web.service;

import java.util.Map;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 陈洪生<br>
 * <b>mail</b> chenhongsheng@tansun.com.cn<br>
 * <b>date</b> 2019/9/30<br>
 * @version 1.0.1
 * <pre>
 * 版本            修改人            修改日期            修改内容描述
 * --------------------------------------------------------------------
 * 1.0.1 	       陈洪生	        2019/9/30            创建
 * --------------------------------------------------------------------
 * </pre>
 */
public interface IMenuService {

    Map<String,Object> findMenuByUser(String userId);
}
