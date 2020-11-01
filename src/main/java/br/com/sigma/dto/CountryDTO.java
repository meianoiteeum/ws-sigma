package br.com.sigma.dto;

import br.com.sigma.utils.BaseDTO;
import br.com.sigma.utils.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CountryDTO extends BaseDTO {
    private Integer id;

    private String name;
}

