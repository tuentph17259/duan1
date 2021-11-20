/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Admin
 */
public class sanPham {
    private String maSanPham;
    private String tenSanPham;
    private String mauSac;
    private double giaSanPham;
    private String thuongHieu;
    private String hinhAnh;
    private String cauHinhChiTiet;
    private String trangThai;
    private String maNhaCungCap;

    public sanPham() {
    }

    public sanPham(String maSanPham, String tenSanPham, String mauSac, double giaSanPham, String thuongHieu, String hinhAnh, String cauHinhChiTiet, String trangThai, String maNhaCungCap) {
        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
        this.mauSac = mauSac;
        this.giaSanPham = giaSanPham;
        this.thuongHieu = thuongHieu;
        this.hinhAnh = hinhAnh;
        this.cauHinhChiTiet = cauHinhChiTiet;
        this.trangThai = trangThai;
        this.maNhaCungCap = maNhaCungCap;
    }

    public String getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public String getMauSac() {
        return mauSac;
    }

    public void setMauSac(String mauSac) {
        this.mauSac = mauSac;
    }

    public double getGiaSanPham() {
        return giaSanPham;
    }

    public void setGiaSanPham(double giaSanPham) {
        this.giaSanPham = giaSanPham;
    }

    public String getThuongHieu() {
        return thuongHieu;
    }

    public void setThuongHieu(String thuongHieu) {
        this.thuongHieu = thuongHieu;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public String getCauHinhChiTiet() {
        return cauHinhChiTiet;
    }

    public void setCauHinhChiTiet(String cauHinhChiTiet) {
        this.cauHinhChiTiet = cauHinhChiTiet;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getMaNhaCungCap() {
        return maNhaCungCap;
    }

    public void setMaNhaCungCap(String maNhaCungCap) {
        this.maNhaCungCap = maNhaCungCap;
    }

    @Override
    public String toString() {
        return "sanPham{" + "maSanPham=" + maSanPham + ", tenSanPham=" + tenSanPham + ", mauSac=" + mauSac + ", giaSanPham=" + giaSanPham + ", thuongHieu=" + thuongHieu + ", hinhAnh=" + hinhAnh + ", cauHinhChiTiet=" + cauHinhChiTiet + ", trangThai=" + trangThai + ", maNhaCungCap=" + maNhaCungCap + '}';
    }
    
    
}
