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

import com.example.demo.model.Topes;
import com.example.demo.service.TopesService;

@RestController
@RequestMapping("/topes")
public class TopesController {

    private final TopesService service;

    public TopesController(TopesService service) {
        this.service = service;
    }

    @GetMapping
    public List<Topes> getAll() throws SQLException {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Topes> getById(@PathVariable int id) throws SQLException {
        Topes t = service.findById(id);
        return t != null ? ResponseEntity.ok(t) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody Topes t) throws SQLException {
        service.insert(t);
        return ResponseEntity.ok("Creado correctamente");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable int id, @RequestBody Topes t) throws SQLException {
        service.update(id, t);
        return ResponseEntity.ok("Actualizado correctamente");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) throws SQLException {
        service.delete(id);
        return ResponseEntity.ok("Eliminado correctamente");
    }

    @DeleteMapping("/sabana/{idSabana}")
    public ResponseEntity<String> deleteBySabana(@PathVariable int idSabana) throws SQLException {
        service.deleteBySabana(idSabana);
        return ResponseEntity.ok("Eliminado correctamente");
    }

}
