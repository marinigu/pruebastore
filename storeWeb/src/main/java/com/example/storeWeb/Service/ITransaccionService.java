package com.example.storeWeb.Service;

import java.util.List;

import com.example.storeWeb.entity.TransaccionDto;

public interface ITransaccionService {

	public List<TransaccionDto> GetAllTransaccion() throws Exception;
}
