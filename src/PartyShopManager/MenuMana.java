package PartyShopManagerThuQuynh;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import SavePartyShopManager.SavaDrinkMana;
import SavePartyShopManager.SaveCakeMana;
import SavePartyShopManager.SaveCookieMana;

public class MenuMana extends JPanel {
	ArrayList<SavaDrinkMana> classList = new ArrayList<SavaDrinkMana>();
	ArrayList<SaveCookieMana> listCookie = new ArrayList<SaveCookieMana>();
	ArrayList<SaveCakeMana> listCake = new ArrayList<SaveCakeMana>();
	private JTable table_Drink;
	private JTable table_Cookie;
	private JTable table_Cake;
	private JTabbedPane tabbedPane;
	private JPanel panelDrink;
	private JPanel panelCookie;
	private JPanel panelCake;
	private JLabel lblNewLabel;
	private JSeparator separator;
	private JLabel lblNewLabel_1;

	private JTextField txtSearch_1;
	private JTextField textField_FindCo;
	private JTextField txtSearch;
	private JLabel lblNewLabel_1_1;
	private JLabel lblNewLabel_1_2;
	private JLabel lblNewLabel_1_3;
	private JLabel lblNewLabel_1_4;
	private JLabel lblNewLabel_1_5;

	private JTextField txtnameCake;
	private JTextField txtnamecookie;
	private JTextField txtnameD;
	private JTextField txtsizeD;
	private JTextField txtGiaD;

	private JButton btnNewButton_DelCake;
	private JButton btnNewButton_DelCo;
	private JButton btnNewButton_DelD;

	private JButton btnNewButton_EditCake;
	private JButton btnNewButton_EditCo;
	private JButton btnNewButton_EditD;

	private JButton btnNewButton_AddCake;
	private JButton btnNewButton_AddCo;
	private JButton btnNewButton_AddD;

	private JButton btnNewButton_UpdateCake;
	private JButton btnNewButton_UpdateCo;
	private JButton btnNewButton_UpdateD;

	private JButton btnNewButton_ExitCake;
	private JButton btnNewButton_ExitCo;
	private JButton btnNewButton_ExitD;
	private JLabel lblNewLabel_2;
	private JTextField txtthanhphanD;
	private DefaultTableModel modelDrink, modelCookie, modelCake;
	String anhDrink = "";
	String anhCookie = "";
	String anhCake = "";
	private JLabel lbAnh, lbAnhCookie, lbAnhCake;
	private JTextField txtingrecookie;
	private JTextField txtpriceCookie;
	private JTextField txtpriceCake;
	private JTextField txtIngreCake;
	private JTextField txtIDdrink;
	private JTextField txtIDCookie;
	private JTextField txtId_Cake;

