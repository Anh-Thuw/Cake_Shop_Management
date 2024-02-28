package PartyShopManagerThuQuynh;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import SavePartyShopManager.SaveColorMana;
import SavePartyShopManager.SaveFruitMana;
import SavePartyShopManager.SavePartMana;
import SavePartyShopManager.SaveShapeMana;
import SavePartyShopManager.SaveTasteMana;
import SavePartyShopManager.SaveTierMana;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PriceMana extends JPanel {
	ArrayList<SaveFruitMana> listFruit = new ArrayList<SaveFruitMana>();
	ArrayList<SaveShapeMana> listShape = new ArrayList<SaveShapeMana>();
	ArrayList<SaveColorMana> listColor = new ArrayList<SaveColorMana>();
	ArrayList<SavePartMana> listPart = new ArrayList<SavePartMana>();
	ArrayList<SaveTasteMana> listTaste = new ArrayList<SaveTasteMana>();
	ArrayList<SaveTierMana> listTier = new ArrayList<SaveTierMana>();
	private JTabbedPane tabbedPane;
	private JPanel panelPrice1;
	private JPanel panelPrice2;
	private JTable table_Shape, table_Color, table_Tier, table_Fruit, table_Part, table_Taste;
	private JTextField textField_NameS;
	private JTextField textField_PriceS;
	private JTextField textField_NameC;
	private JTextField textField_PriceC;
	private JTextField textField_NameTI;
	private JTextField textField_PriceTI;
	private JTextField textField_NameF;
	private JTextField textField_PriceF;
	private JTextField textField_NameP;
	private JTextField textField_PriceP;
	private JTextField textField_NameTA;
	private JTextField textField_PriceTA;
	// private JTable table;
	private JSeparator separator;
	private JLabel lblNewLabel;
	private JLabel lblPrice;
	private JLabel lblPrice_1;
	private JLabel lblPrice_2;
	private JLabel lblMainColor;
	private JLabel lblTier;
	private JLabel lblNewLabel_1;
	private JSeparator separator_1;
	private JSeparator separator_2;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JTextField textField_Find1;
	private JTextField textField_Find2;
	private JButton btnNewButton_Del;
	private JButton btnNewButton_Del_3;
	private JButton btnNewButton_Add;
	private JButton btnNewButton_Add_3;
	private JButton btnNewButton_Edit;
	private JButton btnNewButton_Edit_3;
	private JButton btnNewButton_Update;
	private JButton btnNewButton_Update_3;
	private JButton btnNewButton_Del_1;
	private JButton btnNewButton_Del_1_1;
	private JButton btnNewButton_Add_1;
	private JButton btnNewButton_Add_1_1;
	private JButton btnNewButton_Edit_1;
	private JButton btnNewButton_Edit_1_1;
	private JButton btnNewButton_Update_1;
	private JButton btnNewButton_Update_1_1;
	private JButton btnNewButton_Del_2;
	private JButton btnNewButton_Del_2_1;
	private JButton btnNewButton_Add_2;
	private JButton btnNewButton_Add_2_1;
	private JButton btnNewButton_Edit_2;
	private JButton btnNewButton_Edit_2_1;
	private JButton btnNewButton_Update_2;
	private JButton btnNewButton_Update_2_1;
	private JButton btnNewButton_Find2;
	private JButton btnNewButton_Exit1;
	private JButton btnNewButton_Exit2;
	private JLabel lblNewLabel_4;

	private DefaultTableModel modelFruit , modelColor , modelPart , modelShape , modelTaste , modelTier ;

	/**
	 * Create the panel.
	 */
	public PriceMana() {
		setBackground(new Color(234, 255, 255));
		setLayout(null);
		setLayout(null);
		setBounds(0, 0, 1156, 652);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(new Color(234, 255, 255));
		tabbedPane.setForeground(new Color(128, 0, 0));
		tabbedPane.setFont(new Font("Sylfaen", Font.BOLD, 25));
		tabbedPane.setBounds(0, 0, 1156, 652);
		add(tabbedPane);

//-------------------Bang1---------------------
		panelPrice1 = new JPanel();
		panelPrice1.setBackground(new Color(223, 255, 255));
		tabbedPane.addTab("Price 1", null, panelPrice1, null);
		panelPrice1.setLayout(null);

		lblNewLabel_1 = new JLabel("Price List 1");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 35));
		lblNewLabel_1.setBounds(33, 11, 244, 43);
		panelPrice1.add(lblNewLabel_1);

		lblNewLabel_2 = new JLabel(new ImageIcon(
				new ImageIcon(Toolkit.getDefaultToolkit().getImage(PriceMana.class.getResource("/Image/money.jpg")))
						.getImage().getScaledInstance(41, 36, Image.SCALE_DEFAULT)));
		lblNewLabel_2.setBounds(242, 11, 54, 38);
		panelPrice1.add(lblNewLabel_2);

		lblNewLabel_4 = new JLabel(new ImageIcon(
				new ImageIcon(Toolkit.getDefaultToolkit().getImage(PriceMana.class.getResource("/Image/money2.jpg")))
						.getImage().getScaledInstance(911, 50, Image.SCALE_DEFAULT)));
		lblNewLabel_4.setBounds(54, 550, 911, 50);
		panelPrice1.add(lblNewLabel_4);

		lblNewLabel_3 = new JLabel(new ImageIcon(
				new ImageIcon(Toolkit.getDefaultToolkit().getImage(PriceMana.class.getResource("/Image/kinhlup.png")))
						.getImage().getScaledInstance(41, 36, Image.SCALE_DEFAULT)));
		lblNewLabel_3.setBounds(776, 18, 41, 36);
		panelPrice1.add(lblNewLabel_3);

		lblNewLabel = new JLabel("Shape:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(52, 369, 92, 35);
		panelPrice1.add(lblNewLabel);

		lblPrice = new JLabel("Price:");
		lblPrice.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPrice.setBounds(52, 424, 92, 35);
		panelPrice1.add(lblPrice);

		lblPrice_1 = new JLabel("Price:");
		lblPrice_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPrice_1.setBounds(422, 428, 92, 35);
		panelPrice1.add(lblPrice_1);

		lblPrice_2 = new JLabel("Price:");
		lblPrice_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPrice_2.setBounds(827, 428, 92, 35);
		panelPrice1.add(lblPrice_2);

		lblMainColor = new JLabel("Main Color:");
		lblMainColor.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMainColor.setBounds(422, 371, 109, 35);
		panelPrice1.add(lblMainColor);

		lblTier = new JLabel("Tier:");
		lblTier.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTier.setBounds(827, 371, 92, 35);
		panelPrice1.add(lblTier);

		separator = new JSeparator();
		separator.setForeground(new Color(0, 0, 0));
		separator.setBackground(new Color(0, 0, 0));
		separator.setBounds(5, 340, 1140, 1);
		panelPrice1.add(separator);

		separator_1 = new JSeparator();
		separator_1.setBackground(Color.BLACK);
		separator_1.setBounds(10, 52, 494, 2);
		panelPrice1.add(separator_1);

		separator_2 = new JSeparator();
		separator_2.setForeground(Color.BLACK);
		separator_2.setBackground(Color.BLACK);
		separator_2.setBounds(10, 546, 1140, 1);
		panelPrice1.add(separator_2);

		// ???????hinh dang
		table_Shape = new JTable();
		table_Shape.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				showShape();
			}
		});
		table_Shape.setBackground(new Color(223, 223, 223));
