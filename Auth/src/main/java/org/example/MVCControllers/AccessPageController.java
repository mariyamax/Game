package org.example.MVCControllers;

import lombok.RequiredArgsConstructor;
import org.example.enums.Cast;
import org.example.models.User;
import org.example.services.CustomTokenService;
import org.example.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@RequiredArgsConstructor
@Controller
public class AccessPageController {

    @Autowired
    private UserService userService;
    @Autowired
    private CustomTokenService tokenService;

    @GetMapping("/")
    public String getStartPage() {
        return "AccessPage";
    }

    @GetMapping("/registration")
    public String getRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("registration", "registration");
        return "AccessPage";
    }

    @GetMapping("/login")
    public String getLoginForm(Model model) {
        model.addAttribute("login", "login");
        return "AccessPage";
    }

    @PostMapping("/registration")
    public String registerNewUser(User user, @RequestParam(name = "cast") Cast cast, Model model) {
        //todo тут должно быть формирофание токена и отправка письма
        model.addAttribute("token", tokenService.getToken(user.getUsername(), cast.getValue(), user.getMail()));
        return "AccessPage";
    }

   @PostMapping("/login")
    public RedirectView login(@RequestParam(name = "token", required = true) String token, Model model, RedirectAttributes attributes) {
        tokenService.decodeToUsername(token);
        if (!tokenService.validateUser(token)) {
            attributes.addAttribute("login", "login");
            attributes.addAttribute("error", "Невеный токен");
            return new RedirectView("/login");
        }
        attributes.addAttribute("token", token);
        return new RedirectView("/mainPage");
    }

}

