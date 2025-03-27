package event.management.systen;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import net.proteanit.sql.DbUtils;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;

public class ManageEvents extends JFrame {

	private JPanel contentPane;
	private JTextField tfeid;
	private JTextField tfename;
	private JTextField tfeaddress;
	private JTable eventtable;
	private JTextField tfecollege;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageEvents frame = new ManageEvents();
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
	public ManageEvents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800,600);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.PINK);
		panel.setBounds(0, 0, 130, 561);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("EVENTS");
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(Color.PINK);
		btnNewButton.setBorder(null);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ManageEvents ME= new ManageEvents();
				ME.show();
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnNewButton.setBounds(15, 11, 100, 23);
		panel.add(btnNewButton);
		
		
		JButton btnGenre = new JButton("USERS");
		btnGenre.setForeground(new Color(0, 0, 0));
		btnGenre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ManageUser MU=new ManageUser();
				MU.show();
				dispose();
				
			}
		});
		btnGenre.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnGenre.setBorder(null);
		btnGenre.setBackground(Color.PINK);
		btnGenre.setBounds(20, 68, 89, 23);
		panel.add(btnGenre);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Splash sp=new Splash();
				sp.show();
				dispose();
			}
		});
		btnBack.setFont(new Font("Poppins", Font.BOLD, 25));
		btnBack.setBorder(null);
		btnBack.setBackground(Color.PINK);
		btnBack.setBounds(14, 527, 101, 23);
		panel.add(btnBack);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLACK);
		panel_1.setBounds(130, 0, 654, 561);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JDateChooser edate = new JDateChooser();
		edate.setDateFormatString("yyyy-MM-dd");
		edate.setBounds(425, 40, 219, 32);
		panel_1.add(edate);
		
		JLabel lblNewLabel = new JLabel("MANAGE EVENTS");
		lblNewLabel.setBounds(146, 5, 362, 25);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.PINK);
		lblNewLabel.setBackground(Color.BLACK);
		panel_1.add(lblNewLabel);
		
		JLabel lblUserId = new JLabel("Event ID");
		lblUserId.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserId.setForeground(Color.PINK);
		lblUserId.setFont(new Font("Poppins", Font.BOLD, 20));
		lblUserId.setBackground(Color.BLACK);
		lblUserId.setBounds(10, 41, 124, 25);
		panel_1.add(lblUserId);
		
		JLabel lblName = new JLabel("Name");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setForeground(Color.PINK);
		lblName.setFont(new Font("Poppins", Font.BOLD, 20));
		lblName.setBackground(Color.BLACK);
		lblName.setBounds(10, 77, 124, 25);
		panel_1.add(lblName);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddress.setForeground(Color.PINK);
		lblAddress.setFont(new Font("Poppins", Font.BOLD, 20));
		lblAddress.setBackground(Color.BLACK);
		lblAddress.setBounds(10, 113, 124, 25);
		panel_1.add(lblAddress);
		
		JLabel lblGenre = new JLabel("Genre");
		lblGenre.setHorizontalAlignment(SwingConstants.CENTER);
		lblGenre.setForeground(Color.PINK);
		lblGenre.setFont(new Font("Poppins", Font.BOLD, 20));
		lblGenre.setBackground(Color.BLACK);
		lblGenre.setBounds(333, 77, 82, 25);
		panel_1.add(lblGenre);
		
		tfeid = new JTextField();
		tfeid.setFont(new Font("Poppins", Font.BOLD, 12));
		tfeid.setEnabled(false);
		tfeid.setBorder(null);
		tfeid.setBounds(132, 41, 191, 25);
		panel_1.add(tfeid);
		tfeid.setColumns(10);
		
		tfename = new JTextField();
		tfename.setFont(new Font("Poppins", Font.BOLD, 12));
		tfename.setColumns(10);
		tfename.setBorder(null);
		tfename.setBounds(132, 77, 191, 25);
		panel_1.add(tfename);
		
		tfeaddress = new JTextField();
		tfeaddress.setFont(new Font("Poppins", Font.BOLD, 12));
		tfeaddress.setColumns(10);
		tfeaddress.setBorder(null);
		tfeaddress.setBounds(132, 113, 191, 25);
		panel_1.add(tfeaddress);
		
		final JComboBox egenre = new JComboBox();
		egenre.setForeground(Color.BLACK);
		egenre.setBackground(Color.WHITE);
		egenre.setBorder(null);
		egenre.setFont(new Font("Poppins", Font.BOLD, 12));
		egenre.setModel(new DefaultComboBoxModel(new String[] {"Music", "Spiritual", "Academic", "Cultural", "Sports", "Social", "Educational Workshop", "Alumni Reunion", "Heath and Wellness Program", "Art Showcase", "Technology and Innovation", "Food Fest", "Charity"}));
		egenre.setBounds(425, 78, 219, 27);
		panel_1.add(egenre);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setFont(new Font("Poppins", Font.PLAIN, 14));
		scrollPane.setBounds(10, 198, 634, 352);
		panel_1.add(scrollPane);
		
		eventtable = new JTable();
		eventtable.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel model= (DefaultTableModel)eventtable.getModel();
				int MyIndex =eventtable.getSelectedRow();
				tfeid.setText(model.getValueAt(MyIndex, 0).toString());
				tfename.setText(model.getValueAt(MyIndex, 1).toString());
				tfecollege.setText(model.getValueAt(MyIndex, 3).toString());
				tfeaddress.setText(model.getValueAt(MyIndex, 4).toString());
			}
		});
		SelectEvents();
		scrollPane.setViewportView(eventtable);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setForeground(Color.BLACK);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if(tfename.getText().isEmpty()||tfecollege.getText().isEmpty()||tfeaddress.getText().isEmpty()||edate.getDate().toString().isEmpty()||egenre.getSelectedItem().toString().isEmpty()) {
					JOptionPane.showMessageDialog(null,"Missing Field");
				}
				else {
					String Name = tfename.getText();
					String College= tfecollege.getText();
		            String Address = tfeaddress.getText();
		            Date date = edate.getDate(); 
	                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
	                String strDate = dateFormat.format(date);

		            String Genre=egenre.getSelectedItem().toString();            
		            
		            try {
		                Connect conn = new Connect();
		                
		                String query = "insert into event(Name,College, EventDate, Location, Genre) values('"+Name+"','"+College+"', '"+strDate+"', '"+Address+"', '"+Genre+"');";
		                
		                conn.stm.executeUpdate(query);
		                SelectEvents();
		                
		                JOptionPane.showMessageDialog(null, "Details added successfully");
		            } catch (Exception e1) {
		                e1.printStackTrace();
		            }
				}
			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAdd.setBorder(null);
		btnAdd.setBackground(Color.PINK);
		btnAdd.setBounds(263, 163, 69, 17);
		panel_1.add(btnAdd);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setForeground(Color.BLACK);
		btnEdit.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String eid= tfeid.getText();
				String Name=tfename.getText();
				String College=tfecollege.getText();
				String Address=tfeaddress.getText();
				String Genre=egenre.getSelectedItem().toString();
				 Date date = edate.getDate(); 
	                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
	                String strDate = dateFormat.format(date);
				if(tfename.getText().isEmpty()||tfecollege.getText().isEmpty()||tfeaddress.getText().isEmpty()||egenre.getSelectedItem().toString().isEmpty()){
					JOptionPane.showMessageDialog(null, "Enter data to the field.");
				}
				else {
					try {
						Connect conn=new Connect();
						String query="Update eventmgmt.event set Name='"+Name+"',College='"+College+"', Location='"+Address+"', EventDate='"+strDate+"', Genre='"+Genre+"' WHERE EventID='"+eid+"'";
						conn.stm.executeUpdate(query);
						SelectEvents();
						JOptionPane.showMessageDialog(null, "Value changed.");
						
					}
					catch(Exception e1){
						e1.printStackTrace();
					}
				}
			}
		});
	
		btnEdit.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnEdit.setBorder(null);
		btnEdit.setBackground(Color.PINK);
		btnEdit.setBounds(348, 163, 69, 17);
		panel_1.add(btnEdit);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setForeground(Color.BLACK);
		btnDelete.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(tfeid.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Enter data to the field.");
				}
				else {
					try {
						String eid=tfeid.getText();
						Connect conn=new Connect();
						String query="Delete from eventmgmt.event where EventID ="+eid;
						conn.stm.executeUpdate(query);
						SelectEvents();
						JOptionPane.showMessageDialog(null, "Value deleted.");
						
					}
					catch(Exception e1){
						e1.printStackTrace();
					}
				}
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnDelete.setBorder(null);
		btnDelete.setBackground(Color.PINK);
		btnDelete.setBounds(427, 163, 97, 17);
		panel_1.add(btnDelete);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setForeground(Color.BLACK);
		btnClear.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				tfeid.setText("");
				tfename.setText("");
				tfecollege.setText("");
				tfeaddress.setText("");
				edate.getDate();
				egenre.setSelectedItem(null);
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnClear.setBorder(null);
		btnClear.setBackground(Color.PINK);
		btnClear.setBounds(534, 163, 82, 17);
		panel_1.add(btnClear);
		
		JLabel lblCollege = new JLabel("College");
		lblCollege.setHorizontalAlignment(SwingConstants.CENTER);
		lblCollege.setForeground(Color.PINK);
		lblCollege.setFont(new Font("Poppins", Font.BOLD, 20));
		lblCollege.setBackground(Color.BLACK);
		lblCollege.setBounds(331, 113, 84, 25);
		panel_1.add(lblCollege);
		
		tfecollege = new JTextField();
		tfecollege.setFont(new Font("Poppins", Font.BOLD, 12));
		tfecollege.setColumns(10);
		tfecollege.setBorder(null);
		tfecollege.setBounds(425, 113, 219, 25);
		panel_1.add(tfecollege);
		
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblDate.setForeground(Color.PINK);
		lblDate.setFont(new Font("Dialog", Font.BOLD, 20));
		lblDate.setBackground(Color.BLACK);
		lblDate.setBounds(333, 41, 82, 25);
		panel_1.add(lblDate);
		
		
	}

	public void SelectEvents() {
		try {
			String query= "SELECT * FROM eventmgmt.event";
			Connect conn= new Connect();
			ResultSet rs=conn.stm.executeQuery(query);
			eventtable.setModel(DbUtils.resultSetToTableModel(rs));
		}
		
		catch(Exception e) {
			e.printStackTrace();
			}
		
	}
}
