package com.AgriGest.AgriGestApp.Dao.Interfaces;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.AgriGest.AgriGestApp.Models.Crops;
import com.AgriGest.AgriGestApp.Models.CropsDto;
import com.AgriGest.AgriGestApp.Models.User;

public interface CropsDao {

    List<Crops> getCrops(User user);

    void deleteCrops(String Id);

    ResponseEntity<String> postCrops(CropsDto dto);
 
}
