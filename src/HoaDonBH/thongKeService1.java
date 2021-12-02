/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HoaDonBH;

import HoaDonBH.thongKeModel1;
import java.util.List;

/**
 *
 * @author NGUYEN TRI TUE
 */
public class thongKeService1 implements thongKeServiceInter1{
    private thongKeInter1 tkDao =null;

    public thongKeService1(){
           this.tkDao = new thongKeSQL1();
    }
    @Override
    public List<thongKeModel1> getDoanhThu() {
       return tkDao.getDoanhThu();
    }
    
}
