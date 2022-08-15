package com.example.feignserver.sevice;

import com.example.feignserver.dto.UserDTO;
import com.example.feignserver.dto.UserRequestDTO;
import org.bson.types.ObjectId;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("${api.gateway}")
public interface UserService {
    @GetMapping("/users/{userId}")
    UserDTO getUserById(@PathVariable("userId") ObjectId userId);

    @PutMapping("/users/{userId}")
    UserDTO updateUser(@PathVariable("userId") ObjectId userId, @RequestBody UserRequestDTO userRequestDTO);

    @DeleteMapping("/users/{userId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteUser(@PathVariable("userId") ObjectId userId);

    @GetMapping("/users")
    List<UserDTO> getAllUsers();

    @PostMapping("/users/create")
    UserDTO createUser(UserRequestDTO user);
}
