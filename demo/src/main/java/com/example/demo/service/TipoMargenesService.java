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

import com.example.demo.model.TipoMargenes;

@Service
public class TipoMargenesService {
    
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/proyecto", "root", "root");
    }

    public List<TipoMargenes> findAll() throws SQLException {
        List<TipoMargenes> list = new ArrayList<>();
        try (Connection conn = getConnection();
            Statement st = conn.createStatement();
            ResultSet rs =st.executeQuery("SELECT * FROM tipoMargenes")) {
                while (rs.next()) {
                    TipoMargenes t = new TipoMargenes();
                    t.setIdTipoMargen(rs.getInt("id_tipoMargen"));
                    t.setTipo(rs.getString("Tipo"));
                    list.add(t);
                }     
            }
        return list;
    }

    public TipoMargenes findById(int id) throws SQLException {
        try(Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM tipoMargenes WHERE id_tipoMargen = ?")) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    TipoMargenes t = new TipoMargenes();
                    t.setIdTipoMargen(rs.getInt("id_tipoMargen"));
                    t.setTipo(rs.getString("tipo"));
                    return t;
                }
            }
            return null;
    }

    public void insert(TipoMargenes t) throws SQLException {
        try (Connection conn = getConnection();
        PreparedStatement ps = conn.prepareStatement("INSERT INTO tipoMargenes (tipo) VALUES (?)")) {
            ps.setString(1, t.getTipo());
            ps.executeUpdate();
        }
    }

    public void update(int id, TipoMargenes t) throws SQLException {
        try (Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement("UPDATE tipoMargenes SET tipo=? WHERE id_tipoMargen=?")) {
                ps.setString(1, t.getTipo());
                ps.setInt(2, id);
                ps.executeUpdate();
            }
    }

    public void delete(int id) throws  SQLException  {
        try(Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement("DELETE FROM tipoMargenes WHERE id_tipoMargen=?")) {
                ps.setInt(1, id);
                ps.executeUpdate();
        }
    }
}       
    
