package com.chs.activity.controller;

import com.chs.activity.base.response.ResponseEntity;
import com.chs.activity.modal.entity.GameEntity;
import com.chs.activity.service.GameUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class GameUserController {

    @Resource
    GameUserService gameUserService;

    @GetMapping("/getGameByPhone")
    public ResponseEntity<List<GameEntity>> getGameByPhone(@RequestParam("phone") String phone){
        return ResponseEntity.withRes(res->res.setData(gameUserService.getGameByPhone(phone)));
    }
}
