package org.example.services;

import org.example.utils.SecurityUtils;
import org.springframework.stereotype.Service;

import static org.example.enums.Cast.*;

@Service
public class CustomTokenService {

    public String getToken(String username, String cast, String mail) {
        String credential = username+","+cast+":"+mail;
        String value = SecurityUtils.encode(credential);
        return value;
    }

    public String decodeToUsername(String token) {
        String credentials = SecurityUtils.decode(token);
        return credentials.substring(0, credentials.indexOf(','));
    }

    public String decodeToMail(String token) {
        String credentials = SecurityUtils.decode(token);
        return credentials.substring(credentials.indexOf(':')+1);
    }

    public String decodeToCast(String token) {
        String credentials = SecurityUtils.decode(token);
        return credentials.substring(credentials.indexOf(',')+1,credentials.indexOf(':'));
    }

    public Boolean validateUser(String token) {
        return fromString(decodeToCast(token)) != null;
    }

}
