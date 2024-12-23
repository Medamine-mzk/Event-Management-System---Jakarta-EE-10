package org.ems.ems.controllers;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.ems.ems.models.Event;
import org.ems.ems.models.Registration;
import org.ems.ems.models.User;
import org.ems.ems.services.EventService;
import org.ems.ems.services.RegistrationService;
import org.ems.ems.services.UserService;

import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet("/event-register")
public class EventRegisterServlet extends HttpServlet {

    @Inject
    private RegistrationService registrationService;

    @Inject
    private UserService userService;

    @Inject
    private EventService eventService;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve form parameters
        Long userId = Long.parseLong(request.getParameter("userId"));
        Long eventId = Long.parseLong(request.getParameter("eventId"));

        // Find user and event by IDs
        User user = userService.getAllUsers().stream().filter(u -> u.getId().equals(userId)).findFirst().orElse(null);
        Event event = eventService.getAllEvents().stream().filter(e -> e.getId().equals(eventId)).findFirst().orElse(null);

        if (user != null && event != null) {
            // Create and save the registration
            Registration registration = new Registration(System.currentTimeMillis(), user, event, LocalDateTime.now());
            registrationService.registerForEvent(registration);

            // Redirect to a success page
            response.sendRedirect("events");
        } else {
            // Handle errors (e.g., invalid user or event ID)
            response.sendRedirect("event-register?error=Invalid+User+or+Event");
        }
    }
}
