package org.example.controllers;

import org.example.enums.Cast;
import org.example.states.GamersState;
import org.example.models.User;
import org.example.services.CustomTokenService;
import org.example.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.example.enums.Cast.CAPTAINB;

@RestController
public class GamersController {

    @Autowired
    private CustomTokenService tokenService;

    @Autowired
    private UserService userService;

    @GetMapping("/addGamer")
    public List<User> gamersCounter(@RequestParam(name = "token") String token) {
        if(tokenService.validateUser(token)){
            //if (validateAdding(GamersState.getInstance(),userService.fromToken(token))) {
                return GamersState.getInstance().addUser(userService.fromToken(token));
            }
        return GamersState.getInstance().getUsers();
    }

    @GetMapping("/start")
    public Boolean enableToStart(@RequestParam(name = "token") String token) {
        int rCaptain = 0;
        int bCaptain = 0;
        int rCounter = 0;
        int bCounter = 0;
        for (User user:GamersState.getInstance().getUsers()) {
            switch (user.getCast()) {
                case CAPTAINB:
                    bCaptain++;
                    break;
                case CAPTAINR:
                    rCaptain++;
                    break;
                case RED:
                    rCounter++;
                    break;
                case BLUE:
                    bCounter++;
                    break;
                default:
                   return false;
            }
        }
        return rCaptain == 1 && bCaptain == 1 && (Math.abs(rCounter-bCounter)<2);
    }

    public Boolean validateAdding(GamersState instance, User toAdd) {
        if (toAdd.getCast().equals(CAPTAINB)) {
            for (User user: instance.getUsers()) {
                if (user.getCast().equals(CAPTAINB)) {
                    return false;
                }
            }
        }
        if (toAdd.getCast().equals(Cast.CAPTAINR)) {
            for (User user: instance.getUsers()) {
                if (user.getCast().equals(Cast.CAPTAINR)) {
                    return false;
                }
            }
        }
        return true;
    }

}
