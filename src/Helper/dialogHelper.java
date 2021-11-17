/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;

import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author NGUYEN TRI TUE
 */
public class dialogHelper {
    //Hiên thị thông báo cho người dung
    public static void alert(Component parent, String message) {
    JOptionPane.showMessageDialog(parent, message,
    "Hệ thống cửa hàng điện thoại", JOptionPane.INFORMATION_MESSAGE);
 }
    //Hiển thị thông báo và yêu cầu người dùng xác nhận
    public static boolean confirm(Component parent, String message) {
    int result = JOptionPane.showConfirmDialog(parent, message,
    "Hệ thống cửa hàng điện thoại",
    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
    return result == JOptionPane.YES_OPTION;
 }
    //Hiển thị thông báo yêu cầu nhập dữ liêu
    public static String prompt(Component parent, String message) {
    return JOptionPane.showInputDialog(parent, message,
    "Hệ thống cửa hàng điện thoại", JOptionPane.INFORMATION_MESSAGE);
 }
}
