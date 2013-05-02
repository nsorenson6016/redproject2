package edu.wctc.distjava.redproject.servlet;

import edu.wctc.distjava.redproject.eao.IUserEAO;
import edu.wctc.distjava.redproject.model.Users;
import edu.wctc.distjava.redproject.service.UserRegistrationService;
import edu.wctc.distjava.redproject.service.UserService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * This servlet will be the destination of the email that is sent
 * to new users to verify the user's email.  The servlet will then redirect the
 * user to the verifyEmail web page, which will redirect to the login screen.
 * 
 * @author Neal Sorenson
 */

public class EmailConfirmationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String errorMessage = "";
        String destination = "/faces/";
        
        try{
            //get parameter from email
            String encodedUsername = request.getParameter("user"); 
            //decode username
            byte[] decodedUsername = Base64.decode(encodedUsername.getBytes());
            // turn decoded username into a string
            String username = new String(decodedUsername); 
            
            // Retrieve Spring ApplicationContext 
            WebApplicationContext ctx =
                   WebApplicationContextUtils
                   .getWebApplicationContext(this.getServletContext());
            
            // get UserService
            UserService service = 
                    (UserService) ctx.getBean("userService");
            
            // do a search for username in database
            Users foundUser = service.findUserByUserName(username);
            
            // If found, enable user and send to verifyEmail page.  
            // If not, send to emailerror page.
            
            if (foundUser == null){
                foundUser.setEnabled(true);
                destination+="emailerror.xhtml";
            } else {
                destination+="verifyEmail.xhtml";
            }
            
        } catch (Exception e){
            errorMessage += e.toString();
        }
        
        RequestDispatcher dispatcher =
                    getServletContext().getRequestDispatcher(destination);
                dispatcher.forward(request, response);
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
