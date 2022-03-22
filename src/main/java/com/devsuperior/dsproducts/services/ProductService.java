package com.devsuperior.dsproducts.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.devsuperior.dsproducts.dto.ProductDTO;
import com.devsuperior.dsproducts.entities.Product;
import com.devsuperior.dsproducts.repositories.ProductRepository;
import com.devsuperior.dsproducts.services.exceptions.ResourceNotFoundException;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public ProductDTO findById(UUID id) {
    	Product product = getByid(id);
    	return new ProductDTO(product);
    }
    
    public List<ProductDTO> findByDepartment(@PathVariable String department) {
    	List<Product> products = repository.findByDepartment(department);
    	return products.stream().map(x -> new ProductDTO(x)).collect(Collectors.toList());
    }
    
    private Product getByid(UUID id) {
    	Optional<Product> product = repository.findById(id);
    	return product.orElseThrow(() -> new ResourceNotFoundException("Product not found!"));
    }

}