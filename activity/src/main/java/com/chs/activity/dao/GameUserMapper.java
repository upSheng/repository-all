package com.chs.activity.dao;

import com.chs.activity.modal.bean.GameQuery;
import com.chs.activity.modal.entity.GameEntity;
import com.chs.activity.modal.entity.GameUserEntity;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author : HongSheng.Chen
 * @date : 2021/2/18 14:34
 */
public interface GameUserMapper {


    @Select("select * from game_user where phone = #{phone}")
    List<GameUserEntity> findByPhone(@Param("phone") String phone);

    @Select("select * from game_user where order_id = #{orderId}")
    GameUserEntity findByOrderId(String orderId);

    void insert(GameUserEntity entity);


}
