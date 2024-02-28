package PartyShopManagerThuQuynh;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;



import SavePartyShopManager.SaveEmployee;

public class EmployeeMana extends JPanel {
	ArrayList<SaveEmployee> listEmp = new ArrayList<SaveEmployee>();
	private JTable table;
	private JTextField textField_ID;
	private JTextField textField_Name;
	private JTextField textField_Sex;
	private JTextField textField_CCCD;
	private JTextField textField_Phone;
	private JTextField textField_Salary;
	private JTextField textField_Find;
	private JTextPane textPane_Note;
	private JColorChooser dateChooser;
	private DefaultTableModel modelEmp;
	private SimpleDateFormat dateFormat;
	private JComboBox cbb_Shifts;
	
	/**
	 * Create the panel.
	 */
	public EmployeeMana() {
		setBackground(new Color(206, 206, 255));
		setLayout(null);
		setBounds(0, 0, 1156, 652);
		
		JLabel lblNewLabel_2 = new JLabel("The list of Employee");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 35));
		lblNewLabel_2.setBounds(24, 11, 373, 43);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel(new ImageIcon( new ImageIcon(
				Toolkit.getDefaultToolkit().getImage(
						EmployeeMana.class.getResource("/Image/employ1.jpg")
						)
				).getImage().getScaledInstance(54, 38, Image.SCALE_DEFAULT)));
		lblNewLabel_3.setBounds(393, 11, 54, 38);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel = new JLabel(new ImageIcon( new ImageIcon(
				Toolkit.getDefaultToolkit().getImage(
						EmployeeMana.class.getResource("/Image/kinhlup.png")
						)
				).getImage().getScaledInstance(41, 36, Image.SCALE_DEFAULT)));
		lblNewLabel.setBounds(787, 11, 41, 36);
		lblNewLabel.setSize(41,36);
		add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(0, 0, 0));
		separator.setBounds(24, 52, 494, 2);
		add(separator);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				showEmp();
			}
		});
		table.setBackground(new Color(223, 255, 255));
