package br.com.sigma.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "country")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "couid")
    private Integer id;

    @Column(name = "couname")
    private String name;

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL)
    private List<State> states;
}

