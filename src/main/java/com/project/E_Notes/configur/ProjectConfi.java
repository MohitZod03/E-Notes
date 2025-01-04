package com.project.E_Notes.configur;
// IT THIS CLASS WE USE THE MODEL MAPPER CLASS DEPENDENCY
// MAPPING WITH THE OBJECT.

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;

@Configuration
public class ProjectConfi {

    // THIS IS PURPOSE FOR DTO MAPPING .
    @Bean
    public ModelMapper mapper(){  // WE USE METHOD BECAUSE BEAN CREATED  THAT BELONG TO CLASS.
        return new ModelMapper();
    }


     // THIS IS PURPOSE OF AUDITING ENABLE OR TRACK HOW CREATED.
    @Bean
    public AuditorAware<Integer> auditorAware(){
        return new AudiAwareConfi();
    }
}
