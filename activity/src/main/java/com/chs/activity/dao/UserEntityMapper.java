package com.chs.activity.dao;


import com.chs.activity.modal.entity.UserEntity;

import java.util.List;


public interface UserEntityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserEntity record);

    UserEntity selectByPrimaryKey(Integer id);

    List<UserEntity> selectAll();

    int updateByPrimaryKey(UserEntity record);
}