/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Dao.cuaHangDao;
import Helper.jdbcHelper;
import Model.User;
import Model.nhanVien;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class nhanVienDAO extends cuaHangDao<nhanVien, String> {

    String INSERT_SQL = "INSERT INTO NHANVIEN (MANV, TENNV, GIOITINH, QUEQUAN, NGAYSINH, SDT) VALUES (?,?,?,?,?,?)";
    String UPDATE_SQL = "UPDATE NHANVIEN SET TENNV = ?, GIOITINH = ?, QUEQUAN = ?, NGAYSINH = ?, SDT = ? WHERE MaNV = ?";
    String DELETE_SQL = "UPDATE NHANVIEN SET TRANGTHAI =0 WHERE MaNV = ?";
    String DELETE_SQL1 = "UPDATE NHANVIEN SET TRANGTHAI =1 WHERE MaNV = ?";
    String SELECT_ALL_SQL = "SELECT * FROM NHANVIEN";
    String SELECT_BY_ID_SQL = "SELECT * FROM NHANVIEN WHERE MANV = ?";

    @Override
    public void insert(nhanVien entity) {
        jdbcHelper.executeUpdate(INSERT_SQL, entity.getMaNV(), entity.getTenNV(), entity.isGioiTinh(), entity.getQueQuan(), entity.getNgaySinh(), entity.getSDT());
    }

    @Override
    public void update(nhanVien entity) {
        jdbcHelper.executeUpdate(UPDATE_SQL, entity.getTenNV(), entity.isGioiTinh(), entity.getQueQuan(), entity.getNgaySinh(), entity.getSDT(), entity.getMaNV());
    }

    @Override
    public void delete(String maNV) {
        jdbcHelper.executeUpdate(DELETE_SQL, maNV);

    }

    @Override
    public List<nhanVien> selectAll() {
        return selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public nhanVien selectById(String maNV) {
        List<nhanVien> list = this.selectBySql(SELECT_BY_ID_SQL, maNV);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    protected List<nhanVien> selectBySql(String sql, Object... args) {
        List<nhanVien> list = new ArrayList<nhanVien>();
        try {
            ResultSet rs = jdbcHelper.executeQuery(sql, args);
            while (rs.next()) {
                nhanVien entity = new nhanVien();
                entity.setMaNV(rs.getString("MANV"));
                entity.setTenNV(rs.getString("TENNV"));
                entity.setGioiTinh(rs.getBoolean("GIOITINH"));
                entity.setQueQuan(rs.getString("QUEQUAN"));
                entity.setNgaySinh(rs.getDate("NGAYSINH"));
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
    public void delete1(String maNV) {
        jdbcHelper.executeUpdate(DELETE_SQL1, maNV);
    }

    public List<nhanVien> XoaTamThoi() {
        List<nhanVien> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM NHANVIEN WHERE TRANGTHAI= 1";
            ResultSet rs = jdbcHelper.executeQuery(sql);
            while (rs.next()) {
                nhanVien entity = new nhanVien();
                entity.setMaNV(rs.getString("MANV"));
                entity.setTenNV(rs.getString("TENNV"));
                entity.setGioiTinh(rs.getBoolean("GIOITINH"));
                entity.setQueQuan(rs.getString("QUEQUAN"));
                entity.setNgaySinh(rs.getDate("NGAYSINH"));
                entity.setSDT(rs.getString("SDT"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<nhanVien> HienThiLai() {
        List<nhanVien> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM NHANVIEN WHERE TRANGTHAI= 0";
            ResultSet rs = jdbcHelper.executeQuery(sql);
            while (rs.next()) {
                nhanVien entity = new nhanVien();
                entity.setMaNV(rs.getString("MANV"));
                entity.setTenNV(rs.getString("TENNV"));
                entity.setGioiTinh(rs.getBoolean("GIOITINH"));
                entity.setQueQuan(rs.getString("QUEQUAN"));
                entity.setNgaySinh(rs.getDate("NGAYSINH"));
                entity.setSDT(rs.getString("SDT"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
