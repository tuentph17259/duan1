/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Helper.jdbcHelper;
import Model.nhaCungCap;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author NGUYEN TRI TUE
 */
public class nhaCCDao extends cuaHangDao<nhaCungCap, String> {

    String INSERT_SQL = "INSERT INTO NHACUNGCAP (MANCC, TENNCC, DIACHI, SDT) VALUES (?,?,?,?)";
    String UPDATE_SQL = "UPDATE NHACUNGCAP SET TENNCC = ?, DIACHI = ?, SDT = ? where MANCC = ?";
    String DELETE_SQL = "UPDATE NHACUNGCAP SET TRANGTHAI =0 WHERE MaNCC = ?";
    String DELETE_SQL1 = "UPDATE NHACUNGCAP SET TRANGTHAI =1 WHERE MaNCC = ?";
    String SELECT_ALL_SQL = "SELECT * FROM NHACUNGCAP";
    String SELECT_BY_ID_SQL = "SELECT * FROM NHACUNGCAP WHERE MANCC = ?";

    @Override
    public void insert(nhaCungCap entity) {
        jdbcHelper.executeUpdate(INSERT_SQL, entity.getMaNCC(), entity.getTenNCC(), entity.getDiaChi(), entity.getSDT());
    }

    @Override
    public void update(nhaCungCap entity) {
        jdbcHelper.executeUpdate(UPDATE_SQL, entity.getTenNCC(), entity.getDiaChi(), entity.getSDT(), entity.getMaNCC());
    }

    @Override
    public void delete(String maCC) {
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
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete1(String maCC) {
        jdbcHelper.executeUpdate(DELETE_SQL1, maCC);
    }

    public List<nhaCungCap> XoaTamThoi() {
        List<nhaCungCap> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM NHACUNGCAP WHERE TRANGTHAI= 1";
            ResultSet rs = jdbcHelper.executeQuery(sql);
            while (rs.next()) {
                nhaCungCap entity = new nhaCungCap();
                entity.setMaNCC(rs.getString("MANCC"));
                entity.setTenNCC(rs.getString("TENNCC"));
                entity.setSDT(rs.getString("SDT"));
                entity.setDiaChi(rs.getString("DIACHI"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<nhaCungCap> HienThiLai() {
        List<nhaCungCap> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM NHACUNGCAP WHERE TRANGTHAI= 0";
            ResultSet rs = jdbcHelper.executeQuery(sql);
            while (rs.next()) {
                nhaCungCap entity = new nhaCungCap();
                entity.setMaNCC(rs.getString("MANCC"));
                entity.setTenNCC(rs.getString("TENNCC"));
                entity.setSDT(rs.getString("SDT"));
                entity.setDiaChi(rs.getString("DIACHI"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
