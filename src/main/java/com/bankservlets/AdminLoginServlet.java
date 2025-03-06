package com.bankservlets;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.model.BankUserRegisterDetails;

@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
    private static final String url = "jdbc:mysql://localhost:3306/magadhabank?user=root&password=9198";
    private static final String select = "select * from admindetails where admin_email=? and admin_password=?";
    private static final String selectPending = "select * from bankuserdetails where status='pending'";
    private static final long serialVersionUID = 1L;

    public AdminLoginServlet() {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        int password = Integer.parseInt(request.getParameter("password"));

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url);

           
            PreparedStatement adminStmt = connection.prepareStatement(select);
            adminStmt.setString(1, email);
            adminStmt.setInt(2, password);
            ResultSet adminResult = adminStmt.executeQuery();

            if (adminResult.next()) {
                
                PreparedStatement pendingStmt = connection.prepareStatement(selectPending);
                ResultSet pendingResult = pendingStmt.executeQuery();

                List<BankUserRegisterDetails> bankUserRegisterDetailsList = new ArrayList<>();
                while (pendingResult.next()) {
                    BankUserRegisterDetails details = new BankUserRegisterDetails();
                    details.setUserId(pendingResult.getInt("userId"));
                    details.setUserName(pendingResult.getString("user_Name"));
                    details.setAccountNumber(pendingResult.getLong("aadhar"));
                    details.setEmail(pendingResult.getString("email_Id"));
                    details.setMobile(pendingResult.getLong("mobile_number"));
                    details.setPannumber(pendingResult.getString("pan_number"));
                    details.setGender(pendingResult.getString("gender"));
                    details.setAddress(pendingResult.getString("address"));
                    bankUserRegisterDetailsList.add(details);
                }

               
                HttpSession session = request.getSession();
                session.setAttribute("email", email); 
                request.setAttribute("bankUserRegisterDetails", bankUserRegisterDetailsList); 

               
                RequestDispatcher dispatcher = request.getRequestDispatcher("adminDashboard.jsp");
                dispatcher.forward(request, response);
            } else {
                
                request.setAttribute("errorMessage", "Invalid credentials. Please try again.");
                request.getRequestDispatcher("adminLogin.jsp").forward(request, response);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
