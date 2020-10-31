package br.com.sigma.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comid")
    private Integer id;

    @Column(name = "comtradename")
    private String tradeName;

    @Column(name = "comcorporatename")
    private String corporateName;

    @Column(name = "comaddress")
    private String address;

    @Column(name = "comphone")
    private String phone;

    @Column(name = "comfederaltaxnumber")
    private String federalTaxNumber;

    @ManyToOne
    @JoinColumn(name = "comneiid", referencedColumnName = "neiid")
    private Neighbourhood neighbourhood;
}
