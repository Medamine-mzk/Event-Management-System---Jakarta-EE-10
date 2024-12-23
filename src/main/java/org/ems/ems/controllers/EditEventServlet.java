package org.ems.ems.controllers;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.ems.ems.models.Event;
import org.ems.ems.services.EventService;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@WebServlet("/events/edit")
public class EditEventServlet extends HttpServlet {

    @Inject
    private EventService eventService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long eventId = Long.parseLong(request.getParameter("id"));
        Event event = eventService.getEventById(eventId);

        if (event != null && event.getDateTime() != null) {
            // Format the date-time for the frontend
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
            String formattedDateTime = event.getDateTime().format(formatter);
            request.setAttribute("formattedDateTime", formattedDateTime);
        } else {
            request.setAttribute("formattedDateTime", ""); // Empty if dateTime is null
        }

        request.setAttribute("event", event);
        request.getRequestDispatcher("/views/edit-event.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long eventId = Long.parseLong(request.getParameter("id"));
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String dateTime = request.getParameter("dateTime");

        Event event = eventService.getEventById(eventId);
        event.setTitle(title);
        event.setDescription(description);
        event.setDateTime(LocalDateTime.parse( dateTime));

        eventService.updateEvent(event); // Add this method to your EventService.
        response.sendRedirect(request.getContextPath() + "/events");
    }
}

