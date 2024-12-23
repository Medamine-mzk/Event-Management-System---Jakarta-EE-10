package org.ems.ems.services;

import jakarta.enterprise.context.ApplicationScoped;
import org.ems.ems.models.Registration;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class RegistrationService {
    private List<Registration> registrations = new ArrayList<>();

    public void registerForEvent(Registration registration) {
        registrations.add(registration);
    }

    public List<Registration> getRegistrations() {
        return registrations;
    }

}
