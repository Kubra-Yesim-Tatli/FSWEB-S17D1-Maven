package com.workintech.fswebs17d1.controller;

import com.workintech.fswebs17d1.entity.Animal;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/workintech/animal")
public class AnimalController {

    private Map<Integer, Animal> animals = new HashMap<>();

    @Value("${course.name}")
    private String courseName;

    @Value("${project.developer.fullname}")
    private String developerFullname;

    @GetMapping
    public List<Animal> getAllAnimals() {
        return new ArrayList<>(animals.values());
    }

    @GetMapping("/{id}")
    public Animal getAnimalById(@PathVariable int id) {
        return animals.get(id);
    }

    @PostMapping
    public void addAnimal(@RequestBody Animal animal) {
        animals.put(animal.getId(), animal);
    }

    @PutMapping("/{id}")
    public void updateAnimal(@PathVariable int id, @RequestBody Animal animal) {
        animals.put(id, animal);
    }

    @DeleteMapping("/{id}")
    public void deleteAnimal(@PathVariable int id) {
        animals.remove(id);
    }
}
