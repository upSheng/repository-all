package com.chs.activity.controller;

import com.chs.activity.base.response.EasyPage;
import com.chs.activity.base.response.ResponseEntity;
import com.chs.activity.modal.bean.GameQuery;
import com.chs.activity.modal.entity.GameEntity;
import com.chs.activity.modal.vo.GameVO;
import com.chs.activity.service.GameService;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * @author : HongSheng.Chen
 * @date : 2021/3/14 16:41
 */
@RestController
public class GameController {

    @Resource
    GameService gameService;

    @PostMapping("/searchGame")
    public ResponseEntity<EasyPage<GameVO>> searchGame(@RequestBody GameQuery gameQuery) {
        return ResponseEntity.withRes(res -> res.setData(gameService.search(gameQuery)));
    }


    @PostMapping("/listGame")
    public ResponseEntity<EasyPage<GameEntity>> listGame(@RequestBody GameQuery gameQuery) {
        return ResponseEntity.withRes(res -> res.setData(gameService.list(gameQuery)));
    }

    @PostMapping("/saveGame")
    public ResponseEntity<GameEntity> saveGame(@RequestBody GameEntity gameEntity) {
        return ResponseEntity.withRes(res -> res.setData(gameService.save(gameEntity)));
    }

    @GetMapping("/deleteGame")
    public ResponseEntity<Void> deleteGame(@RequestParam("id") Integer id) {
        return ResponseEntity.withRes(res -> gameService.delete(id));
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadExe(@Param("file") MultipartFile file){

        return ResponseEntity.withRes(res->res.setData(gameService.upload(file)));
    }

}
