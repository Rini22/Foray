    import java.io.IOException;  
    import java.io.PrintWriter;  
      
    import javax.servlet.ServletException;  
    import javax.servlet.http.HttpServlet;  
    import javax.servlet.http.HttpServletRequest;  
    import javax.servlet.http.HttpServletResponse;  
    import javax.servlet.http.HttpSession;  
    public class logout extends HttpServlet {  
            @Override
            protected void doGet(HttpServletRequest request, HttpServletResponse response)  
                                    throws ServletException, IOException {  
                response.setContentType("text/html");  
                try (PrintWriter out = response.getWriter()) {
                    
                    
                    HttpSession session=request.getSession();
                    session.removeAttribute("userId");
                    session.invalidate();
                    request.getRequestDispatcher("index.jsp").include(request, response);
                    out.print("You are successfully logged out!");
                }  
        }  
    }  