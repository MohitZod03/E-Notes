package com.project.E_Notes.configur;
// IT THIS CLASS WE USE THE MODEL MAPPER CLASS DEPENDENCY
// MAPPING WITH THE OBJECT.

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfi {
    @Bean
    public ModelMapper mapper(){
        return new ModelMapper();
    }

}
