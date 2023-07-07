package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.model.vehiculo;
import com.example.demo.repository.VehiculoRepository;

@Service
public class VehiculoServicesImpl implements VehiculoServices {

	@Autowired
	private VehiculoRepository repositorio;

	@Override
	public List<vehiculo> listarTodosLosVehiculos() {
		return repositorio.findAll();
	}

	@Override
	public vehiculo guardarVehiculo(vehiculo vehiculo) {
		return repositorio.save(vehiculo);
	}

	@Override
	public vehiculo obtenerVehiculoPorId(Integer id) {
		return repositorio.findById(id).get();
	}

	@Override
	public vehiculo actualizarVehiculo(vehiculo vehiculo) {
		return repositorio.save(vehiculo);
	}

	@Override
	public void eliminarVehiculo(Integer id) {
		repositorio.deleteById(id);

	}

	@Override
	public Page<vehiculo> Paginados(Pageable pageable) {
		return repositorio.findAll(pageable);
	}

	@Override
	public vehiculo buscarVehiculoPorPlaca(String Placa) {
		// TODO Auto-generated method stub
		return null;
	}

}
