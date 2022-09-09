package com.example.backend.config;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClientForwardController implements ErrorController {

    /**
     * Forwards any unmapped paths (excluding those containing a period) for the client application to handle.
     * Also handles the Spring Boot Whitelabel Error Page.
     */
    @GetMapping(value = "/**/{path:[^\\.]*}")
    public String forward() {
        return "forward:/";
    }

}
