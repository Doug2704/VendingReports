package com.candido.VendingReports.services;

import com.candido.VendingReports.entities.Machine;
import com.candido.VendingReports.entities.Product;
import com.candido.VendingReports.repositories.MachineRepository;
import com.candido.VendingReports.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final MachineRepository machineRepository;

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);

    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product create(Product product, Long machineID) {
        Machine m = machineRepository.findById(machineID).orElseThrow(() -> new RuntimeException("Máquina não encontrada"));
        product.setMachine(m);
        return productRepository.save(product);
    }

    public Product update(Product product, Long id) {
        Product p = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        p.setMachine(product.getMachine());
        p.setCode(product.getCode());
        p.setName(product.getName());
        p.setQuantity(product.getQuantity());
        return productRepository.save(p);
    }

    public void delete(Long id) {
        Product p = productRepository.findById(id).get();
        productRepository.delete(p);
    }
}
