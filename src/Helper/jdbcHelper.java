/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author NGUYEN TRI TUE
 */
public class jdbcHelper {

    public static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    public static String url = "jdbc:sqlserver://localhost\\NATSUMEKOKKORO\\SQLEXPRESS:1433;databaseName=DUAN1";
    public static String username = "sa";
    public static String password = "1234";

    //Nạp driver
    static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static PreparedStatement preparedStatement(String sql, Object... args) throws SQLException {
        Connection con = DriverManager.getConnection(url, username, password);
        PreparedStatement pstmt = null;
        if (sql.startsWith("{")) {
            pstmt = con.prepareCall(sql);    //có thể gán biến kiểu PreparedStatement là prepareCall (CallableStatement)
        } else {
            pstmt = con.prepareStatement(sql);
        }
        for (int i = 0; i < args.length; i++) {
            pstmt.setObject(i + 1, args[i]);
        }
        return pstmt;
    }

    //thao tác (INSERT, UPDATE, DELETE)
    public static void executeUpdate(String sql, Object... args) {
        try {
            PreparedStatement pstmt = preparedStatement(sql, args);
            try {
                pstmt.executeUpdate();
            } finally {
                pstmt.getConnection().close();            //đóng Connection từ statement
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    //thao tác truy vấn (SELECT)

    public static ResultSet executeQuery(String sql, Object... args) {
        try {
            PreparedStatement pstmt = preparedStatement(sql, args);
            try {
                return pstmt.executeQuery();
            } finally {
                //pstmt.getConnection().close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);         //throw các lỗi khi chạy CT, VD không có return khi try bị lỗi
        }
    }
}
