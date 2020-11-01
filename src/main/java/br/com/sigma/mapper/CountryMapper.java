package br.com.sigma.mapper;

import br.com.sigma.dto.CountryDTO;
import br.com.sigma.dto.filter.CountryFilterDTO;
import br.com.sigma.model.Country;
import br.com.sigma.utils.FilterMapper;
import br.com.sigma.utils.GenericMapper;

public class CountryMapper implements GenericMapper<Country, CountryDTO>, FilterMapper<Country, CountryFilterDTO> {
    @Override
    public Country convertFilterToEntity(CountryFilterDTO filterDTO) {
        return Country.builder().build();
    }

    @Override
    public Country convertToEntity(CountryDTO dto) {
        return Country.builder()
                .id(dto.getId())
                .name(dto.getName())
                .build();
    }

    @Override
    public CountryDTO convertToDto(Country entity) {
        return CountryDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }
}
