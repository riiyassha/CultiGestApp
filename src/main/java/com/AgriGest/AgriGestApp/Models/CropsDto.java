package com.AgriGest.AgriGestApp.Models;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CropsDto {
    private String name;
    private String areacultivo;
    private String seedtime;

    private String email;
    
    public CropsDto() {
    }

    public CropsDto(String name, String areacultivo, String seedtime, String email) {
        this.name = name;
        this.areacultivo = areacultivo;
        this.seedtime = seedtime;
        this.email = email;
    }
    
}
