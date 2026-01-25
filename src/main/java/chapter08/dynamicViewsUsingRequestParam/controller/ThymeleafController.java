package creatingDynamicViewsUsingThymeleaf.usingRequestParam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ThymeleafController {
    @RequestMapping("/home")
    public String allEndpointsHere(Model model,
                                   @RequestParam(required = false) String color,
                                   @RequestParam(required = false, name = "username") String usernameTrigo) {
        model.addAttribute("color", color);
        if(usernameTrigo == null) {
            usernameTrigo = "Pinho";
        }
        model.addAttribute("username", usernameTrigo);
        return "home.html";
    }
}
