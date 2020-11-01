package br.com.sigma.service.impl;

import br.com.sigma.dto.CompanyDTO;
import br.com.sigma.exceptions.Response;
import br.com.sigma.mapper.CompanyMapper;
import br.com.sigma.model.Company;
import br.com.sigma.repository.CompanyRepository;
import br.com.sigma.service.CompanyService;
import br.com.sigma.service.NeighbourhoodService;
import br.com.sigma.utils.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompanyServiceImpl extends GenericServiceImpl<Company,Integer> implements CompanyService {
    private CompanyMapper mapper;

    private CompanyRepository repository;

    private NeighbourhoodService neighbourhoodService;

    @Autowired
    public CompanyServiceImpl(CompanyRepository repository,
                              NeighbourhoodService neighbourhoodService) {
        this.repository = repository;
        this.mapper = new CompanyMapper();
        this.neighbourhoodService = neighbourhoodService;
    }

    @Override
    public ResponseEntity create(CompanyDTO dto) {
        ResponseEntity responseEntity = neighbourhoodService.read(dto.getNeighbourhoodId());
        if(responseEntity.getStatusCode() == HttpStatus.NOT_FOUND)
            return responseEntity;

        super.saveOrUpdate(mapper.convertToEntity(dto));
        return Response.ok();
    }

    @Override
    public ResponseEntity read(Integer id) {
        Optional<Company> op = super.get(id);
        if(op.isPresent())
            return ResponseEntity.ok(mapper.convertToDto(op.get()));
        return Response.notFound("COMPANY_NOT_FOUND");
    }

    @Override
    public ResponseEntity update(Integer id, CompanyDTO dto) {
        Optional<Company> op = super.get(id);
        if(op.isPresent())
            return Response.notFound("COMPANY_NOT_FOUND");

        ResponseEntity responseEntity = neighbourhoodService.read(dto.getNeighbourhoodId());
        if(responseEntity.getStatusCode() == HttpStatus.NOT_FOUND)
            return responseEntity;

        Company company = mapper.convertToEntity(dto);
        company.setId(id);
        super.saveOrUpdate(company);
        return Response.ok();
    }

    @Override
    public ResponseEntity delete(Integer id) {
        Optional<Company> op = super.get(id);
        if(op.isPresent()) {
            super.removeById(id);
            return Response.ok();
        }
        return Response.notFound("COMPANY_NOT_FOUND");
    }
}
