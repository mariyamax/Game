package org.example.states;

import org.example.models.User;

import java.util.ArrayList;
import java.util.List;

public class GamersState {

    private static final GamersState INSTANCE = new GamersState();

    private List<User> users;

    private GamersState() {
        users = new ArrayList<>();
    }

    public List<User> addUser(User user) {
        if (!users.contains(user)) {
            users.add(user);
        }
        return users;
    }

    public List<User> getUsers() {
        return users;
    }

    public static GamersState getInstance() {
        return INSTANCE;
    }

}
