package com.web.dao;

import com.web.entity.UserEntity;
import org.apache.ibatis.annotations.Param;


/**
 * @author Administrator
 */
public interface UserMapper {


    UserEntity findByName(@Param("name") String name);
}
