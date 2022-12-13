package com.Projectgb.projectmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Projectgb.projectmongo.domain.User;
import com.Projectgb.projectmongo.repositories.UserRepository;
import com.Projectgb.projectmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }

    public User findByid(String id){
        Optional<User> user = repository.findById(id);
       return user.orElseThrow(() -> new ObjectNotFoundException("User not found."));
    }

}
