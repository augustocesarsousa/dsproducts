package com.devsuperior.dsproducts.repositories;

import java.util.UUID;

import com.devsuperior.dsproducts.entities.Product;

import org.springframework.data.cassandra.repository.CassandraRepository;

public interface ProductRepository extends CassandraRepository<Product, UUID> {

}