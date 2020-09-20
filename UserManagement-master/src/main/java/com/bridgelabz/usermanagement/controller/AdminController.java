package com.bridgelabz.usermanagement.controller;


import com.bridgelabz.usermanagement.logs.LoggerConfiguration;
import com.bridgelabz.usermanagement.dao.*;
import com.bridgelabz.usermanagement.model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class AdminController extends HttpServlet {

    private static Logger logger = LogManager.getLogger(LoggerConfiguration.class);


    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String name = request.getParameter("username");

        String password = request.getParameter("password");

        HttpSession session = request.getSession(true);
        User user=null;
        user = LoginDAO.validate(name, password);
        if (user != null) {
            logger.info(" this is information message ");
            user.setLoginAttempts(0);
            UpdateUserDAO updateUserDAO=new UpdateUserDAO();
            try {
                updateUserDAO.setStatus(name,true);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            ArrayList dashboardpermission = LoginDAO.getPermissions(user.getUser_id(), 1);
            ArrayList settingpermission = LoginDAO.getPermissions(user.getUser_id(), 2);
            ArrayList userpermission = LoginDAO.getPermissions(user.getUser_id(), 3);
            ArrayList webpage1 = LoginDAO.getPermissions(user.getUser_id(), 4);
            ArrayList webpage2 = LoginDAO.getPermissions(user.getUser_id(), 5);
            ArrayList webpage3 = LoginDAO.getPermissions(user.getUser_id(), 6);
            session.setAttribute("user",user);
            request.setAttribute("userRole", user.getRoleId());
            session.setAttribute("username",user.getUserName());
            session.setAttribute("webpage1", webpage1);
            session.setAttribute("webpage2", webpage2);
            session.setAttribute("webpage3", webpage3);
            session.setAttribute("dashboardpermission",dashboardpermission);
            session.setAttribute("settingpermission",settingpermission);
            session.setAttribute("userpermission",userpermission);
            session.setAttribute("totalUsers", DashboardDAO.getNoRecords());
            session.setAttribute("activeusers", DashboardDAO.getActiveRecords());
            session.setAttribute("inactiveUsers", DashboardDAO.getInActiveRecords());
            session.setAttribute("toplocations", DashboardDAO.getTopLocations());
            session.setAttribute("malePercentage", DashboardDAO.getMalePercentage());
            session.setAttribute("femalePercentage", DashboardDAO.getFemalePercentage());
            try {
                session.setAttribute("lastLoginDetails",DashboardDAO.getLastLoggedInDetails(user.getUser_id()));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            session.setAttribute("ageGroup", AgeGroupData.getAgedata());
            ArrayList<User> listOfUsers = UserListDAO.getUserList();
            session.setAttribute("listOfUsers", listOfUsers);
            session.setAttribute("registrationDetails",RegistrationGraphDetails.AllTimeRegistration());
            session.setAttribute("registerMonthDetails",RegistrationGraphDetails.getMonthWise());
            session.setAttribute("registerYearDetails",RegistrationGraphDetails.getYearWise());
            session.setAttribute("yearLabels",RegistrationGraphDetails.getLabel("year"));
            session.setAttribute("monthLables",RegistrationGraphDetails.getLabel("month"));
            session.setAttribute("allTimeLables",RegistrationGraphDetails.getLabel("allTime"));

            if(user.getRoleId()==1){
                logger.info(" this is admin login message");
                RequestDispatcher rd=request.getRequestDispatcher("dashboard");
                rd.forward(request,response);
            }
            else if (user.getRoleId()==0){
                logger.info(" this is user login message");
                RequestDispatcher rd=request.getRequestDispatcher("userProfile");
                rd.forward(request,response);
            }
        }

        else{
            logger.error("this is an error message");
            UpdateUserDAO updateUserDAO=new UpdateUserDAO();
            LogoutDAO.updateLoginAttempts(name);
            if (LogoutDAO.getLoginAttempts(name)>=3) {
                try {
                    updateUserDAO.setStatus(name,false);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
            RequestDispatcher rd=request.getRequestDispatcher("login");
            rd.include(request,response);
        }
        out.close();
    }
}
