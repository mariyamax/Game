package org.example.controllers;

import org.example.enums.Cast;
import org.example.enums.Colors;
import org.example.models.Card;
import org.example.services.CustomTokenService;
import org.example.states.GameState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.example.enums.Colors.RED;
import static org.example.enums.Colors.byValue;

@RestController
public class GameController {

    @Autowired
    private CustomTokenService tokenService;

    @GetMapping("/getState")
    public List<Card> cards(@RequestParam(name = "token") String token) {
        return GameState.getInstance().getCards();
    }

    @GetMapping("/isCaptain")
    public Boolean isCaptain(@RequestParam(name = "token") String token) {
        if (tokenService.isCaptain(token)) {
            return true;
        } else {
           return false;
        }
    }

    public void addPoint(int id,String userCast) {
        Card card = GameState.getInstance().getCards().get(id);
        switch (Colors.byValue(card.getColor())) {
            case RED:
                GameState.getInstance().addPointToRed();
                break;
            case BLUE:
                GameState.getInstance().addPointToBlue();
                break;
            case GREY:
                GameState.getInstance().gameOver(Cast.fromString(userCast));
                break;
        }
    }
}