	/**
	 * Create the panel.
	 */
	public MenuMana() {
		setBackground(new Color(255, 244, 244));
		setLayout(null);
		setBounds(0, 0, 1156, 652);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(new Color(255, 200, 200));
		tabbedPane.setForeground(new Color(128, 0, 0));
		tabbedPane.setFont(new Font("Sylfaen", Font.BOLD, 25));
		tabbedPane.setBounds(0, 0, 1156, 652);
		add(tabbedPane);

		// Drink
		panelDrink = new JPanel();
		panelDrink.setBackground(new Color(255, 236, 236));
		tabbedPane.addTab("Drinks", null, panelDrink, null);
		panelDrink.setLayout(null);

		lblNewLabel = new JLabel("Drinks Menu");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 35));
		lblNewLabel.setBounds(24, 11, 373, 43);
		panelDrink.add(lblNewLabel);

		lblNewLabel_2 = new JLabel(new ImageIcon(
				new ImageIcon(Toolkit.getDefaultToolkit().getImage(MenuMana.class.getResource("/Image/menu.jpg")))
						.getImage().getScaledInstance(54, 38, Image.SCALE_DEFAULT)));
		lblNewLabel_2.setBounds(248, 16, 54, 38);
		panelDrink.add(lblNewLabel_2);

		lblNewLabel_1 = new JLabel(new ImageIcon(
				new ImageIcon(Toolkit.getDefaultToolkit().getImage(MenuMana.class.getResource("/Image/kinhlup.png")))
						.getImage().getScaledInstance(41, 36, Image.SCALE_DEFAULT)));
		lblNewLabel_1.setBounds(774, 11, 41, 36);
		panelDrink.add(lblNewLabel_1);

		lblNewLabel_1_1 = new JLabel("Name:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1_1.setBounds(748, 129, 84, 29);
		panelDrink.add(lblNewLabel_1_1);

		lblNewLabel_1_2 = new JLabel("Image:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1_2.setBounds(748, 303, 84, 29);
		panelDrink.add(lblNewLabel_1_2);

		lblNewLabel_1_3 = new JLabel("Size:");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1_3.setBounds(748, 174, 84, 29);
		panelDrink.add(lblNewLabel_1_3);

		lblNewLabel_1_4 = new JLabel("Main Ingre:");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1_4.setBounds(748, 225, 138, 29);
		panelDrink.add(lblNewLabel_1_4);

		lblNewLabel_1_5 = new JLabel("Price:");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1_5.setBounds(748, 264, 84, 29);
		panelDrink.add(lblNewLabel_1_5);
		// separatorDrink
		separator = new JSeparator();
		separator.setBackground(Color.BLACK);
		separator.setBounds(10, 52, 304, 2);
		panelDrink.add(separator);

		// tableDrink
		table_Drink = new JTable();
		table_Drink.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				showDrink();

			}
		});
		table_Drink.setBackground(new Color(223, 255, 255));
		table_Drink.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Name", "Size", "Main Ingredients", "Price", "Image"
			}
		) {
			Class[] columnTypes = new Class[] {
				Object.class, Object.class, Object.class, Object.class, Object.class, ImageIcon.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});

		findDrink();
		// findseachDrink();
		loadInformationDrink();
		table_Drink.setBounds(375, 91, 889, 422);
		JScrollPane scrollPane_Drink = new JScrollPane(table_Drink);
		scrollPane_Drink.setBounds(10, 58, 714, 535);
		scrollPane_Drink.setFont(new Font("Tahoma", Font.BOLD, 15));
		panelDrink.add(scrollPane_Drink);

		txtSearch = new JTextField();
		txtSearch.setForeground(new Color(0, 0, 0));
		txtSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String  searchString = txtSearch.getText();
				reseach(searchString);
				
			}
		});
		txtSearch.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtSearch.setColumns(10);
		txtSearch.setBounds(814, 11, 304, 36);
		panelDrink.add(txtSearch);

		txtnameD = new JTextField();
		txtnameD.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtnameD.setColumns(10);
		txtnameD.setBounds(882, 126, 210, 35);
		panelDrink.add(txtnameD);

		txtsizeD = new JTextField();
		txtsizeD.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtsizeD.setColumns(10);
		txtsizeD.setBounds(882, 171, 210, 35);
		panelDrink.add(txtsizeD);

		txtGiaD = new JTextField();
		txtGiaD.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtGiaD.setColumns(10);
		txtGiaD.setBounds(882, 261, 210, 35);
		panelDrink.add(txtGiaD);

		btnNewButton_ExitD = new JButton("Exit");
		btnNewButton_ExitD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				HomeManager hom = new HomeManager();
				hom.setVisible(true);
			}
		});
		btnNewButton_ExitD.setForeground(new Color(128, 0, 0));
		btnNewButton_ExitD.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_ExitD.setBackground(new Color(255, 128, 128));
		btnNewButton_ExitD.setBounds(1046, 505, 72, 61);
		panelDrink.add(btnNewButton_ExitD);

		btnNewButton_DelD = new JButton("Delete");
		btnNewButton_DelD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tenDrink = txtnameD.getText();
				SQL handle = new SQL();
				if (handle.deleteDrink(tenDrink)) {
					clearDrink();
					findDrink();
					loadInformationDrink();
					JOptionPane.showMessageDialog(null, "Delete Successfully");
				} else {
					JOptionPane.showMessageDialog(null, "Delete error");
				}

			}
		});
		btnNewButton_DelD.setForeground(new Color(0, 64, 128));
		btnNewButton_DelD.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_DelD.setBackground(new Color(230, 255, 255));
		btnNewButton_DelD.setBounds(774, 494, 113, 36);
		panelDrink.add(btnNewButton_DelD);

		btnNewButton_EditD = new JButton("Clear");
		btnNewButton_EditD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearDrink();
			}
		});
		btnNewButton_EditD.setForeground(new Color(0, 64, 128));
		btnNewButton_EditD.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_EditD.setBackground(new Color(230, 255, 255));
		btnNewButton_EditD.setBounds(912, 494, 113, 36);
		panelDrink.add(btnNewButton_EditD);

		btnNewButton_AddD = new JButton("Add");
		btnNewButton_AddD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				//saveDrink(nameDrink, sizeDrink, thanhphan, pricedrink, anhDrink);
				saveDrink();
				findDrink();
				loadInformationDrink();
				clearDrink();
			}
		});
		btnNewButton_AddD.setForeground(new Color(0, 64, 128));
		btnNewButton_AddD.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_AddD.setBackground(new Color(230, 255, 255));
		btnNewButton_AddD.setBounds(774, 541, 113, 36);
		panelDrink.add(btnNewButton_AddD);

		btnNewButton_UpdateD = new JButton("Update");
		btnNewButton_UpdateD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt(txtIDdrink.getText());
				try {
					int giadrink = Integer.parseInt(txtGiaD.getText());
					
					SavaDrinkMana drink = new SavaDrinkMana();
					drink.setId(id);
					drink.setTenDrink(txtnameD.getText());
					drink.setSizeDrink(txtsizeD.getText());
					drink.setThanhphanDrink(txtthanhphanD.getText());
					drink.setGiaDrink(giadrink);
					SQL xuLy = new SQL();
					if ( xuLy.updateDrink(drink)) {
						JOptionPane.showMessageDialog(null, "Updata Successfully ");
					}else {
						JOptionPane.showMessageDialog(null, "Updata Error ");
					}
				} catch (Exception e1) {
					
					e1.printStackTrace();
				} 
				try {
					SavaDrinkMana drink = new SavaDrinkMana();
					drink.setId(id);
					File file = new File (anhDrink);
					FileInputStream fis = new FileInputStream(file);
					byte[] image = new byte [ (int ) file.length()];
					fis.read(image);
					SQL xuLy = new SQL();
					xuLy.updataDrink1(image , id);
				} catch (Exception e2) {
					
				}
				clearDrink();
				findDrink();
				loadInformationDrink();

			}
		});
		btnNewButton_UpdateD.setForeground(new Color(0, 64, 128));
		btnNewButton_UpdateD.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_UpdateD.setBackground(new Color(230, 255, 255));
		btnNewButton_UpdateD.setBounds(912, 541, 113, 36);
		panelDrink.add(btnNewButton_UpdateD);

		lbAnh = new JLabel("");
		lbAnh.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		lbAnh.setBounds(888, 309, 230, 156);
		panelDrink.add(lbAnh);

		txtthanhphanD = new JTextField();
		txtthanhphanD.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtthanhphanD.setColumns(10);
		txtthanhphanD.setBounds(882, 216, 210, 35);
		panelDrink.add(txtthanhphanD);

		JButton btnNewButton_DelD_1 = new JButton("Add Image");
		btnNewButton_DelD_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jFileChoooser = new JFileChooser();
				jFileChoooser.setDialogTitle("ADD IMAGE");
				jFileChoooser.setMultiSelectionEnabled(false);
				jFileChoooser.setFileFilter(new FileTypeFiler(".jpg", ".JPG"));
				jFileChoooser.setFileFilter(new FileTypeFiler(".gif", ".GIF"));
				jFileChoooser.setFileFilter(new FileTypeFiler(".png", ".PNG"));
				int result = jFileChoooser.showOpenDialog(null);

				if (result == JFileChooser.APPROVE_OPTION) {
					File file = jFileChoooser.getSelectedFile();
					lbAnh.setIcon(new ImageIcon(file.getAbsolutePath()));
					anhDrink = file.getAbsolutePath().replace("/", "//");
				}
			}
		});
		btnNewButton_DelD_1.setForeground(new Color(128, 0, 0));
		btnNewButton_DelD_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_DelD_1.setBackground(new Color(255, 174, 174));
		btnNewButton_DelD_1.setBounds(734, 429, 138, 36);
		panelDrink.add(btnNewButton_DelD_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("ID :");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1_1_1.setBounds(748, 82, 84, 29);
		panelDrink.add(lblNewLabel_1_1_1);
		
		txtIDdrink = new JTextField();
		txtIDdrink.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtIDdrink.setColumns(10);
		txtIDdrink.setBounds(882, 79, 210, 35);
		panelDrink.add(txtIDdrink);
		txtIDdrink.setEditable(false);

		// Cookie
		panelCookie = new JPanel();
		panelCookie.setBackground(new Color(255, 221, 221));
		tabbedPane.addTab("Cookies", null, panelCookie, null);
		panelCookie.setLayout(null);

		lblNewLabel = new JLabel("Cookies Menu");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 35));
		lblNewLabel.setBounds(25, 11, 274, 43);
		panelCookie.add(lblNewLabel);

		lblNewLabel_2 = new JLabel(new ImageIcon(
				new ImageIcon(Toolkit.getDefaultToolkit().getImage(MenuMana.class.getResource("/Image/menu.jpg")))
						.getImage().getScaledInstance(54, 38, Image.SCALE_DEFAULT)));
		lblNewLabel_2.setBounds(282, 11, 54, 38);
		panelCookie.add(lblNewLabel_2);

		lblNewLabel_1 = new JLabel(new ImageIcon(
				new ImageIcon(Toolkit.getDefaultToolkit().getImage(MenuMana.class.getResource("/Image/kinhlup.png")))
						.getImage().getScaledInstance(41, 36, Image.SCALE_DEFAULT)));
		lblNewLabel_1.setBounds(791, 11, 41, 36);
		panelCookie.add(lblNewLabel_1);

		lblNewLabel_1_1 = new JLabel("Name:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1_1.setBounds(748, 161, 84, 29);
		panelCookie.add(lblNewLabel_1_1);

		lblNewLabel_1_2 = new JLabel("Image:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1_2.setBounds(748, 299, 84, 29);
		panelCookie.add(lblNewLabel_1_2);

		lblNewLabel_1_4 = new JLabel("Main Ingre:");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1_4.setBounds(748, 200, 134, 29);
		panelCookie.add(lblNewLabel_1_4);

		lblNewLabel_1_5 = new JLabel("Price:");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1_5.setBounds(748, 245, 84, 29);
		panelCookie.add(lblNewLabel_1_5);

		separator = new JSeparator();
		separator.setBackground(Color.BLACK);
		separator.setBounds(10, 52, 364, 2);
		panelCookie.add(separator);
// table Cookie 
		table_Cookie = new JTable();
		table_Cookie.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				showCookie();
			}
		});
		table_Cookie.setBackground(new Color(206, 206, 255));
