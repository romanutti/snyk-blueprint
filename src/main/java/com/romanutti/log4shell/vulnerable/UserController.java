package com.romanutti.log4shell.vulnerable;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.util.HtmlUtils.htmlEscape;

@RestController
public class UserController {

    private static final Logger logger = LogManager.getLogger("vulnerable-logger");

    @GetMapping("/welcome")
    public String welcome(@RequestHeader("user") String user) {
        logger.info(String.format("User %s drops in", user));
        return generateWelcomeMessage(user);
    }

    private String generateWelcomeMessage(String user){
        return htmlEscape("Welcome to the Server " + user);
    }
}
