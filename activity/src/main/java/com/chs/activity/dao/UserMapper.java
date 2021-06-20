package com.chs.activity.dao;

import com.chs.activity.modal.entity.UserEntity;
import org.apache.ibatis.annotations.Select;

/**
 * @author : HongSheng.Chen
 * @date : 2021/3/31 13:59
 */
public interface UserMapper {

    @Select("select * from user where name = #{name}")
    UserEntity findByName(String name);

    @Select("select * from user where phone = #{phone}")
    UserEntity findByPhone(String phone);

    @Select("select * from user where id = #{id}")
    UserEntity findById(Integer id);

    void insert(UserEntity entity);
}