//		table.setFont(new Font("Tahoma", Font.PLAIN, 25));
		table_Cookie.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Name", "Main Ingredients", "Price", "Image"
			}
		) {
			Class[] columnTypes = new Class[] {
				Object.class, Object.class, Object.class, Object.class, ImageIcon.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		findCookie();
		loadInformationCookie();
		table_Cookie.setBounds(375, 91, 889, 422);
		JScrollPane scrollPane_Cookie = new JScrollPane(table_Cookie);
		scrollPane_Cookie.setBounds(10, 58, 714, 535);
		scrollPane_Cookie.setFont(new Font("Tahoma", Font.BOLD, 15));
		panelCookie.add(scrollPane_Cookie);

		textField_FindCo = new JTextField();
		textField_FindCo.setForeground(new Color(0, 0, 0));
		textField_FindCo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String  searchString = textField_FindCo.getText();
				reseachCo(searchString);
			}
		});
		textField_FindCo.setFont(new Font("Tahoma", Font.ITALIC, 20));
		textField_FindCo.setColumns(10);
		textField_FindCo.setBounds(831, 11, 285, 36);
		panelCookie.add(textField_FindCo);

		txtnamecookie = new JTextField();
		txtnamecookie.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtnamecookie.setColumns(10);
		txtnamecookie.setBounds(891, 155, 250, 35);
		panelCookie.add(txtnamecookie);

		btnNewButton_ExitCo = new JButton("Exit");
		btnNewButton_ExitCo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				HomeManager hom = new HomeManager();
				hom.setVisible(true);
			}
		});
		btnNewButton_ExitCo.setForeground(new Color(128, 0, 0));
		btnNewButton_ExitCo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_ExitCo.setBackground(new Color(255, 128, 128));
		btnNewButton_ExitCo.setBounds(1046, 505, 72, 61);
		panelCookie.add(btnNewButton_ExitCo);

		btnNewButton_DelCo = new JButton("Delete");
		btnNewButton_DelCo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tenCookie = txtnamecookie.getText();
				SQL handle = new SQL();
				if (handle.deleteCookie(tenCookie)) {
					clearCookie();
					findCookie();
					loadInformationCookie();
					JOptionPane.showMessageDialog(null, "Delete Successfully");
				} else {
					JOptionPane.showMessageDialog(null, "Delete error");
				}

			}
		});
		btnNewButton_DelCo.setForeground(new Color(0, 64, 128));
		btnNewButton_DelCo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_DelCo.setBackground(new Color(230, 255, 255));
		btnNewButton_DelCo.setBounds(774, 494, 113, 36);
		panelCookie.add(btnNewButton_DelCo);

		btnNewButton_EditCo = new JButton("Clear");
		btnNewButton_EditCo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearCookie();
			}
		});
		btnNewButton_EditCo.setForeground(new Color(0, 64, 128));
		btnNewButton_EditCo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_EditCo.setBackground(new Color(230, 255, 255));
		btnNewButton_EditCo.setBounds(912, 494, 113, 36);
		panelCookie.add(btnNewButton_EditCo);

		btnNewButton_AddCo = new JButton("Add");
		btnNewButton_AddCo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveCookie();
				findCookie();
				loadInformationCookie();
				clearCookie();

			}
		});
		btnNewButton_AddCo.setForeground(new Color(0, 64, 128));
		btnNewButton_AddCo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_AddCo.setBackground(new Color(230, 255, 255));
		btnNewButton_AddCo.setBounds(774, 541, 113, 36);
		panelCookie.add(btnNewButton_AddCo);
		
		btnNewButton_UpdateCo = new JButton("Update");
		btnNewButton_UpdateCo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int idCookie = Integer.parseInt(txtIDCookie.getText());
				try {
					int giaCookie = Integer.parseInt(txtpriceCookie.getText());
					SaveCookieMana cookie = new SaveCookieMana();
					cookie.setTenCookie(txtnamecookie.getText());
					cookie.setThanhphanCookie(txtingrecookie.getText());
					cookie.setGiaCookie(giaCookie);
					cookie.setIdCookie(idCookie);
					SQL xuLyy = new SQL();
					if ( xuLyy.updateCookie(cookie)) {
						JOptionPane.showMessageDialog(null, "Updata Successfully ");
					}else {
						JOptionPane.showMessageDialog(null, "Updata Error ");
					}
					
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				try {
					SaveCookieMana cookie = new SaveCookieMana();
					cookie.setIdCookie(idCookie);
					File file = new File (anhDrink);
					FileInputStream fis = new FileInputStream(file);
					byte[] image = new byte [ (int ) file.length()];
					fis.read(image);
					SQL xuLy = new SQL();
					xuLy.updateCookie1(idCookie, image);
				} catch (Exception e2) {
					
				}
				clearCookie();
				findCookie();
				loadInformationCookie();
			}
		});
		btnNewButton_UpdateCo.setForeground(new Color(0, 64, 128));
		btnNewButton_UpdateCo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_UpdateCo.setBackground(new Color(230, 255, 255));
		btnNewButton_UpdateCo.setBounds(912, 541, 113, 36);
		panelCookie.add(btnNewButton_UpdateCo);

		txtingrecookie = new JTextField();
		txtingrecookie.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtingrecookie.setColumns(10);
		txtingrecookie.setBounds(891, 197, 250, 35);
		panelCookie.add(txtingrecookie);

		txtpriceCookie = new JTextField();
		txtpriceCookie.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtpriceCookie.setColumns(10);
		txtpriceCookie.setBounds(891, 242, 250, 35);
		panelCookie.add(txtpriceCookie);

		lbAnhCookie = new JLabel("");
		lbAnhCookie.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		lbAnhCookie.setBounds(891, 309, 230, 156);
		panelCookie.add(lbAnhCookie);

		JButton btnNewButton_DelCo_1 = new JButton("Add Image");
		btnNewButton_DelCo_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jFileChoooser = new JFileChooser();
				jFileChoooser.setDialogTitle("ADD IMAGE");
				jFileChoooser.setMultiSelectionEnabled(false);
				jFileChoooser.setFileFilter(new FileTypeFiler(".jpg", ".JPG"));
				jFileChoooser.setFileFilter(new FileTypeFiler(".gif", ".GIF"));
				jFileChoooser.setFileFilter(new FileTypeFiler(".png", ".PNG"));
				int result = jFileChoooser.showOpenDialog(null);

				if (result == JFileChooser.APPROVE_OPTION) {
					File file = jFileChoooser.getSelectedFile();
					lbAnhCookie.setIcon(new ImageIcon(file.getAbsolutePath()));
					anhCookie = file.getAbsolutePath().replace("/", "//");
				}

			}
		});
		btnNewButton_DelCo_1.setForeground(new Color(128, 0, 0));
		btnNewButton_DelCo_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_DelCo_1.setBackground(new Color(255, 227, 227));
		btnNewButton_DelCo_1.setBounds(748, 428, 134, 36);
		panelCookie.add(btnNewButton_DelCo_1);
		
		txtIDCookie = new JTextField();
		txtIDCookie.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtIDCookie.setColumns(10);
		txtIDCookie.setBounds(891, 110, 250, 35);
		panelCookie.add(txtIDCookie);
		txtIDCookie.setEditable(false);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("ID :");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1_1_2.setBounds(748, 113, 84, 29);
		panelCookie.add(lblNewLabel_1_1_2);

		// Cake
		panelCake = new JPanel();
		panelCake.setBackground(new Color(255, 198, 198));
		tabbedPane.addTab("Cakes", null, panelCake, null);
		panelCake.setLayout(null);

		lblNewLabel = new JLabel("Cakes Menu");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 35));
		lblNewLabel.setBounds(34, 11, 274, 43);
		panelCake.add(lblNewLabel);

		lblNewLabel_2 = new JLabel(new ImageIcon(
				new ImageIcon(Toolkit.getDefaultToolkit().getImage(MenuMana.class.getResource("/Image/menu.jpg")))
						.getImage().getScaledInstance(54, 38, Image.SCALE_DEFAULT)));
		lblNewLabel_2.setBounds(254, 11, 54, 38);
		panelCake.add(lblNewLabel_2);

		lblNewLabel_1 = new JLabel(new ImageIcon(
				new ImageIcon(Toolkit.getDefaultToolkit().getImage(MenuMana.class.getResource("/Image/kinhlup.png")))
						.getImage().getScaledInstance(41, 36, Image.SCALE_DEFAULT)));
		lblNewLabel_1.setBounds(791, 11, 41, 36);
		panelCake.add(lblNewLabel_1);

		lblNewLabel_1_1 = new JLabel("Name:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1_1.setBounds(748, 152, 84, 29);
		panelCake.add(lblNewLabel_1_1);

		lblNewLabel_1_2 = new JLabel("Image:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1_2.setBounds(748, 289, 84, 29);
		panelCake.add(lblNewLabel_1_2);

		lblNewLabel_1_4 = new JLabel("Main Ingre:");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1_4.setBounds(749, 202, 138, 29);
		panelCake.add(lblNewLabel_1_4);

		lblNewLabel_1_5 = new JLabel("Price:");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1_5.setBounds(748, 250, 84, 29);
		panelCake.add(lblNewLabel_1_5);

		separator = new JSeparator();
		separator.setBackground(Color.BLACK);
		separator.setBounds(10, 52, 364, 2);
		panelCake.add(separator);

		table_Cake = new JTable();
		table_Cake.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				showCake();
			}
		});
		table_Cake.setBackground(new Color(198, 255, 198));
