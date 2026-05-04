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

import com.example.demo.model.Margenes;
import com.example.demo.service.MargenesService;

@RestController
@RequestMapping("/margenes")
public class MargenesController {

    private final MargenesService service;

    public MargenesController(MargenesService service) {
        this.service = service;
    }

    @GetMapping
    public List<Margenes> getAll() throws SQLException {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Margenes> getById(@PathVariable int id) throws SQLException {
        Margenes m = service.findById(id);
        return m != null ? ResponseEntity.ok(m) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody Margenes m) throws SQLException {
        service.insert(m);
        return ResponseEntity.ok("Creado correctamente");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable int id, @RequestBody Margenes m) throws SQLException {
        service.update(id, m);
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
