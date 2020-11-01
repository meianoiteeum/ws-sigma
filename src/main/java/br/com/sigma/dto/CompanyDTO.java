package br.com.sigma.dto;

import br.com.sigma.utils.BaseDTO;
import br.com.sigma.utils.BaseEntity;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CompanyDTO extends BaseDTO {

    @Positive
    private Integer id;

    @NotBlank
    private String tradeName;

    @NotBlank
    private String corporateName;

    @NotBlank
    private String address;

    @NotBlank
    private String phone;

    @NotBlank
    private String federalTaxNumber;

    @Positive @NotNull
    private Integer neighbourhoodId;
}
