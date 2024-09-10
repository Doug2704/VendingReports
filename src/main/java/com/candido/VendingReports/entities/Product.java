package com.candido.VendingReports.entities;

import jakarta.persistence.*;

public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int code;

    private int quantity;
    @ManyToOne
    @JoinColumn(name = "machine_id")
    private Machine machine;
}
