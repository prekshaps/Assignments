package com.tms.rpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tms.rpa.models.ParameterData;

@Repository
public interface ParameterRepo extends JpaRepository<ParameterData, Integer>{

}