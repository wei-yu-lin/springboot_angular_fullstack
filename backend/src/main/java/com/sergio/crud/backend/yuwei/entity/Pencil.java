package com.sergio.crud.backend.yuwei.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Pencil {

    private Integer id;

    private String createdAt;

    private String name;

    @JsonProperty("avatar")
    private String avatarYoyo;
//
//
//    @PostConstruct
//    public void pencil(){
//        this.avatarYoyo = "這是圖片"+this.avatarYoyo;
//    }


}
