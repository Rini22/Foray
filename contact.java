/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSInputFile;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hp-u
 */
public class contact extends HttpServlet {

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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
             DBCollection userCollection;
        Mongo mongo = new Mongo();
        DB db = mongo.getDB("registeration");
        userCollection = db.getCollection("users");
        String email=request.getParameter("email");
        BasicDBObject andQuery = new BasicDBObject();
        List<BasicDBObject> obj = new ArrayList<>();
         obj.add(new BasicDBObject("EmailId", email));
    andQuery.put("$and", obj);
    System.out.println(andQuery.toString());

DBCursor cursor =userCollection.find(andQuery);
 if( cursor.hasNext() ){
      response.sendRedirect("indl");
 }
 else{
     out.println ("<html><body><script>alert('user not registered!');</script></body></html>");
 }
  DB db1 = mongo.getDB("gridfs");
        String image=request.getParameter("pic");
       String newFileName = image;
File imageFile = new File("c:\\" +image);
      
GridFS gfsPhoto = new GridFS(db1, "photo");
GridFSInputFile gfsFile = gfsPhoto.createFile(imageFile);
gfsFile.setFilename(newFileName);
gfsFile.save();
        }
    
 }
     }
    
