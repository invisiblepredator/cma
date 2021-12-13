package com.gpw.cma.api.exception;

import org.springframework.http.HttpStatus;

public class EntityNotFoundException extends ResponseException {

    private static final String COULD_NOT_FIND_ENTITY_WITH_ID = "Could not find entity";
    private static final long serialVersionUID = 6029381148313047053L;

    public EntityNotFoundException() {
        this(COULD_NOT_FIND_ENTITY_WITH_ID);
    }

    public EntityNotFoundException(String message) {
        super(HttpStatus.NOT_FOUND, "NOT_FOUND", message);
    }
}
