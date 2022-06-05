package com.netcracker.service;

import com.netcracker.model.User;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class RegexService {

    private final String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
    private final String firstNameRegex = "^[A-Za-zА-Яа-я]{1,}$";
    private final String lastNameRegex = "^[A-Za-zА-Яа-я]{1,}$";

    public boolean checkingValidate(User user){
        return checkEmail(user) && checkAge(user) && checkFirstName(user) && checkLastName(user);
    }

    private boolean checkEmail(User user){
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(user.getEmail());
        return matcher.matches();
    }

    private boolean checkAge(User user){
        return user.getAge() > 0 && user.getAge() < 120;
    }

    private boolean checkFirstName(User user){
        Pattern pattern = Pattern.compile(firstNameRegex);
        Matcher matcher = pattern.matcher(user.getFirstName());
        return matcher.matches();
    }

    private boolean checkLastName(User user){
        Pattern pattern = Pattern.compile(lastNameRegex);
        Matcher matcher = pattern.matcher(user.getLastName());
        return matcher.matches();
    }
}
