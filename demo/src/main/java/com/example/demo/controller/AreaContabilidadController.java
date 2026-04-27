package com.example.demo.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.AreaContabilidad;
import com.example.demo.service.AreaContabilidadService;

@RestController
@RequestMapping("/areacontabilidad")
public class AreaContabilidadController {
    
    private final AreaContabilidadService service;
    public AreaContabilidadController(AreaContabilidadService service) {
        this.service = service;
    }

    @GetMapping
    public List<AreaContabilidad> getAll() throws SQLException {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AreaContabilidad> getById(@PathVariable int id) throws SQLException {
        AreaContabilidad a = service.findById(id);
        return a != null ? ResponseEntity.ok(a) : ResponseEntity.notFound().build(); 
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody AreaContabilidad a) throws SQLException {
        service.insert(a);
        return ResponseEntity.ok("Creado correctamente");
    }

    @PutMapping
    public ResponseEntity<String> update(@PathVariable int id, @RequestBody AreaContabilidad a) throws SQLException {
        service.update(id, a);
        return ResponseEntity.ok("Actualizado correctamente");
    }

    @DeleteMapping
    public ResponseEntity<String> delete(@PathVariable int id) throws SQLException {
        service.delete(id);
        return ResponseEntity.ok("Eliminado correctamente");
    }
}
