package PartyShopManagerThuQuynh;


import javax.swing.JPanel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import SavePartyShopManager.SaveCookieMana;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

public class CookieCus extends JPanel {
	ArrayList<SaveCookieMana> listCookie = new ArrayList<SaveCookieMana>();
	private DefaultTableModel modelCookie;
	private JTable table_Cookie;
	public static  JComboBox comboBox;
	public static  JComboBox comboBox_1;
	public static JButton  btnNewButton_Cookie = new JButton("Add");
	/**
	 * Create the panel.
	 */
	public CookieCus() {
		setVisible(true);
		setBackground(new Color(255, 225, 225));
		setBounds(0, 0, 711, 652);
		setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 250, 685, 2);
		add(separator);
		
		JLabel lblNewLabel_Cookie = new JLabel("Cookie Name:");
		lblNewLabel_Cookie.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_Cookie.setBounds(10, 52, 120, 32);
		add(lblNewLabel_Cookie);
		
		JLabel lblNewLabel_Cookie_1 = new JLabel("Quantity:");
		lblNewLabel_Cookie_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_Cookie_1.setBounds(10, 128, 87, 32);
		add(lblNewLabel_Cookie_1);
		
		 comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox.setBounds(119, 46, 304, 45);
		add(comboBox);
		fillCbb();
		
		 comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox_1.setBounds(119, 122, 304, 45);
		add(comboBox_1);
		
		JLabel lblNewLabel = new JLabel("Refer to the cookies in the following table.");
		lblNewLabel.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel.setBounds(25, 230, 516, 21);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(new ImageIcon( new ImageIcon(
				Toolkit.getDefaultToolkit().getImage(
						CookieCus.class.getResource("/Image/cookie.jpg")
						)
				).getImage().getScaledInstance(198, 169, Image.SCALE_DEFAULT)));
		lblNewLabel_1.setBounds(490, 47, 198, 169);
		add(lblNewLabel_1);
		
		table_Cookie = new JTable();
		table_Cookie.setBackground(new Color(193, 193, 255));
//		table.setFont(new Font("Tahoma", Font.PLAIN, 25));
		table_Cookie.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Name", "Main Ingredients", "Price", "Image"
			}
		) {
			Class[] columnTypes = new Class[] {
				Object.class, Object.class, Object.class, ImageIcon.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		findCookie();
		loadInformationCookie();
		table_Cookie.setBounds(39, 620, 889, 422);
		
		JScrollPane scrollPane = new JScrollPane(table_Cookie);
		scrollPane.setBounds(10, 256, 691, 390);
		add(scrollPane);
		
		 btnNewButton_Cookie = new JButton("Add");
		btnNewButton_Cookie.setForeground(new Color(128, 0, 0));
		btnNewButton_Cookie.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_Cookie.setBackground(new Color(213, 255, 255));
		btnNewButton_Cookie.setBounds(323, 182, 100, 32);
		add(btnNewButton_Cookie);

	}
	private void findCookie() {
		try {
			Connection con = DataSQL.getConnection();
			String sql = "select ID,Name,MainIngredients,Price,Image from CookieMana";
			PreparedStatement pre = con.prepareStatement(sql);
			ResultSet rs = pre.executeQuery();
			listCookie.clear();
			while (rs.next()) {
				SaveCookieMana cookie = new SaveCookieMana( rs.getString(2),rs.getString(3),rs.getInt(4), rs.getInt(1),
						rs.getBytes(5));
				listCookie.add(cookie);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	private void loadInformationCookie() {
		modelCookie = (DefaultTableModel) table_Cookie.getModel();
		modelCookie.setRowCount(0);
		Object[] row = new Object[4];
		for (int i = 0; i < listCookie.size(); i++) {
			row[0] = listCookie.get(i).getTenCookie();
			row[1] = listCookie.get(i).getThanhphanCookie();
			row[2] = listCookie.get(i).getGiaCookie();
			if (listCookie.get(i).getAnhCookie() != null) {
				ImageIcon imageIcon = new ImageIcon(new ImageIcon(listCookie.get(i).getAnhCookie()).getImage()
						.getScaledInstance(100, 100, Image.SCALE_SMOOTH));
				row[3] = imageIcon;
			} else {
				row[3] = null;

			}
			modelCookie.addRow(row);
		}
		table_Cookie.setRowHeight(80);
	}
	private void fillCbb() {
		try {
			Connection con = DataSQL.getConnection();
			String sql = "select ID,Name,MainIngredients,Price,Image from CookieMana";
			PreparedStatement pre = con.prepareStatement(sql);
			ResultSet rs = pre.executeQuery();
			while(rs.next()) {
				comboBox.addItem(rs.getString("Name"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}


}
