package com.AgriGest.AgriGestApp.Models;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;   

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Document(collection = "Crops")
public class Crops {

    @MongoId
    private String Id;
    @Field("name")
    private String name;
    @Field("areacultivo")
    private String areacultivo;
    @Field("seedtime") 
    private String seedtime;
    @Field("usuario")
    private User usuario;
    
    public Crops() {
    }

    public Crops(String id, String name, String areacultivo, String seedtime, User usuario) {
        Id = id;
        this.name = name;
        this.areacultivo = areacultivo;
        this.seedtime = seedtime;
        this.usuario = usuario;
    }

}
