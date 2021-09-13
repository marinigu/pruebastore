package com.example.storeWeb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.storeWeb.Service.IProductoService;
import com.example.storeWeb.entity.ProductoDto;


@Controller
public class ProductoController {
	IProductoService productoService;

	public ProductoController(IProductoService productoService) {
		super();
		this.productoService = productoService;
	}
	
	@GetMapping
	public String Index(Model modelo, ProductoDto productoDto) throws Exception {
		modelo.addAttribute("productoDto",new ProductoDto());
		modelo.addAttribute("productos",this.productoService.GetAllProducto());
		return "index";
	}
	
	@PostMapping("/crearProducto")
	public String crearProducto(Model modelo, ProductoDto productoDto) throws Exception {
		this.productoService.SaveProducto(productoDto);
		modelo.addAttribute("productoDto",new ProductoDto());
		modelo.addAttribute("productos",this.productoService.GetAllProducto());
		return "index";
	}
	
	@GetMapping("/editarProducto/{id}")
	public String editarProducto(Model modelo, @PathVariable(name="id") Long id ) throws Exception {
		ProductoDto productoDtoEditar = new ProductoDto();
		productoDtoEditar.setId(id);
		productoDtoEditar = this.productoService.FindByIdProducto(productoDtoEditar);
		modelo.addAttribute("productoDto",productoDtoEditar);
		modelo.addAttribute("productos",this.productoService.GetAllProducto());
		return "index";
	}
}
