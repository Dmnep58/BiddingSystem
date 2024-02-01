package com.biddingsystem.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.biddingsystem.model.Products;
import com.biddingsystem.utill.DBConnect;

@WebServlet("/Addnewproduct")
@MultipartConfig(fileSizeThreshold=1024*1024*2, // 2MB
maxFileSize=1024*1024*10,      // 10MB
maxRequestSize=1024*1024*50)

public class Addnewproduct extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    private static final String SAVE_DIR="productimages";

    public Addnewproduct() {
        super();
    }
    

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
    	
        @SuppressWarnings("unused")
		PrintWriter out = response.getWriter();
        String savePath = "E:" +File.separator+"d"+File.separator+"nepbid"+File.separator+"src"+File.separator+"main"+File.separator
        		+"webapp"+File.separator+"assets"+File.separator+ SAVE_DIR;
            File fileSaveDir=new File(savePath);
            if(!fileSaveDir.exists()){
                fileSaveDir.mkdir();
            }
        
        // Retrieve form data
        String pname = request.getParameter("name");
        String productdescription = request.getParameter("description");
        String productcategory = request.getParameter("category");
        String starting_bp = request.getParameter("bidprice");
        String selleridString = request.getParameter("sellerid");
        Part part = request.getPart("image");

        
        String fileName=extractFileName(part);
        part.write(savePath + File.separator + fileName);
        RequestDispatcher dispatcher = null;
        Connection conn = null;

        // Create a Product object and set its properties
        Products p = new Products();
        p.setProductname(pname);
        p.setProductdescription(productdescription);
        p.setProductcategory(productcategory);
        p.setStarting_bp(starting_bp);
        p.setImage(fileName);
        p.setSellerid(Integer.valueOf(selleridString));

        try {
            // Insert the product into the database
            conn = DBConnect.getConnection();
            String sql = "INSERT INTO newproduct(productname,description,category,starting_bp,image,sellerid) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, p.getProductname());
            statement.setString(2, p.getProductdescription());
            statement.setString(3, p.getProductcategory());
            statement.setString(4, p.getStarting_bp());
            statement.setString(5, p.getImage());
            statement.setInt(6, p.getSellerid());

            int rowsInserted = statement.executeUpdate();

            if (rowsInserted > 0) {
                request.setAttribute("message", "New product has been added!");
            } else {
                request.setAttribute("message", "Product addition failed!");
            }

            statement.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        dispatcher = request.getRequestDispatcher("NewProduct.jsp");
        dispatcher.forward(request, response);
    }
    
    
    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length()-1);
            }
        }
        return "";
    }
}