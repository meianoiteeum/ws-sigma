package br.com.sigma.mapper;

import br.com.sigma.dto.CompanyDTO;
import br.com.sigma.dto.filter.CompanyFilterDTO;
import br.com.sigma.model.Company;
import br.com.sigma.model.Neighbourhood;
import br.com.sigma.utils.FilterMapper;
import br.com.sigma.utils.GenericMapper;

public class CompanyMapper implements GenericMapper<Company, CompanyDTO>, FilterMapper<Company, CompanyFilterDTO> {
    @Override
    public Company convertFilterToEntity(CompanyFilterDTO filterDTO) {
        return Company.builder()
                .build();
    }

    @Override
    public Company convertToEntity(CompanyDTO dto) {
        return Company.builder()
                .id(dto.getId())
                .tradeName(dto.getTradeName())
                .address(dto.getAddress())
                .corporateName(dto.getCorporateName())
                .phone(dto.getPhone())
                .federalTaxNumber(dto.getFederalTaxNumber())
                .neighbourhood(Neighbourhood.builder()
                        .id(dto.getNeighbourhoodId())
                        .build())
                .build();
    }

    @Override
    public CompanyDTO convertToDto(Company entity) {
        return CompanyDTO.builder()
                .id(entity.getId())
                .tradeName(entity.getTradeName())
                .corporateName(entity.getCorporateName())
                .address(entity.getAddress())
                .phone(entity.getPhone())
                .federalTaxNumber(entity.getFederalTaxNumber())
                .neighbourhoodId(entity.getNeighbourhood().getId())
                .build();
    }
}
