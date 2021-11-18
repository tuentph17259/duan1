/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author Admin
 */
public class chiTietHoaDon {
    private String maChiTietHoaDon;
    private String maHoaDon;
    private int soLuong;
    private double donGia;
    private String maSanPham;

    public chiTietHoaDon() {
    }

    public chiTietHoaDon(String maChiTietHoaDon, String maHoaDon, int soLuong, double donGia, String maSanPham) {
        this.maChiTietHoaDon = maChiTietHoaDon;
        this.maHoaDon = maHoaDon;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.maSanPham = maSanPham;
    }

    public String getMaChiTietHoaDon() {
        return maChiTietHoaDon;
    }

    public void setMaChiTietHoaDon(String maChiTietHoaDon) {
        this.maChiTietHoaDon = maChiTietHoaDon;
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public String getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }

    @Override
    public String toString() {
        return "chiTietHoaDon{" + "maChiTietHoaDon=" + maChiTietHoaDon + ", maHoaDon=" + maHoaDon + ", soLuong=" + soLuong + ", donGia=" + donGia + ", maSanPham=" + maSanPham + '}';
    }
    
    
}
