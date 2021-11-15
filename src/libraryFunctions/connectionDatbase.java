
package libraryFunctions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import Objects.*;



public class connectionDatbase {
    private static final String DatabaseLocation = System.getProperty("user.dir") + "\\ProjectManagment.accdb";
    private static Connection con;
    private static userDetailsObject currentUser;
   public static Connection getConnection() {
        try {
            con = DriverManager.getConnection("jdbc:ucanaccess://" + DatabaseLocation, "", "");
            return con;
        } catch (Exception e) {
            System.out.println("Error in the repository class: " + e);
        }
        return null;
    }


    public static userDetailsObject getCurrentUser() {
        return currentUser;
    }
    public static connection addUserEmail(){
        
    }
     public static boolean EmployeeLogIn(String userID, String password) {
        try {
            String sql = "SELECT * FROM Employee where Employee_ID = '" + userID + "'";
            ResultSet rs = executeSQL.executeQuery(getConnection(), sql);

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
