package com.chs.service;

import com.chs.entity.User;

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
public interface IUserService {

    User findByName(String name);

    void save(User user);

    void deleteById(String id);
}
