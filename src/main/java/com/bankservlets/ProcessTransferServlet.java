package com.bankservlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.TransactionProcessDao;

@WebServlet("/ProcessTransferServlet")
public class ProcessTransferServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public ProcessTransferServlet() {
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
	    HttpSession httpSession = request.getSession();
	    String email = (String) httpSession.getAttribute("email");
	    int pin = (int) httpSession.getAttribute("pin");
	    int userId = (int) httpSession.getAttribute("userId");
	    
	    // Fetch recipientMobile and transferAmount parameters from the request
	    long recipentmobilenumber = Long.parseLong(request.getParameter("recipientMobile"));
	    double transferamount = Double.parseDouble(request.getParameter("transferAmount"));
	    
	    // Call DAO method for transfer logic
	    TransactionProcessDao transactionProcessDao = new TransactionProcessDao();
	    int result = transactionProcessDao.transferamountusingmobilenumber(email, pin, transferamount, recipentmobilenumber);
	    
	    // Forward based on result
	    if (result > 0) {
	        RequestDispatcher requestDispatcher = request.getRequestDispatcher("BalanceCheckServlet");
	        requestDispatcher.forward(request, response);
	    } else {
	        RequestDispatcher requestDispatcher = request.getRequestDispatcher("mobileNumberTransaction.jsp");
	        requestDispatcher.forward(request, response);
	    }
	}


}
