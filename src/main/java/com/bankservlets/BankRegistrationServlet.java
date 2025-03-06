package com.bankservlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.BankRegistrationDao;
import com.model.BankUserRegisterDetails;



@WebServlet("/BankRegistrationServlets")
public class BankRegistrationServlet extends HttpServlet {
	private BankRegistrationDao bankRegistrationDao=new BankRegistrationDao();
	private static final long serialVersionUID = 1L;
       
   
    public BankRegistrationServlet() {
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Registered succesfully..........");
		String name=request.getParameter("userName");
		String email=request.getParameter("emailId");
		long aadhar= Long.parseLong( request.getParameter("aadhar"));
		 long mobile= Long.parseLong( request.getParameter("mobileNumber"));
		 String panNumber  =request.getParameter("panNumber");
		  String    address=   request.getParameter("address");
		   String gender = request.getParameter("gender");
		   System.out.println("userName:"+name);
		   System.out.println("emailid:"+email);
		   
		   // set the values to setters 
		   BankUserRegisterDetails bankUserRegisterDetails=new BankUserRegisterDetails(name, email, aadhar, mobile, panNumber, address, 
				                                                          gender, gender, aadhar, mobile, 0);
		   
		   int result=bankRegistrationDao.registerUserDetails(bankUserRegisterDetails);
		   if(result>0) {
			   System.out.println("Registered successfully folks...");
			   RequestDispatcher requestDispatcher=request.getRequestDispatcher("userLogin.jsp");
			   requestDispatcher.forward(request, response);
		   }
		   else {
			   System.out.println("Not added to the database");
		   }
		
		
	}

}
