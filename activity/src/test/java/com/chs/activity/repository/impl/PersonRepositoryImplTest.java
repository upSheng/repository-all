package com.chs.activity.repository.impl;

import com.chs.activity.Application;
import com.chs.activity.base.response.EasyPage;
import com.chs.activity.modal.entity.PersonEntity;
import com.chs.activity.repository.IPersonRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author : HongSheng.Chen
 * @date : 2021/2/18 14:48
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
class PersonRepositoryImplTest {

    @Autowired
    private IPersonRepository personRepository;

    @Test
    void page() {

        EasyPage<PersonEntity> san = personRepository.page(1, 20, "san");
        System.out.println(san);
    }


    @Test
    void save() {

        PersonEntity personEntity = personRepository.save(new PersonEntity(null, "张三", 25));
        System.out.println(personEntity);
    }

    @Test
    void deleteById() {
        personRepository.deleteById("602e0f1ead98a0768ce4fd95");
    }


}