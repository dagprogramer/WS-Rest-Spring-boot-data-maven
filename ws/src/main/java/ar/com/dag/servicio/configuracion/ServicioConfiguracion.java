package ar.com.dag.servicio.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ar.com.dag.repositorio.ProductoRepositorio;
import ar.com.dag.servicio.ProductoServicio;

@Configuration
public class ServicioConfiguracion {

	@Bean
	public ProductoServicio productoServicio(ProductoRepositorio productoRepositorio){
		return new ProductoServicio(productoRepositorio);
	}
	
	
}
