
    import java.io.*;  
    import javax.servlet.*;  
    import javax.servlet.http.*;  
    public class download extends HttpServlet {  
      
        @Override
        public void doGet(HttpServletRequest request,HttpServletResponse response)  
                 throws IOException  
        {  
        response.setContentType("image/jpeg");  
        ServletOutputStream out;  
            String SAVE_DIR = "images";
         String savePath = "C:" + File.separator + SAVE_DIR;
                File fileSaveDir=new File(savePath);
                if(!fileSaveDir.exists()){
                    fileSaveDir.mkdir();
        out = response.getOutputStream();  
        BufferedOutputStream bout = null;
        int i=0;
       
            try (FileInputStream fin = new FileInputStream("D:\\uploads\\c.jpg "); BufferedInputStream bin = new BufferedInputStream(fin)) {
                bout = new BufferedOutputStream(out);
                int ch =0;
                
                while((ch=bin.read())!=-1)
                {
                    bout.write(ch);
                }         
            }
          
        bout.close();  
        out.close();  
        }  
    }
    }