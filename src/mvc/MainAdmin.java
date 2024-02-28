package mvc;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainAdmin extends JFrame {
	private JPanel contentPane;
	private JTextField txtMaSinhVien;
	private JTextField txtHoTenSinhVien;
	private JTextField txtSDTSinhVien;
	private JTextField txtNamSinhSinhVien;
	private JTextField txtDiaChiSinhVien;
	private JTable tableStudent;
	private JTextField txtSDTGiangVien;
	private JTextField txtMaGiangVien;
	private JTextField txtHoTenGiangVien;
	private JTextField txtNamSinhGiangVien;
	private JTextField txtDiaChiGiangVien;
	private JTable tableTeacher;
	private DefaultTableModel modelStudent, modelTeacher;
	private String fileNameStudent = null;
	private String fileNameTeacher = null;
	private JComboBox comboBoxMonHoc;
	
	
	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public MainAdmin() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1078, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 1043, 336);
		contentPane.add(tabbedPane);
		
		JPanel panelStudent = new JPanel();
		tabbedPane.addTab("Student", null, panelStudent, null);
		panelStudent.setLayout(null);
		//
		
		
		JLabel lbImageStudent = new JLabel("");
		lbImageStudent.setBounds(10, 11, 158, 203);
		panelStudent.add(lbImageStudent);
		
		
		
		JPanel panel = new JPanel();
		panel.setBounds(178, 10, 185, 226);
		panelStudent.add(panel);
		panel.setLayout(new GridLayout(5, 1, 0, 5));
		
		JLabel lblNewLabel = new JLabel("code student");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_6 = new JLabel("SDT");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_4 = new JLabel("date");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_3 = new JLabel("test1");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(373, 10, 240, 226);
		panelStudent.add(panel_1);
		panel_1.setLayout(new GridLayout(5, 1, 0, 5));
		
		txtMaSinhVien = new JTextField();
		txtMaSinhVien.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_1.add(txtMaSinhVien);
		txtMaSinhVien.setColumns(10);
		
		txtHoTenSinhVien = new JTextField();
		txtHoTenSinhVien.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_1.add(txtHoTenSinhVien);
		txtHoTenSinhVien.setColumns(10);
		
		txtSDTSinhVien = new JTextField();
		txtSDTSinhVien.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_1.add(txtSDTSinhVien);
		txtSDTSinhVien.setColumns(10);
		
		txtNamSinhSinhVien = new JTextField();
		txtNamSinhSinhVien.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_1.add(txtNamSinhSinhVien);
		txtNamSinhSinhVien.setColumns(10);
		
		txtDiaChiSinhVien = new JTextField();
		txtDiaChiSinhVien.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_1.add(txtDiaChiSinhVien);
		txtDiaChiSinhVien.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(178, 244, 435, 47);
		panelStudent.add(panel_2);
		panel_2.setLayout(new GridLayout(1, 4, 10, 10));
		
		JButton btnFindStudent = new JButton("find");
		btnFindStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String maSinhVien = txtMaSinhVien.getText();
				if(maSinhVien.equals("")) {
					JOptionPane.showMessageDialog(null, "you no input code student");
				} else {
					XuLy xuLy = new XuLy();
					Student student = xuLy.findStudent(maSinhVien);
					if(student == null) {
						JOptionPane.showMessageDialog(null, "no find this student");
					} else {
						txtMaSinhVien.setText(student.getMaSV());
						txtHoTenSinhVien.setText(student.getHoTen());
						txtDiaChiSinhVien.setText(student.getDiaChi());
						txtNamSinhSinhVien.setText(student.getNamSinh());
						txtSDTSinhVien.setText(student.getSdt());
						ImageIcon img = new ImageIcon(new ImageIcon(student.getAnh()).getImage().getScaledInstance(lbImageStudent.getWidth(), lbImageStudent.getHeight(), Image.SCALE_SMOOTH));
						lbImageStudent.setIcon(img);
					}
				}
			}
		});
		btnFindStudent.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_2.add(btnFindStudent);
		
		JButton btnNewStudent = new JButton("insert");
		btnNewStudent.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, "you sure insert ?") == JOptionPane.YES_OPTION) {
					Student student = new Student();
					student.setHoTen(txtHoTenSinhVien.getText());
					student.setDiaChi(txtDiaChiSinhVien.getText());
					student.setNamSinh(txtNamSinhSinhVien.getText());
					student.setSdt(txtSDTSinhVien.getText());
					student.setMaSV(txtMaSinhVien.getText());
					student.setAnh(chuyenDoi(fileNameStudent));
					
					XuLy xuLy = new XuLy();
					if(xuLy.newStudent(student)) {
						JOptionPane.showMessageDialog(null, "insert successfull");
						clearStudent();
						loadInformationStudent();
					} else {
						JOptionPane.showMessageDialog(null, "test 2");
					}
				}
			}
		});
		panel_2.add(btnNewStudent);
		
		JButton btnUpdateStudent = new JButton("show");
		
		btnUpdateStudent.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnUpdateStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Update") == JOptionPane.YES_OPTION) {
					Student student = new Student();
					student.setHoTen(txtHoTenSinhVien.getText());
					student.setDiaChi(txtDiaChiSinhVien.getText());
					student.setNamSinh(txtNamSinhSinhVien.getText());
					student.setSdt(txtSDTSinhVien.getText());
					student.setMaSV(txtMaSinhVien.getText());
					
					XuLy xuLy = new XuLy();
					if(xuLy.updateStudent(student)) {
						JOptionPane.showMessageDialog(null, "Update successfull");
						clearStudent();
						loadInformationStudent();
					} else {
						JOptionPane.showMessageDialog(null, "Update error");
					}
				}
			}
		});
		panel_2.add(btnUpdateStudent);
		
		JButton btnDeleteStudent = new JButton("delete");
		btnDeleteStudent.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDeleteStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Delete ? ") == JOptionPane.YES_OPTION) {
					String maSinhVien = txtMaSinhVien.getText();
					XuLy xuLy = new XuLy();
					if(xuLy.deleteStudent(maSinhVien)) {
						JOptionPane.showMessageDialog(null, "Delete Ok");
						clearStudent();
						loadInformationStudent();
					} else {
						JOptionPane.showMessageDialog(null, "Delete error ");
					}
				}
			}
		});
		panel_2.add(btnDeleteStudent);
		
		tableStudent = new JTable();
		tableStudent.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int row = tableStudent.getSelectedRow();
				String username = tableStudent.getValueAt(row, 0).toString();
				XuLy xuLy = new XuLy();
				
				Student student = xuLy.findStudent(username);
				if(student == null) {
					JOptionPane.showMessageDialog(null, "no find student");
				} else {
					txtMaSinhVien.setText(student.getMaSV());
					txtHoTenSinhVien.setText(student.getHoTen());
					txtDiaChiSinhVien.setText(student.getDiaChi());
					txtNamSinhSinhVien.setText(student.getNamSinh());
					txtSDTSinhVien.setText(student.getSdt());
					ImageIcon img = new ImageIcon(new ImageIcon(student.getAnh()).getImage().getScaledInstance(lbImageStudent.getWidth(), lbImageStudent.getHeight(), Image.SCALE_SMOOTH));
					lbImageStudent.setIcon(img);
				}
			}
		});
		tableStudent.setFont(new Font("Tahoma", Font.PLAIN, 13));
		tableStudent.setBounds(623, 11, 400, 280);
		
		
		
		
		
		
		String[] headStudent = new String[] {"code student","name","Address","SDT","date"};
		modelStudent = new DefaultTableModel(headStudent,0);
		modelStudent.addRow(headStudent);
		loadInformationStudent();
		
		tableStudent.setModel(modelStudent);
		panelStudent.add(tableStudent);
		
		
		
		
		JButton btnNewButton_1 = new JButton("insert picture");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				chooser.showOpenDialog(null);
			File f = chooser.getSelectedFile();
				fileNameStudent = f.getAbsolutePath();
				ImageIcon img = new ImageIcon(new ImageIcon(fileNameStudent).getImage().getScaledInstance(lbImageStudent.getWidth(), lbImageStudent.getHeight(), Image.SCALE_SMOOTH));
				lbImageStudent.setIcon(img);
				
			}
		});
		btnNewButton_1.setBounds(20, 225, 130, 32);
		panelStudent.add(btnNewButton_1);

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		JPanel panelTeacher = new JPanel();
		tabbedPane.addTab("Teacher", null, panelTeacher, null);
		panelTeacher.setLayout(null);
		
		JLabel lbImageTeacher = new JLabel("");
		lbImageTeacher.setBounds(10, 11, 162, 188);
		panelTeacher.add(lbImageTeacher);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(182, 11, 142, 249);
		panelTeacher.add(panel_3);
		panel_3.setLayout(new GridLayout(6, 1, 0, 10));
		
		JLabel lblNewLabel_7 = new JLabel("code teacher");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_3.add(lblNewLabel_7);
		
		JLabel lblNewLabel_5 = new JLabel("name");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_3.add(lblNewLabel_5);
		
		JLabel lblNewLabel_9 = new JLabel("SDT");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("date");
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_3.add(lblNewLabel_10);
		
		JLabel lblaCh = new JLabel("Address");
		lblaCh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblaCh.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblaCh);
		
		JLabel lblNewLabel_8 = new JLabel("suject");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_3.add(lblNewLabel_8);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(334, 11, 240, 249);
		panelTeacher.add(panel_4);
		panel_4.setLayout(new GridLayout(6, 1, 0, 10));
		
		txtMaGiangVien = new JTextField();
		txtMaGiangVien.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_4.add(txtMaGiangVien);
		txtMaGiangVien.setColumns(10);
		
		txtHoTenGiangVien = new JTextField();
		txtHoTenGiangVien.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_4.add(txtHoTenGiangVien);
		txtHoTenGiangVien.setColumns(10);
		
		txtSDTGiangVien = new JTextField();
		txtSDTGiangVien.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_4.add(txtSDTGiangVien);
		txtSDTGiangVien.setColumns(10);
		
		txtNamSinhGiangVien = new JTextField();
		txtNamSinhGiangVien.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_4.add(txtNamSinhGiangVien);
		txtNamSinhGiangVien.setColumns(10);
		
		txtDiaChiGiangVien = new JTextField();
		txtDiaChiGiangVien.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_4.add(txtDiaChiGiangVien);
		txtDiaChiGiangVien.setColumns(10);
		
		comboBoxMonHoc = new JComboBox();
		comboBoxMonHoc.setModel(new DefaultComboBoxModel(new String[] {"Java", "SQL", "Python"}));
		panel_4.add(comboBoxMonHoc);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(182, 262, 392, 35);
		panelTeacher.add(panel_5);
		panel_5.setLayout(new GridLayout(1, 4, 10, 0));
		
		JButton btnTimKiemGiangVien = new JButton("find");
		btnTimKiemGiangVien.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnTimKiemGiangVien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String maGiangVien = txtMaGiangVien.getText();
				XuLy xuLy = new XuLy();
				Teacher teacher = xuLy.findTeacher(maGiangVien);
				if(teacher == null) {
					JOptionPane.showMessageDialog(null, "KhÃ´ng tÃ¬m tháº¥y giáº£ng viÃªn");
				} else {
					txtMaGiangVien.setText(teacher.getMaGV());
					txtHoTenGiangVien.setText(teacher.getHoTen());
					txtDiaChiGiangVien.setText(teacher.getDiaChi());
					txtNamSinhGiangVien.setText(teacher.getNamSinh());
					txtSDTGiangVien.setText(teacher.getSdt());
					comboBoxMonHoc.setSelectedItem(teacher.getMon());
					ImageIcon img = new ImageIcon(new ImageIcon(teacher.getAnh()).getImage().getScaledInstance(lbImageTeacher.getWidth(), lbImageTeacher.getHeight(), Image.SCALE_SMOOTH));
					lbImageTeacher.setIcon(img);
				}
			}
		});
		panel_5.add(btnTimKiemGiangVien);
		
		JButton btnThemGiangVien = new JButton("Insert");
		btnThemGiangVien.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		btnThemGiangVien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Báº¡n cÃ³ cháº¯c cháº¯n muá»‘n thÃªm ? ") == JOptionPane.YES_OPTION) {
					Teacher teacher = new Teacher();
					teacher.setHoTen(fileNameStudent);
					teacher.setDiaChi(txtDiaChiGiangVien.getText());
					teacher.setNamSinh(txtNamSinhGiangVien.getText());
					teacher.setSdt(txtSDTGiangVien.getText());
					teacher.setMaGV(txtMaGiangVien.getText());
					teacher.setMon("Java");
					if(comboBoxMonHoc.getSelectedIndex() != -1) {
						teacher.setMon(comboBoxMonHoc.getSelectedItem().toString());
					}
					teacher.setAnh(chuyenDoi(fileNameTeacher));
					
					XuLy xuLy = new XuLy();
					if(xuLy.newTeacher(teacher)) {
						JOptionPane.showMessageDialog(null, "Ä�Ã£ thÃªm thÃ nh cÃ´ng");
						clearTeacher();
						loadInformationTeacher();
					} else {
						JOptionPane.showMessageDialog(null, "Ä�Ã£ tá»“n táº¡i sinh viÃªn nÃ y");
					}
				}
			}
		});
		panel_5.add(btnThemGiangVien);
		
		JButton btnSuaGiangVien = new JButton("Sá»­a");
		btnSuaGiangVien.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnSuaGiangVien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Báº¡n cÃ³ cháº¯c cháº¯n muá»‘n sá»§a ? ") == JOptionPane.YES_OPTION) {
					Teacher teacher = new Teacher();
					teacher.setHoTen(txtHoTenGiangVien.getText());
					teacher.setDiaChi(txtDiaChiGiangVien.getText());
					teacher.setNamSinh(txtNamSinhGiangVien.getText());
					teacher.setSdt(txtSDTGiangVien.getText());
					teacher.setMaGV(txtMaGiangVien.getText());
					teacher.setMon("Java");
					if(comboBoxMonHoc.getSelectedIndex() != -1) {
						teacher.setMon(comboBoxMonHoc.getSelectedItem().toString());
					}
					XuLy xuLy = new XuLy();
					if(xuLy.updateTeacher(teacher)) {
						JOptionPane.showMessageDialog(null, "successfull");
						clearTeacher();
						loadInformationTeacher();
					} else {
						JOptionPane.showMessageDialog(null, "error");
					}
				}
			}
		});
		panel_5.add(btnSuaGiangVien);
		
		JButton btnXoaGiangVien = new JButton("Delete");
		btnXoaGiangVien.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnXoaGiangVien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, "delete ? ") == JOptionPane.YES_OPTION) {
					String maGiangVien = txtMaGiangVien.getText();
					XuLy xuLy = new XuLy();
					if(xuLy.deleteTeacher(maGiangVien)) {
						JOptionPane.showMessageDialog(null, "error");
						clearTeacher();
						loadInformationTeacher();
					} else {
						JOptionPane.showMessageDialog(null, "error ");
					}
				}
			}
		});
		panel_5.add(btnXoaGiangVien);
		
		tableTeacher = new JTable();
		tableTeacher.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int row = tableTeacher.getSelectedRow();
				String username = tableTeacher.getValueAt(row, 0).toString();
				XuLy xuLy = new XuLy();
				Teacher teacher = xuLy.findTeacher(username);
				if(teacher == null) {
					JOptionPane.showMessageDialog(null, "no find teacher");
				} else {
					txtMaGiangVien.setText(teacher.getMaGV());
					txtHoTenGiangVien.setText(teacher.getHoTen());
					txtDiaChiGiangVien.setText(teacher.getDiaChi());
					txtNamSinhGiangVien.setText(teacher.getNamSinh());
					txtSDTGiangVien.setText(teacher.getSdt());
					comboBoxMonHoc.setSelectedItem(teacher.getMon());
					ImageIcon img = new ImageIcon(new ImageIcon(teacher.getAnh()).getImage().getScaledInstance(lbImageTeacher.getWidth(), lbImageTeacher.getHeight(), Image.SCALE_SMOOTH));
					lbImageTeacher.setIcon(img);
				}
				
			}
		});
		tableTeacher.setFont(new Font("Tahoma", Font.PLAIN, 13));
		tableTeacher.setBounds(584, 11, 444, 286);
		String[] headTeacher = new String[] {"code teacher","name","Address","SDT","date","test"};
		modelTeacher = new DefaultTableModel(headTeacher,0);
		modelTeacher.addRow(headTeacher);
		loadInformationTeacher();
		tableTeacher.setModel(modelTeacher);
		panelTeacher.add(tableTeacher);
		
		JButton btnNewButton_2 = new JButton("Chá»�n áº¢nh");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				chooser.showOpenDialog(null);
				File f = chooser.getSelectedFile();
				fileNameTeacher = f.getAbsolutePath();
				ImageIcon img = new ImageIcon(new ImageIcon(fileNameTeacher).getImage().getScaledInstance(lbImageTeacher.getWidth(), lbImageTeacher.getHeight(), Image.SCALE_SMOOTH));
				lbImageTeacher.setIcon(img);
				
			}
		});
		btnNewButton_2.setBounds(35, 210, 106, 35);
		panelTeacher.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Out");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton_3.setBounds(10, 358, 135, 30);
		contentPane.add(btnNewButton_3);
		
	}
	
	private byte[] chuyenDoi(String fileName) {
		FileInputStream fileInputStream= null;
		File file = new File(fileName);
		byte[] bFile = new byte[(int) file.length()];
		try {
			fileInputStream = new FileInputStream(file);
			fileInputStream.read(bFile);
			fileInputStream.close();
		} catch(Exception e) {
			bFile = null;
		}
		return bFile;
	}
	
	private void loadInformationStudent() {
		modelStudent.setRowCount(1);
		try {
			Connection connection = Data.getConnection();
			String sql = "select * from Student";
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				Vector row = new Vector();
				row.add(rs.getString("masinhvien"));
				row.add(rs.getString("hoten"));
				row.add(rs.getString("diachi"));
				row.add(rs.getString("namsinh"));
				row.add(rs.getString("sdt"));
				modelStudent.addRow(row);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}
	
	private void loadInformationTeacher() {
		modelTeacher.setRowCount(1);
		try {
			Connection connection = Data.getConnection();
			String sql = "select * from Teacher";
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				Vector row = new Vector();
				row.add(rs.getString("magiangvien"));
				row.add(rs.getString("hoten"));
				row.add(rs.getString("diachi"));
				row.add(rs.getString("namsinh"));
				row.add(rs.getString("sdt"));
				row.add(rs.getString("mon"));
				modelTeacher.addRow(row);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}
	
	void clearStudent() {
		txtMaSinhVien.setText("");
		txtHoTenSinhVien.setText("");
		txtDiaChiSinhVien.setText("");
		txtNamSinhSinhVien.setText("");
		txtSDTSinhVien.setText("");
	}
	
	void clearTeacher() {
		txtMaGiangVien.setText("");
		txtHoTenGiangVien.setText("");
		txtDiaChiGiangVien.setText("");
		txtNamSinhGiangVien.setText("");
		txtSDTGiangVien.setText("");
		comboBoxMonHoc.setSelectedItem("Java");
//		txtMonHoc.setText("");
	}
	
	public static void main(String[] args) {
		MainAdmin frame = new MainAdmin();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}
	
}
