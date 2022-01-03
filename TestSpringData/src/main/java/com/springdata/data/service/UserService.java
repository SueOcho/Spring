package com.springdata.data.service;

import com.springdata.data.model.User;
import com.springdata.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UserService implements BaseService<User,Integer>{



    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> findById(Integer id) {

        return userRepository.findById(id);
    }

    @Override
    public Optional<List<User>> findAll() {
        return Optional.of(userRepository.findAll());
    }

    @Override
    public User saveOrUpdate(User user) {
        return userRepository.save(user);
    }

    @Override
    public boolean deleteById(Integer id) {

        return findById(id).map(user-> {userRepository.delete(user);
        return true;}).orElse( false) ;
    }
}
