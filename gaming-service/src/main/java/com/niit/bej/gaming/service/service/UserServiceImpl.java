package com.niit.bej.gaming.service.service;

import com.niit.bej.gaming.service.exception.EmptyGameListException;
import com.niit.bej.gaming.service.exception.GameNotFoundException;
import com.niit.bej.gaming.service.exception.UserAlreadyCreatedException;
import com.niit.bej.gaming.service.exception.UserNotFoundException;
import com.niit.bej.gaming.service.model.Game;
import com.niit.bej.gaming.service.model.User;
import com.niit.bej.gaming.service.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user) throws UserAlreadyCreatedException {
        Optional<User> optionalUser = this.userRepository.findUserByName(user.getName());
        if (optionalUser.isPresent()) {
            throw new UserAlreadyCreatedException(user.getName() + " already created!");
        }
        return this.userRepository.save(user);
    }

    @Override
    public User findUserByName(String username) throws UserNotFoundException {
        Optional<User> optionalUser = this.userRepository.findUserByName(username);
        return optionalUser.orElseThrow(() -> new UserNotFoundException(username + " not found !!!"));
    }

    @Override
    public Game addGameToList(String username, Game game) throws UserNotFoundException {
        User userFromDatabase = getUserFromDatabase(username);
        List<Game> gameList = userFromDatabase.getFavouriteGameList();
        gameList.add(game);
        this.userRepository.save(userFromDatabase);
        return game;
    }

    private User getUserFromDatabase(String username) throws UserNotFoundException {
        Optional<User> optionalUser = userRepository.findUserByName(username);
        if (optionalUser.isEmpty()) {
            throw new UserNotFoundException(username + " not found!");
        }
        return optionalUser.get();
    }

    private Game findGameByName(List<Game> gameList, String gameName) throws GameNotFoundException {
        Optional<Game> optionalGame = gameList.stream().filter(game -> game.getTitle().trim().equals(gameName)).findFirst();
        return optionalGame.orElseThrow(() -> new GameNotFoundException("Could not find Game" + gameName + "!"));
    }

    @Override
    public List<Game> viewGameList(String username) throws UserNotFoundException {
        User user = getUserFromDatabase(username);
        return user.getFavouriteGameList();
    }

    @Override
    public Game updateGame(String username, String gameName, Game updatedGame) throws UserNotFoundException, EmptyGameListException, GameNotFoundException {
        User userFromDatabase = getUserFromDatabase(username);
        List<Game> gameList = userFromDatabase.getFavouriteGameList();
        if(gameList.isEmpty()){
            throw new EmptyGameListException("game list is empty! ");
        }
        Game gameToUpdate = findGameByName(gameList,gameName);
        gameToUpdate.setId(updatedGame.getId());
        gameToUpdate.setTitle(updatedGame.getTitle());
        gameToUpdate.setGenre(updatedGame.getGenre());
        gameToUpdate.setReleaseYear(updatedGame.getReleaseYear());
        gameToUpdate.setRating(updatedGame.getRating());
        userRepository.save(userFromDatabase);
        return gameToUpdate;
    }

    @Override
    public Game removeGameFromList(String username, String gameName) throws UserNotFoundException, EmptyGameListException, GameNotFoundException {
        User userFromDatabase = getUserFromDatabase(username);
        List<Game> gameList = userFromDatabase.getFavouriteGameList();
        if (gameList.isEmpty()) {
            throw new EmptyGameListException("List is empty");
        }
        Game gameToRemove = findGameByName(gameList, gameName);
        gameList.remove(gameToRemove);
        userRepository.save(userFromDatabase);
        return gameToRemove;
    }
}
