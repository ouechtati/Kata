package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/transform")
public class TransformController {

    @Autowired
    private TransformService transformService;

    @GetMapping("/{number}")
    public String transformNumber(@PathVariable int number) {
        return transformService.transform(number);
    }
}