//		table.setFont(new Font("Tahoma", Font.PLAIN, 25));
		table_Shape
				.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Shape", "Price"
			}
		));
		findShape();
		loadInformationShape();
		table_Shape.setBounds(375, 91, 889, 422);
		JScrollPane scrollPane_Shape = new JScrollPane(table_Shape);
		scrollPane_Shape.setBounds(10, 82, 380, 254);
		scrollPane_Shape.setFont(new Font("Tahoma", Font.BOLD, 15));
		panelPrice1.add(scrollPane_Shape);

		textField_NameS = new JTextField();
		textField_NameS.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField_NameS.setColumns(10);
		textField_NameS.setBounds(123, 367, 210, 35);
		panelPrice1.add(textField_NameS);

		textField_PriceS = new JTextField();
		textField_PriceS.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField_PriceS.setColumns(10);
		textField_PriceS.setBounds(123, 424, 210, 35);
		panelPrice1.add(textField_PriceS);

		// mausac????????
		table_Color = new JTable();
		table_Color.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				showColor();
			}
		});
		table_Color.setBackground(new Color(255, 198, 198));
//				table.setFont(new Font("Tahoma", Font.PLAIN, 25));
		table_Color.setModel(
				new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Main Color", "Price"
			}
		));
findColor();
loadInformationColor();
		table_Color.setBounds(375, 91, 889, 422);
		JScrollPane scrollPane_Color = new JScrollPane(table_Color);
		scrollPane_Color.setBounds(393, 82, 380, 254);
		scrollPane_Color.setFont(new Font("Tahoma", Font.BOLD, 15));
		panelPrice1.add(scrollPane_Color);

		textField_NameC = new JTextField();
		textField_NameC.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_NameC.setColumns(10);
		textField_NameC.setBounds(512, 367, 210, 35);
		panelPrice1.add(textField_NameC);

		textField_PriceC = new JTextField();
		textField_PriceC.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_PriceC.setColumns(10);
		textField_PriceC.setBounds(512, 424, 210, 35);
		panelPrice1.add(textField_PriceC);

		// @@@@@tang
		table_Tier = new JTable();
		table_Tier.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				showTier();
			}
		});
		table_Tier.setBackground(new Color(181, 218, 255));
//				table.setFont(new Font("Tahoma", Font.PLAIN, 25));
		table_Tier
				.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Tier", "Price"
			}
		));
