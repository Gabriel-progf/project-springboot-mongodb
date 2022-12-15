package com.Projectgb.projectmongo.dto;

import java.io.Serializable;

import org.springframework.data.annotation.Id;

import com.Projectgb.projectmongo.domain.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private String name;
    private String email;

    public UserDto(User user) {
        id = user.getId();
        name = user.getName();
        email = user.getEmail();
    }
}
