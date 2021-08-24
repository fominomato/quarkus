package br.com.alura.resource;

import br.com.alura.model.Distrito;
import br.com.alura.service.LocalityService;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/localidades")
public class LocalityResource {

	@Inject
	@RestClient
	LocalityService localityService;

	@GET
	@Path("/{UF}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Distrito> listar(@PathParam("UF") String uf) {
		return localityService.listar(uf);
	}

}
