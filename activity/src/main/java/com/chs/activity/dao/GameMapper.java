package com.chs.activity.dao;

import com.chs.activity.modal.bean.GameQuery;
import com.chs.activity.modal.entity.GameEntity;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author : HongSheng.Chen
 * @date : 2021/2/18 14:34
 */
public interface GameMapper {


    List<GameEntity> list(GameQuery gameQuery);

    @Select("select * from game")
    List<GameEntity> findAll();

    @Select("select * from game where id = #{id}")
    GameEntity findById(Integer id);

    void insert(GameEntity entity);

    void update(GameEntity entity);

    @Delete("delete from game where id = #{id}")
    void deleteById(Integer id);

}
