/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NhapHang;


import Helper.jdbcHelper;
import NhapHang.thongKeModel;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;
import java.sql.DriverManager;

/**
 *
 * @author NGUYEN TRI TUE
 */
public class thongKeSQL implements  thongKeInter{


     @Override
    public List<thongKeModel> getDoanhThu() {
       String sql = "exec sp_TIENCHITHANG";

        List<thongKeModel> list = new ArrayList<>();
        try {
            ResultSet rs = jdbcHelper.executeQuery(sql);
            while (rs.next()) {
                thongKeModel dt = new thongKeModel();
                dt.setNgayNhap(rs.getString("NAMTHANGNHAP"));
                dt.setTongTienChi(rs.getInt("CHITIEU"));
                list.add(dt);
             }
            rs.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
}
