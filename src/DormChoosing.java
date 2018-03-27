/*
 * This frame serves as a dorm choosing frame. 
 * The user will click on one of the pictures they believe is their favorite dorm to live in.
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.TextField;

import javax.swing.JToggleButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

public class DormChoosing extends JFrame {

	private JPanel contentPane;
	
	 private JTextField TextCWID;
	   // private JTextField passField;
	
	 HouseVerification frm2 = new HouseVerification();
	 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DormChoosing frame = new DormChoosing();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection connection = null;
	
	private String housePicked;
	private String username = Student.userName;
	
	/**
	 * Create the frame.
	 * @param string 
	 * 
	 */
	public DormChoosing() {
		
		/*
		 * Frame components/Details, mostly for decorations. 
		 * Includes ample pictures, set as button icons. When any button is clicked, saves the value from 1-9, and adds it to the database. 
		 * Includes lable, that can be clickable and will take you to a website. 
		 * From(76-380)
		 */
		
		
		connection = sqliteConnection.dbConnector();
		
		HouseVerification frm = new HouseVerification();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1086, 604);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	
		JToggleButton heightsButton = new JToggleButton("The Heights");
		heightsButton.addMouseMotionListener(new MouseMotionAdapter() { 
			@Override
			public void mouseMoved(MouseEvent arg0) {
				heightsButton.setCursor(new Cursor(Cursor.HAND_CURSOR));//change cursor
			}
		});
		heightsButton.setForeground(new Color(0, 255, 255));
		heightsButton.setBackground(new Color(0, 0, 0));
		
		Image Blantonhall = new ImageIcon(this.getClass().getResource("The Heights.jpeg")).getImage();
		heightsButton.setIcon(new ImageIcon(Blantonhall));
		
		heightsButton.addActionListener(new ActionListener() { //when button is clicked add 1 to database 
			public void actionPerformed(ActionEvent arg0) {
				
				housePicked = "1";
			}
		});
		heightsButton.setBounds(28, 104, 229, 126);
		contentPane.add(heightsButton);		
		JToggleButton bohnButton = new JToggleButton("Bohn Hall\r\n");
		bohnButton.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				bohnButton.setCursor(new Cursor(Cursor.HAND_CURSOR));//change cursor
			}
		});
		
		Image BohnHall = new ImageIcon(this.getClass().getResource("Bohn Hall.jpeg")).getImage();
		bohnButton.setIcon(new ImageIcon(BohnHall));
		bohnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //when button is clicked add 2 to database 
				housePicked = "2";
			}
		});
		bohnButton.setBounds(290, 104, 229, 126);
		contentPane.add(bohnButton);
		
		JLabel CollegeChoose = new JLabel("Choosing Your Dorm");
		CollegeChoose.setForeground(new Color(0, 51, 102));
		CollegeChoose.setFont(new Font("Wide Latin", Font.BOLD, 20));
		CollegeChoose.setBounds(352, 11, 417, 57);
		contentPane.add(CollegeChoose);
		
		JToggleButton blantonButton = new JToggleButton("Blanton Hall");
		blantonButton.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				blantonButton.setCursor(new Cursor(Cursor.HAND_CURSOR));//change cursor
			}
		});
		
		Image BlantonHall = new ImageIcon(this.getClass().getResource("Blanton Hall.jpeg")).getImage();
		blantonButton.setIcon(new ImageIcon(BlantonHall));
		blantonButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {//when button is clicked add 3 to database 
				housePicked = "3";
			}
		});
		blantonButton.setBounds(553, 104, 229, 126);
		contentPane.add(blantonButton);
		
		JToggleButton freemanButton = new JToggleButton("Freeman Hall");
		freemanButton.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				freemanButton.setCursor(new Cursor(Cursor.HAND_CURSOR));//change cursor

			}
		});
		
		Image FreemanHall = new ImageIcon(this.getClass().getResource("Freeman Hall.jpeg")).getImage();
		freemanButton.setIcon(new ImageIcon(FreemanHall));		
		freemanButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//when button is clicked add 4 to database 
				housePicked = "4";
			}
		});
		freemanButton.setBounds(811, 104, 238, 126);
		contentPane.add(freemanButton);
		
		JToggleButton russButton = new JToggleButton("Russ Hall");
		russButton.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				russButton.setCursor(new Cursor(Cursor.HAND_CURSOR));//change cursor

			}
		});
		
		Image RussHall = new ImageIcon(this.getClass().getResource("RussHall.jpeg")).getImage();
		russButton.setIcon(new ImageIcon(RussHall));
		
		russButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//when button is clicked add 5 to database 
				housePicked = "5";
			}
		});
		russButton.setBounds(31, 303, 226, 126);
		contentPane.add(russButton);
		
		JToggleButton hawkButton = new JToggleButton("Hawk Crossing ");
		hawkButton.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				hawkButton.setCursor(new Cursor(Cursor.HAND_CURSOR));//change cursor
			}
		});
		Image HawkCrossing = new ImageIcon(this.getClass().getResource("HawkCrossings.jpeg")).getImage();
		hawkButton.setIcon(new ImageIcon(HawkCrossing));


		hawkButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //when button is clicked add 6 to database 
				housePicked = "6";
			}
		});
		hawkButton.setBounds(293, 303, 226, 126);
		contentPane.add(hawkButton);
		
		JToggleButton villageButton = new JToggleButton("Village Apartments ");
		villageButton.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				villageButton.setCursor(new Cursor(Cursor.HAND_CURSOR));//change cursor

			}
		});
		
		Image VillageApartment = new ImageIcon(this.getClass().getResource("Village Apartment.gif")).getImage();
		villageButton.setIcon(new ImageIcon(VillageApartment));
		
		villageButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //when button is clicked add 7 to database 
				housePicked = "7";
			}
			
		});
		villageButton.setBounds(553, 303, 229, 126);
		contentPane.add(villageButton);
		
		JToggleButton frankButton = new JToggleButton("Frank Sinatra Hall");
		frankButton.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				frankButton.setCursor(new Cursor(Cursor.HAND_CURSOR));//change cursor

			}
		});
		
		Image FrankSinatra = new ImageIcon(this.getClass().getResource("SinatraHall.jpeg")).getImage();
		frankButton.setIcon(new ImageIcon(FrankSinatra));
		
		frankButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //when button is clicked add 8 to database 
				housePicked = "8";

			}
		});
		frankButton.setBounds(811, 303, 238, 126);
		contentPane.add(frankButton);
		
		JToggleButton stoneButton = new JToggleButton("Stone Hall");
		stoneButton.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				stoneButton.setCursor(new Cursor(Cursor.HAND_CURSOR));//change cursor

			}
		});
		stoneButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) { //when button is clicked add 9 to database 
				housePicked = "9";
			}
		});
		
		Image StoneHall = new ImageIcon(this.getClass().getResource("Stone Hall.jpeg")).getImage();
		stoneButton.setIcon(new ImageIcon(StoneHall));
		stoneButton.setBounds(405, 474, 251, 80);
		contentPane.add(stoneButton);
		
		JLabel heightsLabel = new JLabel("The Heights");
		heightsLabel.setForeground(new Color(0, 51, 102));
		heightsLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		heightsLabel.setBounds(87, 79, 81, 20);
		contentPane.add(heightsLabel);
		
		JLabel bohnLabel = new JLabel("Bohn Hall");
		bohnLabel.setForeground(new Color(0, 51, 102));
		bohnLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		bohnLabel.setBounds(372, 79, 69, 20);
		contentPane.add(bohnLabel);
		
		JLabel blantonHall = new JLabel("Blanton Hall");
		blantonHall.setForeground(new Color(0, 51, 102));
		blantonHall.setFont(new Font("Tahoma", Font.BOLD, 13));
		blantonHall.setBounds(621, 79, 81, 14);
		contentPane.add(blantonHall);
		
		JLabel freemanLabel = new JLabel("Freeman Hall");
		freemanLabel.setForeground(new Color(0, 51, 102));
		freemanLabel.setBackground(SystemColor.desktop);
		freemanLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		freemanLabel.setBounds(889, 79, 89, 14);
		contentPane.add(freemanLabel);
		
		JLabel russLabel = new JLabel("Russ Hall\r\n");
		russLabel.setForeground(new Color(0, 51, 102));
		russLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		russLabel.setBounds(99, 278, 69, 14);
		contentPane.add(russLabel);
		
		JLabel hawkLabel = new JLabel("Hawk Crossing ");
		hawkLabel.setForeground(new Color(0, 51, 102));
		hawkLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		hawkLabel.setBounds(352, 278, 98, 14);
		contentPane.add(hawkLabel);
		
		JLabel villageLabel = new JLabel("Village Apartments");
		villageLabel.setForeground(new Color(0, 51, 102));
		villageLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		villageLabel.setBounds(605, 278, 124, 20);
		contentPane.add(villageLabel);
		
		JLabel frankHall = new JLabel("Frank Sinatra Hall");
		frankHall.setForeground(new Color(0, 51, 102));
		frankHall.setFont(new Font("Tahoma", Font.BOLD, 13));
		frankHall.setBounds(868, 278, 131, 14);
		contentPane.add(frankHall);
		
		JLabel stoneHall = new JLabel("Stone Hall\r\n");
		stoneHall.setForeground(new Color(0, 51, 102));
		stoneHall.setFont(new Font("Tahoma", Font.BOLD, 13));
		stoneHall.setBounds(499, 455, 69, 14);
		contentPane.add(stoneHall);
		
		JLabel infoLabel = new JLabel("Click on the following pictures to choose your dorm. \r\n");
		infoLabel.setForeground(Color.BLACK);
		infoLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		infoLabel.setBounds(10, 468, 346, 20);
		contentPane.add(infoLabel);
		
		JLabel helpLabel = new JLabel("For more information, Please Visit- ");
		helpLabel.setForeground(Color.BLACK);
		helpLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		helpLabel.setBounds(10, 491, 229, 14);
		contentPane.add(helpLabel);
		
		JLabel dorminfoLabel = new JLabel("Dorm Information\r\n"); //Clickable label, takes you to more information on MSU dorms. 
		dorminfoLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try{
					String msu1 = "https://www.montclair.edu/residence-life/about-us/residence-halls/";
					Desktop.getDesktop().browse(java.net.URI.create(msu1)); 
				}catch(Exception e1){
					JOptionPane.showMessageDialog(null, "Link not found");	
				}
			}
		});
		dorminfoLabel.addMouseMotionListener(new MouseMotionAdapter() { //changed cursor 
			@Override
			public void mouseMoved(MouseEvent arg0) {
				dorminfoLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));	
			}
		});
		dorminfoLabel.setForeground(new Color(0, 51, 102));
		dorminfoLabel.setBackground(new Color(0, 51, 102));
		dorminfoLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		dorminfoLabel.setBounds(237, 491, 115, 14);
		contentPane.add(dorminfoLabel);
		
		JButton logoutButton = new JButton("New button"); //Logout button, gives you an optionpane message, if clicked yes, takes you to frame 1. No will do nothing. 
		logoutButton.setIcon(new ImageIcon(DormChoosing.class.getResource("/javax/swing/plaf/metal/icons/ocean/close.gif")));
		logoutButton.setText(String.valueOf(Student.userName).toString());
		logoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 int reply = JOptionPane.showConfirmDialog(null, "Are you sure you want to logout, your Information will not be saved.", "Exiting??", JOptionPane.YES_NO_OPTION);
			        if (reply == JOptionPane.YES_OPTION) {
						dispose();
						LoginFramee frm1 = new LoginFramee();
						frm1.setVisible(true);
						frm1.dispose();
			        }
			        else {
			        }
			}
		});
		
		logoutButton.setBounds(934, 11, 115, 25);
		contentPane.add(logoutButton);
		
		
		/*
		 * Query will write to the database. 
		 * Whatever the user selects as their dorm, the value of that button will be written to the database. 
		 * From(388-End)
		 */
		
		JButton btnNext = new JButton("Continue"); 
		btnNext.setForeground(new Color(0, 0, 128));
		btnNext.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNext.setBackground(new Color(143, 188, 143));
		btnNext.addActionListener(new ActionListener() { //action performance, when button is clicked
			public void actionPerformed(ActionEvent e) {
				
				//First check if the user has selected a dorm, if not alert them!! Only continue if there is a dorm selected.
				if(housePicked == null || housePicked.trim().isEmpty() || username == null || username.trim().isEmpty() ){
					JOptionPane.showMessageDialog(null, "Please choose a Dorm to continue, or logout and try again");
				}else{
					
				try {
					String campus =  housePicked;					
					String sql = "Update StudentData set Campus = '"+campus+"' where username=?";  //Query writes to the database 
					
					PreparedStatement pst = connection .prepareStatement(sql);//prepared statement
					pst.setString(1, campus); //set campus to the database
	                pst.setString(1, String.valueOf(Student.userName).toString());
					pst.execute();//execute database

					ResultSet rs = pst.executeQuery(); //result statement 
					
					
					rs.close(); //close the database
					pst.close();
				} catch (Exception e1) {
					//JOptionPane.showMessageDialog(null, e1);
				} 
				
				dispose(); //if dorm is choose, close the frame, and open Question Frame.
				QuestionFramee frm4 = new QuestionFramee();
				frm4.setVisible(true);
				}
			}
		});
		btnNext.setBounds(845, 491, 175, 44);
		contentPane.add(btnNext);
	}
}
