package com.devsuperior.dsproducts.services;

import java.util.List;
import java.util.stream.Collectors;

import com.devsuperior.dsproducts.dto.DepartmentDTO;
import com.devsuperior.dsproducts.entities.Department;
import com.devsuperior.dsproducts.repositories.DepartmentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository repository;

    public List<DepartmentDTO> findAll() {
        List<Department> departments = repository.findAll();
        return departments.stream().map(x -> new DepartmentDTO(x)).collect(Collectors.toList());
    }

}