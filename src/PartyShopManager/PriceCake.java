package PartyShopManagerThuQuynh;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.Icon;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import SavePartyShopManager.SaveColorMana;
import SavePartyShopManager.SaveFruitMana;
import SavePartyShopManager.SavePartMana;
import SavePartyShopManager.SaveShapeMana;
import SavePartyShopManager.SaveTasteMana;
import SavePartyShopManager.SaveTierMana;

public class PriceCake extends JFrame {
	ArrayList<SaveFruitMana> listFruit = new ArrayList<SaveFruitMana>();
	ArrayList<SaveShapeMana> listShape = new ArrayList<SaveShapeMana>();
	ArrayList<SaveColorMana> listColor = new ArrayList<SaveColorMana>();
	ArrayList<SavePartMana> listPart = new ArrayList<SavePartMana>();
	ArrayList<SaveTasteMana> listTaste = new ArrayList<SaveTasteMana>();
	ArrayList<SaveTierMana> listTier = new ArrayList<SaveTierMana>();
	private DefaultTableModel modelFruit , modelColor , modelPart , modelShape , modelTaste , modelTier ;
	private JPanel contentPane;
	private JTextField textField_6;
	private JTextField textField;
	private JTable table_Fruit;
	private JTable table_Part;
	private JTable table_Taste;
	private JTable table_Shape;
	private JTable table_Color;
	private JTable table_Tier;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PriceCake frame = new PriceCake();
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
	public PriceCake() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1339, 493);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 1335, 463);
		contentPane.add(tabbedPane);
	//	---------------BANG 1 ---------------------
		JPanel panel = new JPanel();
		panel.setBackground(new Color(223, 255, 255));
		tabbedPane.addTab("Price 1", null, panel, null);
		panel.setLayout(null);
		
		JPanel panelPrice1 = new JPanel();
		panelPrice1.setLayout(null);
		panelPrice1.setBackground(new Color(255, 204, 204));
		panelPrice1.setBounds(0, 0, 1320, 436);
		panel.add(panelPrice1);
		
		JLabel lblNewLabel_1 = new JLabel("Price List 1");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 35));
		lblNewLabel_1.setBounds(33, 11, 227, 43);
		panelPrice1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_4 = new JLabel((Icon) null);
		lblNewLabel_4.setBounds(54, 550, 911, 50);
		panelPrice1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_3 = new JLabel((Icon) null);
		lblNewLabel_3.setBounds(776, 18, 41, 36);
		panelPrice1.add(lblNewLabel_3);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(Color.BLACK);
		separator_1.setBounds(10, 52, 494, 2);
		panelPrice1.add(separator_1);
		
		JScrollPane scrollPane_Shape = new JScrollPane((Component) null);
		scrollPane_Shape.setFont(new Font("Tahoma", Font.BOLD, 15));
		scrollPane_Shape.setBounds(10, 64, 399, 354);
		panelPrice1.add(scrollPane_Shape);
		
		table_Shape = new JTable();
		table_Shape.setBackground(new Color(128, 255, 255));
		table_Shape.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table_Shape.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Shape", "Price"
			}
		));
		findShape();
		loadInformationShape();
		scrollPane_Shape.setViewportView(table_Shape);
		
		JScrollPane scrollPane_Color = new JScrollPane((Component) null);
		scrollPane_Color.setFont(new Font("Tahoma", Font.BOLD, 15));
		scrollPane_Color.setBounds(450, 64, 399, 354);
		panelPrice1.add(scrollPane_Color);
		
		table_Color = new JTable();
		table_Color.setBackground(new Color(198, 198, 255));
		table_Color.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Color", "Price"
			}
		));
		findColor();
		loadInformationColor();
		table_Color.setFont(new Font("Tahoma", Font.PLAIN, 15));
		scrollPane_Color.setViewportView(table_Color);
		
		JScrollPane scrollPane_Tier = new JScrollPane((Component) null);
		scrollPane_Tier.setFont(new Font("Tahoma", Font.BOLD, 15));
		scrollPane_Tier.setBounds(894, 64, 407, 354);
		panelPrice1.add(scrollPane_Tier);
		
		table_Tier = new JTable();
		table_Tier.setBackground(new Color(174, 255, 174));
		table_Tier.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Tier", "Price"
			}
		));
		findTier();
		loadInformationTier();
		table_Tier.setFont(new Font("Tahoma", Font.PLAIN, 15));
		scrollPane_Tier.setViewportView(table_Tier);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField_6.setColumns(10);
		textField_6.setBounds(727, 5, 238, 36);
		panelPrice1.add(textField_6);
		
		JButton btnNewButton_Exit1 = new JButton("Exit");
		btnNewButton_Exit1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Cake cake = new Cake();
				cake.setVisible(true);
			}
		});
		btnNewButton_Exit1.setForeground(new Color(128, 0, 0));
		btnNewButton_Exit1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_Exit1.setBackground(new Color(255, 128, 128));
		btnNewButton_Exit1.setBounds(1212, 0, 98, 43);
		panelPrice1.add(btnNewButton_Exit1);
		//-------------------BANG2 --------------------------
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(223, 255, 255));
		tabbedPane.addTab("Price 2", null, panel_1, null);
		panel_1.setLayout(null);
		
		JPanel panelPrice1_1 = new JPanel();
		panelPrice1_1.setBackground(new Color(255, 203, 179));
		panelPrice1_1.setBounds(0, 0, 1320, 436);
		panel_1.add(panelPrice1_1);
		panelPrice1_1.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("Price List 2");
		lblNewLabel_1_1.setBounds(33, 11, 244, 43);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 35));
		panelPrice1_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2_1 = new JLabel((Icon) null);
		lblNewLabel_2_1.setBounds(242, 11, 54, 38);
		panelPrice1_1.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_4_1 = new JLabel((Icon) null);
		lblNewLabel_4_1.setBounds(54, 550, 911, 50);
		panelPrice1_1.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_3_1 = new JLabel((Icon) null);
		lblNewLabel_3_1.setBounds(776, 18, 41, 36);
		panelPrice1_1.add(lblNewLabel_3_1);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(10, 52, 494, 2);
		separator_1_1.setBackground(Color.BLACK);
		panelPrice1_1.add(separator_1_1);
		
		JScrollPane scrollPane_Fruit = new JScrollPane((Component) null);
		scrollPane_Fruit.setBounds(10, 64, 399, 354);
		scrollPane_Fruit.setFont(new Font("Tahoma", Font.BOLD, 15));
		panelPrice1_1.add(scrollPane_Fruit);
		
		table_Fruit = new JTable();
		table_Fruit.setBackground(new Color(128, 255, 255));
		table_Fruit.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Fruit", "Price"
			}
		));
		findFruit();
		loadInformationFruit();
		scrollPane_Fruit.setViewportView(table_Fruit);
		
		JScrollPane scrollPane_Taste = new JScrollPane((Component) null);
		scrollPane_Taste.setBounds(450, 64, 399, 354);
		scrollPane_Taste.setFont(new Font("Tahoma", Font.BOLD, 15));
		panelPrice1_1.add(scrollPane_Taste);
		
		table_Part = new JTable();
		table_Part.setBackground(new Color(166, 166, 255));
		table_Part.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Part", "Price"
			}
		));
		findPart();
		loadInformationPart();
		table_Part.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table_Part.setForeground(new Color(0, 0, 0));
		scrollPane_Taste.setViewportView(table_Part);
		
		JScrollPane scrollPane_Tier_1 = new JScrollPane((Component) null);
		scrollPane_Tier_1.setBounds(894, 64, 407, 354);
		scrollPane_Tier_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		panelPrice1_1.add(scrollPane_Tier_1);
		
		table_Taste = new JTable();
		table_Taste.setBackground(new Color(162, 255, 162));
		table_Taste.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Taste", "Price"
			}
		));
		findTaste();
		loadInformationTaste();
		scrollPane_Tier_1.setViewportView(table_Taste);
		
		textField = new JTextField();
		textField.setBounds(727, 5, 238, 36);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField.setColumns(10);
		panelPrice1_1.add(textField);
		
		JButton btnNewButton_Exit1_1 = new JButton("Exit");
		btnNewButton_Exit1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Cake cake = new Cake();
				cake.setVisible(true);
			}
		});
		btnNewButton_Exit1_1.setBounds(1212, 0, 98, 43);
		btnNewButton_Exit1_1.setForeground(new Color(128, 0, 0));
		btnNewButton_Exit1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_Exit1_1.setBackground(new Color(255, 128, 128));
		panelPrice1_1.add(btnNewButton_Exit1_1);
	}
	//Shape
	private void findShape() {
		try {
			Connection con = DataSQL.getConnection();
			PreparedStatement pre = con.prepareStatement("select Name,Price,IdShapes from Shapes");
			ResultSet rs = pre.executeQuery();
			listShape.clear();
			while (rs.next()) {
				SaveShapeMana shape = new SaveShapeMana(rs.getInt(2), rs.getInt(3),rs.getString(1));
				listShape.add(shape);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void loadInformationShape() {
		modelShape = (DefaultTableModel) table_Shape.getModel();
		modelShape.setRowCount(0);
		Object[] row = new Object[2];
		for (int i = 0; i < listShape.size(); i++) {
			row[0] = listShape.get(i).getTenShape();
			row[1] = listShape.get(i).getGiaShape();
		
			modelShape.addRow(row);
		}
		table_Shape.setRowHeight(40);

	}

	//COlor
	private void findColor() {
		try {
			Connection con = DataSQL.getConnection();
			PreparedStatement pre = con.prepareStatement("select Name,Price,IdColor from Colors");
			ResultSet rs = pre.executeQuery();
			listColor.clear();
			while (rs.next()) {
				SaveColorMana color = new SaveColorMana(rs.getInt(2),rs.getInt(3), rs.getString(1));
				listColor.add(color);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void loadInformationColor() {
		modelColor = (DefaultTableModel) table_Color.getModel();
		modelColor.setRowCount(0);
		Object[] row = new Object[2];
		for (int i = 0; i < listColor.size(); i++) {
			row[0] = listColor.get(i).getTenColor();
			row[1] = listColor.get(i).getGiaColor();
		
			modelColor.addRow(row);
		}
		table_Color.setRowHeight(40);

	}
	//Tier
	private void findTier() {
		try {
			Connection con = DataSQL.getConnection();
			PreparedStatement pre = con.prepareStatement("select Name,Price,IdTiers from Tiers");
			ResultSet rs = pre.executeQuery();
			listTier.clear();
			while (rs.next()) {
				SaveTierMana tier = new SaveTierMana(rs.getInt(2),rs.getInt(3), rs.getString(1));
				listTier.add(tier);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void loadInformationTier() {
		modelTier = (DefaultTableModel) table_Tier.getModel();
		modelTier.setRowCount(0);
		Object[] row = new Object[2];
		for (int i = 0; i < listTier.size(); i++) {
			row[0] = listTier.get(i).getTenTierMana();
			row[1] = listTier.get(i).getGiaTier();
			
			modelTier.addRow(row);
		}
		table_Tier.setRowHeight(40);

	}
	//Fruit
	private void findFruit() {
		try {
			Connection con = DataSQL.getConnection();
			PreparedStatement pre = con.prepareStatement("select Name,Price,IdFruit from Fruits");
			ResultSet rs = pre.executeQuery();
			listFruit.clear();
			while (rs.next()) {
				SaveFruitMana fruit = new SaveFruitMana(rs.getInt(2),rs.getInt(3), rs.getString(1));
				listFruit.add(fruit);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void loadInformationFruit() {
		modelFruit = (DefaultTableModel) table_Fruit.getModel();
		modelFruit.setRowCount(0);
		Object[] row = new Object[2];
		for (int i = 0; i < listFruit.size(); i++) {
			row[0] = listFruit.get(i).getTenFruit();
			row[1] = listFruit.get(i).getGiaFruit();
			
			modelFruit.addRow(row);
		}
		table_Fruit.setRowHeight(40);

	}

	//Part
	private void findPart() {
		try {
			Connection con = DataSQL.getConnection();
			PreparedStatement pre = con.prepareStatement("select Name,Price,IdPart from Parts");
			ResultSet rs = pre.executeQuery();
			listPart.clear();
			while (rs.next()) {
				SavePartMana part = new SavePartMana(rs.getInt(2),rs.getInt(3) ,rs.getString(1));
				listPart.add(part);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void loadInformationPart() {
		modelPart = (DefaultTableModel) table_Part.getModel();
		modelPart.setRowCount(0);
		Object[] row = new Object[2];
		for (int i = 0; i < listPart.size(); i++) {
			row[0] = listPart.get(i).getTenPart();
			row[1] = listPart.get(i).getGiaPart();
		
			modelPart.addRow(row);
		}
		table_Part.setRowHeight(40);

	}
	//Taste
	private void findTaste() {
		try {
			Connection con = DataSQL.getConnection();
			PreparedStatement pre = con.prepareStatement("select Name,Price,IdTaste from Tastes");
			ResultSet rs = pre.executeQuery();
			listTaste.clear();
			while (rs.next()) {
				SaveTasteMana taste = new SaveTasteMana(rs.getInt(2),rs.getInt(3), rs.getString(1));
				listTaste.add(taste);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void loadInformationTaste() {
		modelTaste = (DefaultTableModel) table_Taste.getModel();
		modelTaste.setRowCount(0);
		Object[] row = new Object[2];
		for (int i = 0; i < listTaste.size(); i++) {
			row[0] = listTaste.get(i).getTenTaste();
			row[1] = listTaste.get(i).getGiaTaste();
			
			modelTaste.addRow(row);
		}
		table_Taste.setRowHeight(40);

	}
}
