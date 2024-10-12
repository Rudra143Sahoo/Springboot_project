package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.Tourist;

public interface ITouristRepository extends  JpaRepository<Tourist, Integer> {
    
}
