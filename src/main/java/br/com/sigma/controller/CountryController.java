package br.com.sigma.controller;

import br.com.sigma.dto.CityDTO;
import br.com.sigma.dto.CountryDTO;
import br.com.sigma.dto.filter.CountryFilterDTO;
import br.com.sigma.mapper.CountryMapper;
import br.com.sigma.model.Country;
import br.com.sigma.service.CountryService;
import br.com.sigma.utils.GenericMapper;
import br.com.sigma.utils.GenericService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api("country controller")
@RestController
@RequestMapping("/country")
public class CountryController implements ListRest<Country, CountryMapper, CountryFilterDTO, CountryDTO, Integer>{

    private CountryService service;

    @Override
    public GenericMapper<Country, CountryDTO> getMapper() {
        return new CountryMapper();
    }

    @Override
    public CountryMapper getFilterMapper() {
        return new CountryMapper();
    }

    @Override
    public GenericService<Country, Integer> getService() {
        return service;
    }

    @Autowired
    public CountryController(CountryService service) {
        this.service = service;
    }

    @PostMapping
    @ApiOperation("Create country")
    public ResponseEntity create(@RequestBody CountryDTO dto){
        return service.create(dto);
    }

    @GetMapping("/id")
    @ApiOperation("Find country by id")
    public ResponseEntity<CountryDTO> find(@PathVariable Integer id){
        return service.read(id);
    }

    @PutMapping("/{id}")
    @ApiOperation("Update country")
    public ResponseEntity update(@PathVariable Integer id, @RequestBody CountryDTO dto){
        return service.update(id, dto);
    }

    @DeleteMapping("{id}")
    @ApiOperation("Delete country")
    public ResponseEntity delete(@PathVariable Integer id){
        return service.delete(id);
    }
}
