/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Helper.jdbcHelper;
import Model.hoaDon;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author acer
 */
public class hoaDonDAO extends cuaHangDao<hoaDon, String>{

   String INSERT_SQL = "insert into HOADON (MAHD,MAKH,MANV,NGAYLAPHOADON,TONGTIEN) values (?,?,?,?,?)";
    String UPDATE_SQL = "UPDATE HOADON SET MAKH=?,MANV=?,NGAYLAPHOADON=?,TONGTIEN=? where MAHD=?";
    String DELETE_SQL = "DELETE FROM HOADON where MAHD=?";
    String SELECT_ALL_SQL = "SELECT * FROM HOADON";
    String SELECT_BY_ID_SQL = "SELECT * FROM HOADON WHERE MAHD = ?";

    @Override
    public void insert(hoaDon entity) {
        jdbcHelper.executeUpdate(INSERT_SQL, entity.getMaHoaDon(),entity.getMaKhachHang(),entity.getMaNhanVien(),entity.getNgayLapHoaDon(),entity.getTongTien());
    }

    @Override
    public void update(hoaDon entity) {
        jdbcHelper.executeUpdate(UPDATE_SQL, entity.getMaKhachHang(),entity.getMaNhanVien(),entity.getNgayLapHoaDon(),entity.getTongTien(),entity.getMaHoaDon());
    }

    @Override
    public void delete(String maHD) {
        jdbcHelper.executeUpdate(DELETE_SQL, maHD);
    }

    @Override
    public List<hoaDon> selectAll() {
        return selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public hoaDon selectById(String maHD) {
        List<hoaDon> list = this.selectBySql(SELECT_BY_ID_SQL, maHD);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    protected List<hoaDon> selectBySql(String sql, Object... args) {
        List<hoaDon> list = new ArrayList<hoaDon>();
        try {
            ResultSet rs = jdbcHelper.executeQuery(sql, args);
            while (rs.next()) {
                hoaDon entity= new hoaDon();
                entity.setMaHoaDon(rs.getString("MAHD"));
                entity.setMaKhachHang(rs.getString("MAKH"));
                entity.setMaNhanVien(rs.getString("MANV"));
                entity.setNgayLapHoaDon(rs.getDate("NGAYLAPHOADON"));
                entity.setTongTien(rs.getString("TONGTIEN"));
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
