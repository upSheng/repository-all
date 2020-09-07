package com.web.dao;

import com.web.entity.UserEntity;
import com.web.entity.query.UserEntityQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * @author Administrator
 */
public interface UserMapper {


    List<UserEntity> findByQuery(UserEntityQuery userEntityQuery);

    void insert(UserEntity userEntity);

    void update(UserEntity userEntity);

    void delete(@Param("id") Integer id);
}
