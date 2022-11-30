package se.yrgo.SPGroup2.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.yrgo.SPGroup2.model.Pants;

@RestController
public class PantsController {


    @GetMapping("/pants")
    public Pants getPants() {
        return new Pants(1,
                "blue",
                "L",
                "cotton");
    }
}
