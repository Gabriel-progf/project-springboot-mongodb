package com.Projectgb.projectmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.Projectgb.projectmongo.domain.Post;
import com.Projectgb.projectmongo.domain.User;
import com.Projectgb.projectmongo.dto.AuthorDto;
import com.Projectgb.projectmongo.repositories.PostRepository;
import com.Projectgb.projectmongo.repositories.UserRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Configuration
public class Instantiation implements CommandLineRunner {

    
    private UserRepository userRepository;

    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");
        
        userRepository.saveAll(Arrays.asList(maria, alex, bob));
        
        Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar par São Paulo. Abraços!",
                new AuthorDto(maria));
        Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", new AuthorDto(maria));

        userRepository.saveAll(Arrays.asList(maria, alex, bob));
        postRepository.saveAll(Arrays.asList(post1, post2));

        maria.getPosts().addAll(Arrays.asList(post1, post2));
        userRepository.save(maria);
    }

}
