package br.com.sigma.service;

import br.com.sigma.dto.NeighbourhoodDTO;
import br.com.sigma.model.Neighbourhood;
import br.com.sigma.utils.GenericService;
import org.springframework.http.ResponseEntity;

public interface NeighbourhoodService extends GenericService<Neighbourhood, Integer> {
    ResponseEntity create(NeighbourhoodDTO neighbourhood);
    ResponseEntity read(Integer id);
    ResponseEntity update(Integer id, NeighbourhoodDTO neighbourhood);
    ResponseEntity delete(Integer id);
}
