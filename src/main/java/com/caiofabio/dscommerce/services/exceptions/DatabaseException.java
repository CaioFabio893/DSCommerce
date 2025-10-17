package com.caiofabio.dscommerce.services.exceptions;

public class DatabaseException extends RuntimeException {

    // exececao costumizada para o banco de dados
    public DatabaseException(String msg) {
        super(msg);
    }

}
