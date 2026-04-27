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

import com.example.demo.model.TopesAnuales;

@Service
public class TopesAnualesService {
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/proyecto", "root", "root");
    }

    public List<TopesAnuales> findAll() throws SQLException {
        List<TopesAnuales> list = new ArrayList<>();
        try (Connection conn = getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM topes_anuales")) {
            while (rs.next()) {
                TopesAnuales t = new TopesAnuales();
                t.setIdTopeAnual(rs.getInt("id_topeAnual"));
                t.setIdTopes(rs.getInt("id_topes"));
                t.setAnos(rs.getInt("anos"));
                t.setCoste(rs.getBigDecimal("COSTE"));
                t.setPvp(rs.getBigDecimal("PVP"));
                t.setGp(rs.getInt("GP"));
                t.setGpPct(rs.getInt("GPpct"));
                list.add(t);
            }
        }
        return list;
    }

    public TopesAnuales findById(int id) throws SQLException {
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM topes_anuales WHERE id_topeAnual = ?")) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                TopesAnuales t = new TopesAnuales();
                t.setIdTopeAnual(rs.getInt("id_topeAnual"));
                t.setIdTopes(rs.getInt("id_topes"));
                t.setAnos(rs.getInt("anos"));
                t.setCoste(rs.getBigDecimal("COSTE"));
                t.setPvp(rs.getBigDecimal("PVP"));
                t.setGp(rs.getInt("GP"));
                t.setGpPct(rs.getInt("GPpct"));
                return t;
            }
        }
        return null;
    }

    public void insert(TopesAnuales t) throws SQLException {
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement("INSERT INTO topes_anuales (id_topes, anos, COSTE, PVP, GP, GPpct) VALUES (?,?,?,?,?,?)")) {
            ps.setInt(1, t.getIdTopes()); 
            ps.setInt(2, t.getAnos());
            ps.setBigDecimal(3, t.getCoste()); 
            ps.setBigDecimal(4, t.getPvp());
            ps.setInt(5, t.getGp()); 
            ps.setInt(6, t.getGpPct());
            ps.executeUpdate();
        }
    }

    public void update(int id, TopesAnuales t) throws SQLException {
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement("UPDATE topes_anuales SET id_topes=?, anos=?, COSTE=?, PVP=?, GP=?, GPpct=? WHERE id_topeAnual=?")) {
            ps.setInt(1, t.getIdTopes()); 
            ps.setInt(2, t.getAnos());
            ps.setBigDecimal(3, t.getCoste()); 
            ps.setBigDecimal(4, t.getPvp());
            ps.setInt(5, t.getGp()); 
            ps.setInt(6, t.getGpPct());
            ps.setInt(7, id);
            ps.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement("DELETE FROM topes_anuales WHERE id_topeAnual=?")) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}
