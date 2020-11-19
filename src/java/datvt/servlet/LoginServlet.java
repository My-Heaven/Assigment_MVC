/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datvt.servlet;

import datvt.tbluser.tblUserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Tan DaT
 */
public class LoginServlet extends HttpServlet {

    private final String SEARCH_PAGE = "searchP";
    private final String INVALID_PAGE = "invalid";

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
        String url = INVALID_PAGE;
//        String button = request.getParameter("btAction");
        try {
//            if (button.equals("Login")) {
                String username = request.getParameter("txtusername");
                String password = request.getParameter("txtpassword");
                tblUserDAO dao = new tblUserDAO();
                String fullname = dao.checkLogin(username, password);
                if (fullname != null ) {
                    
                    url = SEARCH_PAGE;
                    
                    Cookie cookie = new Cookie(username, password);
                    cookie.setMaxAge(60*5);
                    response.addCookie(cookie);
                    
                      HttpSession session = request.getSession();
                      session.setAttribute("USERNAME", username);
                      
//                    HttpSession session = request.getSession();
                      session.setAttribute("FULLNAME", fullname);
//                }
            }//end if butin is login
        } catch (SQLException ex) {
            log("SQL Exception: " + ex.getMessage());
        } catch (NamingException ex) {
            log("Naming Exception: " + ex.getMessage());
        } finally {
            response.sendRedirect(url);
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