//		table.setFont(new Font("Tahoma", Font.PLAIN, 25));
		table_Cake.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Name", "Main Ingredients", "Price", "Image"
			}
		) {
			Class[] columnTypes = new Class[] {
				Object.class, Object.class, Object.class, Object.class, ImageIcon.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});

		findCake();
		loadInformationCake();
		table_Cake.setBounds(375, 91, 889, 422);
		JScrollPane scrollPane_Cake = new JScrollPane(table_Cake);
		scrollPane_Cake.setBounds(10, 58, 714, 535);
		scrollPane_Cake.setFont(new Font("Tahoma", Font.BOLD, 15));
		panelCake.add(scrollPane_Cake);

		txtSearch_1 = new JTextField();
		txtSearch_1.setForeground(new Color(0, 0, 0));
		txtSearch_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String  searchString = txtSearch_1.getText();
				reseachCa(searchString);
			}
		});
		txtSearch_1.setFont(new Font("Tahoma", Font.ITALIC, 20));
		txtSearch_1.setColumns(10);
		txtSearch_1.setBounds(836, 11, 282, 36);
		panelCake.add(txtSearch_1);
		

		txtnameCake = new JTextField();
		txtnameCake.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtnameCake.setColumns(10);
		txtnameCake.setBounds(891, 149, 250, 35);
		panelCake.add(txtnameCake);

		btnNewButton_ExitCake = new JButton("Exit");
		btnNewButton_ExitCake.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				HomeManager hom = new HomeManager();
				hom.setVisible(true);
			}
		});
		btnNewButton_ExitCake.setForeground(new Color(128, 0, 0));
		btnNewButton_ExitCake.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_ExitCake.setBackground(new Color(255, 128, 128));
		btnNewButton_ExitCake.setBounds(1046, 505, 72, 61);
		panelCake.add(btnNewButton_ExitCake);

		btnNewButton_DelCake = new JButton("Delete");
		btnNewButton_DelCake.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tenCake = txtnameCake.getText();
				SQL handle = new SQL();
				if (handle.deleteCake(tenCake)) {
					clearCake();
					findCake();
					loadInformationCake();
					JOptionPane.showMessageDialog(null, "Delete Successfully");
				} else {
					JOptionPane.showMessageDialog(null, "Delete error");
				}
			}
		});
		btnNewButton_DelCake.setForeground(new Color(0, 64, 128));
		btnNewButton_DelCake.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_DelCake.setBackground(new Color(230, 255, 255));
		btnNewButton_DelCake.setBounds(774, 494, 113, 36);
		panelCake.add(btnNewButton_DelCake);

		btnNewButton_EditCake = new JButton("Clear");
		btnNewButton_EditCake.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearCake();
			}
		});
		btnNewButton_EditCake.setForeground(new Color(0, 64, 128));
		btnNewButton_EditCake.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_EditCake.setBackground(new Color(230, 255, 255));
		btnNewButton_EditCake.setBounds(912, 494, 113, 36);
		panelCake.add(btnNewButton_EditCake);

		btnNewButton_AddCake = new JButton("Add");
		btnNewButton_AddCake.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveCake();
				findCake();
				loadInformationCake();
				clearCake();
			}
		});
		btnNewButton_AddCake.setForeground(new Color(0, 64, 128));
		btnNewButton_AddCake.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_AddCake.setBackground(new Color(230, 255, 255));
		btnNewButton_AddCake.setBounds(774, 541, 113, 36);
		panelCake.add(btnNewButton_AddCake);

		btnNewButton_UpdateCake = new JButton("Update");
		btnNewButton_UpdateCake.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int giacake = Integer.parseInt(txtpriceCake.getText());
				int idcake = Integer.parseInt(txtId_Cake.getText());
				try {
					
					SaveCakeMana cake = new SaveCakeMana();
					cake.setTenCake(txtnameCake.getText());
					cake.setThanhphanCake(txtIngreCake.getText());
					cake.setGiaCake(giacake);
					cake.setIdCake(idcake);
					SQL xuLyy = new SQL();
					if ( xuLyy.updateCake(cake)) {
						JOptionPane.showMessageDialog(null, "Updata Successfully ");
					}else {
						JOptionPane.showMessageDialog(null, "Updata Error ");
					}
					
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				try {
					SaveCakeMana cake = new SaveCakeMana();
					cake.setIdCake(idcake);
					File file = new File (anhCake);
					FileInputStream fis = new FileInputStream(file);
					byte[] image = new byte [ (int ) file.length()];
					fis.read(image);
			SQL xuLy = new SQL();
					xuLy.updateCake1(idcake, image);
				} catch (Exception e2) {
					
				}
				clearCake();
				findCake();
				loadInformationCake();
			}
		});
		btnNewButton_UpdateCake.setForeground(new Color(0, 64, 128));
		btnNewButton_UpdateCake.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_UpdateCake.setBackground(new Color(230, 255, 255));
		btnNewButton_UpdateCake.setBounds(912, 541, 113, 36);
		panelCake.add(btnNewButton_UpdateCake);

		txtpriceCake = new JTextField();
		txtpriceCake.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtpriceCake.setColumns(10);
		txtpriceCake.setBounds(891, 244, 250, 35);
		panelCake.add(txtpriceCake);

		txtIngreCake = new JTextField();
		txtIngreCake.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtIngreCake.setColumns(10);
		txtIngreCake.setBounds(891, 199, 250, 35);
		panelCake.add(txtIngreCake);

		lbAnhCake = new JLabel("");
		lbAnhCake.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		lbAnhCake.setBounds(891, 312, 230, 156);
		panelCake.add(lbAnhCake);

		JButton btnNewButton_DelCake_1 = new JButton("Add Image");
		btnNewButton_DelCake_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jFileChoooser = new JFileChooser();
				jFileChoooser.setDialogTitle("ADD IMAGE");
				jFileChoooser.setMultiSelectionEnabled(false);
				jFileChoooser.setFileFilter(new FileTypeFiler(".jpg", ".JPG"));
				jFileChoooser.setFileFilter(new FileTypeFiler(".gif", ".GIF"));
				jFileChoooser.setFileFilter(new FileTypeFiler(".png", ".PNG"));
				int result = jFileChoooser.showOpenDialog(null);

				if (result == JFileChooser.APPROVE_OPTION) {
					File file = jFileChoooser.getSelectedFile();
					lbAnhCake.setIcon(new ImageIcon(file.getAbsolutePath()));
					anhCake = file.getAbsolutePath().replace("/", "//");
				}
			}
		});
		btnNewButton_DelCake_1.setForeground(new Color(128, 0, 0));
		btnNewButton_DelCake_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_DelCake_1.setBackground(new Color(255, 236, 236));
		btnNewButton_DelCake_1.setBounds(734, 432, 138, 36);
		panelCake.add(btnNewButton_DelCake_1);
		
		txtId_Cake = new JTextField();
		txtId_Cake.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtId_Cake.setColumns(10);
		txtId_Cake.setBounds(891, 99, 250, 35);
		panelCake.add(txtId_Cake);
		txtId_Cake.setEditable(false);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("ID :");
		lblNewLabel_1_1_3.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1_1_3.setBounds(748, 102, 65, 29);
		panelCake.add(lblNewLabel_1_1_3);

	}

	// Drink
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
		Object[] row = new Object[6];
		for (int i = 0; i < classList.size(); i++) {
			row[0] = classList.get(i).getId();
			row[1] = classList.get(i).getTenDrink();
			row[2] = classList.get(i).getSizeDrink();
			row[3] = classList.get(i).getThanhphanDrink();
			row[4] = classList.get(i).getGiaDrink();
			if (classList.get(i).getAnhDrink() != null) {
				ImageIcon imageIcon = new ImageIcon(new ImageIcon(classList.get(i).getAnhDrink()).getImage()
						.getScaledInstance(100, 100, Image.SCALE_SMOOTH));
				row[5] = imageIcon;
			} else {
				row[5] = null;

			}
			modelDrink.addRow(row);
		}
		table_Drink.setRowHeight(80);
	}

	void clearDrink() {
		txtIDdrink.setText("");
		txtnameD.setText("");
		txtsizeD.setText("");
		txtthanhphanD.setText("");
		txtGiaD.setText("");
		lbAnh.setIcon(null);
	}
