
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import java.io.Serializable;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author hp-u
 */
public class quizo implements Serializable {
    private String[] q1;
 private String to;
 private String from;
  private String people;
  
  

 public BasicDBObject toDBObject() {
  BasicDBObject document = new BasicDBObject();
  document.put("q1", q1);
  document.put("to", to);
  document.put("from", from);
   document.put("people", people);
    
 
  return document;
 }
 
 public static quizo fromDBObject(DBObject document) {
  quizo b = new quizo();
  b.q1 = (String[]) document.get("q1");
  b.to= (String) document.get("to");
  b.from = (String) document.get("from");
   b.people = (String) document.get("people");
    
  return b;
 }
      public String[] getQ1(){
 return q1;   
}
public void setQ1(String[] q1){
 this.q1=q1;
}
public String getTo(){
 return to;   
}
public void setTo(String to){
 this.to=to;
}
public String getFrom(){
 return from;   
}
public void setFrom(String from){
 this.from=from;
}
public String getPeople(){
 return people;   
}
public void setPeople(String people){
 this.people=people;
}

   

}
