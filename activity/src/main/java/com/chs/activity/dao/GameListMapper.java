package com.chs.activity.dao;

import com.chs.activity.modal.entity.GameListEntity;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author : HongSheng.Chen
 * @date : 2021/2/18 14:34
 */
public interface GameListMapper {

    @Select("select * from game_list")
    List<GameListEntity> findAll();

    @Select("select * from game_list where id = #{id}")
    GameListEntity findById(Integer id);

    void insert(GameListEntity entity);

    void update(GameListEntity entity);

    @Delete("delete from game_list where id = #{id}")
    void deleteById(Integer id);

}
