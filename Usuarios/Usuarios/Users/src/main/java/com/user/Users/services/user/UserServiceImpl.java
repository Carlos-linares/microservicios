package com.usersPackage.Users.services.user;

import com.user.Users.dto.UserDto;
import com.user.Users.dto.UserMapper;
import com.user.Users.dto.UserToSaveDto;
import com.user.Users.entity.User;
import com.user.Users.exceptions.UserNotFoundException;
import com.user.Users.repository.UserRepository;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto saveUsuario(UserToSaveDto userToSaveDto) {
        User usuario = UserMapper.INSTANCE.userToSaveDtoToUserEntity(userToSaveDto);
        User savedUser = userRepository.save(usuario);
        return UserMapper.INSTANCE.userEntityToUserDto(savedUser);
    }

    @SneakyThrows
    @Override
    public UserDto updateUsuario(Long id, UserToSaveDto usuario) {
        Optional<User> userConsulted = userRepository.findById(id);

        if(userConsulted.isEmpty())
            throw new UserNotFoundException("Usuario con ID " + id + " no encontrado");

        User us = userConsulted.get();

        if (us.getUsername() != null) us.setUsername(us.getUsername());
        if (us.getEmail() != null) us.setEmail(us.getEmail());
        if (us.getPassword() != null) us.setPassword(us.getPassword());

        User updatedUser = userRepository.save(us);

        return UserMapper.INSTANCE.userEntityToUserDto(updatedUser);
    }

    @Override
    public UserDto findById(Long id) throws UserNotFoundException {
        User usuario = userRepository.findById(id)
                .orElseThrow(()-> new UserNotFoundException("Usuario No Encontrado"));
        return UserMapper.INSTANCE.userEntityToUserDto(usuario);
    }

    @Override
    public void deleteUserById(Long id) throws UserNotFoundException {
        Optional<User> userToDelete = userRepository.findById(id);

        if(userToDelete.isEmpty())
            throw new UserNotFoundException("Usuario con ID " + id + " no existe");

        userRepository.deleteById(id);
    }

    @Override
    public UserDto findByUsernameAndRol(String username) throws UserNotFoundException {
        return null;
    }

    @Override
    public UserDto findByusernameAndrole(String username, Role role) throws UserNotFoundException {
        User usuario = (User) userRepository.findByusernameAndRole(username);
        if(Objects.isNull(usuario))
            throw new UserNotFoundException("Usuario no encontrado");
        return UserMapper.INSTANCE.userEntityToUserDto(usuario);
    }
}
