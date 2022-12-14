package com.Projectgb.projectmongo.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.Projectgb.projectmongo.domain.Post;

public interface PostRepository extends MongoRepository<Post, String>  {

    List<Post> findByTitleContainingIgnoreCase(String title);
}
