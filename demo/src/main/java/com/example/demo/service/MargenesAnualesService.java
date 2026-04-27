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

import com.example.demo.model.MargenesAnuales;

@Service
public class MargenesAnualesService {
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/proyecto", "root", "root");
    }

    public List<MargenesAnuales> findAll() throws SQLException {
        List<MargenesAnuales> list = new ArrayList<>();
        try (Connection conn = getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM margenesAnuales")) {
            while (rs.next()) {
                MargenesAnuales m = new MargenesAnuales();
                m.setIdMargenAnual(rs.getInt("id_margenAnual"));
                m.setIdMargen(rs.getInt("id_margen"));
                m.setAno(rs.getInt("ano"));
                m.setCoste(rs.getBigDecimal("COSTE"));
                m.setPvp(rs.getBigDecimal("PVP"));
                m.setGp(rs.getInt("GP"));
                m.setGpPct(rs.getInt("GPpct"));
                list.add(m);
            }
        }
        return list;
    }

    public MargenesAnuales findById(int id) throws SQLException {
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM margenesAnuales WHERE id_margenAnual = ?")) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                MargenesAnuales m = new MargenesAnuales();
                m.setIdMargenAnual(rs.getInt("id_margenAnual"));
                m.setIdMargen(rs.getInt("id_margen"));
                m.setAno(rs.getInt("ano"));
                m.setCoste(rs.getBigDecimal("COSTE"));
                m.setPvp(rs.getBigDecimal("PVP"));
                m.setGp(rs.getInt("GP"));
                m.setGpPct(rs.getInt("GPpct"));
                return m;
            }
        }
        return null;
    }

    public void insert(MargenesAnuales m) throws SQLException {
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement("INSERT INTO margenesAnuales (id_margen, ano, COSTE, PVP, GP, GPpct) VALUES (?,?,?,?,?,?)")) {
            ps.setInt(1, m.getIdMargen()); 
            ps.setInt(2, m.getAno());
            ps.setBigDecimal(3, m.getCoste()); 
            ps.setBigDecimal(4, m.getPvp());
            ps.setInt(5, m.getGp()); 
            ps.setInt(6, m.getGpPct());
            ps.executeUpdate();
        }
    }

    public void update(int id, MargenesAnuales m) throws SQLException {
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement("UPDATE margenesAnuales SET id_margen=?, ano=?, COSTE=?, PVP=?, GP=?, GPpct=? WHERE id_margenAnual=?")) {
            ps.setInt(1, m.getIdMargen()); 
            ps.setInt(2, m.getAno());
            ps.setBigDecimal(3, m.getCoste()); 
            ps.setBigDecimal(4, m.getPvp());
            ps.setInt(5, m.getGp()); 
            ps.setInt(6, m.getGpPct());
            ps.setInt(7, id);
            ps.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement("DELETE FROM margenesAnuales WHERE id_margenAnual=?")) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}
