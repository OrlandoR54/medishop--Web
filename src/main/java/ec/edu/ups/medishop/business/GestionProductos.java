package ec.edu.ups.medishop.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.medishop.dao.ProductoDAO;
import ec.edu.ups.medishop.modelo.Producto;

@Stateless
public class GestionProductos {
	
	@Inject
	private ProductoDAO daoProducto;
	
	public void createProducto(Producto producto) throws Exception {
		// reglas o validaciones previas a guardar
		
		daoProducto.create(producto);
	}
	
	public List<Producto> getProductos() throws Exception{
		return daoProducto.getList();
	}
}
