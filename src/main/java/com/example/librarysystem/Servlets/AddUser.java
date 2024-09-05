package com.example.librarysystem.Servlets;

import com.example.librarysystem.ejb.UsersBean;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.Arrays;

@ServletSecurity(value = @HttpConstraint(rolesAllowed = {"WRITE_USERS"}))
@WebServlet(name = "AddUser", value = "/AddUser")
public class AddUser extends HttpServlet {

    @Inject
    UsersBean usersBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("usergroups",new String[] {"READ_BOOKS","WRITE_BOOKS","READ_USERS","WRITE_USERS",
                                                              "READ_BORROWED_BOOKS","WRITE_BORROWED_BOOKS",
                                                              "READ_RETURNED_BOOKS","WRITE_RETURNED_BOOKS",
                                                              "READ_PROFILE","WRITE_PROFILE"});
        request.getRequestDispatcher("/WEB-INF/pages/addUser.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String[] userGroups = request.getParameterValues("user_groups");
        if(userGroups == null){
            userGroups = new String[0];
        }
        usersBean.createUser(username,email,password, Arrays.asList(userGroups));
        response.sendRedirect(request.getContextPath()+"/Users");
    }
}