package org.example.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.enums.Cast;
import org.example.models.Card;
import org.example.utils.SecurityUtils;
import org.springframework.stereotype.Service;

import static org.example.enums.Cast.*;

@Service
@Slf4j
@RequiredArgsConstructor
public class CustomTokenService {

    public boolean isCaptain(String token) {
        String tokenCast = decodeToCast(token);
        return CAPTAINB.getValue().equals(tokenCast.toUpperCase()) || CAPTAINR.getValue().equals(tokenCast.toUpperCase());
    }

    public String getToken(String username, String cast, String mail) {
        String credential = username + "," + cast + ":" + mail;
        String value = SecurityUtils.encode(credential);
        return value;
    }

    public String decodeToUsername(String token) {
        String credentials = SecurityUtils.decode(token);
        return credentials.substring(0, credentials.indexOf(','));
    }

    public String decodeToMail(String token) {
        String credentials = SecurityUtils.decode(token);
        return credentials.substring(credentials.indexOf(':') + 1);
    }

    public String decodeToCast(String token) {
        String credentials = SecurityUtils.decode(token);
        return credentials.substring(credentials.indexOf(',') + 1, credentials.indexOf(':'));
    }

    public Boolean validateUser(String token) {
        return fromString(decodeToCast(token)) != null;
    }

}
