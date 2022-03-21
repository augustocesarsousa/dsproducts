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
    	Department department = getByid(id);
    	return new DepartmentDTO(department);
    }
    
    public DepartmentDTO insert(DepartmentDTO departmentDTO) {
    	Department department = new Department();
    	department.setId(UUID.randomUUID());
    	copyDtoToEntity(departmentDTO, department);
    	department = repository.save(department);
    	return new DepartmentDTO(department);
    }
    
    public DepartmentDTO update(UUID id, DepartmentDTO departmentDTO) {
    	Department department = getByid(id);
    	copyDtoToEntity(departmentDTO, department);
    	department = repository.save(department);
    	return new DepartmentDTO(department);
    }
    
    private Department getByid(UUID id) {
    	Optional<Department> department = repository.findById(id);
    	return department.orElseThrow(() -> new ResourceNotFoundException("Department not found!"));
    }

	private void copyDtoToEntity(DepartmentDTO departmentDTO, Department department) {
		department.setName(departmentDTO.getName());		
	}

}