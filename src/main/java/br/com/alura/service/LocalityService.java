package br.com.alura.service;

import br.com.alura.model.Country;
import br.com.alura.model.Distrito;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/api/v1")
@RegisterRestClient(configKey = "locality-api")
public interface LocalityService {

	@GET
	@Path("/localidades/estados/{UF}/distritos")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Distrito> listar(@PathParam("UF") String uf);

}
