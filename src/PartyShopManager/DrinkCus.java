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

import SavePartyShopManager.SavaDrinkMana;

import javax.swing.JScrollPane;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class DrinkCus extends JPanel {
	ArrayList<SavaDrinkMana> classList = new ArrayList<SavaDrinkMana>();
	private JTable table_Drink;
	private DefaultTableModel modelDrink;
 static  JComboBox cbbNameD;
 static JComboBox comboBox_1 = new JComboBox();
	 static JButton btnNewButton_Drink = new JButton("Add");
	/**
	 * Create the panel.
	 */
	public DrinkCus() {
		
		
		                setVisible(true);
	                    setBackground(new Color(255, 240, 240));
						setBounds(0, 0, 711, 652);
						setLayout(null);
						
						JSeparator separator = new JSeparator();
						separator.setBounds(10, 250, 685, 2);
						add(separator);
						
						JLabel lblNewLabel_Cookie = new JLabel("Drinks Name:");
						lblNewLabel_Cookie.setFont(new Font("Tahoma", Font.BOLD, 15));
						lblNewLabel_Cookie.setBounds(10, 52, 120, 32);
						add(lblNewLabel_Cookie);
						
						JLabel lblNewLabel_Cookie_1 = new JLabel("Quantity:");
						lblNewLabel_Cookie_1.setFont(new Font("Tahoma", Font.BOLD, 15));
						lblNewLabel_Cookie_1.setBounds(10, 128, 87, 32);
						add(lblNewLabel_Cookie_1);
						
						 cbbNameD = new JComboBox();
						cbbNameD.setFont(new Font("Tahoma", Font.PLAIN, 15));
						cbbNameD.setBounds(119, 46, 304, 45);
						add(cbbNameD);
						fillCbb();
						comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
						
						
						comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
						comboBox_1.setBounds(119, 122, 304, 45);
						add(comboBox_1);
						
						JLabel lblNewLabel = new JLabel("Refer to the drinks in the following table.");
						lblNewLabel.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 15));
						lblNewLabel.setBounds(25, 230, 516, 21);
						add(lblNewLabel);
						
						JLabel lblNewLabel_1 = new JLabel(new ImageIcon( new ImageIcon(
								Toolkit.getDefaultToolkit().getImage(
										DrinkCus.class.getResource("/Image/drink.jpg")
										)
								).getImage().getScaledInstance(198, 169, Image.SCALE_DEFAULT)));
						lblNewLabel_1.setBounds(490, 47, 198, 169);
						add(lblNewLabel_1);
						
						table_Drink = new JTable();
						table_Drink.setBackground(new Color(193, 193, 255));
						table_Drink.setModel(new DefaultTableModel(
							new Object[][] {
							},
							new String[] {
								"Name", "Size", "Main Ingredients", "Price", "Image"
							}
						) {
							Class[] columnTypes = new Class[] {
								Object.class, Object.class, Object.class, Object.class, ImageIcon.class
							};
							public Class getColumnClass(int columnIndex) {
								return columnTypes[columnIndex];
							}
						});
						findDrink();
						loadInformationDrink();
						table_Drink.setBounds(39, 620, 889, 422);
						
						JScrollPane scrollPane = new JScrollPane(table_Drink);
						scrollPane.setBounds(10, 256, 691, 390);
						add(scrollPane);
						
						btnNewButton_Drink.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
							}
						});
						btnNewButton_Drink.setBackground(new Color(213, 255, 255));
						btnNewButton_Drink.setForeground(new Color(128, 0, 0));
						btnNewButton_Drink.setFont(new Font("Tahoma", Font.BOLD, 18));
						btnNewButton_Drink.setBounds(323, 182, 100, 32);
						add(btnNewButton_Drink);
						
					
				

			}
	private void findDrink() {
		try {
			// lay du du lieu tu tu sql 
			Connection con = DataSQL.getConnection();
			String sql = "select Iddrink,tendrink,sizedrink,thanhphandrink,giadrink,anhdrink from DrinkMana ";
			PreparedStatement pre = con.prepareStatement(sql);
			ResultSet rs = pre.executeQuery();
			classList.clear();
			while (rs.next()) {
				SavaDrinkMana drink = new SavaDrinkMana(rs.getString(2),rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(1), rs.getBytes(6));
				classList.add(drink);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
// hien thi thong tin len bang 
	private void loadInformationDrink() {
		modelDrink = (DefaultTableModel) table_Drink.getModel();
		modelDrink.setRowCount(0);
		Object[] row = new Object[5];
		for (int i = 0; i < classList.size(); i++) {
			row[0] = classList.get(i).getTenDrink();
			row[1] = classList.get(i).getSizeDrink();
			row[2] = classList.get(i).getThanhphanDrink();
			row[3] = classList.get(i).getGiaDrink();
			if (classList.get(i).getAnhDrink() != null) {
				ImageIcon imageIcon = new ImageIcon(new ImageIcon(classList.get(i).getAnhDrink()).getImage()
						.getScaledInstance(100, 100, Image.SCALE_SMOOTH));
				row[4] = imageIcon;
			} else {
				row[4] = null;

			}
			modelDrink.addRow(row);
		}
		table_Drink.setRowHeight(80);
	}

	private void fillCbb() {
		try {
			Connection con = DataSQL.getConnection();
			String sql = "select Iddrink,tendrink,sizedrink,thanhphandrink,giadrink,anhdrink from DrinkMana ";
			PreparedStatement pre = con.prepareStatement(sql);
			ResultSet rs = pre.executeQuery();
			while(rs.next()) {
				cbbNameD.addItem(rs.getString("tendrink"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}


