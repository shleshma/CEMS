package event.management.systen;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.ResultSet;

import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Userdash extends JFrame {

	private JPanel contentPane;
	private JTextField tfsearch;
	private JTable table;
	private JScrollPane scrollpane;
	private JTable eventtable;
	public Object jlabel;
	public String Genre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Userdash frame = new Userdash(null);
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
	public Userdash(final String name) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800,600);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tfsearch = new JTextField();
		tfsearch.setBorder(null);
		tfsearch.setFont(new Font("Poppins", Font.BOLD, 12));
		tfsearch.setBounds(275, 67, 233, 36);
		contentPane.add(tfsearch);
		tfsearch.setColumns(10);
		
		
		
		JLabel lblSearch = new JLabel("Search");
		lblSearch.setForeground(Color.PINK);
		lblSearch.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearch.setFont(new Font("Poppins", Font.BOLD, 20));
		lblSearch.setBounds(176, 73, 89, 23);
		contentPane.add(lblSearch);
		
		JLabel lblUser = new JLabel("USER");
		lblUser.setForeground(Color.PINK);
		lblUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblUser.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblUser.setBounds(313, 11, 157, 36);
		contentPane.add(lblUser);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 173, 732, 316);
		contentPane.add(scrollPane);
		
		eventtable = new JTable();
		scrollPane.setViewportView(eventtable);
		
		JButton logout = new JButton("LOG OUT");
		logout.setFont(new Font("Poppins", Font.BOLD, 15));
		logout.setBackground(Color.PINK);
		logout.setBorder(null);
		logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserLogin ul= new UserLogin();
				dispose();
				ul.show();
			}
		});
		logout.setBounds(669, 527, 89, 23);
		contentPane.add(logout);
		
		final JComboBox combo = new JComboBox();
		combo.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				if(combo.getSelectedItem().toString()=="All" ) {
					SelectAllEvents();
				}
				else
					Genre= combo.getSelectedItem().toString();
				SelectGenreEvents();
			}
		});
	
		combo.setFont(new Font("Poppins", Font.BOLD, 12));
		combo.setBorder(null);
		combo.setModel(new DefaultComboBoxModel(new String[] {"Music", "Spiritual", "Education","Academic", "Cultural", "Sports", "Social", "Career Fairs", "Educational Workshop", "Alumni Reunion", "Heath and Wellness Program", "Art Showcase", "Technology and Innovation", "Food Fest", "Charity","All"}));
		combo.setBounds(275, 114, 233, 34);
		contentPane.add(combo);
		
		JLabel lblNewLabel = new JLabel("Genre");
		lblNewLabel.setForeground(Color.PINK);
		lblNewLabel.setFont(new Font("Poppins", Font.BOLD, 20));
		lblNewLabel.setBounds(186, 114, 63, 31);
		contentPane.add(lblNewLabel);
		
		JButton btnsearch = new JButton("Search");
		btnsearch.setBorder(null);
		btnsearch.setForeground(Color.BLACK);
		btnsearch.setBackground(Color.PINK);
		btnsearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SelectEvents();
				
			}
		});
		btnsearch.setFont(new Font("Poppins", Font.BOLD, 15));
		btnsearch.setBounds(520, 88, 89, 30);
		contentPane.add(btnsearch);
		
		JButton btnNewButton = new JButton();
		btnNewButton.setBorder(null);
		btnNewButton.setForeground(Color.PINK);
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setText("Hello, "+name);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserUpdate up= new UserUpdate(name);
				up.show();
				dispose();
			}
		});
		
		btnNewButton.setFont(new Font("Poppins", Font.BOLD, 15));
		btnNewButton.setBounds(10, 11, 233, 36);
		contentPane.add(btnNewButton);
		
		
		
	}
	
	

	public void SelectEvents() {
		try {
			String Name=tfsearch.getText();
			String query= "SELECT EventID,Name,EventDate,Location,Genre FROM eventmgmt.event where Name LIKE '%"+Name+"%' || Genre='"+Genre+"'";
			Connect conn= new Connect();
			ResultSet rs=conn.stm.executeQuery(query);
			eventtable.setModel(DbUtils.resultSetToTableModel(rs));
		}
		
		catch(Exception e) {
			e.printStackTrace();
			}
		
	}
	public void SelectGenreEvents() {
		try {
			String query= "SELECT EventID,Name,EventDate,Location,Genre FROM eventmgmt.event where Genre='"+Genre+"'";
			Connect conn= new Connect();
			ResultSet rs=conn.stm.executeQuery(query);
			eventtable.setModel(DbUtils.resultSetToTableModel(rs));
		}
		
		catch(Exception e) {
			e.printStackTrace();
			}
		
	}
	public void SelectAllEvents() {
		try {
			String query= "SELECT EventID,Name,EventDate,Location,Genre FROM eventmgmt.event ";
			Connect conn= new Connect();
			ResultSet rs=conn.stm.executeQuery(query);
			eventtable.setModel(DbUtils.resultSetToTableModel(rs));
		}
		
		catch(Exception e) {
			e.printStackTrace();
			}
		
	}
}
