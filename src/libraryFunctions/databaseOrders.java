package libraryFunctions;

import Objects.*;
import GUI.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class databaseOrders {
private static userDetailsObject currentUser; 

    
     public static boolean userLogIn(String email, String password) {
         boolean validUser = false;
        try {
            
           
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/StadiumBookingSystem", "Noah", "1234");
            Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql = "SELECT * FROM usertable where email = '" + email + "' AND password = '"+password+"'";
            ResultSet rs = databaseManagement.executeQuery(sql);
            
            if (rs.next()) {
                currentUser = new userDetailsObject(rs.getString("USERID"), rs.getString("email"), rs.getString("password"), rs.getString("firstName"), rs.getString("lastName"), rs.getString("dateOfBirth"));
                validUser = true;
            }
            rs.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);

        }
        return validUser;
    }
     
    public static void addUser(String userID, String email, String password){
         try {
            
           
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/StadiumBookingSystem", "Noah", "1234");
            Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql = "INSERT INTO USERTABLE (userID, email, password) VALUES ("+userID+", " + email + ", "+password+")";
            ResultSet rs = databaseManagement.executeQuery(sql);
            
            rs.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);

        }
        
    }
    
}
