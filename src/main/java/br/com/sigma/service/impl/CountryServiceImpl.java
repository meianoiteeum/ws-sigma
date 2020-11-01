package br.com.sigma.service.impl;

import br.com.sigma.dto.CountryDTO;
import br.com.sigma.exceptions.Response;
import br.com.sigma.mapper.CountryMapper;
import br.com.sigma.model.Country;
import br.com.sigma.repository.CountryRepository;
import br.com.sigma.service.CountryService;
import br.com.sigma.utils.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CountryServiceImpl extends GenericServiceImpl<Country,Integer> implements CountryService {

    private CountryRepository repository;

    private CountryMapper mapper;

    @Autowired
    public CountryServiceImpl(CountryRepository repository) {
        this.repository = repository;
        this.mapper = new CountryMapper();
    }

    @Override
    public ResponseEntity create(CountryDTO dto) {
        super.saveOrUpdate(mapper.convertToEntity(dto));
        return Response.ok();
    }

    @Override
    public ResponseEntity read(Integer id) {
        Optional<Country> op = super.get(id);
        if(op.isPresent())
            return ResponseEntity.ok(mapper.convertToDto(op.get()));
        return Response.notFound("COUNTRY_NOT_FOUND");
    }

    @Override
    public ResponseEntity update(Integer id, CountryDTO dto) {
        Optional<Country> op = super.get(id);
        if(op.isPresent()) {
            Country country = mapper.convertToEntity(dto);
            country.setId(id);
            super.saveOrUpdate(country);
            return Response.ok();
        }
        return Response.notFound("COUNTRY_NOT_FOUND");
    }

    @Override
    public ResponseEntity delete(Integer id) {
        Optional<Country> op = super.get(id);
        if(op.isPresent()) {
            super.removeById(id);
            return Response.ok();
        }
        return Response.notFound("COUNTRY_NOT_FOUND");
    }
}
