package com.Projectgb.projectmongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.Projectgb.projectmongo.domain.Post;

public interface PostRepository extends MongoRepository<Post, String>  {
    
}
