package com.biddingsystem.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DataInfoImpl.Datainfo;


/**
 * Servlet implementation class SendEmails
 */
@WebServlet("/SendMessages")
public class SendMessages extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendMessages() {
        super();
    }
    

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		
		String id = (String) session.getAttribute("aid");
		
		if(id == null) {
			request.setAttribute("message", "login to send message");
		}
		
		else {
		
		String ids = request.getParameter("id");
		String name = request.getParameter("name");
		String message = request.getParameter("message");
		
		if(Datainfo.SendMessage(ids, name, message) == true){
			request.setAttribute("message", "message Sent Successfully");
		}
		else {
			request.setAttribute("message", "message Failure");
		}
		
		}
		request.getRequestDispatcher("contactus.jsp").forward(request, response);
		
	}


}
