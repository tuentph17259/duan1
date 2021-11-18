/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class hoaDon {
    private String maHoaDon;
    private String maKhachHang;
    private String maNhanVien;
    private String maSanPham;
    private Date ngayLapHoaDon;
    private double tongTien;

    public hoaDon() {
    }

    public hoaDon(String maHoaDon, String maKhachHang, String maNhanVien, String maSanPham, Date ngayLapHoaDon, double tongTien) {
        this.maHoaDon = maHoaDon;
        this.maKhachHang = maKhachHang;
        this.maNhanVien = maNhanVien;
        this.maSanPham = maSanPham;
        this.ngayLapHoaDon = ngayLapHoaDon;
        this.tongTien = tongTien;
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }

    public Date getNgayLapHoaDon() {
        return ngayLapHoaDon;
    }

    public void setNgayLapHoaDon(Date ngayLapHoaDon) {
        this.ngayLapHoaDon = ngayLapHoaDon;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    @Override
    public String toString() {
        return "hoaDon{" + "maHoaDon=" + maHoaDon + ", maKhachHang=" + maKhachHang + ", maNhanVien=" + maNhanVien + ", maSanPham=" + maSanPham + ", ngayLapHoaDon=" + ngayLapHoaDon + ", tongTien=" + tongTien + '}';
    }
    
    
}
