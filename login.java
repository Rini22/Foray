/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author hp-u
 */
public class login extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
                response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          DBCollection userCollection;
        Mongo mongo = new Mongo();
        DB db = mongo.getDB("registeration");
        userCollection = db.getCollection("users");
        String userId=request.getParameter("userId");
        String Pwd=request.getParameter("pwd");
       
        BasicDBObject andQuery = new BasicDBObject();
        List<BasicDBObject> obj = new ArrayList<>();
        obj.add(new BasicDBObject("Pwd", Pwd ));
    obj.add(new BasicDBObject("EmailId", userId));
    andQuery.put("$and", obj);

System.out.println(andQuery.toString());

DBCursor cursor =userCollection.find(andQuery);
 
        //request.getRequestDispatcher("/loginme.html").include(request,response);
 if( cursor.hasNext() ){
    // DBObject obj1 = cursor.next();

                 HttpSession session= request.getSession();
                 //session.setMaxInactiveInterval(30);
                 session.setAttribute("userId",userId);
                
                 response.sendRedirect("start.jsp");
                 // out.println("Welcome");
        }
       
        
        else{  
           out.println ("<html><body><script>alert('user not registered!');</script></body></html>");
            request.getRequestDispatcher("index1.html").include(request, response);  
        } 
        }
        
        catch(ServletException | IOException e){
            System.out.println(e);
  }
        
        
        
        
        
        
        /*BasicDBObject whereQuery = new BasicDBObject();
        whereQuery.put("emailId", userId);
        DBCursor cursor = userCollection.find(whereQuery);
        BasicDBObject whereQuery1= new BasicDBObject();
        whereQuery1.put("Pwd", Pwd);
        DBCursor cursor1 = userCollection.find(whereQuery);
        while(cursor.hasNext()) {
            
            //System.out.println(cursor.next());
           RequestDispatcher rd = getServletContext().getRequestDispatcher("/start.html");
            rd.forward(request, response);
           }*/

    }
}