findTier();
loadInformationTier();
		table_Tier.setBounds(375, 91, 889, 422);
		JScrollPane scrollPane_Tier = new JScrollPane(table_Tier);
		scrollPane_Tier.setBounds(776, 82, 365, 254);
		scrollPane_Tier.setFont(new Font("Tahoma", Font.BOLD, 15));
		panelPrice1.add(scrollPane_Tier);

		textField_NameTI = new JTextField();
		textField_NameTI.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_NameTI.setColumns(10);
		textField_NameTI.setBounds(884, 367, 210, 35);
		panelPrice1.add(textField_NameTI);

		textField_PriceTI = new JTextField();
		textField_PriceTI.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_PriceTI.setColumns(10);
		textField_PriceTI.setBounds(884, 424, 210, 35);
		panelPrice1.add(textField_PriceTI);

		textField_Find1 = new JTextField();
		textField_Find1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField_Find1.setColumns(10);
		textField_Find1.setBounds(821, 18, 238, 36);
		panelPrice1.add(textField_Find1);

		btnNewButton_Del = new JButton("Delete");
		btnNewButton_Del.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tenShape = textField_NameS.getText();
				SQL xuLy = new SQL();
				if (xuLy.deleteShape(tenShape)) {
					ClearShape();
					findShape();
					loadInformationShape();
					JOptionPane.showMessageDialog(null, "Delete Successfully");
				} else {
					JOptionPane.showMessageDialog(null, "Delete Error");
				}
				
			}
		});
		btnNewButton_Del.setForeground(new Color(0, 64, 128));
		btnNewButton_Del.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_Del.setBackground(new Color(255, 221, 221));
		btnNewButton_Del.setBounds(10, 485, 83, 36);
		panelPrice1.add(btnNewButton_Del);

		btnNewButton_Del_1 = new JButton("Delete");
		btnNewButton_Del_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tenColor = textField_NameC.getText();
				SQL xuLy = new SQL();
				if (xuLy.deleteColor(tenColor)) {
					ClearColor();
					findColor();
					loadInformationColor();
					JOptionPane.showMessageDialog(null, "Delete Successfully");
				} else {
					JOptionPane.showMessageDialog(null, "Delete Error");
				}
			}
		});
		btnNewButton_Del_1.setForeground(new Color(0, 64, 128));
		btnNewButton_Del_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_Del_1.setBackground(new Color(255, 221, 221));
		btnNewButton_Del_1.setBounds(408, 485, 83, 36);
		panelPrice1.add(btnNewButton_Del_1);

		btnNewButton_Del_2 = new JButton("Delete");
		btnNewButton_Del_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tenTier = textField_NameTI.getText();
				SQL xuLy = new SQL();
			if (xuLy.deleteTiers(tenTier)) {
					ClearTier();
					findTier();
					loadInformationTier();
					JOptionPane.showMessageDialog(null, "Delete Successfully");
				} else {
					JOptionPane.showMessageDialog(null, "Delete Error");
				}
			}
		});
		btnNewButton_Del_2.setForeground(new Color(0, 64, 128));
		btnNewButton_Del_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_Del_2.setBackground(new Color(255, 221, 221));
		btnNewButton_Del_2.setBounds(791, 485, 83, 36);
		panelPrice1.add(btnNewButton_Del_2);

		btnNewButton_Add = new JButton("Add");
		btnNewButton_Add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SaveShapeMana shape = new SaveShapeMana();
				int gia = Integer.parseInt(textField_PriceS.getText());
				shape.setTenShape(textField_NameS.getText());
				shape.setGiaShape(gia);
				SQL xuly = new SQL();
				if (xuly.saveShape(shape)) {
					findShape();
					loadInformationShape();
					ClearShape();
				}

			}
		});
		btnNewButton_Add.setForeground(new Color(0, 64, 128));
		btnNewButton_Add.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_Add.setBackground(new Color(255, 221, 221));
		btnNewButton_Add.setBounds(104, 485, 71, 36);
		panelPrice1.add(btnNewButton_Add);

		btnNewButton_Add_1 = new JButton("Add");
		btnNewButton_Add_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SaveColorMana color = new SaveColorMana();
				int gia = Integer.parseInt(textField_PriceC.getText());
				color.setTenColor(textField_NameC.getText());
				color.setGiaColor(gia);
				SQL xuly = new SQL();
				if (xuly.saveColor(color)) {
					findColor();
					loadInformationColor();
					ClearColor();
				}
			}
		});
		btnNewButton_Add_1.setForeground(new Color(0, 64, 128));
		btnNewButton_Add_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_Add_1.setBackground(new Color(255, 221, 221));
		btnNewButton_Add_1.setBounds(501, 485, 71, 36);
		panelPrice1.add(btnNewButton_Add_1);

		btnNewButton_Add_2 = new JButton("Add");
		btnNewButton_Add_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SaveTierMana tier = new SaveTierMana();
				int gia = Integer.parseInt(textField_PriceTI.getText());
				tier.setTenTierMana(textField_NameTI.getText());
				tier.setGiaTier(gia);
				SQL xuly = new SQL();
				if (xuly.saveTiers(tier)) {
					findTier();
					loadInformationTier();
					ClearTier();
				}
			}
		});
		btnNewButton_Add_2.setForeground(new Color(0, 64, 128));
		btnNewButton_Add_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_Add_2.setBackground(new Color(255, 221, 221));
		btnNewButton_Add_2.setBounds(884, 485, 71, 36);
		panelPrice1.add(btnNewButton_Add_2);

		btnNewButton_Edit = new JButton("Clear");
		btnNewButton_Edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClearShape();
			}
		});
		btnNewButton_Edit.setForeground(new Color(0, 64, 128));
		btnNewButton_Edit.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_Edit.setBackground(new Color(255, 221, 221));
		btnNewButton_Edit.setBounds(185, 485, 83, 36);
		panelPrice1.add(btnNewButton_Edit);

		btnNewButton_Edit_1 = new JButton("Clear");
		btnNewButton_Edit_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClearColor();
			}
		});
		btnNewButton_Edit_1.setForeground(new Color(0, 64, 128));
		btnNewButton_Edit_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_Edit_1.setBackground(new Color(255, 221, 221));
		btnNewButton_Edit_1.setBounds(582, 485, 83, 36);
		panelPrice1.add(btnNewButton_Edit_1);

		btnNewButton_Edit_2 = new JButton("Clear");
		btnNewButton_Edit_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClearTier();
			}
		});
		btnNewButton_Edit_2.setForeground(new Color(0, 64, 128));
		btnNewButton_Edit_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_Edit_2.setBackground(new Color(255, 221, 221));
		btnNewButton_Edit_2.setBounds(965, 485, 83, 36);
		panelPrice1.add(btnNewButton_Edit_2);

		btnNewButton_Update = new JButton("Update");
		btnNewButton_Update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				try {
					int giaShape = Integer.parseInt(textField_PriceS.getText());
					SaveShapeMana shape = new SaveShapeMana();
					shape.setGiaShape(giaShape);
					shape.setTenShape(textField_NameS.getText());
					updateShape(shape);
					ClearShape();
					findShape();
					loadInformationShape();
					JOptionPane.showMessageDialog(null, "Updata Successfully ");
					
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Updata Error ");
				}			
			}
		});
		btnNewButton_Update.setForeground(new Color(0, 64, 128));
		btnNewButton_Update.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_Update.setBackground(new Color(255, 221, 221));
		btnNewButton_Update.setBounds(274, 485, 92, 36);
		panelPrice1.add(btnNewButton_Update);

		btnNewButton_Update_1 = new JButton("Update");
		btnNewButton_Update_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int giaColor = Integer.parseInt(textField_PriceC.getText());
					SaveColorMana color = new SaveColorMana();
					color.setGiaColor(giaColor);
					color.setTenColor(textField_NameC.getText());
					updateColor(color);
					ClearColor();
					findColor();
					loadInformationColor();
					JOptionPane.showMessageDialog(null, "Updata Successfully ");
					
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Updata Error ");
				}
			}
		});
		btnNewButton_Update_1.setForeground(new Color(0, 64, 128));
		btnNewButton_Update_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_Update_1.setBackground(new Color(255, 221, 221));
		btnNewButton_Update_1.setBounds(675, 485, 98, 36);
		panelPrice1.add(btnNewButton_Update_1);

		btnNewButton_Update_2 = new JButton("Update");
		btnNewButton_Update_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					int giaTier = Integer.parseInt(textField_PriceTI.getText());
					SaveTierMana tier = new SaveTierMana();
					tier.setGiaTier(giaTier);
					tier.setTenTierMana(textField_NameTI.getText());
					updateTiers(tier);
					ClearTier();
					findTier();
					loadInformationTier();
					JOptionPane.showMessageDialog(null, "Updata Successfully ");
					
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Updata Error ");
				}
			}
		});
		btnNewButton_Update_2.setForeground(new Color(0, 64, 128));
		btnNewButton_Update_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_Update_2.setBackground(new Color(255, 221, 221));
		btnNewButton_Update_2.setBounds(1056, 485, 92, 36);
		panelPrice1.add(btnNewButton_Update_2);

		btnNewButton_Exit1 = new JButton("Exit");
		btnNewButton_Exit1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				HomeManager hom = new HomeManager();
				hom.setVisible(true);
			}
		});
		btnNewButton_Exit1.setForeground(new Color(128, 0, 0));
		btnNewButton_Exit1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_Exit1.setBackground(new Color(255, 128, 128));
		btnNewButton_Exit1.setBounds(1022, 554, 98, 43);
		panelPrice1.add(btnNewButton_Exit1);

