package br.com.sigma.mapper;

import br.com.sigma.dto.filter.CityFilterDTO;
import br.com.sigma.model.City;
import br.com.sigma.model.State;
import br.com.sigma.utils.FilterMapper;
import br.com.sigma.utils.GenericMapper;

public class CityMapper implements GenericMapper<City, br.com.sigma.dto.CityDTO>, FilterMapper<City, CityFilterDTO> {
    @Override
    public City convertFilterToEntity(CityFilterDTO filterDTO) {
        return City.builder()
                .build();
    }

    @Override
    public City convertToEntity(br.com.sigma.dto.CityDTO dto) {
        return City.builder()
                .id(dto.getId())
                .name(dto.getName())
                .state(State.builder()
                        .id(dto.getId())
                        .build())
                .build();
    }

    @Override
    public br.com.sigma.dto.CityDTO convertToDto(City entity) {
        return br.com.sigma.dto.CityDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .stateId(entity.getState().getId())
                .build();
    }
}
