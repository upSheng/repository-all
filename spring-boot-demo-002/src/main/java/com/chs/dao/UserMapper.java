package com.chs.dao;

import com.chs.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 陈洪生<br>
 * <b>mail</b> chenhongsheng@tansun.com.cn<br>
 * <b>date</b> 2019/6/25<br>
 * @version 1.0.1
 * <pre>
 * 版本            修改人            修改日期            修改内容描述
 * --------------------------------------------------------------------
 * 1.0.1 	       陈洪生	        2019/6/25            创建
 * --------------------------------------------------------------------
 * </pre>
 */


public interface UserMapper {

    User findById(String id);

    List<Map<String,Object>> findMapById(String id);

    @Select("select * from user where id = #{id} ")
    User findByIdA(@Param("id") String id);
}