//		table.setFont(new Font("Tahoma", Font.PLAIN, 25));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Name", "Date", "Sex", "CCCD", "Phone", "Salary", "Shifts", "Note"
			}
		));
		findEmp();
		loadInformationEmp();
		
	
		table.setBounds(375, 91, 889, 422);
		
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setFont(new Font("Tahoma", Font.PLAIN, 10));
		scrollPane.setBounds(10, 60, 1136, 332);
		add(scrollPane);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(24, 398, 952, 2);
		add(separator_1);
		
		JLabel lblNewLabel_1 = new JLabel("ID:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(24, 414, 72, 29);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Name:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1_1.setBounds(24, 477, 84, 29);
		add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Date:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1_2.setBounds(24, 539, 72, 29);
		add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_4 = new JLabel("Sex:");
		lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1_4.setBounds(24, 599, 72, 29);
		add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_3 = new JLabel("CCCD:");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1_3.setBounds(409, 414, 72, 29);
		add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_5 = new JLabel("Phone:");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1_5.setBackground(SystemColor.menu);
		lblNewLabel_1_5.setBounds(409, 477, 104, 29);
		add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_5_1 = new JLabel("Salary:");
		lblNewLabel_1_5_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1_5_1.setBackground(SystemColor.menu);
		lblNewLabel_1_5_1.setBounds(409, 539, 104, 29);
		add(lblNewLabel_1_5_1);
		
		JLabel lblNewLabel_1_5_2 = new JLabel("Shifts:");
		lblNewLabel_1_5_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1_5_2.setBackground(SystemColor.menu);
		lblNewLabel_1_5_2.setBounds(409, 599, 104, 29);
		add(lblNewLabel_1_5_2);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Note:");
		lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1_3_1.setBounds(798, 414, 72, 29);
		add(lblNewLabel_1_3_1);
		
		textField_ID = new JTextField();
		textField_ID.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField_ID.setColumns(10);
		textField_ID.setBounds(106, 411, 238, 35);
		add(textField_ID);
		textField_ID.setEditable(false);
		
		textField_Name = new JTextField();
		textField_Name.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField_Name.setColumns(10);
		textField_Name.setBounds(106, 471, 238, 35);
		add(textField_Name);
		
		textField_Sex = new JTextField();
		textField_Sex.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField_Sex.setColumns(10);
		textField_Sex.setBounds(106, 593, 90, 35);
		add(textField_Sex);
		
		JRadioButton jrdBoy = new JRadioButton("Boy");
		jrdBoy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sex1();
			}
		});
		jrdBoy.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jrdBoy.setBackground(new Color(206, 206, 255));
		jrdBoy.setBounds(202, 602, 63, 23);
		add(jrdBoy);
		
		JRadioButton jrdGirl = new JRadioButton("Girl");
		jrdGirl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sex2();
			}
		});
		jrdGirl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jrdGirl.setBackground(new Color(206, 206, 255));
		jrdGirl.setBounds(270, 602, 63, 23);
		add(jrdGirl);
		
		textField_CCCD = new JTextField();
		textField_CCCD.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField_CCCD.setColumns(10);
		textField_CCCD.setBounds(491, 408, 238, 35);
		add(textField_CCCD);
		
		textField_Phone = new JTextField();
		textField_Phone.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField_Phone.setColumns(10);
		textField_Phone.setBounds(491, 471, 238, 35);
		add(textField_Phone);
		
		textField_Salary = new JTextField();
		textField_Salary.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField_Salary.setColumns(10);
		textField_Salary.setBounds(491, 533, 238, 35);
		add(textField_Salary);
		
		
		
		 cbb_Shifts = new JComboBox();
		cbb_Shifts.setFont(new Font("Tahoma", Font.PLAIN, 25));
		cbb_Shifts.setModel(new DefaultComboBoxModel(new String[] {"Morning shift", "Night shift", "Afternoon shift", "All day", "Morning shift,Night shift", "Morning shift,Afternoon shift", "Night shift,Afternoon shift"}));
		cbb_Shifts.setBounds(491, 593, 238, 35);
		add(cbb_Shifts);
		
		 textPane_Note = new JTextPane();
		textPane_Note.setBounds(880, 411, 239, 124);
		add(textPane_Note);
	
		
		textField_Find = new JTextField();
		textField_Find.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String  searchString = textField_Find.getText();
				reseachEmp(searchString);
			}
		});
		textField_Find.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField_Find.setColumns(10);
		textField_Find.setBounds(833, 11, 271, 36);
		add(textField_Find);
		
		JButton btnNewButton_Del = new JButton("Delete");
		btnNewButton_Del.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = textField_ID.getText();
				SQL xuly = new SQL();
				if( xuly.deleteEmp(id)) {
					clear();
					findEmp();
					loadInformationEmp();
					JOptionPane.showMessageDialog(null, "Delete Sucessfully");
				}else {
					JOptionPane.showMessageDialog(null, "Delete Error");
				}
			}
		});
		btnNewButton_Del.setForeground(new Color(0, 64, 128));
		btnNewButton_Del.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_Del.setBackground(new Color(230, 255, 255));
		btnNewButton_Del.setBounds(811, 548, 113, 36);
		add(btnNewButton_Del);
		
		JButton btnNewButton_Add = new JButton("Add");
		btnNewButton_Add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				long cccd = Long.parseLong(textField_CCCD.getText());
				long phone = Long.parseLong(textField_Phone.getText());
				long salary = Long.parseLong(textField_Salary.getText());
				//int id = Integer.parseInt(textField_ID.getText());
				SaveEmployee emp = new SaveEmployee();
				emp.setCccd(cccd);
				emp.setPhone(phone);
				emp.setSalary(salary);
				//emp.setId(id);
				emp.setName(textField_Name.getText());
				emp.setSex(textField_Sex.getText());
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String date = sdf.format(dateChooser.getDate());
				emp.setDate(date);
				String shifts ;
				shifts = cbb_Shifts.getSelectedItem().toString();
				emp.setShifts(shifts);
				emp.setNote(textPane_Note.getText());
				SQL xuly = new SQL();
				if ( xuly.saveEmployee(emp)) {
					findEmp();
					loadInformationEmp();
					clear();
					JOptionPane.showMessageDialog(null, "Add Sucessfully ");	
				}
				else {
					JOptionPane.showMessageDialog(null, "Error");	
				}
			}
		});
		btnNewButton_Add.setForeground(new Color(0, 64, 128));
		btnNewButton_Add.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_Add.setBackground(new Color(230, 255, 255));
		btnNewButton_Add.setBounds(811, 608, 113, 36);
		add(btnNewButton_Add);
		
		JButton btnNewButton_Edit = new JButton("Clear");
		btnNewButton_Edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
			}
		});
		btnNewButton_Edit.setForeground(new Color(0, 64, 128));
		btnNewButton_Edit.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_Edit.setBackground(new Color(230, 255, 255));
		btnNewButton_Edit.setBounds(934, 548, 113, 36);
		add(btnNewButton_Edit);
		
		JButton btnNewButton_Update = new JButton("Update");
		btnNewButton_Update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				long cccd = Long.parseLong(textField_CCCD.getText());
				long phone = Long.parseLong(textField_Phone.getText());
				long salary = Long.parseLong(textField_Salary.getText());
				int id = Integer.parseInt(textField_ID.getText());
				SaveEmployee emp = new SaveEmployee();
				emp.setCccd(cccd);
				emp.setPhone(phone);
				emp.setSalary(salary);
				emp.setId(id);
				emp.setName(textField_Name.getText());
				emp.setSex(textField_Sex.getText());
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String date = sdf.format(dateChooser.getDate());
				emp.setDate(date);
				String shifts ;
				shifts = cbb_Shifts.getSelectedItem().toString();
				emp.setShifts(shifts);
				emp.setNote(textPane_Note.getText());
				SQL xuly = new SQL();
				if ( xuly.updateEmp(emp)) {
					clear();
					findEmp();
					loadInformationEmp();
					JOptionPane.showMessageDialog(null, "Update Sucessfully");
				}else {
					JOptionPane.showMessageDialog(null, "Update Error ");
				}
				
				
			}
		});
		btnNewButton_Update.setForeground(new Color(0, 64, 128));
		btnNewButton_Update.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_Update.setBackground(new Color(230, 255, 255));
		btnNewButton_Update.setBounds(934, 608, 113, 36);
		add(btnNewButton_Update);
		
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
		btnNewButton_Exit.setBounds(1057, 567, 72, 61);
		add(btnNewButton_Exit);
		
		 dateChooser = new JDateChooser();
		 dateChooser.setDateFormatString("yyyy-MM-dd");
		dateChooser.setBounds(106, 530, 238, 38);
		dateChooser.setFont(new Font("Tahoma", Font.PLAIN, 17));
		add(dateChooser);

	}
	public void sex1() {
		textField_Sex.setText("Boy");
	}
	public void sex2() {
		textField_Sex.setText("Girl");
	}
	void clear() {
		textField_CCCD.setText("");
		dateChooser.setCalendar(null);
		textField_Find.setText("");
		textField_ID.setText("");
		textField_Name.setText("");
		textField_Phone.setText("");
		textField_Salary.setText("");
		textField_Sex.setText("");
		textPane_Note.setText("");
	}
	private void findEmp() {
		try {
			Connection con = DataSQL.getConnection();
			String sql = "select Id,Name,Date,Sex,Cccd,Phone,Salary,Shifts,Note from Employee";
			PreparedStatement pre = con.prepareStatement(sql);
			ResultSet rs = pre.executeQuery();
			listEmp.clear();
			while (rs.next()) {
				SaveEmployee emp = new SaveEmployee(rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(8),rs.getString(9), rs.getLong(5),rs.getLong(6),rs.getLong(7),rs.getInt(1));
				listEmp.add(emp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void loadInformationEmp() {
		modelEmp = (DefaultTableModel) table.getModel();
		modelEmp.setRowCount(0);
		Object[] row = new Object[9];
		for (int i = 0; i < listEmp.size(); i++) {
			row[0] = listEmp.get(i).getId();
			row[1] = listEmp.get(i).getName();
			row[2] = listEmp.get(i).getDate();
			row[3] = listEmp.get(i).getSex();
			row[4] = listEmp.get(i).getCccd();
			row[5] = listEmp.get(i).getPhone();
			row[6] = listEmp.get(i).getSalary();
			row[7] = listEmp.get(i).getShifts();
			row[8] = listEmp.get(i).getNote();
			modelEmp.addRow(row);
		}
		table.setRowHeight(50);
		
	}
	private void showEmp () {
		modelEmp = (DefaultTableModel) table.getModel();
		int row = table.getSelectedRow();
		textField_ID.setText(modelEmp.getValueAt(row, 0).toString());
		textField_Name.setText(modelEmp.getValueAt(row, 1).toString());
		textField_Sex.setText(modelEmp.getValueAt(row, 3).toString());
		textField_CCCD.setText(modelEmp.getValueAt(row, 4).toString());
		textField_Phone.setText(modelEmp.getValueAt(row, 5).toString());
		textField_Salary.setText(modelEmp.getValueAt(row, 6).toString());
		String shifts = modelEmp.getValueAt(row, 7).toString();
		for ( int i = 0  ; i < cbb_Shifts.getItemCount() ; i++) {
			if ( cbb_Shifts.getItemAt(i).toString().equalsIgnoreCase(shifts)) {
				cbb_Shifts.setSelectedIndex(i);
			}
		
		}
		textPane_Note.setText(modelEmp.getValueAt(row, 8).toString());
		try {
			Date date = new SimpleDateFormat("yyyy-MM-dd").parse((String)modelEmp.getValueAt(row, 2));
			dateChooser.setDate(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// tim kiem 
	public void serRecordsToTableEmp() {
		try {
			Connection con = DataSQL.getConnection();
			String sql = "select Id,Name,Date,Sex,Cccd,Phone,Salary,Shifts,Note from Employee";
			PreparedStatement pre = con.prepareStatement(sql);
			ResultSet rs = pre.executeQuery();
			while (rs.next()) {
				SaveEmployee emp = new SaveEmployee(rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(8),rs.getString(9), rs.getLong(5),rs.getLong(6),rs.getLong(7),rs.getInt(1));
				Object[] obj = { "ID", "Name", "Date", "Sex", "CCCD", "Phone", "Salary", "Shifts", "Note" };
				modelEmp = (DefaultTableModel) table.getModel();
				modelEmp.addRow(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void reseachEmp(String str) {
		modelEmp = (DefaultTableModel) table.getModel();
		TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(modelEmp);
		table.setRowSorter(trs);
		trs.setRowFilter(RowFilter.regexFilter(str));
	}
	
}
