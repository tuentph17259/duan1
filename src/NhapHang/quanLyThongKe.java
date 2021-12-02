/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NhapHang;

import NhapHang.thongKeModel;
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
public class quanLyThongKe {
    private thongKeServiceInter thongKeService = null;
    public quanLyThongKe() {
        this.thongKeService = new thongKeService();
    }

    public void setDataToChart(JPanel jpnItem) {
        List<thongKeModel> listItem = thongKeService.getDoanhThu();

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        if (listItem != null) {
            for (thongKeModel item1 : listItem) {
                dataset.addValue(item1.getTongTienChi(), "Thống kê", item1.getNgayNhap());
            }
        }

        JFreeChart barChart = ChartFactory.createBarChart(
                "BIỂU ĐỒ THỐNG KÊ TIỀN CHI THEO THÁNG".toUpperCase(),
                "THÁNG TRONG NĂM", "TIỀN CHI",
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
