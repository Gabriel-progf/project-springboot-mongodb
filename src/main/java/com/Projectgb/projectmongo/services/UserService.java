package com.Projectgb.projectmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import com.Projectgb.projectmongo.domain.User;
import com.Projectgb.projectmongo.dto.UserDto;
import com.Projectgb.projectmongo.repositories.UserRepository;
import com.Projectgb.projectmongo.services.exception.DataBaseException;
import com.Projectgb.projectmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findByid(String id) {
        Optional<User> user = repository.findById(id);
        return user.orElseThrow(() -> new ObjectNotFoundException("User not found."));
    }

    public User save(User user) {
        boolean existUser = repository.findByEmail(user.getEmail()).stream().anyMatch(u -> !u.equals(user));
        if (existUser) {
            throw new DataBaseException("This user already exist.");
        }

        return repository.save(user);

    }

    public void delete(String id){
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e){
            throw new ObjectNotFoundException("Not found id: " + id);
        } catch (DataIntegrityViolationException e){
            throw new DataBaseException(e.getMessage());
        }
    }

    public User fromDto(UserDto userDto) {
        return new User(userDto.getId(), userDto.getName(), userDto.getEmail());
    }

}
