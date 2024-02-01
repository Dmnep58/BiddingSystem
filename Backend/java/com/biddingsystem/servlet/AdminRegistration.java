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
 * Servlet implementation class AdminRegistration
 */
@WebServlet("/AdminRegistration")
public class AdminRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminRegistration() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		 RequestDispatcher dispatcher = null;
	        Connection conn = null;
		//retrieve data
	    String name = request.getParameter("email");
        String nic = request.getParameter("nic");
        String contact = request.getParameter("contact");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
       

        
        if(CheckDupliacteData.isAdminPresent(Long.parseLong(contact))) {
        	request.setAttribute("message", "User Already Present");
        }
        
        else {
        try {
        	  // Insert the bidder into the database
            conn = DBConnect.getConnection();
            String sql = "INSERT INTO admin (Adminemail, AdminTelephone, AdminNIC, Adminusername,Adminpassword) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, name);
            statement.setString(2, contact);
            statement.setString(3, nic);
            statement.setString(4, username);
            statement.setString(5, PasswordHashing.hashpassword(password));

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
        
        dispatcher = request.getRequestDispatcher("AdminRegistration.jsp");
        dispatcher.forward(request, response);
	}

}
