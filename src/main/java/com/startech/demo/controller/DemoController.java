package com.startech.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DemoController {

    @GetMapping(path = "/")
    public String index() {
        return "Greetings from Spring Boot";
    }

    @GetMapping(path = "/health")
    public String health() {
        return HttpStatus.OK.toString();
    }

    @GetMapping(path = "/ping")
    public String pingPong(@RequestParam("param") String input) {
        System.out.println("input: " + input);
        if (input.equals("Ping")) {
            return "Pong!";
        } else {
            return "not working!";
        }
    }

    @GetMapping(path = "/hello", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody()
    public String hello() {
        return "Hello from Star-Tech Industries!";
    }
}
