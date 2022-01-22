package com.example.demo.service;

import com.example.demo.models.User;
import com.example.demo.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
@Service
public class UserService implements IUserService {

    @Autowired
    UsersRepository usersRepository;

    @Transactional(readOnly = true)
    @Override
    public List<User> index() {
        return usersRepository.findAll();
    }
    @Transactional(readOnly = true)
    @Override
    public User show(long id) {
        return usersRepository.getById(id);
    }
    @Transactional
    @Override
    public void save(User user) {
        usersRepository.save(user);
    }
    @Transactional
    @Override
    public void update(long id, User user) {
        usersRepository.save(user);
    }
    @Transactional
    @Override
    public void delete(long id) {
        usersRepository.deleteById(id);
    }
}