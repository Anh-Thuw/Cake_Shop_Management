package PartyShopManagerThuQuynh;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import SavePartyShopManager.SaveUser;


public class SignUp extends JFrame {

	private JPanel contentPane;
	private JTextField txtname;
	private JTextField txtPhone;
	private JTextField txtemail;
	private JTextField txtpass5;
	private Color panel;
	private JTextField txtsex;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1, checkNewPass;
	private JTextField txtcccd;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp frame = new SignUp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	public SignUp() throws ParseException {
		setForeground(new Color(128, 0, 0));
		this.setTitle("SIGN UP");
		URL MainIcon = SignUp.class.getResource("/Image/INFO.png");
		Image img = Toolkit.getDefaultToolkit().createImage(MainIcon);
		this.setIconImage(img);
		
		setFont(new Font("Tahoma", Font.BOLD, 25));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 989, 689);
		setSize(989,689);
		setResizable(false);
		getContentPane().setLayout(null);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(182, 182, 254));
		contentPane.setForeground(new Color(128, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("A. USER INFORMATION ");
		lblNewLabel.setBounds(339, 25, 532, 47);
		lblNewLabel.setForeground(new Color(118, 54, 224));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(10, 25, 272, 184);
		contentPane.add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(SignUp.class.getResource("/Image/INFO.png"))));
		
		JLabel lblNewLabel_2 = new JLabel("Full Name:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(349, 83, 102, 47);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_6 = new JLabel("Email:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_6.setBounds(349, 283, 70, 47);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_3 = new JLabel("Sex:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(349, 133, 112, 47);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("CCCD:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(349, 183, 84, 47);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Phone:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_5.setBounds(349, 233, 97, 47);
		contentPane.add(lblNewLabel_5);
		
		txtname = new JTextField();
		txtname.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtname.setBounds(472, 83, 418, 40);
		contentPane.add(txtname);
		txtname.setColumns(10);
		
		txtPhone = new JTextField();
		txtPhone.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtPhone.setColumns(10);
		txtPhone.setBounds(472, 233, 418, 40);
		contentPane.add(txtPhone);
		
		txtemail = new JTextField();
		txtemail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtemail.setColumns(10);
		txtemail.setBounds(472, 283, 418, 40);
		contentPane.add(txtemail);
		
		JLabel lblNewLabel_7 = new JLabel("B. START CREATING AN ACCOUNT");
		lblNewLabel_7.setForeground(new Color(118, 54, 224));
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_7.setBounds(59, 341, 532, 47);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Enter user name:");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_8.setBounds(67, 399, 181, 47);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Enter the password:");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_9.setBounds(67, 449, 202, 47);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Re-enter the password:");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_10.setBounds(67, 499, 215, 47);
		contentPane.add(lblNewLabel_10);
		
		txtpass5 = new JTextField();
		txtpass5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtpass5.setColumns(10);
		txtpass5.setBounds(293, 399, 520, 40);
		contentPane.add(txtpass5);
		
		JButton btnNewButton_1 = new JButton("Boy");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sex1();
	
			}});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.setBounds(690, 133, 97, 40);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_2 = new JButton("Girl");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sex2();
			}
		});
		btnNewButton_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1_2.setBounds(793, 133, 97, 40);
		contentPane.add(btnNewButton_1_2);
		
		txtsex = new JTextField();
		txtsex.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtsex.setColumns(10);
		txtsex.setBounds(472, 133, 208, 40);
		contentPane.add(txtsex);
		
		JButton btnClean = new JButton("CLEAN");
		btnClean.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand()== "CLEAN") {
					Clean();
				}
			}
		});
		btnClean.setForeground(new Color(128, 0, 0));
		btnClean.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnClean.setBackground(Color.RED);
		btnClean.setBounds(369, 595, 236, 47);
		contentPane.add(btnClean);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		passwordField.setBounds(293, 449, 520, 40);
		contentPane.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		passwordField_1.setBounds(293, 499, 520, 40);
		contentPane.add(passwordField_1);
		
		JButton btnSignUp = new JButton("SIGN UP");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			findUser();
				SaveUser user = new SaveUser();
				user.setName(txtname.getText());
				user.setSex(txtsex.getText());
				user.setCccd(Long.parseLong(txtcccd.getText()));
				user.setPhone(Long.parseLong(txtPhone.getText()));
				user.setEmail(txtemail.getText());
				user.setUsername(txtpass5.getText());
				newUser(user);
				Clean();
				
				setVisible(false);
				Home ho = new Home();
				ho.setVisible(true);
			}
		});
		btnSignUp.setForeground(new Color(0, 0, 255));
		btnSignUp.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnSignUp.setBackground(new Color(128, 255, 255));
		btnSignUp.setBounds(712, 595, 236, 47);
		contentPane.add(btnSignUp);
		
		txtcccd = new JTextField();
		txtcccd.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtcccd.setColumns(10);
		txtcccd.setBounds(472, 183, 418, 40);
		contentPane.add(txtcccd);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Home ho = new Home();
				ho.setVisible(true);
			}
		});
		btnExit.setForeground(new Color(128, 0, 0));
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnExit.setBackground(Color.RED);
		btnExit.setBounds(43, 595, 236, 47);
		contentPane.add(btnExit);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Show Password");
		chckbxNewCheckBox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(chckbxNewCheckBox.isSelected()) {
					passwordField.setEchoChar((char)0);
					passwordField_1.setEchoChar((char)0);
				} else {
					passwordField.setEchoChar('*');
					passwordField_1.setEchoChar('*');
				}
			}
		});
		chckbxNewCheckBox.setBackground(new Color(192, 192, 192));
		chckbxNewCheckBox.setFont(new Font("Tahoma", Font.ITALIC, 17));
		chckbxNewCheckBox.setBounds(293, 555, 175, 21);
		contentPane.add(chckbxNewCheckBox);

		
		checkNewPass = new JPasswordField();
		checkNewPass.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
	}
	public void Sex1() {
		txtsex.setText("Boy");
	}
	public void Sex2() {
		txtsex.setText("Girl");
	}
	
	public void Clean() {
		txtname.setText("");
		txtsex.setText("");
		txtcccd.setText("");
		txtPhone.setText("");
		txtemail.setText("");
		txtpass5.setText("");
		passwordField.setText("");
		passwordField_1.setText("");
	}
	//
	private void  findUser() {
		SaveUser user = new SaveUser();
		try {
			 Connection con = DataSQL.getConnection();
			String sql = " select * from Users where Username = '" + user.getUsername() +"'";
			PreparedStatement pre = con.prepareStatement(sql);
			ResultSet rs = pre.executeQuery();
			if(rs.next()) {
				JOptionPane.showMessageDialog(null, " Account exists !");
				
			}
			if (!getPass(passwordField.getPassword()).equals(getPass(passwordField_1.getPassword()))) {
				JOptionPane.showMessageDialog(null, "Wrong password !");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}
	//theem mot khach hang nmoi
	private  boolean newUser( SaveUser user ) {
		
		try {
			Connection con = DataSQL.getConnection();
			String sql = " insert into Users(Username,Password,Name,Sex,Cccd,Phone,Email,Position) values (?,?,?,?,?,?,?,?)";
			PreparedStatement pre = con.prepareStatement(sql);
			pre.setString(1, user.getUsername());
			pre.setString(2, getPass(passwordField.getPassword()));
			pre.setString(3, user.getName());
			pre.setString(4, user.getSex());
			pre.setLong(5, user.getCccd());
			pre.setLong(6, user.getPhone());
			pre.setString(7, user.getEmail());
			pre.setString(8, "User");
			return pre.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	//
	public String getPass(char[] pass) {
		String p = "";
		for (char x:pass) {
			p+= x;
		}
		return p;
	}
}
