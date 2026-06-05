package com.caiofabio.dscommerce.tests;

import com.caiofabio.dscommerce.entities.Role;
import com.caiofabio.dscommerce.entities.User;

import java.time.LocalDate;

public class UserFactory {

    public static User createClientUser(){
        User user = new User(LocalDate.parse("2001-07-25"), "maria@gmail.com", 1L, "Maira","$2a$10$nm5B6AhzfcZW1h2nDRYwl.1gyfD6olTdCrKBudaWVW0NHXrHseqb6", "988888889");;
        user.addRole(new Role(1L, "ROLE_CLIENT"));
        return user;
    }

    public static User createAdminUser(){
        User user = new User(LocalDate.parse("1987-12-13"), "alex@gmail.com", 2L, "Alex","$2a$10$nm5B6AhzfcZW1h2nDRYwl.1gyfD6olTdCrKBudaWVW0NHXrHseqb6", "977777777");;
        user.addRole(new Role(2L, "ROLE_ADMIN"));
        return user;
    }

    public static User createCustomerClientUser(Long id, String username){
        User user = new User(LocalDate.parse("2001-07-25"), username, id, "Maira","$2a$10$nm5B6AhzfcZW1h2nDRYwl.1gyfD6olTdCrKBudaWVW0NHXrHseqb6", "988888889");;
        user.addRole(new Role(1L, "ROLE_CLIENT"));
        return user;
    }

    public static User createCustomerAdimnUser(Long id, String username){
        User user = new User(LocalDate.parse("1987-12-13"), username, id, "Alex","$2a$10$nm5B6AhzfcZW1h2nDRYwl.1gyfD6olTdCrKBudaWVW0NHXrHseqb6", "977777777");;
        user.addRole(new Role(2L, "ROLE_ADMIN"));
        return user;
    }


}