// luu vao sql 
	private void saveDrink() {
		try {
			Connection con = DataSQL.getConnection();
			String sql = "INSERT INTO DrinkMana select N'"+txtnameD.getText()+"',N'"+txtsizeD.getText()+"',N'"+txtthanhphanD.getText()+"','"+txtGiaD.getText()+"',BulkColumn FROM OPENROWSET(BULK N'"+anhDrink+"',SINGLE_BLOB) image;";
		//	PreparedStatement pre = con.prepareStatement(sql);
		    Statement stm = con.createStatement();
			stm.executeUpdate(sql);
			JOptionPane.showMessageDialog(null, "Add Successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
//'"+txtId_Cake.getText()+"',
	}
// hien len bang text feil
	private void showDrink() {
		modelDrink = (DefaultTableModel) table_Drink.getModel();
		int row = table_Drink.getSelectedRow();
		txtIDdrink.setText(modelDrink.getValueAt(row, 0).toString());
		txtnameD.setText(modelDrink.getValueAt(row, 1).toString());
		txtsizeD.setText(modelDrink.getValueAt(row, 2).toString());
		txtthanhphanD.setText(modelDrink.getValueAt(row, 3).toString());
		txtGiaD.setText(modelDrink.getValueAt(row, 4).toString());

		ImageIcon image1 = (ImageIcon) table_Drink.getValueAt(row, 5);
		Image image2 = image1.getImage().getScaledInstance(230, 156, Image.SCALE_SMOOTH);
		ImageIcon image3 = new ImageIcon(image2);
		lbAnh.setIcon(image3);
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
		Object[] row = new Object[5];
		for (int i = 0; i < listCookie.size(); i++) {
			row[0] = listCookie.get(i).getIdCookie();
			row[1] = listCookie.get(i).getTenCookie();
			row[2] = listCookie.get(i).getThanhphanCookie();
			row[3] = listCookie.get(i).getGiaCookie();
			if (listCookie.get(i).getAnhCookie() != null) {
				ImageIcon imageIcon = new ImageIcon(new ImageIcon(listCookie.get(i).getAnhCookie()).getImage()
						.getScaledInstance(100, 100, Image.SCALE_SMOOTH));
				row[4] = imageIcon;
			} else {
				row[4] = null;

			}
			modelCookie.addRow(row);
		}
		table_Cookie.setRowHeight(80);
	}

	void clearCookie() {
		txtIDCookie.setText("");
		txtnamecookie.setText("");
		txtingrecookie.setText("");
		txtpriceCookie.setText("");
		lbAnhCookie.setIcon(null);
	}

	private void saveCookie() {
		try {
			Connection con = DataSQL.getConnection();
			String sql = "INSERT INTO CookieMana SELECT N'" + txtnamecookie.getText() + "' , N'"
					+ txtingrecookie.getText() + "', '" + txtpriceCookie.getText()
					+ "', BulkColumn FROM OPENROWSET(BULK N'" + anhCookie + "',SINGLE_BLOB) image; ";
			PreparedStatement pre = con.prepareStatement(sql);
			pre.executeUpdate();
			JOptionPane.showMessageDialog(null, "Add Successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void showCookie() {
		modelCookie = (DefaultTableModel) table_Cookie.getModel();
		int row = table_Cookie.getSelectedRow();
		txtIDCookie.setText(modelCookie.getValueAt(row, 0).toString());
		txtnamecookie.setText(modelCookie.getValueAt(row, 1).toString());
		txtingrecookie.setText(modelCookie.getValueAt(row, 2).toString());
		txtpriceCookie.setText(modelCookie.getValueAt(row, 3).toString());
		ImageIcon image1 = (ImageIcon) table_Cookie.getValueAt(row, 4);
		Image image2 = image1.getImage().getScaledInstance(230, 156, Image.SCALE_SMOOTH);
		ImageIcon image3 = new ImageIcon(image2);
		lbAnhCookie.setIcon(image3);
	}

	// Cake
	private void findCake() {
		try {
			Connection con = DataSQL.getConnection();
			String sql = "select IdCake,Name,MainIngredients,Price,Image from CakeMana";
			PreparedStatement pre = con.prepareStatement(sql);
			ResultSet rs = pre.executeQuery();
			listCake.clear();
			while (rs.next()) {
				SaveCakeMana cake = new SaveCakeMana(rs.getString(2), rs.getString(3), rs.getInt(4),rs.getInt(1), rs.getBytes(5));
				listCake.add(cake);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void loadInformationCake() {
		modelCake = (DefaultTableModel) table_Cake.getModel();
		modelCake.setRowCount(0);
		Object[] row = new Object[5];
		for (int i = 0; i < listCake.size(); i++) {
			row[0] = listCake.get(i).getIdCake();
			row[1] = listCake.get(i).getTenCake();
			row[2] = listCake.get(i).getThanhphanCake();
			row[3] = listCake.get(i).getGiaCake();
			if (listCake.get(i).getAnhCake() != null) {
				ImageIcon imageIcon = new ImageIcon(new ImageIcon(listCake.get(i).getAnhCake()).getImage()
						.getScaledInstance(100, 100, Image.SCALE_SMOOTH));
				row[4] = imageIcon;
			} else {
				row[4] = null;

			}
			modelCake.addRow(row);
		}
		table_Cake.setRowHeight(80);
	}

	void clearCake() {
		txtId_Cake.setText("");
		txtnameCake.setText("");
		txtIngreCake.setText("");
		txtpriceCake.setText("");
		lbAnhCake.setIcon(null);
	}

	private void saveCake() {
		try {
			Connection con = DataSQL.getConnection();
			String sql = "INSERT INTO CakeMana SELECT N'" + txtnameCake.getText() + "' , N'" + txtIngreCake.getText()
					+ "', '" + txtpriceCake.getText() + "', BulkColumn FROM OPENROWSET(BULK N'" + anhCake
					+ "',SINGLE_BLOB) image; ";
			PreparedStatement pre = con.prepareStatement(sql);
			pre.executeUpdate();
			JOptionPane.showMessageDialog(null, "Add Successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void showCake() {
		modelCake = (DefaultTableModel) table_Cake.getModel();
		int row = table_Cake.getSelectedRow();
		txtId_Cake.setText(modelCake.getValueAt(row, 0).toString());
		txtnameCake.setText(modelCake.getValueAt(row, 1).toString());
		txtIngreCake.setText(modelCake.getValueAt(row, 2).toString());
		txtpriceCake.setText(modelCake.getValueAt(row, 3).toString());
		ImageIcon image1 = (ImageIcon) table_Cake.getValueAt(row, 4);
		Image image2 = image1.getImage().getScaledInstance(230, 156, Image.SCALE_SMOOTH);
		ImageIcon image3 = new ImageIcon(image2);
		lbAnhCake.setIcon(image3);
	}
	// tìm kiếm drink 
	public void serRecordsToTable() {
		try {
			Connection con = DataSQL.getConnection();
			String sql = "select Iddrink,tendrink,sizedrink,thanhphandrink,giadrink,anhdrink from DrinkMana ";
			PreparedStatement pre = con.prepareStatement(sql);
			ResultSet rs = pre.executeQuery();
			while (rs.next()) {
				SavaDrinkMana drink = new SavaDrinkMana(rs.getString(2),rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(1), rs.getBytes(6));
				Object[] obj = { "ID", "Name", "Size", "Main Ingredients", "Price", "Image" };
				modelDrink = (DefaultTableModel) table_Drink.getModel();
				modelDrink.addRow(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void reseach ( String str) {
		modelDrink = (DefaultTableModel) table_Drink.getModel();
		TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(modelDrink);
		table_Drink.setRowSorter(trs);
		trs.setRowFilter(RowFilter.regexFilter(str));
	}

// tìm kiếm côkie 
	public void serRecordsToTableCo() {
		try {
			Connection con = DataSQL.getConnection();
			String sql = "select ID,Name,MainIngredients,Price,Image from CookieMana";
			PreparedStatement pre = con.prepareStatement(sql);
			ResultSet rs = pre.executeQuery();
			while (rs.next()) {
				SaveCookieMana cookie = new SaveCookieMana( rs.getString(2),rs.getString(3),rs.getInt(4), rs.getInt(1),
						rs.getBytes(5));
				Object[] obj = { "ID", "Name", "Main Ingredients", "Price", "Image" };
				modelCookie = (DefaultTableModel) table_Cookie.getModel();
				modelCookie.addRow(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void reseachCo(String str) {
		modelCookie = (DefaultTableModel) table_Cookie.getModel();
		TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(modelCookie);
		table_Cookie.setRowSorter(trs);
		trs.setRowFilter(RowFilter.regexFilter(str));
	}
	// tiềm kiếm cake 
	public void serRecordsToTableCa() {
		try {
			Connection con = DataSQL.getConnection();
			String sql = "select IdCake,Name,MainIngredients,Price,Image from CakeMana";
			PreparedStatement pre = con.prepareStatement(sql);
			ResultSet rs = pre.executeQuery();
			while (rs.next()) {
				SaveCakeMana cake = new SaveCakeMana(rs.getString(2), rs.getString(3), rs.getInt(4),rs.getInt(1), rs.getBytes(5));
				Object[] obj = { "ID", "Name", "Main Ingredients", "Price", "Image" };
				modelCake = (DefaultTableModel) table_Cake.getModel();
				modelCake.addRow(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void reseachCa(String str) {
		modelCake = (DefaultTableModel) table_Cake.getModel();
		TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(modelCake);
		table_Cake.setRowSorter(trs);
		trs.setRowFilter(RowFilter.regexFilter(str));
	}
}