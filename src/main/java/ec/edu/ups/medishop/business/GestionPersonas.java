/**
 * 
 */
package ec.edu.ups.medishop.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.medishop.dao.PersonaDAO;
import ec.edu.ups.medishop.modelo.Persona;

/**
 * @author orlan
 *
 */
@Stateless
public class GestionPersonas {
	
	@Inject
	private PersonaDAO daoPersona;

	public void createPersona(Persona persona) throws Exception {
		// reglas o validaciones previas a guardar
		if (daoPersona.read(persona.getCodigo()) != null) {
			daoPersona.update(persona);
		}else
			daoPersona.create(persona);
		
	}
	
	public List<Persona> getPersonas() throws Exception{
		return daoPersona.getList();
	}
}
