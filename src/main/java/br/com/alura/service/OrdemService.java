package br.com.alura.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.SecurityContext;

import br.com.alura.model.Country;
import br.com.alura.model.Ordem;
import br.com.alura.model.Usuario;
import br.com.alura.repository.OrdemRepository;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@ApplicationScoped
public class OrdemService {

	@Inject
	OrdemRepository ordemRepository;

	@Inject
	@RestClient
	CountryService countryService;

	public void inserir(SecurityContext securityContext, Ordem ordem) {
		Optional<Usuario> usuarioOptional = Usuario.findByIdOptional(ordem.getUserId());
		Usuario usuario = usuarioOptional.orElseThrow();
		if (!usuario.getUsername().equals(securityContext.getUserPrincipal().getName())) {
			throw new RuntimeException("O usuário logado é diferente do userId");
		}
		ordem.setData(LocalDate.now());
		ordem.setStatus("ENVIADA");
		ordemRepository.persist(ordem);
	}

	public List<Country> getAllCountries() {
		return this.countryService.listar();
	}
}
