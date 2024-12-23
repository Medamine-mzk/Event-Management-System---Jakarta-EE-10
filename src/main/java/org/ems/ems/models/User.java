package org.ems.ems.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Objects;

@AllArgsConstructor
@Data
public class User {
    private Long id;
    private String name;
    private String email;
    private String password;

    // Overriding equals for comparison
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
