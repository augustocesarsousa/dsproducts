package com.devsuperior.dsproducts.repositories;

import java.util.UUID;

import com.devsuperior.dsproducts.entities.Department;

import org.springframework.data.cassandra.repository.CassandraRepository;

public interface DepartmentRepository extends CassandraRepository<Department, UUID> {

}