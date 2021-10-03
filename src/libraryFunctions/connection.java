
package libraryFunctions;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;



public class connection {
    
    public static void main(String[] args){
       
        try{
           Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/StadiumBookingDatabase", "Noah", "1111");
           Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
           
           String sql = "Select * From USERTABLE";
           ResultSet rs = statement.executeQuery(sql);
           
           while(rs.next()){
               int id = rs.getInt("USERID");
               String firstName = rs.getString("FIRSTNAME");          
               String lastName = rs.getString("LASTNAME");
               String emailAddress = rs.getString("EMAIL");
               String password = rs.getString("password");
               Date dob = rs.getDate("DATEOFBIRTH");
               
               System.out.println(id+" "+firstName+" "+emailAddress);
           }
           
           rs.close();
           con.close();
           statement.close();
           
        } catch (Exception e){
            System.out.println(e);;
        }
    }
}
