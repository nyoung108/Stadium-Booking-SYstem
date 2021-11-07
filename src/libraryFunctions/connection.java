
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
    public static boolean UserLogIn(String email, String password) {
        try {
            String sql = "SELECT * FROM Employee where Employee_ID = '" + email + "'";
            ResultSet rs = statement.executeQuery(getConnection(), sql);

            if (rs.next()) {
                currentUser = new Employee(rs.getString("Employee_Id"), rs.getString("Employee_Fname"), rs.getString("Employee_Lname"), rs.getString("Employee_Password"), rs.getString("Employee_Dept"), rs.getString("Employee_Office"), rs.getString("Employee_Phone"), rs.getDate("Employee_HireDate"), rs.getDouble("Employee_HourlyRate"));
                if (!helper.CompareHashed(currentUser.getEmployee_Password(), password)) {
                    return false;
                }
            }
            rs.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Error in the repository class: " + e);

        }
        return currentUser != null;
    }
}
