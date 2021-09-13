package com.example.storeWeb.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.storeWeb.entity.Transaccion;
import com.example.storeWeb.entity.TransaccionDto;
import com.example.storeWeb.repository.TransaccionRepository;

@Service
public class TransaccionService implements ITransaccionService {
	@Autowired
	TransaccionRepository repositorio;

	@Override
	public List<TransaccionDto> GetAllTransaccion() throws Exception{
		List<TransaccionDto> listDto = new ArrayList<>();
		try {
		 Iterable<Transaccion> listEntity =	this.repositorio.findAll();
			 for(Transaccion entity : listEntity)
			 {
				 TransaccionDto dto = new TransaccionDto();			 
				 dto.setId(entity.getId());
				 dto.setCantidad(entity.getCantidad());
				 dto.setFecha(entity.getFecha());
				 dto.setProducto(entity.getProducto());
				 dto.setUsuario(entity.getUsuario());
				 
				 listDto.add(dto);
			 }
		} catch (Exception handlerException) {
			throw new Exception ("Falla al obtener las transacciones");
		}

		return listDto;
	}
}
