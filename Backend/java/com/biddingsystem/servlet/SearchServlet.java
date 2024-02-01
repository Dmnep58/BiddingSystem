package com.biddingsystem.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.biddingsystem.model.Bid;

import DataInfoImpl.Datainfo;

import java.io.IOException;
import java.util.List;

@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public SearchServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String search = request.getParameter("search");	
		request.setAttribute("search",search);
		request.getRequestDispatcher("SearchPage.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        String searchTerm = request.getParameter("searchTerm");
        String id = request.getParameter("id");
        List<Bid> searchResults = Datainfo.searchBids(Integer.parseInt(id), searchTerm);
        request.setAttribute("bids", searchResults);
        request.getRequestDispatcher("BidItems.jsp").forward(request, response);
	
    }
}
