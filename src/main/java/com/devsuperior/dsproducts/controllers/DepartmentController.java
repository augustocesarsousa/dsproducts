package com.devsuperior.dsproducts.controllers;

import java.util.List;

import com.devsuperior.dsproducts.dto.DepartmentDTO;
import com.devsuperior.dsproducts.services.DepartmentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}