package com.Backend.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Backend.DaoImplementation.userInterfaceImplementation;
import com.Backend.model.User;
import com.google.gson.Gson;

@WebServlet("/UserServer")
public class UserServer extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private userInterfaceImplementation userInterface;

    @Override
    public void init() {
        userInterface = new userInterfaceImplementation();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Methods", "GET");

        PrintWriter writer = response.getWriter();
        List<User> userData = userInterface.getAllUserData();

        Gson gon = new Gson();
        String JSONResponseUserData = gon.toJson(userData);

        response.setContentType("application/json");
        writer.append(JSONResponseUserData);
    }

}
