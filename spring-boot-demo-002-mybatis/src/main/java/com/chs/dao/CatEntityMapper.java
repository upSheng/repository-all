package com.chs.dao;

import com.chs.entity.CatEntity;
import java.util.List;

public interface CatEntityMapper {
    int deleteByPrimaryKey(String id);

    int insert(CatEntity record);

    CatEntity selectByPrimaryKey(String id);

    List<CatEntity> selectAll();

    int updateByPrimaryKey(CatEntity record);
}