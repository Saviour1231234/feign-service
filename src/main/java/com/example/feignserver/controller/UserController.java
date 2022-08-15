package com.example.feignserver.controller;

import com.example.feignserver.dto.UserDTO;
import com.example.feignserver.dto.UserRequestDTO;
import com.example.feignserver.sevice.UserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @Operation(summary = "Returns user of specified id")
    @GetMapping("/users/{userId}")
    UserDTO getUserById(@PathVariable("userId") ObjectId userId){
        return userService.getUserById(userId);
    }

    @Operation(summary = "Update user with requested data")
    @PutMapping("/users/{userId}")
    UserDTO updateUser(@PathVariable("userId") ObjectId userId, @RequestBody UserRequestDTO userRequestDTO){
        return userService.updateUser(userId,userRequestDTO);
    }

    @Operation(summary = "Delete user by id")
    @DeleteMapping("/users/{userId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteUser(@PathVariable("userId") ObjectId userId){
        userService.deleteUser(userId);
    }

    @Operation(summary = "Returns all users")
    @GetMapping("/users")
    List<UserDTO> getAllUsers(){
        return userService.getAllUsers();
    }

    @Operation(summary = "Create user with requested data")
    @PostMapping("/users/create")
    UserDTO createUser(UserRequestDTO user){
        return userService.createUser(user);
    }
}
