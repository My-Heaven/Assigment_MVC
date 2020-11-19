/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datvt.servlet;

import com.sun.javafx.css.StyleManager;
import datvt.tbluser.tblItemCreateError;
import datvt.tbluser.tblUserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Tan DaT
 */
public class CreateNewAccountServlet extends HttpServlet {
private final String EORROR_PAGE="createNewAccountE";
private final String LOGIN_PAGE="loginP";
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
            String username = request.getParameter("txtusername");
            String password = request.getParameter("txtpassword");
            String confirm = request.getParameter("txtconfirm");
            String fullname = request.getParameter("txtfullname");
            
            
            tblItemCreateError errors = new tblItemCreateError();
            String url = EORROR_PAGE;
        try{
            //1. Check validate of 4 users
            boolean foundErr = false;
            if(username.trim().length()< 6 || username.trim().length() > 30){
                foundErr = true;
                errors.setUsernameLengError("Username requires typing from 6 to 30 chars");
            }
            if(password.trim().length()< 6 || password.trim().length() > 30){
                foundErr = true;
                errors.setPasswordLengError("Password requires typing from 6 to 20 chars");
            }else if(!password.trim().equals(confirm.trim())){
                foundErr = true;
                errors.setConfirmNotMatched("Confirm must match password");
            }
            if(fullname.trim().length()< 2 || fullname.trim().length() > 50){
                foundErr = true;
                errors.setFullnameLengError("Fullname requires typing from 2 to 50 chars");
            }
            if(foundErr){
                //2.1 store Errors into scope
                request.setAttribute("CREATEERR", errors);
            }else{
                //2.2 call DAO to insert to DB
                tblUserDAO dao = new tblUserDAO();
                boolean result= dao.createAccount(username, password, fullname, false);
                if(result){
                    url = LOGIN_PAGE;
                }
            }
        }catch(NamingException e){
            log("CreateNewAccountServlet _ Naming " + e.getMessage());
        }catch(SQLException e){
            String errMsg = e.getMessage();
            log("CreateNewAccountServlet _ SQL: " + errMsg );
            if(errMsg.contains("duplicate")){
                errors.setUsernameIsExisted(username + " is Existed!!");
                request.setAttribute("CREATEERR", errors);
            }
        }
        finally{
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
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
     * Handles the HTTP <code>POST</code> method.
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
