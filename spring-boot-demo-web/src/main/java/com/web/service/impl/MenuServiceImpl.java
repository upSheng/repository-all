package com.web.service.impl;

import com.web.dao.IMenuMapper;
import com.web.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 陈洪生<br>
 * <b>mail</b> chenhongsheng@tansun.com.cn<br>
 * <b>date</b> 2019/10/1<br>
 * @version 1.0.1
 * <pre>
 * 版本            修改人            修改日期            修改内容描述
 * --------------------------------------------------------------------
 * 1.0.1 	       陈洪生	        2019/10/1            创建
 * --------------------------------------------------------------------
 * </pre>
 */
@Service
public class MenuServiceImpl implements IMenuService {


    @Autowired
    IMenuMapper iMenuMapper;

    @Override
    public Map<String, Object> findMenuByUser(String userId) {
        Map<String,Object> user = iMenuMapper.findMenuByUser(userId);
        return user;
    }
}
