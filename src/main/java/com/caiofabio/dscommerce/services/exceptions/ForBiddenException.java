package com.caiofabio.dscommerce.services.exceptions;

public class ForBiddenException extends RuntimeException {

    // exececao costumizada para o banco de dados
    public ForBiddenException(String msg) {
        super(msg);
    }

}
