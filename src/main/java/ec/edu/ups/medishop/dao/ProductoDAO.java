package ec.edu.ups.medishop.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.medishop.modelo.Producto;

@Stateless
public class ProductoDAO {

	@PersistenceContext
	private EntityManager em;

	public void create(Producto producto) throws Exception{
		em.persist(producto);
	}

	public Producto read(int codigo) throws Exception{
		return em.find(Producto.class, codigo);
	}
	
	public void update(Producto producto) throws Exception{
		em.merge(producto);
	}

	public void delete(int codigo) throws Exception{
		em.remove(this.read(codigo));
	}
	
	public List<Producto> getList() throws Exception{
		String sql = "SELECT p FROM Producto p";
		
		Query q = em.createQuery(sql, Producto.class);
		
		return q.getResultList();
	}
}
