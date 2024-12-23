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
import java.util.List;

@WebServlet("/events")
public class EventServlet extends HttpServlet {


    @Inject
    private EventService eventService;


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Event> events = eventService.getAllEvents();
        request.setAttribute("events", events);
        request.getRequestDispatcher("/views/events.jsp").forward(request, response);
    }
}
