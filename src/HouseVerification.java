/*
 * This frame will check wheather the user has paid their housing deposit money.
 * If they have not paid their housing deposit, they can no longer continue to the application. 
 * If they have paid their housing deposit, the query will check to the database, and allow the user to pe
 * 
 */
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.border.EmptyBorder;
import javax.swing.text.html.HTMLEditorKit;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.TextField;

import javax.swing.border.EmptyBorder;
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
import java.awt.event.MouseMotionAdapter;
import java.awt.SystemColor;

public class HouseVerification extends JFrame {

	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HouseVerification frame = new HouseVerification();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection connection = null;
	private JTextField TextCWID;
	private JTextField textField;
	/**
	 * Create the frame.
	 */
	private HTMLEditorKit kit;
	private JTextField HiddenTxt;
	
	public HouseVerification() {
		
		/*
		 * Frame details, mostly for decorations. 
		 * Includes pictures. 
		 * Clickable links.
		 * Changes curser when mouse is dragged over clickable buttons. 
		 * Decleration of buttons, and labels. (From 70-300)
		 */
		
		kit = new HTMLEditorKit();
		connection = sqliteConnection.dbConnector();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1086, 604);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel housingHeadLabel = new JLabel("Housing Deposit Verification");
		housingHeadLabel.setForeground(Color.WHITE);
		housingHeadLabel.setFont(new Font("Tahoma", Font.BOLD, 23));
		Font font = housingHeadLabel.getFont();
		Map attributes = font.getAttributes();
		attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		housingHeadLabel.setFont(font.deriveFont(attributes));
		housingHeadLabel.setBounds(583, 43, 338, 44);
		contentPane.add(housingHeadLabel);
		
