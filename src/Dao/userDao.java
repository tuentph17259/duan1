/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Helper.jdbcHelper;
import Model.User;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author NGUYEN TRI TUE
 */
public class userDao extends cuaHangDao<User, String>{
String INSERT_SQL="INSERT INTO USERS (MaNV, MatKhau, HOTEN, VAITRO) VALUES (?,?,?,?)";
String UPDATE_SQL="UPDATE USERS SET MatKhau = ?, HoTen = ?, VaiTro = ? WHERE MaNV = ?";
String DELETE_SQL="DELETE FROM USERS WHERE MaNV = ?";
String SELECT_ALL_SQL = "SELECT * FROM USERS";
String SELECT_BY_ID_SQL = "SELECT * FROM USERS WHERE MaNV = ?";

    
    @Override
    public void insert(User entity) {
        jdbcHelper.executeUpdate(INSERT_SQL, entity.getMaNV(),entity.getMatKhau(),entity.getHoTen(),entity.isVaiTro());
    }

    @Override
    public void update(User entity) {
      jdbcHelper.executeUpdate(UPDATE_SQL,entity.getMatKhau(),entity.getHoTen(),entity.isVaiTro(), entity.getMaNV());
    }

    @Override
    public void delete(String maNV) {
          jdbcHelper.executeUpdate(DELETE_SQL,maNV);
    }

    @Override
    public List<User> selectAll() {
        return selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public User selectById(String maNV) {
        List<User> list = this.selectBySql(SELECT_BY_ID_SQL,maNV);
        if(list.isEmpty()){
        return null;
        }
        return list.get(0);
    }

    @Override
    protected List<User> selectBySql(String sql, Object... args) {
        List<User> list = new ArrayList<User>();
         try {
            ResultSet rs = jdbcHelper.executeQuery(sql, args);
             while (rs.next()) {
                User entity =new User();
                entity.setMaNV(rs.getString("MaNV"));
                entity.setHoTen(rs.getString("HoTen"));
                entity.setMatKhau(rs.getString("MatKhau"));
                entity.setVaiTro(rs.getBoolean("VaiTro"));
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
