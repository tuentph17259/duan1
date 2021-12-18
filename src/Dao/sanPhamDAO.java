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
public class sanPhamDAO extends cuaHangDao<sanPham, String> {

    String INSERT_SQL = "INSERT INTO SANPHAM(MASP,TENSP,MAUSAC,TRANGTHAI,GIASP,MATHUONGHIEU,RAM,CAMERA,KICHTHUOC,BONHOTRONG,DOPHANGIAI,HEDIEUHANH,MOTA,HINHANH)\n"
            + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    String UPDATE_SQL = "UPDATE SANPHAM SET TENSP = ? , MAUSAC = ? , TRANGTHAI = ? , GIASP = ?, MATHUONGHIEU = ?, RAM = ?, CAMERA = ?, KICHTHUOC = ?, BONHOTRONG = ?, DOPHANGIAI = ?, HEDIEUHANH = ?, MOTA = ?, HINHANH = ? WHERE MASP=?";
    String DELETE_SQL = "UPDATE SANPHAM SET TT =0 WHERE MaSP = ?";
    String DELETE_SQL1 = "UPDATE SANPHAM SET TT =1 WHERE MaSP = ?";
    String SELECT_ALL_SQL = "SELECT * FROM SANPHAM";
    String SELECT_BY_ID_SQL = "SELECT * FROM SANPHAM WHERE MASP=?";
    

    @Override
    public void insert(sanPham entity) {
        jdbcHelper.executeUpdate(INSERT_SQL, entity.getMaSanPham(), entity.getTenSanPham(), entity.getMauSac(),entity.isTrangThai(), entity.getGiaSanPham(), entity.getMaThuongHieu(),entity.getRam(),entity.getCamera(),entity.getScreenSize(),entity.getRom(),entity.getPixel(),entity.getOs(),entity.getMoTa(),entity.getHinhAnh());
    }

