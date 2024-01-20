package com.AgriGest.AgriGestApp.Utils;

import com.AgriGest.AgriGestApp.Dao.Interfaces.CropsDao;
import com.AgriGest.AgriGestApp.Dao.Interfaces.PlantDao;
import com.AgriGest.AgriGestApp.Dao.Interfaces.UserDao;
import com.AgriGest.AgriGestApp.Dao.Interfaces.ZonesDao;
import com.AgriGest.AgriGestApp.Models.User;
import com.AgriGest.AgriGestApp.Dao.CropsDaoImp;
import com.AgriGest.AgriGestApp.Dao.PlantDaoImp;
import com.AgriGest.AgriGestApp.Dao.UserDaoImp;
import com.AgriGest.AgriGestApp.Dao.zoneDaoImp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {
    @Bean
    public UserDao userDao(){
        return new UserDaoImp();
    }

    @Bean
    public CropsDao cropsDao(){
        return new CropsDaoImp();
    }

    @Bean
    public User opUser(){
        return new User();
    }

    @Bean
    public PlantDao plantDao(){
        return new PlantDaoImp();
    }

    @Bean
    public ZonesDao zonesDao(){
        return new zoneDaoImp();
    }
}
