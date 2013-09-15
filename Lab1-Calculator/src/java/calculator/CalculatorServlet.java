/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Samira El-Rayyes 6439366
 */
@WebServlet(name = "CalculatorServlet", urlPatterns = {"/calculate"})
public class CalculatorServlet extends HttpServlet {

    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods. 
     * @param request servlet request
     * @param response servlet response
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF­8");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Calculator response</title>");
        out.println("</head>");
        out.println("<body>");
        String sfirst = request.getParameter("First");
        String ssecond = request.getParameter("Second");
        try {
            double firstn = Double.parseDouble(sfirst);
            double secondn = Double.parseDouble(ssecond);
            double result = 0;
            if (request.getParameter("add") != null) {
                result = firstn + secondn;
            } else if (request.getParameter("subtract") != null) {
                result = firstn - secondn;
            } else if (request.getParameter("multiply") != null) {
                result = firstn * secondn;
            } else if (request.getParameter("divide") != null) {
                result = firstn / secondn;
            }
            out.println("<h1>Result is: " + result + "</h1>");
        } catch (Exception e) {
            out.println("<h1>Wrong parameter types ­ enter numbers</h1>");
        }
        out.println("</body>");
        out.println("</html>"); /* */
        out.close();
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
