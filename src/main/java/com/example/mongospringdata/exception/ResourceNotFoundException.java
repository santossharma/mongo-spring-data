package com.example.mongospringdata.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Data
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    private String fieldName;
    private String fieldValue;
    private String resourceName;

    public ResourceNotFoundException(String fieldName, String fieldValue, String resourceName) {
        super(String.format("%s not found with %s : %s", resourceName, fieldName, fieldValue));

        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
        this.resourceName = resourceName;
    }
}
