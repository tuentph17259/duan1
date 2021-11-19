/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;


import Model.User;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author NGUYEN TRI TUE
 */
public class shareHelper {

    //Ảnh biểu tượng của ứng dụng, xuất hiện trên mọi cửa sổ
//    public static final Image AppIcon;
//    public static final ImageIcon AppIcon1;
//
//    static {
//        String file = "/icon/dt.png";
//        AppIcon = new ImageIcon(shareHelper.class.getResource(file)).getImage();
//        AppIcon1 = new ImageIcon(shareHelper.class.getResource(file));
//    }
//
//    //Sao chép file logo chuyên đề vào thư mục logos (tạo nếu chưa có thư mục logos)
//    public static void save(File src) {
//        File dst = new File("logos", src.getName());
//        if (!dst.getParentFile().exists()) {
//            dst.getParentFile().mkdirs();//Tạo thư mục
//        }
//        try {
//            Path from = Paths.get(src.getAbsolutePath());
//            Path to = Paths.get(dst.getAbsolutePath());
//            Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);
//        } catch (Exception ex) {
//            throw new RuntimeException(ex);
//        }
//    }
//
//    //Đọc hình ảnh logo chuyên đề trong thư mục logos theo tenFile
//    public static ImageIcon readLogo(String fileName) {
//        File path = new File("logos", fileName);
//        return new ImageIcon(new ImageIcon(path.getAbsolutePath()).getImage().getScaledInstance(180, 180, Image.SCALE_DEFAULT));
//    }
    //Đối tượng này chứa thông tin người sử dụng sau khi đăng nhập
    public static User user = null;

    //Xóa thông tin của người sử dụng khi có yêu cầu đăng xuất
    public static void logoff() {
        shareHelper.user = null;
    }

    //Kiểm tra xem đăng nhập hay chưa
    public static boolean isLogin() {
        return shareHelper.user != null;
    }
    //Kiểm tra vai trò
    public static boolean isManager(){
      return shareHelper.isLogin()&& user.isVaiTro();
    }
}
