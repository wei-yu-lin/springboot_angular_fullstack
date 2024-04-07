package com.sergio.crud.backend.yuwei.controller;

import com.sergio.crud.backend.yuwei.entity.Pencil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/yuwei")
public class ConfigController {
    @Autowired
    Pencil pencil_1;

    //    Bean初始化的練習
    @GetMapping("/init")
    public void beanInit() {
//        pencil_1.getCount();
    }

    //    ResponseEntity練習 - 自定Function內所返回的http response內容和http status
    @GetMapping("/getResponseEntity")
    public ResponseEntity<String> getResponseEntity() {
        return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("這邊是自定義的返回內容並且與ResponseEntity型態一致才可以");
    }

    //    自訂Excption的http status和http reponse內容，交由ExceptionHandler處理RuntimeException
    @GetMapping("/RuntimeException")
    public void RuntimeException() {
        throw new RuntimeException("這邊是在controller內自訂義的RuntimeException內容");
    }

    @GetMapping("/IllegalArgumentException")
    public void IllegalArgumentException() {
        throw new IllegalArgumentException("這邊是在controller內自訂義的IllegalArgumentException內容");
    }
}
