package br.com.sigma.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "neighbourhood")
public class Neighbourhood {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "neiid")
    private Integer id;

    @Column(name = "neiname")
    private String name;

    @ManyToOne
    @JoinColumn(name = "neicitid", referencedColumnName = "citid")
    private City city;

    @OneToMany(mappedBy = "neighbourhood", cascade = CascadeType.ALL)
    private List<Company> company;
}
