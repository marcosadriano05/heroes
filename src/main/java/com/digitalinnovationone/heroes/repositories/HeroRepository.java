package com.digitalinnovationone.heroes.repositories;

import com.digitalinnovationone.heroes.models.Hero;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface HeroRepository extends MongoRepository<Hero, String> {
}
