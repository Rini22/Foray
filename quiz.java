

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static javax.ws.rs.client.Entity.json;
import org.bson.BasicBSONObject;
import org.bson.Document;
import org.bson.types.BasicBSONList;
import org.json.JSONObject;
/**
 *
 * @author hp-u
 */
public class quiz extends HttpServlet {
  MongoClient client = new MongoClient();
		MongoDatabase database = client.getDatabase("foray");
		MongoCollection<Document> collection = database
				.getCollection("temple");
                MongoCollection<Document> collection1 = database
				.getCollection("cafes");
                MongoCollection<Document> collection2 = database
				.getCollection("mall");
                MongoCollection<Document> collection3 = database
				.getCollection("park");
                

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        
     
            response.setContentType("text/html;charset=UTF-8");
       
         int i=0,j;
        PrintWriter out = response.getWriter();
   
          String s1,s2,s3,s4;
          s1="Cafes";s2="Malls";s3="Parks";s4="Places of Worship";
       
          String[] s=request.getParameterValues("q1");
          String m3=request.getParameter("from");
           String m4=request.getParameter("to");
            String m5=request.getParameter("x");
request.setAttribute("to",m4);        
 request.setAttribute("from",m3);  
 request.setAttribute("x",m5);  
          
          
if(s[0].equals(s1)){
   
  cafes(request,response);
  
   for(j=1;j<s.length;j++){
if(s[j].equals(s2)){
  mall(request,response);
  }
if(s[j].equals(s3)){
  park(request,response);
  }
if(s[j].equals(s4)){
   
  templess(request,response);
  
  }
   }
  request.getRequestDispatcher("index2.jsp").include(request, response);
          }

if(s[0].equals(s2)){
   
  mall(request,response);
   
   for( j=1;j<s.length;j++){
if(s[j].equals(s1)){
  cafes(request,response);
  }
if(s[j].equals(s3)){
  park(request,response);
  }
if(s[j].equals(s4)){
    
  templess(request,response);
  
  }
   }
  request.getRequestDispatcher("index2.jsp").include(request, response);
 }
    

if(s[0].equals(s3)){
   
  park(request,response);
  
   for( j=1;j<s.length;j++){
if(s[j].equals(s2)){
  mall(request,response);
  }
if(s[j].equals(s1)){
  cafes(request,response);
  }
if(s[j].equals(s4)){
   
  templess(request,response);
  
  }
   }
     request.getRequestDispatcher("index2.jsp").include(request, response);
 }


 
if(s[0].equals(s4)){
  
  templess(request,response);
 
   for(j=1;j<s.length;j++){
if(s[j].equals(s2)){
  mall(request,response);
  }
if(s[j].equals(s3)){
  park(request,response);
  }
if(s[j].equals(s1)){
   
  cafes(request,response);
  
   }
  }
   request.getRequestDispatcher("index2.jsp").include(request, response);  
 }

          

 }       
 
 
          
 public void templess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
            
		List<Document> temples = (List<Document>) collection.find().into(
				new ArrayList<Document>());
               
                
                               String a[]=new String[5];
                               int i=0;
		for (Document temple : temples) {
                      a[i] =  temple.getString("name");
                         i++;                    
                }
   request.setAttribute("temple", a);
         //              request.getRequestDispatcher("index2.jsp").include(request, response);  
          }
         public void cafes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
            
		List<Document> cafes= (List<Document>) collection1.find().into(
				new ArrayList<Document>());
                       
                              String a[]=new String[7];
                              int i=0;
		for (Document cafe : cafes) {
                       a[i] =  cafe.getString("name");
                                i++;
}
			
                        request.setAttribute("cafe", a);
                        
                                
          }
         public void mall(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
            
		List<Document> malls = (List<Document>) collection2.find().into(
				new ArrayList<Document>());
                       
                            String a[]=new String[7];
                            int i=0;
		for (Document mall : malls) {
                  a[i] =  mall.getString("name");                                //System.out.println("<html><body><p>"+mall.getString("name")+"</p></body></html>");
                     i++;            
                }
   request.setAttribute("mall", a);
                     //  request.getRequestDispatcher("index2.jsp").include(request, response);  
          }
          
public void park(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
            
		List<Document> parks = (List<Document>) collection3.find().into(
				new ArrayList<Document>());
                       String a[]=new String[5];
                             int i=0; 
		for (Document park : parks) {
                    
                    
    
    a[i] =  park.getString("name");

		i++;	
                                  
                                    //System.out.println("<html><body><p>"+mall.getString("name")+"</p></body></html>");
                     
                      

			
                                    //System.out.println("<html><body><p>"+park.getString("name")+"</p></body></html>");
                               
                }
      request.setAttribute("park", a);
                       //request.getRequestDispatcher("index2.jsp").include(request, response);  
          }
        }
    
