package com.caiofabio.dscommerce.tests;

import com.caiofabio.dscommerce.projections.UserDetailsProjection;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.List;

public class UserDetailsFactory {

    public static List<UserDetailsProjection> createClientUser(String username){
        List<UserDetailsProjection> list= new ArrayList<>();
        list.add(new UserDetailsImpl(username,"123",1l,"ROLE_CLIENT"));
        return list;
    }

    public static List<UserDetailsProjection> createAdminUser(String username){
        List<UserDetailsProjection> list= new ArrayList<>();
        list.add(new UserDetailsImpl(username,"123",2l,"ROLE_ADMIN"));
        return list;
    }

    public static List<UserDetailsProjection> createAdminClientUser(String username){
        List<UserDetailsProjection> list= new ArrayList<>();
        list.add(new UserDetailsImpl(username,"123",1l,"ROLE_CLIENT"));
        list.add(new UserDetailsImpl(username,"123",2l,"ROLE_ADMIN"));
        return list;
    }


}
class UserDetailsImpl implements UserDetailsProjection {
    private String username;
    private String password;
    private Long roleId;
    private String authority;

    public UserDetailsImpl() {}

    public UserDetailsImpl(String username, String password, Long roleId, String authority) {
        this.username = username;
        this.password = password;
        this.roleId = roleId;
        this.authority = authority;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public Long getRoleId() {
        return roleId;
    }

    @Override
    public String getAuthority() {
        return authority;
    }
}