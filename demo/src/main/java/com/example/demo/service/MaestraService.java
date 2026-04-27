package com.example.demo.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Maestra;

@Service
public class MaestraService {
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/proyecto", "root", "root");
    }

    public List<Maestra> findAll() throws SQLException {
        List<Maestra> list = new ArrayList<>();
        try (Connection conn = getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM maestra")) {
                while(rs.next()) {
                    Maestra m = new Maestra();
                    m.setIdSabana(rs.getInt("id_Sabana"));
                    m.setNombre(rs.getString("nombre"));
                    m.setFecha(rs.getDate("fecha").toLocalDate());
                    m.setComentario(rs.getString("comentario"));
                    list.add(m);
                }
            }
            return list;           
        }

    public Maestra findById(int id) throws SQLException {
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM maestra WHERE id_sabana = ?")) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Maestra m = new Maestra();
                m.setIdSabana(rs.getInt("id_sabana"));
                m.setNombre(rs.getString("nombre"));
                m.setFecha(rs.getDate("fecha").toLocalDate());
                m.setComentario(rs.getString("comentario"));
                return m;
            }
        }
        return null;
    }

    public void insert(Maestra m) throws SQLException {
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement("INSERT INTO maestra (nombre, fecha, comentario) VALUES (?, ?, ?)")) {
            ps.setString(1, m.getNombre());
            ps.setDate(2, Date.valueOf(m.getFecha()));
            ps.setString(3, m.getComentario());
            ps.executeUpdate();
        }
    }

    public void update(int id, Maestra m) throws SQLException {
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement("UPDATE maestra SET nombre=?, fecha=?, comentario=? WHERE id_sabana=?")) {
            ps.setString(1, m.getNombre());
            ps.setDate(2, Date.valueOf(m.getFecha()));
            ps.setString(3, m.getComentario());
            ps.setInt(4, id);
            ps.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement("DELETE FROM maestra WHERE id_sabana=?")) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}


