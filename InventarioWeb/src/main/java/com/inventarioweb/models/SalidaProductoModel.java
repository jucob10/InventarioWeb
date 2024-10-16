package com.inventarioweb.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "salida_producto")
public class SalidaProductoModel {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
    private Long id;
	@Column(name="nombre_producto")
	private String nomProductoSalida;
	@Column(name="unidades_inventario")
	private double unidadesInventario;
	@Column(name="unidades_salida")
    private double unidadesSalida;
	@Column(name="tipo_movimiento")
    private String tipoMovimiento;	

	//Getters y Setters	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNomProductoSalida() {
		return nomProductoSalida;
	}
	public void setNomProductoSalida(String nomProductoSalida) {
		this.nomProductoSalida = nomProductoSalida;
	}
	public double getUnidadesInventario() {
		return unidadesInventario;
	}
	public void setUnidadesInventario(double unidadesInventario) {
		this.unidadesInventario = unidadesInventario;
	}
	public double getUnidadesSalida() {
		return unidadesSalida;
	}
	public void setUnidadesSalida(double unidadesSalida) {
		this.unidadesSalida = unidadesSalida;
	}
	public String getTipoMovimiento() {
		return tipoMovimiento;
	}
	public void setTipoMovimiento(String tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}
	

}