    @Override
    public void update(sanPham entity) {
        jdbcHelper.executeUpdate(UPDATE_SQL, entity.getTenSanPham(), entity.getMauSac(),entity.isTrangThai(), entity.getGiaSanPham(), entity.getMaThuongHieu(),entity.getRam(),entity.getCamera(),entity.getScreenSize(),entity.getRom(),entity.getPixel(),entity.getOs(),entity.getMoTa(),entity.getHinhAnh(), entity.getMaSanPham());
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
            while (rs.next()) {
                sanPham entity = new sanPham();
                entity.setMaSanPham(rs.getString("MASP"));
                entity.setTenSanPham(rs.getString("TENSP"));
                entity.setMauSac(rs.getString("MAUSAC"));
                entity.setGiaSanPham(rs.getDouble("GIASP"));
                entity.setTrangThai(rs.getBoolean("TRANGTHAI"));
                entity.setMaThuongHieu(rs.getString("MATHUONGHIEU"));
                entity.setRam(rs.getString("RAM"));
                entity.setCamera(rs.getString("CAMERA"));
                entity.setScreenSize(rs.getString("KICHTHUOC"));
                entity.setRom(rs.getString("BONHOTRONG"));
                entity.setPixel(rs.getString("DOPHANGIAI"));
                entity.setOs(rs.getString("HEDIEUHANH"));
                entity.setMoTa(rs.getString("MOTA"));
                entity.setHinhAnh(rs.getString("HINHANH"));
                lst.add(entity);
            }
            rs.getStatement().getConnection().close();  
            return lst;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<sanPham> selectByKeyWord(String keyword) {
        String sql = "SELECT * FROM SANPHAM WHERE TENSP LIKE ? AND TT=1";
        return this.selectBySql(sql, "%" + keyword + "%");
    }

    @Override
    public void delete1(String maSP) {
         jdbcHelper.executeUpdate(DELETE_SQL1, maSP);
    }
    
    public List<sanPham> XoaTamThoi() {
        List<sanPham> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM SANPHAM WHERE TT= 1";
            ResultSet rs = jdbcHelper.executeQuery(sql);
            while (rs.next()) {
                sanPham entity = new sanPham();
                entity.setMaSanPham(rs.getString("MASP"));
                entity.setTenSanPham(rs.getString("TENSP"));
                entity.setMauSac(rs.getString("MAUSAC"));
                entity.setGiaSanPham(rs.getDouble("GIASP"));
                entity.setTrangThai(rs.getBoolean("TRANGTHAI"));
                entity.setMaThuongHieu(rs.getString("MATHUONGHIEU"));
                entity.setRam(rs.getString("RAM"));
                entity.setCamera(rs.getString("CAMERA"));
                entity.setScreenSize(rs.getString("KICHTHUOC"));
                entity.setRom(rs.getString("BONHOTRONG"));
                entity.setPixel(rs.getString("DOPHANGIAI"));
                entity.setOs(rs.getString("HEDIEUHANH"));
                entity.setMoTa(rs.getString("MOTA"));
                entity.setHinhAnh(rs.getString("HINHANH"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<sanPham> HienThiLai() {
        List<sanPham> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM SANPHAM WHERE TT= 0";
            ResultSet rs = jdbcHelper.executeQuery(sql);
            while (rs.next()) {
                sanPham entity = new sanPham();
                entity.setMaSanPham(rs.getString("MASP"));
                entity.setTenSanPham(rs.getString("TENSP"));
                entity.setMauSac(rs.getString("MAUSAC"));
                entity.setGiaSanPham(rs.getDouble("GIASP"));
                entity.setTrangThai(rs.getBoolean("TRANGTHAI"));
                entity.setMaThuongHieu(rs.getString("MATHUONGHIEU"));
                entity.setRam(rs.getString("RAM"));
                entity.setCamera(rs.getString("CAMERA"));
                entity.setScreenSize(rs.getString("KICHTHUOC"));
                entity.setRom(rs.getString("BONHOTRONG"));
                entity.setPixel(rs.getString("DOPHANGIAI"));
                entity.setOs(rs.getString("HEDIEUHANH"));
                entity.setMoTa(rs.getString("MOTA"));
                entity.setHinhAnh(rs.getString("HINHANH"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<sanPham> SortNameASC() {
        List<sanPham> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM SANPHAM ORDER BY TENSP ASC";
            ResultSet rs = jdbcHelper.executeQuery(sql);
            while (rs.next()) {
                sanPham entity = new sanPham();
                entity.setMaSanPham(rs.getString("MASP"));
                entity.setTenSanPham(rs.getString("TENSP"));
                entity.setMauSac(rs.getString("MAUSAC"));
                entity.setGiaSanPham(rs.getDouble("GIASP"));
                entity.setTrangThai(rs.getBoolean("TRANGTHAI"));
                entity.setMaThuongHieu(rs.getString("MATHUONGHIEU"));
                entity.setRam(rs.getString("RAM"));
                entity.setCamera(rs.getString("CAMERA"));
                entity.setScreenSize(rs.getString("KICHTHUOC"));
                entity.setRom(rs.getString("BONHOTRONG"));
                entity.setPixel(rs.getString("DOPHANGIAI"));
                entity.setOs(rs.getString("HEDIEUHANH"));
                entity.setMoTa(rs.getString("MOTA"));
                entity.setHinhAnh(rs.getString("HINHANH"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<sanPham> SortNameDESC() {
        List<sanPham> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM SANPHAM ORDER BY TENSP DESC";
            ResultSet rs = jdbcHelper.executeQuery(sql);
            while (rs.next()) {
                sanPham entity = new sanPham();
                entity.setMaSanPham(rs.getString("MASP"));
                entity.setTenSanPham(rs.getString("TENSP"));
                entity.setMauSac(rs.getString("MAUSAC"));
                entity.setGiaSanPham(rs.getDouble("GIASP"));
                entity.setTrangThai(rs.getBoolean("TRANGTHAI"));
                entity.setMaThuongHieu(rs.getString("MATHUONGHIEU"));
                entity.setRam(rs.getString("RAM"));
                entity.setCamera(rs.getString("CAMERA"));
                entity.setScreenSize(rs.getString("KICHTHUOC"));
                entity.setRom(rs.getString("BONHOTRONG"));
                entity.setPixel(rs.getString("DOPHANGIAI"));
                entity.setOs(rs.getString("HEDIEUHANH"));
                entity.setMoTa(rs.getString("MOTA"));
                entity.setHinhAnh(rs.getString("HINHANH"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<sanPham> SortPriceASC() {
        List<sanPham> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM SANPHAM ORDER BY GIASP ASC";
            ResultSet rs = jdbcHelper.executeQuery(sql);
            while (rs.next()) {
                sanPham entity = new sanPham();
                entity.setMaSanPham(rs.getString("MASP"));
                entity.setTenSanPham(rs.getString("TENSP"));
                entity.setMauSac(rs.getString("MAUSAC"));
                entity.setGiaSanPham(rs.getDouble("GIASP"));
                entity.setTrangThai(rs.getBoolean("TRANGTHAI"));
                entity.setMaThuongHieu(rs.getString("MATHUONGHIEU"));
                entity.setRam(rs.getString("RAM"));
                entity.setCamera(rs.getString("CAMERA"));
                entity.setScreenSize(rs.getString("KICHTHUOC"));
                entity.setRom(rs.getString("BONHOTRONG"));
                entity.setPixel(rs.getString("DOPHANGIAI"));
                entity.setOs(rs.getString("HEDIEUHANH"));
                entity.setMoTa(rs.getString("MOTA"));
                entity.setHinhAnh(rs.getString("HINHANH"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<sanPham> SortPriceDECS() {
        List<sanPham> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM SANPHAM ORDER BY GIASP DESC";
            ResultSet rs = jdbcHelper.executeQuery(sql);
            while (rs.next()) {
                sanPham entity = new sanPham();
                entity.setMaSanPham(rs.getString("MASP"));
                entity.setTenSanPham(rs.getString("TENSP"));
                entity.setMauSac(rs.getString("MAUSAC"));
                entity.setGiaSanPham(rs.getDouble("GIASP"));
                entity.setTrangThai(rs.getBoolean("TRANGTHAI"));
                entity.setMaThuongHieu(rs.getString("MATHUONGHIEU"));
                entity.setRam(rs.getString("RAM"));
                entity.setCamera(rs.getString("CAMERA"));
                entity.setScreenSize(rs.getString("KICHTHUOC"));
                entity.setRom(rs.getString("BONHOTRONG"));
                entity.setPixel(rs.getString("DOPHANGIAI"));
                entity.setOs(rs.getString("HEDIEUHANH"));
                entity.setMoTa(rs.getString("MOTA"));
                entity.setHinhAnh(rs.getString("HINHANH"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
