package com.tms.rpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tms.rpa.models.AccuracyData;

@Repository
public interface AccuracyRepo extends JpaRepository<AccuracyData, Integer> {

}