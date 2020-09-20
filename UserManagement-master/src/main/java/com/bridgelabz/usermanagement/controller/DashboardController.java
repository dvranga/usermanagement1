package com.bridgelabz.usermanagement.controller;

import com.bridgelabz.usermanagement.dao.DashboardDAO;
import com.bridgelabz.usermanagement.dao.UserListDAO;
import com.bridgelabz.usermanagement.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

public class DashboardController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        session.setAttribute("totalUsers", DashboardDAO.getNoRecords());
        session.setAttribute("activeusers", DashboardDAO.getActiveRecords());
        session.setAttribute("inactiveUsers", DashboardDAO.getInActiveRecords());
        session.setAttribute("toplocations", DashboardDAO.getTopLocations());
        session.setAttribute("malePercentage", DashboardDAO.getMalePercentage());
        session.setAttribute("femalePercentage", DashboardDAO.getFemalePercentage());
        ArrayList<User> listOfUsers = UserListDAO.getUserList();
        session.setAttribute("listOfUsers", listOfUsers);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("dashboard");
        requestDispatcher.forward(request,response);
    }
}

