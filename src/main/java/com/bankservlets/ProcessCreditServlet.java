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

/**
 * Servlet implementation class ProcessCreditServlet
 */
@WebServlet("/ProcessCreditServlet")
public class ProcessCreditServlet extends HttpServlet {
	 
	private static final long serialVersionUID = 1L;
       
  
    public ProcessCreditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TransactionProcessDao transactionProcessDao=new TransactionProcessDao();
		
		HttpSession session=request.getSession();
		String email=(String) session.getAttribute("email");
		int pin=(int) session.getAttribute("pin");
		double amount=Double.parseDouble(request.getParameter("transactionAmount"));
		int userId=(int) session.getAttribute("userId");
		int result=transactionProcessDao.creditProcess(email, pin, amount);
		if(result>0) {
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("BalanceCheckServlet");
			requestDispatcher.forward(request, response);
		}
		else {
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("userCredit.jsp");
			requestDispatcher.forward(request, response);
		}
		
		
	}

}
