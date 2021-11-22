package Model;

/**
 *
 * @author Dell Ins
 */
public class User {

    private int ID;
    private String maNV;
    private String matKhau;
    private String hoTen;
    private boolean vaiTro;
    
    
    public User() {
    }

    public User(int ID, String maNV, String matKhau, String hoTen, boolean vaiTro) {
        this.ID = ID;
        this.maNV = maNV;
        this.matKhau = matKhau;
        this.hoTen = hoTen;
        this.vaiTro = vaiTro;
    }

    public int getID() {
        return ID;
    }

    public String getMaNV() {
        return maNV;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public String getHoTen() {
        return hoTen;
    }

    public boolean isVaiTro() {
        return vaiTro;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public void setVaiTro(boolean vaiTro) {
        this.vaiTro = vaiTro;
    }

}
