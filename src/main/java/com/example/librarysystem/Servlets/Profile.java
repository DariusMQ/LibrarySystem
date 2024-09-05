package com.example.librarysystem.Servlets;

import com.example.librarysystem.common.Borrowed_BookDto;
import com.example.librarysystem.common.UserDto;
import com.example.librarysystem.ejb.UsersBean;
import jakarta.annotation.security.DeclareRoles;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@DeclareRoles({"READ_PROFILE","WRITE_PROFILE"})
@ServletSecurity(value = @HttpConstraint(rolesAllowed = {"READ_PROFILE"}),
        httpMethodConstraints = {@HttpMethodConstraint(value = "POST", rolesAllowed =
                {"WRITE_PROFILE"})})
@WebServlet(name = "Profile", value = "/Profile")
public class Profile extends HttpServlet {

    @Inject
    UsersBean usersBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDto user = usersBean.findUserByUsername(request.getRemoteUser());
        request.setAttribute("user",user);

        List<Borrowed_BookDto> books = usersBean.getUserBorrowedBooks(user.getUsername());
        request.setAttribute("books",books);

        request.getRequestDispatcher("/WEB-INF/pages/profile.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}