package event.management.systen;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;

public class Login extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField tf_username;
	
	String username;
	String password;
	private JPasswordField pfpassword;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setTitle("LOGIN");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400,300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOGIN");
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setForeground(Color.PINK);
		lblNewLabel.setFont(new Font("Poppins", Font.BOLD, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(104, 11, 176, 35);
		contentPane.add(lblNewLabel);
		
		JLabel lbl_username = new JLabel("Username");
		lbl_username.setBackground(Color.BLACK);
		lbl_username.setForeground(Color.PINK);
		lbl_username.setFont(new Font("Poppins", Font.BOLD, 20));
		lbl_username.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_username.setBounds(10, 79, 121, 24);
		contentPane.add(lbl_username);
		
		JLabel lbl_password = new JLabel("Password");
		lbl_password.setBackground(Color.BLACK);
		lbl_password.setForeground(Color.PINK);
		lbl_password.setFont(new Font("Poppins", Font.BOLD, 20));
		lbl_password.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_password.setBounds(10, 129, 121, 24);
		contentPane.add(lbl_password);
		
		tf_username = new JTextField();
		tf_username.setFont(new Font("Poppins", Font.BOLD, 12));
		tf_username.setBorder(null);
		tf_username.setBounds(141, 76, 233, 35);
		contentPane.add(tf_username);
		tf_username.setColumns(10);
		
		JButton btn_login = new JButton("Login");
		btn_login.setForeground(Color.BLACK);
		btn_login.setBorder(null);
		btn_login.addActionListener(this);
		btn_login.setBackground(Color.PINK);
		btn_login.setFont(new Font("Poppins", Font.BOLD, 20));
		btn_login.setBounds(147, 214, 89, 36);
		contentPane.add(btn_login);
		
		pfpassword = new JPasswordField();
		pfpassword.setEchoChar('*');
		pfpassword.setFont(new Font("Poppins", Font.BOLD, 12));
		pfpassword.setBounds(141, 129, 233, 35);
		contentPane.add(pfpassword);
		
		final JCheckBox showpass = new JCheckBox("Show Password");
		showpass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (showpass.isSelected())
				{
					pfpassword.setEchoChar((char)0);
				}
				else 
				{
					pfpassword.setEchoChar('*');
				}
			}
		});
		showpass.setForeground(Color.PINK);
		showpass.setFont(new Font("Poppins", Font.BOLD, 15));
		showpass.setBorder(null);
		showpass.setBackground(Color.BLACK);
		showpass.setBounds(229, 180, 145, 23);
		contentPane.add(showpass);
	}
		
		public void actionPerformed(ActionEvent e) {
		
			username = tf_username.getText();
			password = pfpassword.getText();
			
			
			try {
				 Connect conn= new Connect();
				 String query = "select * from admin where name = '"+username+"' and password = '"+password+"'";
				 ResultSet rs = conn.stm.executeQuery(query);
				 
				  if (rs.next()) {
					    
		                dispose();	
		                ManageEvents m=new ManageEvents();
		                m.show();
		                
		                
		            } 
				  else {
		              JOptionPane.showMessageDialog(null, "Invalid Username or Password");
		            }
			}
			catch(Exception e1){
				e1.printStackTrace();
			}
		}
	
}
