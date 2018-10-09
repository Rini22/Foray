import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;
import java.net.*;

import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.WriteConcern;
import com.mongodb.ServerAddress;
import com.mongodb.connection.Connection;
import com.mongodb.model.User;
import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import static com.sun.xml.rpc.spi.runtime.ClientTransportFactoryTypes.HTTP;
import java.io.IOException;
import java.io.PrintWriter;
import static java.net.Proxy.Type.HTTP;
import java.util.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class saveData extends HttpServlet {
 @Override
 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  try{
         
         DBCollection userCollection;      
         // init  
         Mongo mongo = new Mongo();
         DB db = mongo.getDB("registeration");
         userCollection = db.getCollection("users");
         if (userCollection == null) {
             userCollection = db.createCollection("users", null);
         }
         // create    
         Users users = new Users(); 
         users.setFirstName(request.getParameter("first name"));
         users.setLastName(request.getParameter("last name"));
        users.setEmailId(request.getParameter("email id"));
        String emailId=request.getParameter("email id");
         users.setPwd(request.getParameter("Pwd"));
         
         BasicDBObject andQuery = new BasicDBObject();
        List<BasicDBObject> obj = new ArrayList<>();
        obj.add(new BasicDBObject("EmailId", emailId ));
         andQuery.put("$and", obj);

System.out.println(andQuery.toString());

DBCursor cursor =userCollection.find(andQuery);
              if( cursor.hasNext() ){     
       
        RequestDispatcher rd1 = getServletContext().getRequestDispatcher("/m.html");
            rd1.forward(request, response);
              }
              else 
              {
                 BasicDBObject doc = users.toDBObject();
        userCollection.insert(doc);
         RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
            rd.forward(request, response);
           
              }
 
  } catch(Exception e){
  }
 }
}


  