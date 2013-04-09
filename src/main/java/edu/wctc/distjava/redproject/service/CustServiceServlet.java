/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wctc.distjava.redproject.service;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Neal
 */
@WebServlet(name = "EmailService", urlPatterns = {"/EmailService"})
public class CustServiceServlet extends HttpServlet { 

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
                
        IEmailer cse = new CustServiceEmailer();

        //Converts parameters to strings
        String custName = request.getParameter("custName");
        String custEmail = request.getParameter("custEmail");
        String custSubject = request.getParameter("custSubject");
        String custMessage = request.getParameter("custMessage");
        String contentsStr = "";
        
        try{
            cse.emailMessage(custEmail, custSubject);
        } catch(Exception e){
            contentsStr = "Houston, we have a problem.";
        }
        
        String destination = "/index.xhtml";
        RequestDispatcher view =
                request.getRequestDispatcher(destination);
        view.forward(request, response);
    }
}
