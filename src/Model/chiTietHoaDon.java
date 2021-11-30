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
public class chiTietHoaDon {
    private String maChiTietHoaDon;
    private String maHoaDon;
    private int soLuong;
   
    private String maSanPham;
    private String tongTien;
    

    public chiTietHoaDon() {
    }

    public chiTietHoaDon(String maChiTietHoaDon, String maHoaDon, int soLuong, String maSanPham, String tongTien) {
        this.maChiTietHoaDon = maChiTietHoaDon;
        this.maHoaDon = maHoaDon;
        this.soLuong = soLuong;
       
        this.maSanPham = maSanPham;
        this.tongTien = tongTien;
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
        return "chiTietHoaDon{" + "maChiTietHoaDon=" + maChiTietHoaDon + ", maHoaDon=" + maHoaDon + ", soLuong=" + soLuong + ", maSanPham=" + maSanPham + ", tongTien=" + tongTien + '}';
    }
    
    
}
