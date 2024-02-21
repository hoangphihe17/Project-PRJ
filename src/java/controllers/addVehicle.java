/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controllers;

import dal.VehicleDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.List;
import models.Category;
import models.Vehicle;

/**
 *
 * @author duong
 */
public class addVehicle extends HttpServlet {

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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet addVehicle</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet addVehicle at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
         VehicleDao dao = new VehicleDao();
            List<Category> listC = dao.getListCategory();
            request.setAttribute("listC", listC);
       request.getRequestDispatcher("addVehicle.jsp").forward(request, response);
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
        String name = request.getParameter("Name");
        String licensePlate = request.getParameter("LicensePlate");
        String statusStr = request.getParameter("Status");
        int status = Integer.parseInt(statusStr); 
//
        String cateIdStr = request.getParameter("cateId");
        int cateId = Integer.parseInt(cateIdStr); 
//
        String rentalPriceStr = request.getParameter("RentalPrice");
        BigDecimal rentalPrice = new BigDecimal(rentalPriceStr);
        Vehicle newVehicle = new Vehicle( name, licensePlate, status, cateId, rentalPrice);
        VehicleDao dao = new VehicleDao();
        PrintWriter out = response.getWriter();
        out.print(name);
        out.print(licensePlate);
        out.print(statusStr);
        out.print(status);
        out.print(cateId);
        out.print(rentalPrice);
        boolean isS = dao.addVehicle(newVehicle);
        if(isS){
            response.sendRedirect("vehicle");
        }else{
            request.getRequestDispatcher("home.jsp").forward(request, response);
        }
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
