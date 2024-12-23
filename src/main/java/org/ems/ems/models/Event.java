package org.ems.ems.models;

import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Event {
    private Long id;
    private String title;
    private String description;
    private LocalDateTime dateTime;
    private List<Registration> registrations = new ArrayList<>();



    // Overriding equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Event)) return false;
        Event event = (Event) o;
        return Objects.equals(id, event.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
