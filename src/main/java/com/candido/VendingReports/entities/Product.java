package com.candido.VendingReports.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonBackReference
    private Machine machine;

    @JsonProperty("machine_id")
    private Long getMachineId(){
        return machine.getId();
    }
}
