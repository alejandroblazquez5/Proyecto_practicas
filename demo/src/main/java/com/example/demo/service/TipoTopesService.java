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

import com.example.demo.model.TipoTopes;

@Service
public class TipoTopesService {
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/proyecto", "root", "root");
    }

    public List<TipoTopes> findAll() throws SQLException {
        List<TipoTopes> list = new ArrayList<>();
        try (Connection conn = getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM tipoTopes")) {
            while (rs.next()) {
                TipoTopes t = new TipoTopes();
                t.setIdTipoTopes(rs.getInt("id_tipoTopes"));
                t.setAgrupacionTopes(rs.getString("agrupacionTopes"));
                list.add(t);
            }
        }
        return list;
    }

    public TipoTopes findById(int id) throws SQLException {
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM tipoTopes WHERE id_tipoTopes = ?")) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                TipoTopes t = new TipoTopes();
                t.setIdTipoTopes(rs.getInt("id_tipoTopes"));
                t.setAgrupacionTopes(rs.getString("agrupacionTopes"));
                return t;
            }
        }
        return null;
    }

    public void insert(TipoTopes t) throws SQLException {
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement("INSERT INTO tipoTopes (agrupacionTopes) VALUES (?)")) {
            ps.setString(1, t.getAgrupacionTopes());
            ps.executeUpdate();
        }
    }

    public void update(int id, TipoTopes t) throws SQLException {
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement("UPDATE tipoTopes SET agrupacionTopes=? WHERE id_tipoTopes=?")) {
            ps.setString(1, t.getAgrupacionTopes());
            ps.setInt(2, id);
            ps.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement("DELETE FROM tipoTopes WHERE id_tipoTopes=?")) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}

