package org.ems.ems.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
@AllArgsConstructor
@Data
public class Registration {
    private Long id;
    private User user;
    private Event event;
    private LocalDateTime dateTime;
}
