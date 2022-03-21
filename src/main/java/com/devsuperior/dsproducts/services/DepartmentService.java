package com.devsuperior.dsproducts.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.dsproducts.dto.DepartmentDTO;
import com.devsuperior.dsproducts.entities.Department;
import com.devsuperior.dsproducts.repositories.DepartmentRepository;
import com.devsuperior.dsproducts.services.exceptions.ResourceNotFoundException;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository repository;

    public List<DepartmentDTO> findAll() {
        List<Department> departments = repository.findAll();
        return departments.stream().map(x -> new DepartmentDTO(x)).collect(Collectors.toList());
    }
    
    public DepartmentDTO findById(UUID id) {
    	Optional<Department> department = repository.findById(id);
    	Department entity = department.orElseThrow(() -> new ResourceNotFoundException("Department not found!"));
    	return new DepartmentDTO(entity);
    }

}