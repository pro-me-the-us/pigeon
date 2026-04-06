package com.notify.pigeon.user;

import com.notify.pigeon.user.dtos.CreateUserDTO;
import org.springframework.stereotype.Service;

@Service
public class UserServices {

    private final UserRepository userRepository;

    public UserServices(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    UserEntity createUser(CreateUserDTO request){
        var newuser = UserEntity.builder()
                .username(request.getUsername())
                .password(request.getPassword())
                .contact(request.getContact())
                .email(request.getEmail())
                .build();
        userRepository.save(newuser);
        return newuser;
    }
}
