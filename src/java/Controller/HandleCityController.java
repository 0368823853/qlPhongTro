/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import DAO.City;
import Model.HandleCity;
import jakarta.servlet.RequestDispatcher;
/**
 *
 * @author Nguyen Khanh
 */
@WebServlet(name="HandleCityController", urlPatterns={"/HandleCityController"})
public class HandleCityController extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HandleCityController</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HandleCityController at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
      
        try {
              ArrayList<City> data = new ArrayList<City>();
            HandleCity ModelCity = new HandleCity();
    
            data = ModelCity.getAllProduct();
             request.setAttribute("data", data);
             
              String editId = request.getParameter("editId");
            if (editId != null) {
                City cityToEdit = ModelCity.getCityById(editId);
                request.setAttribute("editCity", cityToEdit);
            }
             
            RequestDispatcher dispatcher =  request.getRequestDispatcher("/WEB-INF/cityshow.jsp");
            dispatcher.forward(request, response);
        }catch(Exception ex) {
            System.out.println("LOI CONTROLLER");
        }
        
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        HandleCity create = new HandleCity();
        int ID = request.getIntHeader("id");
        String Hoten = request.getParameter("hoten");
        String Email = request.getParameter("email");
        String Diachi = request.getParameter("diachi");
        String Toan = request.getParameter("toan");
        String Van = request.getParameter("van");
        String Anh = request.getParameter("anh");
           City city = new City(ID, Hoten, Email, Diachi, Toan, Van, Anh);
        if (request.getParameter("edit") != null) {
                create.update(city);
            } else {
                create.insert(city);
            }
       response.sendRedirect("HandleCityController");
        
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
