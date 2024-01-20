package com.AgriGest.AgriGestApp.Models;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Document(value = "zones")
public class Zone {
    @MongoId
    private String id;
    @Field("name")
    private String name;
    @Field("soil")
    private String soil;
    @Field("seeds")
    private String[] seeds;
    
    public Zone() {
    }

    public Zone(String id, String name, String soil, String[] seeds) {
        this.id = id;
        this.name = name;
        this.soil = soil;
        this.seeds = seeds;
    }

    
}
