package com.AgriGest.AgriGestApp.Models;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter 
@Document(collection = "Plant")
public class Plant {
    
    @MongoId
    private String Id_plant;
    @Field("Name")
    private String Name;
    @Field("AreaCultivo")
    private String AreaCultivo;
    @Field("Plague")
    private String Plague;
    @Field("lvlFertility")
    private String lvlFertility;
    @Field("Performance")
    private String Performance;
    @Field("user")
    private User user;

    public Plant() {

    }

    public Plant(String id_plant, String name, String areaCultivo, String plague, String lvlFertility,
            String performance, User user) {
                
        Id_plant = id_plant;
        Name = name;
        AreaCultivo = areaCultivo;
        Plague = plague;
        this.lvlFertility = lvlFertility;
        Performance = performance;
        this.user = user;
    }

    
    
}
