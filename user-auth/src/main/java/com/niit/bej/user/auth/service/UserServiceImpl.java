package com.niit.bej.user.auth.service;

import com.niit.bej.user.auth.exception.InvalidCredentialsException;
import com.niit.bej.user.auth.exception.UserAlreadyRegisteredException;
import com.niit.bej.user.auth.exception.UserNotFoundException;
import com.niit.bej.user.auth.model.User;
import com.niit.bej.user.auth.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User register(User user) throws UserAlreadyRegisteredException {
        Optional<User> optionalUser = this.userRepository.findUserByUsername(user.getUsername());
        if (optionalUser.isPresent()) {
            throw new UserAlreadyRegisteredException("username is taken, please choose a different username!");
        }
        return this.userRepository.save(user);
    }

    @Override
    public User login(User user) throws UserNotFoundException, InvalidCredentialsException {
        Optional<User> optionalUser = this.userRepository.findUserByUsername(user.getUsername());
        if (optionalUser.isEmpty()) {
            throw new UserNotFoundException("User not found!");
        }
        User userFromDatabase = optionalUser.get();
        if (userFromDatabase.getPassword().equals(user.getPassword())) {
            return userFromDatabase;
        }
        throw new InvalidCredentialsException("Please check your username and password!");
    }
}
