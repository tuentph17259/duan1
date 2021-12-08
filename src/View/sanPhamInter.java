/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import DAO.thuongHieuDao;
import Dao.sanPhamDAO;
import Helper.Check;
import Helper.XImage;
import Helper.dialogHelper;
import Model.thuongHieu;
import Model.sanPham;
import static java.awt.Color.pink;
import static java.awt.Color.white;
import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class sanPhamInter extends javax.swing.JInternalFrame {

    thuongHieuDao dao = new thuongHieuDao();
    JFileChooser fileChooser = new JFileChooser();
    sanPhamDAO SPdao = new sanPhamDAO();
    String fileNamePic = "";
    int row = -1;
    int index = 0;

    public sanPhamInter() {
        initComponents();
        init();
    }

    public void init() {
        this.row = -1;
        this.updateStatusSP();
        this.fillTable();
        this.fillTableSP();
        this.fillComboBox();
    }

    private void fillTable() {
        DefaultTableModel dtm = (DefaultTableModel) tblThuongHieu.getModel();
        dtm.setRowCount(0);
        try {
            List<thuongHieu> lst = dao.selectAll();
            for (int i = 0; i < lst.size(); i++) {
                thuongHieu loai = lst.get(i);
                Object[] data = new Object[]{
                    i + 1,
                    loai.getMaTH(),
                    loai.getTenTH()
                };
                dtm.addRow(data);
            }
        } catch (Exception e) {
            dialogHelper.alert(this, "Lỗi truy vấn dữ liệu");
            e.printStackTrace();
        }
    }

    private void fillTableSP() {
        DefaultTableModel modelSP = (DefaultTableModel) tblSanPham.getModel();
        modelSP.setRowCount(0);
        try {
            List<sanPham> lstSP = SPdao.selectAll();
            for (sanPham sp : lstSP) {
                Object[] row = {
                    sp.getMaSanPham(),
                    sp.getTenSanPham(),
                    sp.getMauSac(),
                    sp.isTrangThai() ? "Còn" : "Hết",
                    sp.getGiaSanPham(),
                    sp.getMaThuongHieu(),
                    sp.getCauHinhChiTiet(),
                    sp.getHinhAnh(),};
                modelSP.addRow(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setForm(thuongHieu loai) {
        txtMaThuongHieu.setText(loai.getMaTH());
        txtTenThuongHieu.setText(loai.getTenTH());
    }

    void setFormSP(sanPham model) {
        txtMaSP.setText(model.getMaSanPham());
        txtTenSP.setText(model.getTenSanPham());
        txtMauSac.setText(model.getMauSac());
        rdoCon.setSelected(model.isTrangThai());
        txtGia.setText(Double.toString(model.getGiaSanPham()));
        cbbMaTH.getModel().setSelectedItem(model.getMaThuongHieu());
        txaCauHinh.setText(model.getCauHinhChiTiet());
        lblHinh.setToolTipText(model.getHinhAnh());
        if (model.getHinhAnh() != null) {
            lblHinh.setIcon(XImage.read(model.getHinhAnh()));
        } else {
            lblHinh.setIcon(XImage.read("noImage.png"));
        }
    }

    private thuongHieu getForm() {
        thuongHieu loai = new thuongHieu();
        loai.setMaTH(txtMaThuongHieu.getText());
        loai.setTenTH(txtTenThuongHieu.getText());
        return loai;
    }

    private sanPham getFormSP() {
        sanPham sp = new sanPham();
        if (txtMaSP.getText().equals("")) {
            return null;
        }
        if (txtTenSP.getText().equals("")) {
            return null;
        }
        if (txtMauSac.getText().equals("")) {
            return null;
        }
        if (txtGia.getText().equals("")) {
            return null;
        } else if (txaCauHinh.getText().equals("")) {
            return null;
        }
        sp.setMaSanPham(txtMaSP.getText());
        sp.setTenSanPham(txtTenSP.getText());
        sp.setMauSac(txtMauSac.getText());
        sp.setTrangThai(rdoCon.isSelected());
        sp.setGiaSanPham(Double.parseDouble(txtGia.getText()));
        sp.setMaThuongHieu(cbbMaTH.getSelectedItem().toString());
        sp.setCauHinhChiTiet(txaCauHinh.getText());
        sp.setHinhAnh(lblHinh.getToolTipText());
        return sp;
    }

    private void clearForm() {
        thuongHieu loai = new thuongHieu();
        this.setForm(loai);
        this.row = -1;
        this.updateStatus();
    }

    private void clearSP() {
        sanPham sp = new sanPham();
        this.setFormSP(sp);
        this.row = -1;
        this.updateStatusSP();
    }

    private void edit() {
        String maLoai = (String) tblThuongHieu.getValueAt(this.row, 1);
        thuongHieu loai = dao.selectById(maLoai);
        this.setForm(loai);
        this.updateStatus();
    }

    private void editSP() {
//        try {
        String maSP = (String) tblSanPham.getValueAt(this.row, 0);
        sanPham model = SPdao.selectById(maSP);
//            if (model != null) {
        this.setFormSP(model);
        this.updateStatusSP();
//            }
//        } catch (Exception e) {
//            dialogHelper.alert(this, "Lôi truy vẫn dữ liệu");
//        }
    }

    private void updateStatus() {
        boolean edit = (this.row >= 0);

        txtMaThuongHieu.setEditable(!edit);
        btnThem1.setEnabled(!edit);
        btnSua1.setEnabled(edit);
        btnXoa1.setEnabled(edit);
    }

    private void updateStatusSP() {
        boolean edit = (this.row >= 0);

        txtMaSP.setEditable(!edit);
        btnThem.setEnabled(!edit);
        btnSua.setEnabled(edit);
        btnXoa.setEnabled(edit);
    }

    private void insert() {
        thuongHieu loai = this.getForm();
        if (txtMaThuongHieu.getText().length() == 0 || txtTenThuongHieu.getText().length() == 0) {
            dialogHelper.alert(this, "Không được để trống dữ liệu");
            return;
        } else if (checkKey() == 1) {
            dialogHelper.alert(this, "Đã tồn tại mã thương hiệu phẩm:" + txtMaThuongHieu.getText());
            return;
        } else {
            try {
                dao.insert(loai);
                this.fillTable();
                this.clearForm();
                dialogHelper.alert(this, "Thêm mới thành công!");
            } catch (Exception e) {
                dialogHelper.alert(this, "Thêm mới thất bại!");
                e.printStackTrace();
            }
        }

    }

    private void update() {
        thuongHieu loai = this.getForm();
        try {
            dao.update(loai);
            this.fillTable();
            this.clearForm();
            dialogHelper.alert(this, "Cập nhật thành công");
        } catch (Exception e) {
            dialogHelper.alert(this, "Cập nhật thất bại!");
            e.printStackTrace();
        }
    }

    private void delete() {
        if (dialogHelper.confirm(this, "Bạn muốn xoá thương hiệu này ?")) {
            try {
                String maLoai = txtMaThuongHieu.getText();
                dao.delete(maLoai);
                this.fillTable();
                this.clearForm();
                dialogHelper.alert(this, "Xóa thành công!");
            } catch (Exception e) {
                dialogHelper.alert(this, "Xóa thất bại!");
                e.printStackTrace();
            }
        }

    }

    private void insertSP() {
        sanPham model = getFormSP();
        if (txtMaSP.getText().length() == 0
                || txtTenSP.getText().length() == 0) {
            dialogHelper.alert(this, "Không được để trống");
            return;
        } else if (checkKeySP() == 1) {
            dialogHelper.alert(this, "Đã tồn tại mã sản phẩm" + txtMaSP.getText());
            return;
        } else {
            try {
                SPdao.insert(model);
                this.fillTableSP();
                this.clearSP();
                dialogHelper.alert(this, "Thêm mới thành công!");
            } catch (Exception e) {
                dialogHelper.alert(this, "Thêm mới thất bại!");
                e.printStackTrace();
            }
        }
    }

    public boolean checkTrungMa(JTextField txt) {
        txt.setBackground(white);
        if (SPdao.selectById(txt.getText().toString()) == null) {
            return true;
        } else {
            txt.setBackground(pink);
            dialogHelper.alert(this, txt.getName() + " đã bị tồn tại:" + txtMaSP.getText());
            return false;
        }
    }

    private void deleteSP() {
        if (dialogHelper.confirm(this, "Bạn muốn xoá sản phẩm này ?")) {
            try {
                String sp = txtMaSP.getText();
                SPdao.delete(sp);
                this.fillTableSP();
                this.clearSP();
                dialogHelper.alert(this, "Xóa thành công!");
            } catch (Exception e) {
                dialogHelper.alert(this, "Xóa thất bại!");
                e.printStackTrace();
            }
        }
    }

    private void updateSP() {
        sanPham sp = this.getFormSP();
        try {
            SPdao.update(sp);
            this.fillTableSP();
            dialogHelper.alert(this, "Cập nhật thành công");
        } catch (Exception e) {
            dialogHelper.alert(this, "Cập nhật thất bại!");
            e.printStackTrace();
        }
    }

    private void searchSP() {
        if (txtTenSPTK.getText().length() == 0) {
            dialogHelper.alert(this, "Chưa nhập thông tin!");
            return;
        } else if (checkKeySP() == 1) {
            dialogHelper.alert(this, "Không tìm thấy sản phẩm: " + txtTenSPTK + " ?");
            return;
        } else {
            this.load();
            this.clearSP();
            this.row = -1;
        }
    }

    public int checkKey() {
        int kt = 0;
        List<thuongHieu> lst = dao.selectAll();
        for (int i = 0; i < lst.size(); i++) {
            thuongHieu loai = lst.get(i);
            if (txtMaThuongHieu.getText().trim().equalsIgnoreCase(loai.getMaTH().trim())) {
                kt = 1;
                break;
            }
        }
        return kt;
    }

    public int checkKeySP() {
        int kt = 0;
        List<sanPham> lst = SPdao.selectAll();
        for (int i = 0; i < lst.size(); i++) {
            sanPham sp = lst.get(i);
            if (txtMaThuongHieu.getText().trim().equalsIgnoreCase(sp.getMaSanPham().trim())) {
                kt = 1;
                break;
            }
        }
        return kt;
    }

    void chonAnh() {
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            XImage.save(file);
            ImageIcon icon = XImage.read(file.getName());
            lblHinh.setIcon(icon);
            lblHinh.setToolTipText(file.getName());
        }
    }

    public void upImage(String hinh) {
        ImageIcon image = new ImageIcon("src\\images\\" + hinh);
        Image img = image.getImage();
        ImageIcon icon = new ImageIcon(img.getScaledInstance(lblHinh.getWidth(), lblHinh.getHeight(), img.SCALE_SMOOTH));
        lblHinh.setIcon(icon);
    }

    void load() {
        DefaultTableModel mol = (DefaultTableModel) tblSanPham.getModel();
        mol.setRowCount(0);
        try {
            String keyword = txtTenSPTK.getText();
            List<sanPham> list = SPdao.selectByKeyWord(keyword);
            for (sanPham sp : list) {
                Object[] row = {
                    sp.getMaSanPham(),
                    sp.getTenSanPham(),
                    sp.getMauSac(),
                    sp.isTrangThai() ? "Còn" : "Hết",
                    sp.getGiaSanPham(),
                    sp.getMaThuongHieu(),
                    sp.getCauHinhChiTiet(),
                    sp.getHinhAnh(),};
                mol.addRow(row);
            }
        } catch (Exception e) {
            dialogHelper.alert(this, "Lỗi truy vấn dữ liệu!");
            e.printStackTrace();
        }
    }

    void fillComboBox() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cbbMaTH.getModel(); //kết nối model với cbo
        model.removeAllElements();   //xóa toàn bộ item của cbo
        try {
            List<thuongHieu> list = dao.selectAll();
            for (thuongHieu th : list) {
                model.addElement(th);    //thêm đối tượng (Object) vào model
                //chỉ thêm đc đối tượng đối với model, cbo chỉ được cbo.addItem(String);
                //lấy đối tượng thì từ cbo cũng được: cbo.getSelectedItem();
            }
        } catch (Exception e) {
            dialogHelper.alert(this, "Lỗi truy vấn dữ liệu!");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        tab1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtMaSP = new javax.swing.JTextField();
        txtTenSP = new javax.swing.JTextField();
        txtMauSac = new javax.swing.JTextField();
        rdoHet = new javax.swing.JRadioButton();
        rdoCon = new javax.swing.JRadioButton();
        txtGia = new javax.swing.JTextField();
        cbbMaTH = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaCauHinh = new javax.swing.JTextArea();
        lblHinh = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        btnSua = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnXoaTrang = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSanPham = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        txtTenSPTK = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        btnSearch = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblThuongHieu = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        txtTenThuongHieu = new javax.swing.JTextField();
        txtMaThuongHieu = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        btnThem1 = new javax.swing.JButton();
        btnSua1 = new javax.swing.JButton();
        btnXoa1 = new javax.swing.JButton();
        btnXoatrang1 = new javax.swing.JButton();

        setClosable(true);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 51));
        jLabel1.setText("THÔNG TIN SẢN PHẨM");

        jPanel4.setBackground(new java.awt.Color(218, 242, 220));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Mã sản phẩm:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Tên sản phẩm:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Màu sắc:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Trạng thái:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Giá:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Mã thương hiệu:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Cấu hình:");

        buttonGroup1.add(rdoHet);
        rdoHet.setText("Hết hàng");

        buttonGroup1.add(rdoCon);
        rdoCon.setText("Còn hàng");

        cbbMaTH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txaCauHinh.setColumns(20);
        txaCauHinh.setRows(5);
        jScrollPane1.setViewportView(txaCauHinh);

        lblHinh.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        lblHinh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHinhMouseClicked(evt);
            }
        });

        jLabel11.setText("Ảnh sản phẩm");

        jPanel5.setBackground(new java.awt.Color(129, 183, 210));

        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Edit.png"))); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

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

        btnXoaTrang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Refresh.png"))); // NOI18N
        btnXoaTrang.setText("Xóa trắng");
        btnXoaTrang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaTrangActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                    .addComponent(btnSua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnXoaTrang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnXoa))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSua)
                    .addComponent(btnXoaTrang))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel10))
                .addGap(55, 55, 55)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtGia, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbMaTH, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(rdoCon, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(rdoHet, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 135, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblHinh, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(110, 110, 110))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(192, 192, 192))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(rdoHet)
                            .addComponent(rdoCon))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(75, 75, 75)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(lblHinh, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jLabel8)
                            .addComponent(cbbMaTH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(56, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(338, 338, 338)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tab1.addTab("Sản phẩm", jPanel2);

        tblSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã SP", "Tên SP", "Màu Sắc", "Trạng Thái", "Giá", "Mã Thương Hiệu", "Cấu hình", "Hình ảnh"
            }
        ));
        tblSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSanPhamMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblSanPham);

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm Kiếm"));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("Tên sp:");

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Zoom.png"))); // NOI18N
        btnSearch.setText("Tìm kiếm");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel14)
                .addGap(36, 36, 36)
                .addComponent(txtTenSPTK, javax.swing.GroupLayout.PREFERRED_SIZE, 563, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addComponent(btnSearch)
                .addGap(47, 47, 47))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTenSPTK, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(btnSearch))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(102, 102, 102))
        );

        tab1.addTab("Danh sách", jPanel3);

        tblThuongHieu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã Thương Hiệu", "Tên Thương Hiệu"
            }
        ));
        tblThuongHieu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblThuongHieuMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblThuongHieu);

        jPanel6.setBackground(new java.awt.Color(218, 242, 220));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Tên Thương Hiệu:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Mã Thương Hiệu:");

        jPanel8.setBackground(new java.awt.Color(129, 183, 210));

        btnThem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Add.png"))); // NOI18N
        btnThem1.setText("Thêm");
        btnThem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThem1ActionPerformed(evt);
            }
        });

        btnSua1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Edit.png"))); // NOI18N
        btnSua1.setText("Sửa");
        btnSua1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSua1ActionPerformed(evt);
            }
        });

        btnXoa1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Delete.png"))); // NOI18N
        btnXoa1.setText("Xóa");
        btnXoa1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoa1ActionPerformed(evt);
            }
        });

        btnXoatrang1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Refresh.png"))); // NOI18N
        btnXoatrang1.setText("Xóa trắng");
        btnXoatrang1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoatrang1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnXoatrang1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnThem1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnXoa1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSua1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSua1)
                    .addComponent(btnThem1))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXoa1)
                    .addComponent(btnXoatrang1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(14, 14, 14)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMaThuongHieu, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenThuongHieu, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(45, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtMaThuongHieu, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtTenThuongHieu, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 531, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tab1.addTab("Thương hiệu", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tab1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tab1, javax.swing.GroupLayout.PREFERRED_SIZE, 581, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThem1ActionPerformed
        if (Check.checkName(txtTenThuongHieu)) {
            this.insert();
        }
    }//GEN-LAST:event_btnThem1ActionPerformed

    private void btnSua1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSua1ActionPerformed
        if (Check.checkName(txtTenThuongHieu)) {
            this.update();
        }
    }//GEN-LAST:event_btnSua1ActionPerformed

    private void btnXoa1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoa1ActionPerformed
        this.delete();
    }//GEN-LAST:event_btnXoa1ActionPerformed

    private void btnXoatrang1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoatrang1ActionPerformed
        this.clearForm();
    }//GEN-LAST:event_btnXoatrang1ActionPerformed

    private void tblThuongHieuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblThuongHieuMouseClicked
        if (evt.getClickCount() == 1) {
            this.row = tblThuongHieu.getSelectedRow();
            this.edit();
        }
    }//GEN-LAST:event_tblThuongHieuMouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        if (Check.checkMaNV(txtMaSP)&&Check.checkName(txtTenSP)&&Check.checkName(txtMauSac)&&Check.checkSo(txtGia)) {
            insertSP();
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        deleteSP();
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        if (Check.checkMaNV(txtMaSP)&&Check.checkName(txtTenSP)&&Check.checkName(txtMauSac)&&Check.checkSo(txtGia)) {
            updateSP();
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaTrangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaTrangActionPerformed
        // TODO add your handling code here:
        clearSP();
    }//GEN-LAST:event_btnXoaTrangActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        if (Check.checkName(txtTenSPTK)) {
            searchSP();
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void lblHinhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHinhMouseClicked
        // TODO add your handling code here:
        this.chonAnh();
    }//GEN-LAST:event_lblHinhMouseClicked

    private void tblSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamMouseClicked
        // TODO add your handling code here:
