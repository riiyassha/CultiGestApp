package com.AgriGest.AgriGestApp.Dao;

import java.util.List;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Repository;
import com.AgriGest.AgriGestApp.Dao.Interfaces.CropsDao;
import com.AgriGest.AgriGestApp.Models.Crops;
import com.AgriGest.AgriGestApp.Models.CropsDto;
import com.AgriGest.AgriGestApp.Models.User;

@Repository
@Profile(value = "mongodb")
public class CropsDaoImp implements CropsDao{

    @Autowired
    private MongoOperations operations;


    @Override
    public List<Crops> getCrops(User user) {
        Query query = new Query();
        query.addCriteria(Criteria.where("user").is(user));
        return operations.find(query, Crops.class);
    }

    @Override
    public void deleteCrops(String Id) {
        Query query = new Query();
        query.addCriteria(Criteria.where(Id).is("Id_Crops"));
        operations.remove(query, Crops.class, "Crops");
    }

    /*
     * Este metodo se encarga de resgistrar un nuevo cultivo, asociandolo a un usuario buscado
     * el email en la coleccion de usuarios para asociarlo como un objeto dentro del documento
     * del cultivo en MongoDb.
     */
    @Override
    public ResponseEntity<String> postCrops(CropsDto dto) {
        Crops crops = new Crops();
        Query query = new Query();
        query.addCriteria(Criteria.where("Email").is(dto.getEmail()));

        List<User> usuario = operations.find(query, User.class);

        if(usuario.isEmpty()){
            return ResponseEntity.badRequest().body("usuario no encontrado");
        }

        crops.setName(dto.getName());
        crops.setAreacultivo(dto.getAreacultivo());
        crops.setSeedtime(dto.getSeedtime());
        crops.setUsuario(usuario.get(0));

        operations.save(crops, "Crops");
        return ResponseEntity.ok("status 200");
    }   
  
}
