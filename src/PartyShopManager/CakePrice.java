
package PartyShopManagerThuQuynh;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextPane;

public class CakePrice extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	private JTable table_3;
	private JTable table_4;
	private JTable table_5;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CakePrice frame = new CakePrice();
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
	public CakePrice() {
		setBounds(100, 100, 1400, 710);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 206, 183));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		//bang hinh dang
		table = new JTable();
		table.setBackground(new Color(217, 217, 217));
//		table.setFont(new Font("Tahoma", Font.PLAIN, 25));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
			},
			new String[] {
				"Shape", "Price"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(57);
		table.getColumnModel().getColumn(1).setPreferredWidth(101);
		
		table.setBounds(375, 91, 889, 422);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 5, 329, 325);
		scrollPane.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(scrollPane);
		
		
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 336, 1008, 3);
		contentPane.add(separator);
		
		//bang mau
		table_1 = new JTable();
		table_1.setBackground(new Color(255, 196, 196));
//		table.setFont(new Font("Tahoma", Font.PLAIN, 25));
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
			},
			new String[] {
				"Main Color", "Price"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table_1.getColumnModel().getColumn(0).setPreferredWidth(68);
		table_1.getColumnModel().getColumn(1).setPreferredWidth(117);
		
		table_1.setBounds(375, 91, 889, 422);
		JScrollPane scrollPane_1 = new JScrollPane(table_1);
		scrollPane_1.setBounds(343, 5, 337, 325);
		scrollPane_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(scrollPane_1);
		
        //bang tang
		table_2 = new JTable();
		table_2.setBackground(new Color(200, 255, 255));
//		table.setFont(new Font("Tahoma", Font.PLAIN, 25));
		table_2.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
			},
			new String[] {
				"Tier", "Price"
			}
		));
		table_2.getColumnModel().getColumn(0).setPreferredWidth(37);
		table_2.getColumnModel().getColumn(1).setPreferredWidth(128);
		
		table_2.setBounds(375, 91, 889, 422);
		JScrollPane scrollPane_2 = new JScrollPane(table_2);
		scrollPane_2.setBounds(685, 5, 322, 325);
		scrollPane_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(scrollPane_2);
		
		//bang hoa qua
		table_3 = new JTable();
		table_3.setBackground(new Color(198, 255, 198));
//		table.setFont(new Font("Tahoma", Font.PLAIN, 25));
		table_3.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
			},
			new String[] {
				"Fruit", "Price"
			}
		));
		table_3.getColumnModel().getColumn(0).setPreferredWidth(100);
		table_3.getColumnModel().getColumn(1).setPreferredWidth(140);
		
		table_3.setBounds(375, 91, 889, 422);
		JScrollPane scrollPane_3 = new JScrollPane(table_3);
		scrollPane_3.setBounds(10, 344, 329, 325);
		scrollPane_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(scrollPane_3);
		
		//bang phu kien
		table_4 = new JTable();
		table_4.setBackground(new Color(255, 255, 187));
//		table.setFont(new Font("Tahoma", Font.PLAIN, 25));
		table_4.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
			},
			new String[] {
				"Part", "Price"
			}
		));
		table_4.getColumnModel().getColumn(0).setPreferredWidth(102);
		table_4.getColumnModel().getColumn(1).setPreferredWidth(88);
		
		table_4.setBounds(375, 91, 889, 422);
		JScrollPane scrollPane_4 = new JScrollPane(table_4);
		scrollPane_4.setBounds(343, 344, 337, 325);
		scrollPane_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(scrollPane_4);
		
		//bang_phu huong vi
		table_5 = new JTable();
		table_5.setBackground(new Color(206, 206, 255));
//		table.setFont(new Font("Tahoma", Font.PLAIN, 25));
		table_5.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
			},
			new String[] {
				"Taste", "Price"
			}
		));
		
		table_5.setBounds(375, 91, 889, 422);
		JScrollPane scrollPane_5 = new JScrollPane(table_5);
		scrollPane_5.setBounds(685, 344, 322, 325);
		scrollPane_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(scrollPane_5);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField.setColumns(10);
		textField.setBounds(1060, 12, 143, 36);
		contentPane.add(textField);
		
		JLabel lblNewLabel = new JLabel(new ImageIcon( new ImageIcon(
				Toolkit.getDefaultToolkit().getImage(
						CakePrice.class.getResource("/Image/kinhlup.png")
						)
				).getImage().getScaledInstance(41, 36, Image.SCALE_DEFAULT)));
		lblNewLabel.setBounds(1015, 12, 41, 36);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_Find = new JButton("Find");
		btnNewButton_Find.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_Find.setBackground(new Color(217, 217, 217));
		btnNewButton_Find.setBounds(1207, 21, 72, 23);
		contentPane.add(btnNewButton_Find);
		
		JLabel lblNewLabel_1 = new JLabel(new ImageIcon( new ImageIcon(
				Toolkit.getDefaultToolkit().getImage(
						CakePrice.class.getResource("/Image/giphy.gif")
						)
				).getImage().getScaledInstance(256, 569, Image.SCALE_DEFAULT)));
		lblNewLabel_1.setText("");
		lblNewLabel_1.setBounds(1018, 78, 256, 569);
		contentPane.add(lblNewLabel_1);
		
		
		
		
//		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
//		tabbedPane.setBackground(new Color(255, 200, 200));
//		tabbedPane.setForeground(new Color(128, 0, 0));
//		tabbedPane.setFont(new Font("Sylfaen", Font.BOLD, 25));
//		tabbedPane.setBounds(10, 0, 1389, 652);
//		contentPane.add(tabbedPane);
	}
}
