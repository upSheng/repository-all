package com.web.service.impl;

import com.web.entity.UserEntity;
import com.web.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


@Service
public class UserServiceImpl {

    @Resource
    private UserRepository userRepository;


    public UserEntity findByName(String name) {
        return userRepository.findByName(name);
    }

    public void save(UserEntity user) {

        userRepository.save(user);
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteById(Integer id) {
        userRepository.deleteById(id);
    }
}
