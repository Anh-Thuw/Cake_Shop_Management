package mvc;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class changePass extends JFrame {

	private JPanel contentPane;
	private JPasswordField checkNewPass;
	private JPasswordField oldPass;
	private JPasswordField newPass;
	private JCheckBox checkPass;
	private String StringOldPass;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public changePass(String username) {
		StringOldPass = null;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 425);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbChucVu = new JLabel("New label");
		lbChucVu.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbChucVu.setBounds(10, 39, 162, 50);
		contentPane.add(lbChucVu);
		
		JLabel lbName = new JLabel("New label");
		lbName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbName.setBounds(182, 39, 255, 50);
		contentPane.add(lbName);
		try {
			Connection connection = Data.getConnection();
			String sql = "select * from login where tendangnhap = ?";
			PreparedStatement pre = connection.prepareStatement(sql);
			pre.setString(1, username);
			ResultSet rs = pre.executeQuery();
			if(rs.next()) {
				lbChucVu.setText(rs.getString("chucvu"));
				lbName.setText(rs.getString("tendangnhap"));
				StringOldPass = rs.getString("matkhau");
				
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		JPanel panel = new JPanel();
		panel.setBounds(20, 100, 172, 198);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(3, 1, 0, 20));
		
		JLabel lblNewLabel_3 = new JLabel("pass odl ");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_2 = new JLabel("pass new");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("confirm pass new");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblNewLabel_4);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(202, 100, 292, 198);
		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(3, 1, 0, 20));
		
		oldPass = new JPasswordField();
		oldPass.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_1.add(oldPass);
		
		newPass = new JPasswordField();
		newPass.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_1.add(newPass);
		
		checkNewPass = new JPasswordField();
		checkNewPass.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_1.add(checkNewPass);
		
		oldPass.setEchoChar('*');
		newPass.setEchoChar('*');
		checkNewPass.setEchoChar('*');
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("show password");
		chckbxNewCheckBox_1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(chckbxNewCheckBox_1.isSelected()) {
					oldPass.setEchoChar((char)0);
					newPass.setEchoChar((char)0);
					checkNewPass.setEchoChar((char)0);
				} else {
					oldPass.setEchoChar('*');
					newPass.setEchoChar('*');
					checkNewPass.setEchoChar('*');
				}
			}
		});
		chckbxNewCheckBox_1.setBounds(202, 305, 190, 23);
		contentPane.add(chckbxNewCheckBox_1);
		
		JButton btnNewButton = new JButton("Change Pass ");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(StringOldPass.equals(oldPass.getText())) {
					if(newPass.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "input pass new");
					} else {
						if(newPass.getText().equals(checkNewPass.getText())) {
							if(JOptionPane.showConfirmDialog(null, "pass new ") == JOptionPane.YES_OPTION) {
								try {
									Connection connection = Data.getConnection();
									String sql = "update login set matkhau = ? where tendangnhap = ?";
									PreparedStatement pre = connection.prepareStatement(sql);
									pre.setString(1, newPass.getText());
									pre.setString(2, username);
									if(pre.executeUpdate() > 0) {
										JOptionPane.showMessageDialog(null, "change pass successful");
										oldPass.setText("");
										newPass.setText("");
										checkNewPass.setText("");
										setVisible(false);
									}
									
								} catch (Exception e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							}
						} else {
							JOptionPane.showMessageDialog(null, "ok !!!!!");
						}
					}
				} else {
					JOptionPane.showMessageDialog(null, "pass error !!!!!");
				}
			}
		});
		btnNewButton.setBounds(264, 335, 121, 40);
		contentPane.add(btnNewButton);
		
		
	}
	public static void main(String[] args) {
		changePass frame = new changePass("gv111");
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}
	
}
