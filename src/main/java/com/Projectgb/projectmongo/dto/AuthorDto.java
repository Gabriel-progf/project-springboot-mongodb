package com.Projectgb.projectmongo.dto;

import java.io.Serializable;

import com.Projectgb.projectmongo.domain.User;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class AuthorDto implements Serializable {
    
    private String id;
    private String name;

    public AuthorDto(){

    }

    public AuthorDto(User user){
        id = user.getId();
        name = user.getName();
    }
    
}
