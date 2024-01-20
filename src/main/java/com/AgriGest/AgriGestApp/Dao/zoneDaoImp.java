package com.AgriGest.AgriGestApp.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Repository;

import com.AgriGest.AgriGestApp.Dao.Interfaces.ZonesDao;
import com.AgriGest.AgriGestApp.Models.Zone;

@Repository
@Profile(value = "mongodb")
public class zoneDaoImp implements ZonesDao{
    
    @Autowired
    MongoOperations operations;

    @Override
    public List<Zone> getZones() {
        return operations.findAll(Zone.class, "Zones");
    }
    
}
