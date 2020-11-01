package br.com.sigma.controller;

import br.com.sigma.dto.CityDTO;
import br.com.sigma.dto.filter.CityFilterDTO;
import br.com.sigma.mapper.CityMapper;
import br.com.sigma.model.City;
import br.com.sigma.service.CityService;
import br.com.sigma.utils.GenericMapper;
import br.com.sigma.utils.GenericService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api("city controller")
@RestController
@RequestMapping("/city")
public class CityController implements ListRest<City, CityMapper, CityFilterDTO, CityDTO, Integer> {

    private CityService service;

    @Override
    public GenericMapper<City, CityDTO> getMapper() {
        return new CityMapper();
    }

    @Override
    public CityMapper getFilterMapper() {
        return new CityMapper();
    }

    @Override
    public GenericService<City, Integer> getService() {
        return service;
    }

    @Autowired
    public CityController(CityService service){
        this.service = service;
    }

    @PostMapping
    @ApiOperation("Create city")
    public ResponseEntity create(@RequestBody CityDTO dto){
        return service.create(dto);
    }

    @GetMapping("/id")
    @ApiOperation("Find city by id")
    public ResponseEntity<CityDTO> find(@PathVariable Integer id){
        return service.read(id);
    }

    @PutMapping("/{id}")
    @ApiOperation("Update city")
    public ResponseEntity update(@PathVariable Integer id, @RequestBody CityDTO dto){
        return service.update(id, dto);
    }

    @DeleteMapping("{id}")
    @ApiOperation("Delete city")
    public ResponseEntity delete(@PathVariable Integer id){
        return service.delete(id);
    }
}
