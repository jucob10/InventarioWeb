package com.inventarioweb.models;

import jakarta.persistence.*;

@Entity
@Table(name="Producto")
public class ProductoModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="dat_id")
	private Long datId;
	@Column(name="codigo")	
	private String codigo;
	@Column(name="nombre_producto")	
	private String nombreProducto;
	@Column(name="categoria")	
	private String categoria;
		
	//Getters y Setters
	public Long getDatId() {
		return datId;
	}
	public void setDatId(Long datId) {
		this.datId = datId;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNombreProducto() {
		return nombreProducto;
	}
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	
	
	
}
