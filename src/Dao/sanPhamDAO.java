/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Helper.jdbcHelper;
import Model.sanPham;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class sanPhamDAO extends cuaHangDao<sanPham, String>{
    String INSERT_SQL ="INSERT INTO SANPHAM(MASP,TENSP,MAUSAC,GIASP,THUONGHIEU,HINHANH,CAUHINHCHITIET,TRANGTHAI,MANCC,MALOAISP)\n" +
"VALUES(?,?,?,?,?,?,?,?,?,?)";
    String UPDATE_SQL ="UPDATE SANPHAM SET TENSP=?,MAUSAC=?,GIASP=?,THUONGHIEU=?,HINHANH=?,CAUHINHCHITIET=?,TRANGTHAI=?,MANCC=?,MALOAISP=?\n" +
"WHERE MASP=?";
    String DELETE_SQL ="DELETE FROM SANPHAM WHERE MASP=?";
    String SELECT_ALL_SQL ="SELECT * FROM SANPHAM";
    String SELECT_BY_ID_SQL ="SELECT * FROM SANPHAM WHERE MASP=?";

    @Override
    public void insert(sanPham entity) {
          jdbcHelper.executeUpdate(INSERT_SQL, entity.getMaSanPham(), entity.getTenSanPham(), entity.getMauSac(), entity.getGiaSanPham(), entity.getThuongHieu(), entity.getHinhAnh(), entity.getCauHinhChiTiet(), entity.getTrangThai(), entity.getMaNhaCungCap(), entity.getMaLoaiSP());  
    }

    @Override
    public void update(sanPham entity) {
        jdbcHelper.executeUpdate(UPDATE_SQL, entity.getTenSanPham(), entity.getMauSac(), entity.getGiaSanPham(), entity.getThuongHieu(), entity.getHinhAnh(), entity.getCauHinhChiTiet(), entity.getTrangThai(), entity.getMaNhaCungCap(), entity.getMaLoaiSP(),entity.getMaSanPham());
    }

    @Override
    public void delete(String id) {
        jdbcHelper.executeUpdate(DELETE_SQL, id);
    }

    @Override
    public List<sanPham> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public sanPham selectById(String id) {
        List<sanPham> lst = this.selectBySql(SELECT_BY_ID_SQL, id);
        if (lst.isEmpty()) {
            return null;
        }
        return lst.get(0);
    }

    @Override
    protected List<sanPham> selectBySql(String sql, Object... args) {
        List<sanPham> lst = new ArrayList<>();
        try {
            ResultSet rs = jdbcHelper.executeQuery(sql, args);
            while(rs.next()){
                sanPham entity = new sanPham();
                entity.setMaSanPham(rs.getString("MASP"));
                entity.setTenSanPham(rs.getString("TENSP"));
                entity.setMauSac(rs.getString("MAUSAC"));
                entity.setGiaSanPham(rs.getDouble("GIASP"));
                entity.setThuongHieu(rs.getString("THUONGHIEU"));
                entity.setHinhAnh(rs.getString("HINHANH"));
                entity.setCauHinhChiTiet(rs.getString("CAUHINHCHITIET"));
                entity.setTrangThai(rs.getString("TRANGTHAI"));
                entity.setMaNhaCungCap(rs.getString("MANCC"));
                entity.setMaLoaiSP(rs.getString("MALOAISP"));
            }
            rs.getStatement().getConnection().close();
            return lst;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    
    

    
}
