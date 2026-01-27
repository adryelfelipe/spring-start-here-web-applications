package chapter09.usingRequestWebScope.service;

import chapter09.usingRequestWebScope.context.LoginContext;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    // Methods
    public boolean login(LoginContext loginContext) {
        return(loginContext.getPassword().equals("123") && loginContext.getUsername().equalsIgnoreCase("Roberto"));
    }
}
