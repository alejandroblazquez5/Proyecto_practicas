package com.example.demo.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Margenes;

@Service
public class MargenesService {
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/proyecto", "root", "root");
    }

    public List<Margenes> findAll() throws SQLException {
        List<Margenes> list = new ArrayList<>();
        try (Connection conn = getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM margenes")) {
            while (rs.next()) {
                Margenes m = new Margenes();
                m.setIdMargen(rs.getInt("id_margen"));
                m.setIdSabana(rs.getInt("id_sabana"));
                m.setIdTipoMargen(rs.getInt("id_tipoMargen"));
                m.setMargen(rs.getBigDecimal("margen"));
                list.add(m);
            }
        }
        return list;
    }

    public Margenes findById(int id) throws SQLException {
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM margenes WHERE id_margen = ?")) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Margenes m = new Margenes();
                m.setIdMargen(rs.getInt("id_margen"));
                m.setIdSabana(rs.getInt("id_sabana"));
                m.setIdTipoMargen(rs.getInt("id_tipoMargen"));
                m.setMargen(rs.getBigDecimal("margen"));
                return m;
            }
        }
        return null;
    }

    public void insert(Margenes m) throws SQLException {
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement("INSERT INTO margenes (id_sabana, id_tipoMargen, margen) VALUES (?,?,?)")) {
            ps.setInt(1, m.getIdSabana());
            ps.setInt(2, m.getIdTipoMargen());
            ps.setBigDecimal(3, m.getMargen());
            ps.executeUpdate();
        }
    }

    public void update(int id, Margenes m) throws SQLException {
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement("UPDATE margenes SET id_sabana=?, id_tipoMargen=?, margen=? WHERE id_margen=?")) {
            ps.setInt(1, m.getIdSabana());
            ps.setInt(2, m.getIdTipoMargen());
            ps.setBigDecimal(3, m.getMargen());
            ps.setInt(4, id);
            ps.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement("DELETE FROM margenes WHERE id_margen=?")) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}
