package com.AgriGest.AgriGestApp.Controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.AgriGest.AgriGestApp.Dao.Interfaces.UserDao;
import com.AgriGest.AgriGestApp.Models.User;
import com.AgriGest.AgriGestApp.Utils.JWTUtil;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

@RestController
public class UserController {
    @Autowired
    private UserDao userDao;

    @Autowired
    private JWTUtil jwtUtil;

    @GetMapping(value = "api/User")
    public List<User> GetUsers (@RequestHeader(value = "Authorization") String token){
        return !validarToken(token) ? null : userDao.GetUser(); 
    }

    @PostMapping("api/User")
    public ResponseEntity<String> PostUser(@RequestBody User user){
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash = argon2.hash(1, 1024, 1, user.getPassword());
        user.setPassword(hash);
        return userDao.postUser(user);  
    }

    @DeleteMapping(value = "api/User/{Id}")
    public ResponseEntity<String> DeleteUserbyId( @RequestHeader("Authorization") String token, @PathVariable String Id){
        return !validarToken(token) ? null : userDao.deleteUserbyId(Id);
    }

    @DeleteMapping(value = "api/user/{name}/{email}")
    public ResponseEntity<String> deleteUserbyName(@RequestHeader("Authorization") String token, @PathVariable("name") String Name,@PathVariable("email") String Email){
        return !validarToken(token) ? null : userDao.deleteUserbyName(Name, Email);
    }

    private boolean validarToken(String token){
        String UserTkn = jwtUtil.getKey(token);
        return UserTkn != null;
    }

}

