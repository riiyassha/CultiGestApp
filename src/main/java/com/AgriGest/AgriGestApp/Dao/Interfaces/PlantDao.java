package com.AgriGest.AgriGestApp.Dao.Interfaces;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.AgriGest.AgriGestApp.Models.Plant;
import com.AgriGest.AgriGestApp.Models.PlantDto;
import com.AgriGest.AgriGestApp.Models.User;

public interface PlantDao {

    List<Plant> getPlants(User user);

    void DeletePlant(String Id);

    ResponseEntity<String> postPlant(PlantDto plantDto);

}
