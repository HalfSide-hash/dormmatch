/**
 * 
 * @author Parth Patel, Slvester Delvillar 
 * VIDEO OF THE PROJECT EXPLANATION - https://www.youtube.com/watch?v=s4pVm8cTVQM
 * This class checks the legitimacy of the user's login information.
 */

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.border.EmptyBorder;

import com.sun.glass.ui.Application;

import java.sql.*;
import java.util.Map;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.TextAttribute;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.MouseMotionAdapter;

public class LoginFramee extends JFrame {

	private JFrame LoginFrame;
	
	Student stu = new Student();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFramee window = new LoginFramee();
					window.LoginFrame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection connection = null;
	private JTextField textFieldUN; //field for the username
	private JPasswordField passwordField; //field for the password
	/**
	 * Create the application.
	 */
	public LoginFramee() {
		initialize();
		connection = sqliteConnection.dbConnector();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initialize() { 
		
		/*
		 * Frame details, mostly for decorations.
		 * Pictures are included inside labels, as icons. 
		 * There are also clickable links, that will take you to wesites.
		 * Labels that could be clickable will change cursor when mouse is mmoved over them.
		 * And Decelration of textfields, and buttons are also included. 
		 */
		
		
		LoginFrame = new JFrame();
		LoginFrame.getContentPane().setBackground(SystemColor.inactiveCaptionBorder);
		LoginFrame.setResizable(false);
		LoginFrame.setTitle("Login");
		LoginFrame.setBounds(100, 100, 1086, 604);
		LoginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		LoginFrame.getContentPane().setLayout(null);
		LoginFrame.setVisible(true);
		
		JLabel idLabel = new JLabel("MSU NetID");
		idLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		idLabel.setForeground(new Color(204, 0, 51));
		idLabel.setBackground(Color.WHITE);
		idLabel.setBounds(589, 213, 121, 23);
		LoginFrame.getContentPane().add(idLabel);
		
		textFieldUN = new JTextField();
		textFieldUN.setForeground(Color.BLACK);
		textFieldUN.setBounds(589, 236, 223, 23);
		LoginFrame.getContentPane().add(textFieldUN);
		textFieldUN.setColumns(10);
		
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		passwordLabel.setForeground(new Color(204, 0, 51));
		passwordLabel.setBackground(Color.BLACK);
		passwordLabel.setBounds(589, 271, 83, 14);
		LoginFrame.getContentPane().add(passwordLabel);
		
		passwordField = new JPasswordField();
		passwordField.setForeground(Color.BLACK);
		passwordField.setBounds(589, 290, 223, 23);
		LoginFrame.getContentPane().add(passwordField);
		JLabel invalidLabel = new JLabel("Invalid Input, Please Try Again");
		invalidLabel.setForeground(new Color(153, 0, 51));
		invalidLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		invalidLabel.setBounds(589, 127, 281, 29);
		LoginFrame.getContentPane().add(invalidLabel);
		invalidLabel.setVisible(false);
		
		
		JLabel warningLabel = new JLabel("");
		warningLabel.setIcon(new ImageIcon(LoginFramee.class.getResource("/javax/swing/plaf/metal/icons/ocean/warning.png")));
		warningLabel.setBounds(552, 124, 38, 39);
		warningLabel.setVisible(false);
		LoginFrame.getContentPane().add(warningLabel);
		
		/*
		 * Query for checking if the username and the password are found in the database.
		 * And to see if the usename and password match. (264-End)
		 */
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBackground(new Color(30, 144, 255));
		btnLogin.setForeground(Color.WHITE);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

					//Query inside a try catch statement, throws exception if values are not found
				try{
					String query = "select * from StudentData where username=? and password=?"; //looks for the two values in the database.
					PreparedStatement pst = connection.prepareStatement(query); //prepare statement adds the query
					pst.setString(1, textFieldUN.getText() ); //gets the values of username and password from the two textfields. 7
					pst.setString(2, passwordField.getText() ); //password field is unseeable 
					
					ResultSet rs = pst.executeQuery(); //result statement 
					int count = 0;
					while (rs.next()) { //checks next values from the database 
						
						String username = rs.getString("username"); 
						Student.userName = username; //gets the user input from the txtfield and stores it in userName
						count = count+1;
					}
					if(count == 1){ //if the count ==1 meaning the values entered are equall, user is taken to frame 2 
						JOptionPane.showMessageDialog(null, "Username and password is correct");
						System.out.println("User input is valid: Welcome");
						LoginFrame.dispose();
						HouseVerification frm2 = new HouseVerification();
						frm2.setVisible(true);
						
						//have it so that it checks to the database in a option pane, if they paid their deposit, no 
						//need for a new frame. 	
					}
					else if(count>1){ //if the values match while in the database there are multiple same values, throws duplication  
						JOptionPane.showMessageDialog(null, "Invalid, Username and password are Duplicated! Please speak with the university.");
						repaint();
					}
					else{  //if the values don't match in the database then, user is asked to re-enter values 
						//JOptionPane.showMessageDialog(null, "Invalid, Please renter Username and password");
						invalidLabel.setVisible(true);
						warningLabel.setVisible(true);
						
					}	
					rs.close(); //close the database 
					pst.close();

				}catch(Exception e ){ //if the database is not found, they throw this exception
					JOptionPane.showMessageDialog(null, e);
					
				}
			}
		});
		btnLogin.setBounds(741, 364, 89, 23);
		LoginFrame.getContentPane().add(btnLogin);
		
		
		
		JLabel lblFP = new JLabel("Forgot Password?");
		lblFP.setBackground(new Color(30, 144, 255));
		lblFP.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblFP.setForeground(new Color(153, 0, 51));
		
		lblFP.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) { //Underline and changed curson when mouse is moved 
				lblFP.setCursor(new Cursor(Cursor.HAND_CURSOR));	
				Font font = lblFP.getFont();
				Map attributes = font.getAttributes();
				attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
				lblFP.setFont(font.deriveFont(attributes));
			}
		});
		lblFP.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) { //Clickable link
				lblFP.setCursor(new Cursor(Cursor.HAND_CURSOR));
				try{
					String msu1 = "https://netid.montclair.edu/netid/";
					Desktop.getDesktop().browse(java.net.URI.create(msu1)); 
				}catch(Exception e1){
					JOptionPane.showMessageDialog(null, "Link not found");
				}
			}
		});
		lblFP.setBounds(677, 324, 150, 29);
		LoginFrame.getContentPane().add(lblFP);
		
		JLabel PictureLogin = new JLabel("New label");
		PictureLogin.setIcon(new ImageIcon("images\\Login.jpeg"));
		PictureLogin.setBounds(193, 148, 677, 263);
		LoginFrame.getContentPane().add(PictureLogin);
		
		
		JLabel msuhomeLabel = new JLabel("MSU Home");
		msuhomeLabel.setForeground(new Color(153, 0, 51));
		msuhomeLabel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				
				msuhomeLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));	
			}
		});
		msuhomeLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) { //Clickable link
					try{
					String msu1 = "http://www.montclair.edu/";
					Desktop.getDesktop().browse(java.net.URI.create(msu1)); 
					
				}catch(Exception e1){
					JOptionPane.showMessageDialog(null, "Link not found");	
				}
			}
		});
		msuhomeLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		msuhomeLabel.setBounds(687, 397, 83, 29);
		LoginFrame.getContentPane().add(msuhomeLabel);
		
		JLabel differLabel = new JLabel("|");
		differLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));
		differLabel.setBounds(769, 398, 17, 22);
		LoginFrame.getContentPane().add(differLabel);
		
		
		
		JLabel oitLabel = new JLabel("OIT Home");
		oitLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		oitLabel.setForeground(new Color(153, 0, 51));
		oitLabel.setBounds(780, 404, 89, 14);
		LoginFrame.getContentPane().add(oitLabel);
		
		oitLabel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				
				oitLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));	
			}
		});
		oitLabel.addMouseListener(new MouseAdapter() { //Clickable link
			@Override
			public void mouseClicked(MouseEvent arg0) {
					try{
					String msu1 = "http://www.montclair.edu/oit/";
					Desktop.getDesktop().browse(java.net.URI.create(msu1)); 	
				}catch(Exception e1){
					JOptionPane.showMessageDialog(null, "Link not found");	
				}
			}
		});	
		
		JLabel seconddifferLabel = new JLabel("|");
		seconddifferLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));
		seconddifferLabel.setBounds(677, 395, 17, 28);
		LoginFrame.getContentPane().add(seconddifferLabel);
		
		
		
		JLabel residenceLabel = new JLabel("Residence Life");	
		residenceLabel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				residenceLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));	
			}
		});
		residenceLabel.addMouseListener(new MouseAdapter() { //Clickable link
			@Override
			public void mouseClicked(MouseEvent e) {
				try{
					String msu1 = "http://www.montclair.edu/residence-life/";
					Desktop.getDesktop().browse(java.net.URI.create(msu1)); 
					
				}catch(Exception e1){
					JOptionPane.showMessageDialog(null, "Link not found");
				}
			}
		});
		residenceLabel.setForeground(new Color(153, 0, 51));
		residenceLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		residenceLabel.setBounds(561, 400, 116, 22);
		LoginFrame.getContentPane().add(residenceLabel);
		
		
		
		
	
	}
}

