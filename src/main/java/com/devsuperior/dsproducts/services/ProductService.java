package com.devsuperior.dsproducts.services;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    
    private Product getByid(UUID id) {
    	Optional<Product> product = repository.findById(id);
    	return product.orElseThrow(() -> new ResourceNotFoundException("Product not found!"));
    }

	private void copyDtoToEntity(ProductDTO productDTO, Product product) {
		product.setName(productDTO.getName());		
	}

}