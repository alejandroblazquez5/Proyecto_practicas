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

import com.example.demo.model.Maestra;
import com.example.demo.service.MaestraService;

@RestController
@RequestMapping("/maestra")
public class MaestraController {
    
    private final MaestraService service;
    public MaestraController(MaestraService service) {
        this.service = service;
    }

    @GetMapping
    public List<Maestra> getAll() throws SQLException {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Maestra> getById(@PathVariable int id) throws SQLException {
        Maestra m = service.findById(id);
        return m != null ? ResponseEntity.ok(m) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Integer> create(@RequestBody Maestra m) throws SQLException {
        int id = service.insert(m);
        return ResponseEntity.ok(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable int id, @RequestBody Maestra m) throws SQLException {
        service.update(id, m);
        return ResponseEntity.ok("Actualizado correctamente");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) throws SQLException {
        service.delete(id);
        return ResponseEntity.ok("Eliminado correctamente");
    }
}
