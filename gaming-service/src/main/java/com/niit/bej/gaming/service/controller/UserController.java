package com.niit.bej.gaming.service.controller;

import com.niit.bej.gaming.service.exception.EmptyGameListException;
import com.niit.bej.gaming.service.exception.GameNotFoundException;
import com.niit.bej.gaming.service.exception.UserAlreadyCreatedException;
import com.niit.bej.gaming.service.exception.UserNotFoundException;
import com.niit.bej.gaming.service.model.Game;
import com.niit.bej.gaming.service.model.User;
import com.niit.bej.gaming.service.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users/create")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        try {
            User createdUser = userService.createUser(user);
            return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
        } catch (UserAlreadyCreatedException exception) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/users/{username}")
    public ResponseEntity<User> findUserByUsername(@PathVariable String username) {
        try {
            User user = userService.findUserByName(username);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (UserNotFoundException exception) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/users/{username}/gameList/add")
    public ResponseEntity<Game> addGameToList(@PathVariable String username, @RequestBody Game game) {
        try {
            Game addedGame = userService.addGameToList(username, game);
            return new ResponseEntity<>(addedGame, HttpStatus.CREATED);
        } catch (UserNotFoundException exception) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (EmptyGameListException exception) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/users/{username}/gameList")
    public ResponseEntity<List<Game>> viewGameList(@PathVariable String username) {
        try {
            List<Game> gameList = userService.viewGameList(username);
            return new ResponseEntity<>(gameList, HttpStatus.OK);
        } catch (UserNotFoundException exception) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/users/{username}/gameList/{gameName}")
    public ResponseEntity<Game> updateGame(@PathVariable String username, @PathVariable String gameName, @RequestBody Game updatedGame) {
        try {
            Game game = userService.updateGame(username, gameName, updatedGame);
            return new ResponseEntity<>(game, HttpStatus.OK);
        } catch (UserNotFoundException | EmptyGameListException | GameNotFoundException exception) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/users/{username}/gameList/{gameName}")
    public ResponseEntity<Game> removeGameFromList(@PathVariable String username, @PathVariable String gameName) {
        try {
            Game removedGame = userService.removeGameFromList(username, gameName);
            return new ResponseEntity<>(removedGame, HttpStatus.OK);
        } catch (UserNotFoundException | EmptyGameListException | GameNotFoundException exception) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
