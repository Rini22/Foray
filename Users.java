
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

public class Users {
 
 private String FirstName;
 private String LastName;
 private String EmailId;
  private String Pwd;
  private String name;
  private String msg;
  
  

 public BasicDBObject toDBObject() {
  BasicDBObject document = new BasicDBObject();
  document.put("Firstname", FirstName);
  document.put("LastName", LastName);
  document.put("EmailId", EmailId);
   document.put("Pwd", Pwd);
    
    
 
  return document;
 }
 
 public static Users fromDBObject(DBObject document) {
  Users b = new Users();
  b.FirstName = (String) document.get("Firstname");
  b.LastName = (String) document.get("Lastname");
  b.EmailId = (String) document.get("EmailId");
   b.Pwd = (String) document.get("Pwd");
  
    
  return b;
 }
      public String getFirsName(){
 return FirstName;   
}
public void setFirstName(String FirstName){
 this.FirstName=FirstName;
}
public String getLastName(){
 return LastName;   
}
public void setLastName(String LastName){
 this.LastName=LastName;
}
public String getEmailId(){
 return EmailId;   
}
public void setEmailId(String EmailId){
 this.EmailId=EmailId;
}
public String getPwd(){
 return Pwd;   
}
public void setPwd(String Pwd){
 this.Pwd=Pwd;
}


   

}
