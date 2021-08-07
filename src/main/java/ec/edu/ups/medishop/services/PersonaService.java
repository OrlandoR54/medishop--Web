package ec.edu.ups.medishop.services;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ec.edu.ups.medishop.business.GestionPersonas;
import ec.edu.ups.medishop.modelo.Persona;

@Path("/personas")
public class PersonaService {

	@Inject
	private GestionPersonas on;
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Mensaje createPersona(Persona persona) {
		Mensaje m = new Mensaje();
		try {
			on.createPersona(persona);
			m.setCodigo(1);
			m.setMensaje("OK");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			m.setCodigo(0);
			m.setMensaje("Error");
		}
		return m;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Persona> getPersonas(){
		
		try {
			List<Persona> listado = on.getPersonas();
			return listado;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
}
