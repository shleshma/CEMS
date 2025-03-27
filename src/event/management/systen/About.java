package event.management.systen;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.DropMode;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import java.awt.Font;
import java.awt.Point;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;
import java.awt.Insets;
import javax.swing.UIManager;

public class About extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					About frame = new About();
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
	public About() {
		setResizable(false);
		setTitle("About Us");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800,600);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("v1.1");
		lblNewLabel.setBounds(272, 531, 240, 14);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(null);
		scrollPane.setToolTipText("");
		scrollPane.setAutoscrolls(true);
		scrollPane.setBounds(10, 11, 764, 509);
		contentPane.add(scrollPane);
		
		JTextArea txtrAtCollegeEvent = new JTextArea();
		txtrAtCollegeEvent.setSelectionColor(Color.PINK);
		txtrAtCollegeEvent.setMargin(new Insets(10, 15, 10, 10));
		txtrAtCollegeEvent.setLineWrap(true);
		txtrAtCollegeEvent.setBackground(Color.WHITE);
		txtrAtCollegeEvent.setForeground(Color.BLACK);
		txtrAtCollegeEvent.setEnabled(false);
		txtrAtCollegeEvent.setBorder(null);
		txtrAtCollegeEvent.setSelectionStart(1);
		txtrAtCollegeEvent.setTabSize(20);
		scrollPane.setViewportView(txtrAtCollegeEvent);
		txtrAtCollegeEvent.setFont(new Font("Poppins", Font.BOLD, 13));
		txtrAtCollegeEvent.setWrapStyleWord(true);
		txtrAtCollegeEvent.setText("At College Event Management System, our primary goal is to manage and organize events efficiently. With this management system, colleges can create event schedules and check the attendees. It allows for the creation of customized event pages with details such as date, location, and additional information about the event. We have developed an application that empowers event organizers, participants, and administrators, ensuring a seamless and efficient event experience for all.\r\n\r\nOur Mission:\r\nWe are driven by a mission to revolutionize event management. We aim to provide a comprehensive platform that enables colleges to plan, promote, and execute events effortlessly while fostering a sense of engagement and connection among students and staff.\r\n\r\nFeatures: \r\n  1. Create an intuitive, accessible registration platform for admins.\r\n  2. Develop a convenient registration portal for attendees.\r\n  3. Develop a layout to view and search events.\r\n\r\nOur Team:\r\nWe student of LACM developed this app with a primary focus on providing a secure platform for event organizers to handle participants' personal information. Our aim is to empower organizers with the ability to generate reports and analytics that provide valuable insights into the success of their events.\r\n\r\nThe event registration system we have created is designed to be user-friendly and easily accessible, encouraging a higher number of sign-ups for events. Our software provides a seamless and efficient registration process that benefits both organizers and attendees, ensuring a straightforward and hassle-free experience for all involved.");
		
		JButton btnback = new JButton("Back");
		btnback.setForeground(Color.WHITE);
		btnback.setFont(new Font("Poppins", Font.BOLD, 15));
		btnback.setBorderPainted(false);
		btnback.setBackground(Color.DARK_GRAY);
		btnback.setBorder(null);
		btnback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Splash spl=new Splash();
				spl.show();
			}
		});
		btnback.setBounds(569, 527, 89, 23);
		contentPane.add(btnback);
	
		
		
	}
}
