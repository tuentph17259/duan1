/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author NGUYEN TRI TUE
 */
public class phieuNhap {

    private String maPhieuNhap;
    private String maNhanVien;
    private String maNCC;
    private Date ngayNhap;
    private String tongTien;

    public phieuNhap() {
    }

    public phieuNhap(String maPhieuNhap, String maNhanVien, String maNCC, Date ngayNhap, String tongTien) {
        this.maPhieuNhap = maPhieuNhap;
        this.maNhanVien = maNhanVien;
        this.maNCC = maNCC;
        this.ngayNhap = ngayNhap;
        this.tongTien = tongTien;
    }

    public String getMaPhieuNhap() {
        return maPhieuNhap;
    }

    public void setMaPhieuNhap(String maPhieuNhap) {
        this.maPhieuNhap = maPhieuNhap;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getMaNCC() {
        return maNCC;
    }

    public void setMaNCC(String maNCC) {
        this.maNCC = maNCC;
    }

    public Date getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(Date ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public String getTongTien() {
        return tongTien;
    }

    public void setTongTien(String tongTien) {
        this.tongTien = tongTien;
    }

    @Override
    public String toString() {
        return "phieuNhap{" + "maPhieuNhap=" + maPhieuNhap + ", maNhanVien=" + maNhanVien + ", maNCC=" + maNCC + ", ngayNhap=" + ngayNhap + ", tongTien=" + tongTien + '}';
    }
}
