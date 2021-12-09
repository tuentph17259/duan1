/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import DAO.nhanVienDAO;
import Dao.userDao;
import Helper.Check;
import Helper.auth;
import Helper.dialogHelper;
import Model.User;
import Model.nhanVien;
import static java.awt.Color.pink;
import static java.awt.Color.white;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author NGUYEN TRI TUE
 */
public class taiKhoanInter extends javax.swing.JInternalFrame {

    public taiKhoanInter() {
        initComponents();
        init();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        tabs = new javax.swing.JTabbedPane();
        pnlCapNhap = new javax.swing.JPanel();
        pnlNhapTT = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtHoten = new javax.swing.JTextField();
        txtMK2 = new javax.swing.JPasswordField();
        txtMK = new javax.swing.JPasswordField();
        rdoNhanVien = new javax.swing.JRadioButton();
        rdoChu = new javax.swing.JRadioButton();
        cbbMaNV = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnMoi = new javax.swing.JButton();
        pnlDanhSach = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTaiKhoan = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();

        setClosable(true);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("QUẢN LÝ TÀI KHOẢN");

        pnlNhapTT.setBackground(new java.awt.Color(218, 242, 220));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Mã nhân viên:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Họ và tên:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Mật khẩu:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Vai trò:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Xác nhận mật khẩu:");

        buttonGroup1.add(rdoNhanVien);
        rdoNhanVien.setText("Nhân viên");

        buttonGroup1.add(rdoChu);
        rdoChu.setText("Chủ");

        cbbMaNV.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbMaNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbMaNVActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlNhapTTLayout = new javax.swing.GroupLayout(pnlNhapTT);
        pnlNhapTT.setLayout(pnlNhapTTLayout);
        pnlNhapTTLayout.setHorizontalGroup(
            pnlNhapTTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNhapTTLayout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addGroup(pnlNhapTTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlNhapTTLayout.createSequentialGroup()
                        .addGroup(pnlNhapTTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5))
                        .addGap(38, 38, 38)
                        .addGroup(pnlNhapTTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlNhapTTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtHoten, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                                .addComponent(txtMK)
                                .addComponent(txtMK2, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(cbbMaNV, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(pnlNhapTTLayout.createSequentialGroup()
                                .addComponent(rdoChu, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(49, 49, 49)
                                .addComponent(rdoNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addContainerGap(150, Short.MAX_VALUE))
        );
        pnlNhapTTLayout.setVerticalGroup(
            pnlNhapTTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNhapTTLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(pnlNhapTTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbbMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(pnlNhapTTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtHoten, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(pnlNhapTTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtMK, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(pnlNhapTTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtMK2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(pnlNhapTTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(rdoNhanVien)
                    .addComponent(rdoChu))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(129, 183, 210));

        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Add.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Delete.png"))); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Refresh.png"))); // NOI18N
        btnMoi.setText("Mới");
        btnMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(152, Short.MAX_VALUE)
                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76)
                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75)
                .addComponent(btnMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(130, 130, 130))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMoi)
                    .addComponent(btnXoa)
                    .addComponent(btnThem))
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout pnlCapNhapLayout = new javax.swing.GroupLayout(pnlCapNhap);
        pnlCapNhap.setLayout(pnlCapNhapLayout);
        pnlCapNhapLayout.setHorizontalGroup(
            pnlCapNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlNhapTT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlCapNhapLayout.setVerticalGroup(
            pnlCapNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCapNhapLayout.createSequentialGroup()
                .addComponent(pnlNhapTT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabs.addTab("Cập nhập", pnlCapNhap);

        tblTaiKhoan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Nv", "Họ và Tên", "Mật khẩu", "Vai trò"
            }
        ));
        tblTaiKhoan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTaiKhoanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblTaiKhoan);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("DANH SÁCH TÀI KHOẢN");

        javax.swing.GroupLayout pnlDanhSachLayout = new javax.swing.GroupLayout(pnlDanhSach);
        pnlDanhSach.setLayout(pnlDanhSachLayout);
        pnlDanhSachLayout.setHorizontalGroup(
            pnlDanhSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDanhSachLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 713, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(pnlDanhSachLayout.createSequentialGroup()
                .addGap(283, 283, 283)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlDanhSachLayout.setVerticalGroup(
            pnlDanhSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDanhSachLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 442, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabs.addTab("Danh sách", pnlDanhSach);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabs)
            .addGroup(layout.createSequentialGroup()
                .addGap(256, 256, 256)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabs))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoiActionPerformed
        this.clearForm();
    }//GEN-LAST:event_btnMoiActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        if (Check.checkNullPass(txtMK)
                && Check.checkNullPass(txtMK2)) {
            if (Check.checkPass(txtMK)) {
                if (checkTrungMa(cbbMaNV)) {
                    insert();
                }
            }

        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void cbbMaNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbMaNVActionPerformed
        int index;
        index = cbbMaNV.getSelectedIndex();
        if (index >= 0) {

            chonNhanVien();
        }
    }//GEN-LAST:event_cbbMaNVActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        delete();

    }//GEN-LAST:event_btnXoaActionPerformed

