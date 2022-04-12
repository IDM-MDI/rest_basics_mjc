package com.epam.esm.task.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping
    public String getInstance() {
        return "index";
    }

    @GetMapping("/{id}")
    public String getId(@PathVariable long id){
        return "" + id;
    }
}
