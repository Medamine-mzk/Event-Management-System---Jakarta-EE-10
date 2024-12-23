package org.ems.ems.services;

import jakarta.enterprise.context.ApplicationScoped;
import org.ems.ems.models.Event;
import org.ems.ems.models.Registration;
import org.ems.ems.models.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class EventService {
    private static final List<Event> events = new ArrayList<>();

    public EventService() {
        // Adding sample data
        events.add(new Event(1L, "Tech Conference", "Conference on latest tech trends", LocalDateTime.now().plusDays(5),new ArrayList<>()));
        events.add(new Event(2L, "Music Festival", "Annual music festival", LocalDateTime.now().plusDays(10),new ArrayList<>()));
        events.add(new Event(3L, "Art Workshop", "Learn art from top artists", LocalDateTime.now().plusDays(15),new ArrayList<>()));
        Registration reg1 = new Registration(1L, new User(1L, "Alice", "alice@example.com", "password"), events.get(0), LocalDateTime.now());
        Registration reg2 = new Registration(2L, new User(2L, "Bob", "bob@example.com", "password"), events.get(1), LocalDateTime.now());
        events.get(0).getRegistrations().add(reg1);
        events.get(1).getRegistrations().add(reg2);
    }

    public List<Event> getAllEvents() {
        return events;
    }


    public void addEvent(Event event) {
        events.add(event);
    }
    public Event getEventById(Long id) {
        return events.stream().filter(event -> event.getId().equals(id)).findFirst().orElse(null);
    }
    public void updateEvent(Event updatedEvent) {
        for (int i = 0; i < events.size(); i++) {
            if (events.get(i).getId() == updatedEvent.getId()) {
                events.set(i, updatedEvent);
                break;
            }
        }
    }
    public void deleteEvent(Long id) {
        events.removeIf(event -> event.getId() == id);
    }

}
