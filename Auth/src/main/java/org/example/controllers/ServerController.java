package org.example.controllers;

import org.example.enums.Cast;
import org.example.models.Action;
import org.example.models.User;
import org.example.services.CustomTokenService;
import org.example.states.GameState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;


@Controller
public class ServerController {


    @Autowired
    private SimpMessageSendingOperations messagingTemplate;

    @Autowired
    private GameController gameController;

    @Autowired
    private CustomTokenService tokenService;


    @MessageMapping("/server/{room}")
    public void catchRoom(@DestinationVariable String room, @Payload Action action) {
        int id = Integer.parseInt(action.getCellId().substring(5));
        String userCast = tokenService.decodeToCast(action.getToken());
        gameController.addPoint(id,userCast);
        messagingTemplate.convertAndSend("/server/".concat(room), action);
    }

}
