package com.biddingsystem.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebServlet("/errorHandler")
public class ErrorHandlerServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int errorCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        
        String errorPage = determineErrorPage(errorCode, request);
        
        // Forward to the determined error page
        request.getRequestDispatcher(errorPage).forward(request, response);
    }

    private String determineErrorPage(int errorCode, HttpServletRequest request) {
        // Implement your logic to determine the error page based on user conditions and error code
        // You can use user roles, session attributes, or any other criteria
        String errorPage =""; // Default to common error page

        // Example logic for handling different error codes
        if (userHasPermission(request) && (errorCode == 404 || errorCode==405 || errorCode==500)) {
            errorPage = "ErrorPage.jsp";
        }
        return errorPage;
    }

    @SuppressWarnings("null")
	private boolean userHasPermission(HttpServletRequest request) {
    	 // Pass false to prevent creating a new session if it doesn't exist
        HttpSession session = request.getSession(false);

        // Check if the session is active (not null) and contains the necessary attributes.
        if (session != null) {
            // If a user role attribute exists, check its value to determine permissions
            String userRole = (String) session.getAttribute("userRole");
            
            if (userRole != null && (userRole.equals("admin") || userRole.equals("bidder") || userRole.equals("seller"))) {
                // User has permission
                return true;
            }
        }

        // If session is not active or user doesn't have permission
        return false;
    }

}
