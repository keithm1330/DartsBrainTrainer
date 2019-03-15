package com.dartsapp.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

@Controller
public class WelcomeController {

    // inject via application.properties
    @Value("${welcome.message}")
    private String message;

    private static int highscore= 0;

    private List<String> tasks = Arrays.asList("a", "b", "c", "d", "e", "f", "g");

    @GetMapping("/")
    public String main(Model model) {
        model.addAttribute("message", message);
        model.addAttribute("tasks", tasks);

        return "index"; //view
    }

    
    @GetMapping("/highScore")
    @ResponseBody
    public Integer mainWithParam(){
         return highscore;
    }

    @GetMapping("/updateHighScore")
    @ResponseBody
    public String maodxd(@RequestParam(name = "score", required = false, defaultValue = "") Integer score){
         highscore=score;
    	return "";
    }

}