package com.chs.activity.controller;

import com.chs.activity.base.response.EasyPage;
import com.chs.activity.base.response.ResponseEntity;
import com.chs.activity.modal.bean.OrderParam;
import com.chs.activity.modal.bean.OrderQuery;
import com.chs.activity.modal.entity.OrderEntity;
import com.chs.activity.service.OrderService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author : HongSheng.Chen
 * @date : 2021/3/23 13:41
 */
@RestController
public class OrderController {

    @Resource
    OrderService orderService;

    @PostMapping("/placeOrder")
    ResponseEntity<OrderEntity> placeOrder(@RequestBody OrderParam orderParam) {
        return ResponseEntity.withRes(res -> res.setData(orderService.placeOrder(orderParam.getGameId(), orderParam.getPhone())));
    }

    @PostMapping("/payHandle")
    ResponseEntity<Void> payHandle(@RequestParam Map<String, String> params) {
        return ResponseEntity.withRes(res -> orderService.payHandle(params));
    }

    @GetMapping("/findByOrderId")
    ResponseEntity<OrderEntity> findByOrderId(@RequestParam("orderId") String orderId) {
        return ResponseEntity.withRes(res -> res.setData(orderService.findByOrderId(orderId)));
    }

    @PostMapping("/listOrder")
    public ResponseEntity<EasyPage<OrderEntity>> listGame(@RequestBody OrderQuery orderQuery) {
        return ResponseEntity.withRes(res -> res.setData(orderService.list(orderQuery)));
    }

}
