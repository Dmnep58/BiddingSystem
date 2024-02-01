package com.biddingsystem.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DataInfoImpl.Datainfo;

/**
 * Servlet implementation class NotAlloted
 */
@WebServlet("/NotAlloted")
public class NotAlloted extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NotAlloted() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id =Integer.valueOf(request.getParameter("ids"));
		Datainfo datainfo = new Datainfo();
		boolean f = datainfo.noallotment(id);
		
		if(f)  {
			response.sendRedirect("ProductAllotment.jsp");
		}
		else {
			
			response.sendRedirect("ProductAllotment.jsp");
		}
	}

}
