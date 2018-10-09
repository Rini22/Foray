
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

public class User1 {
 
 
  private String name;
  private String msg;
  
  

 public BasicDBObject toDBObject() {
  BasicDBObject document = new BasicDBObject();
 
    document.put("name", name);
    document.put("msg", msg);
    
 
  return document;
 }
 
 public static User1 fromDBObject(DBObject document) {
  User1 b = new User1();
  
   b.name = (String) document.get("name");
   b.msg = (String) document.get("msg");
    
  return b;
 }
     

public String getName(){
 return name;   
}
public void setName(String name){
 this.name=name;
}
public String getMsg(){
 return msg;   
}
public void setMsg(String msg){
 this.msg=msg;
}

   

}
