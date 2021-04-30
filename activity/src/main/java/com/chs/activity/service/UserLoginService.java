package com.chs.activity.service;

import com.chs.activity.base.exception.BusinessException;
import com.chs.activity.base.exception.ExceptionEnum;
import com.chs.activity.modal.entity.UserEntity;
import com.chs.activity.modal.vo.LoginResVO;
import com.chs.activity.repository.IUserRepository;
import com.chs.activity.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * @author : HongSheng.Chen
 * @date : 2020/12/24 11:23
 */
@Slf4j
@Service
public class UserLoginService {

    @Resource
    IUserRepository userRepository;

    public void register(String name, String password) {

        UserEntity userEntity = userRepository.findByName(name);
        if (userEntity != null) {
            throw BusinessException.of(ExceptionEnum.REGISTER_ERR);
        }
        userEntity = UserEntity.builder().createTime(LocalDateTime.now())
                .name(name)
                .password(password)
                .role("user")
                .updateTime(LocalDateTime.now())
                .build();
        userRepository.save(userEntity);
    }

    public LoginResVO login(String name, String password) {

        UserEntity user = userRepository.findByName(name);
        if (user == null || !Objects.equals(password, user.getPassword())) {
            throw BusinessException.of(ExceptionEnum.LOGIN_ERR);
        }
        String token = JwtUtils.creatToken(user.getId(), 30 * 60 * 1000L);
        return new LoginResVO(token);
    }

    public UserEntity checkToken(String token) {

        String id = JwtUtils.verifierToken(token);
        if (StringUtils.isEmpty(id)) {
            return null;
        }
        return userRepository.findById(id);

    }
}
