/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author NGUYEN TRI TUE
 */
public class phieuNhapChiTiet {

    private String maChiTietPhieuNhap;
    private String maPhieuNhap;
    private int soLuong;
    private String donGia;
    private String maSanPham;
    private String tongTien;

    public phieuNhapChiTiet() {
    }

    public phieuNhapChiTiet(String maChiTietPhieuNhap, String maPhieuNhap, int soLuong, String donGia, String maSanPham, String tongTien) {
        this.maChiTietPhieuNhap = maChiTietPhieuNhap;
        this.maPhieuNhap = maPhieuNhap;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.maSanPham = maSanPham;
        this.tongTien = tongTien;
    }

    public String getMaChiTietPhieuNhap() {
        return maChiTietPhieuNhap;
    }

    public void setMaChiTietPhieuNhap(String maChiTietPhieuNhap) {
        this.maChiTietPhieuNhap = maChiTietPhieuNhap;
    }

    public String getMaPhieuNhap() {
        return maPhieuNhap;
    }

    public void setMaPhieuNhap(String maPhieuNhap) {
        this.maPhieuNhap = maPhieuNhap;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getDonGia() {
        return donGia;
    }

    public void setDonGia(String donGia) {
        this.donGia = donGia;
    }

    public String getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }

    public String getTongTien() {
        return tongTien;
    }

    public void setTongTien(String tongTien) {
        this.tongTien = tongTien;
    }

    @Override
    public String toString() {
        return "chiTietPhieuNhap{" + "maChiTietPhieuNhap=" + maChiTietPhieuNhap + ", maPhieuNhap=" + maPhieuNhap + ", soLuong=" + soLuong + ", donGia=" + donGia + ", maSanPham=" + maSanPham + ", tongTien=" + tongTien + '}';
    }
}
