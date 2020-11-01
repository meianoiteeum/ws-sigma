package br.com.sigma.controller;

import br.com.sigma.dto.NeighbourhoodDTO;
import br.com.sigma.dto.filter.NeighbourhoodFilterDTO;
import br.com.sigma.mapper.NeighbourhoodMapper;
import br.com.sigma.model.Neighbourhood;
import br.com.sigma.service.NeighbourhoodService;
import br.com.sigma.utils.GenericMapper;
import br.com.sigma.utils.GenericService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api("neighbourhood controller")
@RestController
@RequestMapping("/neighbourhood")
public class NeighbourhoodController implements ListRest<Neighbourhood, NeighbourhoodMapper, NeighbourhoodFilterDTO, NeighbourhoodDTO, Integer>{

    private NeighbourhoodService service;

    @Override
    public GenericMapper<Neighbourhood, NeighbourhoodDTO> getMapper() {
        return new NeighbourhoodMapper();
    }

    @Override
    public NeighbourhoodMapper getFilterMapper() {
        return new NeighbourhoodMapper();
    }

    @Override
    public GenericService<Neighbourhood, Integer> getService() {
        return service;
    }

    @Autowired
    public NeighbourhoodController(NeighbourhoodService service) {
        this.service = service;
    }

    @PostMapping
    @ApiOperation("Create neighbourhood")
    public ResponseEntity create(@RequestBody NeighbourhoodDTO dto){
        return service.create(dto);
    }

    @GetMapping("/id")
    @ApiOperation("Find neighbourhood by id")
    public ResponseEntity<NeighbourhoodDTO> find(@PathVariable Integer id){
        return service.read(id);
    }

    @PutMapping("/{id}")
    @ApiOperation("Update neighbourhood")
    public ResponseEntity update(@PathVariable Integer id, @RequestBody NeighbourhoodDTO dto){
        return service.update(id, dto);
    }

    @DeleteMapping("{id}")
    @ApiOperation("Delete neighbourhood")
    public ResponseEntity delete(@PathVariable Integer id){
        return service.delete(id);
    }
}
