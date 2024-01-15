package com.Backend.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Backend.DaoImplementation.productInterfaceImplementation;
import com.Backend.model.Product;
import com.google.gson.Gson;


@WebServlet("/ProductsServer")
public class ProductServer extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private productInterfaceImplementation productInterface;

    @Override
    public void init() {
        productInterface = new productInterfaceImplementation();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Methods", "GET");

        PrintWriter writer = response.getWriter();
        List<Product> productData = productInterface.getAllProducts();

        Gson gon = new Gson();
        String JSONResponseUserData = gon.toJson(productData);

        response.setContentType("application/json");
        writer.append(JSONResponseUserData);
    }
    
}
