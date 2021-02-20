package com.example.newmanTester.controllers;

import com.example.newmanTester.models.SampleResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewmanController {

    @RequestMapping("/newman")
    public SampleResponse Sample(@RequestParam(value = "name", defaultValue = "Mochi") String name) {
        SampleResponse sr = new SampleResponse("Mochi is a name-o");
        sr.setId(1);
        sr.setMessage("Hello! " + name);
        return sr;
    }

}
