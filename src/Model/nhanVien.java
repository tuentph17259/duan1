package Model;

import java.util.Date;

/**
 *
 * @author Dell Ins
 */
public class nhanVien {

    private String maNV;
    private String tenNV;
    private boolean gioiTinh;
    private String queQuan;
    private Date ngaySinh;
    private String SDT;
    @Override
    public String toString(){
        return this.maNV;
    }

    public nhanVien() {
    }

    public nhanVien(String maNV, String tenNV, boolean gioiTinh, String queQuan, Date ngaySinh, String SDT) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.gioiTinh = gioiTinh;
        this.queQuan = queQuan;
        this.ngaySinh = ngaySinh;
        this.SDT = SDT;
    }

    public String getMaNV() {
        return maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public String getQueQuan() {
        return queQuan;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public String getSDT() {
        return SDT;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

}
