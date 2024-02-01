package com.biddingsystem.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DataInfoImpl.Datainfo;

/**
 * Servlet implementation class allotment
 */
@WebServlet("/allotment")
public class allotment extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public allotment() {
        super();
        // TODO Auto-generated constructor stub
    }


@Override
public void init() throws ServletException {
	// TODO Auto-generated method stub
	super.init();
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id =Integer.valueOf(request.getParameter("id"));
		Datainfo datainfo = new Datainfo();
		boolean f = datainfo.allotment(id);
		
		if(f)  {
			response.sendRedirect("ProductAllotment.jsp");
		}
		else {	
			response.sendRedirect("ProductAllotment.jsp");
		}
	}

	

}
