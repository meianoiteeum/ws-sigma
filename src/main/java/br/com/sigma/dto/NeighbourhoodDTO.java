package br.com.sigma.dto;

import br.com.sigma.utils.BaseDTO;
import br.com.sigma.utils.BaseEntity;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NeighbourhoodDTO extends BaseDTO {

    @Positive
    private Integer id;

    @NotBlank
    private String name;

    @Positive @NotNull
    private Integer cityId;
}
