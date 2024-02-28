package PartyShopManagerThuQuynh;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JTextPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.Icon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StatisticMana extends JPanel {
	private JTable table_Drink;
	private JTable table_Cookie;
	private JTable table_Cake;
	private JTabbedPane tabbedPane;
	private JPanel panelDrink;
	private JPanel panelCookie;
	private JPanel panelCake;
	private JLabel lblNewLabel;
	private JSeparator separator;
	private JSeparator separator_1;
	private JLabel lblNewLabel_1;
	
	private JTextField textField_FindCake;
	private JTextField textField_FindCookie;
	private JTextField textField_FindDrink;
	
	private JButton btnNewButton_Find_1;
	private JButton btnNewButton_Find_2;
	private JButton btnNewButton_FindCake_3;

	private JButton btnNewButton_Exit_1;
	private JButton btnNewButton_Exit_2;
	private JButton btnNewButton_ExitCake_3;
	
	private JLabel lblNewLabel_2;
	
	
	private JButton btnNewButton_Reset_1;
	private JButton btnNewButton_Reset_2;
	private JButton btnNewButton_Reset_3;
	private JLabel lblNewLabel_3;
	
	private JTextField txtTotalCake;
	private JTextField txtTotalCookie;
	private JTextField txtTotalDrink;
	private JLabel lblNewLabel_4;
	private JPanel panelPre;
	private JTable table_Pre;
	/**
	 * Create the panel.
	 */
	public StatisticMana() {
		setBackground(new Color(255, 244, 244));
		setLayout(null);
		setBounds(0, 0, 1156, 652);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(new Color(255, 200, 200));
		tabbedPane.setForeground(new Color(128, 0, 0));
		tabbedPane.setFont(new Font("Sylfaen", Font.BOLD, 25));
		tabbedPane.setBounds(0, 0, 1156, 652);
		add(tabbedPane);
		
		//Drink
		panelDrink = new JPanel();
		panelDrink.setBackground(new Color(223, 223, 223));
		tabbedPane.addTab("Revenue Drink", null, panelDrink, null);
		panelDrink.setLayout(null);
		
		lblNewLabel = new JLabel("Revenue Statistics Drinks");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 35));
		lblNewLabel.setBounds(10, 11, 503, 43);
		panelDrink.add(lblNewLabel);
		
		lblNewLabel_2 = new JLabel(new ImageIcon( new ImageIcon(
				Toolkit.getDefaultToolkit().getImage(
						StatisticMana.class.getResource("/Image/thongke1.jpg")
						)
				).getImage().getScaledInstance(54, 38, Image.SCALE_DEFAULT)));
		lblNewLabel_2.setBounds(485, 11, 54, 38);
		panelDrink.add(lblNewLabel_2);
		
		lblNewLabel_1 = new JLabel(new ImageIcon( new ImageIcon(
				Toolkit.getDefaultToolkit().getImage(
						StatisticMana.class.getResource("/Image/kinhlup.png")
						)
				).getImage().getScaledInstance(41, 36, Image.SCALE_DEFAULT)));
		lblNewLabel_1.setBounds(791, 11, 41, 36);
		panelDrink.add(lblNewLabel_1);
		
		lblNewLabel_4 = new JLabel(new ImageIcon( new ImageIcon(
				Toolkit.getDefaultToolkit().getImage(
						StatisticMana.class.getResource("/Image/thongke2.jpg")
						)
				).getImage().getScaledInstance(621, 129, Image.SCALE_DEFAULT)));
		lblNewLabel_4.setBounds(10, 464, 621, 129);
		panelDrink.add(lblNewLabel_4);
		
		lblNewLabel_3 = new JLabel("Total Revenue:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3.setBounds(641, 476, 174, 38);
		panelDrink.add(lblNewLabel_3);
		
		separator = new JSeparator();
		separator.setBackground(Color.BLACK);
		separator.setBounds(10, 52, 692, 2);
		panelDrink.add(separator);
		
		
		table_Drink = new JTable();
		table_Drink.setBackground(new Color(223, 255, 255));
//		table.setFont(new Font("Tahoma", Font.PLAIN, 25));
		table_Drink.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"IDB", "Name Cookie", "Date", "Money"
			}
		) );
		table_Drink.getColumnModel().getColumn(0).setPreferredWidth(42);
		table_Drink.getColumnModel().getColumn(1).setPreferredWidth(111);
		table_Drink.getColumnModel().getColumn(3).setPreferredWidth(87);
		
		
		table_Drink.setBounds(375, 91, 889, 422);
		JScrollPane scrollPane_Drink = new JScrollPane(table_Drink);
		scrollPane_Drink.setBounds(10, 58, 1131, 395);
		scrollPane_Drink.setFont(new Font("Tahoma", Font.BOLD, 15));
		panelDrink.add(scrollPane_Drink);
		
		txtTotalDrink = new JTextField();
		txtTotalDrink.setBounds(806, 476, 312, 38);
		panelDrink.add(txtTotalDrink);
		txtTotalDrink.setColumns(10);
		
		textField_FindDrink = new JTextField();
		textField_FindDrink.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField_FindDrink.setColumns(10);
		textField_FindDrink.setBounds(836, 11, 238, 36);
		panelDrink.add(textField_FindDrink);
	
		
		btnNewButton_Exit_1 = new JButton("Exit");
		btnNewButton_Exit_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				HomeManager hom = new HomeManager();
				hom.setVisible(true);
			}
		});
		btnNewButton_Exit_1.setForeground(new Color(128, 0, 0));
		btnNewButton_Exit_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_Exit_1.setBackground(new Color(255, 128, 128));
		btnNewButton_Exit_1.setBounds(1023, 550, 95, 43);
		panelDrink.add(btnNewButton_Exit_1);
		
		
		
		btnNewButton_Find_1 = new JButton("Find");
		btnNewButton_Find_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_Find_1.setBackground(new Color(217, 217, 217));
		btnNewButton_Find_1.setBounds(1075, 20, 72, 23);
		panelDrink.add(btnNewButton_Find_1);
		
		btnNewButton_Reset_1 = new JButton("Reset");
		btnNewButton_Reset_1.setForeground(new Color(0, 64, 128));
		btnNewButton_Reset_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_Reset_1.setBackground(new Color(185, 255, 255));
		btnNewButton_Reset_1.setBounds(909, 550, 104, 43);
		panelDrink.add(btnNewButton_Reset_1);
		
		
		
		
		
		
		//Cookie
		panelCookie = new JPanel();
		panelCookie.setBackground(new Color(223, 223, 223));
		tabbedPane.addTab("Revenue Cookie", null, panelCookie, null);
		panelCookie.setLayout(null);
		
		
		lblNewLabel = new JLabel("Revenue Statistics Cookies");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 35));
		lblNewLabel.setBounds(10, 11, 503, 43);
		panelCookie.add(lblNewLabel);
		
		lblNewLabel_2 = new JLabel(new ImageIcon( new ImageIcon(
				Toolkit.getDefaultToolkit().getImage(
						StatisticMana.class.getResource("/Image/thongke1.jpg")
						)
				).getImage().getScaledInstance(54, 38, Image.SCALE_DEFAULT)));
		lblNewLabel_2.setBounds(505, 11, 54, 38);
		panelCookie.add(lblNewLabel_2);
		
		lblNewLabel_1 = new JLabel(new ImageIcon( new ImageIcon(
				Toolkit.getDefaultToolkit().getImage(
						StatisticMana.class.getResource("/Image/kinhlup.png")
						)
				).getImage().getScaledInstance(41, 36, Image.SCALE_DEFAULT)));
		lblNewLabel_1.setBounds(791, 11, 41, 36);
		panelCookie.add(lblNewLabel_1);
		
		lblNewLabel_4 = new JLabel(new ImageIcon( new ImageIcon(
				Toolkit.getDefaultToolkit().getImage(
						StatisticMana.class.getResource("/Image/thongke2.jpg")
						)
				).getImage().getScaledInstance(621, 129, Image.SCALE_DEFAULT)));
		lblNewLabel_4.setBounds(10, 464, 621, 129);
		panelCookie.add(lblNewLabel_4);
		
		lblNewLabel_3 = new JLabel("Total Revenue:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3.setBounds(641, 476, 174, 38);
		panelCookie.add(lblNewLabel_3);
		
		
		
		
		separator_1 = new JSeparator();
		separator_1.setForeground(new Color(0, 0, 0));
		separator_1.setBackground(Color.BLACK);
		separator_1.setBounds(10, 52, 692, 1);
		panelCookie.add(separator_1);
        
		table_Cookie = new JTable();
		table_Cookie.setBackground(new Color(206, 206, 255));
//		table.setFont(new Font("Tahoma", Font.PLAIN, 25));
		table_Cookie.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"IDB", "Name Cookie", "Date", "Money"
			}
		));
		table_Cookie.getColumnModel().getColumn(0).setPreferredWidth(65);
		table_Cookie.getColumnModel().getColumn(1).setPreferredWidth(140);
		table_Cookie.getColumnModel().getColumn(2).setPreferredWidth(103);
		
		
		table_Cookie.setBounds(375, 91, 889, 422);
		JScrollPane scrollPane_Cookie = new JScrollPane(table_Cookie);
		scrollPane_Cookie.setBounds(10, 58, 1131, 395);
		scrollPane_Cookie.setFont(new Font("Tahoma", Font.BOLD, 15));
		panelCookie.add(scrollPane_Cookie);
		
		txtTotalCookie = new JTextField();
		txtTotalCookie.setBounds(806, 476, 312, 38);
		panelCookie.add(txtTotalCookie);
		txtTotalCookie.setColumns(10);
		
		textField_FindCookie = new JTextField();
		textField_FindCookie.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField_FindCookie.setColumns(10);
		textField_FindCookie.setBounds(836, 11, 238, 36);
		panelCookie.add(textField_FindCookie);
	
		
		btnNewButton_Exit_2 = new JButton("Exit");
		btnNewButton_Exit_2.setForeground(new Color(128, 0, 0));
		btnNewButton_Exit_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_Exit_2.setBackground(new Color(255, 128, 128));
		btnNewButton_Exit_2.setBounds(1026, 550, 92, 43);
		panelCookie.add(btnNewButton_Exit_2);
		
		
		
		btnNewButton_Find_2 = new JButton("Find");
		btnNewButton_Find_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_Find_2.setBackground(new Color(217, 217, 217));
		btnNewButton_Find_2.setBounds(1075, 20, 72, 23);
		panelCookie.add(btnNewButton_Find_2);
		
		btnNewButton_Reset_2 = new JButton("Reset");
		btnNewButton_Reset_2.setForeground(new Color(0, 64, 128));
		btnNewButton_Reset_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_Reset_2.setBackground(new Color(185, 255, 255));
		btnNewButton_Reset_2.setBounds(909, 550, 104, 43);
		panelCookie.add(btnNewButton_Reset_2);
		
		
		
		
		
		
		
		
		//Cake
		panelCake = new JPanel();
		panelCake.setBackground(new Color(223, 223, 223));
		tabbedPane.addTab("Revenue Cake", null, panelCake, null);
		panelCake.setLayout(null);
		
		lblNewLabel = new JLabel("Revenue Statistics Cakes");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 35));
		lblNewLabel.setBounds(34, 11, 491, 43);
		panelCake.add(lblNewLabel);
		
		lblNewLabel_2 = new JLabel(new ImageIcon( new ImageIcon(
				Toolkit.getDefaultToolkit().getImage(
						StatisticMana.class.getResource("/Image/thongke1.jpg")
						)
				).getImage().getScaledInstance(54, 38, Image.SCALE_DEFAULT)));
		lblNewLabel_2.setBounds(500, 11, 54, 38);
		panelCake.add(lblNewLabel_2);
		
		lblNewLabel_1 = new JLabel(new ImageIcon( new ImageIcon(
				Toolkit.getDefaultToolkit().getImage(
						StatisticMana.class.getResource("/Image/kinhlup.png")
						)
				).getImage().getScaledInstance(41, 36, Image.SCALE_DEFAULT)));
		lblNewLabel_1.setBounds(791, 11, 41, 36);
		panelCake.add(lblNewLabel_1);
		
		lblNewLabel_4 = new JLabel(new ImageIcon( new ImageIcon(
				Toolkit.getDefaultToolkit().getImage(
						StatisticMana.class.getResource("/Image/thongke2.jpg")
						)
				).getImage().getScaledInstance(621, 129, Image.SCALE_DEFAULT)));
		lblNewLabel_4.setBounds(10, 464, 621, 129);
		panelCake.add(lblNewLabel_4);
		
		lblNewLabel_3 = new JLabel("Total Revenue:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3.setBounds(641, 476, 174, 38);
		panelCake.add(lblNewLabel_3);
		
		
		
		separator = new JSeparator();
		separator.setBackground(Color.BLACK);
		separator.setBounds(10, 52, 678, 2);
		panelCake.add(separator);
		
		
		table_Cake = new JTable();
		table_Cake.setBackground(new Color(198, 255, 198));
//		table.setFont(new Font("Tahoma", Font.PLAIN, 25));
		table_Cake.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
			},
			new String[] {
					"IDB", "Name Cookie", "Date", "Money"
			}
		));
		table_Cake.getColumnModel().getColumn(0).setPreferredWidth(65);
		table_Cake.getColumnModel().getColumn(1).setPreferredWidth(140);
		table_Cake.getColumnModel().getColumn(2).setPreferredWidth(103);
		
		table_Cake.setBounds(375, 91, 889, 422);
		JScrollPane scrollPane_Cake = new JScrollPane(table_Cake);
		scrollPane_Cake.setBounds(10, 58, 1131, 392);
		scrollPane_Cake.setFont(new Font("Tahoma", Font.BOLD, 15));
		panelCake.add(scrollPane_Cake);
		
		txtTotalCake = new JTextField();
		txtTotalCake.setBounds(806, 476, 312, 38);
		panelCake.add(txtTotalCake);
		txtTotalCake.setColumns(10);
		
		textField_FindCake = new JTextField();
		textField_FindCake.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField_FindCake.setColumns(10);
		textField_FindCake.setBounds(836, 11, 238, 36);
		panelCake.add(textField_FindCake);
	
		
		btnNewButton_ExitCake_3 = new JButton("Exit");
		btnNewButton_ExitCake_3.setForeground(new Color(128, 0, 0));
		btnNewButton_ExitCake_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_ExitCake_3.setBackground(new Color(255, 128, 128));
		btnNewButton_ExitCake_3.setBounds(1023, 550, 84, 43);
		panelCake.add(btnNewButton_ExitCake_3);
		
		
		
		btnNewButton_FindCake_3 = new JButton("Find");
		btnNewButton_FindCake_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_FindCake_3.setBackground(new Color(217, 217, 217));
		btnNewButton_FindCake_3.setBounds(1075, 20, 72, 23);
		panelCake.add(btnNewButton_FindCake_3);
		
		btnNewButton_Reset_3 = new JButton("Reset");
		btnNewButton_Reset_3.setForeground(new Color(0, 64, 128));
		btnNewButton_Reset_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_Reset_3.setBackground(new Color(185, 255, 255));
		btnNewButton_Reset_3.setBounds(909, 550, 104, 43);
		panelCake.add(btnNewButton_Reset_3);
		
		
		
		
		//Dat hang truoc
				panelPre = new JPanel();
				panelPre.setBackground(new Color(223, 223, 223));
				tabbedPane.addTab("Revenue Pre-Order", null, panelPre, null);
				panelPre.setLayout(null);
				
				lblNewLabel = new JLabel("Revenue Statistics Pre-Ord");
				lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 35));
				lblNewLabel.setBounds(34, 11, 491, 43);
				panelPre.add(lblNewLabel);
				
				lblNewLabel_2 = new JLabel(new ImageIcon( new ImageIcon(
						Toolkit.getDefaultToolkit().getImage(
								StatisticMana.class.getResource("/Image/thongke1.jpg")
								)
						).getImage().getScaledInstance(54, 38, Image.SCALE_DEFAULT)));
				lblNewLabel_2.setBounds(535, 11, 54, 38);
				panelPre.add(lblNewLabel_2);
				
				lblNewLabel_1 = new JLabel(new ImageIcon( new ImageIcon(
						Toolkit.getDefaultToolkit().getImage(
								StatisticMana.class.getResource("/Image/kinhlup.png")
								)
						).getImage().getScaledInstance(41, 36, Image.SCALE_DEFAULT)));
				lblNewLabel_1.setBounds(791, 11, 41, 36);
				panelPre.add(lblNewLabel_1);
				
				lblNewLabel_4 = new JLabel(new ImageIcon( new ImageIcon(
						Toolkit.getDefaultToolkit().getImage(
								StatisticMana.class.getResource("/Image/thongke2.jpg")
								)
						).getImage().getScaledInstance(621, 129, Image.SCALE_DEFAULT)));
				lblNewLabel_4.setBounds(10, 464, 621, 129);
				panelPre.add(lblNewLabel_4);
				
				lblNewLabel_3 = new JLabel("Total Revenue:");
				lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 20));
				lblNewLabel_3.setBounds(641, 476, 174, 38);
				panelPre.add(lblNewLabel_3);
				
				
				
				separator = new JSeparator();
				separator.setBackground(Color.BLACK);
				separator.setBounds(10, 52, 678, 2);
				panelPre.add(separator);
				
				
				table_Pre = new JTable();
				table_Pre.setBackground(new Color(255, 221, 221));
