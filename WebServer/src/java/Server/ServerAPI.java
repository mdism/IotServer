/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mdism
 */
public class ServerAPI extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Register</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Welcome</h1>");
            String name = request.getParameter("name");
            String pass = request.getParameter("password");
            String company = request.getParameter("company");
            String mobile = request.getParameter("mobile");
            String email = request.getParameter("email");
            String address = request.getParameter("address");
            String deviceid = request.getParameter("deviceid");
//            if ((name.isEmpty() && pass.isEmpty() && company.isEmpty()
//                    && mobile.isEmpty() && email.isEmpty() && address.isEmpty() && deviceid.isEmpty())) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/user?zeroDateTimeBehavior=convertToNull", "root", "");
//                    java.sql.Statement st = conn.createStatement();
////                    String qStr = "insert into `user` values(null, `" + name + "`,`" + pass + "`,`" + 
////                            company + "`,`" + mobile + "`,`" + email + "`,`" + address + "`,`" + deviceid + "`);";
//                        String sql = "INSERT INTO `user` (user_name, pass, company, mobile, email, address, deviceid) VALUES ('q', 'a', 's', 's', 's', 's', 's')";
//                    ResultSet rs = st.executeQuery(sql);
                PreparedStatement ps = conn.prepareStatement("insert into user values(?,?,?,?,?,?,?,?)");
                ps.setString(1, null);
                ps.setString(2, name);
                ps.setString(3, pass);
                ps.setString(4, company);
                ps.setString(5, mobile);
                ps.setString(6, email);
                ps.setString(7, address);
                ps.setString(8, deviceid);

                int i = ps.executeUpdate();
                if (i > 0) {
                    out.println("<p>Added Data</p>");
                }
            } catch (ClassNotFoundException | SQLException e) {
                out.println("Error: " + e);
            }
//            }

            out.println("<a href=AddDevice.jsp><P>Go Back</p> </a>");
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
