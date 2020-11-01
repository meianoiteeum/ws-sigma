package br.com.sigma.service.impl;

import br.com.sigma.dto.CityDTO;
import br.com.sigma.exceptions.Response;
import br.com.sigma.mapper.CityMapper;
import br.com.sigma.model.City;
import br.com.sigma.repository.CityRepository;
import br.com.sigma.service.CityService;
import br.com.sigma.service.StateService;
import br.com.sigma.utils.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CityServiceImpl extends GenericServiceImpl<City,Integer> implements CityService {

    private CityRepository repository;

    private StateService stateService;

    private CityMapper mapper;

    @Autowired
    public CityServiceImpl(CityRepository repository,
                           StateService stateService){
        this.mapper = new CityMapper();
        this.stateService = stateService;
    }

    @Override
    public ResponseEntity create(CityDTO dto) {
        ResponseEntity responseEntity = stateService.read(dto.getStateId());
        if(responseEntity.getStatusCode() == HttpStatus.NOT_FOUND)
            return responseEntity;
        super.saveOrUpdate(mapper.convertToEntity(dto));
        return Response.ok();
    }

    @Override
    public ResponseEntity read(Integer id) {
        Optional<City> op = super.get(id);
        if(!op.isPresent())
            return Response.notFound("CITY_NOT_FOUND");
        return ResponseEntity.ok(mapper.convertToDto(op.get()));
    }

    @Override
    public ResponseEntity update(Integer id, CityDTO dto) {
        Optional<City> op = super.get(id);
        if(op.isPresent())
            return Response.notFound("CITY_NOT_FOUND");

        ResponseEntity responseEntity = stateService.read(dto.getStateId());
        if(responseEntity.getStatusCode() == HttpStatus.NOT_FOUND)
            return responseEntity;

        City city = mapper.convertToEntity(dto);
        city.setId(id);
        super.saveOrUpdate(city);
        return Response.ok();

    }

    @Override
    public ResponseEntity delete(Integer id) {
        Optional<City> op = super.get(id);
        if(op.isPresent())
            return Response.notFound("CITY_NOT_FOUND");
        super.removeById(id);
        return Response.ok();
    }
}
