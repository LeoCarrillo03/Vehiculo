package com.example.demo.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.model.vehiculo;


public interface VehiculoServices {

public List<vehiculo> listarTodosLosVehiculos();
	
	public vehiculo guardarVehiculo(vehiculo vehiculo);
	
	public vehiculo obtenerVehiculoPorId(Integer id);
	
	public vehiculo actualizarVehiculo(vehiculo vehiculo);
	
	Page<vehiculo> Paginados(Pageable pageable);
	
	public void eliminarVehiculo(Integer id);
	
	vehiculo buscarVehiculoPorPlaca (String Placa);

	
}
