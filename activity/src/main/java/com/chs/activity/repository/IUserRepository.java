package com.chs.activity.repository;

import com.chs.activity.modal.entity.UserEntity;

/**
 * @author : HongSheng.Chen
 * @date : 2021/3/31 13:59
 */
public interface IUserRepository {

    UserEntity findByName(String name);

    UserEntity findById(String id);

    UserEntity save(UserEntity entity);
}