//---------------------------------Bang2--------------------------------
		panelPrice2 = new JPanel();
		panelPrice2.setBackground(new Color(185, 255, 255));
		tabbedPane.addTab("Price 2", null, panelPrice2, null);
		panelPrice2.setLayout(null);

		lblNewLabel_1 = new JLabel("Price List 2");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 35));
		lblNewLabel_1.setBounds(33, 11, 244, 43);
		panelPrice2.add(lblNewLabel_1);

		lblNewLabel_2 = new JLabel(new ImageIcon(
				new ImageIcon(Toolkit.getDefaultToolkit().getImage(PriceMana.class.getResource("/Image/money.jpg")))
						.getImage().getScaledInstance(41, 36, Image.SCALE_DEFAULT)));
		lblNewLabel_2.setBounds(242, 11, 54, 38);
		panelPrice2.add(lblNewLabel_2);

		lblNewLabel_4 = new JLabel(new ImageIcon(
				new ImageIcon(Toolkit.getDefaultToolkit().getImage(PriceMana.class.getResource("/Image/money3.jpg")))
						.getImage().getScaledInstance(911, 50, Image.SCALE_DEFAULT)));
		lblNewLabel_4.setBounds(54, 550, 911, 50);
		panelPrice2.add(lblNewLabel_4);

		lblNewLabel_3 = new JLabel(new ImageIcon(
				new ImageIcon(Toolkit.getDefaultToolkit().getImage(PriceMana.class.getResource("/Image/kinhlup.png")))
						.getImage().getScaledInstance(41, 36, Image.SCALE_DEFAULT)));
		lblNewLabel_3.setBounds(776, 18, 41, 36);
		panelPrice2.add(lblNewLabel_3);

		lblNewLabel = new JLabel("Fruit:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(52, 369, 64, 35);
		panelPrice2.add(lblNewLabel);

		lblPrice = new JLabel("Price:");
		lblPrice.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPrice.setBounds(52, 424, 64, 35);
		panelPrice2.add(lblPrice);

		lblPrice_1 = new JLabel("Price:");
		lblPrice_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPrice_1.setBounds(462, 424, 64, 35);
		panelPrice2.add(lblPrice_1);

		lblPrice_2 = new JLabel("Price:");
		lblPrice_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPrice_2.setBounds(827, 424, 64, 35);
		panelPrice2.add(lblPrice_2);

		lblMainColor = new JLabel("Part:");
		lblMainColor.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMainColor.setBounds(462, 369, 64, 35);
		panelPrice2.add(lblMainColor);

		lblTier = new JLabel("Taste:");
		lblTier.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTier.setBounds(827, 371, 64, 35);
		panelPrice2.add(lblTier);

		separator = new JSeparator();
		separator.setForeground(new Color(0, 0, 0));
		separator.setBackground(new Color(0, 0, 0));
		separator.setBounds(5, 340, 1140, 1);
		panelPrice2.add(separator);

		separator_1 = new JSeparator();
		separator_1.setBackground(Color.BLACK);
		separator_1.setBounds(10, 52, 494, 2);
		panelPrice2.add(separator_1);

		separator_2 = new JSeparator();
		separator_2.setForeground(Color.BLACK);
		separator_2.setBackground(Color.BLACK);
		separator_2.setBounds(10, 546, 1140, 1);
		panelPrice2.add(separator_2);

		// ???????????trai con
		table_Fruit = new JTable();
		table_Fruit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				showFruit();
			}
		});
		table_Fruit.setBackground(new Color(193, 255, 193));
