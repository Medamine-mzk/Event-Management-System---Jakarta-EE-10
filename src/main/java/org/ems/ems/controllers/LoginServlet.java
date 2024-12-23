package org.ems.ems.controllers;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.ems.ems.models.User;
import org.ems.ems.services.UserService;

import java.io.IOException;

@WebServlet ("/login")
public class LoginServlet extends HttpServlet {

    @Inject
    private UserService userService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Forward to login.jsp
        request.getRequestDispatcher("/views/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User user = userService.getAllUsers().stream()
                .filter(u -> u.getEmail().equals(email) && u.getPassword().equals(password))
                .findFirst()
                .orElse(null);

        if (user != null) {
            // Save user in session
            request.getSession().setAttribute("loggedInUser", user);
            response.sendRedirect("events");
        } else {
            response.sendRedirect("login?error=Invalid+credentials");
        }
    }
}
