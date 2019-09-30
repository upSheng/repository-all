package com.web.service.impl;

import com.web.entity.User;
import com.web.repository.UserRepository;
import com.web.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findByName(String name) {
        return userRepository.findByName(name);
    }

    @Override
    public void save(User user) {

        userRepository.save(user);
    }

    @Override
    public void deleteById(String id) {
        userRepository.deleteById(id);

    }
}
