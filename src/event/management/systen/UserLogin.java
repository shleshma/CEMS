package event.management.systen;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;
import javax.swing.border.CompoundBorder;
import javax.swing.JCheckBox;

public class UserLogin extends JFrame {

	private JPanel contentPane;
	private JTextField tfusername;
	private JPasswordField pfpass;
	
	String Username;
	String Password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserLogin frame = new UserLogin();
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
	public UserLogin() {
		setType(Type.UTILITY);
		setResizable(false);
		setTitle("LOGIN");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800,600);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.BLACK);
		panel.setBackground(Color.PINK);
		panel.setBounds(0, 0, 312, 561);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblWelcome = new JLabel("WELCOME");
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setForeground(Color.BLACK);
		lblWelcome.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblWelcome.setBackground(Color.PINK);
		lblWelcome.setBounds(71, 198, 170, 45);
		panel.add(lblWelcome);
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(Color.BLACK);
		panel_1.setBackground(Color.BLACK);
		panel_1.setBounds(312, 0, 472, 561);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lbllogin = new JLabel("LOGIN");
		lbllogin.setFont(new Font("Poppins", Font.BOLD, 30));
		lbllogin.setHorizontalAlignment(SwingConstants.CENTER);
		lbllogin.setForeground(Color.PINK);
		lbllogin.setBackground(new Color(0, 0, 0));
		lbllogin.setBounds(167, 28, 138, 79);
		panel_1.add(lbllogin);
		
		JLabel lblusername = new JLabel("Username");
		lblusername.setForeground(Color.PINK);
		lblusername.setBackground(new Color(0, 0, 0));
		lblusername.setFont(new Font("Poppins", Font.BOLD, 20));
		lblusername.setBounds(38, 157, 121, 32);
		panel_1.add(lblusername);
		
		JLabel lblpassword = new JLabel("Password");
		lblpassword.setForeground(Color.PINK);
		lblpassword.setFont(new Font("Poppins", Font.BOLD, 20));
		lblpassword.setBackground(new Color(0, 0, 0));
		lblpassword.setBounds(38, 229, 121, 32);
		panel_1.add(lblpassword);
		
		tfusername = new JTextField();
		tfusername.setFont(new Font("Poppins", Font.BOLD, 12));
		tfusername.setBorder(null);
		tfusername.setBackground(Color.WHITE);
		tfusername.setBounds(163, 157, 279, 34);
		panel_1.add(tfusername);
		tfusername.setColumns(10);
		
		pfpass = new JPasswordField();
		pfpass.setEchoChar('*');
		pfpass.setFont(new Font("Poppins", Font.BOLD, 12));
		pfpass.setBorder(null);
		pfpass.setBounds(163, 229, 279, 34);
		panel_1.add(pfpass);
		
		JButton btnlogin = new JButton("Login");
		btnlogin.addActionListener(new ActionListener() {
			private String user;

			public void actionPerformed(ActionEvent e) {
				Username= tfusername.getText();
				Password= pfpass.getText();
				try {
					 Connect conn= new Connect();
					 String query = "select * from users where name = '"+Username+"' and password = '"+Password+"'";
					 ResultSet rs = conn.stm.executeQuery(query);
					 
					  if (rs.next()) {
						    
			                dispose();	
			                Userdash dash=new Userdash(Username);
			                dash.show();
			                
			                
			            } 
					  else {
			              JOptionPane.showMessageDialog(null, "Invalid Username or Password");
			            }
					  
					 
				}
				catch(Exception e1){
					e1.printStackTrace();
				}
			}

			

			
		});
		btnlogin.setBorder(null);
		btnlogin.setForeground(Color.BLACK);
		btnlogin.setFont(new Font("Poppins", Font.BOLD, 15));
		btnlogin.setBackground(Color.PINK);
		btnlogin.setBounds(191, 369, 89, 23);
		panel_1.add(btnlogin);
		
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				Add_users aduser=new Add_users();
				aduser.show();
				
			}
		});
		btnSignUp.setForeground(Color.BLACK);
		btnSignUp.setFont(new Font("Poppins", Font.BOLD, 15));
		btnSignUp.setBorder(null);
		btnSignUp.setBackground(Color.PINK);
		btnSignUp.setBounds(191, 419, 89, 23);
		panel_1.add(btnSignUp);
		
		final JCheckBox showpass = new JCheckBox("Show Password");
		showpass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (showpass.isSelected())
				{
					pfpass.setEchoChar((char)0);
				}
				else 
				{
					pfpass.setEchoChar('*');
				}
			}
		});
		showpass.setForeground(Color.PINK);
		showpass.setFont(new Font("Poppins", Font.BOLD, 15));
		showpass.setBorder(null);
		showpass.setBackground(Color.BLACK);
		showpass.setBounds(297, 285, 145, 23);
		panel_1.add(showpass);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Splash sh=new Splash();
				sh.show();
				dispose();
			}
		});
		btnBack.setForeground(Color.BLACK);
		btnBack.setFont(new Font("Poppins", Font.BOLD, 15));
		btnBack.setBorder(null);
		btnBack.setBackground(Color.PINK);
		btnBack.setBounds(191, 467, 89, 23);
		panel_1.add(btnBack);
	}
}
