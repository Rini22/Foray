/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.mongodb.Block;
import com.mongodb.Mongo;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DB;
import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSBuckets;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSFile;
import com.mongodb.gridfs.GridFSInputFile;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.in;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static javax.ws.rs.client.Entity.json;

/**
 *
 * @author hp-u
 */
public class review extends HttpServlet {

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
       // response.setContentType("image/jpg");
        try (PrintWriter out = response.getWriter()) {
            
            DB db1;
            Mongo mongo = new Mongo();
            db1 = mongo.getDB("gridfs");
            // Create a gridFSBucket using the default bucket name "fs"
//GridFSBucket gridFSBucket = GridFSBuckets.create();
        String image=request.getParameter("pic");
       String newFileName = image;
File imageFile = new File("c:\\" +image);
     
GridFS gfsPhoto = new GridFS(db1, "photo");
        final DBCursor cursor,data1;
        
        
    
            cursor = gfsPhoto.getFileList();
 //data1 = json.loads(dumps(cursor))
        while (cursor.hasNext()) {
                //String m=gridFile.getFilename();
                Block<GridFSFile> block = new Block<GridFSFile>(){
                    @Override
                    public void apply(final GridFSFile gridFSFile) {
                        System.out.println(gridFSFile.getFilename());
                        System.out.println(cursor.next());
                        
                    }
                    //out.println(gridFile.getFilename());
                };
            }
            }
    
        }}
    