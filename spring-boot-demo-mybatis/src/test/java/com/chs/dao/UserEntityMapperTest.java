package com.chs.dao;

import com.chs.Application;
import com.chs.entity.UserEntity;
import com.github.pagehelper.PageHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

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

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})// 指定启动类
public class UserEntityMapperTest {


    @Resource
    private UserEntityMapper userEntityMapper;


    @Test
    public void selectByPrimaryKeyTest() {
        UserEntity userEntity = userEntityMapper.selectByPrimaryKey("11");
        System.out.println(userEntity.getName());
    }

    //@Transactional //回滚，防止脏数据
    @Test
    public void insertTest() {
        UserEntity userEntity = userEntityMapper.selectByPrimaryKey("11");
        userEntity.setId(UUID.randomUUID().toString());
        userEntity.setName("cc");
        userEntityMapper.insert(userEntity);

    }


    @Transactional //回滚，防止脏数据
    @Test
    public void deleteByPrimaryKeyTest() {

        userEntityMapper.deleteByPrimaryKey("2cbd3362-baa3-40ae-a293-ed9e9058b8a2");

    }

    @Transactional //回滚，防止脏数据
    @Test
    public void updateByPrimaryKeyTest() {

        UserEntity userEntity = userEntityMapper.selectByPrimaryKey("11");
        userEntity.setName("哥哥");
        userEntityMapper.updateByPrimaryKey(userEntity);


    }


    @Test
    public void selectAllTest() {

        PageHelper.offsetPage(0, 2); //下一条sql分页
        List<UserEntity> list = userEntityMapper.selectAll();

        for (UserEntity userEntity : list) {
            System.out.println(userEntity.toString());
        }

    }


}
