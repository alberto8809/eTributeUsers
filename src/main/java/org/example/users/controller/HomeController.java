package org.example.users.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/eTribute")
public class HomeController {

    @GetMapping("/index")
    public ModelAndView showPage() {
        return new ModelAndView("index");
    }
}
