package com.example.Proyecto_Vet.controller;

import java.util.List;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.example.Proyecto_Vet.model.Empleado;
import com.example.Proyecto_Vet.service.EmpleadoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/empleado")
@RequiredArgsConstructor
public class EmpleadoController {

    private final EmpleadoService service;

    @GetMapping
    public List<Empleado> getAll() { return service.findAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<Empleado> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<Empleado> create(@RequestBody Empleado empleado) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(empleado));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Empleado> update(@PathVariable Integer id, @RequestBody Empleado empleado) {
        return ResponseEntity.ok(service.update(id, empleado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}