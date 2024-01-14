package com.Backend.server;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/UserServer")
public class UserServer extends HttpServlet {
    private  static final  long serialVersionUID = 1L;
    private DaoI
    @Override
    public void init() {

    }

    @Override
    protected void doGET(HttpServletRequest request , HttpServletResponse response) throws IOException , ServletException{
        response.setHeader("Access-Control-Allow-Origin","*");
        response.addHeader("Access-Control-Allow-Methods","GET");

        PrintWriter outwriter = response.getWriter();

        String JSONResponseUserData =

    }

}
