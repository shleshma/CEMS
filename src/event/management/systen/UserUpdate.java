package event.management.systen;

import java.awt.EventQueue;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class UserUpdate extends JFrame {

	private JPanel contentPane;
	private JTextField tfuid;
	private JTextField tfuname;
	private JTextField tfuphone;
	private JTextField tfuaddress;
	private JTextField tfuemail;
	private JTextField tfupass;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserUpdate frame = new UserUpdate(null);
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
	public UserUpdate(final String name) {
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800,600);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setForeground(Color.PINK);
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Update User");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Poppins", Font.BOLD, 30));
		lblNewLabel.setForeground(Color.PINK);
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setBounds(203, 11, 378, 70);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("UserID");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Poppins", Font.BOLD, 20));
		lblNewLabel_1.setForeground(Color.PINK);
		lblNewLabel_1.setBackground(Color.BLACK);
		lblNewLabel_1.setBounds(70, 115, 120, 25);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Username");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Poppins", Font.BOLD, 20));
		lblNewLabel_2.setForeground(Color.PINK);
		lblNewLabel_2.setBackground(Color.BLACK);
		lblNewLabel_2.setBounds(70, 165, 120, 25);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Phone");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Poppins", Font.BOLD, 20));
		lblNewLabel_3.setForeground(Color.PINK);
		lblNewLabel_3.setBackground(Color.BLACK);
		lblNewLabel_3.setBounds(70, 215, 120, 25);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Address");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setFont(new Font("Poppins", Font.BOLD, 20));
		lblNewLabel_3_1.setForeground(Color.PINK);
		lblNewLabel_3_1.setBackground(Color.BLACK);
		lblNewLabel_3_1.setBounds(70, 265, 120, 25);
		contentPane.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("Email");
		lblNewLabel_3_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_2.setFont(new Font("Poppins", Font.BOLD, 20));
		lblNewLabel_3_2.setForeground(Color.PINK);
		lblNewLabel_3_2.setBackground(Color.BLACK);
		lblNewLabel_3_2.setBounds(70, 315, 120, 25);
		contentPane.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_3_3 = new JLabel("Password");
		lblNewLabel_3_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_3.setFont(new Font("Poppins", Font.BOLD, 20));
		lblNewLabel_3_3.setForeground(Color.PINK);
		lblNewLabel_3_3.setBackground(Color.BLACK);
		lblNewLabel_3_3.setBounds(70, 365, 120, 25);
		contentPane.add(lblNewLabel_3_3);
		
		tfuid = new JTextField();
		tfuid.setFont(new Font("Poppins", Font.BOLD, 12));
		tfuid.setBorder(null);
		tfuid.setForeground(Color.BLACK);
		tfuid.setBackground(Color.WHITE);
		tfuid.setEnabled(false);
		tfuid.setBounds(200, 100, 500, 40);
		contentPane.add(tfuid);
		tfuid.setColumns(10);
		
		tfuname = new JTextField();
		tfuname.setFont(new Font("Poppins", Font.BOLD, 12));
		tfuname.setBorder(null);
		tfuname.setForeground(Color.BLACK);
		tfuname.setBackground(Color.WHITE);
		tfuname.setColumns(10);
		tfuname.setBounds(200, 150, 500, 40);
		contentPane.add(tfuname);
		
		tfuphone = new JTextField();
		tfuphone.setFont(new Font("Poppins", Font.BOLD, 12));
		tfuphone.setBorder(null);
		tfuphone.setForeground(Color.BLACK);
		tfuphone.setBackground(Color.WHITE);
		tfuphone.setColumns(10);
		tfuphone.setBounds(200, 200, 500, 40);
		contentPane.add(tfuphone);
		
		tfuaddress = new JTextField();
		tfuaddress.setFont(new Font("Poppins", Font.BOLD, 12));
		tfuaddress.setBorder(null);
		tfuaddress.setForeground(Color.BLACK);
		tfuaddress.setBackground(Color.WHITE);
		tfuaddress.setColumns(10);
		tfuaddress.setBounds(200, 250, 500, 40);
		contentPane.add(tfuaddress);
		
		tfuemail = new JTextField();
		tfuemail.setFont(new Font("Poppins", Font.BOLD, 12));
		tfuemail.setBorder(null);
		tfuemail.setForeground(Color.BLACK);
		tfuemail.setBackground(Color.WHITE);
		tfuemail.setColumns(10);
		tfuemail.setBounds(200, 300, 500, 40);
		contentPane.add(tfuemail);
		
		tfupass = new JTextField();
		tfupass.setFont(new Font("Poppins", Font.BOLD, 12));
		tfupass.setBorder(null);
		tfupass.setForeground(Color.BLACK);
		tfupass.setBackground(Color.WHITE);
		tfupass.setColumns(10);
		tfupass.setBounds(200, 350, 500, 40);
		contentPane.add(tfupass);
		
		JButton updatebtn = new JButton("Update");
		updatebtn.setBackground(Color.PINK);
		updatebtn.setBorder(null);
		updatebtn.setFont(new Font("Poppins", Font.BOLD, 15));
		updatebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String uid,Name,Address,Useremail,Password,ph;
				uid=tfuid.getText();
				Name=tfuname.getText();
				ph=tfuphone.getText();
				Address=tfuaddress.getText();
				Useremail=tfuemail.getText();
				Password=tfupass.getText();
				int length=tfuphone.getText().length();
				if(Name.isEmpty()||Address.isEmpty()||Useremail.isEmpty()||Password.isEmpty()||ph.isEmpty()||length<9) {
					JOptionPane.showMessageDialog(null, "Empty Field");
				}
				else {
				try {
					Connect conn=new Connect();
					String query="Update eventmgmt.users set Name ='"+Name+"',Phone='"+ph+"',Address='"+Address+"',Email='"+Useremail+"',Password='"+Password+"' where UserID='"+uid+"'";
					conn.stm.executeUpdate(query);
					JOptionPane.showMessageDialog(null, "Value changed.");
					dispose();
					Userdash ud=new Userdash(name);
					ud.show();
					
					
				}
				catch(Exception e1){
					e1.printStackTrace();
				}
				}
			}
		});
		updatebtn.setBounds(307, 455, 170, 40);
		contentPane.add(updatebtn);
		
		JButton backbtn = new JButton("Back");
		backbtn.setBackground(Color.PINK);
		backbtn.setBorder(null);
		backbtn.setFont(new Font("Poppins", Font.BOLD, 15));
		backbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Userdash ud=new Userdash(name);
				ud.show();
			}
		});
		backbtn.setBounds(307, 506, 170, 44);
		contentPane.add(backbtn);
		
		try {
			String query= "SELECT UserID,Name,Phone,Address,Email,Password FROM eventmgmt.users where Name='"+name+"'";
			Connect conn= new Connect();
			ResultSet rs=conn.stm.executeQuery(query);
			
			while (rs.next()) {
				tfuid.setText(rs.getString("UserID"));
				tfuname.setText(rs.getString("Name"));
				tfuphone.setText(rs.getString("Phone"));
				tfuaddress.setText(rs.getString("Address"));
				tfuemail.setText(rs.getString("Email"));
				tfupass.setText(rs.getString("Password"));
			}
			
		}
		
		catch(Exception e) {
			e.printStackTrace();
			}
	}
	
	
}
