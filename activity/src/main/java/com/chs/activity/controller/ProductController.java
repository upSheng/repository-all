package com.chs.activity.controller;

import com.chs.activity.base.response.ResponseEntity;
import com.chs.activity.modal.entity.ProductEntity;
import com.chs.activity.repository.IProductRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author : HongSheng.Chen
 * @date : 2021/3/14 16:41
 */
@RestController
public class ProductController {

    @Resource
    IProductRepository productRepository;


    @GetMapping("/listProduct")
    public ResponseEntity<List<ProductEntity>> listProduct() {
        return ResponseEntity.withRes(res -> res.setData(productRepository.findAll()));
    }

    @PostMapping("/saveProduct")
    public ResponseEntity<ProductEntity> saveProduct(@RequestBody ProductEntity productEntity) {
        return ResponseEntity.withRes(res -> res.setData(productRepository.save(productEntity)));
    }

}
