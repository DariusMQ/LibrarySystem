package com.example.librarysystem.Servlets;

import com.example.librarysystem.common.UserDto;
import com.example.librarysystem.ejb.UsersBean;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.Arrays;

@ServletSecurity(value = @HttpConstraint(rolesAllowed = {"WRITE_PROFILE"}))
@WebServlet(name = "EditProfile", value = "/EditProfile")
public class EditProfile extends HttpServlet {

    @Inject
    UsersBean usersBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long userId = Long.parseLong(request.getParameter("id"));
        UserDto user = usersBean.findUserById(userId);
        request.setAttribute("user",user);
        request.getRequestDispatcher("/WEB-INF/pages/editProfile.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long userId = Long.parseLong(request.getParameter("userId"));
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        usersBean.updateUser(userId,username,email,password);
        response.sendRedirect(request.getContextPath()+"/Profile");
    }
}