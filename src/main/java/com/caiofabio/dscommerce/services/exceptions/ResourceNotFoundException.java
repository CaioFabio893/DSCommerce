package com.caiofabio.dscommerce.services.exceptions;

public class ResourceNotFoundException extends RuntimeException {

    // exececao costumizada caso nao encontre nenhum recurso
    public ResourceNotFoundException(String msg) {
        super(msg);
    }

}
