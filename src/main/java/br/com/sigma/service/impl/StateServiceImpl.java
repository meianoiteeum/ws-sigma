package br.com.sigma.service.impl;

import br.com.sigma.dto.StateDTO;
import br.com.sigma.exceptions.Response;
import br.com.sigma.mapper.StateMapper;
import br.com.sigma.model.State;
import br.com.sigma.repository.StateRepository;
import br.com.sigma.service.CountryService;
import br.com.sigma.service.StateService;
import br.com.sigma.utils.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StateServiceImpl extends GenericServiceImpl<State,Integer> implements StateService {
    private StateMapper mapper;

    private StateRepository repository;

    private CountryService countryService;

    @Autowired
    public StateServiceImpl(StateRepository repository,
                            CountryService countryService) {
        this.repository = repository;
        this.mapper = new StateMapper();
        this.countryService = countryService;
    }

    @Override
    public ResponseEntity create(StateDTO dto) {
        ResponseEntity responseEntity = countryService.read(dto.getCountryId());
        if(responseEntity.getStatusCode() == HttpStatus.NOT_FOUND)
            return responseEntity;

        super.saveOrUpdate(mapper.convertToEntity(dto));
        return Response.ok();
    }

    @Override
    public ResponseEntity read(Integer id) {
        Optional<State> op = super.get(id);
        if(op.isPresent())
            return ResponseEntity.ok(mapper.convertToDto(op.get()));
        return Response.notFound("STATE_NOT_FOUND");
    }

    @Override
    public ResponseEntity update(Integer id, StateDTO dto) {
        Optional<State> op = super.get(id);
        if(!op.isPresent())
            return Response.notFound("STATE_NOT_FOUND");

        ResponseEntity responseEntity = countryService.read(dto.getCountryId());
        if(responseEntity.getStatusCode() == HttpStatus.NOT_FOUND)
            return responseEntity;

        State state = mapper.convertToEntity(dto);
        state.setId(id);
        super.saveOrUpdate(state);
        return Response.ok();
    }

    @Override
    public ResponseEntity delete(Integer id) {
        Optional<State> op = super.get(id);
        if(op.isPresent()) {
            super.removeById(id);
            return Response.ok();
        }
        return Response.notFound("STATE_NOT_FOUND");
    }
}
