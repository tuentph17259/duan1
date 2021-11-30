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
    private String hinhAnh;
    private String cauHinhChiTiet;
    private boolean trangThai;
    private String maThuongHieu;
    

    public sanPham() {
    }

    public sanPham(String maSanPham, String tenSanPham, String mauSac, double giaSanPham, String hinhAnh, String cauHinhChiTiet, boolean trangThai, String maThuongHieu) {
        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
        this.mauSac = mauSac;
        this.giaSanPham = giaSanPham;
        this.hinhAnh = hinhAnh;
        this.cauHinhChiTiet = cauHinhChiTiet;
        this.trangThai = trangThai;
        this.maThuongHieu = maThuongHieu;
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

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public String getMaThuongHieu() {
        return maThuongHieu;
    }

    public void setMaThuongHieu(String maThuongHieu) {
        this.maThuongHieu = maThuongHieu;
    }

    @Override
    public String toString() {
        return "sanPham{" + "maSanPham=" + maSanPham + ", tenSanPham=" + tenSanPham + ", mauSac=" + mauSac + ", giaSanPham=" + giaSanPham + ", hinhAnh=" + hinhAnh + ", cauHinhChiTiet=" + cauHinhChiTiet + ", trangThai=" + trangThai + ", maThuongHieu=" + maThuongHieu + '}';
    }


}
