package mvc;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainNumber extends JFrame {
	private JPanel contentPane;
	private JTable table;
	private JTextField txtMaSinhVien;
	private JTextField txtDiem;
	private JTextField txtHoTenSinhVien;
	private JTextField txtMonHoc;
	private DefaultTableModel model;
	private String tenMon;
	private int row;
	public MainNumber(String username) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 683, 463);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextField txtHoTenGiaoVien = new JTextField("Há»� tÃªn giÃ¡o viÃªn");
		txtHoTenGiaoVien.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtHoTenGiaoVien.setEditable(false);
		txtHoTenGiaoVien.setBounds(120, 27, 207, 30);
		contentPane.add(txtHoTenGiaoVien);
		
		try {
			Connection connection = Data.getConnection();
			String sql = "select * from teacher where magiangvien = ?";
			PreparedStatement pre = connection.prepareStatement(sql);
			pre.setString(1, username);
			ResultSet rs = pre.executeQuery();
			
			if(rs.next()) {
				txtHoTenGiaoVien.setText(rs.getString("hoten"));
				
				tenMon = rs.getString("mon");
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		
		String[] head = new String[] {"MÃ£ sinh viÃªn","Há»� tÃªn",tenMon};
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				row = table.getSelectedRow();
				txtMaSinhVien.setText(table.getValueAt(row, 0).toString());
				txtDiem.setText(table.getValueAt(row, 2).toString());
				txtHoTenSinhVien.setText(table.getValueAt(row, 1).toString());
			}
		});
		table.setBounds(337, 79, 320, 334);
		model = new DefaultTableModel(head,0);
		model.addRow(head);
		loadInformation();
		table.setModel(model);
		contentPane.add(table);
		
		JLabel lblNewLabel = new JLabel("GiÃ¡o viÃªn");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(10, 27, 100, 30);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("ThÃ´ng tin cÃ¡ nhÃ¢n");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				MainTeacher frame = new MainTeacher(username);
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
			}
		});
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(538, 27, 119, 41);
		contentPane.add(lblNewLabel_2);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 79, 143, 228);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(4, 1, 0, 20));
		
		JLabel lblNewLabel_4 = new JLabel("MÃ£ sinh viÃªn");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_3 = new JLabel("Há»� tÃªn");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_5 = new JLabel("MÃ´n há»�c");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Ä�iá»ƒm");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_6);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(163, 79, 164, 228);
		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(4, 1, 0, 20));
		
		txtMaSinhVien = new JTextField();
		txtMaSinhVien.setEditable(false);
		panel_1.add(txtMaSinhVien);
		txtMaSinhVien.setColumns(10);
		
		txtHoTenSinhVien = new JTextField();
		txtHoTenSinhVien.setEditable(false);
		panel_1.add(txtHoTenSinhVien);
		txtHoTenSinhVien.setColumns(10);
		
		txtMonHoc = new JTextField(tenMon);
		txtMonHoc.setEditable(false);
		panel_1.add(txtMonHoc);
		txtMonHoc.setColumns(10);
		
		txtDiem = new JTextField();
		panel_1.add(txtDiem);
		txtDiem.setColumns(10);
		
		JButton btnNewButton = new JButton("Ä�Äƒng xuáº¥t");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBounds(0, 394, 110, 30);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Next");
		btnNewButton_1.setBounds(163, 331, 164, 52);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(row != -1) {
					if (update()) {
						loadInformation();
						row++;
						if(row < table.getRowCount()) {
							txtMaSinhVien.setText(table.getValueAt(row, 0).toString());
							txtDiem.setText(table.getValueAt(row, 2).toString());
							txtHoTenSinhVien.setText(table.getValueAt(row, 1).toString());
						} else {
							JOptionPane.showMessageDialog(null, "Ä�Ã£ hoÃ n táº¥t nháº­p Ä‘iá»ƒm cho sinh viÃªn");
							txtMaSinhVien.setText("");
							txtHoTenSinhVien.setText("");
							txtDiem.setText("");
						}
					} else {
						JOptionPane.showMessageDialog(null, "Nháº­p Ä‘iá»ƒm khÃ´ng thÃ nh cÃ´ng");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Báº¡n chÆ°a chá»�n sinh viÃªn Ä‘á»ƒ nháº­p Ä‘iá»ƒm");
				}
			}
		});
		
	}
	
	void loadInformation() {
		model.setRowCount(1);
		try {
			Connection connection = Data.getConnection();
			String sql = "select * from student";
			Statement sta = connection.createStatement();
			ResultSet rs = sta.executeQuery(sql);
			while(rs.next()) {
				Vector row = new Vector();
				row.add(rs.getString("masinhvien"));
				row.add(rs.getString("hoten"));
				row.add(rs.getString(tenMon));
				model.addRow(row);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	boolean update() {
		try {
			
			Connection connection = Data.getConnection();
			String sql = "update student set " +tenMon+" = ? where masinhvien = ?";
			PreparedStatement pre = connection.prepareStatement(sql);
			pre.setString(1, txtDiem.getText());
			pre.setString(2, txtMaSinhVien.getText());
			
//			JOptionPane.showMessageDialog(null, txtDiem.getText());
			return pre.executeUpdate() > 0;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} 
		
	}
}
