package com.AgriGest.AgriGestApp.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.AgriGest.AgriGestApp.Dao.Interfaces.ZonesDao;
import com.AgriGest.AgriGestApp.Models.Zone;
import com.AgriGest.AgriGestApp.Utils.JWTUtil;

@RestController
public class ZoneController {
    @Autowired 
    private ZonesDao zonesDao;

    @Autowired
    private JWTUtil jwtUtil;

    @GetMapping(value = "api/Zone")
    public List<Zone> getZones(@RequestHeader("Authorization") String token){
        return !validarToken(token) ? null : zonesDao.getZones();
    }

    private boolean validarToken(String token){
        String UserTkn = jwtUtil.getKey(token);
        return UserTkn != null;
    }
}
