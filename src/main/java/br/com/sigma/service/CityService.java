package br.com.sigma.service;

import br.com.sigma.dto.CityDTO;
import br.com.sigma.model.City;
import br.com.sigma.utils.GenericService;
import org.springframework.http.ResponseEntity;

public interface CityService extends GenericService<City, Integer> {
    ResponseEntity create(CityDTO city);
    ResponseEntity read(Integer id);
    ResponseEntity update(Integer id, CityDTO city);
    ResponseEntity delete(Integer id);
}