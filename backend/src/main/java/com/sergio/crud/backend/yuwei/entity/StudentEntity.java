package com.sergio.crud.backend.yuwei.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;




@Entity
@Getter
@Setter
@Table(name="FARADAY")
public class StudentEntity {
    @Id
    @Column(name = "EMPLOYEEID")
            @JsonProperty("Employeeid")
//    @GeneratedValue(strategy = GenerationType.IDENTITY) //Id的值是由資料庫自動生成並使用IDENTITY方式生成
    Integer employeeid; //變數名字一定要小寫


    @NotBlank
    @Column(name = "FIRSTNAME")
    String firstname;

    @Column(name = "LASTNAME")
    String lastname;

}
