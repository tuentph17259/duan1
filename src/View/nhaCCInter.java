/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Dao.nhaCCDao;
import Helper.dateHelper;
import Helper.dialogHelper;
import Helper.jdbcHelper;
import Model.nhaCungCap;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author NGUYEN TRI TUE
 */
public class nhaCCInter extends javax.swing.JInternalFrame {

    nhaCCDao dao = new nhaCCDao();
    int row = -1;

    /**
     * Creates new form nhaCCInter
     */
    public nhaCCInter() {
        initComponents();
        init();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtMaNCC = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtTenNCC = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtDiaChi = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnXoaTrang = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblNhaCC = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblluuTru = new javax.swing.JTable();
        btnluuTru = new javax.swing.JButton();

        setClosable(true);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 51));
        jLabel1.setText("THÔNG TIN NHÀ CUNG CẤP");

        jPanel2.setBackground(new java.awt.Color(218, 242, 220));

        jLabel2.setText("Mã nhà cung cấp:");

        jLabel3.setText("Tên nhà cung cấp: ");

        jLabel4.setText("SDT:");

        jLabel5.setText("Địa chỉ:");

        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Add.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Edit.png"))); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Delete.png"))); // NOI18N
        btnXoa.setText("Xoá");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnXoaTrang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Refresh.png"))); // NOI18N
        btnXoaTrang.setText("Xoá trắng");
        btnXoaTrang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaTrangActionPerformed(evt);
            }
        });

        tblNhaCC.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã nhà cung cấp", "Tên nhà cung cấp", "SDT", "Địa chỉ"
            }
        ));
        tblNhaCC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNhaCCMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblNhaCC);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5))
                .addGap(39, 39, 39)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtTenNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnXoa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoaTrang, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSua, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtMaNCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThem))
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtTenNCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSua))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(btnXoa)
                        .addGap(18, 18, 18)
                        .addComponent(btnXoaTrang)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(209, 209, 209)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Thông tin", jPanel1);

        tblluuTru.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã nhà cung cấp", "Tên nhà cung cấp"
            }
        ));
        jScrollPane2.setViewportView(tblluuTru);

        btnluuTru.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Refresh.png"))); // NOI18N
        btnluuTru.setText("Khôi phục");
        btnluuTru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnluuTruActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 732, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnluuTru))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnluuTru)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Lưu trữ", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 496, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        insert();
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        update();
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        delete();
        fillTableRecycle();
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnXoaTrangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaTrangActionPerformed
        clearFrom();
    }//GEN-LAST:event_btnXoaTrangActionPerformed

    private void tblNhaCCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNhaCCMouseClicked
        this.row = tblNhaCC.getSelectedRow();
        this.edit();
    }//GEN-LAST:event_tblNhaCCMouseClicked

    private void btnluuTruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnluuTruActionPerformed
        install();
    }//GEN-LAST:event_btnluuTruActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnXoaTrang;
    private javax.swing.JButton btnluuTru;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblNhaCC;
    private javax.swing.JTable tblluuTru;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtMaNCC;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTenNCC;
    // End of variables declaration//GEN-END:variables

    public void init() {
        this.row = -1;
        this.updateStatus();
        fillTable();
    }

    void fillTable() {
        DefaultTableModel mol = (DefaultTableModel) tblNhaCC.getModel();
        mol.setRowCount(0);
        try {
            List<nhaCungCap> list = dao.selectAll();
            for (nhaCungCap cc : list) {
                Object[] row = {cc.getMaNCC(), cc.getTenNCC(), cc.getDiaChi(), cc.getSDT()};
                mol.addRow(row);
            }
        } catch (Exception e) {
            dialogHelper.alert(this, "Lỗi truy vấn dữ liệu!");
            e.printStackTrace();
        }
    }

    void fillTableRecycle() {
        DefaultTableModel dtm = (DefaultTableModel) tblluuTru.getModel();
        dtm.setRowCount(0);
        try {
            dao.getNhaCungCapRecycle().removeAll(dao.getNhaCungCapRecycle());
            for (nhaCungCap ncc : dao.getNhaCungCapRecycle()) {
                dtm.addRow(new Object[]{
                    ncc.getMaNCC(),
                    ncc.getTenNCC()
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
            dialogHelper.alert(null, "Lỗi truy vấn dữ liệu");
        }
    }

    void install() {
        try {
            String maCC = tblluuTru.getValueAt(tblluuTru.getSelectedRow(), 0).toString();
            dao.install(maCC);
            dialogHelper.alert(null, "Khôi phục thành công!");
            jTabbedPane1.setSelectedIndex(0);
            fillTableRecycle();
            fillTable();
        } catch (Exception e) {
            e.printStackTrace();
            dialogHelper.alert(null, "KHông có dữ liệu");
        }

    }

    void setForm(nhaCungCap nhaCC) {
        txtMaNCC.setText(nhaCC.getMaNCC());
        txtTenNCC.setText(nhaCC.getTenNCC());
        txtDiaChi.setText(nhaCC.getDiaChi());
        txtSDT.setText(nhaCC.getSDT());
    }

    nhaCungCap getFrom() {
        nhaCungCap nhaCC = new nhaCungCap();
        if (txtMaNCC.getText().equals("")) {
            return null;
        }
        if (txtTenNCC.getText().equals("")) {
            return null;
        }
        if (txtDiaChi.getText().equals("")) {
            return null;
        }

        if (txtSDT.getText().equals("")) {
            return null;
        } else if (!txtSDT.getText().matches("0[0-9]{9}")) {
            dialogHelper.alert(this, "Số điện thoại 10 số");
            return null;
        }

        nhaCC.setMaNCC(txtMaNCC.getText());
        nhaCC.setTenNCC(txtTenNCC.getText());
        nhaCC.setDiaChi(txtDiaChi.getText());
        nhaCC.setSDT(txtSDT.getText());
        return nhaCC;
    }

    void clearFrom() {
        nhaCungCap nhaCC = new nhaCungCap();
        setForm(nhaCC);
        row = -1;
        updateStatus();
    }

    int checkKey() {
        int kt = 0;
        List<nhaCungCap> list = dao.selectAll();
        for (int i = 0; i < list.size(); i++) {
            nhaCungCap nv = list.get(i);
            if (txtMaNCC.getText().trim().equalsIgnoreCase(nv.getMaNCC().trim())) {
                kt = 1;
                break;
            }
        }
        return kt;
    }

    void insert() {
        nhaCungCap nhaCC = getFrom();
        if (txtMaNCC.getText().length() == 0
                || txtSDT.getText().length() == 0
                || txtDiaChi.getText().length() == 0
                || txtTenNCC.getText().length() == 0) {
            dialogHelper.alert(this, "Không được để trống!");
            return;
        } else if (checkKey() == 1) {
            dialogHelper.alert(this, "Mã cung cấp này đã tồn tại!");
            return;
        } else {
            try {
                dao.insert(nhaCC);
                this.fillTable();
                this.clearFrom();
                dialogHelper.alert(this, "Thêm mới thành công!");
            } catch (Exception e) {
                dialogHelper.alert(this, "Thêm mới thất bại!");
                e.printStackTrace();
            }
        }
    }

    void update() {
        nhaCungCap ncc = getFrom();
        try {
            dao.update(ncc);
            fillTable();
            clearFrom();
            dialogHelper.alert(this, "Cập nhật thành công");
        } catch (Exception e) {
            dialogHelper.alert(this, "Cập nhật thất bại!");
            e.printStackTrace();
        }
    }

    void delete() {
        if (dialogHelper.confirm(this, "Bạn có muốn xóa nhà cung cấp này không?")) {
            try {
                String maNCC = txtMaNCC.getText();
                dao.delete(maNCC);
//                dao.delete2(maNCC);
                fillTable();
                clearFrom();
                dialogHelper.alert(this, "Xóa thành công!");
            } catch (Exception e) {
                dialogHelper.alert(this, "Xóa thất bại!");
                e.printStackTrace();
            }
        }
    }

    void edit() {
        String maNCC = (String) tblNhaCC.getValueAt(this.row, 0);
        nhaCungCap nhaCC = dao.selectById(maNCC);
        this.setForm(nhaCC);
        this.updateStatus();
    }

    void updateStatus() {
        boolean edit = (this.row >= 0);
        boolean first = (this.row == 0);
        boolean last = (this.row == tblNhaCC.getRowCount() - 1);
        //Trạng thái form
        txtMaNCC.setEditable(!edit);
        btnThem.setEnabled(!edit);
        btnSua.setEnabled(edit);
        btnXoa.setEnabled(edit);
    }
}
