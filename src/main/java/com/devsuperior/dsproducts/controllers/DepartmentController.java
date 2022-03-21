package com.devsuperior.dsproducts.controllers;

import java.net.URI;
import java.util.List;
import java.util.UUID;

import com.devsuperior.dsproducts.dto.DepartmentDTO;
import com.devsuperior.dsproducts.services.DepartmentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = "/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService service;

    @GetMapping
    public ResponseEntity<List<DepartmentDTO>> findAll() {
        List<DepartmentDTO> departments = service.findAll();
        return ResponseEntity.ok(departments);
    }
    
    @GetMapping(value = "/{id}")
    public ResponseEntity<DepartmentDTO> fingById(@PathVariable UUID id) {
        DepartmentDTO department = service.findById(id);
        return ResponseEntity.ok(department);
    }
    
    @PostMapping
    public ResponseEntity<DepartmentDTO> insert(@RequestBody DepartmentDTO departmentDTO) {
    	departmentDTO = service.insert(departmentDTO);
    	URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(departmentDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(departmentDTO);
    }
}