package br.com.sigma.mapper;

import br.com.sigma.dto.NeighbourhoodDTO;
import br.com.sigma.dto.filter.NeighbourhoodFilterDTO;
import br.com.sigma.model.City;
import br.com.sigma.model.Neighbourhood;
import br.com.sigma.utils.FilterMapper;
import br.com.sigma.utils.GenericMapper;

public class NeighbourhoodMapper implements GenericMapper<Neighbourhood, NeighbourhoodDTO>, FilterMapper<Neighbourhood, NeighbourhoodFilterDTO> {
    @Override
    public Neighbourhood convertFilterToEntity(NeighbourhoodFilterDTO filterDTO) {
        return Neighbourhood.builder()
                .build();
    }

    @Override
    public Neighbourhood convertToEntity(NeighbourhoodDTO dto) {
        return Neighbourhood.builder()
                .id(dto.getId())
                .name(dto.getName())
                .city(City.builder()
                        .id(dto.getCityId())
                        .build())
                .build();
    }

    @Override
    public NeighbourhoodDTO convertToDto(Neighbourhood entity) {
        return NeighbourhoodDTO.builder()
                .id(entity.getId())
                .cityId(entity.getCity().getId())
                .build();
    }
}
