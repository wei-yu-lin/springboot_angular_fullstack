package com.sergio.crud.backend.yuwei.controller;



import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sergio.crud.backend.yuwei.entity.Pencil;
import com.sergio.crud.backend.yuwei.entity.StudentEntity;
import com.sergio.crud.backend.yuwei.repositories.StudentsRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RequiredArgsConstructor
@RestController
@RequestMapping("/yuwei")
public class CrudController {
    private final StudentsRepository studentRepository; //@RequiredArgsConstructor
    @Autowired
    Pencil pencil;

    RestTemplate restTemplate = new RestTemplate();


    @GetMapping("/get")
    public void get() {
        StudentEntity se = studentRepository.findById(312).orElse(null);
        System.out.println(se.getFirstname());
    }

    @PostMapping("/post")
    public String insert(@RequestBody String postBody) throws JsonProcessingException {
        ObjectMapper obj =  new ObjectMapper();
        StudentEntity st = obj.readValue(postBody,StudentEntity.class);
        studentRepository.save(st);
        return "收到囉";
    }

//    @PostMapping("/post")
//    public void inserts(@RequestBody StudentEntity postBody){
//        studentRepository.save(postBody);
//    }

    // 驗證於Entity內的request驗證註解
    @RequestMapping(value = "/requestPost", method = RequestMethod.POST)
    public void requestPost(@RequestParam @Valid StudentEntity postBody) {
        String firstname = postBody.getFirstname();
    }

   // 使用@PathVariable取得url的參數
    @PutMapping("/{employeeId}")
    public void update(
            @PathVariable Integer employeeId,
            @RequestBody StudentEntity updateBody) {
        updateBody.setEmployeeid(employeeId);
        studentRepository.save(updateBody);
    }

    //練習接Json request
    @GetMapping("/getJson")
    public ResponseEntity<String> getJson() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String json = "{"
                + "\"count\":2,"
                + "\"penCartridge\":\"Hello World\""
                + "}";
        pencil = objectMapper.readValue(json, Pencil.class);
        System.out.println(pencil);
        return ResponseEntity.ok().body(json);
    }

    @GetMapping("/test/{ids}")
    public void test(@PathVariable Integer ids) {
        String url = "https://660e5c9e6ddfa2943b3686ae.mockapi.io/processStep/{id}";
        Map<String ,Integer> parameter= new HashMap<>();
        parameter.put("id",ids);

        Pencil pencil2 = restTemplate.getForObject(url, Pencil.class,  parameter);
        ResponseEntity<Pencil> pencil3 = restTemplate.getForEntity(url, Pencil.class,  parameter);

        System.out.println(pencil2.getId());
        System.out.println(pencil3.getBody().getCreatedAt());
    }


}
