package com.revature.exceptions;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(){
        super("ResourceNotFound");
    }
}
