package com.chs.activity.dao;

import com.chs.activity.modal.entity.VerificationCodeEntity;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author : HongSheng.Chen
 * @date : 2021/2/18 14:34
 */
public interface VerificationCodeMapper {

    @Select("select * from verification_code where code = #{code} and phone = #{phone} order by create_time desc limit 1")
    VerificationCodeEntity findByCodeAndPhone(@Param("code") String code, @Param("phone") String phone);

    void insert(VerificationCodeEntity entity);

}
