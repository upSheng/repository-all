package com.chs.activity.controller;

import com.chs.activity.base.response.ResponseEntity;
import com.chs.activity.modal.entity.OrderEntity;
import com.chs.activity.service.PlaceOrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author : HongSheng.Chen
 * @date : 2021/3/23 13:41
 */
@RestController
public class PlaceOrderController {

    @Resource
    PlaceOrderService placeOrderService;

    @PostMapping("/placeOrder")
    ResponseEntity<OrderEntity> placeOrder(@RequestParam("id") String id) {
        return ResponseEntity.withRes(res -> res.setData(placeOrderService.placeOrder(id)));
    }

    @PostMapping("/payHandle")
    ResponseEntity<Void> payHandle(@RequestParam Map<String, String> params) {
        return ResponseEntity.withRes(res -> placeOrderService.payHandle(params));
    }

    @GetMapping("/findOrder")
    ResponseEntity<OrderEntity> findOrder(@RequestParam("id") String id) {
        return ResponseEntity.withRes(res -> res.setData(placeOrderService.findOrder(id)));
    }
}
