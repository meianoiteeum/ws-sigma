package br.com.sigma.model;

import br.com.sigma.utils.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "city")
public class City implements BaseEntity<Integer> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "citid")
    private Integer id;

    @Column(name = "citname")
    private String name;

    @ManyToOne
    @JoinColumn(name = "citstaid", referencedColumnName = "staid")
    private State state;

    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL)
    private List<Neighbourhood> states;

}
