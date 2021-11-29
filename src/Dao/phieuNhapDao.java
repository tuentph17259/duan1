/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Helper.jdbcHelper;
import Model.phieuNhap;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author NGUYEN TRI TUE
 */
public class phieuNhapDao extends cuaHangDao<phieuNhap, String>{
    
    String INSERT_SQL = "insert into PHIEUNHAP (MAPN,MANV,MANCC,NGAYNHAP,TONGTIEN) values (?,?,?,?,?)";
    String UPDATE_SQL = "UPDATE PHIEUNHAP SET MANV=?,MANCC=?,NGAYNHAP=?,TONGTIEN=? where MAPN=?";
    String DELETE_SQL = "DELETE FROM PHIEUNHAP where MAPN=?";
    String SELECT_ALL_SQL = "SELECT * FROM PHIEUNHAP";
    String SELECT_BY_ID_SQL = "SELECT * FROM PHIEUNHAP WHERE MAPN = ?";

    @Override
    public void insert(phieuNhap entity) {
        jdbcHelper.executeUpdate(INSERT_SQL, entity.getMaPhieuNhap(), entity.getMaNhanVien(), entity.getMaNCC(), entity.getNgayNhap(), entity.getTongTien());
    
    }

    @Override
    public void update(phieuNhap entity) {
        jdbcHelper.executeUpdate(INSERT_SQL, entity.getMaNhanVien(), entity.getMaNCC(), entity.getNgayNhap(), entity.getTongTien(), entity.getMaPhieuNhap());
    }

    @Override
    public void delete(String maPN) {
        jdbcHelper.executeUpdate(DELETE_SQL, maPN);
    }

    @Override
    public void delete1(String Key) {
        
    }

    @Override
    public List<phieuNhap> selectAll() {
        return selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public phieuNhap selectById(String maPN) {
        List<phieuNhap> list = this.selectBySql(SELECT_BY_ID_SQL, maPN);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    protected List<phieuNhap> selectBySql(String sql, Object... args) {
        List<phieuNhap> list = new ArrayList<phieuNhap>();
        try {
            ResultSet rs = jdbcHelper.executeQuery(sql, args);
            while (rs.next()) {
                phieuNhap entity = new phieuNhap();
                entity.setMaPhieuNhap(rs.getString("MAPN"));
                entity.setMaNhanVien(rs.getString("MANV"));
                entity.setMaNCC(rs.getString("MANCC"));
                entity.setNgayNhap(rs.getDate("NGAYNHAP"));
                entity.setTongTien(rs.getString("TONGTIEN"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
