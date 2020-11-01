package br.com.sigma.controller;

import br.com.sigma.dto.StateDTO;
import br.com.sigma.dto.filter.StateFilterDTO;
import br.com.sigma.mapper.StateMapper;
import br.com.sigma.model.State;
import br.com.sigma.service.StateService;
import br.com.sigma.utils.GenericMapper;
import br.com.sigma.utils.GenericService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api("state controller")
@RestController
@RequestMapping("/state")
public class StateController implements ListRest<State, StateMapper, StateFilterDTO, StateDTO, Integer>{

    private StateService service;

    @Override
    public GenericMapper<State, StateDTO> getMapper() {
        return new StateMapper();
    }

    @Override
    public StateMapper getFilterMapper() {
        return new StateMapper();
    }

    @Override
    public GenericService<State, Integer> getService() {
        return service;
    }

    @Autowired
    public StateController(StateService service) {
        this.service = service;
    }

    @PostMapping
    @ApiOperation("Create state")
    public ResponseEntity create(@RequestBody StateDTO dto){
        return service.create(dto);
    }

    @GetMapping("/id")
    @ApiOperation("Find state by id")
    public ResponseEntity<StateDTO> find(@PathVariable Integer id){
        return service.read(id);
    }

    @PutMapping("/{id}")
    @ApiOperation("Update state")
    public ResponseEntity update(@PathVariable Integer id, @RequestBody StateDTO dto){
        return service.update(id, dto);
    }

    @DeleteMapping("{id}")
    @ApiOperation("Delete state")
    public ResponseEntity delete(@PathVariable Integer id){
        return service.delete(id);
    }
}
