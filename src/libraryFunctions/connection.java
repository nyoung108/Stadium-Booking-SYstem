
package libraryFunctions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import jdk.nashorn.internal.ir.Statement;

public class connection {
    
    public static void main(String[] args){
        Connection connection = null;
        Statement statement = null;
        ResultSet result = null;
        String query = "";
        try{
            connection = DriverManager.getConnection("jdbc:derby://localhost:1527/StadiumBookingDatabase", "Noah", "1111");
            
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
