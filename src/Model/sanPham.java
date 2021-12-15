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
    private String ram;
    private String rom;
    private String camera;
    private String pixel;
    private String screenSize;
    private String os;
    private boolean trangThai;
    private String maThuongHieu;
    private String moTa;
    
    

    public sanPham() {
    }

    public sanPham(String maSanPham, String tenSanPham, String mauSac, double giaSanPham, String hinhAnh, String ram, String rom, String camera, String pixel, String screenSize, String os, boolean trangThai, String maThuongHieu, String moTa) {
        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
        this.mauSac = mauSac;
        this.giaSanPham = giaSanPham;
        this.hinhAnh = hinhAnh;
        this.ram = ram;
        this.rom = rom;
        this.camera = camera;
        this.pixel = pixel;
        this.screenSize = screenSize;
        this.os = os;
        this.trangThai = trangThai;
        this.maThuongHieu = maThuongHieu;
        this.moTa = moTa;
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

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getRom() {
        return rom;
    }

    public void setRom(String rom) {
        this.rom = rom;
    }

    public String getCamera() {
        return camera;
    }

    public void setCamera(String camera) {
        this.camera = camera;
    }

    public String getPixel() {
        return pixel;
    }

    public void setPixel(String pixel) {
        this.pixel = pixel;
    }

    public String getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(String screenSize) {
        this.screenSize = screenSize;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
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

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    @Override
    public String toString() {
        return "sanPham{" + "maSanPham=" + maSanPham + ", tenSanPham=" + tenSanPham + ", mauSac=" + mauSac + ", giaSanPham=" + giaSanPham + ", hinhAnh=" + hinhAnh + ", ram=" + ram + ", rom=" + rom + ", camera=" + camera + ", pixel=" + pixel + ", screenSize=" + screenSize + ", os=" + os + ", trangThai=" + trangThai + ", maThuongHieu=" + maThuongHieu + ", moTa=" + moTa + '}';
    }

    
}
