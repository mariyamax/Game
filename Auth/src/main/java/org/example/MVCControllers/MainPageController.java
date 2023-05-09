package org.example.MVCControllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@Controller
public class MainPageController {

    @GetMapping("/mainPage")
    public String getLoginForm(@RequestParam(name = "token", required = true) String token, Model model) {
        model.addAttribute("token",token);
        return "MainPage";
    }

}

