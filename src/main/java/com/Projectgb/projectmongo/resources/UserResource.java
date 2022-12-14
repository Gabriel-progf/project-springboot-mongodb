package com.Projectgb.projectmongo.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.Projectgb.projectmongo.domain.Post;
import com.Projectgb.projectmongo.domain.User;
import com.Projectgb.projectmongo.dto.UserDto;
import com.Projectgb.projectmongo.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<UserDto>> findAll() {
        List<User> list = service.findAll();
        List<UserDto> listDto = list.stream().map(x -> new UserDto(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> findById(@PathVariable String id) {
        User user = service.findByid(id);
        return ResponseEntity.ok().body(new UserDto(user));
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public User insert(@Valid @RequestBody UserDto userDto) {
        User user = service.fromDto(userDto);
        return service.save(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> update(@PathVariable String id, @Valid @RequestBody UserDto userDto) {
        User obj = service.fromDto(userDto);
        if (!service.existById(id)) {
            return ResponseEntity.notFound().build();
        }

        obj.setId(id);
        service.save(obj);

        return ResponseEntity.ok(userDto);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        if (!service.existById(id)) {
            return ResponseEntity.notFound().build();
        }

        service.delete(id);
        return ResponseEntity.noContent().build();

    }

    @GetMapping("/{id}/posts")
    public ResponseEntity<List<Post>> findPosts(@PathVariable String id) {
        User user = service.findByid(id);
        return ResponseEntity.ok().body(user.getPosts());
    }

}