package com.example.repository;

import com.example.entity.DataEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DataRepository extends JpaRepository<DataEntity, Long> {
    List<DataEntity> findByEmail(String email);
}