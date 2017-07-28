package net.antra.hanz.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hanzheng on 7/27/17.
 */

@RestController
public class MainController {

    @RequestMapping("/main")
    public String getMainPage() {
        return "Hello";
    }

    @RequestMapping("/main/{user}")
    public String getMainPage(@PathVariable String user) {
        return "Hello, " + user;
    }
}
