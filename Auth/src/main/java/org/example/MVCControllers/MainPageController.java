package org.example.MVCControllers;

import lombok.RequiredArgsConstructor;
import org.example.services.CustomTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@Controller
public class MainPageController {

    @Autowired
    private CustomTokenService tokenService;

    @GetMapping("/mainPage")
    public String getLoginForm(@RequestParam(name = "token", required = true) String token, Model model) {
        model.addAttribute("token",token);
        return "MainPage";
    }

    @GetMapping("/game")
    public String getGame(@RequestParam(name = "token", required = true) String token, Model model) {
        model.addAttribute("token",token);
        model.addAttribute("name",tokenService.decodeToUsername(token));
        model.addAttribute("server",tokenService.decodeToMail(token));
        return "GamePage";
    }

}

