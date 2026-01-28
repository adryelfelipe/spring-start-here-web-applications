package chapter09.usingRequestAndSessionWebScopes.controller;

import chapter09.usingRequestAndSessionWebScopes.context.LoginContext;
import chapter09.usingRequestAndSessionWebScopes.service.LoginService;
import chapter09.usingRequestAndSessionWebScopes.session.UserSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    // Attributes
    private final LoginService loginService;
    private final LoginContext loginContext;
    private final UserSession userSession;

    // Constructor
    public LoginController(LoginService loginService, LoginContext loginContext, UserSession userSession) {
        this.loginService = loginService;
        this.loginContext = loginContext;
        this.userSession = userSession;
    }

    // Methods
    @GetMapping("/")
    public String getLogin() {
        return "login.html";
    }

    @PostMapping("/")
    public String postLogin(@RequestParam String username, @RequestParam String password, Model model) {
        loginContext.setPassword(password);
        boolean operation = loginService.login(loginContext, username);
        if(operation) {
            userSession.setUsername(username);

            return("redirect:/profile");
        } else {
            model.addAttribute("message", "Nooo, try again!");

            return("login.html");
        }
    }

    @GetMapping("/profile")
    public String getProfile(Model model) {
        if(userSession.getUsername() == null) {

            return("redirect:/");
        } else {
            System.err.println("LENDO USERNAME: " + userSession.getUsername());
            model.addAttribute("username", userSession.getUsername());

            return "profile.html";
        }
    }
}
