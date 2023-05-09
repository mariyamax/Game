package org.example.models;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.example.enums.Cast;

@Data
@RequiredArgsConstructor
public class User {

    private String username;

    private String mail;

    private Cast cast;


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        User user = (User) o;
        return this.getCast().equals(user.cast) && this.getUsername().equals(user.username);
    }

    @Override
    public int hashCode() {
        int result = username != null ? username.hashCode() : 0;
        result = 31 * result + cast.hashCode();
        return result;
    }

}

