package com.rechom.provaap.repositories;

import com.rechom.provaap.domain.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
}
