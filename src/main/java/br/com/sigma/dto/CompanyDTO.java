package br.com.sigma.dto;

import br.com.sigma.utils.BaseDTO;
import br.com.sigma.utils.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CompanyDTO extends BaseDTO {

    private Integer id;

    private String tradeName;

    private String corporateName;

    private String address;

    private String phone;

    private String federalTaxNumber;

    private Integer neighbourhoodId;
}
