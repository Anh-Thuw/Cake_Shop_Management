package mvc;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainStudent extends JFrame {

	private JPanel contentPane;
	private JTextField txtMaSinhVien;
	private JTextField txtHoTen;
	private JTextField txtSDT;
	private JTextField txtNamSinh;
	private JTextField txtDiaChi;
	private JTextField txtJava;
	private JTextField txtPython;
	private JTextField txtSql;

	/**
	 * Launch the application.
	
	/**
	 * Create the frame.
	 */
	public MainStudent(String maSinhVien) {
	//	public MainStudent() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 670, 415);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbImage = new JLabel("");
		lbImage.setBounds(10, 11, 186, 202);
		contentPane.add(lbImage);
		
		JButton btnNewButton = new JButton("Dang xuat");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton.setBounds(10, 331, 145, 34);
		contentPane.add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBounds(206, 11, 186, 339);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(9, 1, 0, 5));
		
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
		
		JLabel lblNewLabel_4 = new JLabel("Date");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_3 = new JLabel("Address");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_5 = new JLabel("JAVA");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_8 = new JLabel("PYTHON");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("SQL");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_9);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(402, 11, 242, 339);
		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(9, 1, 0, 5));
		
		txtMaSinhVien = new JTextField();
		txtMaSinhVien.setEditable(false);
		panel_1.add(txtMaSinhVien);
		txtMaSinhVien.setColumns(10);
		
		txtHoTen = new JTextField();
		txtHoTen.setEditable(false);
		panel_1.add(txtHoTen);
		txtHoTen.setColumns(10);
		
		txtSDT = new JTextField();
		txtSDT.setEditable(false);
		panel_1.add(txtSDT);
		txtSDT.setColumns(10);
		
		txtNamSinh = new JTextField();
		txtNamSinh.setEditable(false);
		panel_1.add(txtNamSinh);
		txtNamSinh.setColumns(10);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setEditable(false);
		panel_1.add(txtDiaChi);
		txtDiaChi.setColumns(10);
		
		txtJava = new JTextField();
		txtJava.setEditable(false);
		panel_1.add(txtJava);
		txtJava.setColumns(10);
		
		txtPython = new JTextField();
		txtPython.setEditable(false);
		panel_1.add(txtPython);
		txtPython.setColumns(10);
		
		txtSql = new JTextField();
		txtSql.setEditable(false);
		panel_1.add(txtSql);
		txtSql.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Password");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changePass frame = new changePass(maSinhVien);
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_1.setBounds(10, 286, 145, 34);
		contentPane.add(btnNewButton_1);
		
		try {
			Connection connection = Data.getConnection();
			String sql = "select * from Student where masinhvien = ?";
			PreparedStatement pre = connection.prepareStatement(sql);
			pre.setString(1, maSinhVien);
			ResultSet rs = pre.executeQuery();
			if(rs.next()) {
				txtMaSinhVien.setText(rs.getString("masinhvien"));
				txtHoTen.setText(rs.getString("hoten"));
				txtSDT.setText(rs.getString("sdt"));
				txtNamSinh.setText(rs.getString("namsinh"));
				txtDiaChi.setText(rs.getString("diachi"));
				txtJava.setText(rs.getString("java"));
				txtPython.setText(rs.getString("python"));
				txtSql.setText(rs.getString("sql"));
				ImageIcon img = new ImageIcon(new ImageIcon(rs.getBytes("anh")).getImage().getScaledInstance(lbImage.getWidth(), lbImage.getHeight(), Image.SCALE_SMOOTH));
				lbImage.setIcon(img);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}				
	}
	
	public static void main(String[] args) {
		MainStudent frame = new MainStudent("sv001");
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}

}
