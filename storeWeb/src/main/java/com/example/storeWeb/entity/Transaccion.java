package com.example.storeWeb.entity;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Transaccion {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long Id;
	private Long usuario;
	private Long producto;
	private double cantidad;
	private String fecha;
	
	public Transaccion() {}
	
	public Transaccion(Long id, Long usuario, Long producto, double cantidad, String fecha) {
		super();
		Id = id;
		this.usuario = usuario;
		this.producto = producto;
		this.cantidad = cantidad;
		this.fecha = fecha;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Long getUsuario() {
		return usuario;
	}

	public void setUsuario(Long usuario) {
		this.usuario = usuario;
	}

	public Long getProducto() {
		return producto;
	}

	public void setProducto(Long producto) {
		this.producto = producto;
	}

	public double getCantidad() {
		return cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transaccion other = (Transaccion) obj;
		return Objects.equals(Id, other.Id);
	}

	@Override
	public String toString() {
		return "Transaccion [Id=" + Id + ", usuario=" + usuario + ", producto=" + producto + ", cantidad=" + cantidad
				+ ", fecha=" + fecha + "]";
	}
}
