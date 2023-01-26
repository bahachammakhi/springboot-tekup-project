package com.tekupminiproject.TekupMiniProject.dto;

import com.tekupminiproject.TekupMiniProject.entities.Role;
import lombok.Data;

import java.util.List;

@Data
public class UserDto {

    private String firstName;

    private String lastName;

    private String email;
    private String password;
    private List<Role> roles;

}
