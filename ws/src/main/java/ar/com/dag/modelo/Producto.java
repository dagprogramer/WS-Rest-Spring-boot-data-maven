package ar.com.dag.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="producto")
public class Producto {
	
   @Id
   @GeneratedValue(strategy=GenerationType.AUTO)
   @Column(name="id")
   private Long id;
   
   @Column(name="nombre")
   private String nombre;
   
   @Column(name="precio")
   private Float precio;
   
   @Column(name="cantidad")
   private Integer cantidad;
   
   
public Producto() {
	// TODO Auto-generated constructor stub
}


public Producto(Long id, String nombre, Float precio, Integer cantidad) {
	this.id = id;
	this.nombre = nombre;
	this.precio = precio;
	this.cantidad = cantidad;
}


public Long getId() {
	return id;
}


public void setId(Long id) {
	this.id = id;
}


public String getNombre() {
	return nombre;
}


public void setNombre(String nombre) {
	this.nombre = nombre;
}


public Float getPrecio() {
	return precio;
}


public void setPrecio(Float precio) {
	this.precio = precio;
}


public Integer getCantidad() {
	return cantidad;
}


public void setCantidad(Integer cantidad) {
	this.cantidad = cantidad;
}


@Override
public String toString() {
	return "Producto [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", cantidad=" + cantidad + "]";
}
   
   
   
}
