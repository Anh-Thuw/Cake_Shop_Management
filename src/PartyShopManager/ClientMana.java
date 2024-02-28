package PartyShopManagerThuQuynh;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import SavePartyShopManager.SavaDrinkMana;
import SavePartyShopManager.SaveCakeMana;
import SavePartyShopManager.SaveUser;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.RowFilter;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.Icon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ClientMana extends JPanel {
	private JTable table;
	ArrayList<SaveUser> listuser = new ArrayList<SaveUser>();
	private DefaultTableModel model ;
	/**
	 * Create the panel.
	 */
	public ClientMana() {
		setBackground(new Color(255, 255, 221));
		setLayout(null);
		setBounds(0, 0, 1156, 652);

		JLabel lblNewLabel_2 = new JLabel("The list of Customer");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 35));
		lblNewLabel_2.setBounds(27, 11, 373, 43);
		add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel(new ImageIcon(
				new ImageIcon(Toolkit.getDefaultToolkit().getImage(ClientMana.class.getResource("/Image/client.jpg")))
						.getImage().getScaledInstance(54, 38, Image.SCALE_DEFAULT)));
		lblNewLabel_3.setBounds(399, 11, 54, 38);
		add(lblNewLabel_3);

		JLabel lblNewLabel = new JLabel(new ImageIcon(
				new ImageIcon(Toolkit.getDefaultToolkit().getImage(ClientMana.class.getResource("/Image/clien1.jpg")))
						.getImage().getScaledInstance(712, 132, Image.SCALE_DEFAULT)));
		lblNewLabel.setBounds(43, 509, 712, 132);
		add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel(new ImageIcon(
				new ImageIcon(Toolkit.getDefaultToolkit().getImage(ClientMana.class.getResource("/Image/kinhlup.png")))
						.getImage().getScaledInstance(41, 36, Image.SCALE_DEFAULT)));
		lblNewLabel_1.setBounds(819, 11, 41, 36);
		add(lblNewLabel_1);

		JSeparator separator = new JSeparator();
		separator.setBackground(Color.BLACK);
		separator.setBounds(10, 49, 494, 2);
		add(separator);

		table = new JTable();
		table.setBackground(new Color(255, 198, 198));
//		table.setFont(new Font("Tahoma", Font.PLAIN, 25));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Name", "Email", "Sex", "CCCD", "Phone", "User Name"
			}
		));
		findCus();
		loadInformationCus();
		table.setBounds(375, 91, 889, 422);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setFont(new Font("Tahoma", Font.PLAIN, 10));
		scrollPane.setBounds(10, 60, 1136, 438);
		add(scrollPane);

		JTextField textField_Find = new JTextField();
		textField_Find.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String  searchString = textField_Find.getText();
				reseachClient(searchString);
				
			}
		});
		textField_Find.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField_Find.setColumns(10);
		textField_Find.setBounds(868, 11, 278, 36);
		add(textField_Find);

		JButton btnNewButton_Exit = new JButton("Exit");
		btnNewButton_Exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				HomeManager hom = new HomeManager();
				hom.setVisible(true);
			}
		});
		btnNewButton_Exit.setForeground(new Color(128, 0, 0));
		btnNewButton_Exit.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_Exit.setBackground(new Color(255, 128, 128));
		btnNewButton_Exit.setBounds(1026, 582, 104, 43);
		add(btnNewButton_Exit);
	}
	private void findCus() {
		try {
			Connection con = DataSQL.getConnection();
			String sql = "select IDUsers,Username,Name,Sex,Cccd,Phone,Email from Users";
			PreparedStatement pre = con.prepareStatement(sql);
			ResultSet rs = pre.executeQuery();
			listuser.clear();
			while (rs.next()) {
				SaveUser us = new SaveUser(rs.getString(3), rs.getString(4),rs.getString(7),rs.getString(2), rs.getLong(5),rs.getLong(6), rs.getInt(1));
				listuser.add(us);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void loadInformationCus() {
		model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		Object[] row = new Object[7];
		for (int i = 0; i < listuser.size(); i++) {
			row[0] = listuser.get(i).getId();
			row[1] = listuser.get(i).getName();
			row[2] = listuser.get(i).getEmail();
			row[3] = listuser.get(i).getSex();
			row[4] = listuser.get(i).getCccd();
			row[5] = listuser.get(i).getPhone();
			row[6] = listuser.get(i).getUsername();
			model.addRow(row);
		}
		table.setRowHeight(50);
	}
	// tim kiem 
	public void serRecordsToTableClient() {
		try {
			Connection con = DataSQL.getConnection();
			String sql = "select IDUsers,Username,Name,Sex,Cccd,Phone,Email from Users";
			PreparedStatement pre = con.prepareStatement(sql);
			ResultSet rs = pre.executeQuery();
			while (rs.next()) {
				SaveUser us = new SaveUser(rs.getString(3), rs.getString(4),rs.getString(7),rs.getString(2), rs.getLong(5),rs.getLong(6), rs.getInt(1));
				Object[] obj = { "ID", "Name", "Email", "Sex", "CCCD", "Phone", "User Name"};
				model = (DefaultTableModel) table.getModel();
				model.addRow(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void reseachClient(String str) {
		model = (DefaultTableModel) table.getModel();
		TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
		table.setRowSorter(trs);
		trs.setRowFilter(RowFilter.regexFilter(str));
	}
	

}
