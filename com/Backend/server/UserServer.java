package com.Backend.server;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/UserServer")
public class UserServer extends HttpServlet {
    private  static final  long serialVersionUID = 1L;
    private userInterfaceImplementation userInterface;
    @Override
    public void init() {
        userInterface = new userInterfaceImplementation();
    }

    @Override
    protected void doGET(HttpServletRequest request , HttpServletResponse response) throws IOException , ServletException{
        response.setHeader("Access-Control-Allow-Origin","*");
        response.addHeader("Access-Control-Allow-Methods","GET");

        PrintWriter outwriter = response.getWriter();
        List<User>  userData = userInterface.getAllUserData();

        Gson gson = new Gson();
        String JSONResponseUserData = gson.toJSON(userData);

        response.setContentType("application/json");
        writer.append(JSONResponseUserData);
    }

}
