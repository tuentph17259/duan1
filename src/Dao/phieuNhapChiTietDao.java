/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Helper.jdbcHelper;
import Model.phieuNhapChiTiet;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author NGUYEN TRI TUE
 */
public class phieuNhapChiTietDao extends cuaHangDao<phieuNhapChiTiet, String> {

    String INSERT_SQL = "INSERT INTO CHITIETPHIEUNHAP (MACTPN,MAPN,SOLUONG,DONGIA,TONGTIEN,MASP) VALUES (?,?,?,?,?,?)";
    String UPDATE_SQL = "UPDATE CHITIETPHIEUNHAP SET MAPN=?,SOLUONG=?,DONGIA=?,TONGTIEN=? , MASP=? where MACTPN=?";
    String DELETE_SQL = "DELETE FROM CHITIETPHIEUNHAP where MACTPN=?";
    String SELECT_ALL_SQL = "SELECT * FROM CHITIETPHIEUNHAP";
    String SELECT_BY_ID_SQL = "SELECT * FROM CHITIETPHIEUNHAP WHERE MACTPN = ?";

    @Override
    public void insert(phieuNhapChiTiet entity) {
        jdbcHelper.executeUpdate(INSERT_SQL, entity.getMaChiTietPhieuNhap(), entity.getMaPhieuNhap(), entity.getSoLuong(), entity.getDonGia(), entity.getTongTien(), entity.getMaSanPham());

    }

    @Override
    public void update(phieuNhapChiTiet entity) {
        jdbcHelper.executeUpdate(UPDATE_SQL, entity.getMaPhieuNhap(), entity.getSoLuong(), entity.getDonGia(), entity.getTongTien(), entity.getMaSanPham(), entity.getMaChiTietPhieuNhap());
    }

    @Override
    public void delete(String maPNCT) {
        jdbcHelper.executeUpdate(DELETE_SQL, maPNCT);
    }

    @Override
    public void delete1(String Key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<phieuNhapChiTiet> selectAll() {
        return selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public phieuNhapChiTiet selectById(String maPNCT) {
        List<phieuNhapChiTiet> list = this.selectBySql(SELECT_BY_ID_SQL, maPNCT);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    protected List<phieuNhapChiTiet> selectBySql(String sql, Object... args) {
        List<phieuNhapChiTiet> list = new ArrayList<>();
        try {
            ResultSet rs = jdbcHelper.executeQuery(sql, args);
            while (rs.next()) {
                phieuNhapChiTiet entity = new phieuNhapChiTiet();
                entity.setMaChiTietPhieuNhap(rs.getString("MACTPN"));
                entity.setMaPhieuNhap(rs.getString("MAPN"));
                entity.setSoLuong(rs.getInt("SOLUONG"));
                entity.setDonGia(rs.getString("DONGIA"));
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
}
