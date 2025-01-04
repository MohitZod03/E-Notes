package com.project.E_Notes.exceptionHandling;


/// this is class exception massage if name already of category exist

    public class ExistDataException extends RuntimeException {

        public ExistDataException(String message) {
            super(message);
        }

    }

