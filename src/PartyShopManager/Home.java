package PartyShopManagerThuQuynh;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Home extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
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
	public Home() {
		setForeground(new Color(128, 0, 0));
		setTitle("HOME");
		URL MainIcon = SignUp.class.getResource("/Image/Home.jpg");
		Image img = Toolkit.getDefaultToolkit().createImage(MainIcon);
		this.setIconImage(img);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 989, 689);
		setSize(989, 689);
		setResizable(false);
		getContentPane().setLayout(null);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Login lo = new Login();
				lo.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton.setForeground(new Color(128, 0, 0));
		btnNewButton.setBackground(new Color(255, 199, 142));
		btnNewButton.setBounds(131, 341, 206, 53);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("SIGN UP");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				SignUp si = null;
				try {
					si = new SignUp();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
//				try {
//					si = new SignUp();
//				} catch (ParseException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
			si.setVisible(true);
			}
		});
		btnNewButton_1.setForeground(new Color(128, 0, 0));
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton_1.setBackground(new Color(255, 199, 142));
		btnNewButton_1.setBounds(131, 256, 206, 53);
		contentPane.add(btnNewButton_1);
		
		JButton btnIntroduce = new JButton("INTRODUCE");
		btnIntroduce.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//setVisible(false);
				Introduce in = new Introduce();
				in.setVisible(true);
			}
		});
		btnIntroduce.setForeground(new Color(128, 0, 0));
		btnIntroduce.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnIntroduce.setBackground(new Color(255, 199, 142));
		btnIntroduce.setBounds(131, 426, 206, 53);
		contentPane.add(btnIntroduce);
		
		JLabel lblNewLabel_1 = new JLabel(new ImageIcon( new ImageIcon(
				Toolkit.getDefaultToolkit().getImage(
						Home.class.getResource("/Image/Poster.png")
						)
				).getImage().getScaledInstance(989, 652, Image.SCALE_DEFAULT)));
		lblNewLabel_1.setBounds(0, 0, 989, 652);
		//lblNewLabel_1.setSize(1400, 500);
		contentPane.add(lblNewLabel_1);
		
	}

}
