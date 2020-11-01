package br.com.sigma.service.impl;

import br.com.sigma.dto.NeighbourhoodDTO;
import br.com.sigma.exceptions.Response;
import br.com.sigma.mapper.NeighbourhoodMapper;
import br.com.sigma.model.Neighbourhood;
import br.com.sigma.repository.NeighbourhoodRepository;
import br.com.sigma.service.NeighbourhoodService;
import br.com.sigma.utils.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NeighbourhoodServiceImpl extends GenericServiceImpl<Neighbourhood,Integer> implements NeighbourhoodService {
    private NeighbourhoodMapper mapper;

    private NeighbourhoodRepository reposiory;

    @Autowired
    public NeighbourhoodServiceImpl(NeighbourhoodRepository reposiory) {
        this.reposiory = reposiory;
    }

    @Override
    public ResponseEntity create(NeighbourhoodDTO dto) {
        super.saveOrUpdate(mapper.convertToEntity(dto));
        return Response.ok();
    }

    @Override
    public ResponseEntity read(Integer id) {
        Optional<Neighbourhood> op = super.get(id);
        if(op.isPresent())
            return ResponseEntity.ok(mapper.convertToDto(op.get()));
        return Response.notFound("STATE_NOT_FOUND");
    }

    @Override
    public ResponseEntity update(Integer id, NeighbourhoodDTO dto) {
        Optional<Neighbourhood> op = super.get(id);
        if(op.isPresent()) {
            Neighbourhood neighbourhood = mapper.convertToEntity(dto);
            neighbourhood.setId(id);
            super.saveOrUpdate(neighbourhood);
            return Response.ok();
        }
        return Response.notFound("STATE_NOT_FOUND");
    }

    @Override
    public ResponseEntity delete(Integer id) {
        Optional<Neighbourhood> op = super.get(id);
        if(op.isPresent()) {
            super.removeById(id);
            return Response.ok();
        }
        return Response.notFound("STATE_NOT_FOUND");
    }
}
