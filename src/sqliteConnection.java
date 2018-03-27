/*
 * Connection to the database class. 
 */
//sql imports
import java.sql.*;
import javax.swing.*;
public class sqliteConnection {
	
	Connection conn = null;
	public static Connection dbConnector(){
		
		try{ 
			Class.forName("org.sqlite.JDBC"); //uses JDBC components
			
			/*
			 * As mentioned in the word document for instructions, please change the path to the database location. 
			 */
			Connection conn = DriverManager.getConnection("jdbc:sqlite:\\Users\\Sylvester\\Desktop\\StudentInfo.sqlite");
			System.out.println("Connection successful");

			return conn; //return connection, which will be used in other classes. 
			
		}catch(Exception e ){ //if database is not found, output exception instead of errors. 
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}
	
		
}
