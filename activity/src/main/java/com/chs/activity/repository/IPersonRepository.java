package com.chs.activity.repository;

import com.chs.activity.base.response.EasyPage;
import com.chs.activity.modal.entity.PersonEntity;

/**
 * @author : HongSheng.Chen
 * @date : 2021/2/18 14:34
 */
public interface IPersonRepository {


    EasyPage<PersonEntity> page(Integer pageNum, Integer pageSize, String name);

    PersonEntity findById(String id);

    PersonEntity save(PersonEntity person);

    void deleteById(String id);

}
