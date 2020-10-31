package br.com.sigma.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "state")
public class State {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "staid")
    private Integer id;

    @Column(name = "staname")
    private String name;

    @ManyToOne
    @JoinColumn(name = "stacouid", referencedColumnName = "couid")
    private Country country;

    @OneToMany(mappedBy = "state", cascade = CascadeType.ALL)
    private List<City> citys;
}
