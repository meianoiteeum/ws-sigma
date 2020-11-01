package br.com.sigma.controller;

import br.com.sigma.dto.CityDTO;
import br.com.sigma.dto.CompanyDTO;
import br.com.sigma.dto.filter.CompanyFilterDTO;
import br.com.sigma.mapper.CityMapper;
import br.com.sigma.mapper.CompanyMapper;
import br.com.sigma.model.City;
import br.com.sigma.model.Company;
import br.com.sigma.service.CityService;
import br.com.sigma.service.CompanyService;
import br.com.sigma.utils.GenericMapper;
import br.com.sigma.utils.GenericService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api("company controller")
@RestController
@RequestMapping("/company")
public class CompanyController implements ListRest<Company, CompanyMapper, CompanyFilterDTO, CompanyDTO, Integer>{

    private CompanyService service;

    @Override
    public GenericMapper<Company, CompanyDTO> getMapper() {
        return new CompanyMapper();
    }

    @Override
    public CompanyMapper getFilterMapper() {
        return new CompanyMapper();
    }

    @Override
    public GenericService<Company, Integer> getService() {
        return service;
    }

    @Autowired
    public CompanyController(CompanyService service){
        this.service = service;
    }

    @PostMapping
    @ApiOperation("Create company")
    public ResponseEntity create(@RequestBody CompanyDTO dto){
        return service.create(dto);
    }

    @GetMapping("/id")
    @ApiOperation("Find company by id")
    public ResponseEntity<CompanyDTO> find(@PathVariable Integer id){
        return service.read(id);
    }

    @PutMapping("/{id}")
    @ApiOperation("Update company")
    public ResponseEntity update(@PathVariable Integer id, @RequestBody CompanyDTO dto){
        return service.update(id, dto);
    }

    @DeleteMapping("{id}")
    @ApiOperation("Delete company")
    public ResponseEntity delete(@PathVariable Integer id){
        return service.delete(id);
    }
}
