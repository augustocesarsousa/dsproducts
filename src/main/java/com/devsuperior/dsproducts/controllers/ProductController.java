package com.devsuperior.dsproducts.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsproducts.dto.ProductDTO;
import com.devsuperior.dsproducts.services.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProductDTO> fingById(@PathVariable UUID id) {
        ProductDTO product = service.findById(id);
        return ResponseEntity.ok(product);
    }
    
    @GetMapping
    public ResponseEntity<List<ProductDTO>> findByDepartment(@RequestParam(name="department", defaultValue = "") String department) {
        List<ProductDTO> products = service.findByDepartment(department);
        return ResponseEntity.ok(products);
    }
}