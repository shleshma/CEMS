package event.management.systen;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import net.proteanit.sql.DbUtils;

import javax.swing.JComboBox;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JScrollPane;
import javax.swing.border.CompoundBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JPasswordField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ManageUser extends JFrame {

	private JPanel contentPane;
	private JTextField tfuid;
	private JTextField tfuname;
	private JTextField tfuaddress;
	private JTable usertable;
	private JTextField tfuphone;
	private JTextField tfuemail;
	private JPasswordField passwordField;
	
	public String ph;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageUser frame = new ManageUser();
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
	public ManageUser() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800,600);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(Color.BLACK);
		panel_1.setLayout(null);
		panel_1.setBackground(Color.BLACK);
		panel_1.setBounds(130, 0, 654, 561);
		contentPane.add(panel_1);
		
		JLabel lblManageUsers = new JLabel("MANAGE USERS");
		lblManageUsers.setHorizontalAlignment(SwingConstants.CENTER);
		lblManageUsers.setForeground(Color.PINK);
		lblManageUsers.setFont(new Font("Poppins", Font.BOLD, 30));
		lblManageUsers.setBackground(Color.PINK);
		lblManageUsers.setBounds(178, 5, 297, 25);
		panel_1.add(lblManageUsers);
		
		JLabel lblUserId_1 = new JLabel("User ID");
		lblUserId_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserId_1.setForeground(Color.PINK);
		lblUserId_1.setFont(new Font("Poppins", Font.BOLD, 20));
		lblUserId_1.setBackground(Color.PINK);
		lblUserId_1.setBounds(10, 41, 104, 25);
		panel_1.add(lblUserId_1);
		
		JLabel lblName = new JLabel("Name");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setForeground(Color.PINK);
		lblName.setFont(new Font("Poppins", Font.BOLD, 20));
		lblName.setBackground(Color.PINK);
		lblName.setBounds(10, 77, 104, 25);
		panel_1.add(lblName);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddress.setForeground(Color.PINK);
		lblAddress.setFont(new Font("Poppins", Font.BOLD, 20));
		lblAddress.setBackground(Color.PINK);
		lblAddress.setBounds(10, 113, 104, 25);
		panel_1.add(lblAddress);
		
		JLabel lblDate = new JLabel("Phone");
		lblDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblDate.setForeground(Color.PINK);
		lblDate.setFont(new Font("Poppins", Font.BOLD, 20));
		lblDate.setBackground(Color.PINK);
		lblDate.setBounds(313, 41, 102, 25);
		panel_1.add(lblDate);
		
		JLabel lblGenre = new JLabel("Email");
		lblGenre.setHorizontalAlignment(SwingConstants.CENTER);
		lblGenre.setForeground(Color.PINK);
		lblGenre.setFont(new Font("Poppins", Font.BOLD, 20));
		lblGenre.setBackground(Color.PINK);
		lblGenre.setBounds(313, 77, 102, 25);
		panel_1.add(lblGenre);
		
		tfuid = new JTextField();
		tfuid.setFont(new Font("Poppins", Font.BOLD, 12));
		tfuid.setEnabled(false);
		tfuid.setColumns(10);
		tfuid.setBorder(null);
		tfuid.setBounds(112, 41, 191, 25);
		panel_1.add(tfuid);
		
		tfuname = new JTextField();
		tfuname.setFont(new Font("Poppins", Font.BOLD, 12));
		tfuname.setColumns(10);
		tfuname.setBorder(null);
		tfuname.setBounds(112, 77, 191, 25);
		panel_1.add(tfuname);
		
		tfuaddress = new JTextField();
		tfuaddress.setFont(new Font("Poppins", Font.BOLD, 12));
		tfuaddress.setColumns(10);
		tfuaddress.setBorder(null);
		tfuaddress.setBounds(112, 113, 191, 25);
		panel_1.add(tfuaddress);
		
		tfuphone = new JTextField();
		tfuphone.setFont(new Font("Poppins", Font.BOLD, 12));
		tfuphone.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent evt) {
				String Phone=tfuphone.getText();
				int length=Phone.length();
				char c=evt.getKeyChar();
				
				if(evt.getKeyChar()>='0' && evt.getKeyChar()<='9' ||evt.getExtendedKeyCode()==KeyEvent.VK_DELETE||evt.getExtendedKeyCode()==KeyEvent.VK_BACK_SPACE) 
				{
					if(length<=10)
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
		tfuphone.setColumns(10);
		tfuphone.setBorder(null);
		tfuphone.setBounds(425, 41, 219, 25);
		panel_1.add(tfuphone);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 198, 634, 352);
		panel_1.add(scrollPane);
		
		
		usertable = new JTable();
		usertable.setFont(new Font("Poppins", Font.PLAIN, 14));
		usertable.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel model= (DefaultTableModel)usertable.getModel();
				int MyIndex =usertable.getSelectedRow();
				tfuid.setText(model.getValueAt(MyIndex, 0).toString());
				tfuname.setText(model.getValueAt(MyIndex, 1).toString());
				tfuphone.setText(model.getValueAt(MyIndex, 2).toString());
				tfuaddress.setText(model.getValueAt(MyIndex, 3).toString());
				tfuemail.setText(model.getValueAt(MyIndex, 4).toString());

			}
		});
		String [] column= {"User ID", "Username", "Phone No.", "Address","Email"};
		SelectUser();
		scrollPane.setViewportView(usertable);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String uid= tfuid.getText();
				String Name=tfuname.getText();
				String Address=tfuaddress.getText();
				String Useremail=tfuemail.getText();
				String Phone= tfuphone.getText();
				
				if(tfuid.getText().isEmpty()||tfuname.getText().isEmpty()||tfuaddress.getText().isEmpty()||tfuphone.getText().isEmpty()||tfuemail.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Enter data to the field.");
				}
				else {
					try {
						Connect conn=new Connect();
						String query="Update eventmgmt.users set Name ='"+Name+"',Phone='"+Phone+"',Address='"+Address+"',Email='"+Useremail+"' where UserID='"+uid+"'";
						conn.stm.executeUpdate(query);
						SelectUser();
						JOptionPane.showMessageDialog(null, "Value changed.");
						
					}
					catch(Exception e1){
						e1.printStackTrace();
					}
				}
				
			}
		});
		btnEdit.setForeground(Color.BLACK);
		btnEdit.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnEdit.setBorder(null);
		btnEdit.setBackground(Color.PINK);
		btnEdit.setBounds(344, 155, 69, 23);
		panel_1.add(btnEdit);
		
		JButton btnDelete = new JButton("Delete");
		
		btnDelete.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(tfuid.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Enter data to the field.");
				}
				else {
					try {
						String uid=tfuid.getText();
						Connect conn=new Connect();
						String query="Delete from eventmgmt.users where UserID ="+uid;
						conn.stm.executeUpdate(query);
						SelectUser();
						JOptionPane.showMessageDialog(null, "Value deleted.");
						
					}
					catch(Exception e1){
						e1.printStackTrace();
					}
				}
			}
		});
		btnDelete.setForeground(Color.BLACK);
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnDelete.setBorder(null);
		btnDelete.setBackground(Color.PINK);
		btnDelete.setBounds(427, 155, 97, 23);
		panel_1.add(btnDelete);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setForeground(Color.BLACK);
		btnClear.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				tfuid.setText("");
				tfuname.setText("");
				tfuaddress.setText("");
				tfuphone.setText("");
				tfuemail.setText("");
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnClear.setBorder(null);
		btnClear.setBackground(Color.PINK);
		btnClear.setBounds(534, 155, 82, 23);
		panel_1.add(btnClear);
		

		
		tfuemail = new JTextField();
		tfuemail.setFont(new Font("Poppins", Font.BOLD, 12));
		tfuemail.setColumns(10);
		tfuemail.setBorder(null);
		tfuemail.setBounds(425, 77, 219, 25);
		panel_1.add(tfuemail);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.PINK);
		panel.setBounds(0, 0, 131, 561);
		contentPane.add(panel);
		
		JButton btnUsers = new JButton("USERS");
		btnUsers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ManageUser MU=new ManageUser();
				MU.show();
			}
		});
		btnUsers.setFont(new Font("Poppins", Font.BOLD, 25));
		btnUsers.setBorder(null);
		btnUsers.setBackground(Color.PINK);
		btnUsers.setBounds(15, 11, 100, 23);
		panel.add(btnUsers);
		
		JButton btnEvents = new JButton("EVENTS");
		btnEvents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ManageEvents ME= new ManageEvents();
				ME.show();
			}
		});
		btnEvents.setFont(new Font("Poppins", Font.BOLD, 25));
		btnEvents.setBorder(null);
		btnEvents.setBackground(Color.PINK);
		btnEvents.setBounds(15, 68, 101, 23);
		panel.add(btnEvents);
		
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
	}

	public void SelectUser() {
		try {
			String query= "SELECT UserID,Name,Phone,Address,Email FROM eventmgmt.users";
			Connect conn= new Connect();
			ResultSet rs=conn.stm.executeQuery(query);
			usertable.setModel(DbUtils.resultSetToTableModel(rs));
		}
		
		catch(Exception e) {
			e.printStackTrace();
			}
		
	}
	public TableModel getUsertableModel() {
		return usertable.getModel();
	}
	public void setUsertableModel(TableModel model) {
		usertable.setModel(model);
	}
}
