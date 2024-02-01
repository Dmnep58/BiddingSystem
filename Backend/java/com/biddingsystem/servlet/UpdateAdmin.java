package com.biddingsystem.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DataInfoImpl.Datainfo;
import DataInfoImpl.PasswordHashing;

/**
 * Servlet implementation class UpdateAdmin
 */
@WebServlet("/UpdateAdmin")
public class UpdateAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	Datainfo datainfo;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }
    
 


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = null;
		String id =request.getParameter("id");
		String password = request.getParameter("password");
		String newpassword = request.getParameter("newpassword");
		String confirmnewpassword = request.getParameter("confirmnewpassword");
		String action = request.getParameter("action");
		
		
		datainfo = new Datainfo();
//		boolean t = false;
		
		switch(action) {
		
		case "seller":
			String string1 =(datainfo.match(datainfo.fetchSellerpassword(Integer.parseInt(id)),PasswordHashing.hashpassword(password)) == false) ? "Old password didnt matched":(datainfo.match(newpassword, confirmnewpassword)==true) ? "pass" :"Password misMatched"; 
			if("pass".equals(string1)) {
				 datainfo.UpdateSellerpass(PasswordHashing.hashpassword(newpassword), id);
				 request.setAttribute("message","Seller Password Updation success");
			}
			else {
				request.setAttribute("message", string1);
			}
			
			dispatcher = request.getRequestDispatcher("UpdateAdmin.jsp");
	        dispatcher.forward(request, response);
			break;
			
		case "bidder":
			String string2 =(datainfo.match(datainfo.fetchBidderspassword(Integer.parseInt(id)),PasswordHashing.hashpassword(password)) == false) ? "Old password didnt matched":(datainfo.match(newpassword, confirmnewpassword)==true) ? "pass" :"Password misMatched"; 
			if("pass".equals(string2)) {
				 datainfo.UpdateBidderpass(PasswordHashing.hashpassword(newpassword), id);
				 request.setAttribute("message","Bidder Password Updation success");
			}
			else {
				request.setAttribute("message", string2);
			}
			
			dispatcher = request.getRequestDispatcher("UpdateAdmin.jsp");
	        dispatcher.forward(request, response);
			break;
			
		default:
		String string =(datainfo.match(datainfo.fetchpassword(id),PasswordHashing.hashpassword(password)) == false) ? "Old password didnt matched":(datainfo.match(newpassword, confirmnewpassword)==true) ? "pass" :"Password misMatched"; 
		if("pass".equals(string)) {
			 datainfo.Updatepass(PasswordHashing.hashpassword(newpassword), id);
			 request.setAttribute("message","Admin Password Updation success");
		}
		else {
			request.setAttribute("message", string);
		}
		
		dispatcher = request.getRequestDispatcher("UpdateAdmin.jsp");
        dispatcher.forward(request, response);
		
	}
		
	}

}
