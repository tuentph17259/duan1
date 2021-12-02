/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HoaDonBH;

import Helper.jdbcHelper;
import HoaDonBH.thongKeModel1;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;
import java.sql.DriverManager;

/**
 *
 * @author NGUYEN TRI TUE
 */
public class thongKeSQL1 implements thongKeInter1 {

    @Override
    public List<thongKeModel1> getDoanhThu() {
        String sql1 = "exec sp_DoanhThuThang";
        List<thongKeModel1> list = new ArrayList<>();
        try {
            ResultSet rs = jdbcHelper.executeQuery(sql1);
            while (rs.next()) {
                thongKeModel1 dt = new thongKeModel1();
                dt.setNgaylap(rs.getString("NAMTHANG"));
                dt.setTongtien(rs.getInt("DOANHTHUTHANG"));
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
