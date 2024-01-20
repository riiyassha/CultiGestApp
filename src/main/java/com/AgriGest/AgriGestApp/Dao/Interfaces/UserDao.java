package com.AgriGest.AgriGestApp.Dao.Interfaces;

import java.util.List;
import org.springframework.http.ResponseEntity;

import com.AgriGest.AgriGestApp.Models.LoginDto;
import com.AgriGest.AgriGestApp.Models.User;

public interface UserDao{
    List<User> GetUser();

    ResponseEntity<String> deleteUserbyId(String Id);
    ResponseEntity<String> deleteUserbyName(String Name, String Email);

    void UpdateUser();

    ResponseEntity<String> postUser(User user);

    User VerificarUser(LoginDto loginDto);

}
