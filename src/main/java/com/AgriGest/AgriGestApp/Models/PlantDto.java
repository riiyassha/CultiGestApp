package com.AgriGest.AgriGestApp.Models;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PlantDto {
    private String name;
    private String areacultivo;
    private String plague;
    private String lvlFertility;
    private String performance;
    private String email;
    
    public PlantDto() {
    }

    public PlantDto(String name, String areacultivo, String plague, String lvlFertility, String performance,
            String email) {
        this.name = name;
        this.areacultivo = areacultivo;
        this.plague = plague;
        this.lvlFertility = lvlFertility;
        this.performance = performance;
        this.email = email;
    }

    
}
