package br.com.sigma.service;

import br.com.sigma.dto.StateDTO;
import br.com.sigma.model.Neighbourhood;
import br.com.sigma.model.State;
import br.com.sigma.utils.GenericService;
import org.springframework.http.ResponseEntity;

public interface StateService extends GenericService<State, Integer> {
    ResponseEntity create(StateDTO state);
    ResponseEntity read(Integer id);
    ResponseEntity update(Integer id, StateDTO state);
    ResponseEntity delete(Integer id);
}