//		table.setFont(new Font("Tahoma", Font.PLAIN, 25));
		table_Fruit.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Fruit", "Price"
			}
		));
		findFruit();
		loadInformationFruit();

		table_Fruit.setBounds(375, 91, 889, 422);
		JScrollPane scrollPane_Fruit = new JScrollPane(table_Fruit);
		scrollPane_Fruit.setBounds(10, 82, 380, 254);
		scrollPane_Fruit.setFont(new Font("Tahoma", Font.BOLD, 15));
		panelPrice2.add(scrollPane_Fruit);

		textField_NameF = new JTextField();
		textField_NameF.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_NameF.setColumns(10);
		textField_NameF.setBounds(102, 369, 210, 35);
		panelPrice2.add(textField_NameF);

		textField_PriceF = new JTextField();
		textField_PriceF.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_PriceF.setColumns(10);
		textField_PriceF.setBounds(102, 424, 210, 35);
		panelPrice2.add(textField_PriceF);

		// phu kien????????
		table_Part = new JTable();
		table_Part.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				showPart();
			}
		});
		table_Part.setBackground(new Color(255, 255, 221));
//		table.setFont(new Font("Tahoma", Font.PLAIN, 25));
		table_Part
				.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Part", "Price"
			}
		));
findPart();
loadInformationPart();
		table_Part.setBounds(375, 91, 889, 422);
		JScrollPane scrollPane_Part = new JScrollPane(table_Part);
		scrollPane_Part.setBounds(393, 82, 380, 254);
		scrollPane_Part.setFont(new Font("Tahoma", Font.BOLD, 15));
		panelPrice2.add(scrollPane_Part);

		textField_NameP = new JTextField();
		textField_NameP.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_NameP.setColumns(10);
		textField_NameP.setBounds(512, 369, 210, 35);
		panelPrice2.add(textField_NameP);

		textField_PriceP = new JTextField();
		textField_PriceP.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_PriceP.setColumns(10);
		textField_PriceP.setBounds(512, 424, 210, 35);
		panelPrice2.add(textField_PriceP);

		// @@@@@huong vi
		table_Taste = new JTable();
		table_Taste.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				showTaste();
			}
		});
		table_Taste.setBackground(new Color(206, 206, 255));
