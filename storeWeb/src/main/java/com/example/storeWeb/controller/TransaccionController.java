package com.example.storeWeb.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.storeWeb.Service.ITransaccionService;
import com.example.storeWeb.entity.TransaccionDto;

@Controller
public class TransaccionController {
	ITransaccionService transaccionService;
	
	public TransaccionController(ITransaccionService _transaccionService) {
		super();
		this.transaccionService = _transaccionService;
	}
	
	/*@GetMapping
	public String Index(Model modelo, TransaccionDto transaccionDto) throws Exception
	{
		modelo.addAttribute("transaccion",new TransaccionDto());
		modelo.addAttribute("transacciones",this.transaccionService.GetAllTransaccion());
		return "index";
	}*/
	
	
	@GetMapping(value = "/transaccion", produces = "application/json")
	public List<TransaccionDto> GetAllTransaccion() throws Exception{
		return this.transaccionService.GetAllTransaccion();
	}
}
