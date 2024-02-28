package PartyShopManagerThuQuynh;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import SavePartyShopManager.SaveEmployee;
import SavePartyShopManager.SavePreOder;

import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Cake extends JFrame {
	ArrayList<SavePreOder> listPreOder = new ArrayList<SavePreOder>();
	private JPanel contentPane;
	private JTextField txttime;
	private JTable table;
	public JButton btnExit = new JButton("Exit");
	public JButton btnNewButton = new JButton("Price List");
	public JButton btnIntroduce = new JButton("Introduce");
	private JComboBox ccbShape;
	private JComboBox cbbColor;
	private JComboBox cbbTier;
	private JComboBox cbbFruit;
	private JComboBox cbbpart;
	private JComboBox cbbTaste;
	private DefaultTableModel model ;
	private JTextPane textPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cake frame = new Cake();
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
	public Cake() {
		
		setForeground(new Color(128, 0, 0));
		this.setTitle("Pre-Order");
		this.setIconImage((Toolkit.getDefaultToolkit().createImage(Cake.class.getResource("/Image/cake.jpg"))));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 730);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 202, 202));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 202, 202));
		contentPane.add(panel_1);
		panel_1.setBounds(0, 0, 1186, 329);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Shape:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(35, 28, 114, 25);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Color:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(35, 77, 114, 25);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Tier:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(35, 126, 114, 25);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Fruit:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3.setBounds(35, 175, 114, 25);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Part:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_4.setBounds(35, 224, 114, 25);
		panel_1.add(lblNewLabel_4);
		
		 ccbShape = new JComboBox();

		ccbShape.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ccbShape.setBounds(114, 23, 225, 35);
		panel_1.add(ccbShape);
		fillCbbShape();
		
		 cbbColor = new JComboBox();

		cbbColor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cbbColor.setBounds(114, 72, 225, 35);
		panel_1.add(cbbColor);
		fillCbbColor();
		 cbbTier = new JComboBox();

		cbbTier.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cbbTier.setBounds(114, 121, 225, 35);
		panel_1.add(cbbTier);
		fillCbbTier();
		 cbbFruit = new JComboBox();

		cbbFruit.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cbbFruit.setBounds(114, 170, 225, 35);
		panel_1.add(cbbFruit);
		fillCbbFruit();
		 cbbpart = new JComboBox();
		//comboBox_3_1.setModel(new DefaultComboBoxModel(part.getPart()));
		cbbpart.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cbbpart.setBounds(114, 219, 225, 35);
		panel_1.add(cbbpart);
		fillCbbPart();
		JLabel lblTaste = new JLabel("Taste:");
		lblTaste.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTaste.setBounds(425, 28, 114, 25);
		panel_1.add(lblTaste);
		
		JLabel lblTimeGet = new JLabel("Time get:");
		lblTimeGet.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTimeGet.setBounds(425, 77, 114, 25);
		panel_1.add(lblTimeGet);
		
		JLabel lblNewLabel_7 = new JLabel("Other requirements:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_7.setBounds(425, 126, 204, 25);
		panel_1.add(lblNewLabel_7);
		
		 cbbTaste = new JComboBox();
		//comboBox_4.setModel(new DefaultComboBoxModel(taste.getTaste()));
		cbbTaste.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cbbTaste.setBounds(506, 23, 225, 35);
		panel_1.add(cbbTaste);
		fillCbbTaste();
	    textPane = new JTextPane();
		textPane.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textPane.setBounds(425, 150, 306, 104);
		panel_1.add(textPane);
		
		txttime = new JTextField();
		txttime.setBounds(506, 72, 225, 35);
		panel_1.add(txttime);
		txttime.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel(new ImageIcon( new ImageIcon(
				Toolkit.getDefaultToolkit().getImage(
						Cake.class.getResource("/Image/Gato.png")
						)
				).getImage().getScaledInstance(327, 271, Image.SCALE_DEFAULT)));
		lblNewLabel_5.setBounds(810, 23, 327, 271);
		panel_1.add(lblNewLabel_5);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				PriceCake lowc = new PriceCake();
				lowc.setVisible(true);
				
			}
		});
		
		
		
		
		btnNewButton.setForeground(new Color(64, 0, 0));
		btnNewButton.setBackground(new Color(236, 220, 220));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton.setBounds(588, 280, 114, 35);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Add");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton_1.setForeground(new Color(64, 0, 0));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton_1.setBackground(new Color(236, 220, 220));
		btnNewButton_1.setBounds(461, 280, 104, 35);
		panel_1.add(btnNewButton_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Note: Payment by bank transfer. Details in");
		lblNewLabel_1_1.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_1_1.setBounds(10, 259, 311, 34);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("--->");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_2_1.setBounds(215, 302, 45, 25);
		panel_1.add(lblNewLabel_2_1);
		
		
		
		btnIntroduce.setForeground(new Color(128, 0, 255));
		btnIntroduce.setFont(new Font("Tahoma", Font.ITALIC, 11));
		btnIntroduce.setBackground(new Color(255, 202, 202));
		btnIntroduce.setBounds(250, 305, 85, 20);
		panel_1.add(btnIntroduce);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 168, 168));
		panel_2.setBounds(0, 329, 1186, 364);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		
		
		JButton btnNewButton_2 = new JButton("Delete");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setForeground(new Color(128, 0, 0));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_2.setBackground(new Color(236, 220, 220));
		btnNewButton_2.setBounds(915, 296, 105, 40);
		panel_2.add(btnNewButton_2);
		
		
		
		btnExit.setForeground(new Color(128, 0, 0));
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnExit.setBackground(new Color(236, 220, 220));
		btnExit.setBounds(1044, 296, 105, 40);
		panel_2.add(btnExit);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			showpreOder();
			}
		});
		table.setBackground(new Color(193, 193, 255));
		//		table.setFont(new Font("Tahoma", Font.PLAIN, 25));
				table.setModel(new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
						"Shape", "Color", "Tier", "Fruit", "Part", "Taste", "Time get", "Other requirements", "Total"
					}
				));
					
				table.setBounds(0, 11, 1186, 236);
				JScrollPane scrollPane = new JScrollPane(table);
				scrollPane.setBounds(0, 0, 1186, 271);
				panel_2.add(scrollPane);
				
				JLabel lblNewLabel_6 = new JLabel(new ImageIcon( new ImageIcon(
						Toolkit.getDefaultToolkit().getImage(
								Cake.class.getResource("/Image/gato1.jpg")
								)
						).getImage().getScaledInstance(535, 79, Image.SCALE_DEFAULT)));
				lblNewLabel_6.setBounds(70, 282, 535, 79);
				panel_2.add(lblNewLabel_6);
				
				JButton btnNewButton_2_1 = new JButton("Order");
				btnNewButton_2_1.setForeground(new Color(128, 0, 0));
				btnNewButton_2_1.setFont(new Font("Tahoma", Font.BOLD, 18));
				btnNewButton_2_1.setBackground(new Color(236, 220, 220));
				btnNewButton_2_1.setBounds(652, 296, 105, 40);
				panel_2.add(btnNewButton_2_1);
				
				JButton btnNewButton_2_1_1 = new JButton("Update");
				btnNewButton_2_1_1.setForeground(new Color(128, 0, 0));
				btnNewButton_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
				btnNewButton_2_1_1.setBackground(new Color(236, 220, 220));
				btnNewButton_2_1_1.setBounds(781, 296, 105, 40);
				panel_2.add(btnNewButton_2_1_1);
		
	}
	// Shape
	private void fillCbbShape() {
		try {
			Connection con = DataSQL.getConnection();
			PreparedStatement pre = con.prepareStatement("select Name,Price,IdShapes from Shapes");
			ResultSet rs = pre.executeQuery();
			while(rs.next()) {
				ccbShape.addItem(rs.getString("Name"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	//color
	private void fillCbbColor() {
		try {
			Connection con = DataSQL.getConnection();
			PreparedStatement pre = con.prepareStatement("select Name,Price,IdColor from Colors");
			ResultSet rs = pre.executeQuery();
			while(rs.next()) {
				cbbColor.addItem(rs.getString("Name"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	//Tier
	private void fillCbbTier() {
		try {
			Connection con = DataSQL.getConnection();
			PreparedStatement pre = con.prepareStatement("select Name,Price,IdTiers from Tiers");
			ResultSet rs = pre.executeQuery();
			while(rs.next()) {
				cbbTier.addItem(rs.getString("Name"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	//fruit
	private void fillCbbFruit() {
		try {
			Connection con = DataSQL.getConnection();
			PreparedStatement pre = con.prepareStatement("select Name,Price,IdFruit from Fruits");
			ResultSet rs = pre.executeQuery();
			while(rs.next()) {
				cbbFruit.addItem(rs.getString("Name"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	//part
	private void fillCbbPart() {
		try {
			Connection con = DataSQL.getConnection();
			PreparedStatement pre = con.prepareStatement("select Name,Price,IdPart from Parts");
			ResultSet rs = pre.executeQuery();
			while(rs.next()) {
				cbbpart.addItem(rs.getString("Name"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	// taste
	private void fillCbbTaste() {
		try {
			Connection con = DataSQL.getConnection();
			PreparedStatement pre = con.prepareStatement("select Name,Price,IdTaste from Tastes");
			ResultSet rs = pre.executeQuery();
			while(rs.next()) {
				cbbTaste.addItem(rs.getString("Name"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
//	private void findCake () {
//		try {
//			Connection con = DataSQL.getConnection();
//			String sql = "select Id,Name,Date,Sex,Cccd,Phone,Salary,Shifts,Note from Employee";
//			PreparedStatement pre = con.prepareStatement(sql);
//			ResultSet rs = pre.executeQuery();
//			listEmp.clear();
//			while (rs.next()) {
//				SaveEmployee emp = new SaveEmployee(rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(8),rs.getString(9), rs.getLong(5),rs.getLong(6),rs.getLong(7),rs.getInt(1));
//				listEmp.add(emp);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	private void loadInformationEmp() {
		model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		Object[] row = new Object[9];
		for (int i = 0; i < listPreOder.size(); i++) {
			row[0] = listPreOder.get(i).getShape();
			row[1] = listPreOder.get(i).getColor();
			row[2] = listPreOder.get(i).getTier();
			row[3] = listPreOder.get(i).getFruit();
			row[4] = listPreOder.get(i).getPart();
			row[5] = listPreOder.get(i).getTaste();
			row[6] = listPreOder.get(i).getTimeget();
			row[7] = listPreOder.get(i).getRequirement();
			row[8] = listPreOder.get(i).getTong();
			model.addRow(row);
		}
		table.setRowHeight(50);
		
	}
	private void showpreOder () {
		model = (DefaultTableModel) table.getModel();
		int row = table.getSelectedRow();
		txttime.setText(model.getValueAt(row, 6).toString());
		String shape = model.getValueAt(row, 0).toString();
		for ( int i = 0  ; i < ccbShape.getItemCount() ; i++) {
			if ( ccbShape.getItemAt(i).toString().equalsIgnoreCase(shape)) {
				ccbShape.setSelectedIndex(i);
			}
		}
		textPane.setText(model.getValueAt(row, 7).toString());
		
		
		String color = model.getValueAt(row, 1).toString();
		for ( int i = 0  ; i < cbbColor.getItemCount() ; i++) {
			if ( cbbColor.getItemAt(i).toString().equalsIgnoreCase(color)) {
				cbbColor.setSelectedIndex(i);
			}
		}
		String tier = model.getValueAt(row, 2).toString();
		for ( int i = 0  ; i < cbbTier.getItemCount() ; i++) {
			if ( cbbTier.getItemAt(i).toString().equalsIgnoreCase(tier)) {
				cbbTier.setSelectedIndex(i);
			}
		}
		String fruit = model.getValueAt(row, 3).toString();
		for ( int i = 0  ; i < cbbFruit.getItemCount() ; i++) {
			if ( cbbFruit.getItemAt(i).toString().equalsIgnoreCase(fruit)) {
				cbbFruit.setSelectedIndex(i);
			}
		}
		 String part = model.getValueAt(row, 4).toString();
		for ( int i = 0  ; i < cbbpart.getItemCount(); i++) {
			if ( cbbpart.getItemAt(i).toString().equalsIgnoreCase(part)) {
				cbbpart.setSelectedIndex(i);
			}
		}
		String taste = model.getValueAt(row, 5).toString();
		for ( int i = 0  ; i < cbbTaste.getItemCount() ; i++) {
			if ( cbbTaste.getItemAt(i).toString().equalsIgnoreCase(taste)) {
				cbbTaste.setSelectedIndex(i);
			}
		}
		
			
	
	}
}
