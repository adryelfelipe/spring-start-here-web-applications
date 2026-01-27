package chapter09.usingRequestWebScope.controller;

import chapter09.usingRequestWebScope.context.LoginContext;
import chapter09.usingRequestWebScope.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    // Attributes
    private LoginService loginService;
    private LoginContext loginContext;

    // Constructor
    public LoginController(LoginService loginService, LoginContext loginContext) {
        this.loginService = loginService;
        this.loginContext = loginContext;
    }

    // Methods
    @GetMapping("/")
    public String getLogin() {
        return "login.html";
    }

    @PostMapping("/")
    public String postLogin(@RequestParam String username, @RequestParam String password, Model model) {
        loginContext.setUsername(username);
        loginContext.setPassword(password);
        boolean operation = loginService.login(loginContext);
        if(operation) {
            model.addAttribute("message", "Login successful");

        } else {
            model.addAttribute("message", "Nooo, try again!");
        }

        return("login.html");
    }
}