    private void tblTaiKhoanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTaiKhoanMouseClicked
        if (evt.getClickCount() == 1) {
            this.row = tblTaiKhoan.getSelectedRow();
            this.edit();

        }
    }//GEN-LAST:event_tblTaiKhoanMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMoi;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbbMaNV;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnlCapNhap;
    private javax.swing.JPanel pnlDanhSach;
    private javax.swing.JPanel pnlNhapTT;
    private javax.swing.JRadioButton rdoChu;
    private javax.swing.JRadioButton rdoNhanVien;
    private javax.swing.JTabbedPane tabs;
    private javax.swing.JTable tblTaiKhoan;
    private javax.swing.JTextField txtHoten;
    private javax.swing.JPasswordField txtMK;
    private javax.swing.JPasswordField txtMK2;
    // End of variables declaration//GEN-END:variables
    nhanVienDAO nvDao = new nhanVienDAO();
    userDao usDao = new userDao();
    int row = -1;

    public void init() {
        fillComBobox();
        fillTable();
        rdoNhanVien.setSelected(true);
        txtHoten.setEditable(false);

    }

    public boolean checkTrungMa(JComboBox txt) {
        txt.setBackground(white);
        if (usDao.selectById(txt.getSelectedItem().toString()) == null) {
            return true;
        } else {
            txt.setBackground(pink);
            dialogHelper.alert(this, txt.getName() + " đã bị tồn tại:" + cbbMaNV.getSelectedItem());
            return false;
        }
    }

    void insert() {
        User us = getForm();
        if (us == null) {
            return;
        }
        String mk2 = new String(txtMK2.getPassword());
        if (!mk2.equals(us.getMatKhau())) {
            dialogHelper.alert(this, "Mật khẩu xác nhận không đúng ahihi");
        } else {
            try {
                usDao.insert(us);
                this.fillTable();
                this.clearForm();
                dialogHelper.alert(this, "thêm mới thành công");
            } catch (Exception e) {
                e.printStackTrace();
                dialogHelper.alert(this, "thêm mới thất bại");
            }

        }
    }

    void delete() {
        if (!auth.isManager()) {
            dialogHelper.alert(this, "Bạn không có quyền xóa nhân viên");
        } else {
            String manv = JOptionPane.showInputDialog("Mời bạn chọn mã nhân viên muốn xóa");
            if (usDao.selectById(manv) == null) {

                dialogHelper.alert(this, "mã nhân viên bạn nhập không tồn tại");
                return;
            }
            if (manv.equals(auth.user.getMaNV())) {
                dialogHelper.alert(this, "bạn không được xóa chính bạn");
            } else if (dialogHelper.confirm(this, "Bạn có thực sự muốn xóa")) {
                try {
                    usDao.delete(manv);
                    this.fillTable();
                    this.clearForm();
                    dialogHelper.alert(this, "xóa thành công");
                } catch (Exception e) {
                    e.printStackTrace();
                    dialogHelper.alert(this, "xóa thất bại");
                }
            }
        }
    }

    public void fillComBobox() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cbbMaNV.getModel();
        model.removeAllElements();
        try {
            List<nhanVien> list = nvDao.selectAll();
            for (nhanVien nv : list) {
                model.addElement(nv);
            }
        } catch (Exception e) {
            e.printStackTrace();
            dialogHelper.alert(this, "lỗi truy vấn");
        }
    }

    void fillTable() {
        DefaultTableModel model = (DefaultTableModel) tblTaiKhoan.getModel();
        model.setRowCount(0);
        try {
            List<User> list = usDao.selectAll();
            for (User us : list) {
                Object[] row = {
                    us.getMaNV(),
                    us.getHoTen(),
                    us.getMatKhau(),
                    us.isVaiTro() ? "Chủ " : " Nhân Viên"
                };
                model.addRow(row);
            }
        } catch (Exception e) {
            dialogHelper.alert(this, "lỗi truy vấn dữ liệu");
        }
    }

    void setForm(User us) {

        txtMK.setText(us.getMatKhau());
        txtMK2.setText(us.getMatKhau());
//        cbbMaNV.setSelectedItem(us.getMaNV());
        txtHoten.setText(us.getHoTen());
        rdoChu.setSelected(us.isVaiTro());
        rdoNhanVien.setSelected(!us.isVaiTro());

    }

    User getForm() {
        User us = new User();
        us.setMaNV(cbbMaNV.getSelectedItem().toString());
        us.setHoTen(txtHoten.getText());
        us.setMatKhau(new String(txtMK.getPassword()));
        us.setVaiTro(rdoChu.isSelected());
        return us;
    }

    void edit() {
        String manv = tblTaiKhoan.getValueAt(this.row, 0).toString();
        User us = usDao.selectById(manv);
        this.setForm(us);

        tabs.setSelectedIndex(0);

    }

    void clearForm() {
        txtMK.setText("");
        txtMK2.setText("");

    }

    private void chonNhanVien() {
        nhanVien nv = (nhanVien) cbbMaNV.getSelectedItem();
        txtHoten.setText(nv.getTenNV());
    }
//    void hienMaCBB(){
//        int viTri = tblTaiKhoan.getSelectedRow();
//        if (viTri==-1) {
//            return;
//        }
//        List<nhanVien> list = nvDao.selectAll();
//        nhanVien nv = list.get(viTri);
//        cbbMaNV.setSelectedItem(tblTaiKhoan.getValueAt(viTri, 0));
//    }

}
