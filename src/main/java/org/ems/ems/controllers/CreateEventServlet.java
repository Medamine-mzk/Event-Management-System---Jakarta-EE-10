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

@WebServlet("/events/create")
public class CreateEventServlet extends HttpServlet {

    @Inject
    private EventService eventService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/views/create-event.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String dateTime = request.getParameter("dateTime");
        Event event = new Event();
        event.setId(System.currentTimeMillis() + (long) (Math.random() * 1000)); //generate ID
        event.setTitle(title);
        event.setDescription(description);
        event.setDateTime(LocalDateTime.parse(dateTime));

        eventService.addEvent(event);
        response.sendRedirect(request.getContextPath() + "/events");
    }
}

