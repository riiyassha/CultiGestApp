package com.AgriGest.AgriGestApp.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.AgriGest.AgriGestApp.Dao.Interfaces.UserDao;
import com.AgriGest.AgriGestApp.Models.LoginDto;
import com.AgriGest.AgriGestApp.Models.User;
import com.AgriGest.AgriGestApp.Utils.JWTUtil;

@RestController
public class AuthController {
    @Autowired
    private UserDao userDao;

    @Autowired
    private JWTUtil jwtUtil;

    @PostMapping(value = "api/Login")
    public String Login(@RequestBody LoginDto loginDto){
        User usrLogin = userDao.VerificarUser(loginDto);

        if(usrLogin != null){
            return jwtUtil.create(String.valueOf(usrLogin.getId()), usrLogin.getEmail());
        }else{
            return null;
        }
    }
}
