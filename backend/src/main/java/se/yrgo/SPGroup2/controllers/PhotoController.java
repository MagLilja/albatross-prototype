package se.yrgo.SPGroup2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import se.yrgo.SPGroup2.domain.Photo;
import se.yrgo.SPGroup2.enums.ProductType;
import se.yrgo.SPGroup2.repositories.PhotoRepository;

import java.util.List;

@RestController
@RequestMapping(value = "/photos")
public class PhotoController {

    @Autowired
    private PhotoRepository photoRepository;

    @GetMapping(value = "/{type}")
    public List<Photo> getPhotosByType(@PathVariable String type) {
        return photoRepository.findByType(ProductType.valueOf(type));
    }

    @GetMapping(value = "/{model}")
    public List<Photo> getPhotosByModel(@PathVariable String model) {
        return photoRepository.findByModel(model);
    }

    @GetMapping(value = "/{color}")
    public List<Photo> getPhotosByColor(@PathVariable String color) {
        return photoRepository.findByColor(color);
    }

}