//        if (evt.getClickCount() == 1) {
//            this.index = tblSanPham.rowAtPoint(evt.getPoint()); //lấy vị trí dòng được chọn
//            if (this.index >= 0) {
//                this.editSP();
//                tab1.setSelectedIndex(0);
//            }
//        }
        if (evt.getClickCount() == 1) {
            this.row = tblSanPham.getSelectedRow();
            this.editSP();
            tab1.setSelectedIndex(0);
        }
    }//GEN-LAST:event_tblSanPhamMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnSua1;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThem1;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnXoa1;
    private javax.swing.JButton btnXoaTrang;
    private javax.swing.JButton btnXoatrang1;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbbMaTH;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblHinh;
    private javax.swing.JRadioButton rdoCon;
    private javax.swing.JRadioButton rdoHet;
    private javax.swing.JTabbedPane tab1;
    private javax.swing.JTable tblSanPham;
    private javax.swing.JTable tblThuongHieu;
    private javax.swing.JTextArea txaCauHinh;
    private javax.swing.JTextField txtGia;
    private javax.swing.JTextField txtMaSP;
    private javax.swing.JTextField txtMaThuongHieu;
    private javax.swing.JTextField txtMauSac;
    private javax.swing.JTextField txtTenSP;
    private javax.swing.JTextField txtTenSPTK;
    private javax.swing.JTextField txtTenThuongHieu;
    // End of variables declaration//GEN-END:variables

}
