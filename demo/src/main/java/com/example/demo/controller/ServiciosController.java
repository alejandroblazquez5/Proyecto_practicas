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

import com.example.demo.model.Servicios;
import com.example.demo.service.ServiciosService;

@RestController
@RequestMapping("/servicios")
public class ServiciosController {

    private final ServiciosService service;

    public ServiciosController(ServiciosService service) {
        this.service = service;
    }

    @GetMapping
    public List<Servicios> getAll() throws SQLException {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Servicios> getById(@PathVariable int id) throws SQLException {
        Servicios s = service.findById(id);
        return s != null ? ResponseEntity.ok(s) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Integer> create(@RequestBody Servicios s) throws SQLException {
        int id = service.insert(s);
        return ResponseEntity.ok(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable int id, @RequestBody Servicios s) throws SQLException {
        service.update(id, s);
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
