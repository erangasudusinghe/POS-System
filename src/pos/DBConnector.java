
package pos;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;


public class DBConnector {
    static Connection DBCon()
    {
        Connection con =null;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/pos_system","root","");
            return con;
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Please Run the database Sever");
            System.out.println("Connection interupted "+e);
            return null;
        }    
    }
}
