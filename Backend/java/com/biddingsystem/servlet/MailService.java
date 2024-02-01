package com.biddingsystem.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DataInfoImpl.Datainfo;
import DataInfoImpl.EmailSender;


/**
 * Servlet implementation class MailService
 */
@WebServlet("/	")
public class MailService extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public MailService() {
        super();

    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		
		String email = request.getParameter("email");

		Datainfo.Subsrcibe(email);

			String message= "Hello "+email+","+
                    "\n Your Regisstration Has been Done Successfully "+"\n"+
                    "Thank you for Registration\n\n"
                    +"\n Devi Prasad Mishra \n Dpm";
			
			String Subject = "Subscription";
			
			EmailSender.SendEmail(Subject, message, email);

			request.getRequestDispatcher("home.jsp").forward(request, response);

	}

}
