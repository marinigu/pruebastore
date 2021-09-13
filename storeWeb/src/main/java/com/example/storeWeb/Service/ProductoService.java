package com.example.storeWeb.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.storeWeb.entity.Producto;
import com.example.storeWeb.entity.ProductoDto;
import com.example.storeWeb.repository.ProductoRepository;

@Service
public class ProductoService implements IProductoService {

	@Autowired
	ProductoRepository repositorio;
	
	@Override
	public List<ProductoDto> GetAllProducto() throws Exception {
		List<ProductoDto> listDto = new ArrayList<>();
		try {
		 Iterable<Producto> listEntity =	this.repositorio.findAll();
			 for(Producto entity : listEntity)
			 {
				 ProductoDto dto = new ProductoDto();			 
				 dto.setId(entity.getId());
				 dto.setDescripcion(entity.getDescripcion());
				 dto.setNombre(entity.getNombre());
				 dto.setPrecio(entity.getPrecio());
								 
				 listDto.add(dto);
			 }
		} catch (Exception handlerException) {
			throw new Exception ("Falla al obtener los Productos");
		}

		return listDto;
	}

	@Override
	public String SaveProducto(ProductoDto productoDto) throws Exception {
		Producto productoEntity = new Producto(); 
		productoEntity.setPrecio(productoDto.getPrecio());
		productoEntity.setDescripcion(productoDto.getDescripcion());
		productoEntity.setNombre(productoDto.getNombre());
		
		if(productoDto.getId() != null)
		{
			productoEntity.setId(productoDto.getId());
		}
		
		this.repositorio.save(productoEntity);
		return "";
	}

	@Override
	public ProductoDto FindByIdProducto(ProductoDto producto) throws Exception {
		Producto productoEntity = new Producto(); 
		productoEntity.setId(producto.getId());
		Producto entity = this.repositorio.findById(productoEntity.getId()).get();
		
		ProductoDto dto = new ProductoDto();			 
		dto.setId(entity.getId());
		dto.setDescripcion(entity.getDescripcion());
		dto.setNombre(entity.getNombre());
		dto.setPrecio(entity.getPrecio());
		
		return dto;
	}

}
