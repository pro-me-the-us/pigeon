package com.notify.pigeon.user;

import com.notify.pigeon.user.dtos.CreateUserDTO;
import com.notify.pigeon.user.dtos.UserResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserServices userServices;

    public UserController(UserServices userServices) {
        this.userServices = userServices;
    }


    @PostMapping("/signup")
    ResponseEntity<UserResponseDTO> signupUser(@RequestBody CreateUserDTO request){
        var newuser = userServices.createUser(request);
        var response = new UserResponseDTO();
        response.setId(newuser.getId());
        response.setUsername(newuser.getUsername());
        response.setContact(newuser.getContact());
        response.setEmail(newuser.getEmail());
        return new ResponseEntity<>(response, HttpStatus.CREATED);
        //TODO : Verify email using regex, add password using hash (JWT/OAuth);
    }

}
