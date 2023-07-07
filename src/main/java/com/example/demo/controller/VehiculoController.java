package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.vehiculo;
import com.example.demo.services.VehiculoServices;


@Controller
public class VehiculoController {
	
	@Autowired
	private VehiculoServices servicio;
	
	@GetMapping("vehiculo/listar")
	public String listarVehiculos(Model model,@RequestParam(required = false, defaultValue = "0") Integer page) {
		
		Page<vehiculo> pg= servicio.Paginados(PageRequest.of(page, 5));
		
		model.addAttribute("vehiculo", pg);
		model.addAttribute("paginacion", "/vehiculo/listar");
		
		return "vehiculo/index";
		
	}
	

	@GetMapping("/vehiculos/nuevo")
	public String mostrarFormularioDeRegistrarVehiculo(Model model) {
		
		vehiculo vehiculo = new vehiculo();
		
		model.addAttribute("vehiculo", vehiculo);
		return "vehiculo/registrar";
	}
	
	
	@PostMapping("/vehiculo")
	public String guardarVehiculo(vehiculo vehiculo) {

		System.out.println(vehiculo);

		servicio.guardarVehiculo(vehiculo);

		return "redirect:/vehiculo/listar";
	}
	
	

	@GetMapping("/vehiculos/editar/{id}")
	public String mostrarFormularioDeEditar(@PathVariable Integer id, Model model) {

		model.addAttribute("vehiculo", servicio.obtenerVehiculoPorId(id));

		return "vehiculo/editar";

	}
	
	@PostMapping("/vehiculos/{id}")
	public String actualizarVehiculo(@PathVariable Integer id, @ModelAttribute("vehiculo") vehiculo vehiculo) {

		servicio.actualizarVehiculo(vehiculo);

		return "redirect:/vehiculo/listar";

	}
	
	
	@GetMapping("/vehiculos/{id}")
	public String eliminarVehiculo(@PathVariable Integer id) {
		servicio.eliminarVehiculo(id);
		return "redirect:/vehiculo/listar";
	}

	
}
