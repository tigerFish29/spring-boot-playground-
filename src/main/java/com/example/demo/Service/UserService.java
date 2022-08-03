package com.example.demo.Service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.Repos.UserRepo;
import com.example.demo.domain.User;

@Service
public class UserService {

    private final UserRepo userRepository;

    // constructor 
    public UserService(final UserRepo userRepository) {
        this.userRepository = userRepository;
    }
    
    // get all 
    public List<User> findAll() {
        return userRepository.findAll();
    }

    // get one 
    public User get(final Long id) {
        return userRepository.findById(id).orElseThrow(  
           () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        
    }

    // create a user 
    public Long create(final User user) {
        return userRepository.save(user).getId();
    }

    // update a user 
    public void update(final Long id, final User user) {
        final User existingUser = userRepository.findById(id)
                  .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        userRepository.save(existingUser);
    }

    // delete a user 
    public void delete(final Long id) {
        userRepository.deleteById(id);
    }
    
}
