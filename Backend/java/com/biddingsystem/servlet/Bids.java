package com.biddingsystem.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.biddingsystem.utill.DBConnect;
import DataInfoImpl.Datainfo;


/**
 * Servlet implementation class Bids
 */
@WebServlet("/Bids")
public class Bids extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Datainfo datainfo;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Bids() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    
		    int id = Integer.parseInt(request.getParameter("pid"));
			int bidderid = Integer.parseInt(request.getParameter("bidderid"));
			long bidamount = Integer.parseInt(request.getParameter("bidamount"));
			Datainfo.BIds(id, bidderid, bidamount);

			request.getRequestDispatcher("view.jsp").forward(request, response);
	}
	

}
