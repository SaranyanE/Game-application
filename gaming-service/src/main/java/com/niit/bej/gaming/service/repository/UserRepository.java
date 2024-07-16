package com.niit.bej.gaming.service.repository;

import com.niit.bej.gaming.service.model.Game;
import com.niit.bej.gaming.service.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, Game> {
    Optional<User> findUserByName(String name);
}