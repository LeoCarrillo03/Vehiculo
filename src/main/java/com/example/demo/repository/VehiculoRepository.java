package com.example.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.vehiculo;


public interface VehiculoRepository extends JpaRepository<vehiculo, Integer> {
	
}
