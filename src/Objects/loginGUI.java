
package Objects;

import java.io.*;
public class loginGUI implements Serializable {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    
    public loginGUI(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public boolean equals(loginGUI LoginGUI){
        return (this.username.equals(LoginGUI.username) && this.password.equals(LoginGUI.password));      
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
