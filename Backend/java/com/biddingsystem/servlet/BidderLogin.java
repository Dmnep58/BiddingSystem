package com.biddingsystem.servlet;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DataInfoImpl.LoginData;

@WebServlet("/bidderlogin")
public class BidderLogin extends HttpServlet {
    private static final long serialVersionUID = 1L;
@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
	String email = request.getParameter("email");
	String password1 = request.getParameter("password");
	
	LoginData loginData = new LoginData();
	boolean isvaliduser = loginData.user(email, password1);

	RequestDispatcher dispatcher = null;
	
	if(isvaliduser == true) {
		 dispatcher = request.getRequestDispatcher("Customer.jsp");
	     dispatcher.forward(request, response);
	}
	else {
		 
		 email="";
		 password1="";
		 dispatcher = request.getRequestDispatcher("UserLogin.jsp");
		 dispatcher.forward(request, response);
	}
	
    }
}
