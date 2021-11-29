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
    String INSERT_SQL ="INSERT INTO SANPHAM(MASP,TENSP,MAUSAC,GIASP,HINHANH,CAUHINHCHITIET,TRANGTHAI,MATHUONGHIEU)\n" +
"VALUES(?,?,?,?,?,?,?,?)";
    String UPDATE_SQL ="UPDATE SANPHAM SET TENSP=?,MAUSAC=?,GIASP=?,HINHANH=?,CAUHINHCHITIET=?,TRANGTHAI=?,MATHUONGHIEU=?\n" +
"WHERE MASP=?";
    String DELETE_SQL ="DELETE FROM SANPHAM WHERE MASP=?";
    String SELECT_ALL_SQL ="SELECT * FROM SANPHAM";
    String SELECT_BY_ID_SQL ="SELECT * FROM SANPHAM WHERE MASP=?";

    @Override
    public void insert(sanPham entity) {
          jdbcHelper.executeUpdate(INSERT_SQL, entity.getMaSanPham(), entity.getTenSanPham(), entity.getMauSac(), entity.getGiaSanPham(), entity.getHinhAnh(), entity.getCauHinhChiTiet(), entity.isTrangThai(), entity.getMaThuongHieu());  
    }

    @Override
    public void update(sanPham entity) {
        jdbcHelper.executeUpdate(UPDATE_SQL, entity.getTenSanPham(), entity.getMauSac(), entity.getGiaSanPham(),  entity.getHinhAnh(), entity.getCauHinhChiTiet(), entity.isTrangThai(), entity.getMaThuongHieu(),entity.getMaSanPham());
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
                entity.setHinhAnh(rs.getString("HINHANH"));
                entity.setCauHinhChiTiet(rs.getString("CAUHINHCHITIET"));
                entity.setTrangThai(rs.getBoolean("TRANGTHAI"));
                entity.setMaThuongHieu(rs.getString("MATHUONGHIEU"));
                lst.add(entity);
            }
            rs.getStatement().getConnection().close();
            return lst;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<sanPham> selectByKeyWord(String keyword) {
        String sql = "SELECT * FROM SANPHAM WHERE TENSP LIKE ?";
        return this.selectBySql(sql, "%" +keyword + "%");
    }
    @Override
    public void delete1(String Key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
