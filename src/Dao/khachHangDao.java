/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Helper.jdbcHelper;
import Model.khachHang;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author NGUYEN TRI TUE
 */
public class khachHangDao extends cuaHangDao<khachHang, String>{
    String INSERT_SQL = "INSERT INTO KHACHHANG (MAKH, TENKH, DIACHI, SDT, CMND) VALUES (?,?,?,?,?)";
    String UPDATE_SQL = "UPDATE KHACHHANG SET TENKH = ?, DIACHI = ?, SDT = ?, CMND = ? where MAKH = ?";
    String DELETE_SQL = "DELETE FROM KHACHHANG WHERE MAKH = ?";
    String SELECT_ALL_SQL = "SELECT * FROM KHACHHANG";
    String SELECT_BY_ID_SQL = "SELECT * FROM KHACHHANG WHERE MAKH = ?";

    @Override
    public void insert(khachHang entity) {
        jdbcHelper.executeUpdate(INSERT_SQL, entity.getMaKhachHang(), entity.getTenKhachHang(), entity.getDiaChi(), entity.getSdt(),entity.getCmnd());
    }

    @Override
    public void update(khachHang entity) {
        jdbcHelper.executeUpdate(UPDATE_SQL, entity.getTenKhachHang(), entity.getDiaChi(), entity.getSdt(), entity.getCmnd(),entity.getMaKhachHang());
    }

    @Override
    public void delete(String maKH) {
        jdbcHelper.executeUpdate(DELETE_SQL, maKH);

    }

    @Override
    public List<khachHang> selectAll() {
        return selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public khachHang selectById(String maKH) {
        List<khachHang> list = this.selectBySql(SELECT_BY_ID_SQL, maKH);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    protected List<khachHang> selectBySql(String sql, Object... args) {
        List<khachHang> list = new ArrayList<khachHang>();
        try {
            ResultSet rs = jdbcHelper.executeQuery(sql, args);
            while (rs.next()) {
                khachHang entity = new khachHang();
                entity.setMaKhachHang(rs.getString("MAKH"));
                entity.setTenKhachHang(rs.getString("TENKH"));
                entity.setDiaChi(rs.getString("DIACHI"));
                entity.setSdt(rs.getString("SDT"));
                entity.setCmnd(rs.getString("CMND"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public List<khachHang> selectByKeyWord(String keyword) {
        String sql = "SELECT * FROM KHACHHANG WHERE TENKH LIKE ?";
        return this.selectBySql(sql, "%" +keyword + "%");
    }

    @Override
    public void delete1(String Key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
