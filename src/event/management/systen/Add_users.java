package event.management.systen;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Add_users extends JFrame {

	private JPanel contentPane;
	private JTextField txtuemail;
	private JTextField txtuaddress;
	private JTextField txtuphone;
	private JTextField txtuname;
	private JPasswordField tfpass;

	  
	public String ph;

    
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_users frame = new Add_users();
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
	public Add_users() {
		setTitle("ADD USERS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800,600);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnback = new JButton("Back");
		btnback.setForeground(Color.BLACK);
		btnback.setBackground(Color.PINK);
		btnback.setBorder(null);
		btnback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				//calls user login page if back button is clicked
				UserLogin ul= new UserLogin();
				ul.show();
			}
		});
		btnback.setFont(new Font("Poppins", Font.BOLD, 15));
		btnback.setBounds(329, 506, 125, 25);
		contentPane.add(btnback);
		
		tfpass = new JPasswordField();
		tfpass.setFont(new Font("Poppins", Font.BOLD, 12));
		tfpass.setBorder(null);
		tfpass.setForeground(Color.BLACK);
		tfpass.setBackground(Color.WHITE);
		tfpass.setEchoChar('*');
		tfpass.setBounds(185, 370, 507, 37);
		contentPane.add(tfpass);
		
		
		
		txtuemail = new JTextField();
		txtuemail.setFont(new Font("Poppins", Font.BOLD, 12));
		txtuemail.setBorder(null);
		txtuemail.setColumns(10);
		txtuemail.setBounds(185, 295, 507, 37);
		contentPane.add(txtuemail);
		
		JLabel lblNewLabel_5 = new JLabel("Email");
		lblNewLabel_5.setBackground(Color.BLACK);
		lblNewLabel_5.setForeground(Color.PINK);
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Poppins", Font.BOLD, 20));
		lblNewLabel_5.setBounds(33, 306, 142, 14);
		contentPane.add(lblNewLabel_5);
		
		txtuaddress = new JTextField();
		txtuaddress.setFont(new Font("Poppins", Font.BOLD, 12));
		txtuaddress.setBorder(null);
		txtuaddress.setColumns(10);
		txtuaddress.setBounds(185, 223, 507, 37);
		contentPane.add(txtuaddress);
		
		JLabel lblNewLabel_4 = new JLabel("Address");
		lblNewLabel_4.setBackground(Color.BLACK);
		lblNewLabel_4.setForeground(Color.PINK);
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Poppins", Font.BOLD, 20));
		lblNewLabel_4.setBounds(33, 235, 142, 14);
		contentPane.add(lblNewLabel_4);
		
		txtuphone = new JTextField();
		txtuphone.setFont(new Font("Poppins", Font.BOLD, 12));
		txtuphone.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent evt) {
				//here Phone accepts data from text field txtuphone
				String Phone=txtuphone.getText();
				//counts the length of Phone number
				int length=Phone.length();
				char c=evt.getKeyChar();
				//if delete or backspace or integer value from 0 to 9 is inserted value is accepted if not the value is rejected 
				if(evt.getExtendedKeyCode()==KeyEvent.VK_DELETE||evt.getExtendedKeyCode()==KeyEvent.VK_BACK_SPACE||evt.getKeyChar()>='0' && evt.getKeyChar()<='9' ) 
				{
					//if the number length is more than 10 then error pop up is shown 
					if(length<10)
					{
					ph=Phone;
					}
					else
						JOptionPane.showMessageDialog(null,"Enter 10 digits only");
				}
				else
					
					JOptionPane.showMessageDialog(null, "Enter number from 0-9");
				
			}
		});
		txtuphone.setBorder(null);
		txtuphone.setColumns(10);
		txtuphone.setBounds(185, 153, 507, 37);
		contentPane.add(txtuphone);
		
		JButton btnadduser = new JButton("Add");
		btnadduser.setForeground(Color.BLACK);
		btnadduser.setBackground(Color.PINK);
		btnadduser.setBorder(null);
		btnadduser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent elu) {
				
				
				
				if(txtuname.getText().isEmpty()||txtuphone.getText().isEmpty()||txtuaddress.getText().isEmpty()||txtuemail.getText().isEmpty()||tfpass.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null,"Missing Field");
				}
				else {
					          
		            
		            try {
		            	 String Name = txtuname.getText();
		            	 String Address = txtuaddress.getText();
		            	 String Email = txtuemail.getText();
		            	 String Password=tfpass.getText();
		            	 String Phone= txtuphone.getText();
		                //insert data into database
		                Connect conn = new Connect();
		                String query = "insert into users(Name, Phone, Address, Email, Password) values('"+Name+"', '"+Phone+"', '"+Address+"', '"+Email+"','"+Password+"') ;";
		                conn.stm.executeUpdate(query);
		                JOptionPane.showMessageDialog(null, "Details added successfully");
		                setVisible(false);
		                UserLogin UL=new UserLogin();
		                UL.show();
		            } catch (Exception e) {
		                e.printStackTrace();
		            }
				}
			}
		});
		btnadduser.setFont(new Font("Poppins", Font.BOLD, 15));
		btnadduser.setBounds(329, 453, 125, 25);
		contentPane.add(btnadduser);
		
		JLabel lblNewLabel_3 = new JLabel("Mobile No.");
		lblNewLabel_3.setBackground(Color.BLACK);
		lblNewLabel_3.setForeground(Color.PINK);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Poppins", Font.BOLD, 20));
		lblNewLabel_3.setBounds(33, 164, 142, 14);
		contentPane.add(lblNewLabel_3);
		
		txtuname = new JTextField();
		txtuname.setFont(new Font("Poppins", Font.BOLD, 12));
		txtuname.setBorder(null);
		txtuname.setColumns(10);
		txtuname.setBounds(185, 82, 507, 37);
		contentPane.add(txtuname);
		
		JLabel lblNewLabel_2 = new JLabel("Name");
		lblNewLabel_2.setBackground(Color.BLACK);
		lblNewLabel_2.setForeground(Color.PINK);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Poppins", Font.BOLD, 20));
		lblNewLabel_2.setBounds(33, 93, 142, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("ADD USERS");
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setForeground(Color.PINK);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Poppins", Font.BOLD, 30));
		lblNewLabel.setBounds(244, 11, 295, 47);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_5_1 = new JLabel("Password");
		lblNewLabel_5_1.setBackground(Color.BLACK);
		lblNewLabel_5_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5_1.setForeground(Color.PINK);
		lblNewLabel_5_1.setFont(new Font("Poppins", Font.BOLD, 20));
		lblNewLabel_5_1.setBounds(33, 379, 142, 14);
		contentPane.add(lblNewLabel_5_1);
		
		final JCheckBox showpass = new JCheckBox("Show Password");
		showpass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//if tick mark is ticked then password is shown else is hidden 
				if (showpass.isSelected())
				{
					tfpass.setEchoChar((char)0);
				}
				else 
				{
					tfpass.setEchoChar('*');
				}
			}
		});
		showpass.setBorder(null);
		showpass.setForeground(Color.PINK);
		showpass.setBackground(Color.BLACK);
		showpass.setFont(new Font("Poppins", Font.BOLD, 15));
		showpass.setBounds(547, 426, 145, 23);
		contentPane.add(showpass);
		
		
	}
}
