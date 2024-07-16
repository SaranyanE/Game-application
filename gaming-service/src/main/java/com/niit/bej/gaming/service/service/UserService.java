package com.niit.bej.gaming.service.service;

import com.niit.bej.gaming.service.exception.EmptyGameListException;
import com.niit.bej.gaming.service.exception.GameNotFoundException;
import com.niit.bej.gaming.service.exception.UserAlreadyCreatedException;
import com.niit.bej.gaming.service.exception.UserNotFoundException;
import com.niit.bej.gaming.service.model.Game;
import com.niit.bej.gaming.service.model.User;

import java.util.List;

public interface UserService {
    User createUser(User user) throws UserAlreadyCreatedException;

    User findUserByName(String name) throws UserNotFoundException;

    Game addGameToList(String username, Game game) throws UserNotFoundException, EmptyGameListException;

    List<Game> viewGameList(String username) throws UserNotFoundException;

    Game updateGame(String username, String gameName,Game updatedGame) throws UserNotFoundException,EmptyGameListException,GameNotFoundException;

    Game removeGameFromList(String username, String gameName) throws UserNotFoundException, EmptyGameListException, GameNotFoundException;
}
