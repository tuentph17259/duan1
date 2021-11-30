/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Helper.jdbcHelper;
import Model.chiTietHoaDon;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author acer
 */
public class chiTietHoaDonDAO extends cuaHangDao<chiTietHoaDon, String>{
    String INSERT_SQL = "INSERT INTO CHITIETHOADON (MACHITIET,MAHD,SOLUONG,TONGTIEN,MASP) VALUES (?,?,?,?,?)";
    String UPDATE_SQL = "UPDATE CHITIETHOADON SET MAHD=?,SOLUONG=?,TONGTIEN=? , MASP=? where MACHITIET=?";
    String DELETE_SQL = "DELETE FROM CHITIETHOADON where MACHITIET=?";
    String SELECT_ALL_SQL = "SELECT * FROM CHITIETHOADON";
    String SELECT_BY_ID_SQL = "SELECT * FROM CHITIETHOADON WHERE MACHITIET = ?";

    @Override
    public void insert(chiTietHoaDon entity) {
        jdbcHelper.executeUpdate(INSERT_SQL, entity.getMaChiTietHoaDon(),entity.getMaHoaDon(),entity.getSoLuong(),entity.getTongTien(),entity.getMaSanPham());
    }

    @Override
    public void update(chiTietHoaDon entity) {
        jdbcHelper.executeUpdate(UPDATE_SQL, entity.getMaHoaDon(),entity.getSoLuong(),entity.getTongTien(), entity.getMaSanPham(), entity.getMaChiTietHoaDon());
    }

    @Override
    public void delete(String maCTHD) {
        jdbcHelper.executeUpdate(DELETE_SQL, maCTHD);
    }

    @Override
    public List<chiTietHoaDon> selectAll() {
        return selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public chiTietHoaDon selectById(String maCTHD) {
        List<chiTietHoaDon> list = this.selectBySql(SELECT_BY_ID_SQL, maCTHD);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    protected List<chiTietHoaDon> selectBySql(String sql, Object... args) {
     List<chiTietHoaDon> list = new ArrayList<>();
        try {
            ResultSet rs = jdbcHelper.executeQuery(sql, args);
            while (rs.next()) {
                chiTietHoaDon entity= new chiTietHoaDon();
                entity.setMaChiTietHoaDon(rs.getString("MACHITIET"));
                entity.setMaHoaDon(rs.getString("MAHD"));
                entity.setSoLuong(rs.getInt("SOLUONG"));
                
                entity.setTongTien(rs.getString("TONGTIEN"));
                entity.setMaSanPham(rs.getString("MASP"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete1(String Key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
