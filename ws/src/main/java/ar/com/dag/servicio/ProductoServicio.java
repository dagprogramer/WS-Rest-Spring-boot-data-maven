package ar.com.dag.servicio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import ar.com.dag.modelo.Producto;
import ar.com.dag.recurso.request.ProductoRequest;
import ar.com.dag.recurso.response.ProductoResponse;
import ar.com.dag.repositorio.ProductoRepositorio;

public class ProductoServicio {
    private ProductoRepositorio productoRepositorio;
    
	public ProductoServicio(ProductoRepositorio productoRepositorio) {
		super();
		this.productoRepositorio = productoRepositorio;
	}

	public ProductoResponse getById(Long id){
		Producto prod=productoRepositorio.findOne(id);
		ProductoResponse prod_resp=toProductoResponse(prod);
		return prod_resp;
	}
	
	private ProductoResponse toProductoResponse(Producto prod) {
		ProductoResponse prod_resp=new ProductoResponse(prod.getId(), prod.getNombre(), prod.getPrecio(), prod.getCantidad());
		return prod_resp;
	}

	public boolean exists(Long id){
		return productoRepositorio.exists(id);
	}
	
	@Transactional
	public ProductoResponse saveOrUpdate(ProductoRequest prod_req){
		Producto prod=new Producto(prod_req.getId(), prod_req.getNombre(), prod_req.getPrecio(), prod_req.getCantidad());
		Producto prod_save=productoRepositorio.save(prod);
		return toProductoResponse(prod_save);
	}
	
	public List<ProductoResponse>getAll(){
		List<ProductoResponse>lista=new ArrayList<>();
		productoRepositorio.findAll().forEach(prod->{
			ProductoResponse pro_resp=toProductoResponse(prod);
			lista.add(pro_resp);
		});
		return lista;
	}
	
	public void delete(Long id){
		productoRepositorio.delete(id);
	}

	public ProductoRepositorio getProductoRepositorio() {
		return productoRepositorio;
	}

	public void setProductoRepositorio(ProductoRepositorio productoRepositorio) {
		this.productoRepositorio = productoRepositorio;
	}
	
	
	
}
