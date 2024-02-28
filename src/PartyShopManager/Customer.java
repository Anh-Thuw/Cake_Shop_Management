package PartyShopManagerThuQuynh;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

import java.awt.Font;
import java.awt.Image;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import SavePartyShopManager.SavaDrinkMana;
import SavePartyShopManager.SaveCakeMana;
import SavePartyShopManager.SaveCookieMana;

import javax.swing.JScrollPane;

public class Customer extends JFrame {
	ArrayList<SavaDrinkMana> classList = new ArrayList<SavaDrinkMana>();
	ArrayList<SaveCookieMana> listCookie = new ArrayList<SaveCookieMana>();
	ArrayList<SaveCakeMana> listCake = new ArrayList<SaveCakeMana>();
	private JPanel contentPane;

	private CookieCus pnnnCookieCus;
	private CakeCus pnnnnCakeCus;
	private DrinkCus pnnnDrinkCus;
	private OrderCus pnnnOrderCus ;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Customer frame = new Customer();
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
	public Customer() {

		setForeground(new Color(128, 0, 0));
		this.setTitle("Order");
		this.setIconImage((Toolkit.getDefaultToolkit().createImage(Login.class.getResource("/Image/Cus.jpg"))));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1307, 688);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 206, 206));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		pnnnCookieCus = new CookieCus();

		pnnnnCakeCus = new CakeCus();

		pnnnDrinkCus = new DrinkCus();
        pnnnOrderCus = new OrderCus();
        pnnnOrderCus.setSize(382, 642);
        pnnnOrderCus.setLocation(0, 0);
		contentPane.setLayout(null);
		JPanel panelMenu = new JPanel();
		panelMenu.setBounds(0, 0, 191, 652);
		panelMenu.setBackground(new Color(202, 255, 202));
		contentPane.add(panelMenu);
		panelMenu.setLayout(null);

		JLabel lblNewLabel = new JLabel(new ImageIcon(
				new ImageIcon(Toolkit.getDefaultToolkit().getImage(Customer.class.getResource("/Image/Cus.jpg")))
						.getImage().getScaledInstance(188, 131, Image.SCALE_DEFAULT)));
		lblNewLabel.setBounds(0, 0, 191, 131);
		panelMenu.add(lblNewLabel);

		// Mua Cake
		JPanel pnCakeCus = new JPanel();
		pnCakeCus.setLayout(null);
		pnCakeCus.setBackground(new Color(255, 202, 202));
		pnCakeCus.setBounds(0, 478, 188, 174);
		panelMenu.add(pnCakeCus);
		pnCakeCus.addMouseListener(new PanelButtonMouseAdapter(pnCakeCus) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(pnnnnCakeCus);
			}
		});

		JLabel lblNewLabel_1_1 = new JLabel(new ImageIcon(
				new ImageIcon(Toolkit.getDefaultToolkit().getImage(Customer.class.getResource("/Image/cake.jpg")))
						.getImage().getScaledInstance(136, 100, Image.SCALE_DEFAULT)));
		lblNewLabel_1_1.setBounds(27, 20, 136, 100);
		pnCakeCus.add(lblNewLabel_1_1);

		JLabel lblNewLabel_2_2 = new JLabel("CAKES");
		lblNewLabel_2_2.setForeground(new Color(128, 0, 0));
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_2_2.setBounds(52, 131, 141, 36);
		pnCakeCus.add(lblNewLabel_2_2);

		// Mua drink
		JPanel pnDrinkCus = new JPanel();
		pnDrinkCus.setLayout(null);
		pnDrinkCus.setBackground(new Color(255, 242, 242));
		pnDrinkCus.setBounds(0, 131, 188, 174);
		panelMenu.add(pnDrinkCus);
		pnDrinkCus.addMouseListener(new PanelButtonMouseAdapter(pnDrinkCus) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(pnnnDrinkCus);
			}
		});

		JLabel lblNewLabel_1 = new JLabel(new ImageIcon(
				new ImageIcon(Toolkit.getDefaultToolkit().getImage(Customer.class.getResource("/Image/drink.jpg")))
						.getImage().getScaledInstance(136, 100, Image.SCALE_DEFAULT)));
		lblNewLabel_1.setBounds(27, 20, 136, 100);
		pnDrinkCus.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("DRINKS");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_2.setForeground(new Color(128, 0, 0));
		lblNewLabel_2.setBounds(45, 127, 141, 36);
		pnDrinkCus.add(lblNewLabel_2);

		// Mua Cookie
		JPanel pnCookieCus = new JPanel();
		pnCookieCus.setBounds(0, 304, 188, 174);
		panelMenu.add(pnCookieCus);
		pnCookieCus.addMouseListener(new PanelButtonMouseAdapter(pnCookieCus) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(pnnnCookieCus);
			}
		});
		pnCookieCus.setBackground(new Color(255, 223, 223));
		pnCookieCus.setLayout(null);

		JLabel lblNewLabel_3 = new JLabel(new ImageIcon(
				new ImageIcon(Toolkit.getDefaultToolkit().getImage(Customer.class.getResource("/Image/cookie.jpg")))
						.getImage().getScaledInstance(136, 100, Image.SCALE_DEFAULT)));
		lblNewLabel_3.setBounds(27, 20, 136, 100);
		pnCookieCus.add(lblNewLabel_3);

		JLabel lblNewLabel_2_1 = new JLabel("COOKIES");
		lblNewLabel_2_1.setForeground(new Color(128, 0, 0));
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_2_1.setBounds(37, 131, 127, 36);
		pnCookieCus.add(lblNewLabel_2_1);

		///// ban da chon 
		JPanel pnOrderCus = new JPanel();
		pnOrderCus.setLayout(null);
		pnOrderCus.setBackground(new Color(255, 242, 242));
		pnOrderCus.setBounds(1092, 0, 550, 652);
		

		JPanel panelMain1 = new JPanel();
		panelMain1.setBounds(191, 0, 711, 652);
		contentPane.add(panelMain1);
		panelMain1.setLayout(null);

		panelMain1.add(pnnnDrinkCus);
		panelMain1.add(pnnnCookieCus);
		panelMain1.add(pnnnnCakeCus);
		menuClicked(pnnnDrinkCus);
		
		
		JPanel panelMain2 = new JPanel();
		panelMain2.setBounds(901, 0, 382, 652);
		contentPane.add(panelMain2);
		panelMain2.setLayout(null);
		panelMain2.add(pnnnOrderCus);
		
		
		addDrink();
		getDrink();
		addCookie();
		getCookie();
		addCake();
		getCake();
	}

	public void menuClicked(JPanel panel) {
		pnnnCookieCus.setVisible(false);
		pnnnnCakeCus.setVisible(false);
		pnnnDrinkCus.setVisible(false);
		panel.setVisible(true);
	}

	private class PanelButtonMouseAdapter extends MouseAdapter {
		JPanel panel;

		public PanelButtonMouseAdapter(JPanel panel) {
			this.panel = panel;
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			panel.setBackground(new Color(112, 128, 144));
		}

		@Override
		public void mouseExited(MouseEvent e) {
			panel.setBackground(new Color(255, 223, 223));
		}

		@Override
		public void mousePressed(MouseEvent e) {
			panel.setBackground(new Color(112, 128, 144));
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			panel.setBackground(new Color(112, 128, 144));
		}
	}
	
	// add drink
	public void addDrink() {
		DrinkCus.btnNewButton_Drink.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) OrderCus.table_hienthi.getModel();
				Object[] row = new Object[3];
				row[0] = classList.get(DrinkCus.cbbNameD.getSelectedIndex()).getTenDrink();
				row[1] = DrinkCus.comboBox_1.getSelectedItem();

				row[2] = classList.get(DrinkCus.cbbNameD.getSelectedIndex()).getGiaDrink()
						* Long.parseLong(DrinkCus.comboBox_1.getSelectedItem().toString());

				model.addRow(row);

			}
		});

	}
	public void getDrink() {
		try {
			Connection con ;
			con = DataSQL.getConnection();
		String sql = "select Iddrink,tendrink,sizedrink,thanhphandrink,giadrink,anhdrink from DrinkMana ";
		 Statement stm = con.createStatement();
		 ResultSet rs = stm.executeQuery(sql);
		 while(rs.next()) {
				SavaDrinkMana drink = new SavaDrinkMana(rs.getString(2),rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(1), rs.getBytes(6));
		classList.add(drink);
			
		 }
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	// add côkie 
	public void addCookie() {
		CookieCus.btnNewButton_Cookie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) OrderCus.table_hienthi.getModel();
				Object[] row = new Object[3];
				row[0] = listCookie.get(CookieCus.comboBox.getSelectedIndex()).getTenCookie();
				row[1] = CookieCus.comboBox_1.getSelectedItem();

				row[2] = listCookie.get(CookieCus.comboBox_1.getSelectedIndex()).getGiaCookie()
						* Long.parseLong(CookieCus.comboBox_1.getSelectedItem().toString());

				model.addRow(row);

			}
		});

	}
	public void getCookie() {
		try {
			Connection con ;
			con = DataSQL.getConnection();
			String sql = "select ID,Name,MainIngredients,Price,Image from CookieMana";
		 Statement stm = con.createStatement();
		 ResultSet rs = stm.executeQuery(sql);
		 while(rs.next()) {
				SaveCookieMana cookie = new SaveCookieMana( rs.getString(2),rs.getString(3),rs.getInt(4), rs.getInt(1),
						rs.getBytes(5));
				listCookie.add(cookie);
			
		 }
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	// add cake 
	public void addCake() {
		CakeCus.btnNewButton_Cake.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) OrderCus.table_hienthi.getModel();
				Object[] row = new Object[3];
				row[0] = listCake.get(CakeCus.comboBox.getSelectedIndex()).getTenCake();
				row[1] = CakeCus.comboBox_1.getSelectedItem();

				row[2] = listCake.get(CakeCus.comboBox.getSelectedIndex()).getGiaCake()
						* Long.parseLong(CakeCus.comboBox_1.getSelectedItem().toString());

				model.addRow(row);

			}
		});

	}
	public void getCake() {
		try {
			Connection con ;
			con = DataSQL.getConnection();
			String sql = "select IdCake,Name,MainIngredients,Price,Image from CakeMana";
		 Statement stm = con.createStatement();
		 ResultSet rs = stm.executeQuery(sql);
		 while(rs.next()) {
			 SaveCakeMana cake = new SaveCakeMana(rs.getString(2), rs.getString(3), rs.getInt(4),rs.getInt(1), rs.getBytes(5));
				listCake.add(cake);
			
		 }
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
