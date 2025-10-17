package com.caiofabio.dscommerce.dto;

import java.time.Instant;


// classe feita pra costumizar o erro quando retorna o json
public class CustomError {

    private Instant timestamp;
    private Integer status;
    private String error;
    private String path;


    public CustomError() {}

    public CustomError(String error, String path, Integer status, Instant timestamp) {
        this.error = error;
        this.path = path;
        this.status = status;
        this.timestamp = timestamp;
    }


    public String getError() {
        return error;
    }

    public String getPath() {
        return path;
    }

    public Integer getStatus() {
        return status;
    }

    public Instant getTimestamp() {
        return timestamp;
    }
}
