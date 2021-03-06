package com.bruce.service.userService;

import com.bruce.entity.dto.User;
import com.bruce.repo.userRepo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl  implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public String init() {
        return "user service init";
    }

    @Override
    public List<User> list() {
        return userRepository.selectAll();

    }

    @Override
    @Cacheable(value="user",key="'user'.concat(#id)")
    public User getUserById(String id) {
        return userRepository.selectByPrimaryKey(id);
    }
}