//		table.setFont(new Font("Tahoma", Font.PLAIN, 25));
		table_Taste
				.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Taste", "Price"
			}
		));
		findTaste();
		loadInformationTaste();

		table_Taste.setBounds(375, 91, 889, 422);
		JScrollPane scrollPane_Taste = new JScrollPane(table_Taste);
		scrollPane_Taste.setBounds(776, 82, 365, 254);
		scrollPane_Taste.setFont(new Font("Tahoma", Font.BOLD, 15));
		panelPrice2.add(scrollPane_Taste);

		textField_NameTA = new JTextField();
		textField_NameTA.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_NameTA.setColumns(10);
		textField_NameTA.setBounds(884, 369, 210, 35);
		panelPrice2.add(textField_NameTA);

		textField_PriceTA = new JTextField();
		textField_PriceTA.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_PriceTA.setColumns(10);
		textField_PriceTA.setBounds(884, 424, 210, 35);
		panelPrice2.add(textField_PriceTA);

		textField_Find2 = new JTextField();
		textField_Find2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField_Find2.setColumns(10);
		textField_Find2.setBounds(821, 18, 238, 36);
		panelPrice2.add(textField_Find2);

		btnNewButton_Del_3 = new JButton("Delete");
		btnNewButton_Del_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tenFruit = textField_NameF.getText();
				SQL xuLy = new SQL();
				if (xuLy.deleteFruit(tenFruit)) {
					ClearFruit();
					findFruit();
					loadInformationFruit();
					JOptionPane.showMessageDialog(null, "Delete Successfully");
				} else {
					JOptionPane.showMessageDialog(null, "Delete Error");
				}
			}
		});
		btnNewButton_Del_3.setForeground(new Color(0, 64, 128));
		btnNewButton_Del_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_Del_3.setBackground(new Color(255, 221, 221));
		btnNewButton_Del_3.setBounds(10, 485, 83, 36);
		panelPrice2.add(btnNewButton_Del_3);

		btnNewButton_Del_1_1 = new JButton("Delete");
		btnNewButton_Del_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tenPart = textField_NameP.getText();
				SQL xuLy = new SQL();
				if (xuLy.deletePart(tenPart)) {
					ClearPart();
					findPart();
					loadInformationPart();
					JOptionPane.showMessageDialog(null, "Delete Successfully");
				} else {
					JOptionPane.showMessageDialog(null, "Delete Error");
				}
			}
		});
		btnNewButton_Del_1_1.setForeground(new Color(0, 64, 128));
		btnNewButton_Del_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_Del_1_1.setBackground(new Color(255, 221, 221));
		btnNewButton_Del_1_1.setBounds(408, 485, 83, 36);
		panelPrice2.add(btnNewButton_Del_1_1);

		btnNewButton_Del_2_1 = new JButton("Delete");
		btnNewButton_Del_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tenTaste = textField_NameTA.getText();
				SQL xuLy = new SQL();
				if (xuLy.deleteTaste(tenTaste)) {
					ClearTaste();
					findTaste();
					loadInformationTaste();
					JOptionPane.showMessageDialog(null, "Delete Successfully");
				} else {
					JOptionPane.showMessageDialog(null, "Delete Error");
				}
			}
		});
		btnNewButton_Del_2_1.setForeground(new Color(0, 64, 128));
		btnNewButton_Del_2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_Del_2_1.setBackground(new Color(255, 221, 221));
		btnNewButton_Del_2_1.setBounds(793, 485, 83, 36);
		panelPrice2.add(btnNewButton_Del_2_1);

		btnNewButton_Add_3 = new JButton("Add");
		btnNewButton_Add_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SaveFruitMana fruit = new SaveFruitMana();
				int gia = Integer.parseInt(textField_PriceF.getText());
				fruit.setTenFruit(textField_NameF.getText());
				fruit.setGiaFruit(gia);
				SQL xuly = new SQL();
				if (xuly.saveFruit(fruit)) {
					findFruit();
					loadInformationFruit();
					ClearFruit();
				}

			}
		});
		btnNewButton_Add_3.setForeground(new Color(0, 64, 128));
		btnNewButton_Add_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_Add_3.setBackground(new Color(255, 221, 221));
		btnNewButton_Add_3.setBounds(104, 485, 71, 36);
		panelPrice2.add(btnNewButton_Add_3);

		btnNewButton_Add_1_1 = new JButton("Add");
		btnNewButton_Add_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SavePartMana part = new SavePartMana();
				int gia = Integer.parseInt(textField_PriceP.getText());
				part.setTenPart(textField_NameP.getText());
				part.setGiaPart(gia);
				SQL xuly = new SQL();
				if (xuly.savePart(part)) {
					findPart();
					loadInformationPart();
					ClearPart();
				}
			}
		});
		btnNewButton_Add_1_1.setForeground(new Color(0, 64, 128));
		btnNewButton_Add_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_Add_1_1.setBackground(new Color(255, 221, 221));
		btnNewButton_Add_1_1.setBounds(501, 485, 71, 36);
		panelPrice2.add(btnNewButton_Add_1_1);

		btnNewButton_Add_2_1 = new JButton("Add");
		btnNewButton_Add_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SaveTasteMana taste = new SaveTasteMana();
				int gia = Integer.parseInt(textField_PriceTA.getText());
				taste.setTenTaste(textField_NameTA.getText());
				taste.setGiaTaste(gia);
				SQL xuly = new SQL();
				if (xuly.saveTaste(taste)) {
					findTaste();
					loadInformationTaste();
					ClearTaste();
				}
			}
		});
		btnNewButton_Add_2_1.setForeground(new Color(0, 64, 128));
		btnNewButton_Add_2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_Add_2_1.setBackground(new Color(255, 221, 221));
		btnNewButton_Add_2_1.setBounds(894, 485, 71, 36);
		panelPrice2.add(btnNewButton_Add_2_1);

		btnNewButton_Edit_3 = new JButton("Clear");
		btnNewButton_Edit_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClearFruit();
			}
		});
		btnNewButton_Edit_3.setForeground(new Color(0, 64, 128));
		btnNewButton_Edit_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_Edit_3.setBackground(new Color(255, 221, 221));
		btnNewButton_Edit_3.setBounds(185, 485, 83, 36);
		panelPrice2.add(btnNewButton_Edit_3);

		btnNewButton_Edit_1_1 = new JButton("Clear");
		btnNewButton_Edit_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClearPart();
			}
		});
		btnNewButton_Edit_1_1.setForeground(new Color(0, 64, 128));
		btnNewButton_Edit_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_Edit_1_1.setBackground(new Color(255, 221, 221));
		btnNewButton_Edit_1_1.setBounds(582, 485, 89, 36);
		panelPrice2.add(btnNewButton_Edit_1_1);

		btnNewButton_Edit_2_1 = new JButton("Clear");
		btnNewButton_Edit_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClearTaste();
			}
		});
		btnNewButton_Edit_2_1.setForeground(new Color(0, 64, 128));
		btnNewButton_Edit_2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_Edit_2_1.setBackground(new Color(255, 221, 221));
		btnNewButton_Edit_2_1.setBounds(970, 485, 78, 36);
		panelPrice2.add(btnNewButton_Edit_2_1);

		btnNewButton_Update_3 = new JButton("Update");
		btnNewButton_Update_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		
				try {
					int giaFruit = Integer.parseInt(textField_PriceF.getText());
					SaveFruitMana fruit = new SaveFruitMana();
					fruit.setGiaFruit(giaFruit);
					fruit.setTenFruit(textField_NameF.getText());
					updateFruit(fruit);
					ClearFruit();
					findFruit();
					loadInformationFruit();
					JOptionPane.showMessageDialog(null, "Updata Successfully ");
					
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Updata Error ");
				}
			}
		});
		btnNewButton_Update_3.setForeground(new Color(0, 64, 128));
		btnNewButton_Update_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_Update_3.setBackground(new Color(255, 221, 221));
		btnNewButton_Update_3.setBounds(276, 485, 92, 36);
		panelPrice2.add(btnNewButton_Update_3);

		btnNewButton_Update_1_1 = new JButton("Update");
		btnNewButton_Update_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int giaPart = Integer.parseInt(textField_PriceP.getText());
					SavePartMana part = new SavePartMana();
					part.setGiaPart(giaPart);
					part.setTenPart(textField_NameP.getText());
					updateParts(part);
					ClearPart();
					findPart();
					loadInformationPart();
					JOptionPane.showMessageDialog(null, "Updata Successfully ");
					
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Updata Error ");
				}
			}
		});
		btnNewButton_Update_1_1.setForeground(new Color(0, 64, 128));
		btnNewButton_Update_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_Update_1_1.setBackground(new Color(255, 221, 221));
		btnNewButton_Update_1_1.setBounds(681, 485, 92, 36);
		panelPrice2.add(btnNewButton_Update_1_1);

		btnNewButton_Update_2_1 = new JButton("Update");
		btnNewButton_Update_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int giaTaste = Integer.parseInt(textField_PriceTA.getText());
					SaveTasteMana taste = new SaveTasteMana();
					taste.setGiaTaste(giaTaste);
					taste.setTenTaste(textField_NameTA.getText());
					updateTaste(taste);
					ClearTaste();
					findTaste();
					loadInformationTaste();
					JOptionPane.showMessageDialog(null, "Updata Successfully ");
					
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Updata Error ");
				}
			}
		});
		btnNewButton_Update_2_1.setForeground(new Color(0, 64, 128));
		btnNewButton_Update_2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_Update_2_1.setBackground(new Color(255, 221, 221));
		btnNewButton_Update_2_1.setBounds(1056, 485, 92, 36);
		panelPrice2.add(btnNewButton_Update_2_1);

		btnNewButton_Find2 = new JButton("Find");
		btnNewButton_Find2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_Find2.setBackground(new Color(217, 217, 217));
		btnNewButton_Find2.setBounds(1063, 26, 72, 23);
		panelPrice2.add(btnNewButton_Find2);

		btnNewButton_Exit2 = new JButton("Exit");
		btnNewButton_Exit2.setForeground(new Color(128, 0, 0));
		btnNewButton_Exit2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_Exit2.setBackground(new Color(255, 128, 128));
		btnNewButton_Exit2.setBounds(1022, 554, 98, 43);
		panelPrice2.add(btnNewButton_Exit2);

	}
