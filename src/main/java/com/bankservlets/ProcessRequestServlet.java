package com.bankservlets;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ProcessRequestDao;


@WebServlet("/ProcessRequestServlet")
public class ProcessRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProcessRequestDao processRequestDao =new ProcessRequestDao();
    
    public ProcessRequestServlet() {
      
    }
   

	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 int userId = Integer.parseInt(request.getParameter("userId"));
		 
	        String action = request.getParameter("action");

	        String status = action.equals("accept") ? "Approved" : "Rejected"; 
	        if(status.equals("Approved")){
	        Random random=new Random();
			int pin=random.nextInt(10000);
			if(pin<1000) {
				pin+=1000;
			}
			long account=random.nextLong();
			if(account<1000000) {
				account+=1000000;
			}
	        
	        
	    int result=  processRequestDao.requestProcess(userId, status,account,pin );
	    if(result>0) {
	    	System.out.println("Account number generated successfully......!");
	    }
	        }
	        else {
	        	System.out.println("Rejected.....");
	        }
	        
	}

}
