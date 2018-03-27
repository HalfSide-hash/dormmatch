/*
 /*
 * This frame serves as the question frame, where the user will choose thier best choices. 
 * With their choices the program will compare them to their type of roommate. 
 */


import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class QuestionFramee extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    Random generator = new Random();
    JPanel container = new JPanel();
   
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    QuestionFramee frame = new QuestionFramee();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    Connection connection = null;
    private JTextField textField_1;

    /**
     * Create the frame.
     */
    public QuestionFramee() {
    	
    	/*
    	 * Frame components/details. 
    	 * Include decleration of radiobuttons.
    	 * Adds three radiobuttons to a radiobutton Group. 
    	 */
        
        connection = sqliteConnection.dbConnector();//sqlite connector
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 958, 637);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(51, 153, 153));
        setResizable(false);
        
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel question1Lbl = new JLabel("1) What do you look forward to about dorming?");
        question1Lbl.setForeground(Color.BLACK);
        question1Lbl.setFont(new Font("Tahoma", Font.BOLD, 15));
        question1Lbl.setBounds(10, 83, 372, 20);
        contentPane.add(question1Lbl);
        
        
        JLabel lblPersonalityQuestions = new JLabel("Personality Questions!!");
        lblPersonalityQuestions.setForeground(Color.BLACK);
        lblPersonalityQuestions.setFont(new Font("Tahoma", Font.BOLD, 22));
        lblPersonalityQuestions.setBounds(328, 0, 257, 57);
        contentPane.add(lblPersonalityQuestions);
        
        JLabel lblPleaseBeCompletely = new JLabel("Please be completely honest when awnsering questions!!");
        lblPleaseBeCompletely.setForeground(Color.WHITE);
        lblPleaseBeCompletely.setBackground(Color.WHITE);
        lblPleaseBeCompletely.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
        lblPleaseBeCompletely.setBounds(10, 58, 411, 14);
        contentPane.add(lblPleaseBeCompletely);
        
        JLabel question3Lbl = new JLabel("3) Would you like to really get to be friends with your roommate? ");
        question3Lbl.setForeground(Color.BLACK);
        question3Lbl.setFont(new Font("Tahoma", Font.BOLD, 14));
        question3Lbl.setBounds(10, 274, 502, 20);
        contentPane.add(question3Lbl);
        
        JLabel question9Lbl = new JLabel("9) Are you pickey about the way things are kept in the room? ");
        question9Lbl.setForeground(Color.BLACK);
        question9Lbl.setFont(new Font("Tahoma", Font.BOLD, 14));
        question9Lbl.setBounds(489, 379, 445, 20);
        contentPane.add(question9Lbl);
        
        JLabel question10Lbl = new JLabel("10) Do you plan to be frequently in the dorm? ");
        question10Lbl.setForeground(Color.BLACK);
        question10Lbl.setFont(new Font("Tahoma", Font.BOLD, 14));
        question10Lbl.setBounds(489, 477, 330, 19);
        contentPane.add(question10Lbl);
        
        JRadioButton rdbtnoption_0 = new JRadioButton("Getting to meet people!");
        rdbtnoption_0.setForeground(new Color(0, 0, 102));
        rdbtnoption_0.setBackground(new Color(51, 153, 153));
        rdbtnoption_0.setFont(new Font("Tahoma", Font.BOLD, 12));
        rdbtnoption_0.setBounds(10, 104, 213, 23);
        contentPane.add(rdbtnoption_0);
                   
        JRadioButton rdbtnoption_2 = new JRadioButton("That I don't have to commute");
        rdbtnoption_2.setForeground(new Color(0, 0, 102));
        rdbtnoption_2.setBackground(new Color(51, 153, 153));
        rdbtnoption_2.setFont(new Font("Tahoma", Font.BOLD, 12));
        rdbtnoption_2.setBounds(10, 147, 225, 23);
        contentPane.add(rdbtnoption_2);
        
        JRadioButton rdbtnoption_1 = new JRadioButton("Just a nice enviornment to get work done");
        rdbtnoption_1.setForeground(new Color(0, 0, 102));
        rdbtnoption_1.setBackground(new Color(51, 153, 153));
        rdbtnoption_1.setFont(new Font("Tahoma", Font.BOLD, 12));
        rdbtnoption_1.setBounds(10, 130, 300, 14);
        contentPane.add(rdbtnoption_1);
        
        JRadioButton rdbtnoption_3 = new JRadioButton("Of course! I love getting to know people");
        rdbtnoption_3.setForeground(new Color(0, 102, 0));
        rdbtnoption_3.setBackground(new Color(51, 153, 153));
        rdbtnoption_3.setFont(new Font("Tahoma", Font.BOLD, 12));
        rdbtnoption_3.setBounds(10, 198, 300, 23);
        contentPane.add(rdbtnoption_3);
        
        JRadioButton rdbtnoption_4 = new JRadioButton("It's fine to get to know some people");
        rdbtnoption_4.setForeground(new Color(0, 102, 0));
        rdbtnoption_4.setBackground(new Color(51, 153, 153));
        rdbtnoption_4.setFont(new Font("Tahoma", Font.BOLD, 12));
        rdbtnoption_4.setBounds(10, 218, 330, 23);
        contentPane.add(rdbtnoption_4);
        
        JRadioButton rdbtnoption_5 = new JRadioButton("I perfer to keep to myself");
        rdbtnoption_5.setForeground(new Color(0, 102, 0));
        rdbtnoption_5.setBackground(new Color(51, 153, 153));
        rdbtnoption_5.setFont(new Font("Tahoma", Font.BOLD, 12));
        rdbtnoption_5.setBounds(10, 240, 189, 23);
        contentPane.add(rdbtnoption_5);
        
        JRadioButton rdbtnoption_6 = new JRadioButton("I would! It would be an easy transition to making a friend");
        rdbtnoption_6.setForeground(new Color(0, 0, 102));
        rdbtnoption_6.setBackground(new Color(51, 153, 153));
        rdbtnoption_6.setFont(new Font("Tahoma", Font.BOLD, 12));
        rdbtnoption_6.setBounds(10, 295, 399, 23);
        contentPane.add(rdbtnoption_6);
        
        JRadioButton rdbtnoption_7 = new JRadioButton("It'd be cool, but it doesn't matter");
        rdbtnoption_7.setForeground(new Color(0, 0, 102));
        rdbtnoption_7.setBackground(new Color(51, 153, 153));
        rdbtnoption_7.setFont(new Font("Tahoma", Font.BOLD, 12));
        rdbtnoption_7.setBounds(10, 317, 272, 29);
        contentPane.add(rdbtnoption_7);
        
        JRadioButton rdbtnoption_8 = new JRadioButton("I'd rather make my own friends outside then get matched with one");
        rdbtnoption_8.setForeground(new Color(0, 0, 102));
        rdbtnoption_8.setBackground(new Color(51, 153, 153));
        rdbtnoption_8.setFont(new Font("Tahoma", Font.BOLD, 12));
        rdbtnoption_8.setBounds(10, 336, 481, 36);
        contentPane.add(rdbtnoption_8);
        
        JLabel question4Lbl = new JLabel("4) Would you like to attend group events with your roommate?");
        question4Lbl.setForeground(Color.BLACK);
        question4Lbl.setFont(new Font("Tahoma", Font.BOLD, 14));
        question4Lbl.setBounds(10, 373, 456, 20);
        contentPane.add(question4Lbl);
        
        JRadioButton rdbtnoption_9 = new JRadioButton("Yes, I would like that! ");
        rdbtnoption_9.setForeground(new Color(0, 102, 0));
        rdbtnoption_9.setBackground(new Color(51, 153, 153));
        rdbtnoption_9.setFont(new Font("Tahoma", Font.BOLD, 12));
        rdbtnoption_9.setBounds(10, 400, 189, 23);
        contentPane.add(rdbtnoption_9);
        
        JRadioButton rdbtnoption_10 = new JRadioButton("I would, if they ask");
        rdbtnoption_10.setForeground(new Color(0, 102, 0));
        rdbtnoption_10.setBackground(new Color(51, 153, 153));
        rdbtnoption_10.setFont(new Font("Tahoma", Font.BOLD, 12));
        rdbtnoption_10.setBounds(10, 421, 159, 29);
        contentPane.add(rdbtnoption_10);
        
        JRadioButton rdbtnoption_11 = new JRadioButton("I feel we should do our own thing");
        rdbtnoption_11.setForeground(new Color(0, 102, 0));
        rdbtnoption_11.setBackground(new Color(51, 153, 153));
        rdbtnoption_11.setFont(new Font("Tahoma", Font.BOLD, 12));
        rdbtnoption_11.setBounds(10, 446, 247, 23);
        contentPane.add(rdbtnoption_11);
        
        JLabel question5Lbl = new JLabel("5) Do you believe in cleaning schedules?");
        question5Lbl.setForeground(Color.BLACK);
        question5Lbl.setFont(new Font("Tahoma", Font.BOLD, 14));
        question5Lbl.setBounds(10, 476, 311, 20);
        contentPane.add(question5Lbl);
        
        JRadioButton rdbtnoption_12 = new JRadioButton("Yeah we should help each other out");
        rdbtnoption_12.setForeground(new Color(0, 0, 102));
        rdbtnoption_12.setBackground(new Color(51, 153, 153));
        rdbtnoption_12.setFont(new Font("Tahoma", Font.BOLD, 12));
        rdbtnoption_12.setBounds(10, 497, 247, 23);
        contentPane.add(rdbtnoption_12);
        
        JRadioButton rdbtnoption_13 = new JRadioButton("I'd pick up if I saw something down");
        rdbtnoption_13.setForeground(new Color(0, 0, 102));
        rdbtnoption_13.setBackground(new Color(51, 153, 153));
        rdbtnoption_13.setFont(new Font("Tahoma", Font.BOLD, 12));
        rdbtnoption_13.setBounds(10, 523, 247, 23);
        contentPane.add(rdbtnoption_13);
        
        JRadioButton rdbtnoption_14 = new JRadioButton("No, to each their own");
        rdbtnoption_14.setForeground(new Color(0, 0, 102));
        rdbtnoption_14.setBackground(new Color(51, 153, 153));
        rdbtnoption_14.setFont(new Font("Tahoma", Font.BOLD, 12));
        rdbtnoption_14.setBounds(10, 549, 172, 23);
        contentPane.add(rdbtnoption_14);
        
        JLabel question6Lbl = new JLabel("6) Is sleep schedule important?");
        question6Lbl.setForeground(Color.BLACK);
        question6Lbl.setFont(new Font("Tahoma", Font.BOLD, 15));
        question6Lbl.setBounds(489, 83, 257, 14);
        contentPane.add(question6Lbl);
        
        JRadioButton rdbtnoption_15 = new JRadioButton("Of course we should coordinate!");
        rdbtnoption_15.setForeground(new Color(0, 102, 0));
        rdbtnoption_15.setBackground(new Color(51, 153, 153));
        rdbtnoption_15.setFont(new Font("Tahoma", Font.BOLD, 12));
        rdbtnoption_15.setBounds(499, 104, 232, 23);
        contentPane.add(rdbtnoption_15);
        
        JRadioButton rdbtnoption_16 = new JRadioButton("Every once in a while I don't mind if they come in late. ");
        rdbtnoption_16.setForeground(new Color(0, 102, 0));
        rdbtnoption_16.setBackground(new Color(51, 153, 153));
        rdbtnoption_16.setFont(new Font("Tahoma", Font.BOLD, 12));
        rdbtnoption_16.setBounds(498, 126, 372, 23);
        contentPane.add(rdbtnoption_16);
        
        JRadioButton rdbtnoption_17 = new JRadioButton("They can sleep whenever they want, dosn't matter. ");
        rdbtnoption_17.setForeground(new Color(0, 102, 0));
        rdbtnoption_17.setBackground(new Color(51, 153, 153));
        rdbtnoption_17.setFont(new Font("Tahoma", Font.BOLD, 12));
        rdbtnoption_17.setBounds(499, 146, 347, 29);
        contentPane.add(rdbtnoption_17);
        
        JLabel question7Lbl = new JLabel("7) Would you want to find a roommate for the next several year? ");
        question7Lbl.setForeground(Color.BLACK);
        question7Lbl.setFont(new Font("Tahoma", Font.BOLD, 14));
        question7Lbl.setBounds(485, 177, 457, 14);
        contentPane.add(question7Lbl);
        
        JRadioButton rdbtnoption_18 = new JRadioButton("Yes I would, it would be great to dorm togehter all our four year. ");
        rdbtnoption_18.setForeground(new Color(0, 0, 102));
        rdbtnoption_18.setBackground(new Color(51, 153, 153));
        rdbtnoption_18.setFont(new Font("Tahoma", Font.BOLD, 12));
        rdbtnoption_18.setBounds(499, 198, 435, 23);
        contentPane.add(rdbtnoption_18);
        
        JRadioButton rdbtnoption_19 = new JRadioButton("I'll see when it happens.");
        rdbtnoption_19.setForeground(new Color(0, 0, 102));
        rdbtnoption_19.setBackground(new Color(51, 153, 153));
        rdbtnoption_19.setFont(new Font("Tahoma", Font.BOLD, 12));
        rdbtnoption_19.setBounds(499, 218, 232, 23);
        contentPane.add(rdbtnoption_19);
        
        JRadioButton rdbtnoption_20 = new JRadioButton("I'd rather change it up every year. ");
        rdbtnoption_20.setForeground(new Color(0, 0, 102));
        rdbtnoption_20.setBackground(new Color(51, 153, 153));
        rdbtnoption_20.setFont(new Font("Tahoma", Font.BOLD, 12));
        rdbtnoption_20.setBounds(499, 240, 257, 23);
        contentPane.add(rdbtnoption_20);
        
        JLabel lblNewLabel_5 = new JLabel("8) You see an older lady crossing the street, you...");
        lblNewLabel_5.setForeground(Color.BLACK);
        lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_5.setBounds(489, 270, 347, 20);
        contentPane.add(lblNewLabel_5);
        
        JRadioButton rdbtnoption_21 = new JRadioButton("Insist on helping her across");
        rdbtnoption_21.setForeground(new Color(0, 102, 0));
        rdbtnoption_21.setBackground(new Color(51, 153, 153));
        rdbtnoption_21.setFont(new Font("Tahoma", Font.BOLD, 12));
        rdbtnoption_21.setBounds(499, 291, 232, 23);
        contentPane.add(rdbtnoption_21);
        
        JRadioButton rdbtnoption_22 = new JRadioButton("Help if she asks!");
        rdbtnoption_22.setForeground(new Color(0, 102, 0));
        rdbtnoption_22.setBackground(new Color(51, 153, 153));
        rdbtnoption_22.setFont(new Font("Tahoma", Font.BOLD, 12));
        rdbtnoption_22.setBounds(499, 307, 184, 36);
        contentPane.add(rdbtnoption_22);
        
        JRadioButton rdbtnoption_23 = new JRadioButton("Mind your own business, she never asked. ");
        rdbtnoption_23.setForeground(new Color(0, 102, 0));
        rdbtnoption_23.setBackground(new Color(51, 153, 153));
        rdbtnoption_23.setFont(new Font("Tahoma", Font.BOLD, 12));
        rdbtnoption_23.setBounds(499, 336, 329, 29);
        contentPane.add(rdbtnoption_23);
        
        JLabel lblNewLabel = new JLabel("2) Do you consider your self social?");
        lblNewLabel.setForeground(Color.BLACK);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel.setBounds(10, 177, 340, 20);
        contentPane.add(lblNewLabel);
        
        JRadioButton rdbtnoption_24 = new JRadioButton("Yes I need it done a particular way");
        rdbtnoption_24.setForeground(new Color(0, 0, 102));
        rdbtnoption_24.setBackground(new Color(51, 153, 153));
        rdbtnoption_24.setFont(new Font("Tahoma", Font.BOLD, 12));
        rdbtnoption_24.setBounds(499, 400, 257, 23);
        contentPane.add(rdbtnoption_24);
        
        JRadioButton rdbtnoption_26 = new JRadioButton("As long as my stuff is kept on my side I have no arguments");
        rdbtnoption_26.setForeground(new Color(0, 0, 102));
        rdbtnoption_26.setBackground(new Color(51, 153, 153));
        rdbtnoption_26.setFont(new Font("Tahoma", Font.BOLD, 12));
        rdbtnoption_26.setBounds(499, 447, 400, 23);
        contentPane.add(rdbtnoption_26);
        
        JRadioButton rdbtnoption_25 = new JRadioButton("Not really!");
        rdbtnoption_25.setForeground(new Color(0, 0, 102));
        rdbtnoption_25.setBackground(new Color(51, 153, 153));
        rdbtnoption_25.setFont(new Font("Tahoma", Font.BOLD, 12));
        rdbtnoption_25.setBounds(499, 425, 109, 23);
        contentPane.add(rdbtnoption_25);
        
        JRadioButton rdbtnoption_29 = new JRadioButton("I feel like I'll be out and about. ");
        rdbtnoption_29.setForeground(new Color(0, 102, 0));
        rdbtnoption_29.setBackground(new Color(51, 153, 153));
        rdbtnoption_29.setFont(new Font("Tahoma", Font.BOLD, 12));
        rdbtnoption_29.setBounds(499, 550, 232, 23);
        contentPane.add(rdbtnoption_29);
        
        JRadioButton rdbtnoption_27 = new JRadioButton("I would prefer to be and I'd like company. ");
        rdbtnoption_27.setForeground(new Color(0, 102, 0));
        rdbtnoption_27.setBackground(new Color(51, 153, 153));
        rdbtnoption_27.setFont(new Font("Tahoma", Font.BOLD, 12));
        rdbtnoption_27.setBounds(499, 498, 329, 23);
        contentPane.add(rdbtnoption_27);
        
        JRadioButton rdbtnoption_28 = new JRadioButton("Sometimes, won't know until the semester starts though. ");
        rdbtnoption_28.setForeground(new Color(0, 102, 0));
        rdbtnoption_28.setBackground(new Color(51, 153, 153));
        rdbtnoption_28.setFont(new Font("Tahoma", Font.BOLD, 12));
        rdbtnoption_28.setBounds(499, 524, 411, 23);
        contentPane.add(rdbtnoption_28);
        
        //declares the radio-button groups for all the radiobutton in a group of three. 
        ButtonGroup bg1 = new ButtonGroup();//group 1 

        bg1.add(rdbtnoption_0);
        bg1.add(rdbtnoption_1);
        bg1.add(rdbtnoption_2);
        
        ButtonGroup bg2 = new ButtonGroup();//group 2
        
        bg2.add(rdbtnoption_3);
        bg2.add(rdbtnoption_4);
        bg2.add(rdbtnoption_5);
        
        ButtonGroup bg3 = new ButtonGroup();//group 3
        
        bg3.add(rdbtnoption_6);
        bg3.add(rdbtnoption_7);
        bg3.add(rdbtnoption_8);
        
        ButtonGroup bg4 = new ButtonGroup();//group 4
        
        bg4.add(rdbtnoption_9);
        bg4.add(rdbtnoption_10);
        bg4.add(rdbtnoption_11);
        
        ButtonGroup bg5 = new ButtonGroup();//group 5
        
        bg5.add(rdbtnoption_12);
        bg5.add(rdbtnoption_13);
        bg5.add(rdbtnoption_14);
        
        ButtonGroup bg6 = new ButtonGroup();//group 6
        
        bg6.add(rdbtnoption_15);
        bg6.add(rdbtnoption_16);
        bg6.add(rdbtnoption_17);
        
        ButtonGroup bg7 = new ButtonGroup();//group 7
        
        bg7.add(rdbtnoption_18);
        bg7.add(rdbtnoption_19);
        bg7.add(rdbtnoption_20);
        
        ButtonGroup bg8 = new ButtonGroup();//group 8
        
        bg8.add(rdbtnoption_21);
        bg8.add(rdbtnoption_22);
        bg8.add(rdbtnoption_23);

        ButtonGroup bg9 = new ButtonGroup();//group 9
        
        bg9.add(rdbtnoption_24);
        bg9.add(rdbtnoption_25);
        bg9.add(rdbtnoption_26);
        
        ButtonGroup bg10 = new ButtonGroup();//group 10
        
        bg10.add(rdbtnoption_27);
        bg10.add(rdbtnoption_28);
        bg10.add(rdbtnoption_29);
        
        
        
        /*
         * Query will write to the database, whatever the user selects as their awnsers for the questions.
         * The program will check all the values to see which personality type was the most selected.  
         * Personality A - Those who want to work with their roommates
         * Personality B - Neutral Towards roommates
         * Personality C - Want nothing to do with roommates. 
         * After clicking continue, either A,B,or C will be written to the database.
         */
        
        JButton continueButton = new JButton("Continue");
        continueButton.setForeground(Color.BLACK);
        continueButton.setFont(new Font("Tahoma", Font.BOLD, 12));
        continueButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { //Action performance 
                
                //Checks if the user has selected at least one option from the radiobutton groups, only then they can continue. 
                if(bg1.getSelection()==null || bg2.getSelection()==null || bg3.getSelection()==null || bg4.getSelection()==null || bg5.getSelection()==null ||bg6.getSelection()==null || bg7.getSelection()==null
                        || bg8.getSelection()==null || bg9.getSelection()==null || bg10.getSelection()==null){
                    JOptionPane.showMessageDialog(null, "Pleae Enter all questions!"); //Message showing Alert 
                    
                }else{ //If all buttongroups have a value in them, then the use can continue
                
                	//takes the three personalities as integer values. 
                int perA = 0; 
                int perB = 0;
                int perC = 0;
                //place every radiobutton in an array
                JRadioButton questionArray [] = {rdbtnoption_0,rdbtnoption_1,rdbtnoption_2,rdbtnoption_3,rdbtnoption_4,rdbtnoption_5,rdbtnoption_6,rdbtnoption_7,rdbtnoption_8,rdbtnoption_9,rdbtnoption_10,rdbtnoption_11,rdbtnoption_12,rdbtnoption_13,rdbtnoption_14,rdbtnoption_15,rdbtnoption_16,rdbtnoption_17,rdbtnoption_18,rdbtnoption_19,rdbtnoption_20,rdbtnoption_21,rdbtnoption_22,rdbtnoption_23,  };
                
                /*
                 * The buttons are placed in an orders such that the first button has roommates wanting to spend time with each other.
                 * Secound button options are usually neutral towards roommates.
                 * Third button options are for those who don't want anything with their roommates.
                 * These will hold as the theree types of personalities for roommate matching.
                 */
                
                
                //Takes three button at a time
                for (int x=0; x <=21; x+=3){
                    if(questionArray[x].isSelected())
                        perA++; //if first button from the buttonGroup is selected, increment A 
                }
                
                
                for (int x=1; x <=22; x+=3){
                    if(questionArray[x].isSelected())
                        perB++; //if secound button from the buttonGroup is selected, increment B 
                }
                for (int x=2; x <=23; x+=3){
                    if(questionArray[x].isSelected())
                        perC++;//if third button from the buttonGroup is selected, increment C
                }
                
                String personalityType =  null; 
                
                //the statements below will compare the variables of each personality and output the one with the biggest number.
                //That personality type will be added to the database.
                if (perA >= perB && perA >= perC){
                     personalityType = "A"; //either A 
                     
                }
                if (perB >= perA && perB >= perC){
                    personalityType = "B"; //either B 
                     

                }
                if (perC >= perA && perC >= perB){
                    personalityType = "C"; //Or C
                }
                
                try{
                                    
                //Query will update the database, on the colum "Personality", whatever the user's personality is. 
                String sql = "Update StudentData set Personality = '"+personalityType+"' where username=?";
                
                PreparedStatement pst = connection .prepareStatement(sql);//prepare statement for query
                
                
                pst.setString(1, personalityType); //sets the value where username equals the username entered in frame 1.
                pst.setString(1, String.valueOf(Student.userName).toString());
                pst.execute(); //Execute the prepare statement. 

                ResultSet rs = pst.executeQuery(); //result statement. 
                
                rs.close();  //Close the database
                pst.close();
                
            
            } catch (Exception e1) {
               
            }
                //IF all radiobutton groups have atleast one value in them, then close the frame, and open the ResultFrame
                dispose();
                ResultFramee frm5= new ResultFramee();
                frm5.setVisible(true);
            }
            }
        });
        continueButton.setBounds(760, 564, 172, 23);
        contentPane.add(continueButton);
    }
}