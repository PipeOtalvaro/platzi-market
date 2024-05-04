package com.platzimarket.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/great")
public class HiWorldController {
    @GetMapping("/sayHi")
    private String great(){
        return "Hi world";
    }
}
