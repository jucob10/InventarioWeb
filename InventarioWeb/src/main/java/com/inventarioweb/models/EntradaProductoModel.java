package com.inventarioweb.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "entrada_producto")
public class EntradaProductoModel {
		
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
    private Long id;
	@Column(name="nombre_producto")
	private String nombreProductoE;
	@Column(name="codigo")
	private String codigoE;
	@Column(name="categoria")
	private String categoriaE;
	@Column(name="nombre_proveedor")
	private String nombreProveedor;
	@Column(name="valor_producto")
    private double valorProducto;
	@Column(name="unidades_entrada")
    private int unidadesEntrada;
	@Column(name="tipo_movimiento")
    private String tipoMovimiento;
	
	//Getters y Setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombreProductoE() {
		return nombreProductoE;
	}
	public void setNombreProductoE(String nombreProductoE) {
		this.nombreProductoE = nombreProductoE;
	}
	public String getCodigoE() {
		return codigoE;
	}
	public void setCodigoE(String codigoE) {
		this.codigoE = codigoE;
	}
	public String getCategoriaE() {
		return categoriaE;
	}
	public void setCategoriaE(String categoriaE) {
		this.categoriaE = categoriaE;
	}
	public String getNombreProveedor() {
		return nombreProveedor;
	}
	public void setNombreProveedor(String nombreProveedor) {
		this.nombreProveedor = nombreProveedor;
	}
	public double getValorProducto() {
		return valorProducto;
	}
	public void setValorProducto(double valorProducto) {
		this.valorProducto = valorProducto;
	}
	public int getUnidadesEntrada() {
		return unidadesEntrada;
	}
	public void setUnidadesEntrada(int unidadesEntrada) {
		this.unidadesEntrada = unidadesEntrada;
	}
	public String getTipoMovimiento() {
		return tipoMovimiento;
	}
	public void setTipoMovimiento(String tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}
}
