package com.digitalinnovationone.heroes.controllers;

import com.digitalinnovationone.heroes.models.Hero;
import com.digitalinnovationone.heroes.repositories.HeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/heroes")
public class HeroesController {

    @Autowired
    private HeroRepository heroRepository;

    @GetMapping
    public List<Hero> findHeroes() {
        return this.heroRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Hero> findById(@PathVariable String id) {
        Optional<Hero> optionalHero = this.heroRepository.findById(id);
        if (!optionalHero.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(optionalHero.get());
    }

    @PostMapping(value = "add-hero")
    public Hero addHero(@RequestBody Hero hero) {
        Hero newHero = new Hero(hero.getFirstName(), hero.getLastName());
        return this.heroRepository.save(newHero);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Hero> deleteHero(@PathVariable String id) {
        this.heroRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
