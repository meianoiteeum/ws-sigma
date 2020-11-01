package br.com.sigma.mapper;

import br.com.sigma.dto.StateDTO;
import br.com.sigma.dto.filter.StateFilterDTO;
import br.com.sigma.model.Country;
import br.com.sigma.model.State;
import br.com.sigma.utils.FilterMapper;
import br.com.sigma.utils.GenericMapper;

public class StateMapper implements GenericMapper<State, StateDTO>, FilterMapper<State, StateFilterDTO> {
    @Override
    public State convertFilterToEntity(StateFilterDTO filterDTO) {
        return State.builder().build();
    }

    @Override
    public State convertToEntity(StateDTO dto) {
        return State.builder()
                .id(dto.getId())
                .name(dto.getName())
                .country(Country.builder()
                        .id(dto.getCountryId())
                        .build())
                .build();
    }

    @Override
    public StateDTO convertToDto(State entity) {
        return StateDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .countryId(entity.getCountry().getId())
                .build();
    }
}
