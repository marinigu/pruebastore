package com.example.storeWeb.Service;

import java.util.List;


import com.example.storeWeb.entity.ProductoDto;

public interface IProductoService {
	public List<ProductoDto> GetAllProducto() throws Exception;
	public String SaveProducto(ProductoDto producto) throws Exception;
	public ProductoDto FindByIdProducto(ProductoDto producto) throws Exception;
}
