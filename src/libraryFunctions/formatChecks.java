
package libraryFunctions;

public class formatChecks {
    
    public static boolean passwordEqual(){
   
        String password1 = "sfsdfa";
        String password2 = "sfsdfa";
        boolean valid = false;
        if(password1.equals(password2)){
            valid = true;
            return valid;
        }
        return valid;
}
     public static boolean validEmail(){
         String email = "sgjsdkgsj@kjgdf.com";
         boolean valid = false;
         if(email.length()<=64){
         if(email.contains("@")&&(email.contains(".com")||email.contains(".co.uk"))){
             valid = true;
             return valid;
         }
     }
         return valid;
     }
      public static boolean validPassword(){
          String password = "sfsdfa";
            boolean valid = false;
             if(password.length()<=20){
                 valid = true;
             }
             else{
                 valid = false;
                 return valid;
             }
             valid = passwordContainUpperCase(valid, password);
             valid = passwordContainSymbol(valid, password);
             
             return valid;
      }
      public static boolean passwordContainUpperCase(boolean valid, String password){
          String passwordToLowerCase = password.toLowerCase();
          if(password.equals(passwordToLowerCase)){
              valid = false;
          } else{
              valid = true;
              return valid;
          }
          return valid;
      }
       public static boolean passwordContainSymbol(boolean valid, String password){
           char[] characters = password.toCharArray();
           
           for (int i = 0; i < characters.length; i++) {
               char character = characters[i];
               int asciiValue = (int)character;
               if((asciiValue>=33&&asciiValue<=47)||(asciiValue>=58&&asciiValue<=64)
                       ||(asciiValue>=91&&asciiValue<=96)||(asciiValue>=123&&asciiValue<=126)){
                   valid = true;
                   return valid;
               }
           }
           return valid;
       }
}
