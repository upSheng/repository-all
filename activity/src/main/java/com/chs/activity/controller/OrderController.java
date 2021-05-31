package com.chs.activity.controller;

import com.chs.activity.base.response.EasyPage;
import com.chs.activity.base.response.ResponseEntity;
import com.chs.activity.modal.bean.OrderAward;
import com.chs.activity.modal.bean.OrderQuery;
import com.chs.activity.modal.entity.OrderEntity;
import com.chs.activity.service.OrderService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
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
    ResponseEntity<OrderEntity> placeOrder(@RequestParam("id") String id, @RequestParam("userId") String userId) {
        return ResponseEntity.withRes(res -> res.setData(orderService.placeOrder(id,userId)));
    }

    @PostMapping("/payHandle")
    ResponseEntity<Void> payHandle(@RequestParam Map<String, String> params) {
        return ResponseEntity.withRes(res -> orderService.payHandle(params));
    }

    @GetMapping("/findOrderByPayJsOrderId")
    public ResponseEntity<OrderEntity> findOrderByPayJsOrderId(@RequestParam("payJsOrderId") String payJsOrderId) {
        return ResponseEntity.withRes(res -> res.setData(orderService.findOrderByPayJsOrderId(payJsOrderId)));
    }

    @PostMapping("/findAward")
    ResponseEntity<OrderAward> findAward(@RequestParam("transactionId") String transactionId) {
        return ResponseEntity.withRes(res -> res.setData(orderService.findAward(transactionId)));
    }

    @PostMapping("/findAwardList")
    ResponseEntity<List<OrderAward>> findAwardList(@RequestBody List<String> transactionIdList) {
        return ResponseEntity.withRes(res -> res.setData(orderService.findAwardList(transactionIdList)));
    }

    @PostMapping("/listOrder")
    ResponseEntity<EasyPage<OrderEntity>> listOrder(@RequestBody OrderQuery orderQuery) {
        return ResponseEntity.withRes(res -> res.setData(orderService.list(orderQuery)));
    }
}
