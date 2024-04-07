package com.sergio.crud.backend.yuwei.repositories;

import com.sergio.crud.backend.yuwei.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentsRepository extends JpaRepository<StudentEntity,Integer> { //(使用的資料結構,主鍵資料型態)
}