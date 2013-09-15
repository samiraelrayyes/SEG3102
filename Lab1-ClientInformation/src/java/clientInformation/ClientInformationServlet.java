/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clientInformation;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Samira El-Rayyes 6439366
 */
public class ClientInformationServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF­8");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Client Information: Result</title>");
        out.println("</head>");
        out.println("<body>");

        String sFirstName = request.getParameter("FirstName");
        String sSurname = request.getParameter("Surname");
        String sAge = request.getParameter("Age");
        String sGender = request.getParameter("Gender");
        boolean isValid = true;
        String s = "";

        sFirstName = sFirstName.toLowerCase();
        for (int i = 0; i < sFirstName.length(); i++) {
            s = sFirstName.charAt(i) + "";
            if (!s.matches("[abcdefghijklmnopqrstuvwxyz]*")) {
                isValid = false;
                out.println("<h1>Client Information is invalid: First Name must contain only letters.</h1>");
                break;
            }
        }

        if (isValid) {
            sSurname = sSurname.toLowerCase();
            for (int i = 0; i < sSurname.length(); i++) {
                s = sSurname.charAt(i) + "";
                if (!s.matches("[abcdefghijklmnopqrstuvwxyz]*")) {
                    isValid = false;
                    out.println("<h1>Client Information is invalid: Surname must contain only letters.</h1>");
                    break;
                }
            }
        }

        if (isValid) {
            try {
                int age = Integer.parseInt(sAge);

                if (age < 0 || age > 120) {
                    isValid = false;
                    out.println("<h1>Client Information is invalid: Age must be between 0 and 120.</h1>");
                }
            } catch (Exception e) {
                isValid = false;
                out.println("<h1>Client Information is invalid: Age must be between 0 and 120.</h1>");
            }
        }

        if (isValid) {
            if (sGender != "M" && sGender != "F") {
                isValid = false;
                out.println("<h1>Client Information is invalid: Enter M or F for Gender.</h1>");
            }
        }

        if (isValid) {
            out.println("<h1>Client Information is invalid: Enter M or F for Gender.</h1>");
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
