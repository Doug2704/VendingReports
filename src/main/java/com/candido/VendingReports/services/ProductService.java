package com.candido.VendingReports.services;

import com.candido.VendingReports.entities.Machine;
import com.candido.VendingReports.entities.Product;
import com.candido.VendingReports.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;

    public Product findById(Long id) {
        Optional<Product> product = repository.findById(id);

        return product.get();
    }

    public List<Product> findAll() {
        return repository.findAll();
    }

    public Product create(Product product) {

        return repository.save(product);
    }

}
