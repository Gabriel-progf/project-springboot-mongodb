package com.Projectgb.projectmongo.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Projectgb.projectmongo.domain.Post;
import com.Projectgb.projectmongo.repositories.PostRepository;
import com.Projectgb.projectmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;


    public Post findByid(String id) {
        Optional<Post> user = repository.findById(id);
        return user.orElseThrow(() -> new ObjectNotFoundException("User not found."));
    }

    
    public List<Post> findByTitle(String text){
        return repository.searchTitle(text);

    }

    public List<Post> fullSearch(String text, Date min, Date max){
        max = new Date(max.getTime()+ 24 * 60 * 60 * 1000);
        return repository.fullSearch(text, min, max);
    }

}
