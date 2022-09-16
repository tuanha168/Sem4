package com.example.examapi;

import com.example.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
public class ProductsController {
    @Autowired
    private ProductsRepository productsRepository;

    @RequestMapping(value = "/api/products")
    public ResponseEntity<Object> getAllProducts() {
        return new ResponseEntity<>(productsRepository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/api/products", method = RequestMethod.POST)
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        productsRepository.save(product);
        return new ResponseEntity<Product>(product, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/api/products/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateProduct(
            @PathVariable("id") String id,
            @RequestBody Product product) {
        if (productsRepository.findById(Integer.parseInt(id)).isPresent()) {
            Product prod = productsRepository.findById(Integer.parseInt(id)).get();
            prod.setQuantity(product.getQuantity());
            prod.setName(product.getName());
            productsRepository.save(prod);
            return new ResponseEntity<>("Product is updated successfully", HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>("Product not found", HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/api/products/sell/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> sellProduct(
            @PathVariable("id") String id,
            @RequestBody String product) {
        if (productsRepository.findById(Integer.parseInt(id)).isPresent()) {
            Product prod = productsRepository.findById(Integer.parseInt(id)).get();
            prod.setQuantity(prod.getQuantity() - Integer.parseInt(product));
            productsRepository.save(prod);
            return new ResponseEntity<>("Product is sold", HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>("Product not found", HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/api/products/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@PathVariable("id") String id) {
        productsRepository.deleteById(Integer.parseInt(id));
        return new ResponseEntity<>("Product is deleted successfully", HttpStatus.OK);
    }
}
