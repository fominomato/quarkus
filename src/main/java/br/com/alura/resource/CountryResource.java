package br.com.alura.resource;

import br.com.alura.model.Bitcoin;
import br.com.alura.model.Country;
import br.com.alura.service.BitcoinService;
import br.com.alura.service.OrdemService;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/country")
public class CountryResource {

	@Inject
	OrdemService ordemService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Country> listar() {
		return ordemService.getAllCountries();
	}

}
