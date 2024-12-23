package org.ems.ems.controllers;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.ems.ems.services.EventService;

import java.io.IOException;

@WebServlet("/events/delete")
public class DeleteEventServlet extends HttpServlet {

    @Inject
    private EventService eventService;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long eventId = Long.parseLong(request.getParameter("id"));
        eventService.deleteEvent(eventId); // Add this method to your EventService.
        response.sendRedirect(request.getContextPath() + "/events");
    }
}

