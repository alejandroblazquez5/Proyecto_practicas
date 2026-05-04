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

import com.example.demo.model.Topes;

@Service
public class TopesService {

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/proyecto", "root", "root");
    }

    public List<Topes> findAll() throws SQLException {
        List<Topes> list = new ArrayList<>();
        try (Connection conn = getConnection(); Statement st = conn.createStatement(); ResultSet rs = st.executeQuery("SELECT * FROM topes")) {
            while (rs.next()) {
                Topes t = new Topes();
                t.setIdTopes(rs.getInt("id_topes"));
                t.setIdSabana(rs.getInt("id_sabana"));
                t.setIdTipoTopes(rs.getInt("id_tipoTopes"));
                t.setTopes(rs.getInt("topes"));
                list.add(t);
            }
        }
        return list;
    }

    public Topes findById(int id) throws SQLException {
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement("SELECT * FROM topes WHERE id_topes = ?")) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Topes t = new Topes();
                t.setIdTopes(rs.getInt("id_topes"));
                t.setIdSabana(rs.getInt("id_sabana"));
                t.setIdTipoTopes(rs.getInt("id_tipoTopes"));
                t.setTopes(rs.getInt("topes"));
                return t;
            }
        }
        return null;
    }

    public void insert(Topes t) throws SQLException {
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement("INSERT INTO topes (id_sabana, id_tipoTopes, topes) VALUES (?,?,?)")) {
            ps.setInt(1, t.getIdSabana());
            ps.setInt(2, t.getIdTipoTopes());
            ps.setInt(3, t.getTopes());
            ps.executeUpdate();
        }
    }

    public void update(int id, Topes t) throws SQLException {
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement("UPDATE topes SET id_sabana=?, id_tipoTopes=?, topes=? WHERE id_topes=?")) {
            ps.setInt(1, t.getIdSabana());
            ps.setInt(2, t.getIdTipoTopes());
            ps.setInt(3, t.getTopes());
            ps.setInt(4, id);
            ps.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement("DELETE FROM topes WHERE id_topes=?")) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    public void deleteBySabana(int idSabana) throws SQLException {
        String sql = "DELETE FROM topes WHERE id_sabana=?";
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idSabana);
            ps.executeUpdate();
        }
    }

}
