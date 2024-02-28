package PartyShopManagerThuQuynh;


import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.Icon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BillMana extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public BillMana() {
		setBackground(new Color(193, 255, 193));
		setLayout(null);
		setBounds(0, 0, 1156, 652);
		
		JLabel lblNewLabel_2 = new JLabel("The list of Bill");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 35));
		lblNewLabel_2.setBounds(82, 11, 276, 43);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel(new ImageIcon( new ImageIcon(
				Toolkit.getDefaultToolkit().getImage(
						BillMana.class.getResource("/Image/bil.jpg")
						)
				).getImage().getScaledInstance(54, 38, Image.SCALE_DEFAULT)));
		lblNewLabel_3.setBounds(339, 11, 54, 38);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel = new JLabel(new ImageIcon( new ImageIcon(
				Toolkit.getDefaultToolkit().getImage(
						BillMana.class.getResource("/Image/bil1.jpg")
						)
				).getImage().getScaledInstance(612, 147, Image.SCALE_DEFAULT)));
		lblNewLabel.setBounds(143, 505, 612, 147);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(new ImageIcon( new ImageIcon(
				Toolkit.getDefaultToolkit().getImage(
						BillMana.class.getResource("/Image/kinhlup.png")
						)
				).getImage().getScaledInstance(41, 36, Image.SCALE_DEFAULT)));
		lblNewLabel_1.setBounds(824, 11, 41, 36);
		add(lblNewLabel_1);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.BLACK);
		separator.setBounds(50, 49, 454, 2);
		add(separator);
		
		table = new JTable();
		table.setBackground(new Color(255, 198, 198));
//		table.setFont(new Font("Tahoma", Font.PLAIN, 25));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
			},
			new String[] {
				"IDB", "IDC", "Name client", "Date order", "Date Pay", "Payment method", "Price", "Goods Purchased"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(33);
		table.getColumnModel().getColumn(1).setPreferredWidth(30);
		table.getColumnModel().getColumn(3).setPreferredWidth(71);
		table.getColumnModel().getColumn(4).setPreferredWidth(65);
		table.getColumnModel().getColumn(5).setPreferredWidth(105);
		table.getColumnModel().getColumn(7).setPreferredWidth(203);
		
		
		
		table.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 13));
		table.setBounds(375, 91, 889, 422);
		
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setFont(new Font("Tahoma", Font.PLAIN, 10));
		scrollPane.setBounds(10, 60, 1136, 438);
		add(scrollPane);
		
		JTextField textField_Find = new JTextField();
		textField_Find.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField_Find.setColumns(10);
		textField_Find.setBounds(870, 11, 238, 36);
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
		
		
		JButton btnNewButton_Reset = new JButton("Reset");
		btnNewButton_Reset.setForeground(new Color(0, 64, 128));
		btnNewButton_Reset.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_Reset.setBackground(new Color(185, 255, 255));
		btnNewButton_Reset.setBounds(901, 582, 104, 43);
		add(btnNewButton_Reset);
		
		

	}

}
