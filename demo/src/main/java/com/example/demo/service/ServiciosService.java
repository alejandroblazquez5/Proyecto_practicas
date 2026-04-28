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

import com.example.demo.model.Servicios;

@Service
public class ServiciosService {

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/proyecto", "root", "root");
    }

    private Servicios mapRow(ResultSet rs) throws SQLException {
        Servicios s = new Servicios();
        s.setIdServicios(rs.getInt("id_servicios"));
        s.setIdSabana(rs.getInt("id_sabana"));
        s.setConcepto(rs.getString("Concepto"));
        s.setComentario(rs.getString("Comentario"));
        s.setTipo(rs.getString("Tipo"));
        s.setAgrupacionTopes(rs.getString("Agrupacion_topes"));
        s.setHoras(rs.getBigDecimal("Horas"));
        s.setCostesH(rs.getBigDecimal("Costes_h"));
        s.setMult(rs.getBigDecimal("Mult"));
        s.setCoste(rs.getBigDecimal("Coste"));
        s.setTopeLicitacion(rs.getBigDecimal("Tope_licitacion"));
        s.setMargen(rs.getBigDecimal("Margen"));
        s.setDes(rs.getBigDecimal("Des"));
        s.setPvp(rs.getBigDecimal("PVP"));
        s.setCI(rs.getInt("cI"));
        s.setC1(rs.getInt("c1"));
        s.setC2(rs.getInt("c2"));
        s.setC3(rs.getInt("c3"));
        s.setC4(rs.getInt("c4"));
        s.setC5(rs.getInt("c5"));
        s.setC6(rs.getInt("c6"));
        s.setII(rs.getInt("iI"));
        s.setI1(rs.getInt("i1"));
        s.setI2(rs.getInt("i2"));
        s.setI3(rs.getInt("i3"));
        s.setI4(rs.getInt("i4"));
        s.setI5(rs.getInt("i5"));
        s.setI6(rs.getInt("i6"));
        return s;
    }

    public List<Servicios> findAll() throws SQLException {
        List<Servicios> list = new ArrayList<>();
        try (Connection conn = getConnection(); Statement st = conn.createStatement(); ResultSet rs = st.executeQuery("SELECT * FROM servicios")) {
            while (rs.next()) {
                list.add(mapRow(rs));
            }
        }
        return list;
    }

    public Servicios findById(int id) throws SQLException {
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement("SELECT * FROM servicios WHERE id_servicios = ?")) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return mapRow(rs);
            }
        }
        return null;
    }

    public int insert(Servicios s) throws SQLException {
        String sql = "INSERT INTO servicios (id_sabana, Concepto, Comentario, Tipo, Agrupacion_topes, Horas, Costes_h, Mult, Coste, Tope_licitacion, Margen, Des, PVP, cI, c1, c2, c3, c4, c5, c6, iI, i1, i2, i3, i4, i5, i6) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, s.getIdSabana());
            ps.setString(2, s.getConcepto());
            ps.setString(3, s.getComentario());
            ps.setString(4, s.getTipo());
            ps.setString(5, s.getAgrupacionTopes());
            ps.setBigDecimal(6, s.getHoras());
            ps.setBigDecimal(7, s.getCostesH());
            ps.setBigDecimal(8, s.getMult());
            ps.setBigDecimal(9, s.getCoste());
            ps.setBigDecimal(10, s.getTopeLicitacion());
            ps.setBigDecimal(11, s.getMargen());
            ps.setBigDecimal(12, s.getDes());
            ps.setBigDecimal(13, s.getPvp());
            ps.setInt(14, s.getCI());
            ps.setInt(15, s.getC1());
            ps.setInt(16, s.getC2());
            ps.setInt(17, s.getC3());
            ps.setInt(18, s.getC4());
            ps.setInt(19, s.getC5());
            ps.setInt(20, s.getC6());
            ps.setInt(21, s.getII());
            ps.setInt(22, s.getI1());
            ps.setInt(23, s.getI2());
            ps.setInt(24, s.getI3());
            ps.setInt(25, s.getI4());
            ps.setInt(26, s.getI5());
            ps.setInt(27, s.getI6());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1);
            }
        }
        return -1;
    }

    public void update(int id, Servicios s) throws SQLException {
        String sql = "UPDATE servicios SET id_sabana=?, Concepto=?, Comentario=?, Tipo=?, Agrupacion_topes=?, Horas=?, Costes_h=?, Mult=?, Coste=?, Tope_licitacion=?, Margen=?, Des=?, PVP=?, cI=?, c1=?, c2=?, c3=?, c4=?, c5=?, c6=?, iI=?, i1=?, i2=?, i3=?, i4=?, i5=?, i6=? WHERE id_servicios=?";
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, s.getIdSabana());
            ps.setString(2, s.getConcepto());
            ps.setString(3, s.getComentario());
            ps.setString(4, s.getTipo());
            ps.setString(5, s.getAgrupacionTopes());
            ps.setBigDecimal(6, s.getHoras());
            ps.setBigDecimal(7, s.getCostesH());
            ps.setBigDecimal(8, s.getMult());
            ps.setBigDecimal(9, s.getCoste());
            ps.setBigDecimal(10, s.getTopeLicitacion());
            ps.setBigDecimal(11, s.getMargen());
            ps.setBigDecimal(12, s.getDes());
            ps.setBigDecimal(13, s.getPvp());
            ps.setInt(14, s.getCI());
            ps.setInt(15, s.getC1());
            ps.setInt(16, s.getC2());
            ps.setInt(17, s.getC3());
            ps.setInt(18, s.getC4());
            ps.setInt(19, s.getC5());
            ps.setInt(20, s.getC6());
            ps.setInt(21, s.getII());
            ps.setInt(22, s.getI1());
            ps.setInt(23, s.getI2());
            ps.setInt(24, s.getI3());
            ps.setInt(25, s.getI4());
            ps.setInt(26, s.getI5());
            ps.setInt(27, s.getI6());
            ps.setInt(28, id);
            ps.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement("DELETE FROM servicios WHERE id_servicios=?")) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}
