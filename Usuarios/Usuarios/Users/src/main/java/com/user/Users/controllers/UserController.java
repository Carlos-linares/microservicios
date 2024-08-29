package com.user.Users.controllers;

import com.user.Users.dto.UserDto;
import com.user.Users.dto.UserToSaveDto;
import com.user.Users.exceptions.UserNotFoundException;
import com.user.Users.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("usersApi/v1/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping()
    public ResponseEntity<UserDto> postUser(@RequestBody UserToSaveDto usuario){
        UserDto res = userService.saveUsuario(usuario);
        return ResponseEntity.ok().body(res);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id){
        try {
            UserDto res = userService.findById(id);
            return ResponseEntity.ok().body(res);
        } catch (UserNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> putUser(@PathVariable Long id, @RequestBody UserToSaveDto usuario){
        try{
            UserDto res = userService.updateUsuario(id, usuario);
            return ResponseEntity.ok().body(res);
        }catch (UserNotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id){
        try{
            userService.deleteUserById(id);
            return ResponseEntity.ok().body("Usuario eliminado");
        }catch (UserNotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }
}
