package com.candido.VendingReports.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Machine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String code;

    @Column(nullable = false)
    private String Client;

    @OneToMany(mappedBy = "machine")
    private List<Product> products;

    private Long total;

    private Double audit03, audit08, audit09;

}
