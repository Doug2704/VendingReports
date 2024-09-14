package com.candido.VendingReports.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int code;

    private int quantity;

    @ManyToOne
    @JoinColumn(name = "machine_id")
    private Machine machine;
}
