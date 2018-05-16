package ar.com.dag.repositorio;

import org.springframework.data.repository.CrudRepository;

import ar.com.dag.modelo.Producto;

public interface ProductoRepositorio extends CrudRepository<Producto, Long>{

}
