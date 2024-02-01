package com.biddingsystem.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.biddingsystem.utill.DBConnect;

import DataInfoImpl.CheckDupliacteData;
import DataInfoImpl.PasswordHashing;


/**
 * Servlet implementation class TransactionServlet
 */
@WebServlet("/transactionservlet")
public class TransactionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

       
	 public TransactionServlet() {
	        super();
	    }
	 

	    @Override
	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {

	    	String sname = request.getParameter("name");
	        String scontact = request.getParameter("contact");
	        String saddress = request.getParameter("address");
	        String semail = request.getParameter("email");
	        String spassword = request.getParameter("password");
	        
	       
	        
	        RequestDispatcher dispatcher = null;
	        Connection conn = null;

	        
	        if(CheckDupliacteData.isSellerPresent(semail) == true) {
	        	request.setAttribute("message", "User Already Present");
	        }
	        else {

	        try {
	            // Insert the seller into the database
	            conn = DBConnect.getConnection();
	            String sql = "INSERT INTO sellers (sname, scontact, saddress, semail, spassword) VALUES (?, ?, ?, ?, ?)";
	            PreparedStatement statement = conn.prepareStatement(sql);

	            statement.setString(1, sname);
	            statement.setString(2, scontact);
	            statement.setString(3, saddress);
	            statement.setString(4, semail);
	            statement.setString(5, PasswordHashing.hashpassword(spassword));

	            int rowsInserted = statement.executeUpdate();
	            
	            if (rowsInserted > 0) {
	                request.setAttribute("message", "Your account has been created");
	                
	            } else {
	                request.setAttribute("message", "Your request has failed");
	            }

	         
	            
	            statement.close();
	            conn.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        
	        }
	        dispatcher = request.getRequestDispatcher("transaction.jsp");
	        dispatcher.forward(request, response);

	           
			
				
	    }
	}
