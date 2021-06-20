//package com.chs.activity.repository.impl;
//
//import com.chs.activity.Application;
//import com.chs.activity.base.response.EasyPage;
//import com.chs.activity.modal.entity.ProductEntity;
//import com.chs.activity.repository.IProductRepository;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
///**
// * @author : HongSheng.Chen
// * @date : 2021/2/18 14:48
// */
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = {Application.class})
//class PersonRepositoryImplTest {
//
//    @Autowired
//    private IProductRepository personRepository;
//
//    @Test
//    void page() {
//
//
//    }
//
//
//    @Test
//    void save() {
//
//        ProductEntity personEntity = personRepository.save(new ProductEntity());
//        System.out.println(personEntity);
//    }
//
//    @Test
//    void deleteById() {
//        personRepository.deleteById("602e0f1ead98a0768ce4fd95");
//    }
//
//
//}