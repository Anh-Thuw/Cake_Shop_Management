package PartyShopManagerThuQuynh;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HistoryCus extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					HistoryCus frame = new HistoryCus();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public HistoryCus() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 198, 198));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel(new ImageIcon( new ImageIcon(
				Toolkit.getDefaultToolkit().getImage(
						HistoryCus.class.getResource("/Image/gato1.jpg")
						)
				).getImage().getScaledInstance(836, 200, Image.SCALE_DEFAULT)));
		lblNewLabel.setBounds(0, 0, 836, 200);
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(0, 0, 0));
		separator.setForeground(new Color(0, 0, 0));
		separator.setBounds(10, 248, 434, 2);
		contentPane.add(separator);
		
		JLabel lblNewLabel_1 = new JLabel("Purchase History");
		lblNewLabel_1.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1.setBounds(10, 223, 265, 27);
		contentPane.add(lblNewLabel_1);
		
		table = new JTable();
		table.setBackground(new Color(255, 255, 221));
//		table.setFont(new Font("Tahoma", Font.PLAIN, 25));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"ID Bill", "Goods Purchased", "Date", "Price"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(40);
		table.getColumnModel().getColumn(1).setPreferredWidth(249);
		
		table.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 20));
		table.setBounds(375, 91, 889, 422);
		
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setFont(new Font("Tahoma", Font.PLAIN, 10));
		scrollPane.setBounds(0, 257, 836, 347);
		contentPane.add(scrollPane);
		
		JButton btnNewButton = new JButton("Exit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				HomeCustomer ho = new HomeCustomer();
				ho.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setForeground(new Color(128, 0, 0));
		btnNewButton.setBackground(new Color(206, 206, 255));
		btnNewButton.setBounds(703, 615, 95, 37);
		contentPane.add(btnNewButton);
		
		JButton btnClean = new JButton("Clean");
		btnClean.setForeground(new Color(128, 0, 0));
		btnClean.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnClean.setBackground(new Color(206, 206, 255));
		btnClean.setBounds(588, 615, 95, 37);
		contentPane.add(btnClean);
	}
}
