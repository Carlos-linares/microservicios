package com.user.Users.services.user;

import com.user.Users.dto.UserDto;
import com.user.Users.dto.UserToSaveDto;
import com.user.Users.exceptions.UserNotFoundException;

public interface UserService {
    UserDto saveUsuario(UserToSaveDto userToSaveDto);
    UserDto updateUsuario(Long id, UserToSaveDto usuario) throws UserNotFoundException;
    UserDto findById(Long id) throws UserNotFoundException;
    void deleteUserById(Long id) throws UserNotFoundException;
    UserDto findByUsernameAndRol(String username, Role role) throws UserNotFoundException;
    UserDto findByusernameAndrole(String username, Role role) throws UserNotFoundException;
}
