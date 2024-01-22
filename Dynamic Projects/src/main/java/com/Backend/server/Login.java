package com.Backend.server;

import java.io.IOException;
import java.io.PrintWriter;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Backend.DaoImplementation.userInterfaceImplementation;
import com.google.gson.Gson;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    userInterfaceImplementation userInterfaceImpl;
    
    public Login() {
        super();
    }
    
    public void init(){
    	userInterfaceImpl = new userInterfaceImplementation();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
	}
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String password = request.getParameter("Password");
		String action = request.getParameter("role");
		
		boolean loggedIn = false;
		
		switch (action) {
		case "seller":
			
			break;
		
		case "user":
			loggedIn = (userInterfaceImpl.isvalidUser(Long.parseLong(id), password)) ? true : false;
			break;
			
		default:
			id="";
			password="";
			action ="";
		}
		
		PrintWriter writer = response.getWriter();
		Gson gon = new Gson();
        String JSONResponseUserData = gon.toJson(loggedIn + "looged in");

        response.setContentType("application/json");
        writer.append(JSONResponseUserData);
		
	}

}
