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

import com.example.demo.model.TipoTopes;
import com.example.demo.service.TipoTopesService;

@RestController
@RequestMapping("/tipotopes")
public class TipoTopesController {
    
    private final TipoTopesService service;
    public TipoTopesController(TipoTopesService service) {
        this.service = service;
    }

    @GetMapping
    public List<TipoTopes> getAll() throws SQLException {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoTopes> getById(@PathVariable int id) throws SQLException {
        TipoTopes t = service.findById(id);
        return t != null ? ResponseEntity.ok(t) : ResponseEntity.notFound().build();
    } 
        
    @PostMapping
    public ResponseEntity<String> create(@RequestBody TipoTopes t) throws SQLException {
        service.insert(t);
        return ResponseEntity.ok("Creado correctamente");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable int id, @RequestBody TipoTopes t) throws SQLException {
        service.update(id, t);
        return ResponseEntity.ok("Actualizado correctamente");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) throws SQLException {
        service.delete(id);
        return ResponseEntity.ok("Eliminado correctamente");
    }
}
