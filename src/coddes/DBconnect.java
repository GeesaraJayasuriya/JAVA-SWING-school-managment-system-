
package coddes;

import java.sql.*;

import javax.swing.JOptionPane;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBconnect {
    
    public static Connection connect(){
        
        Connection conn=null;
        
        try{
        
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/firstproject","root","");
        
        }
        
        catch(Exception e){
        
        JOptionPane.showMessageDialog(null,e);
        }
        
        return conn;
        
    } 
    
}
