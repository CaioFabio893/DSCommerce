package com.caiofabio.dscommerce.services;

import com.caiofabio.dscommerce.entities.User;
import com.caiofabio.dscommerce.services.exceptions.ForBiddenException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserService userService;

    public void validateSelfOrAdmin(long userId){
        User me = userService.authenticated();
        if(!me.hasRole("ROLE_ADMIN") && !me.getId().equals(userId)){
            throw new ForBiddenException("Acess denied");
        }
    }

}
