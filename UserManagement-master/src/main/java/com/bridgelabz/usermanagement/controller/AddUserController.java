package com.bridgelabz.usermanagement.controller;

import com.bridgelabz.usermanagement.dao.AddUserDAO;
import com.bridgelabz.usermanagement.dao.UpdateUserDAO;
import com.bridgelabz.usermanagement.logs.LoggerConfiguration;
import com.bridgelabz.usermanagement.model.Permissions;
import com.bridgelabz.usermanagement.model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;

@MultipartConfig
public class AddUserController extends HttpServlet {

    private static Logger logger = LogManager.getLogger(LoggerConfiguration.class);


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession httpSession=request.getSession();
        User admin = (User) httpSession.getAttribute("user");
        response.setContentType("text/html");
        String firstName=request.getParameter("firstName");
        System.out.println(firstName+" firstname");
        String middleName=request.getParameter("middleName");
        String lastName=request.getParameter("lastName");
        String date=request.getParameter("dateOfBirth");
        Date dateOfBirth=Date.valueOf(date);
        String gender=request.getParameter("gender");
        String country=request.getParameter("country");
        Long mobileNumber=Long.parseLong(request.getParameter("phone"));
        Long parentsNumber=Long.parseLong(request.getParameter("phone_Ext"));
        String email=request.getParameter("email");
        String address=request.getParameter("address");
        int role= Integer.parseInt(request.getParameter("userRole"));
        String userName=request.getParameter("userName");
        String password=request.getParameter("password");
        Part filePart=request.getPart("new-user-profile-image");
        InputStream imageStream=null;String userImage=null;
        if(filePart.getSize()==0){
            imageStream=new FileInputStream("C:\\Users\\Heros\\Desktop\\usermanagement\\New folder\\UserManagement-master\\src\\main\\webapp\\images\\profile_image.jpeg");
        }
        else {
            imageStream = filePart.getInputStream();
        }
        User user=new User(firstName, middleName, lastName, dateOfBirth, gender, country, mobileNumber, parentsNumber,
                email, address, role, userName, password, userImage);

        boolean dashboardAdd= (request.getParameter("dashboard_add")!=null)?true:false;
        boolean dashboardDelete= (request.getParameter("dashboard_delete")!=null)?true:false;
        boolean dashboardModify=(request.getParameter("dashboard_modify")!=null)?true:false;
        boolean dashboardRead=(request.getParameter("dashboard_read")!=null)?true:false;
        boolean settingsAdd=(request.getParameter("settings_add")!=null)?true:false;
        boolean settingsDelete =(request.getParameter("settings_delete")!=null)?true:false;
        boolean settingsModify=(request.getParameter("settings_modify")!=null)?true:false;
        boolean settingsRead=(request.getParameter("settings_read")!=null)?true:false;
        boolean userInfoAdd=(request.getParameter("user_info_add")!=null)?true:false;
        boolean userInfoDelete =(request.getParameter("user_info_delete")!=null)?true:false;
        boolean userInfoModify=(request.getParameter("user_info_modify")!=null)?true:false;
        boolean userInfoRead=(request.getParameter("user_info_read")!=null)?true:false;
        boolean w1Add=(request.getParameter("w1_add")!=null)?true:false;
        boolean w1Delete=(request.getParameter("w1_delete")!=null)?true:false;
        boolean w1Modify=(request.getParameter("w1_modify")!=null)?true:false;
        boolean w1Read =(request.getParameter("w1_read")!=null)?true:false;
        boolean w2Add =(request.getParameter("w2_add")!=null)?true:false;
        boolean w2Delete=(request.getParameter("w2_delete")!=null)?true:false;
        boolean w2Modify=(request.getParameter("w2_modify")!=null)?true:false;
        boolean w2Read=(request.getParameter("w2_read")!=null)?true:false;
        boolean w3Add =(request.getParameter("w3_add")!=null)?true:false;
        boolean w3Delete=(request.getParameter("w3_delete")!=null)?true:false;
        boolean w3Modify=(request.getParameter("w3_modify")!=null)?true:false;
        boolean w3Read=(request.getParameter("w3_read")!=null)?true:false;

        Permissions permissions=new Permissions(dashboardAdd, dashboardDelete, dashboardModify, dashboardRead, settingsAdd, settingsDelete, settingsModify,
                settingsRead, userInfoAdd, userInfoDelete, userInfoModify, userInfoRead,
                w1Add, w1Delete, w1Modify, w1Read, w2Add, w2Delete, w2Modify, w2Read, w3Add, w3Delete, w3Modify, w3Read);

        AddUserDAO addUserDao=new AddUserDAO();
        int userId=0;
        if(addUserDao.addUser(user, imageStream, admin.getUserName() )){
            logger.info(" this is user added information message ");
            userId=addUserDao.getUserId(userName);
        }else {
            logger.error("this is an error message");
            System.out.println("failed");
        }
        addUserDao.addPermissions(userId, 1, permissions.isDashboardAdd(), permissions.isDashboardDelete(), permissions.isDashboardModify(), permissions.isDashboardRead());
        addUserDao.addPermissions(userId, 2, permissions.isSettingsAdd(), permissions.isSettingsDelete(), permissions.isSettingsModify(), permissions.isSettingsRead());
        addUserDao.addPermissions(userId, 3, permissions.isUserInformationAdd(), permissions.isUserInformationDelete(), permissions.isUserInformationModify(), permissions.isUserInformationRead());
        addUserDao.addPermissions(userId, 4, permissions.isWebPage1Add(), permissions.isWebPage1Delete(), permissions.isWenPage1Modify(), permissions.isWebPage1Read());
        addUserDao.addPermissions(userId, 5, permissions.isWebPage2Add(), permissions.isWebPage2Delete(), permissions.isWenPage2Modify(), permissions.isWebPage2Read());
        addUserDao.addPermissions(userId, 6, permissions.isWebPage3Add(), permissions.isWebPage3Delete(), permissions.isWenPage3Modify(), permissions.isWebPage3Read());
        RequestDispatcher rd=request.getRequestDispatcher("newUser");
        rd.include(request,response);
    }
}
