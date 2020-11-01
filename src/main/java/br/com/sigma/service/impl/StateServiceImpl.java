package br.com.sigma.service.impl;

import br.com.sigma.dto.StateDTO;
import br.com.sigma.exceptions.Response;
import br.com.sigma.mapper.StateMapper;
import br.com.sigma.model.State;
import br.com.sigma.repository.StateRepository;
import br.com.sigma.service.StateService;
import br.com.sigma.utils.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StateServiceImpl extends GenericServiceImpl<State,Integer> implements StateService {
    private StateMapper mapper;

    private StateRepository reposiory;

    @Autowired
    public StateServiceImpl(StateRepository reposiory) {
        this.reposiory = reposiory;
    }

    @Override
    public ResponseEntity create(StateDTO dto) {
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
        if(op.isPresent()) {
            State state = mapper.convertToEntity(dto);
            state.setId(id);
            super.saveOrUpdate(state);
            return Response.ok();
        }
        return Response.notFound("STATE_NOT_FOUND");
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
