package com.chs.bi.service.impl;

import com.chs.bi.base.response.EasyPage;
import com.chs.bi.dao.UserDao;
import com.chs.bi.model.entity.User;
import com.chs.bi.model.vo.UserQuery;
import com.chs.bi.repository.UserRepository;
import com.chs.bi.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserDao userDao;

    @Override
    public User insert(User entity) {
        entity.setCreateTime(LocalDateTime.now());
        entity.setUpdateTime(LocalDateTime.now());

        return userRepository.save(entity);
    }

    @Override
    public EasyPage<User> selectPage(UserQuery userQuery) {

        Page<User> page = userRepository.findAll(PageRequest.of(0, 10));
        List<User> list = page.get().collect(Collectors.toList());

        EasyPage<User> userEasyPage = userDao.selectPage(userQuery);
        System.out.println(userEasyPage);
        return new EasyPage<>(list, page.getTotalElements());
    }
}
