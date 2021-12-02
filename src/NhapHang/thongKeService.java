/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NhapHang;


import NhapHang.thongKeModel;
import java.util.List;

/**
 *
 * @author NGUYEN TRI TUE
 */
public class thongKeService implements thongKeServiceInter{
    private thongKeInter tkDao =null;

    public thongKeService(){
           this.tkDao = new thongKeSQL();
    }
    @Override
    public List<thongKeModel> getDoanhThu() {
       return tkDao.getDoanhThu();
    }
    
}
