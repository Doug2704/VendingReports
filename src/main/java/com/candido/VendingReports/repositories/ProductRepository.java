package com.candido.VendingReports.repositories;

import com.candido.VendingReports.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
