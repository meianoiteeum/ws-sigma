package br.com.sigma.service;

import br.com.sigma.dto.CountryDTO;
import br.com.sigma.model.Country;
import br.com.sigma.utils.GenericService;
import org.springframework.http.ResponseEntity;

public interface CountryService extends GenericService<Country, Integer> {
    ResponseEntity create(CountryDTO country);
    ResponseEntity read(Integer id);
    ResponseEntity update(Integer id, CountryDTO country);
    ResponseEntity delete(Integer id);
}
