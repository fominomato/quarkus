package br.com.alura.service;

import br.com.alura.model.Bitcoin;
import br.com.alura.model.Country;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/rest")
@RegisterRestClient(configKey = "country-api")
public interface CountryService {

	@GET
	@Path("/v2/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Country> listar();

}