//				table.setFont(new Font("Tahoma", Font.PLAIN, 25));
				table_Pre.setModel(new DefaultTableModel(
					new Object[][] {
						{null, null, null, null},
					},
					new String[] {
							"IDB", "Client", "Date", "Money"
					}
				));
				
				
				table_Pre.setBounds(375, 91, 889, 422);
				JScrollPane scrollPane_Pre = new JScrollPane(table_Pre);
				scrollPane_Pre.setBounds(10, 58, 1131, 392);
				scrollPane_Pre.setFont(new Font("Tahoma", Font.BOLD, 15));
				panelPre.add(scrollPane_Pre);
				
				txtTotalCake = new JTextField();
				txtTotalCake.setBounds(806, 476, 312, 38);
				panelPre.add(txtTotalCake);
				txtTotalCake.setColumns(10);
				
				textField_FindCake = new JTextField();
				textField_FindCake.setFont(new Font("Tahoma", Font.PLAIN, 17));
				textField_FindCake.setColumns(10);
				textField_FindCake.setBounds(836, 11, 238, 36);
				panelPre.add(textField_FindCake);
			
				
				btnNewButton_ExitCake_3 = new JButton("Exit");
				btnNewButton_ExitCake_3.setForeground(new Color(128, 0, 0));
				btnNewButton_ExitCake_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
				btnNewButton_ExitCake_3.setBackground(new Color(255, 128, 128));
				btnNewButton_ExitCake_3.setBounds(1023, 550, 84, 43);
				panelPre.add(btnNewButton_ExitCake_3);
				
				
				
				btnNewButton_FindCake_3 = new JButton("Find");
				btnNewButton_FindCake_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
				btnNewButton_FindCake_3.setBackground(new Color(217, 217, 217));
				btnNewButton_FindCake_3.setBounds(1075, 20, 72, 23);
				panelPre.add(btnNewButton_FindCake_3);
				
				btnNewButton_Reset_3 = new JButton("Reset");
				btnNewButton_Reset_3.setForeground(new Color(0, 64, 128));
				btnNewButton_Reset_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
				btnNewButton_Reset_3.setBackground(new Color(185, 255, 255));
				btnNewButton_Reset_3.setBounds(909, 550, 104, 43);
				panelPre.add(btnNewButton_Reset_3);

	}

}
