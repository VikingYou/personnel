package com.totoro.personnel.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by ycd20 on 2022/06/08
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
@Getter
public class ResourceNotFoundException extends RuntimeException {
    private String resourceName;
    private String filedName;
    private Object filedValue;

    public ResourceNotFoundException(String resourceName, String filedName, String filedValue) {
        super(String.format("%s not found with %s : '%s'", resourceName, filedName, filedValue));
        this.filedName = filedName;
        this.filedValue = filedValue;
        this.resourceName = resourceName;
    }

}
