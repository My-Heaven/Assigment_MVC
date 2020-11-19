/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datvt.servlet;

import datvt.tbluser.tblUserDAO;
import datvt.tbluser.updateUserError;
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
public class UpdatePandRoleServlet extends HttpServlet {

//    private final String ERROR_UPDATE_PAGE = "error";
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
        String urlRewrite = "";
        String username = request.getParameter("txtUsername");
        String password = request.getParameter("txtPassword");
        String admin = request.getParameter("chkAdmin");
        String searchvalue = request.getParameter("lastSearchValue");
        boolean role = false;
        if (admin != null) {
            role = true;
        }
        updateUserError error = new updateUserError();
        try {

            boolean foundError = false;
            if (password.length() < 6 || password.length() > 30) {
                foundError = true;
                error.setPasswordLengError("Password leng must be 6 - 30");
            }
            if (foundError) {
                request.setAttribute("ERR", error);
                urlRewrite = urlRewrite = "search"
                            + "?"
                            + "txtSearch=" + searchvalue
                            //                        + "&txtSearch"
                            + "&btAction=Search";
                       
            }else{
                tblUserDAO dao = new tblUserDAO();
                boolean result = dao.update(username, password, role);
                if (result) {
                    urlRewrite = "search"
                            + "?"
                            + "txtSearch=" + searchvalue
                            //                        + "&txtSearch"
                            + "&btAction=Search";
                }
            }
        } catch (SQLException e) {
            log("SQL Exception: " + e.getMessage());
        } catch (NamingException e) {
            log("Naming Exception: " + e.getMessage());
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher(urlRewrite);
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
