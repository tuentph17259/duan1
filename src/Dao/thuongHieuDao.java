/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Dao.cuaHangDao;
import Helper.jdbcHelper;
import Model.thuongHieu;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class thuongHieuDao extends cuaHangDao<Model.thuongHieu, String> {

    String INSERT_SQL = "INSERT INTO THUONGHIEU (MATHUONGHIEU,TENTHUONGHIEU) VALUES (?,?)";
    String UPDATE_SQL = "UPDATE THUONGHIEU SET TENTHUONGHIEU = ? WHERE MATHUONGHIEU = ?";
    String DELETE_SQL = "DELETE FROM THUONGHIEU WHERE MATHUONGHIEU = ?";
    String SELECT_ALL_SQL = "SELECT * FROM THUONGHIEU";
    String SELECT_BY_ID_SQL = "SELECT * FROM THUONGHIEU WHERE MATHUONGHIEU = ?";

    @Override
    public void insert(thuongHieu entity) {
        jdbcHelper.executeUpdate(INSERT_SQL, entity.getMaTH(), entity.getTenTH());
    }

    @Override
    public void update(thuongHieu entity) {
        jdbcHelper.executeUpdate(UPDATE_SQL, entity.getTenTH(),entity.getMaTH());

    }

    @Override
    public void delete(String maLoaiSP) {
        jdbcHelper.executeUpdate(DELETE_SQL, maLoaiSP);

    }

    @Override
    public List<thuongHieu> selectAll() {
        return selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public thuongHieu selectById(String maLoaiSP) {
        List<thuongHieu> list = this.selectBySql(SELECT_BY_ID_SQL, maLoaiSP);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    protected List<thuongHieu> selectBySql(String sql, Object... args) {
        List<thuongHieu> list = new ArrayList<thuongHieu>();
        try {
            ResultSet rs = jdbcHelper.executeQuery(sql, args);
            while (rs.next()) {
                thuongHieu entity = new thuongHieu();
                entity.setMaTH(rs.getString("MATHUONGHIEU"));
                entity.setTenTH(rs.getString("TENTHUONGHIEU"));
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
