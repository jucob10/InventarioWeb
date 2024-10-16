package com.inventarioweb.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Stock")
public class StockModel {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
    private Long id;
	@Column(name="producto_stock")
	private String productoStock;
	@Column(name="saldo_unidades")
    private int saldoUnidades;
	
	//Getters y Setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getProductoStock() {
		return productoStock;
	}
	public void setProductoStock(String productoStock) {
		this.productoStock = productoStock;
	}
	public int getSaldoUnidades() {
		return saldoUnidades;
	}
	public void setSaldoUnidades(int saldoUnidades) {
		this.saldoUnidades = saldoUnidades;
	}
}
