package ec.edu.ups.medishop.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.medishop.modelo.Persona;


@Stateless
public class PersonaDAO {

	@PersistenceContext
	private EntityManager em;

	public void create(Persona persona) throws Exception{
		em.persist(persona);
	}

	public Persona read(int codigo) throws Exception{
		return em.find(Persona.class, codigo);
	}
	
	public void update(Persona persona) throws Exception{
		em.merge(persona);
	}

	public void delete(int codigo) throws Exception{
		em.remove(this.read(codigo));
	}
	
	public List<Persona> getList() throws Exception{
		String sql = "SELECT p FROM Persona p";
		
		Query q = em.createQuery(sql, Persona.class);
		
		return q.getResultList();
	}
}
