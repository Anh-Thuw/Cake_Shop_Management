package PartyShopManagerThuQuynh;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class LoginWithCus extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeCustomer frame = new HomeCustomer();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginWithCus() {
		setForeground(new Color(128, 0, 0));
		this.setTitle("LOGIN CUSTOMER");
		this.setIconImage((Toolkit.getDefaultToolkit().createImage(Login.class.getResource("/Image/INFO.png"))));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 546, 553);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(193, 193, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel(new ImageIcon( new ImageIcon(
				Toolkit.getDefaultToolkit().getImage(
						LoginWithCus.class.getResource("/Image/smile.gif")
						)
				).getImage().getScaledInstance(149, 106, Image.SCALE_DEFAULT)));
		lblNewLabel.setBounds(169, 11, 149, 106);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Login with your account!");
		lblNewLabel_1.setFont(new Font("Tempus Sans ITC", Font.BOLD, 20));
		lblNewLabel_1.setBounds(128, 114, 243, 34);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Do not have an account? Come to ");
		lblNewLabel_1_1.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_1_1.setBounds(99, 472, 255, 34);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("--->");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_2.setBounds(348, 470, 49, 34);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Sign Up");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				SignUp si = null;
				try {
					si = new SignUp();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			si.setVisible(true);
			}
		});
		btnNewButton.setForeground(new Color(255, 0, 0));
		btnNewButton.setBackground(new Color(193, 193, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.ITALIC, 11));
		btnNewButton.setBounds(407, 480, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_3_1 = new JLabel("User Name:");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3_1.setBounds(47, 187, 119, 34);
		contentPane.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("Password:");
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3_2.setBounds(47, 246, 107, 34);
		contentPane.add(lblNewLabel_3_2);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(184, 188, 243, 41);
		contentPane.add(textField_1);
		
		JButton btnNewButton_1 = new JButton("Login");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ten = textField_1.getText();
				String mk = getPass(passwordField.getPassword());		
			    String chucVu =checkDangNhap(ten, mk);
			
				if ( chucVu.equals("User")){
					HomeCustomer frame = new HomeCustomer();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					
					textField_1.setText("");
					passwordField.setText("");
				}
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_1.setForeground(new Color(128, 0, 0));
		btnNewButton_1.setBackground(new Color(255, 255, 185));
		btnNewButton_1.setBounds(389, 354, 107, 41);
		contentPane.add(btnNewButton_1);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Show Password");
		chckbxNewCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ( chckbxNewCheckBox.isSelected()) {
					passwordField.setEchoChar((char)0);
				}else {
					passwordField.setEchoChar('*');
				}
			}
		});
		chckbxNewCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 13));
		chckbxNewCheckBox.setBackground(new Color(193, 193, 255));
		chckbxNewCheckBox.setBounds(184, 299, 159, 23);
		contentPane.add(chckbxNewCheckBox);
		
		JButton btnNewButton_1_1 = new JButton("Exit");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Home ho = new Home();
				ho.setVisible(true);
			}
		});
		btnNewButton_1_1.setForeground(new Color(128, 0, 0));
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_1_1.setBackground(new Color(255, 255, 185));
		btnNewButton_1_1.setBounds(10, 467, 81, 41);
		contentPane.add(btnNewButton_1_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(184, 247, 243, 41);
		contentPane.add(passwordField);
		
		JButton btnNewButton_1_1_1 = new JButton("Forget Password");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1_1_1.setForeground(new Color(128, 0, 0));
		btnNewButton_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_1_1_1.setBackground(new Color(255, 255, 185));
		btnNewButton_1_1_1.setBounds(10, 354, 226, 41);
		contentPane.add(btnNewButton_1_1_1);
		
		

	}
	private String checkDangNhap(String ten, String mk) {
		String chucVu = "";
         Connection con ;
		try {
			con = DataSQL.getConnection();
			String sql = "select Password,Position from Users where Username = ? ";
			PreparedStatement pre = con.prepareStatement(sql);
			pre.setString(1, ten);
			ResultSet rs = pre.executeQuery();
			if (rs.next()) {
				if (mk.equals(rs.getString("Password"))) {
					chucVu = rs.getString("Position");
				} else {
					JOptionPane.showMessageDialog(null, "Wrong password !");
				}
			} else {
				JOptionPane.showMessageDialog(null, "No exits this account!");
			}

		} catch (Exception e) {
//e.printStackTrace();
			JOptionPane.showMessageDialog(null, "test 2 ");
		}
		return chucVu;

	}
	public String getPass(char[] pass) {
		String p = "";
		for (char x:pass) {
			p+= x;
		}
		return p;
	}

}
