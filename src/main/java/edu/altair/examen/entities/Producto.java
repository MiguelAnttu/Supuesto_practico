package edu.altair.examen.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "Productos", schema = "examen_bd", uniqueConstraints = {
		@UniqueConstraint(name = "Productos_codigo_sku", columnNames = "codigo_sku"), })

public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_producto")
	private Long id;

	@Column(name = "codigo_sku", nullable = false, length = 10)
	private String codigoSKU;

	@Column(name = "nombre", nullable = false, length = 100)
	private String nombre;

	@Column(name = "descripcion", nullable = true, length = 255)
	private String descripcion;

	@Column(name = "precio", nullable = false)
	private float precio;

	@Column(name = "stock", nullable = false)
	private int stock;

	@Column(name = "fecha_alta", nullable = false)
	private LocalDate fechaAlta;

	public Producto() {
		super();
	}

	public Producto(Long id, String codigoSKU, String nombre, String descripcion, float precio, int stock,
			LocalDate fechaAlta) {
		super();
		this.id = id;
		this.codigoSKU = codigoSKU;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.stock = stock;
		this.fechaAlta = fechaAlta;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigoSKU() {
		return codigoSKU;
	}

	public void setCodigoSKU(String codigoSKU) {
		this.codigoSKU = codigoSKU;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public LocalDate getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(LocalDate fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

}
