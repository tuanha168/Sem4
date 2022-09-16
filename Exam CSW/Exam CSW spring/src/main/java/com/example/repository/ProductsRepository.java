package com.example.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.model.Product;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository extends CrudRepository<Product, Integer> {
}
