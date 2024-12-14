package com.project.E_Notes.exceptionHandling;

import lombok.extern.slf4j.Slf4j;

public class ResourcesNotFoundException extends Exception{

    // this is constructor method of class...
   public  ResourcesNotFoundException(String massage){
       super(massage);
   }


}