		JButton exitButton = new JButton("Exit"); //Logout button - allows user to leave 
		exitButton.setIcon(new ImageIcon(HouseVerification.class.getResource("/javax/swing/plaf/metal/icons/ocean/close.gif")));
		exitButton.setText(String.valueOf(Student.userName).toString());

		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				 int reply = JOptionPane.showConfirmDialog(null, "Are you sure you want to logout, your Information will not be saved.", "Exiting??", JOptionPane.YES_NO_OPTION);
			        if (reply == JOptionPane.YES_OPTION) { //if yes is selected, go back to frame 1
						dispose();
						LoginFramee frm1 = new LoginFramee();
						frm1.setVisible(true);
						frm1.dispose();
			        }
			        else { //else, do nothing
			        }
			}
		});
		exitButton.setBounds(954, 11, 106, 28);
		contentPane.add(exitButton);
		
		TextCWID = new JTextField();
		TextCWID.setForeground(Color.BLACK);
		TextCWID.setBounds(820, 172, 240, 28);
		contentPane.add(TextCWID);
		TextCWID.setColumns(10);
		
		JLabel lblCwid = new JLabel("CWID: ");
		lblCwid.setForeground(Color.BLACK);
		lblCwid.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCwid.setBounds(820, 155, 62, 14);
		contentPane.add(lblCwid);
		
		JLabel didnotpayLabel = new JLabel("If you have not paid your Housing Deposit, Please visit:");
		didnotpayLabel.setForeground(Color.BLACK);
		didnotpayLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		didnotpayLabel.setBounds(607, 418, 388, 23);
		contentPane.add(didnotpayLabel);
		didnotpayLabel.setVisible(false);
		
		JLabel paydemandLabel = new JLabel("And, pay your housing deposit to continue");
		paydemandLabel.setForeground(Color.BLACK);
		paydemandLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		paydemandLabel.setBounds(607, 444, 320, 23);
		contentPane.add(paydemandLabel);
		paydemandLabel.setVisible(false);
		
		JComboBox classCombo = new JComboBox();
		classCombo.setModel(new DefaultComboBoxModel(new String[] {"Freshman", "Sophmore", "Junior", "Senior"}));
		classCombo.setToolTipText("");
		classCombo.setBounds(967, 266, 93, 20);
		contentPane.add(classCombo);
		
		
		JLabel nestLabel = new JLabel("Nest\r\n"); //Clickable label, changes cursor when mouse hovered. 
		nestLabel.setBackground(new Color(0, 153, 51));
		nestLabel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				nestLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));	
		
			}
		});
		nestLabel.setForeground(new Color(153, 0, 51));
		nestLabel.setVisible(false);
		nestLabel.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent arg0) { //clikable link
			
					try{
					String msu1 = "http://www.montclair.edu/admissions/commit/";
					Desktop.getDesktop().browse(java.net.URI.create(msu1)); 
				}catch(Exception e1){
					JOptionPane.showMessageDialog(null, "Link not found");	
				}
			}
		});
		nestLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 21));
		nestLabel.setBounds(991, 419, 69, 19);
		contentPane.add(nestLabel);
		
		HiddenTxt = new JTextField();
		HiddenTxt.setVisible(false);
		HiddenTxt.setBounds(1035, 43, 25, 20);
		contentPane.add(HiddenTxt);
		HiddenTxt.setColumns(10);
		HiddenTxt.setText(String.valueOf(Student.userName).toString()); 
		
		JLabel birthLabel = new JLabel("Birthdate: \r\n");
		birthLabel.setForeground(Color.BLACK);
		birthLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		birthLabel.setBounds(820, 204, 83, 23);
		contentPane.add(birthLabel);
		
		textField = new JTextField();
		textField.setForeground(Color.BLACK);
		textField.setBackground(Color.WHITE);
		textField.setBounds(820, 224, 240, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel cwidInfoLabel = new JLabel("What is this?\r\n"); //clickable label, changes curson when mouse hovered. 
		cwidInfoLabel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				cwidInfoLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));	
			}
		});
		cwidInfoLabel.addMouseListener(new MouseAdapter() { //takes you to a messagePane
			@Override
			public void mouseClicked(MouseEvent e) {
				
				JOptionPane.showMessageDialog(null, "Campus Wide Identification Number! 8 Digit number, provided by MSU. ");
			}
		});
		cwidInfoLabel.setForeground(Color.WHITE);
		cwidInfoLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		cwidInfoLabel.setBounds(872, 157, 76, 14);
		contentPane.add(cwidInfoLabel);
		
		JLabel birthdayformatLabel = new JLabel("Ex. MM/DD/YYYY");
		birthdayformatLabel.setForeground(Color.WHITE);
		birthdayformatLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		birthdayformatLabel.setBounds(896, 211, 106, 14);
		contentPane.add(birthdayformatLabel);
		
		JLabel lblBefore = new JLabel("Before continuing the application to choose your preferences, please provide us ");
		lblBefore.setForeground(Color.BLACK);
		lblBefore.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblBefore.setBounds(494, 98, 566, 23);
		contentPane.add(lblBefore);
		
		JLabel verifyLabel = new JLabel("with the following information below, and verify that you have paid your Housing Deposit.");
		verifyLabel.setForeground(Color.BLACK);
		verifyLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		verifyLabel.setBounds(450, 121, 620, 23);
		contentPane.add(verifyLabel);
		
		JLabel imgLabel = new JLabel("");
		Image imgLogo = new ImageIcon(this.getClass().getResource("logo.jpeg")).getImage();
		imgLabel.setIcon(new ImageIcon(imgLogo));
		imgLabel.setBounds(747, 466, 313, 99);
		contentPane.add(imgLabel);
		
		JLabel residenceLifeLabel = new JLabel("Residence Life\r\n");
		residenceLifeLabel.setForeground(Color.WHITE);
		residenceLifeLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 19));
		residenceLifeLabel.setBounds(32, 89, 152, 37);
		contentPane.add(residenceLifeLabel);
		
		JButton russhallButton = new JButton("New button"); //Clickable link, and changes curson when mouse is hovered.
		russhallButton.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				russhallButton.setCursor(new Cursor(Cursor.HAND_CURSOR));	
			}
		});
		russhallButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //takes you to the link 
				try{
					String msu1 = "http://www.montclair.edu/residence-life/";
					Desktop.getDesktop().browse(java.net.URI.create(msu1)); 
					
				}catch(Exception e1){
					JOptionPane.showMessageDialog(null, "Link not found");
				}
			}
		});
		Image imgHall = new ImageIcon(this.getClass().getResource("RussHall.jpeg")).getImage();
		russhallButton.setIcon(new ImageIcon(imgHall));
		russhallButton.setBounds(32, 137, 302, 149);
		contentPane.add(russhallButton);
		
		JLabel questionLabel = new JLabel("Got a Question? ");
		questionLabel.setForeground(Color.WHITE);
		questionLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 19));
		questionLabel.setBounds(32, 360, 160, 28);
		contentPane.add(questionLabel);
		
		JButton questionButton = new JButton("New button");
		questionButton.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				questionButton.setCursor(new Cursor(Cursor.HAND_CURSOR));	

			}
		});
		questionButton.addActionListener(new ActionListener() { //Clickable link, takes you to link
			public void actionPerformed(ActionEvent arg0) {
				try{
					String msu1 = "http://www.montclair.edu/residence-life/housing-assignments/housing-helper/";
					Desktop.getDesktop().browse(java.net.URI.create(msu1)); 
					
				}catch(Exception e1){
					JOptionPane.showMessageDialog(null, "Link not found");
				}
			}
		});
		questionButton.setIcon(new ImageIcon("images\\RockyAgain.gif"));
		questionButton.setBounds(32, 399, 292, 116);
		
		contentPane.add(questionButton);
		
		JLabel lblCurrentStatus = new JLabel("Current Status:");
		lblCurrentStatus.setForeground(Color.BLACK);
		lblCurrentStatus.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCurrentStatus.setBounds(840, 267, 127, 14);
		contentPane.add(lblCurrentStatus);
		
		
		/*
		 * Query to check if the user's input of CWID and Birthday is valid to the database. 
		 * Also gets the username from the txtfield, from LoginFrame, and compares it with the CWID and Birthday. 
		 * This makes sure that the user must provide their own CWID and birthday or an error will be thrown .
		 * (From 310-End)
		 * Another query writes to the database, whatever the user selects as their student year. 
		 */ 
		
		JButton continueButton = new JButton("Continue");
		continueButton.setBackground(new Color(30,144,225));
		continueButton.setForeground(new Color(0, 0, 0));
		continueButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					
					String yrCombo = classCombo.getSelectedItem().toString();  //gets selection from comboBox
					String query1 = "Update StudentData set StuYear = '"+yrCombo+"' where cwid=? and username=? "; 
					//writes to the database whatever the user selects in the comboBox.
					
					PreparedStatement pst1 = connection .prepareStatement(query1); //prepare statement
					 
					pst1.setString(1, yrCombo);
					pst1.setString(1, TextCWID.getText());
					pst1.setString(2, HiddenTxt.getText());
				//Three values must be correct in order to write to the database, the username, CWID, and birthdate.
					pst1.execute(); //executes the database 
					ResultSet rs1 = pst1.executeQuery(); //result statement 
					
					rs1.close();//closes the database 
					pst1.close();
					
				}catch(Exception e){ //exception if errors 
					
				}
				
				DormChoosing frm3 = new DormChoosing();
				
				/*
				 * This query checks three values to the HDeposit in the database.
				 * If the HDeposit in the database holds a 1, then user has paid their housing deposit 
				 * If the HDeposit in the database holds a 0, them user has not paid their housing deposit. 
				 */
				
				try{
					String query = "select * from StudentData where cwid=? and username=? and BirthDate=? and HDeposit ";
					//Query compares three values and checks the HDeposit.
					PreparedStatement pst = connection .prepareStatement(query);//prepare statement takes the query
				
					//Gets the three values from txt field inputs 
					pst.setString(1, TextCWID.getText());
					pst.setString(2, HiddenTxt.getText());
					pst.setString(3, textField.getText());


					ResultSet rs = pst.executeQuery(); //result statement 
					int count = 0;
					while (rs.next()) { //checks values in the database 
						
						String cwid = rs.getString("cwid");
						Student.StuCWID = cwid;
						
						count = count+1; //increse count in values are same. 
					}
					
					if(count  == 1){ //if count is 1, then the values must be match in the database, therefore allows the user to continue. 
						
						JOptionPane.showMessageDialog(null, "Verification Complete, you have paid your Housing Deposit.");
						//disposes the frame, and opens the DormChoosing frame. 
						dispose();
						frm3.setVisible(true);
						
					}
					else if(count > 1){ //if count is above one, then the three values are duplicated. 
						JOptionPane.showMessageDialog(null, "Invalid, please speak with the university");
					}
					else{ //if nothing happens to count, then the three values must not match in the database, there for user is not allowed to continue. 
						JOptionPane.showMessageDialog(null, "Please re-enter your information and try again, our records show that you have not paid your Housing Deposit.  ");
						
						//These lables are shown, which will guide the user on how to pay the housing deposit. 
						nestLabel.setVisible(true);
						didnotpayLabel.setVisible(true);
						paydemandLabel.setVisible(true);
						
					}
					
					rs.close();//closes the database 
					pst.close();
				}catch(Exception e1){ //throws exception is db is not found 
					JOptionPane.showMessageDialog(null,e1);
				}
			}
		});
		continueButton.setBounds(935, 367, 125, 23);
		contentPane.add(continueButton);
		
	}
}
