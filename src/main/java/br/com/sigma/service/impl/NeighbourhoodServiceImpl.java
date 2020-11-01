package br.com.sigma.service.impl;

import br.com.sigma.dto.NeighbourhoodDTO;
import br.com.sigma.exceptions.Response;
import br.com.sigma.mapper.NeighbourhoodMapper;
import br.com.sigma.model.Neighbourhood;
import br.com.sigma.repository.NeighbourhoodRepository;
import br.com.sigma.service.CityService;
import br.com.sigma.service.NeighbourhoodService;
import br.com.sigma.utils.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NeighbourhoodServiceImpl extends GenericServiceImpl<Neighbourhood,Integer> implements NeighbourhoodService {
    private NeighbourhoodMapper mapper;

    private NeighbourhoodRepository reposiory;

    private CityService cityService;

    @Autowired
    public NeighbourhoodServiceImpl(NeighbourhoodRepository reposiory,
                                    CityService cityService) {
        this.reposiory = reposiory;
        this.mapper = new NeighbourhoodMapper();
        this.cityService = cityService;
    }

    @Override
    public ResponseEntity create(NeighbourhoodDTO dto) {
        ResponseEntity responseEntity = cityService.read(dto.getCityId());
        if(responseEntity.getStatusCode() == HttpStatus.NOT_FOUND)
            return responseEntity;
        Neighbourhood neighbourhood = super.saveOrUpdate(mapper.convertToEntity(dto));
        return Response.created(mapper.convertToDto(neighbourhood));
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
        if(op.isPresent())
            return Response.notFound("STATE_NOT_FOUND");

        ResponseEntity responseEntity = cityService.read(dto.getCityId());
        if(responseEntity.getStatusCode() == HttpStatus.NOT_FOUND)
            return responseEntity;

        Neighbourhood neighbourhood = mapper.convertToEntity(dto);
        neighbourhood.setId(id);
        super.saveOrUpdate(neighbourhood);
        return Response.ok();
    }

    @Override
    public ResponseEntity delete(Integer id) {
        Optional<Neighbourhood> op = super.get(id);
        if(op.isPresent())
            return Response.notFound("STATE_NOT_FOUND");
        
        super.removeById(id);
        return Response.ok();
    }
}
