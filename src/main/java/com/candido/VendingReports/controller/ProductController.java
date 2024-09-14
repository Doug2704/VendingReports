package com.candido.VendingReports.controller;

import com.candido.VendingReports.entities.Machine;
import com.candido.VendingReports.entities.Product;
import com.candido.VendingReports.services.MachineService;
import com.candido.VendingReports.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService service;

    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id) {
        Product product = service.findById(id);
        return new ResponseEntity<>(product, HttpStatus.FOUND);
    }

    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        List<Product> products = service.findAll();
        return new ResponseEntity<>(products, HttpStatus.FOUND);
    }

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody Product product) {

        Product p = service.create(product);
        return new ResponseEntity<>(p, HttpStatus.CREATED);
    }
}
