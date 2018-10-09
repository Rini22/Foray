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
public class msg extends HttpServlet {
 @Override
 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  try{
         
         DBCollection userCollection,usrColl;      
         // init  
         Mongo mongo = new Mongo();
         DB db = mongo.getDB("review");
         DB db1 = mongo.getDB("registeration");
         userCollection = db.getCollection("contact");
          usrColl= db.getCollection("users");
         if (userCollection == null) {
             userCollection = db.createCollection("contact", null);
         }
         // create    
         User1 users = new User1(); 
         users.setName(request.getParameter("name"));
         users.setMsg(request.getParameter("message"));
        String s=request.getParameter("email");
        /* users.setEmailId(request.getParameter("email"));
         BasicDBObject andQuery1 = new BasicDBObject();
        List<BasicDBObject> obj2 = new ArrayList<>();
        
    obj2.add(new BasicDBObject("EmailId",request.getParameter("email") ));
    andQuery1.put("$and", obj2);
    System.out.println(andQuery1.toString());

DBCursor cursor1 =usrColl.find(andQuery1);
*/
         BasicDBObject andQuery = new BasicDBObject();
        List<BasicDBObject> obj = new ArrayList<>();
        obj.add(new BasicDBObject("name", request.getParameter("name")));
        obj.add(new BasicDBObject("msg", request.getParameter("message")));
            
       
       BasicDBObject doc = users.toDBObject();
        userCollection.insert(doc);
         RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
            rd.forward(request, response);
          

  } catch(ServletException | IOException e){
      System.out.println(e);
  }
 }
}


  