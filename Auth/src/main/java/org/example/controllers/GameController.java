package org.example.controllers;

import org.example.models.Card;
import org.example.states.GameState;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GameController {

    @GetMapping("/getState")
    public List<Card> cards(/*@RequestParam(name = "token") String token*/) {
        return GameState.getInstance().getCards();
    }
}
