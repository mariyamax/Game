package org.example.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.example.enums.Cast.fromString;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {

    @Autowired CustomTokenService tokenService;

    public User fromToken(String token) {
        User user = new User();
        user.setCast(fromString(tokenService.decodeToCast(token)));
        user.setUsername(tokenService.decodeToUsername(token));
        return user;
    }

}
