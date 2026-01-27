package chapter08.dynamicViewsUsingPathVariable.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PathVariableController {

    @RequestMapping("/home/{color}")
    public String allEndpointsHere(@PathVariable String color, Model model) {
        model.addAttribute("color", color);
        model.addAttribute("username", "Tetheu");
        return "home.html";
    }
}
