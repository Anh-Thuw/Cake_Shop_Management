package mvc;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JCheckBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Login extends JFrame {
	private JPanel contentPane;
	private JTextField txtUserName;
	private JPasswordField txtPassword;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setResizable(false);
		setTitle("LOGIN");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 320);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOGIN TO THE SYSTEM");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 24, 424, 40);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("UserName:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(10, 105, 159, 30);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_2.setBounds(10, 165, 156, 30);
		contentPane.add(lblNewLabel_2);
		
		txtUserName = new JTextField();
		txtUserName.setFont(new Font("Tahoma", Font.PLAIN, 30));
		txtUserName.setBounds(179, 105, 255, 30);
		contentPane.add(txtUserName);
		txtUserName.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setEchoChar('*');
		txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 30));
		txtPassword.setBounds(179, 165, 255, 30);
		contentPane.add(txtPassword);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = txtUserName.getText();
				String password = txtPassword.getText();
				
				String chucVu = checkLogin(username,password);
				
				if(chucVu.equals("admin")) {
//					JOptionPane.showMessageDialog(null, "dang nhap voi tu cach admin");
					MainAdmin frame = new MainAdmin();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					txtUserName.setText("");
					txtPassword.setText("");
				} else if(chucVu.equals("Student")) {
//				JOptionPane.showMessageDialog(null, cai gi day");
					MainStudent frame = new MainStudent(username);
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					
					txtUserName.setText("");
					txtPassword.setText("");
				} else if (chucVu.equals("Teacher")){
//					JOptionPane.showMessageDialog(null, "Ä�Äƒng nháº­p vá»›i tÆ° cÃ¡ch giáº£ng viÃªn");
					MainNumber frame = new MainNumber(username);
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					
					txtUserName.setText("");
					txtPassword.setText("");
				} else {
					
				}
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnLogin.setBounds(133, 240, 150, 40);
		contentPane.add(btnLogin);
		// show password
		JCheckBox chckbxNewCheckBox = new JCheckBox("show password");
		
		chckbxNewCheckBox.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(chckbxNewCheckBox.isSelected()) {
					txtPassword.setEchoChar((char)0);
				} else {
					txtPassword.setEchoChar('*');
				}
			}
		});// the end chckbxNewCheckBox
		chckbxNewCheckBox.setBounds(179, 202, 159, 23);
		contentPane.add(chckbxNewCheckBox);
	}
	
	private String checkLogin(String username, String password) {
		String chucVu = "";
		
		Connection connection;
		try {
			connection = Data.getConnection();
			String sql = "select matkhau, chucvu from login where tendangnhap = ?";
			PreparedStatement pre = connection.prepareStatement(sql);
			pre.setString(1, username);
			ResultSet rs = pre.executeQuery();
			if(rs.next()) {
				if(password.equals(rs.getString("matkhau"))) {
					chucVu = rs.getString("chucvu");
				} else {
					JOptionPane.showMessageDialog(null, "pasword error");
				}
			} else {
				JOptionPane.showMessageDialog(null, "no exits this account");
			}
		} catch (Exception e) {
//			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "test 2 ");
		}
		return chucVu;
	}
}
