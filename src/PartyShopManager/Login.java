package PartyShopManagerThuQuynh;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



public class Login extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setForeground(new Color(128, 0, 0));
		this.setTitle("LOGIN");
		this.setIconImage((Toolkit.getDefaultToolkit().createImage(Login.class.getResource("/Image/INFO.png"))));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(164, 164, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Customer");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				LoginWithCus lowc = new LoginWithCus();
				lowc.setVisible(true);
			}
		});
		btnNewButton.setForeground(new Color(128, 0, 0));
		btnNewButton.setBackground(new Color(247, 205, 96));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnNewButton.setBounds(60, 54, 264, 63);
		contentPane.add(btnNewButton);
		
		JButton btnManager = new JButton("Manager");
		btnManager.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				LoginWithManager lowc = new LoginWithManager();
				lowc.setVisible(true);
			}
		});
		btnManager.setForeground(new Color(0, 111, 55));
		btnManager.setBackground(new Color(177, 242, 168));
		btnManager.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnManager.setBounds(60, 141, 264, 63);
		contentPane.add(btnManager);
	}

}
