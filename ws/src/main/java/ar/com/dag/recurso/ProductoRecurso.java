package ar.com.dag.recurso;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.dag.recurso.request.ProductoRequest;
import ar.com.dag.recurso.response.MensajeResponse;
import ar.com.dag.recurso.response.ProductoResponse;
import ar.com.dag.servicio.ProductoServicio;

@RestController
@RequestMapping(value="/v1")
public class ProductoRecurso {
	
	@Autowired
    private ProductoServicio productoServicio;
	private static final Logger LOGGER=LoggerFactory.getLogger(ProductoRecurso.class);
	
	@RequestMapping(value="/producto/{id}",method=RequestMethod.GET,produces="application/json")
	public @ResponseBody ResponseEntity<?>getByid(@PathVariable Long id){
		LOGGER.info("guetting producto id{}", id);
		if(!productoServicio.exists(id)){
			LOGGER.info("producto id{} not found", id);
			return new ResponseEntity(new MensajeResponse("producto: "+id+" not foun"), HttpStatus.BAD_REQUEST);
		}
		ProductoResponse prod_resp=productoServicio.getById(id);
		LOGGER.info("producto foun", prod_resp);
		return new ResponseEntity(prod_resp, HttpStatus.OK);
	}
	
	@RequestMapping(value="/producto",method=RequestMethod.PUT,produces="application/json",consumes="application/json")
	public @ResponseBody ResponseEntity<ProductoResponse>saveProducto(@RequestBody ProductoRequest prod_req){
		LOGGER.info("incoming message", prod_req);
		if(prod_req.getId()!=null){
			LOGGER.info("producto id{} must be null", prod_req.getId());
			return new ResponseEntity(new MensajeResponse("id: "+prod_req.getId()+" must be null"), HttpStatus.BAD_REQUEST);
		}
		ProductoResponse prod_resp=productoServicio.saveOrUpdate(prod_req);
		LOGGER.info("response message", prod_resp);
		return new ResponseEntity(prod_resp, HttpStatus.OK);
	}
	
	@RequestMapping(value="/producto",method=RequestMethod.POST,produces="application/json",consumes="application/json")
	public @ResponseBody ResponseEntity<?>updateProducto(@RequestBody ProductoRequest prod_req){
		LOGGER.info("incoming message", prod_req);
		if(!productoServicio.exists(prod_req.getId())){
			LOGGER.info("producto id{} not found", prod_req.getId());
			return new ResponseEntity(new MensajeResponse("producto: "+prod_req.getId()+" not found"), HttpStatus.BAD_REQUEST);
		}
		ProductoResponse prod_resp=productoServicio.saveOrUpdate(prod_req);
		LOGGER.info("response message", prod_resp);
		return new ResponseEntity(prod_resp, HttpStatus.OK);
	}
	
	@RequestMapping(value="/producto",method=RequestMethod.GET,produces="application/json")
	public @ResponseBody ResponseEntity<?>getAll(){
		LOGGER.info("guetting all productos");
		List<ProductoResponse>lista=productoServicio.getAll();
		LOGGER.info("productos founds", lista);
		return new ResponseEntity(lista, HttpStatus.OK);
	}
	
        @RequestMapping(value = "/producto/{id}",method = RequestMethod.DELETE,produces = "application/json")
	public @ResponseBody ResponseEntity<?>deleteProducto(Long id){
            LOGGER.info("deletting producto id{}", id);
            if(id==null){
                LOGGER.info("producto id{} is manadatory", id);
                return new ResponseEntity<>(new MensajeResponse("id: "+id+" is deletting"),HttpStatus.BAD_REQUEST);
            }
		productoServicio.delete(id);
                LOGGER.info("producto id{} deletting successfully", id);
                return new ResponseEntity<>(new MensajeResponse("deleted"), HttpStatus.OK);
	}
	
	
	
	
}
