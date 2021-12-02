/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HoaDonBH;

import HoaDonBH.thongKeModel1;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.util.List;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
/**
 *
 * @author NGUYEN TRI TUE
 */
public class quanLyThongKe1 {
    private thongKeServiceInter1 thongKeService1 = null;
    public quanLyThongKe1() {
        this.thongKeService1 = new thongKeService1();
    }

    public void setDataToChart1(JPanel jpnItem) {
        List<thongKeModel1> listItem = thongKeService1.getDoanhThu();

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        if (listItem != null) {
            for (thongKeModel1 item : listItem) {
                dataset.addValue(item.getTongtien(), "Thống kê 1", item.getNgaylap());
            }
        }

        JFreeChart barChart = ChartFactory.createBarChart(
                "BIỂU ĐỒ THỐNG KÊ DOANH THU THEO THÁNG".toUpperCase(),
                "THÁNG TRONG NĂM", "DOANH THU",
                dataset, PlotOrientation.VERTICAL, false, true, false);

        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new Dimension(jpnItem.getWidth(), 285));

        jpnItem.removeAll();
        jpnItem.setLayout(new CardLayout());
        jpnItem.add(chartPanel);
        jpnItem.validate();
        jpnItem.repaint();
    }
}
