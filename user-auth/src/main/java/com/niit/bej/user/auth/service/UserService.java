package com.niit.bej.user.auth.service;

import com.niit.bej.user.auth.exception.InvalidCredentialsException;
import com.niit.bej.user.auth.exception.UserAlreadyRegisteredException;
import com.niit.bej.user.auth.exception.UserNotFoundException;
import com.niit.bej.user.auth.model.User;

public interface UserService {
    User register(User user) throws UserAlreadyRegisteredException;

    User login(User user) throws UserNotFoundException, InvalidCredentialsException;
}
