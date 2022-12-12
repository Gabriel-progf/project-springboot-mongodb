package com.Projectgb.projectmongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.Projectgb.projectmongo.domain.User;

public interface UserRepository extends MongoRepository<User,String>  {
    
}
