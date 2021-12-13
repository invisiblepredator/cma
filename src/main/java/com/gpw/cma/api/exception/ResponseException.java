package com.gpw.cma.api.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Slf4j
public class ResponseException extends RuntimeException {

    private static final long serialVersionUID = -6618041963019988070L;

    private HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

    private String error = "ERROR";

    private String message = "Error occurred";

    public ResponseException(@NotNull HttpStatus status) {
        this.status = status;
    }

    public ResponseException(String error, String message) {
        this.error = error;
        this.message = message;
    }

    public ResponseException(String error, String message, Exception e) {
        log.error(message, e);
        this.error = error;
        this.message = message;
    }

    public int getCode() {
        return status.value();
    }
}
