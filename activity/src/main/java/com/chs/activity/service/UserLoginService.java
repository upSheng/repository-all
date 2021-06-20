package com.chs.activity.service;

import com.chs.activity.base.exception.BusinessException;
import com.chs.activity.base.exception.ExceptionEnum;
import com.chs.activity.dao.UserMapper;
import com.chs.activity.dao.VerificationCodeMapper;
import com.chs.activity.modal.entity.UserEntity;
import com.chs.activity.modal.entity.VerificationCodeEntity;
import com.chs.activity.modal.vo.LoginResVO;
import com.chs.activity.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Random;

/**
 * @author : HongSheng.Chen
 * @date : 2020/12/24 11:23
 */
@Slf4j
@Service
public class UserLoginService {

    @Resource
    UserMapper userMapper;

    @Resource
    VerificationCodeMapper verificationCodeMapper;

    public void register(String phone,String code, String password) {

        if(!checkVerifitionCode(phone,code)){
            throw BusinessException.of(ExceptionEnum.VERIFICARTION_ERR);
        }

        UserEntity userEntity = userMapper.findByPhone(phone);
        if (userEntity != null) {
            throw BusinessException.of(ExceptionEnum.REGISTER_ERR);
        }
        userEntity = UserEntity.builder().createTime(LocalDateTime.now())
                .phone(phone)
                .password(password)
                .admin(0)
                .member(0)
                .updateTime(LocalDateTime.now())
                .build();
        userMapper.insert(userEntity);
    }

    public LoginResVO loginByPassword(String phone, String password) {

        UserEntity user = userMapper.findByPhone(phone);
        if (user == null) {
            throw BusinessException.of(ExceptionEnum.LOGIN_ERR);
        }

        if (user.getPassword() == null || !user.getPassword().equals(password)){
            throw BusinessException.of(ExceptionEnum.LOGIN_ERR);
        }

        String token = JwtUtils.creatToken(user.getId().toString(), 10 * 60 * 60 * 1000L);
        return new LoginResVO(token, user.getId().toString(),user.getPhone());

    }
    public LoginResVO loginByCode(String phone, String code) {


        if(!checkVerifitionCode(phone,code)){
            throw BusinessException.of(ExceptionEnum.VERIFICARTION_ERR);
        }

        UserEntity user = userMapper.findByPhone(phone);
        if (user == null) {
            UserEntity userEntity =
            UserEntity.builder().phone(phone).member(0).admin(0)
                    .createTime(LocalDateTime.now()).updateTime(LocalDateTime.now())
                    .build();
            userMapper.insert(userEntity);

        }


        String token = JwtUtils.creatToken(user.getId().toString(), 10 * 60 * 60 * 1000L);
        return new LoginResVO(token, user.getId().toString(),user.getPhone());
    }

    public UserEntity checkToken(String token) {

        String id = JwtUtils.verifierToken(token);
        if (StringUtils.isEmpty(id)) {
            return null;
        }
        return userMapper.findById(Integer.valueOf(id));

    }

    public void sendVerificationCode(String phone) {

        verificationCodeMapper.insert(new VerificationCodeEntity(null,phone,"11",LocalDateTime.now()));

    }

    private   boolean checkVerifitionCode(String phone, String code){
        VerificationCodeEntity verificationCodeEntity = verificationCodeMapper.findByCodeAndPhone(code, phone);

        if (verificationCodeEntity == null || !verificationCodeEntity.getCode().equals(code)){
            return false;
        }

        long between = ChronoUnit.MINUTES.between(verificationCodeEntity.getCreateTime(), LocalDateTime.now());
        if (between>5){
            return false;
        }

        return true;
    }

    public String getCode(String phone) {

        Random random = new Random();
        String code = String.format("%06d",random.nextInt(999999));
        verificationCodeMapper.insert(new VerificationCodeEntity(null,phone,code,LocalDateTime.now()));
        return code;
    }
}
