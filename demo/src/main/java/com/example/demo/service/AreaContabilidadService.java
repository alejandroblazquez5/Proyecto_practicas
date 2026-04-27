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

import com.example.demo.model.AreaContabilidad;

@Service
public class AreaContabilidadService {
   private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/proyecto", "root", "root");
    }

    private AreaContabilidad mapRow(ResultSet rs) throws SQLException {
        AreaContabilidad a = new AreaContabilidad();
        a.setIdAreaContabilidad(rs.getInt("id_areaContabilidad"));
        a.setIdServicios(rs.getInt("id_servicios"));
        a.setTipoPago(rs.getString("Tipo_pago"));
        a.setMeses(rs.getInt("Meses"));
        a.setHitoFirma(rs.getInt("Hito_firma"));
        a.setH1(rs.getInt("H1")); 
        a.setH2(rs.getInt("H2")); 
        a.setH3(rs.getInt("H3"));
        a.setH4(rs.getInt("H4")); 
        a.setH5(rs.getInt("H5")); 
        a.setH6(rs.getInt("H6"));
        a.setHitoCierre(rs.getInt("Hito_cierre"));
        return a;
    }

    public List<AreaContabilidad> findAll() throws SQLException {
        List<AreaContabilidad> list = new ArrayList<>();
        try (Connection conn = getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM areaContabilidad")) {
            while (rs.next()) list.add(mapRow(rs));
        }
        return list;
    }

    public AreaContabilidad findById(int id) throws SQLException {
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM areaContabilidad WHERE id_areaContabilidad = ?")) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return mapRow(rs);
        }
        return null;
    }

    public void insert(AreaContabilidad a) throws SQLException {
        String sql = "INSERT INTO areaContabilidad (id_servicios, Tipo_pago, Meses, Hito_firma, H1, H2, H3, H4, H5, H6, Hito_cierre) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, a.getIdServicios()); 
            ps.setString(2, a.getTipoPago());
            ps.setInt(3, a.getMeses()); 
            ps.setInt(4, a.getHitoFirma());
            ps.setInt(5, a.getH1()); 
            ps.setInt(6, a.getH2()); 
            ps.setInt(7, a.getH3());
            ps.setInt(8, a.getH4()); 
            ps.setInt(9, a.getH5()); 
            ps.setInt(10, a.getH6());
            ps.setInt(11, a.getHitoCierre());
            ps.executeUpdate();
        }
    }

    public void update(int id, AreaContabilidad a) throws SQLException {
        String sql = "UPDATE areaContabilidad SET id_servicios=?, Tipo_pago=?, Meses=?, Hito_firma=?, H1=?, H2=?, H3=?, H4=?, H5=?, H6=?, Hito_cierre=? WHERE id_areaContabilidad=?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, a.getIdServicios()); 
            ps.setString(2, a.getTipoPago());
            ps.setInt(3, a.getMeses()); 
            ps.setInt(4, a.getHitoFirma());
            ps.setInt(5, a.getH1()); 
            ps.setInt(6, a.getH2()); 
            ps.setInt(7, a.getH3());
            ps.setInt(8, a.getH4()); 
            ps.setInt(9, a.getH5()); 
            ps.setInt(10, a.getH6());
            ps.setInt(11, a.getHitoCierre()); 
            ps.setInt(12, id);
            ps.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement("DELETE FROM areaContabilidad WHERE id_areaContabilidad=?")) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    } 
}
