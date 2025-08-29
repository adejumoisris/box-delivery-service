package com.example.javaassessment.repository;

import com.example.javaassessment.model.Box;
import com.example.javaassessment.enums.BoxState;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoxRepository extends JpaRepository<Box, Long> {
    List<Box> findByState(BoxState state);

}
