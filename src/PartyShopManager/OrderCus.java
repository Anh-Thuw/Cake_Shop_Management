package PartyShopManagerThuQuynh;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class OrderCus extends JPanel {
	public static JTable table_hienthi = new JTable();

	/**
	 * Create the panel.
	 */
	public OrderCus() {
		setBackground(new Color(255, 202, 202));
		
				
				setBounds(100, 100, 399, 656);
				setLayout(null);
//				contentPane = new JPanel();
//				contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//
//				setContentPane(contentPane);
				
				table_hienthi.setBackground(new Color(213, 255, 255));
//				table.setFont(new Font("Tahoma", Font.PLAIN, 25));
				table_hienthi.setModel(new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
						"Name", "Quantity", "Price"
					}
				));
				table_hienthi.getColumnModel().getColumn(0).setPreferredWidth(131);
				table_hienthi.getColumnModel().getColumn(1).setPreferredWidth(57);
				table_hienthi.getColumnModel().getColumn(2).setPreferredWidth(122);
				table_hienthi.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 13));
				table_hienthi.setBounds(39, 620, 382, 600);
				
				JScrollPane scrollPane = new JScrollPane(table_hienthi);
				scrollPane.setBounds(0, 191, 382, 393);
				add(scrollPane);
				
				JButton btnNewButton = new JButton("Order");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
					}
				});
				btnNewButton.setForeground(new Color(128, 0, 0));
				btnNewButton.setBackground(new Color(193, 193, 255));
				btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
				btnNewButton.setBounds(0, 597, 95, 31);
				add(btnNewButton);
				
				JButton btnDelete = new JButton("Delete");
				btnDelete.setForeground(new Color(128, 0, 0));
				btnDelete.setFont(new Font("Tahoma", Font.BOLD, 18));
				btnDelete.setBackground(new Color(193, 193, 255));
				btnDelete.setBounds(105, 595, 99, 33);
				add(btnDelete);
				
				JButton btnReset = new JButton("Reset");
				btnReset.setForeground(new Color(128, 0, 0));
				btnReset.setFont(new Font("Tahoma", Font.BOLD, 18));
				btnReset.setBackground(new Color(193, 193, 255));
				btnReset.setBounds(209, 595, 94, 33);
				add(btnReset);
				
				JLabel lblNewLabel = new JLabel(new ImageIcon( new ImageIcon(
						Toolkit.getDefaultToolkit().getImage(
								OrderCus.class.getResource("/Image/OrderCus.jpg")
								)
						).getImage().getScaledInstance(382, 191, Image.SCALE_DEFAULT)));
				lblNewLabel.setBounds(0, 0, 382, 191);
				add(lblNewLabel);
				
				JButton btnNewButton_1 = new JButton("Exit");
				btnNewButton_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
						HomeCustomer ho = new HomeCustomer();
						ho.setVisible(true);
					}
				});
				btnNewButton_1.setForeground(new Color(128, 0, 0));
				btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 18));
				btnNewButton_1.setBackground(new Color(193, 193, 255));
				btnNewButton_1.setBounds(313, 594, 83, 34);
				add(btnNewButton_1);
			}

		}


	


