package com.chs.action;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author : HongSheng.Chen
 * @date : 2020/12/6 13:43
 */
@Mapper
public interface UserMapper {

    UserMapper INSTANSE = Mappers.getMapper(UserMapper.class);
    UserOne user(User user);
}
