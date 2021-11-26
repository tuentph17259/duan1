/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Helper.jdbcHelper;
import Model.nhaCungCap;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author NGUYEN TRI TUE
 */
public class nhaCCDao extends cuaHangDao<nhaCungCap, String> {

    String INSERT_SQL = "INSERT INTO NHACUNGCAP (MANCC, TENNCC, DIACHI, SDT,TRANGTHAI) VALUES (?,?,?,?,?)";
    String UPDATE_SQL = "UPDATE NHACUNGCAP SET TENNCC = ?, DIACHI = ?, SDT = ?,TRANGTHAI=? where MANCC = ?";
    String DELETE_SQL = "UPDATE NHACUNGCAP SET TRANGTHAI = 0 WHERE MANCC=?";
    String DELETE_SQL2 = "DELETE FROM NHACUNGCAP WHERE MANCC=?";
    String SELECT_ALL_SQL = "SELECT * FROM NHACUNGCAP";
    String SELECT_BY_ID_SQL = "SELECT * FROM NHACUNGCAP WHERE MANCC = ?";

    @Override
    public void insert(nhaCungCap entity) {
        jdbcHelper.executeUpdate(INSERT_SQL, entity.getMaNCC(), entity.getTenNCC(), entity.getDiaChi(), entity.getSDT(), entity.isTrangThai());
    }

    @Override
    public void update(nhaCungCap entity) {
        jdbcHelper.executeUpdate(UPDATE_SQL, entity.getTenNCC(), entity.getDiaChi(), entity.getSDT(), entity.getMaNCC(), entity.isTrangThai());
    }
    
    @Override
    public void delete(String maCC) {
//        jdbcHelper.executeUpdate(DELETE_SQL, maCC);
//        String sql = "UPDATE NHACUNGCAP SET TRANGTHAI = 0 WHERE MANCC=?";
//        try {
//            PreparedStatement ps = jdbcHelper.executeUpdate(sql);
//            ps.setString(1, maCC);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        jdbcHelper.executeUpdate(DELETE_SQL, maCC);
    }

    @Override
    public List<nhaCungCap> selectAll() {
        return selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public nhaCungCap selectById(String maCC) {
        List<nhaCungCap> list = this.selectBySql(SELECT_BY_ID_SQL, maCC);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    protected List<nhaCungCap> selectBySql(String sql, Object... args) {
        List<nhaCungCap> list = new ArrayList<nhaCungCap>();
        try {
            ResultSet rs = jdbcHelper.executeQuery(sql, args);
            while (rs.next()) {
                nhaCungCap entity = new nhaCungCap();
                entity.setMaNCC(rs.getString("MANCC"));
                entity.setTenNCC(rs.getString("TENNCC"));
                entity.setDiaChi(rs.getString("DIACHI"));
                entity.setSDT(rs.getString("SDT"));
                entity.setTrangThai(rs.getBoolean("TRANGTHAI"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<nhaCungCap> getNhaCungCapRecycle() {
        List<nhaCungCap> list = new ArrayList<>();
        String sql = "SELECT * FROM NHACUNGCAP WHERE TRANGTHAI = 0";
        try {
            ResultSet rs = jdbcHelper.executeQuery(sql);
            while (rs.next()) {
                nhaCungCap entity = new nhaCungCap();
                entity.setMaNCC(rs.getString("MANCC"));
                entity.setTenNCC(rs.getString("TENNCC"));
                entity.setDiaChi(rs.getString("DIACHI"));
                entity.setSDT(rs.getString("SDT"));
                entity.setTrangThai(rs.getBoolean("TRANGTHAI"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean install(String maCC) {
        String sql = "UPDATE NHACUNGCAP SET TRANGTHAI = 1 WHERE MANCC=?";
        try {
            PreparedStatement ps = (PreparedStatement) jdbcHelper.executeQuery(sql, maCC);
            ps.setString(1, maCC);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