// Shape 
	void ClearShape() {
		textField_NameS.setText("");
		textField_PriceS.setText("");

	}

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
		Object[] row = new Object[3];
		for (int i = 0; i < listShape.size(); i++) {
			row[1] = listShape.get(i).getTenShape();
			row[2] = listShape.get(i).getGiaShape();
			row[0] = listShape.get(i).getIdShape();
			modelShape.addRow(row);
		}
		table_Shape.setRowHeight(40);

	}

	private void showShape() {
		modelShape = (DefaultTableModel) table_Shape.getModel();
		int row = table_Shape.getSelectedRow();
		textField_NameS.setText(modelShape.getValueAt(row, 1).toString());
		textField_PriceS.setText(modelShape.getValueAt(row, 2).toString());
	}
	private boolean updateShape( SaveShapeMana shape) {
		Connection con;
		try {
			int row = table_Shape.getSelectedRow();
			String IdShape =  table_Shape.getValueAt(row, 0).toString();
			con = DataSQL.getConnection();
			String sql = "update Shapes " + "set Name = N'"+ textField_NameS.getText()+"' " + ", Price = " + textField_PriceS.getText() + "where IdShapes = " + IdShape;
			PreparedStatement pre = con.prepareStatement(sql);
			pre.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	// color 
	void ClearColor() {
		textField_NameC.setText("");
		textField_PriceC.setText("");

	}

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
		Object[] row = new Object[3];
		for (int i = 0; i < listColor.size(); i++) {
			row[1] = listColor.get(i).getTenColor();
			row[2] = listColor.get(i).getGiaColor();
			row[0] = listColor.get(i).getIdColor();
			modelColor.addRow(row);
		}
		table_Color.setRowHeight(40);

	}

	private void showColor() {
		modelColor = (DefaultTableModel) table_Color.getModel();
		int row = table_Color.getSelectedRow();
		textField_NameC.setText(modelColor.getValueAt(row, 1).toString());
		textField_PriceC.setText(modelColor.getValueAt(row, 2).toString());
	}
	private boolean updateColor( SaveColorMana color) {
		Connection con;
		try {
			int row = table_Color.getSelectedRow();
			String IdColor =  table_Color.getValueAt(row, 0).toString();
			con = DataSQL.getConnection();
			String sql = "update Colors " + "set Name = N'"+ textField_NameC.getText()+"' " + ", Price = " + textField_PriceC.getText() + "where IdColor = " + IdColor;
			PreparedStatement pre = con.prepareStatement(sql);
			pre.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	//Tier
	void ClearTier() {
		textField_NameTI.setText("");
		textField_PriceTI.setText("");

	}

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
		Object[] row = new Object[3];
		for (int i = 0; i < listTier.size(); i++) {
			row[1] = listTier.get(i).getTenTierMana();
			row[2] = listTier.get(i).getGiaTier();
			row[0] = listTier.get(i).getIdTier();
			modelTier.addRow(row);
		}
		table_Tier.setRowHeight(40);

	}

	private void showTier() {
		modelTier = (DefaultTableModel) table_Tier.getModel();
		int row = table_Tier.getSelectedRow();
		textField_NameTI.setText(modelTier.getValueAt(row, 1).toString());
		textField_PriceTI.setText(modelTier.getValueAt(row, 2).toString());
	}
	private boolean updateTiers( SaveTierMana tiers) {
		Connection con;
		try {
			int row = table_Tier.getSelectedRow();
			String IdTiers =  table_Tier.getValueAt(row, 0).toString();
			con = DataSQL.getConnection();
			String sql = "update Tiers " + "set Name = N'"+ textField_NameTI.getText()+"' " + ", Price = " + textField_PriceTI.getText() + "where IdTiers = " + IdTiers;
			PreparedStatement pre = con.prepareStatement(sql);
			pre.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	// Fruit
	void ClearFruit() {
		textField_NameF.setText("");
		textField_PriceF.setText("");

	}

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
		Object[] row = new Object[3];
		for (int i = 0; i < listFruit.size(); i++) {
			row[1] = listFruit.get(i).getTenFruit();
			row[2] = listFruit.get(i).getGiaFruit();
			row[0] = listFruit.get(i).getIdFruit();
			modelFruit.addRow(row);
		}
		table_Fruit.setRowHeight(40);

	}

	private void showFruit() {
		modelFruit = (DefaultTableModel) table_Fruit.getModel();
		int row = table_Fruit.getSelectedRow();
		textField_NameF.setText(modelFruit.getValueAt(row, 1).toString());
		textField_PriceF.setText(modelFruit.getValueAt(row, 2).toString());
	}
	private boolean updateFruit( SaveFruitMana fruit) {
		Connection con;
		try {
			int row = table_Fruit.getSelectedRow();
			String IdFruit =  table_Fruit.getValueAt(row, 0).toString();
			con = DataSQL.getConnection();
			String sql = "update Fruits " + "set Name = N'"+ textField_NameF.getText()+"' " + ", Price = " + textField_PriceF.getText() + "where IdFruit = " + IdFruit;
			PreparedStatement pre = con.prepareStatement(sql);
			pre.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	//PArt
	void ClearPart() {
		textField_NameP.setText("");
		textField_PriceP.setText("");

	}

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
		Object[] row = new Object[3];
		for (int i = 0; i < listPart.size(); i++) {
			row[1] = listPart.get(i).getTenPart();
			row[2] = listPart.get(i).getGiaPart();
			row[0] = listPart.get(i).getIdPart();
			modelPart.addRow(row);
		}
		table_Part.setRowHeight(40);

	}

	private void showPart() {
		modelPart = (DefaultTableModel) table_Part.getModel();
		int row = table_Part.getSelectedRow();
		textField_NameP.setText(modelPart.getValueAt(row, 1).toString());
		textField_PriceP.setText(modelPart.getValueAt(row, 2).toString());
	}
	private boolean updateParts( SavePartMana part) {
		Connection con;
		try {
			int row = table_Part.getSelectedRow();
			String IdPart =  table_Part.getValueAt(row, 0).toString();
			con = DataSQL.getConnection();
			String sql = "update Parts " + "set Name = N'"+ textField_NameP.getText()+"' " + ", Price = " + textField_PriceP.getText() + "where IdPart = " + IdPart;
			PreparedStatement pre = con.prepareStatement(sql);
			pre.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	//Taste
	void ClearTaste() {
		textField_NameTA.setText("");
		textField_PriceTA.setText("");

	}

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
		Object[] row = new Object[3];
		for (int i = 0; i < listTaste.size(); i++) {
			row[1] = listTaste.get(i).getTenTaste();
			row[2] = listTaste.get(i).getGiaTaste();
			row[0] = listTaste.get(i).getIdTaste();
			modelTaste.addRow(row);
		}
		table_Taste.setRowHeight(40);

	}

	private void showTaste() {
		modelTaste = (DefaultTableModel) table_Taste.getModel();
		int row = table_Taste.getSelectedRow();
		textField_NameTA.setText(modelTaste.getValueAt(row, 1).toString());
		textField_PriceTA.setText(modelTaste.getValueAt(row, 2).toString());
	}
	private boolean updateTaste( SaveTasteMana taste) {
		Connection con;
		try {
			int row = table_Taste.getSelectedRow();
			String IdTaste =  table_Taste.getValueAt(row, 0).toString();
			con = DataSQL.getConnection();
			String sql = "update Tastes " + "set Name = N'"+ textField_NameTA.getText()+"' " + ", Price = " + textField_PriceTA.getText() + "where IdTaste = " + IdTaste ;
			PreparedStatement pre = con.prepareStatement(sql);
			pre.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
