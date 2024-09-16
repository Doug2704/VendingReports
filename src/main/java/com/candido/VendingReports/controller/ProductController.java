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
import java.util.Optional;

@RestController
@RequestMapping(value = "api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id) {
        Optional<Product> product = productService.findById(id);
        if (product.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(product.get(), HttpStatus.FOUND);
    }

    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        List<Product> products = productService.findAll();
        return new ResponseEntity<>(products, HttpStatus.FOUND);
    }

    @PostMapping("/{machineId}")
    public ResponseEntity<?> create(@RequestBody Product product, @PathVariable Long machineId) {
        try {
            Product p = productService.create(product, machineId);
            return new ResponseEntity<>(p, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}