package com.chs.activity.controller;

import com.chs.activity.base.response.EasyPage;
import com.chs.activity.base.response.ResponseEntity;
import com.chs.activity.modal.bean.ProductQuery;
import com.chs.activity.modal.entity.ProductEntity;
import com.chs.activity.modal.vo.ProductVO;
import com.chs.activity.service.ProductService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author : HongSheng.Chen
 * @date : 2021/3/14 16:41
 */
@RestController
public class ProductController {

    @Resource
    ProductService productService;

    @PostMapping("/searchProduct")
    public ResponseEntity<EasyPage<ProductVO>> searchProduct(@RequestBody ProductQuery productQuery) {
        return ResponseEntity.withRes(res -> res.setData(productService.search(productQuery)));
    }

    @PostMapping("/searchProductFree")
    public ResponseEntity<ProductEntity> searchProductFree(@RequestParam("id") String id) {
        return ResponseEntity.withRes(res -> res.setData(productService.searchFree(id)));
    }

    @PostMapping("/listProduct")
    public ResponseEntity<EasyPage<ProductEntity>> listProduct(@RequestBody ProductQuery productQuery) {
        return ResponseEntity.withRes(res -> res.setData(productService.list(productQuery)));
    }

    @PostMapping("/saveProduct")
    public ResponseEntity<ProductEntity> saveProduct(@RequestBody ProductEntity productEntity) {
        return ResponseEntity.withRes(res -> res.setData(productService.save(productEntity)));
    }

    @GetMapping("/deleteProduct")
    public ResponseEntity<Void> deleteProduct(@RequestParam("id") String id) {
        return ResponseEntity.withRes(res -> productService.delete(id));
    }

}
