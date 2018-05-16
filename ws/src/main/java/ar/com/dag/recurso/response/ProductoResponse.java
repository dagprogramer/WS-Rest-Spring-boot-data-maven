package ar.com.dag.recurso.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductoResponse {
	
	@JsonProperty(value="id")
	private Long id;
	
	@JsonProperty(value="nombre")
	private String nombre;
	
	@JsonProperty(value="precio")
	private Float precio;
	
	@JsonProperty(value="cantidad")
	private Integer cantidad;
	
	public ProductoResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductoResponse(Long id, String nombre, Float precio, Integer cantidad) {
		super();
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
		return "ProductoResponse [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", cantidad=" + cantidad
				+ "]";
	}
	
	
	
}
