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
import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class sanPhamInter extends javax.swing.JInternalFrame {

    thuongHieuDao dao = new thuongHieuDao();
    JFileChooser fileChooser = new JFileChooser();
    sanPhamDAO SPdao = new sanPhamDAO();
    String fileNamePic = "";
    int row = -1;
    int index = 0;

    public sanPhamInter() {
        initComponents();
        this.fillTable();
        this.fillTableSP();
        this.fillTableSP1();
        this.fillComboBox();
        tab1.setSelectedIndex(1);
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
            List<sanPham> lstSP = SPdao.XoaTamThoi();
//            for (int i = 0 ; i < lstSP.size(); i++) {
//                sanPham sp = lstSP.get(i);
//                Object[] row = new Object[] {
//                    i + 1,
//                    sp.getMaSanPham(),
//                    sp.getTenSanPham(),
//                    sp.getMauSac(),
//                    sp.isTrangThai() ? "Còn" : "Hết",
//                    sp.getGiaSanPham(),
//                    sp.getMaThuongHieu(),
//                    sp.getRam(),
//                    sp.getRom(),
//                    sp.getCamera(),
//                    sp.getScreenSize(),
//sp.getOs(),
//                    sp.getPixel(),
//                    sp.getHinhAnh(),};
//                modelSP.addRow(row);
//            }

            for (sanPham sp : lstSP) {
                Object[] row = {sp.getMaSanPham(),
                    sp.getTenSanPham(),
                    sp.getMauSac(),
                    sp.isTrangThai() ? "Còn" : "Hết",
                    sp.getGiaSanPham(),
                    sp.getMaThuongHieu(),
                    sp.getRam(),
                    sp.getRom(),
                    sp.getCamera(),
                    sp.getScreenSize(),
                    sp.getPixel(),
                    sp.getOs(),
                    sp.getHinhAnh(),};
                modelSP.addRow(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void fillTableSP1() {
        DefaultTableModel mol = (DefaultTableModel) tblLuuTru.getModel();
        mol.setRowCount(0);
        try {
            List<sanPham> list = SPdao.HienThiLai();
            for (sanPham sp : list) {
                Object[] row = {
                    sp.getMaSanPham(),
                    sp.getTenSanPham(),
                    sp.getMauSac(),
                    sp.isTrangThai() ? "Còn" : "Hết",
                    sp.getGiaSanPham(),
                    sp.getMaThuongHieu(),
                    sp.getRam(),
                    sp.getRom(),
                    sp.getCamera(),
                    sp.getScreenSize(),
                    sp.getPixel(),
                    sp.getOs(),
                    sp.getHinhAnh(),};
                mol.addRow(row);
            }
        } catch (Exception e) {
            dialogHelper.alert(this, "Lỗi truy vấn dữ liệu!");
            e.printStackTrace();
        }
    }

    void deleteTamThoi() {
        if (dialogHelper.confirm(this, "Bạn có muốn xóa sản phẩm này ?")) {
            try {
                String maSP = txtMaSP.getText();
                SPdao.delete(maSP);
                fillTableSP();
                fillTableSP1();
                clearSP();
                dialogHelper.alert(this, "Xóa thành công!");
            } catch (Exception e) {
                dialogHelper.alert(this, "Xóa thất bại!");
                e.printStackTrace();
            }
        }
    }

    void hienThiLai() {
        if (dialogHelper.confirm(this, "Bạn có muốn thêm lại sản phẩm này ?")) {
            try {
                int viTri = tblLuuTru.getSelectedRow();
                String maSP = tblLuuTru.getValueAt(viTri, 0).toString();
                SPdao.delete1(maSP);
                fillTableSP1();
                fillTableSP();
                dialogHelper.alert(this, "Thêm lại thành công!");
            } catch (Exception e) {
                dialogHelper.alert(this, "Thêm lại thất bại!");
                e.printStackTrace();
            }
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
        rdoHet.setSelected(!model.isTrangThai());
        txtGia.setText(Double.toString(model.getGiaSanPham()));
        cbbMaTH.getModel().setSelectedItem(model.getMaThuongHieu());
        txtRam.setText(model.getRam());
        txtRom.setText(model.getRom());
        txtCamera.setText(model.getCamera());
        txtDensity.setText(model.getPixel());
        txtScreenSize.setText(model.getScreenSize());
        txtOS.setText(model.getOs());
        txaMoTa.setText(model.getMoTa());
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
        sp.setMaSanPham(txtMaSP.getText());
        sp.setTenSanPham(txtTenSP.getText());
        sp.setMauSac(txtMauSac.getText());
        sp.setTrangThai(rdoCon.isSelected());
        sp.setGiaSanPham(Double.parseDouble(txtGia.getText()));
        sp.setMaThuongHieu(cbbMaTH.getSelectedItem().toString());
        sp.setRam(txtRam.getText());
        sp.setRom(txtRom.getText());
        sp.setCamera(txtCamera.getText());
        sp.setPixel(txtDensity.getText());
        sp.setScreenSize(txtScreenSize.getText());
        sp.setOs(txtOS.getText());
        sp.setMoTa(txaMoTa.getText());
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
        String maSP = (String) tblSanPham.getValueAt(this.row, 0);
        sanPham model = SPdao.selectById(maSP);
        this.setFormSP(model);
        this.updateStatusSP();
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
        try {
            SPdao.insert(model);
            this.fillTableSP();
            this.clearSP();
            dialogHelper.alert(this, "Thêm thành công");
        } catch (Exception e) {
            e.printStackTrace();
            dialogHelper.alert(this, "Thêm thất bại");
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
        } else if (checkTim() == 1) {
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

    int checkTim() {
        int kt = 0;
        List<sanPham> list = SPdao.selectAll();
        for (int i = 0; i < list.size(); i++) {
            sanPham sp = list.get(i);
            if (txtMaSP.getText().trim().equalsIgnoreCase(sp.getTenSanPham().trim())) {
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
                    sp.getRam(),
                    sp.getRom(),
                    sp.getCamera(),
                    sp.getScreenSize(),
                    sp.getPixel(),
                    sp.getOs(),
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
        btnGroupSort = new javax.swing.ButtonGroup();
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
        lblHinh = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        btnSua = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnXoaTrang = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtCamera = new javax.swing.JTextField();
        txtRam = new javax.swing.JTextField();
        txtScreenSize = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txtOS = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaMoTa = new javax.swing.JTextArea();
        jLabel22 = new javax.swing.JLabel();
        txtRom = new javax.swing.JTextField();
        txtDensity = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSanPham = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        txtTenSPTK = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        btnSearch = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        btnA_Z = new javax.swing.JRadioButton();
        btnZ_A = new javax.swing.JRadioButton();
        btnLowerPrice = new javax.swing.JRadioButton();
        btnHigherPrice = new javax.swing.JRadioButton();
        btnReset = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        btnHienThi = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblLuuTru = new javax.swing.JTable();
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

        jPanel4.setBackground(new java.awt.Color(204, 255, 204));
        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

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

        lblHinh.setBackground(new java.awt.Color(255, 255, 255));
        lblHinh.setForeground(new java.awt.Color(204, 204, 204));
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

        jPanel10.setBackground(new java.awt.Color(255, 153, 153));
        jPanel10.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel9.setText("Ram");

        jLabel16.setText("Camera");

        jLabel18.setText("Kích thước");

        jLabel15.setText("Bộ nhớ trong");

        jLabel17.setText("Độ phân giải");

        jLabel21.setText("Hệ điều hành");

        txaMoTa.setColumns(20);
        txaMoTa.setRows(5);
        jScrollPane1.setViewportView(txaMoTa);

        jLabel22.setText("Mô tả ");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(39, 39, 39)
                        .addComponent(txtRam, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel10Layout.createSequentialGroup()
                            .addComponent(jLabel16)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtCamera, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel10Layout.createSequentialGroup()
                            .addComponent(jLabel18)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtScreenSize, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(47, 47, 47)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel22)
                        .addGap(121, 121, 121))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jLabel21)
                                .addGap(18, 18, 18)
                                .addComponent(txtOS, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtRom, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDensity, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel10Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel15)
                            .addComponent(txtRam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtRom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(txtDensity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCamera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(txtScreenSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21)
                            .addComponent(txtOS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addGap(413, 413, 413))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(38, 38, 38)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbbMaTH, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(rdoCon, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                                .addComponent(rdoHet, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtTenSP)
                            .addComponent(txtMaSP)
                            .addComponent(txtMauSac)
                            .addComponent(txtGia, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(53, 53, 53)
                        .addComponent(lblHinh, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(311, 311, 311)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(cbbMaTH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblHinh, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel2)
                                            .addComponent(txtMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(27, 27, 27)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txtTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel3))
                                        .addGap(29, 29, 29)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txtMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel4))
                                        .addGap(29, 29, 29)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel6)
                                            .addComponent(rdoHet)
                                            .addComponent(rdoCon))
                                        .addGap(30, 30, 30)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel7)))))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(110, 110, 110)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel11)))
                .addGap(31, 31, 31)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(418, 418, 418)
                .addComponent(jLabel1)
                .addContainerGap(464, Short.MAX_VALUE))
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tab1.addTab("Sản phẩm", jPanel2);

        tblSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã SP", "Tên SP", "Màu Sắc", "Trạng Thái", "Giá", "Mã Thương Hiệu", "Ram", "Bộ nhớ trong", "Camera", "Màn hình", "Độ phân giải", "Hệ điều hành", "Hỉnh ảnh"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, false, false, false, true, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
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
                .addComponent(txtTenSPTK)
                .addGap(18, 18, 18)
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

        jLabel19.setText("Sắp xếp");

        btnGroupSort.add(btnA_Z);
        btnA_Z.setText("Tên từ A-Z");
        btnA_Z.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                btnA_ZItemStateChanged(evt);
            }
        });
        btnA_Z.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnA_ZActionPerformed(evt);
            }
        });

        btnGroupSort.add(btnZ_A);
        btnZ_A.setText("Tên từ Z-A");
        btnZ_A.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                btnZ_AItemStateChanged(evt);
            }
        });

        btnGroupSort.add(btnLowerPrice);
        btnLowerPrice.setText("Giá tăng dần");
        btnLowerPrice.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                btnLowerPriceItemStateChanged(evt);
            }
        });

        btnGroupSort.add(btnHigherPrice);
        btnHigherPrice.setText("Giá giảm dần");
        btnHigherPrice.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                btnHigherPriceItemStateChanged(evt);
            }
        });

        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 943, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnReset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(btnZ_A)
                                        .addComponent(btnA_Z)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addComponent(jLabel19)
                                            .addGap(17, 17, 17)))
                                    .addComponent(btnLowerPrice)
                                    .addComponent(btnHigherPrice))
                                .addGap(0, 11, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jLabel19)
                        .addGap(18, 18, 18)
                        .addComponent(btnA_Z)
                        .addGap(18, 18, 18)
                        .addComponent(btnZ_A)
                        .addGap(18, 18, 18)
                        .addComponent(btnLowerPrice)
                        .addGap(18, 18, 18)
                        .addComponent(btnHigherPrice)
                        .addGap(18, 18, 18)
                        .addComponent(btnReset)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 511, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        tab1.addTab("Danh sách", jPanel3);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 51));
        jLabel5.setText("THÔNG TIN LƯU TRỮ");

        btnHienThi.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnHienThi.setText("Hiển thị lại");
        btnHienThi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHienThiActionPerformed(evt);
            }
        });

        tblLuuTru.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã SP", "Tên SP", "Màu Sắc", "Trạng Thái", "Giá", "Mã Thương Hiệu", "Ram", "Bộ nhớ trong", "Camera", "Màn hình", "Độ phân giải", "Hệ điều hành", "Hỉnh ảnh"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tblLuuTru);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(413, 413, 413)
                .addComponent(jLabel5)
                .addContainerGap(482, Short.MAX_VALUE))
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnHienThi)))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 515, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnHienThi, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tab1.addTab("Lưu Trữ", jPanel9);

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
        jPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Tên Thương Hiệu:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Mã Thương Hiệu:");

        jPanel8.setBackground(new java.awt.Color(129, 183, 210));
        jPanel8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

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
                .addContainerGap(176, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 621, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
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
            .addComponent(tab1, javax.swing.GroupLayout.PREFERRED_SIZE, 671, Short.MAX_VALUE)
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
        if (Check.checkMaNV(txtMaSP)&&Check.checkName(txtTenSP)&&Check.checkName(txtMauSac)&&Check.checkSo1(txtGia)&&Check.checkNullText(txtRam)&&Check.checkNullText(txtRom)&Check.checkNullText(txtCamera)&&Check.checkNullText(txtDensity)&&Check.checkNullText(txtScreenSize)&&Check.checkNullText(txtOS)&&Check.checkNullText(txaMoTa)) {
            insertSP();
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        deleteTamThoi();
        tab1.setSelectedIndex(2);
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        if (Check.checkName(txtTenSP)&&Check.checkName(txtMauSac)&&Check.checkSo1(txtGia)&&Check.checkNullText(txtRam)&&Check.checkNullText(txtRom)&Check.checkNullText(txtCamera)&&Check.checkNullText(txtDensity)&&Check.checkNullText(txtScreenSize)&&Check.checkNullText(txtOS)&&Check.checkNullText(txaMoTa)) {
            updateSP();
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaTrangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaTrangActionPerformed
        // TODO add your handling code here:
        clearSP();
        fillComboBox();
    }//GEN-LAST:event_btnXoaTrangActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        if (Check.checkNullText(txtTenSPTK)) {
            searchSP();
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void lblHinhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHinhMouseClicked
        // TODO add your handling code here:
        this.chonAnh();
    }//GEN-LAST:event_lblHinhMouseClicked

    private void tblSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 1) {
//            this.index = tblSanPham.rowAtPoint(evt.getPoint()); //lấy vị trí dòng được chọn
//            if (this.index >= 0) {
//                this.editSP();
//                tab1.setSelectedIndex(0);
//            }

            this.row = tblSanPham.getSelectedRow();
            this.editSP();
            tab1.setSelectedIndex(0);
        }
    }//GEN-LAST:event_tblSanPhamMouseClicked

    private void btnHienThiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHienThiActionPerformed
        // TODO add your handling code here:
        hienThiLai();
        tab1.setSelectedIndex(1);
    }//GEN-LAST:event_btnHienThiActionPerformed

    private void btnA_ZItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_btnA_ZItemStateChanged
        DefaultTableModel mol = (DefaultTableModel) tblSanPham.getModel();
        mol.setRowCount(0);
        try {
            List<sanPham> list = SPdao.SortNameASC();
            for (sanPham sp : list) {
                Object[] row = {
                    sp.getMaSanPham(),
                    sp.getTenSanPham(),
                    sp.getMauSac(),
                    sp.isTrangThai() ? "Còn" : "Hết",
                    sp.getGiaSanPham(),
                    sp.getMaThuongHieu(),
                    sp.getRam(),
                    sp.getRom(),
                    sp.getCamera(),
                    sp.getScreenSize(),
                    sp.getPixel(),
                    sp.getOs(),
                    sp.getHinhAnh(),};
                mol.addRow(row);
            }
        } catch (Exception e) {
            dialogHelper.alert(this, "Lỗi truy vấn dữ liệu!");
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnA_ZItemStateChanged

    private void btnZ_AItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_btnZ_AItemStateChanged
       DefaultTableModel mol = (DefaultTableModel) tblSanPham.getModel();
        mol.setRowCount(0);
        try {
            List<sanPham> list = SPdao.SortNameDESC();
            for (sanPham sp : list) {
                Object[] row = {
                    sp.getMaSanPham(),
                    sp.getTenSanPham(),
                    sp.getMauSac(),
                    sp.isTrangThai() ? "Còn" : "Hết",
                    sp.getGiaSanPham(),
                    sp.getMaThuongHieu(),
                    sp.getRam(),
                    sp.getRom(),
                    sp.getCamera(),
                    sp.getScreenSize(),
                    sp.getPixel(),
                    sp.getOs(),
                    sp.getHinhAnh(),};
                mol.addRow(row);
            }
        } catch (Exception e) {
            dialogHelper.alert(this, "Lỗi truy vấn dữ liệu!");
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnZ_AItemStateChanged

    private void btnLowerPriceItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_btnLowerPriceItemStateChanged
        DefaultTableModel mol = (DefaultTableModel) tblSanPham.getModel();
        mol.setRowCount(0);
        try {
            List<sanPham> list = SPdao.SortPriceASC();
            for (sanPham sp : list) {
                Object[] row = {
                    sp.getMaSanPham(),
                    sp.getTenSanPham(),
                    sp.getMauSac(),
                    sp.isTrangThai() ? "Còn" : "Hết",
                    sp.getGiaSanPham(),
                    sp.getMaThuongHieu(),
                    sp.getRam(),
                    sp.getRom(),
                    sp.getCamera(),
                    sp.getScreenSize(),
                    sp.getPixel(),
                    sp.getOs(),
                    sp.getHinhAnh(),};
                mol.addRow(row);
            }
        } catch (Exception e) {
            dialogHelper.alert(this, "Lỗi truy vấn dữ liệu!");
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnLowerPriceItemStateChanged

    private void btnHigherPriceItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_btnHigherPriceItemStateChanged
        DefaultTableModel mol = (DefaultTableModel) tblSanPham.getModel();
        mol.setRowCount(0);
        try {
            List<sanPham> list = SPdao.SortPriceDECS();
            for (sanPham sp : list) {
                Object[] row = {
                    sp.getMaSanPham(),
                    sp.getTenSanPham(),
                    sp.getMauSac(),
                    sp.isTrangThai() ? "Còn" : "Hết",
                    sp.getGiaSanPham(),
                    sp.getMaThuongHieu(),
                    sp.getRam(),
                    sp.getRom(),
                    sp.getCamera(),
                    sp.getScreenSize(),
                    sp.getPixel(),
                    sp.getOs(),
                    sp.getHinhAnh(),};
                mol.addRow(row);
            }
        } catch (Exception e) {
            dialogHelper.alert(this, "Lỗi truy vấn dữ liệu!");
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnHigherPriceItemStateChanged

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here
        fillTableSP();
        btnGroupSort.clearSelection();

    }//GEN-LAST:event_btnResetActionPerformed

    private void btnA_ZActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnA_ZActionPerformed
        
    }//GEN-LAST:event_btnA_ZActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton btnA_Z;
    private javax.swing.ButtonGroup btnGroupSort;
    private javax.swing.JButton btnHienThi;
    private javax.swing.JRadioButton btnHigherPrice;
    private javax.swing.JRadioButton btnLowerPrice;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnSua1;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThem1;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnXoa1;
    private javax.swing.JButton btnXoaTrang;
    private javax.swing.JButton btnXoatrang1;
    private javax.swing.JRadioButton btnZ_A;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbbMaTH;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblHinh;
    private javax.swing.JRadioButton rdoCon;
    private javax.swing.JRadioButton rdoHet;
    private javax.swing.JTabbedPane tab1;
    private javax.swing.JTable tblLuuTru;
    private javax.swing.JTable tblSanPham;
    private javax.swing.JTable tblThuongHieu;
    private javax.swing.JTextArea txaMoTa;
    private javax.swing.JTextField txtCamera;
    private javax.swing.JTextField txtDensity;
    private javax.swing.JTextField txtGia;
    private javax.swing.JTextField txtMaSP;
    private javax.swing.JTextField txtMaThuongHieu;
    private javax.swing.JTextField txtMauSac;
    private javax.swing.JTextField txtOS;
    private javax.swing.JTextField txtRam;
    private javax.swing.JTextField txtRom;
    private javax.swing.JTextField txtScreenSize;
    private javax.swing.JTextField txtTenSP;
    private javax.swing.JTextField txtTenSPTK;
    private javax.swing.JTextField txtTenThuongHieu;
    // End of variables declaration//GEN-END:variables

}
