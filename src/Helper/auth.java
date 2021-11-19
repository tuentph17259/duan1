/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;

import Model.User;

/**
 *
 * @author NGUYEN TRI TUE
 */
public class auth {
    //Đối tượng này chứa thông tin người sử dụng sau khi đăng nhập
    public static User user = null;

    //Xóa thông tin của người sử dụng khi có yêu cầu đăng xuất
    public static void logoff() {
        auth.user = null;
    }

    //Kiểm tra xem đăng nhập hay chưa
    public static boolean isLogin() {
        return auth.user != null;
    }
    //Kiểm tra vai trò
    public static boolean isManager(){
      return auth.isLogin()&& user.isVaiTro();
    }
}
