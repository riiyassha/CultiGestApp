package com.AgriGest.AgriGestApp.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.CriteriaDefinition;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.AgriGest.AgriGestApp.Dao.Interfaces.PlantDao;
import com.AgriGest.AgriGestApp.Models.Plant;
import com.AgriGest.AgriGestApp.Models.PlantDto;
import com.AgriGest.AgriGestApp.Models.User;
import org.springframework.data.mongodb.core.query.Criteria;

@Repository
@Profile(value = "mongodb")
public class PlantDaoImp implements PlantDao{

    @Autowired
    private MongoOperations operations;

    @Override
    public List<Plant> getPlants(User user) {
        Query query = new Query();
        query.addCriteria((CriteriaDefinition) Criteria.where("User").is("user"));
        return operations.find(query, Plant.class, "plant");
    }

    @Override
    public void DeletePlant(String Id) {
        Query query = new Query();
        query.addCriteria((CriteriaDefinition) Criteria.where("Id").is("Id_plant"));
        operations.remove(query, Plant.class, "Plant");
    }

    @Override
    public ResponseEntity<String> postPlant(PlantDto plantDto) {
       Plant plant = new Plant();
       Query query = new Query();
       query.addCriteria(Criteria.where("email").is(plantDto.getEmail()));

       List<User> lista = operations.find(query, User.class);

       if(lista.isEmpty()){
            return ResponseEntity.badRequest().body("El Usuario no existe");
       }

       plant.setName(plantDto.getName());
       plant.setAreaCultivo(plantDto.getAreacultivo());
       plant.setPlague(plantDto.getPlague());
       plant.setLvlFertility(plantDto.getLvlFertility());
       plant.setPerformance(plantDto.getPerformance());

       plant.setUser(lista.get(0));
       operations.save(plant, "Plant");
       return ResponseEntity.ok("status 200");
    }
    
}
