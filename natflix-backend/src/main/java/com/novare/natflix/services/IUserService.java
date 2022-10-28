package com.novare.natflix.services;

import com.novare.natflix.exceptions.NatflixException;
import com.novare.natflix.models.User;

public interface IUserService {
    User createUser(User user) throws NatflixException;
    User updateUser(User user) throws NatflixException;

}