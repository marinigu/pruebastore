package com.example.storeWeb.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.storeWeb.entity.Producto;

public interface ProductoRepository extends CrudRepository<Producto, Long> {

}
