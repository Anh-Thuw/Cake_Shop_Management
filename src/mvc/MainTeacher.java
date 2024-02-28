package mvc;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class MainTeacher extends JFrame {

	private JPanel contentPane;
	private JTextField txtNamSinh;
	private JTextField txtMaGiangVien;
	private JTextField txtHoTen;
	private JTextField txtMonHoc;
	private JTextField txtSDT;
	private JTextField txtDiaChi;
	private JLabel lblNewLabel_1;

	public MainTeacher(String maGiangVien) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(180, 72, 173, 256);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(6, 1,0, 10));
		
		JLabel lblNewLabel_2 = new JLabel("Code teacher");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(lblNewLabel_2);
		
		lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_4 = new JLabel("Date");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_3 = new JLabel("SDT");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_6 = new JLabel("Address");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_5 = new JLabel("Subject");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_5);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(363, 72, 251, 256);
		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(6, 1, 0, 10));
		
		txtMaGiangVien = new JTextField();
		txtMaGiangVien.setEditable(false);
		panel_1.add(txtMaGiangVien);
		txtMaGiangVien.setColumns(10);
		
		txtHoTen = new JTextField();
		txtHoTen.setEditable(false);
		panel_1.add(txtHoTen);
		txtHoTen.setColumns(10);
		
		txtNamSinh = new JTextField();
		txtNamSinh.setEditable(false);
		panel_1.add(txtNamSinh);
		txtNamSinh.setColumns(10);
		
		txtSDT = new JTextField();
		txtSDT.setEditable(false);
		panel_1.add(txtSDT);
		txtSDT.setColumns(10);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setEditable(false);
		panel_1.add(txtDiaChi);
		txtDiaChi.setColumns(10);
		
		txtMonHoc = new JTextField();
		txtMonHoc.setEditable(false);
		panel_1.add(txtMonHoc);
		txtMonHoc.setColumns(10);
		
		JLabel lbImage = new JLabel("");
		lbImage.setBounds(10, 72, 148, 176);
		contentPane.add(lbImage);
		
		JButton btnNewButton = new JButton("logout");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton.setBounds(10, 300, 135, 40);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("password");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changePass frame = new changePass(maGiangVien);
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
			}
		});
		btnNewButton_1.setBounds(10, 259, 96, 30);
		contentPane.add(btnNewButton_1);
		
		JLabel lbChucVu = new JLabel("Chuc vu");
		lbChucVu.setHorizontalAlignment(SwingConstants.CENTER);
		lbChucVu.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbChucVu.setBounds(10, 11, 96, 30);
		contentPane.add(lbChucVu);
		
		JLabel lbHoTen = new JLabel("Name");
		lbHoTen.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbHoTen.setBounds(116, 11, 214, 30);
		contentPane.add(lbHoTen);
		
		try {
			Connection connection = Data.getConnection();
			String sql = "select * from Teacher where magiangvien = ?";
			PreparedStatement pre= connection.prepareStatement(sql);
			pre.setString(1, maGiangVien);
			ResultSet rs = pre.executeQuery();
			if(rs.next()) {
				txtNamSinh.setText(rs.getString("namsinh"));
				txtMaGiangVien.setText(rs.getString("magiangvien"));
				txtHoTen.setText(rs.getString("hoten"));
				txtMonHoc.setText(rs.getString("mon"));
				txtSDT.setText(rs.getString("sdt"));
				txtDiaChi.setText(rs.getString("sdt"));
				ImageIcon img = new ImageIcon(new ImageIcon(rs.getBytes("anh")).getImage().getScaledInstance(lbImage.getWidth(), lbImage.getHeight(), Image.SCALE_SMOOTH));
				lbImage.setIcon(img);
				lblNewLabel_1.setText(rs.getString("hoten"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		}	
	}
		public static void main(String[] args) {
			MainTeacher frame = new MainTeacher("gv002");
			frame.setVisible(true);
			frame.setLocationRelativeTo(null);
	}
	
	
}
