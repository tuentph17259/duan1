/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Dao.cuaHangDao;
import Helper.jdbcHelper;
import Model.loaiSanPham;
import Model.nhanVien;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class loaiSanPhamDAO extends cuaHangDao<loaiSanPham, String> {

    String INSERT_SQL = "INSERT INTO LOAISANPHAM (MALOAISP,TENLOAISP) VALUES (?,?)";
    String UPDATE_SQL = "UPDATE LOAISANPHAM SET TENLOAISP = ? WHERE MALOAISP = ?";
    String DELETE_SQL = "DELETE FROM LOAISANPHAM WHERE MALOAISP = ?";
    String SELECT_ALL_SQL = "SELECT * FROM LOAISANPHAM";
    String SELECT_BY_ID_SQL = "SELECT * FROM LOAISANPHAM WHERE MALOAISP = ?";

    @Override
    public void insert(loaiSanPham entity) {
        jdbcHelper.executeUpdate(INSERT_SQL, entity.getMaLoaiSP(), entity.getTenLoaiSP());
    }

    @Override
    public void update(loaiSanPham entity) {
        jdbcHelper.executeUpdate(UPDATE_SQL, entity.getTenLoaiSP(),entity.getMaLoaiSP());

    }

    @Override
    public void delete(String maLoaiSP) {
        jdbcHelper.executeUpdate(DELETE_SQL, maLoaiSP);

    }

    @Override
    public List<loaiSanPham> selectAll() {
        return selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public loaiSanPham selectById(String maLoaiSP) {
        List<loaiSanPham> list = this.selectBySql(SELECT_BY_ID_SQL, maLoaiSP);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    protected List<loaiSanPham> selectBySql(String sql, Object... args) {
        List<loaiSanPham> list = new ArrayList<loaiSanPham>();
        try {
            ResultSet rs = jdbcHelper.executeQuery(sql, args);
            while (rs.next()) {
                loaiSanPham entity = new loaiSanPham();
                entity.setMaLoaiSP(rs.getString("MALOAISP"));
                entity.setTenLoaiSP(rs.getString("TENLOAISP"));
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
