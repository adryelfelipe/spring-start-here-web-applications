package chapter09.usingRequestAndSessionWebScopes.service;

import chapter09.usingRequestAndSessionWebScopes.context.LoginContext;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    // Methods
    public boolean login(LoginContext loginContext, String username) {
        return(loginContext.getPassword().equals("123") && username.equalsIgnoreCase("Roberto"));
    }
}
