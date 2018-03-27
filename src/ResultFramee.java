/*
 /*
 /*
 /*
 * This frame will finally allow the user to see thier perfect roommate match. 
 * It will provide the user, with their roommates name, studentyear, and their email. 
 */
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import java.awt.SystemColor;

import java.util.ArrayList;

public class ResultFramee extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ResultFramee frame = new ResultFramee();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    Connection connection = null;
    private String username;
    private String personalityType;
    private String campus;
    private String Email;
    private JLabel bestrmmatchLabel;
    private JLabel buttoninfoLabel;
    private JLabel infocontLabel;
    private JLabel roommateresultLabel;
    private JLabel studentyrdispLabel;
    private JLabel studentyrLabel;
    private JLabel logodispLabel;
    private ArrayList<String> firstNames = new ArrayList<>();
    private ArrayList<String> lastNames = new ArrayList<>();
    private ArrayList<String> emails = new ArrayList<>();
    private ArrayList<String> studentyrs = new ArrayList<>();
    private int theCount = 0;
    /**
     * Create the frame.
     */
    public ResultFramee() {
    	
    	
    	/*
    	* Frame components, and decoration values
    	* Decleration of button, and labels.
    	* Also holds a picture. 
    	* (From 69-175)
    	*/
        
        connection = sqliteConnection.dbConnector();//connection to db

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 757, 452);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(153, 204, 204));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel firstnameLabel = new JLabel("");
        firstnameLabel.setForeground(new Color(0, 153, 102));
        firstnameLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        firstnameLabel.setBounds(251, 169, 117, 20);
        contentPane.add(firstnameLabel);
        firstnameLabel.setVisible(true);
        
        JLabel lastnameLabel = new JLabel("");
        lastnameLabel.setForeground(new Color(0, 153, 102));
        lastnameLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        lastnameLabel.setBounds(311, 169, 174, 20);
        contentPane.add(lastnameLabel);
        lastnameLabel.setVisible(true);
        
        roommateresultLabel = new JLabel("Your Roommate Match: ");
        roommateresultLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
        roommateresultLabel.setBounds(45, 166, 206, 23);
        contentPane.add(roommateresultLabel);
        roommateresultLabel.setVisible(false);
        
        studentyrLabel = new JLabel("");
        studentyrLabel.setForeground(new Color(0, 153, 102));
        studentyrLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        studentyrLabel.setBounds(251, 192, 480, 20);
        contentPane.add(studentyrLabel);
        studentyrLabel.setVisible(true);
        
        studentyrdispLabel = new JLabel("Student Year:");
        studentyrdispLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
        studentyrdispLabel.setBounds(128, 192, 123, 20);
        contentPane.add(studentyrdispLabel);
        studentyrdispLabel.setVisible(false);
        
        logodispLabel = new JLabel("");
        Image Endpic = new ImageIcon(this.getClass().getResource("Allhere.png")).getImage();
        logodispLabel.setIcon(new ImageIcon(Endpic));
        logodispLabel.setBounds(239, 268, 270, 134);
        contentPane.add(logodispLabel);
        
        JLabel emaildispLabel = new JLabel("Email:");
        emaildispLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
        emaildispLabel.setBounds(193, 217, 62, 14);
        contentPane.add(emaildispLabel);
        emaildispLabel.setVisible(false);
        
        JLabel emailLabel = new JLabel("");
        emailLabel.setForeground(new Color(51, 153, 102));
        emailLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        emailLabel.setBounds(251, 217, 302, 20);
        contentPane.add(emailLabel);
        
        bestrmmatchLabel = new JLabel("Best Roommate Matches");
        bestrmmatchLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
        bestrmmatchLabel.setBounds(239, 30, 314, 33);
        contentPane.add(bestrmmatchLabel);
        
        buttoninfoLabel = new JLabel("Click on the button, to find your perfect roommate matches, who shares similar ");
        buttoninfoLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        buttoninfoLabel.setBounds(45, 73, 651, 20);
        contentPane.add(buttoninfoLabel);
        
        infocontLabel = new JLabel("preferences, and plan to live on the same dorm as you.");
        infocontLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        infocontLabel.setBounds(144, 94, 470, 20);
        contentPane.add(infocontLabel);
        
        JButton btnLogout = new JButton("Logout"); //Logout button 
        btnLogout.setIcon(new ImageIcon(ResultFramee.class.getResource("/javax/swing/plaf/metal/icons/ocean/close-pressed.gif")));
        btnLogout.setText(String.valueOf(Student.userName).toString()); //set the label as the username, which was entered in frame 1

        btnLogout.addActionListener(new ActionListener() { //action performance
        	public void actionPerformed(ActionEvent arg0) {
        		//If entered yes, close the frame, and open frame 1. 
        		int reply = JOptionPane.showConfirmDialog(null, "Are you sure you want to logout, your Information will not be saved.", "Exiting??", JOptionPane.YES_NO_OPTION);
		       if (reply == JOptionPane.YES_OPTION) {
					dispose();
					LoginFramee frm1 = new LoginFramee();
					frm1.setVisible(true);
					frm1.dispose();
		       } //else - do nothing
		       else {
		       }
        	}
        });
        btnLogout.setBounds(624, 11, 107, 23);
        contentPane.add(btnLogout);
        
        
        JButton btnExit = new JButton("Exit"); //Button to execute the program. 
        btnExit.setVisible(false);

        btnExit.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		System.exit(0); //Executes program
        	}
        });
        btnExit.setBounds(642, 368, 89, 23);
        contentPane.add(btnExit);
     
        
        /*
         * Query gets multiple values from the username that the user input in frame1. 
         * Gets their name, personality type, Campus they choose.
         * Those values then get compared to a secound query which will match the values to other users in the database. 
         * If another user in the database also has the same values as to the users, then output that user's name, lastname, student year, and email.
         * From(187-END) 
         */
        roommateresultLabel.setVisible(true);
        emaildispLabel.setVisible(true);
        studentyrdispLabel.setVisible(true);
        
        JButton resultsButton = new JButton("Results!");
        resultsButton.setFont(new Font("Tahoma", Font.BOLD, 13));
        resultsButton.setForeground(new Color(0, 153, 102));
        resultsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                
                try {
                    //gest the selected values out from database, where user equals the username they provided in frame 1. 
                    String sql = "select \"Name\",\"Personality\",\"Campus\", \"Email\" from \"StudentData\" where Username='"+Student.userName+"';" ;
                    
                    PreparedStatement pst = connection.prepareStatement(sql); //prepare statement
                    
                    ResultSet rs = pst.executeQuery(); //result statement 

                    while(rs.next()){ //checks next values in the database
                        
                    	//assign the chosen values from the database to variable.
                    	personalityType = rs.getString(2);  
                        campus = rs.getString(3);
                        Email = rs.getString(4);
                        
                    }                    
                    rs.close(); //Close the database. 
                    pst.close();
                
                } catch (Exception e1) {
                } 
    
                //Second query, will compare the personality and campus from query 1, to the database. 
                try{
                String sql1 = "SELECT \"Name\",\"LastName\",\"StuYear\", \"Name\",\"EID\",\"Email\"   FROM \"StudentData\" Where Personality= '"+personalityType+"' and Campus='"+campus+"';";

                    PreparedStatement pst1 = connection .prepareStatement(sql1); //prepare statement
                                        
                    ResultSet rs1 = pst1.executeQuery();//result statement  
                    
                    //gets the EID from database
                    String x = rs1.getString(5);
                    Integer intValue = Integer.parseInt(x); 
                   
                    	 
                    	while(rs1.next()){ //get choosen values out from the database, where campus and personality are the same as the users. 
                        	if ((Email.equals(rs1.getString(6))))
                        		rs1.next(); //skips user input
                        	
                        		if (rs1.isAfterLast())
                        			break; //if the user was the last on this new list it end this query before adding it to the array list
                        	
                        	
                        	//opted to go with an arraylist to store all the variables instead
                            //firstnameLabel.setText(rs1.getString(1)); //gets name
                        	firstNames.add(rs1.getString(1)); 
                            //lastnameLabel.setText(rs1.getString(2)); //gets last name
                        	lastNames.add(rs1.getString(2));
                            //emailLabel.setText(rs1.getString(6)); //gets email
                        	emails.add(rs1.getString(6));
                            //studentyrLabel.setText(rs1.getString(3));//gets student year 
                        	studentyrs.add(rs1.getString(3));
                            //JOptionPane.showMessageDialog(btnExit, rs1.getString(1), "Potential Roommates! Keep clicking OK", 1,null);
                            
                    } //starts with the first value of everything
                    	firstnameLabel.setText(firstNames.get(0)); 
                    	lastnameLabel.setText(lastNames.get(0));
                    	studentyrLabel.setText(studentyrs.get(0));
                    	emailLabel.setText(emails.get(0));
                  
                }catch(Exception e){
                }
            if (firstnameLabel.getText().equals(""))
            	studentyrLabel.setText("No matches at this time!! You must be a special snowflake!");
                //Set these labels and button visible when user presses the button. 
            firstnameLabel.setVisible(true);
            lastnameLabel.setVisible(true);
            studentyrLabel.setVisible(true);
            btnExit.setVisible(true);
            

            }
        });
        resultsButton.setBounds(288, 125, 174, 23);
        contentPane.add(resultsButton);
        
        JButton nextButton = new JButton("Next");
        nextButton.setFont(new Font("Tahoma", Font.BOLD, 13));
        nextButton.setForeground(new Color(0, 153, 102));
        
        nextButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	//checks if the arraylists are empty or if it's the last element, if not gets it going
            	if (theCount != (firstNames.size() - 1) && firstNames.isEmpty() == false){
            	theCount++;
                firstnameLabel.setText(firstNames.get(theCount));
                lastnameLabel.setText(lastNames.get(theCount));
                studentyrLabel.setText(studentyrs.get(theCount));
                emailLabel.setText(emails.get(theCount));
                
            	}

            }
        });
        nextButton.setBounds(453, 240, 68, 14);
        contentPane.add(nextButton);
        JButton prevButton = new JButton("Prev");
        prevButton.setFont(new Font("Tahoma", Font.BOLD, 12));
        prevButton.setForeground(new Color(0, 153, 102));
        prevButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	//the back option of the previous code, since the count starts at 0 no need to check if the list is empty
            	if (theCount != 0){
            		theCount--;
                    firstnameLabel.setText(firstNames.get(theCount));
                    lastnameLabel.setText(lastNames.get(theCount));
                    studentyrLabel.setText(studentyrs.get(theCount));
                    emailLabel.setText(emails.get(theCount));
                	}
                
            

            }
        });
        prevButton.setBounds(253, 240, 68, 14);
        contentPane.add(prevButton);
        
    }
}